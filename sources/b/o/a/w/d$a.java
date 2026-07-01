package b.o.a.w;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements Runnable {
    public final /* synthetic */ f j;
    public final /* synthetic */ d k;

    public d$a(d dVar, f fVar) {
        this.k = dVar;
        this.j = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k.m.add(this.j);
        b.o.a.r.c cVar = this.k.l;
        if (cVar != null) {
            this.j.b(cVar.a.g);
        }
        this.j.c(this.k.q);
    }
}
