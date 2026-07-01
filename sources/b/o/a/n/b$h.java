package b.o.a.n;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$h implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ b k;

    public b$h(b bVar, boolean z2) {
        this.k = bVar;
        this.j = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k.h1(this.j);
    }
}
