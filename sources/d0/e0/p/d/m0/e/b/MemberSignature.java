package d0.e0.p.d.m0.e.b;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.JvmMemberSignature;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.s, reason: use source file name */
/* JADX INFO: compiled from: MemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MemberSignature {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3382b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.s$a */
    /* JADX INFO: compiled from: MemberSignature.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final MemberSignature fromFieldNameAndDesc(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            return new MemberSignature(str + MentionUtils.CHANNELS_CHAR + str2, null);
        }

        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature jvmMemberSignature) {
            Intrinsics3.checkNotNullParameter(jvmMemberSignature, "signature");
            if (jvmMemberSignature instanceof JvmMemberSignature.b) {
                return fromMethodNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            if (jvmMemberSignature instanceof JvmMemberSignature.a) {
                return fromFieldNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final MemberSignature fromMethod(NameResolver nameResolver, JvmProtoBuf.c cVar) {
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(cVar, "signature");
            return fromMethodNameAndDesc(nameResolver.getString(cVar.getName()), nameResolver.getString(cVar.getDesc()));
        }

        public final MemberSignature fromMethodNameAndDesc(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            return new MemberSignature(Intrinsics3.stringPlus(str, str2), null);
        }

        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature memberSignature, int i) {
            Intrinsics3.checkNotNullParameter(memberSignature, "signature");
            return new MemberSignature(memberSignature.getSignature() + MentionUtils.MENTIONS_CHAR + i, null);
        }
    }

    public MemberSignature(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3382b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MemberSignature) && Intrinsics3.areEqual(this.f3382b, ((MemberSignature) obj).f3382b);
    }

    public final String getSignature() {
        return this.f3382b;
    }

    public int hashCode() {
        return this.f3382b.hashCode();
    }

    public String toString() {
        return outline.H(outline.U("MemberSignature(signature="), this.f3382b, ')');
    }
}
