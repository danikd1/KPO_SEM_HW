fun main() {
    val inventory = Inventory()

    // Добавление комплектующих
    inventory.addComponent(Motherboard(1, "Super MB", 250.0, "AM4", 1, "DDR4"))
    inventory.addComponent(Cpu(2, "Fast CPU", 300.0, "AM4", 8, 3.6))
    inventory.addComponent(HardDisk(3, "Big Disk", 100.0, 2000, 7200))

    // Вывод полной номенклатуры
    println("All components:")
    inventory.printAllComponents()

    // Поиск по номенклатурному номеру
    println("\nDetails for stock number 2:")
    inventory.findComponentByStockNumber(2)
}
