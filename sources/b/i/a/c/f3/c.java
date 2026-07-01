package b.i.a.c.f3;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ v j;
    public final /* synthetic */ v$b k;

    public /* synthetic */ c(v vVar, v$b v_b) {
        this.j = vVar;
        this.k = v_b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        v vVar = this.j;
        v$b v_b = this.k;
        synchronized (vVar.d) {
            i = vVar.e;
        }
        v_b.a(i);
    }
}
