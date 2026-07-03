package p007b.p225i.p361c.p369m.p370d.p387t;

/* JADX INFO: renamed from: b.i.c.m.d.t.b */
/* JADX INFO: compiled from: MiddleOutStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4753b implements InterfaceC4755d {

    /* JADX INFO: renamed from: a */
    public final int f12776a;

    public C4753b(int i) {
        this.f12776a = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p387t.InterfaceC4755d
    /* JADX INFO: renamed from: a */
    public StackTraceElement[] mo6696a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i = this.f12776a;
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
