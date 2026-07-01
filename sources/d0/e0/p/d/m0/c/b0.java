package d0.e0.p.d.m0.c;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: ModuleCapability.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0<T> {
    public final String a;

    public b0(String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
