package b.o.a.w;

import java.util.Iterator;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$b implements Runnable {
    public final /* synthetic */ b.o.a.o.b j;
    public final /* synthetic */ d k;

    public d$b(d dVar, b.o.a.o.b bVar) {
        this.k = dVar;
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.k;
        b.o.a.r.c cVar = dVar.l;
        if (cVar != null) {
            cVar.d = this.j;
        }
        Iterator<f> it = dVar.m.iterator();
        while (it.hasNext()) {
            it.next().c(this.j);
        }
    }
}
