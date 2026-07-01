package b.o.a.v;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import b.o.a.l$a;

/* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends i {
    public b.o.a.n.b n;
    public Camera o;
    public b.o.a.x.a p;
    public int q;

    public e(@NonNull l$a l_a, @NonNull b.o.a.n.b bVar, @NonNull Camera camera, @NonNull b.o.a.x.a aVar) {
        super(l_a, bVar);
        this.n = bVar;
        this.o = camera;
        this.p = aVar;
        this.q = camera.getParameters().getPreviewFormat();
    }

    @Override // b.o.a.v.d
    public void b() {
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        super.b();
    }

    @Override // b.o.a.v.d
    public void c() {
        this.o.setOneShotPreviewCallback(new e$a(this));
    }
}
