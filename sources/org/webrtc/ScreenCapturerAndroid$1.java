package org.webrtc;

import android.media.projection.MediaProjection;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenCapturerAndroid$1 implements Runnable {
    public final /* synthetic */ ScreenCapturerAndroid this$0;

    public ScreenCapturerAndroid$1(ScreenCapturerAndroid screenCapturerAndroid) {
        this.this$0 = screenCapturerAndroid;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScreenCapturerAndroid.access$000(this.this$0).stopListening();
        ScreenCapturerAndroid.access$100(this.this$0).onCapturerStopped();
        if (ScreenCapturerAndroid.access$200(this.this$0) != null) {
            ScreenCapturerAndroid.access$200(this.this$0).release();
            ScreenCapturerAndroid.access$202(this.this$0, null);
        }
        ScreenCapturerAndroid screenCapturerAndroid = this.this$0;
        MediaProjection mediaProjection = screenCapturerAndroid.mediaProjection;
        if (mediaProjection != null) {
            mediaProjection.unregisterCallback(ScreenCapturerAndroid.access$300(screenCapturerAndroid));
            this.this$0.mediaProjection.stop();
            this.this$0.mediaProjection = null;
        }
    }
}
