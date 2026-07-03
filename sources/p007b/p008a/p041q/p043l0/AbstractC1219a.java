package p007b.p008a.p041q.p043l0;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.l0.a */
/* JADX INFO: compiled from: WiredHeadsetState.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1219a {

    /* JADX INFO: renamed from: b.a.q.l0.a$a */
    /* JADX INFO: compiled from: WiredHeadsetState.kt */
    public static final class a extends AbstractC1219a {

        /* JADX INFO: renamed from: a */
        public final String f1667a;

        /* JADX INFO: renamed from: b */
        public final boolean f1668b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z2) {
            super(false, null);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f1667a = str;
            this.f1668b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C12238m.areEqual(this.f1667a, aVar.f1667a) && this.f1668b == aVar.f1668b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            String str = this.f1667a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.f1668b;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PluggedIn(name=");
            sbM833U.append(this.f1667a);
            sbM833U.append(", hasMic=");
            return C1643a.m827O(sbM833U, this.f1668b, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.q.l0.a$b */
    /* JADX INFO: compiled from: WiredHeadsetState.kt */
    public static final class b extends AbstractC1219a {

        /* JADX INFO: renamed from: a */
        public static final b f1669a = new b();

        public b() {
            super(false, null);
        }

        public String toString() {
            return "WiredHeadsetState.Unplugged";
        }
    }

    public AbstractC1219a(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
    }
}
