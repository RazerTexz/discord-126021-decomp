package b.o.a.n;

import android.view.SurfaceHolder;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$n implements Callable<Void> {
    public final /* synthetic */ Object j;
    public final /* synthetic */ d k;

    public d$n(d dVar, Object obj) {
        this.k = dVar;
        this.j = obj;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        SurfaceHolder surfaceHolder = (SurfaceHolder) this.j;
        b.o.a.x.b bVar = this.k.f1931s;
        surfaceHolder.setFixedSize(bVar.j, bVar.k);
        return null;
    }
}
