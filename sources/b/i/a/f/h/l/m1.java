package b.i.a.f.h.l;

import b.i.a.f.h.l.f1;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements a5 {
    public static final a5 a = new m1();

    @Override // b.i.a.f.h.l.a5
    public final boolean f(int i) {
        f1.b bVar;
        if (i != 1) {
            bVar = i != 2 ? null : f1.b.PROVISIONING;
        } else {
            bVar = f1.b.RADS;
        }
        return bVar != null;
    }
}
