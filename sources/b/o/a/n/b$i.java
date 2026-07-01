package b.o.a.n;

import android.hardware.Camera$Parameters;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$i implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ b k;

    public b$i(b bVar, float f) {
        this.k = bVar;
        this.j = f;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera$Parameters parameters = this.k.f1914e0.getParameters();
        if (this.k.i1(parameters, this.j)) {
            this.k.f1914e0.setParameters(parameters);
        }
    }
}
