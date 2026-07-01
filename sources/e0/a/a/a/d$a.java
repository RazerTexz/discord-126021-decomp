package e0.a.a.a;

/* JADX INFO: compiled from: CameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements Runnable {
    public final /* synthetic */ d j;

    public d$a(d dVar) {
        this.j = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.j;
        if (dVar.j != null && dVar.l && dVar.m && dVar.n) {
            dVar.a();
        }
    }
}
