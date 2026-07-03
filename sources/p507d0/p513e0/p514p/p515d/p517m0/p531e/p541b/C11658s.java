package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.s */
/* JADX INFO: compiled from: MemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11658s {

    /* JADX INFO: renamed from: a */
    public static final a f23633a = new a(null);

    /* JADX INFO: renamed from: b */
    public final String f23634b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.s$a */
    /* JADX INFO: compiled from: MemberSignature.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11658s fromFieldNameAndDesc(String str, String str2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(str2, "desc");
            return new C11658s(str + MentionUtilsKt.CHANNELS_CHAR + str2, null);
        }

        public final C11658s fromJvmMemberSignature(AbstractC11672e abstractC11672e) {
            C12238m.checkNotNullParameter(abstractC11672e, "signature");
            if (abstractC11672e instanceof AbstractC11672e.b) {
                return fromMethodNameAndDesc(abstractC11672e.getName(), abstractC11672e.getDesc());
            }
            if (abstractC11672e instanceof AbstractC11672e.a) {
                return fromFieldNameAndDesc(abstractC11672e.getName(), abstractC11672e.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final C11658s fromMethod(InterfaceC11704c interfaceC11704c, C11667a.c cVar) {
            C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
            C12238m.checkNotNullParameter(cVar, "signature");
            return fromMethodNameAndDesc(interfaceC11704c.getString(cVar.getName()), interfaceC11704c.getString(cVar.getDesc()));
        }

        public final C11658s fromMethodNameAndDesc(String str, String str2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(str2, "desc");
            return new C11658s(C12238m.stringPlus(str, str2), null);
        }

        public final C11658s fromMethodSignatureAndParameterIndex(C11658s c11658s, int i) {
            C12238m.checkNotNullParameter(c11658s, "signature");
            return new C11658s(c11658s.getSignature() + MentionUtilsKt.MENTIONS_CHAR + i, null);
        }
    }

    public C11658s(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23634b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C11658s) && C12238m.areEqual(this.f23634b, ((C11658s) obj).f23634b);
    }

    public final String getSignature() {
        return this.f23634b;
    }

    public int hashCode() {
        return this.f23634b.hashCode();
    }

    public String toString() {
        return C1643a.m820H(C1643a.m833U("MemberSignature(signature="), this.f23634b, ')');
    }
}
