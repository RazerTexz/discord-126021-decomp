package org.webrtc;

import android.hardware.Camera;
import android.hardware.Camera$PreviewCallback;
import android.os.SystemClock;
import h0.c.b;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class Camera1Session$2 implements Camera$PreviewCallback {
    public final /* synthetic */ Camera1Session this$0;

    public Camera1Session$2(Camera1Session camera1Session) {
        this.this$0 = camera1Session;
    }

    @Override // android.hardware.Camera$PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera1Session.access$200(this.this$0);
        if (camera != Camera1Session.access$300(this.this$0)) {
            Logging.e("Camera1Session", "Callback from a different camera. This should never happen.");
            return;
        }
        if (Camera1Session.access$400(this.this$0) != Camera1Session$SessionState.RUNNING) {
            Logging.d("Camera1Session", "Bytebuffer frame captured but camera is no longer running.");
            return;
        }
        long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
        if (!Camera1Session.access$500(this.this$0)) {
            Camera1Session.access$700().addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera1Session.access$600(this.this$0)));
            Camera1Session.access$502(this.this$0, true);
        }
        VideoFrame videoFrame = new VideoFrame(new NV21Buffer(bArr, Camera1Session.access$800(this.this$0).width, Camera1Session.access$800(this.this$0).height, new b(this, bArr)), Camera1Session.access$900(this.this$0), nanos);
        Camera1Session.access$100(this.this$0).onFrameCaptured(this.this$0, videoFrame);
        videoFrame.release();
    }
}
