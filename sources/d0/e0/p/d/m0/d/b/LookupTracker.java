package d0.e0.p.d.m0.d.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.c, reason: use source file name */
/* JADX INFO: compiled from: LookupTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface LookupTracker {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.c$a */
    /* JADX INFO: compiled from: LookupTracker.kt */
    public static final class a implements LookupTracker {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.d.b.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // d0.e0.p.d.m0.d.b.LookupTracker
        public void record(String str, LookupLocation4 lookupLocation4, String str2, LookupTracker2 lookupTracker2, String str3) {
            Intrinsics3.checkNotNullParameter(str, "filePath");
            Intrinsics3.checkNotNullParameter(lookupLocation4, ModelAuditLogEntry.CHANGE_KEY_POSITION);
            Intrinsics3.checkNotNullParameter(str2, "scopeFqName");
            Intrinsics3.checkNotNullParameter(lookupTracker2, "scopeKind");
            Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    boolean getRequiresPosition();

    void record(String str, LookupLocation4 lookupLocation4, String str2, LookupTracker2 lookupTracker2, String str3);
}
