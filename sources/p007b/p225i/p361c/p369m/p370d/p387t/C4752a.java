package p007b.p225i.p361c.p369m.p370d.p387t;

/* JADX INFO: renamed from: b.i.c.m.d.t.a */
/* JADX INFO: compiled from: MiddleOutFallbackStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4752a implements InterfaceC4755d {

    /* JADX INFO: renamed from: a */
    public final InterfaceC4755d[] f12774a;

    /* JADX INFO: renamed from: b */
    public final C4753b f12775b;

    public C4752a(int i, InterfaceC4755d... interfaceC4755dArr) {
        this.f12774a = interfaceC4755dArr;
        this.f12775b = new C4753b(i);
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p387t.InterfaceC4755d
    /* JADX INFO: renamed from: a */
    public StackTraceElement[] mo6696a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrMo6696a = stackTraceElementArr;
        for (InterfaceC4755d interfaceC4755d : this.f12774a) {
            if (stackTraceElementArrMo6696a.length <= 1024) {
                break;
            }
            stackTraceElementArrMo6696a = interfaceC4755d.mo6696a(stackTraceElementArr);
        }
        return stackTraceElementArrMo6696a.length > 1024 ? this.f12775b.mo6696a(stackTraceElementArrMo6696a) : stackTraceElementArrMo6696a;
    }
}
