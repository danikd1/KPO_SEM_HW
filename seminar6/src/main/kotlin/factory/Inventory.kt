import factory.IComponent

class Inventory {
    private val components: MutableList<IComponent> = mutableListOf()

    fun addComponent(component: IComponent) {
        components.add(component)
    }

    fun printAllComponents() {
        components.forEach {
            println("Stock number: ${it.stockNumber}, Name: ${it.name}, Price: ${it.price}")
        }
    }

    fun findComponentByStockNumber(stockNumber: Int) {
        val component = components.find { it.stockNumber === stockNumber }
        if (component != null) {
            // Вывод полной информации о компоненте
            println(component)
        } else {
            println("Component with stock number $stockNumber not found.")
        }
    }
}
