package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.f.a0.b.e$a;
import d0.e0.p.d.m0.f.a0.b.e$b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$a {
    public s$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final s fromFieldNameAndDesc(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "desc");
        return new s(str + MentionUtilsKt.CHANNELS_CHAR + str2, null);
    }

    public final s fromJvmMemberSignature(d0.e0.p.d.m0.f.a0.b.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "signature");
        if (eVar instanceof e$b) {
            return fromMethodNameAndDesc(eVar.getName(), eVar.getDesc());
        }
        if (eVar instanceof e$a) {
            return fromFieldNameAndDesc(eVar.getName(), eVar.getDesc());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final s fromMethod(d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.a0.a$c a_c) {
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(a_c, "signature");
        return fromMethodNameAndDesc(cVar.getString(a_c.getName()), cVar.getString(a_c.getDesc()));
    }

    public final s fromMethodNameAndDesc(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "desc");
        return new s(d0.z.d.m.stringPlus(str, str2), null);
    }

    public final s fromMethodSignatureAndParameterIndex(s sVar, int i) {
        d0.z.d.m.checkNotNullParameter(sVar, "signature");
        return new s(sVar.getSignature() + MentionUtilsKt.MENTIONS_CHAR + i, null);
    }
}
