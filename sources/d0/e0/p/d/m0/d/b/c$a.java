package d0.e0.p.d.m0.d.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: LookupTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a implements c {
    public static final c$a a = new c$a();

    @Override // d0.e0.p.d.m0.d.b.c
    public boolean getRequiresPosition() {
        return false;
    }

    @Override // d0.e0.p.d.m0.d.b.c
    public void record(String str, e eVar, String str2, f fVar, String str3) {
        m.checkNotNullParameter(str, "filePath");
        m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        m.checkNotNullParameter(str2, "scopeFqName");
        m.checkNotNullParameter(fVar, "scopeKind");
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }
}
