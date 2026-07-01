package b.i.a.f.h.l;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g$c extends b {
    public final b.i.a.f.i.b.z5 a;

    public g$c(b.i.a.f.i.b.z5 z5Var) {
        this.a = z5Var;
    }

    @Override // b.i.a.f.h.l.c
    public final void Z(String str, String str2, Bundle bundle, long j) {
        this.a.a(str, str2, bundle, j);
    }

    @Override // b.i.a.f.h.l.c
    public final int a() {
        return System.identityHashCode(this.a);
    }
}
