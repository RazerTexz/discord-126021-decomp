package b.f.j.p;

/* JADX INFO: compiled from: JobScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0$b implements Runnable {
    public final /* synthetic */ c0 j;

    public c0$b(c0 c0Var) {
        this.j = c0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        c0 c0Var = this.j;
        c0Var.a.execute(c0Var.c);
    }
}
