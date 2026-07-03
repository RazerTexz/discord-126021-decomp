package p007b.p225i.p226a.p288f.p313h.p323j;

import android.database.sqlite.SQLiteException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.j.t */
/* JADX INFO: loaded from: classes3.dex */
public final class C3542t extends AbstractC3498a0 {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C3538r f9799e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3542t(C3538r c3538r, C3515g c3515g) {
        super(c3515g);
        this.f9799e = c3538r;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3498a0
    /* JADX INFO: renamed from: c */
    public final void mo4418c() {
        C3538r c3538r = this.f9799e;
        Objects.requireNonNull(c3538r);
        try {
            c3538r.f9783m.m4472U();
            c3538r.m4491U();
        } catch (SQLiteException e) {
            c3538r.m4439x("Failed to delete stale hits", e);
        }
        c3538r.f9789s.m4420e(86400000L);
    }
}
