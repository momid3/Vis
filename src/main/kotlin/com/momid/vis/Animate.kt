package com.momid.vis

fun startAnimation(durationMillis: Long, frameRate: Int = 30, onEach: (millisPassed: Long) -> Unit) {
    val startTime = System.currentTimeMillis()
    var lastTime = startTime
    val frameTime = 1000 / frameRate
    Thread {
        while (true) {
            val elapsed = System.currentTimeMillis() - lastTime
            lastTime = System.currentTimeMillis()

            onEach(System.currentTimeMillis() - startTime)

            if (System.currentTimeMillis() - startTime > durationMillis) {
                break
            }

            Thread.sleep(maxOf(0, frameTime - elapsed))
        }
    }.start()
}
