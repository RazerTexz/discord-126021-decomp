package b.i.a.b.j;

/* JADX INFO: compiled from: SafeLoggingExecutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$a implements Runnable {
    public final Runnable j;

    public h$a(Runnable runnable) {
        this.j = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.j.run();
        } catch (Exception e) {
            b.c.a.a0.d.c0("Executor", "Background execution failure.", e);
        }
    }
}
