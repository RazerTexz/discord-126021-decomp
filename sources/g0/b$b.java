package g0;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends Thread {
    public b$b() {
        super("Okio Watchdog");
        setDaemon(true);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        b bVarA;
        while (true) {
            try {
                synchronized (b.class) {
                    bVarA = b.h.a();
                    if (bVarA == b.g) {
                        b.g = null;
                        return;
                    }
                }
                if (bVarA != null) {
                    bVarA.l();
                }
            } catch (InterruptedException unused) {
            }
        }
    }
}
