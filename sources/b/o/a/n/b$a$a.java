package b.o.a.n;

import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a$a implements Runnable {
    public final /* synthetic */ b$a j;

    public b$a$a(b$a b_a) {
        this.j = b_a;
    }

    @Override // java.lang.Runnable
    public void run() {
        b$a b_a = this.j;
        ((CameraView$b) b_a.m.m).d(b_a.k, false, b_a.l);
    }
}
