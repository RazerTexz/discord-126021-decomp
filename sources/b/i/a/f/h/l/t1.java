package b.i.a.f.h.l;

import android.database.ContentObserver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t1 extends ContentObserver {
    public t1() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        u1.e.set(true);
    }
}
