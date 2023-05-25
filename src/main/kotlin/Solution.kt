import kotlin.collections.ArrayList
import kotlin.system.exitProcess

/**
 * Add an argument parser to call this function from a compiled jar file
 */
fun main(args: Array<String>) {
    val intervals = ArrayList<Interval>()

    for (arg in args) {
        val values = arg.removeSurrounding("[", "]").split(",")

        try {
            intervals.add(Interval(values.first().toInt(), values.last().toInt()))
        } catch (e: NumberFormatException) {
            System.err.println("Failed to parse arguments. Enter interval values in this format: [25,30] [2,19] ...")
            exitProcess(-1)
        }
    }

    printIntervals(intervals)
    printIntervals(merge(intervals))
}


/**
 * Merges all overlapping intervals and returns non overlapping intervals
 */
fun merge(intervals: List<Interval>): List<Interval> {
    // Nothing to merge
    if (intervals.size <= 1) return intervals

    val merged = ArrayList<Interval>()

    // Smallest start of an interval is at the beginning
    val sorted = sort(intervals)

    // Initialize the values based on the first interval
    var lowestStart = sorted[0].start
    var highestEnd = sorted[0].end

    for ((index, interval) in sorted.withIndex()) {
        if (index == 0) continue

        // The interval is already overlapped by another if it is smaller than the highest ending boundary
        if (interval.end <= highestEnd) continue

        // Previous interval closed and new one started
        if (interval.start >= highestEnd) {
            merged.add(Interval(lowestStart, highestEnd))
            lowestStart = interval.start
            highestEnd = interval.end
        }

        // Check if the interval's end is higher than the current one
        if (interval.start < highestEnd && interval.end > highestEnd) {
            highestEnd = interval.end
        }

        // The Last interval has the highest end inside the list therefore the last interval is added
        if (index >= sorted.size - 1) {
            merged.add(Interval(lowestStart, highestEnd))
            return merged
        }
    }

    // This case occurs only if the last interval is overlapped and has the same end as the second last
    merged.add(Interval(lowestStart, highestEnd))

    return merged
}

data class Interval(val start: Int, val end: Int) {
    override fun toString(): String {
        return "[$start,$end]";
    }
}

/**
 * Sort the list of intervals based on the starting point
 */
fun sort(intervals: List<Interval>): List<Interval> = intervals.sortedBy { it.start }

/**
 * Print out a list of intervals separated by a whitespace
 */
fun printIntervals(intervals: List<Interval>) = println(intervals.joinToString(" "))