package b.o.a.n;

import android.hardware.Camera;
import android.hardware.Camera$AutoFocusCallback;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a$b implements Camera$AutoFocusCallback {
    public final /* synthetic */ b$a a;

    public b$a$b(b$a b_a) {
        this.a = b_a;
    }

    @Override // android.hardware.Camera$AutoFocusCallback
    public void onAutoFocus(boolean z2, Camera camera) {
        this.a.m.n.e("focus end", 0);
        this.a.m.n.e("focus reset", 0);
        b$a b_a = this.a;
        ((CameraView$b) b_a.m.m).d(b_a.k, z2, b_a.l);
        if (this.a.m.a1()) {
            b bVar = this.a.m;
            b.o.a.n.v.f fVar = bVar.n;
            fVar.c("focus reset", true, bVar.W, new b.o.a.n.v.i(fVar, b.o.a.n.v.e.ENGINE, new b$a$b$a(this)));
        }
    }
}
