package b.i.c.m.d.t;

/* JADX INFO: compiled from: MiddleOutFallbackStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements d {
    public final d[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1752b;

    public a(int i, d... dVarArr) {
        this.a = dVarArr;
        this.f1752b = new b(i);
    }

    @Override // b.i.c.m.d.t.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (d dVar : this.a) {
            if (stackTraceElementArrA.length <= 1024) {
                break;
            }
            stackTraceElementArrA = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > 1024 ? this.f1752b.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
