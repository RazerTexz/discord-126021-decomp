package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3455b;

    public d$a$a(int i, String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = i;
        this.f3455b = str;
    }

    public final int getMask() {
        return this.a;
    }

    public final String getName() {
        return this.f3455b;
    }
}
