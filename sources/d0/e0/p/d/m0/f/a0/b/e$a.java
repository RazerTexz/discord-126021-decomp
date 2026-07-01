package d0.e0.p.d.m0.f.a0.b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3387b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(String str, String str2) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, "desc");
        this.a = str;
        this.f3387b = str2;
    }

    @Override // d0.e0.p.d.m0.f.a0.b.e
    public String asString() {
        return getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getDesc();
    }

    public final String component1() {
        return this.a;
    }

    public final String component2() {
        return this.f3387b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e$a)) {
            return false;
        }
        e$a e_a = (e$a) obj;
        return m.areEqual(this.a, e_a.a) && m.areEqual(this.f3387b, e_a.f3387b);
    }

    @Override // d0.e0.p.d.m0.f.a0.b.e
    public String getDesc() {
        return this.f3387b;
    }

    @Override // d0.e0.p.d.m0.f.a0.b.e
    public String getName() {
        return this.a;
    }

    public int hashCode() {
        return this.f3387b.hashCode() + (this.a.hashCode() * 31);
    }
}
