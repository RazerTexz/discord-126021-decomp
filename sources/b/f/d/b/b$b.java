package b.f.d.b;

/* JADX INFO: compiled from: ConstrainedExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class b$b implements Runnable {
    public final /* synthetic */ b j;

    public b$b(b bVar, b$a b_a) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnablePoll = this.j.n.poll();
            if (runnablePoll != null) {
                runnablePoll.run();
            } else {
                Class<?> cls = b.j;
                Class<?> cls2 = b.j;
                String str = this.j.k;
                int i = b.f.d.e.a.a;
            }
        } finally {
            this.j.p.decrementAndGet();
            if (this.j.n.isEmpty()) {
                Class<?> cls3 = b.j;
                Class<?> cls4 = b.j;
                String str2 = this.j.k;
                int i2 = b.f.d.e.a.a;
            } else {
                this.j.a();
            }
        }
    }
}
