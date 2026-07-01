package b.i.c.m.d.t;

/* JADX INFO: renamed from: b.i.c.m.d.t.b, reason: use source file name */
/* JADX INFO: compiled from: MiddleOutStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class MiddleOutStrategy implements StackTraceTrimmingStrategy {
    public final int a;

    public MiddleOutStrategy(int i) {
        this.a = i;
    }

    @Override // b.i.c.m.d.t.StackTraceTrimmingStrategy
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i = this.a;
        if (length <= i) {
            return stackTraceElementArr;
        }
        int i2 = i / 2;
        int i3 = i - i2;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i3);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i2, stackTraceElementArr2, i3, i2);
        return stackTraceElementArr2;
    }
}
