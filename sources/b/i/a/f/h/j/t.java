package b.i.a.f.h.j;

import android.database.sqlite.SQLiteException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends a0 {
    public final /* synthetic */ r e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, g gVar) {
        super(gVar);
        this.e = rVar;
    }

    @Override // b.i.a.f.h.j.a0
    public final void c() {
        r rVar = this.e;
        Objects.requireNonNull(rVar);
        try {
            rVar.m.U();
            rVar.U();
        } catch (SQLiteException e) {
            rVar.x("Failed to delete stale hits", e);
        }
        rVar.f1424s.e(86400000L);
    }
}
