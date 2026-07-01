package z;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: BoltsExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public class b$b implements Executor {
    public ThreadLocal<Integer> j = new ThreadLocal<>();

    public b$b(b$a b_a) {
    }

    public final int a() {
        Integer num = this.j.get();
        if (num == null) {
            num = 0;
        }
        int iIntValue = num.intValue() - 1;
        if (iIntValue == 0) {
            this.j.remove();
        } else {
            this.j.set(Integer.valueOf(iIntValue));
        }
        return iIntValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Integer num = this.j.get();
        if (num == null) {
            num = 0;
        }
        int iIntValue = num.intValue() + 1;
        this.j.set(Integer.valueOf(iIntValue));
        try {
            if (iIntValue <= 15) {
                runnable.run();
            } else {
                b.a.f3858b.execute(runnable);
            }
            a();
        } catch (Throwable th) {
            a();
            throw th;
        }
    }
}
