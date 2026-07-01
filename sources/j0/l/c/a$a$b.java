package j0.l.c;

/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a$b implements Runnable {
    public final /* synthetic */ a$a j;

    public a$a$b(a$a a_a) {
        this.j = a_a;
    }

    @Override // java.lang.Runnable
    public void run() {
        a$a a_a = this.j;
        if (a_a.c.isEmpty()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        for (a$c a_c : a_a.c) {
            if (a_c.r > jNanoTime) {
                return;
            }
            if (a_a.c.remove(a_c)) {
                a_a.d.c(a_c);
            }
        }
    }
}
