package d0.e0.p.d.m0.f.a0.b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e, reason: use source file name */
/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmMemberSignature {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e$a */
    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class a extends JvmMemberSignature {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3387b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            this.a = str;
            this.f3387b = str2;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.JvmMemberSignature
        public String asString() {
            return getName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + getDesc();
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
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && Intrinsics3.areEqual(this.f3387b, aVar.f3387b);
        }

        @Override // d0.e0.p.d.m0.f.a0.b.JvmMemberSignature
        public String getDesc() {
            return this.f3387b;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.JvmMemberSignature
        public String getName() {
            return this.a;
        }

        public int hashCode() {
            return this.f3387b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e$b */
    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class b extends JvmMemberSignature {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3388b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            this.a = str;
            this.f3388b = str2;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.JvmMemberSignature
        public String asString() {
            return Intrinsics3.stringPlus(getName(), getDesc());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f3388b, bVar.f3388b);
        }

        @Override // d0.e0.p.d.m0.f.a0.b.JvmMemberSignature
        public String getDesc() {
            return this.f3388b;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.JvmMemberSignature
        public String getName() {
            return this.a;
        }

        public int hashCode() {
            return this.f3388b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    public JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }
}
