package com.google.firebase.crashlytics.ndk;

/* JADX INFO: loaded from: classes3.dex */
public class CrashpadMain {
    public static native void crashpadMain(String[] strArr);

    public static void main(String[] strArr) {
        try {
            System.loadLibrary("crashlytics-handler");
            crashpadMain(strArr);
        } catch (UnsatisfiedLinkError e) {
            throw new RuntimeException(e);
        }
    }
}
