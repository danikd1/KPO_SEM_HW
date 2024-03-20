package Builder

import kotlinx.serialization.*
import kotlinx.serialization.json.*

sealed class StudentWork {
    abstract val title: String
    abstract val assignment: String
    abstract val abstract: String
    abstract val contents: List<String>
    abstract val reportText: String
    abstract val sourcesList: List<String>
    abstract val appendices: List<String>
}

data class CourseWork(
    val type: String,
    override val title: String,
    override val assignment: String,
    override val abstract: String,
    override val contents: List<String>,
    override val reportText: String,
    override val sourcesList: List<String>,
    override val appendices: List<String>,
) : StudentWork()

data class DiplomaWork(
    val type: String,
    override val title: String,
    override val assignment: String,
    override val abstract: String,
    override val contents: List<String>,
    override val reportText: String,
    override val sourcesList: List<String>,
    override val appendices: List<String>,
) : StudentWork()


fun inputCourseWork(): CourseWork {
    return CourseWork(
        type = "Курсовая работа",
        title = "Исследование методов машинного обучения",
        assignment = "Изучить и применить методы машинного обучения для анализа данных",
        abstract = "Работа посвящена изучению и применению методов машинного обучения...",
        contents = listOf("Введение", "Обзор литературы", "Методология", "Результаты", "Заключение"),
        reportText = "Текст отчета по главам...",
        sourcesList = listOf("Источник 1", "Источник 2"),
        appendices = listOf("Приложение А", "Приложение Б")
    )
}

fun inputDiplomaWork(): DiplomaWork {
    return DiplomaWork(
        type = "Дипломная работа",
        title = "Разработка системы управления проектами для IT-компаний",
        assignment = "Спроектировать и разработать систему управления проектами...",
        abstract = "Данная дипломная работа посвящена разработке системы...",
        contents = listOf("Введение", "Анализ предметной области", "Требования к системе",),
        reportText = "Полный текст дипломной работы...",
        sourcesList = listOf("Источник 1", "Источник 2", "Источник 3"),
        appendices = listOf("Приложение 1", "Приложение 2"),
    )
}

@Serializable
data class JsonReport(
    val type: String,
    val title: String,
    val assignment: String,
    val abstract: String,
    val contents: List<String>,
    val reportText: String,
    val sourcesList: List<String>,
    val appendices: List<String>
)

fun generateJsonCourseReport(work: CourseWork): String {
    val report = JsonReport(
        type = work.type,
        title = work.title,
        assignment = work.assignment,
        abstract = work.abstract,
        contents = work.contents,
        reportText = work.reportText,
        sourcesList = work.sourcesList,
        appendices = work.appendices
    )
    return Json.encodeToString(report)
}

fun generateJsonDiplomaReport(work: DiplomaWork): String {
    val report = JsonReport(
        type = work.type,
        title = work.title,
        assignment = work.assignment,
        abstract = work.abstract,
        contents = work.contents,
        reportText = work.reportText,
        sourcesList = work.sourcesList,
        appendices = work.appendices
    )
    return Json.encodeToString(report)
}

fun main() {
    // Ввод данных курсовой работы
    val courseWork = inputCourseWork()
    val courseWorkReport = generateJsonCourseReport(courseWork)
    println("Отчет курсовой работы в JSON:\n$courseWorkReport")

    // Ввод данных дипломной работы
    val diplomaWork = inputDiplomaWork()
    val diplomaWorkReport = generateJsonDiplomaReport(diplomaWork)
    println("Отчет дипломной работы в JSON:\n$diplomaWorkReport")
}

