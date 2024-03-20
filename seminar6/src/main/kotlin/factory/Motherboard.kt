import factory.IComponent

data class Motherboard(
    override val stockNumber: Int,
    override val name: String,
    override val price: Double,
    val socketType: String,
    val cpuAmount: Int,
    val ramType: String
) : IComponent {
    override fun toString(): String {
        return "Stock number: $stockNumber, Name: $name, Price: $price, Socket type: $socketType, number of cpu: $cpuAmount, ram type: $ramType"
    }
}