package b.o.a.n;

import android.hardware.Camera$Parameters;
import android.location.Location;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$c implements Runnable {
    public final /* synthetic */ Location j;
    public final /* synthetic */ b k;

    public b$c(b bVar, Location location) {
        this.k = bVar;
        this.j = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera$Parameters parameters = this.k.f1914e0.getParameters();
        this.k.g1(parameters);
        this.k.f1914e0.setParameters(parameters);
    }
}
