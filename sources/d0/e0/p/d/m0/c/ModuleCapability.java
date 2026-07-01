package d0.e0.p.d.m0.c;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.b0, reason: use source file name */
/* JADX INFO: compiled from: ModuleCapability.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleCapability<T> {
    public final String a;

    public ModuleCapability(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
