# UIAutomator
Customize your UIAutomator with this demo!

# How to build your UIAutomator

1. clone this repo
2. prepare the Android SDK in your computer
3. open this repo with IDEA
4. click the `project structure` setting, and set the Android SDK
5. set compiler output path for building artifacts of UIAutomator
6. inside `AccessibilityNodeInfoDumper.java`, change the `dumpNodeRec` method to expose the attributes you need
7. build the artifact, namely `uiautomator.jar`

# How to run your UIAutomator in your own device?

The first thing we need to know is that inside Android, we need to convert jar files into the dex format, since Dalvik virtual machine is used. We could use `dx.bat` to convert this `uiautomator.jar` into `uiautomator.dex`. A `dx.bat` of certain version of Android should be located in the `build-tools` folder of Android SDK. You could run this command in your shell.

```
/Path_To/Android/Sdk/build-tools/30.0.2/dx.bat --dex --output="/Path_To/uiautomator.dex" "/Path_To/uiautomator/out/artifacts/uiautomator_jar/uiautomator.jar"
```

Then you need to push this dex file inside your target device. Like this:

```
adb push /Path_To/uiautomator.dex /data/local/tmp
```

Then you could run this modified uiautomator with:

```
adb shell CLASSPATH=/data/local/tmp/uiautomator.dex app_process /system/bin com.android.commands.uiautomator.Launcher dump
```

Then you could find the corresponding UI hierarchy file in your target device.