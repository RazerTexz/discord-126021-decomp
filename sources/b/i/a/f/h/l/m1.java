package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements a5 {
    public static final a5 a = new m1();

    @Override // b.i.a.f.h.l.a5
    public final boolean f(int i) {
        f1$b f1_b;
        if (i != 1) {
            f1_b = i != 2 ? null : f1$b.PROVISIONING;
        } else {
            f1_b = f1$b.RADS;
        }
        return f1_b != null;
    }
}
