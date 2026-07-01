package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n5 extends m5 {
    public n5(l5 l5Var) {
        super(null);
    }

    public static <E> b5<E> c(Object obj, long j) {
        return (b5) j7.r(obj, j);
    }

    @Override // b.i.a.f.h.l.m5
    public final <E> void a(Object obj, Object obj2, long j) {
        b5 b5VarC = c(obj, j);
        b5 b5VarC2 = c(obj2, j);
        int size = b5VarC.size();
        int size2 = b5VarC2.size();
        if (size > 0 && size2 > 0) {
            if (!b5VarC.a()) {
                b5VarC = b5VarC.f(size2 + size);
            }
            b5VarC.addAll(b5VarC2);
        }
        if (size > 0) {
            b5VarC2 = b5VarC;
        }
        j7.f(obj, j, b5VarC2);
    }

    @Override // b.i.a.f.h.l.m5
    public final void b(Object obj, long j) {
        c(obj, j).g0();
    }
}
