# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Tools\adt-bundle-windows-x86_64-20140702\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#Pour la librairie Jackson (parsing JSON)
-keep class org.codehaus.jackson.** { *; }
-dontwarn org.**
-keep class com.squareup.picasso.** { *; }
-dontwarn com.squareup.picasso.**
-dontwarn javax.annotation.Nullable
#-injars jackson-mapper-asl-1.9.13.jar(!META-INF/ASL2.0)
#-injars jackson-mapper-asl-1.9.13.jar(!META-INF/LICENSE)
#-injars jackson-mapper-asl-1.9.13.jar(!META-INF/NOTICE)