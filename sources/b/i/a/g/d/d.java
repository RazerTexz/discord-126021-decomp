package b.i.a.g.d;

/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ c k;

    public d(c cVar, long j) {
        this.k = cVar;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.k;
        cVar.j.setError(String.format(cVar.m, b.i.a.f.e.o.f.g0(this.j)));
        this.k.a();
    }
}
