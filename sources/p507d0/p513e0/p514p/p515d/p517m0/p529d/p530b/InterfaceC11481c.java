package p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.c */
/* JADX INFO: compiled from: LookupTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11481c {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.c$a */
    /* JADX INFO: compiled from: LookupTracker.kt */
    public static final class a implements InterfaceC11481c {

        /* JADX INFO: renamed from: a */
        public static final a f23110a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11481c
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11481c
        public void record(String str, C11483e c11483e, String str2, EnumC11484f enumC11484f, String str3) {
            C12238m.checkNotNullParameter(str, "filePath");
            C12238m.checkNotNullParameter(c11483e, ModelAuditLogEntry.CHANGE_KEY_POSITION);
            C12238m.checkNotNullParameter(str2, "scopeFqName");
            C12238m.checkNotNullParameter(enumC11484f, "scopeKind");
            C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    boolean getRequiresPosition();

    void record(String str, C11483e c11483e, String str2, EnumC11484f enumC11484f, String str3);
}
