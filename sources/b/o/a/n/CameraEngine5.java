package b.o.a.n;

import b.o.a.CameraView3;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.n.m, reason: use source file name */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraEngine5 implements b.i.a.f.n.e<Void> {
    public final /* synthetic */ CameraEngine a;

    public CameraEngine5(CameraEngine cameraEngine) {
        this.a = cameraEngine;
    }

    @Override // b.i.a.f.n.e
    public void onSuccess(Void r6) {
        CameraView.b bVar = (CameraView.b) this.a.m;
        bVar.f3177b.a(1, "dispatchOnCameraClosed");
        CameraView.this.u.post(new CameraView3(bVar));
    }
}
