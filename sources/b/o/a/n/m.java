package b.o.a.n;

import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements b.i.a.f.n.e<Void> {
    public final /* synthetic */ i a;

    public m(i iVar) {
        this.a = iVar;
    }

    @Override // b.i.a.f.n.e
    public void onSuccess(Void r6) {
        CameraView$b cameraView$b = (CameraView$b) this.a.m;
        cameraView$b.f3177b.a(1, "dispatchOnCameraClosed");
        cameraView$b.c.u.post(new b.o.a.g(cameraView$b));
    }
}
