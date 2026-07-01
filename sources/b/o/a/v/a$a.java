package b.o.a.v;

import android.hardware.Camera$ShutterCallback;

/* JADX INFO: compiled from: Full1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements Camera$ShutterCallback {
    public final /* synthetic */ a a;

    public a$a(a aVar) {
        this.a = aVar;
    }

    @Override // android.hardware.Camera$ShutterCallback
    public void onShutter() {
        c.m.a(1, "take(): got onShutter callback.");
        this.a.a(true);
    }
}
