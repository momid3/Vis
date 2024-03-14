package com.momid.vis

fun startAnimation(durationMillis: Long, onEach: (millisPassed: Long) -> Unit) {
    val startTime = System.currentTimeMillis()
    Thread {
        while (true) {
            onEach(System.currentTimeMillis() - startTime)
            if (System.currentTimeMillis() - startTime > durationMillis) {
                break
            }
        }
    }.start()
}
