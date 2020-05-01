enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL;

}

fun <E> List<E>.relationshipTo(other: List<E>): Relationship =
        when {
            this == other -> Relationship.EQUAL
            this.isSublistOf(other) -> Relationship.SUBLIST
            other.isSublistOf(this) -> Relationship.SUPERLIST
            else -> Relationship.UNEQUAL
        }

private fun <E> List<E>.isSublistOf(other: List<E>): Boolean =
        this.isEmpty() || this in other.windowed(this.size)
