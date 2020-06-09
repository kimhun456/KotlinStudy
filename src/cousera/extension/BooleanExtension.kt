package cousera.extension

infix fun Boolean.eq(b: Boolean) {
    if (this == b) {
        println("TRUE")
    } else {
        println("False")
    }
}
