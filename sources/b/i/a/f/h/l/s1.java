package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s1 implements a5 {
    public static final a5 a = new s1();

    @Override // b.i.a.f.h.l.a5
    public final boolean f(int i) {
        q1$a q1_a;
        if (i == 0) {
            q1_a = q1$a.UNKNOWN;
        } else if (i == 1) {
            q1_a = q1$a.STRING;
        } else if (i == 2) {
            q1_a = q1$a.NUMBER;
        } else if (i != 3) {
            q1_a = i != 4 ? null : q1$a.STATEMENT;
        } else {
            q1_a = q1$a.BOOLEAN;
        }
        return q1_a != null;
    }
}
