package s.a;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0$b extends r0$c {
    public final Runnable m;

    public r0$b(long j, Runnable runnable) {
        super(j);
        this.m = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.m.run();
    }

    @Override // s.a.r0$c
    public String toString() {
        return super.toString() + this.m.toString();
    }
}
