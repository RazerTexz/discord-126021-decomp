package b.i.c.m.d.t;

/* JADX INFO: renamed from: b.i.c.m.d.t.a, reason: use source file name */
/* JADX INFO: compiled from: MiddleOutFallbackStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {
    public final StackTraceTrimmingStrategy[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MiddleOutStrategy f1752b;

    public MiddleOutFallbackStrategy(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.a = stackTraceTrimmingStrategyArr;
        this.f1752b = new MiddleOutStrategy(i);
    }

    @Override // b.i.c.m.d.t.StackTraceTrimmingStrategy
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.a) {
            if (stackTraceElementArrA.length <= 1024) {
                break;
            }
            stackTraceElementArrA = stackTraceTrimmingStrategy.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > 1024 ? this.f1752b.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
