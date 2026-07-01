package h0.c;

import org.webrtc.Camera1Session;
import org.webrtc.Camera1Session$2;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Camera1Session$2 j;
    public final /* synthetic */ byte[] k;

    public /* synthetic */ b(Camera1Session$2 camera1Session$2, byte[] bArr) {
        this.j = camera1Session$2;
        this.k = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Camera1Session$2 camera1Session$2 = this.j;
        Camera1Session.access$1000(camera1Session$2.this$0).post(new a(camera1Session$2, this.k));
    }
}
