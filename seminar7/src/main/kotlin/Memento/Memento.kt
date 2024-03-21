package Memento

class TextEditor {
    private var currentText: String = ""
    private val history = mutableListOf<String>()

    fun addText(text: String) {
        history.add(currentText)
        currentText += text
        currentText += " "
    }

    fun editText(newText: String) {
        history.add(currentText)
        currentText = newText
    }

    fun watchText() {
        println("Current text: $currentText")
    }

    fun cancelChanges() {
        if (history.isNotEmpty()) {
            currentText = history.removeAt(history.lastIndex)
        } else {
            println("No changes to cancel.")
        }
    }
}

fun main() {
    val editor = TextEditor()

    while (true) {
        println("Enter command (add/edit/watch/cancel changes/exit):")
        val command = readLine()

        when (command) {
            "add" -> {
                println("Enter text to add:")
                val text = readLine() ?: ""
                editor.addText(text)
            }
            "edit" -> {
                println("Enter new text:")
                val newText = readLine() ?: ""
                editor.editText(newText)
            }
            "watch" -> editor.watchText()
            "cancel changes" -> editor.cancelChanges()
            "exit" -> return
            else -> println("Unknown command. Please try again.")
        }
    }
}
