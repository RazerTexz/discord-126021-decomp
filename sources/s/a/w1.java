package s.a;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w1 {
    public static final ThreadLocal<q0> a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w1 f3847b = null;

    public static final q0 a() {
        ThreadLocal<q0> threadLocal = a;
        q0 q0Var = threadLocal.get();
        if (q0Var != null) {
            return q0Var;
        }
        g gVar = new g(Thread.currentThread());
        threadLocal.set(gVar);
        return gVar;
    }
}
