data class MoodOption(
    val emoji: String,
    val label: String,
    val color: Color = Color.Gray,
    val note: String = "Nothing new",
    val timestamp: Long = System.currentTimeMillis()
)  // create a data class to store emotion values

val moodOptions = listOf{
    MoodOption(emoji = "😊", label = "Happy", color = Color.Green, "This is fucking amazing"),
    MoodOption("😢", "Sad", Color.Blue, "I'm sad"),
    MoodOption("😡", "Angry", Color.Red, "This is bullshit, I want to see the manager"),
    MoodOption("😴", "Tired", Color.Yellow, "I just want some rest, don't bother me"),
    MoodOption("😐", "Neutral", Color.White, "Okay")
}
