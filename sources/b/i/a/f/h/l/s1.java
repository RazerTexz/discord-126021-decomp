package b.i.a.f.h.l;

import b.i.a.f.h.l.q1;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s1 implements a5 {
    public static final a5 a = new s1();

    @Override // b.i.a.f.h.l.a5
    public final boolean f(int i) {
        q1.a aVar;
        if (i == 0) {
            aVar = q1.a.UNKNOWN;
        } else if (i == 1) {
            aVar = q1.a.STRING;
        } else if (i == 2) {
            aVar = q1.a.NUMBER;
        } else if (i != 3) {
            aVar = i != 4 ? null : q1.a.STATEMENT;
        } else {
            aVar = q1.a.BOOLEAN;
        }
        return aVar != null;
    }
}
