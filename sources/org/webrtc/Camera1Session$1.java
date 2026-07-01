package org.webrtc;

import android.hardware.Camera;
import android.hardware.Camera$ErrorCallback;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class Camera1Session$1 implements Camera$ErrorCallback {
    public final /* synthetic */ Camera1Session this$0;

    public Camera1Session$1(Camera1Session camera1Session) {
        this.this$0 = camera1Session;
    }

    @Override // android.hardware.Camera$ErrorCallback
    public void onError(int i, Camera camera) {
        String strQ = i == 100 ? "Camera server died!" : a.q("Camera error: ", i);
        Logging.e("Camera1Session", strQ);
        Camera1Session.access$000(this.this$0);
        if (i == 2) {
            Camera1Session.access$100(this.this$0).onCameraDisconnected(this.this$0);
        } else {
            Camera1Session.access$100(this.this$0).onCameraError(this.this$0, strQ);
        }
    }
}
