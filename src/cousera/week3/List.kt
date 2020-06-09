package cousera.week3

fun main() {
    val list = listOf(
        Hero("The captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.FEMALE),
        Hero("The Kid", 9, null),
        Hero("Lady lauren", 29, Gender.FEMALE),
        Hero("Super Man", 27, Gender.MALE),
        Hero("Sir Stephan", 37, Gender.MALE)
    )

    println(list.map { it.age }.distinct().size)

    // Destruction with partition
    val (youngest, oldest) = list.partition { it.age < 30 }
    println(youngest)
    println(oldest)

    println(list.maxBy { it.age }?.name)

    val mapByAge = list.associateBy { it.age }
    println(mapByAge)
}

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)

enum class Gender { MALE, FEMALE }