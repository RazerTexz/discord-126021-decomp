package h0.c;

import org.webrtc.Camera1Session;
import org.webrtc.Camera1Session$2;
import org.webrtc.Camera1Session$SessionState;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Camera1Session$2 j;
    public final /* synthetic */ byte[] k;

    public /* synthetic */ a(Camera1Session$2 camera1Session$2, byte[] bArr) {
        this.j = camera1Session$2;
        this.k = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Camera1Session$2 camera1Session$2 = this.j;
        byte[] bArr = this.k;
        if (Camera1Session.access$400(camera1Session$2.this$0) == Camera1Session$SessionState.RUNNING) {
            Camera1Session.access$300(camera1Session$2.this$0).addCallbackBuffer(bArr);
        }
    }
}
