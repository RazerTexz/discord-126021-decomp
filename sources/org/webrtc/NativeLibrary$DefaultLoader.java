package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class NativeLibrary$DefaultLoader implements NativeLibraryLoader {
    @Override // org.webrtc.NativeLibraryLoader
    public boolean load(String str) {
        Logging.d(NativeLibrary.access$000(), "Loading library: " + str);
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            Logging.e(NativeLibrary.access$000(), "Failed to load native library: " + str, e);
            return false;
        }
    }
}
