package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r5 implements z5 {
    public z5[] a;

    public r5(z5... z5VarArr) {
        this.a = z5VarArr;
    }

    @Override // b.i.a.f.h.l.z5
    public final boolean a(Class<?> cls) {
        for (z5 z5Var : this.a) {
            if (z5Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.f.h.l.z5
    public final a6 b(Class<?> cls) {
        for (z5 z5Var : this.a) {
            if (z5Var.a(cls)) {
                return z5Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
