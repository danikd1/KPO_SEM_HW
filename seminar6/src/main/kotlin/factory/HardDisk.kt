import factory.IComponent

data class HardDisk(
    override val stockNumber: Int,
    override val name: String,
    override val price: Double,
    val capacity: Int,
    val rotationSpeed: Int
) : IComponent {
    override fun toString(): String {
        return "Stock number: $stockNumber, Name: $name, Price: $price, Capacity: $capacity, Rotation speed: $rotationSpeed"
    }
}
