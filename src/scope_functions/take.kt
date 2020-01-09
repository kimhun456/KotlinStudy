package scope_functions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {

    val strings = mutableListOf("1", "2", "3")

    strings.takeIf { it.contains("1") }?.let {
        println("strings contains 1")
        it.forEach(::println)
        it
    }

    strings.takeUnless { it.contains("4") }?.let {
        println("strings not contains 4")
        it.forEach(::println)
        it
    }
}


/**
 *  @method takeIf
 *
 *   take If [predicate] is satisfied or 'null'
 *
 *  주어진 predicate가 만족되면 this 를 return 아니면  null을 리턴한다.
 *  @return T? -> Nullable 이라는 것에 주목해야함.
 *  보통 ?.let과 함께 쓰이게 된다.
 *
 * Official docs
 *
 * Returns `this` value if it satisfies the given [predicate] or `null`, if it doesn't.
 */
@ExperimentalContracts
@SinceKotlin("1.1")
inline fun <T> T.takeIfFromStandardKT(predicate: (T) -> Boolean): T? {
    contract {
        callsInPlace(predicate, InvocationKind.EXACTLY_ONCE)
    }
    return if (predicate(this)) this else null
}


/**
 *
 * 주어진 predicate 가 만족하지 않는다면 this 를 리턴하고 그렇지 않으면 'null'
 *
 * take unless [predicate] is not satisfied or 'null'
 *
 *
 * Returns `this` value if it _does not_ satisfy the given [predicate] or `null`, if it does.
 */
@ExperimentalContracts
@SinceKotlin("1.1")
inline fun <T> T.takeUnlessFromStandardKT(predicate: (T) -> Boolean): T? {
    contract {
        callsInPlace(predicate, InvocationKind.EXACTLY_ONCE)
    }
    return if (!predicate(this)) this else null
}
