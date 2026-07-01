package d0.e0.p.d.m0.f.a0.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3388b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$b(String str, String str2) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, "desc");
        this.a = str;
        this.f3388b = str2;
    }

    @Override // d0.e0.p.d.m0.f.a0.b.e
    public String asString() {
        return m.stringPlus(getName(), getDesc());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e$b)) {
            return false;
        }
        e$b e_b = (e$b) obj;
        return m.areEqual(this.a, e_b.a) && m.areEqual(this.f3388b, e_b.f3388b);
    }

    @Override // d0.e0.p.d.m0.f.a0.b.e
    public String getDesc() {
        return this.f3388b;
    }

    @Override // d0.e0.p.d.m0.f.a0.b.e
    public String getName() {
        return this.a;
    }

    public int hashCode() {
        return this.f3388b.hashCode() + (this.a.hashCode() * 31);
    }
}
