package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenCapturerAndroid$2 implements Runnable {
    public final /* synthetic */ ScreenCapturerAndroid this$0;

    public ScreenCapturerAndroid$2(ScreenCapturerAndroid screenCapturerAndroid) {
        this.this$0 = screenCapturerAndroid;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScreenCapturerAndroid.access$200(this.this$0).release();
        this.this$0.createVirtualDisplay();
    }
}
