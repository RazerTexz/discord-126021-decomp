package b.a.q.l0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WiredHeadsetState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$a extends a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f265b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(String str, boolean z2) {
        super(false, null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = str;
        this.f265b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a$a)) {
            return false;
        }
        a$a a_a = (a$a) obj;
        return m.areEqual(this.a, a_a.a) && this.f265b == a_a.f265b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.f265b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("PluggedIn(name=");
        sbU.append(this.a);
        sbU.append(", hasMic=");
        return b.d.b.a.a.O(sbU, this.f265b, ")");
    }
}
