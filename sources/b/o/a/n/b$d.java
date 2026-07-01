package b.o.a.n;

import android.hardware.Camera$Parameters;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$d implements Runnable {
    public final /* synthetic */ b.o.a.m.m j;
    public final /* synthetic */ b k;

    public b$d(b bVar, b.o.a.m.m mVar) {
        this.k = bVar;
        this.j = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera$Parameters parameters = this.k.f1914e0.getParameters();
        if (this.k.j1(parameters, this.j)) {
            this.k.f1914e0.setParameters(parameters);
        }
    }
}
