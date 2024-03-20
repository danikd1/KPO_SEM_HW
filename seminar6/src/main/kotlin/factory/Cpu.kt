import factory.IComponent


data class Cpu(
    override val stockNumber: Int,
    override val name: String,
    override val price: Double,
    val socketType: String,
    val coreAmount: Int,
    val clockSpeed: Double
) : IComponent {
    override fun toString(): String {
        return "Stock number: $stockNumber, Name: $name, Price: $price, Socket type: $socketType, numbers of cores: $coreAmount, Clock speed: $clockSpeed"
    }
}