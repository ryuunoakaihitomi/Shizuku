package moe.shizuku.manager.starter

import moe.shizuku.manager.application
import moe.shizuku.manager.ktx.logi
import java.io.File

object Starter {

    private val starterFile = File(application.applicationInfo.nativeLibraryDir, "libshizuku.so")

    val userCommand: String = starterFile.absolutePath

    val adbCommand = "adb shell $userCommand"

    val internalCommand = "$userCommand --apk=${application.applicationInfo.sourceDir}"

    /**
     * DO NOT REMOVE
     *
     * it's used to obtain the .so library path in the ADB Shell without parsing the output of `pm`
     * or requiring the user to manually copy or send the command.
     *
     * After opening the manager app,
     * immediately execute `adb shell "$(logcat -v tag -d | grep ShizukuStarter_SoPath -m 1 | cut -d : -f 2)"` to start the service.
     */
    fun logUserCommand() = logi("ShizukuStarter_SoPath", userCommand)
}
