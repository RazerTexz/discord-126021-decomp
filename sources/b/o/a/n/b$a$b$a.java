package b.o.a.n;

import android.hardware.Camera$Parameters;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a$b$a implements Runnable {
    public final /* synthetic */ b$a$b j;

    public b$a$b$a(b$a$b b_a_b) {
        this.j = b_a_b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.a.m.f1914e0.cancelAutoFocus();
        Camera$Parameters parameters = this.j.a.m.f1914e0.getParameters();
        int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
        int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
        if (maxNumFocusAreas > 0) {
            parameters.setFocusAreas(null);
        }
        if (maxNumMeteringAreas > 0) {
            parameters.setMeteringAreas(null);
        }
        this.j.a.m.c1(parameters);
        this.j.a.m.f1914e0.setParameters(parameters);
    }
}
