package b.o.a.n;

/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements Runnable {
    public final /* synthetic */ g j;

    public h(g gVar) {
        this.j = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.o.a.x.b bVarR0 = this.j.R0();
        if (bVarR0.equals(this.j.f1931s)) {
            i.j.a(1, "onSurfaceChanged:", "The computed preview size is identical. No op.");
            return;
        }
        i.j.a(1, "onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
        g gVar = this.j;
        gVar.f1931s = bVarR0;
        gVar.X0();
    }
}
