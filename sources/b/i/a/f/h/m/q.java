package b.i.a.f.h.m;

import android.database.ContentObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends ContentObserver {
    public q() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        p.e.set(true);
    }
}
