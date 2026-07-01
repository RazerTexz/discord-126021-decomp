package b.o.a.v;

import android.hardware.Camera;
import android.hardware.Camera$Parameters;
import androidx.annotation.NonNull;
import b.o.a.l$a;

/* JADX INFO: compiled from: Full1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends c {
    public final Camera n;
    public final b.o.a.n.b o;

    public a(@NonNull l$a l_a, @NonNull b.o.a.n.b bVar, @NonNull Camera camera) {
        super(l_a, bVar);
        this.o = bVar;
        this.n = camera;
        Camera$Parameters parameters = camera.getParameters();
        parameters.setRotation(this.j.c);
        camera.setParameters(parameters);
    }

    @Override // b.o.a.v.d
    public void b() {
        c.m.a(1, "dispatching result. Thread:", Thread.currentThread());
        super.b();
    }

    @Override // b.o.a.v.d
    public void c() {
        b.o.a.b bVar = c.m;
        bVar.a(1, "take() called.");
        this.n.setPreviewCallbackWithBuffer(null);
        this.o.l1().d();
        try {
            this.n.takePicture(new a$a(this), null, null, new a$b(this));
            bVar.a(1, "take() returned.");
        } catch (Exception e) {
            this.l = e;
            b();
        }
    }
}
