package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e */
/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11672e {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e$a */
    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class a extends AbstractC11672e {

        /* JADX INFO: renamed from: a */
        public final String f23707a;

        /* JADX INFO: renamed from: b */
        public final String f23708b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(str2, "desc");
            this.f23707a = str;
            this.f23708b = str2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e
        public String asString() {
            return getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getDesc();
        }

        public final String component1() {
            return this.f23707a;
        }

        public final String component2() {
            return this.f23708b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C12238m.areEqual(this.f23707a, aVar.f23707a) && C12238m.areEqual(this.f23708b, aVar.f23708b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e
        public String getDesc() {
            return this.f23708b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e
        public String getName() {
            return this.f23707a;
        }

        public int hashCode() {
            return this.f23708b.hashCode() + (this.f23707a.hashCode() * 31);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e$b */
    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class b extends AbstractC11672e {

        /* JADX INFO: renamed from: a */
        public final String f23709a;

        /* JADX INFO: renamed from: b */
        public final String f23710b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(str2, "desc");
            this.f23709a = str;
            this.f23710b = str2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e
        public String asString() {
            return C12238m.stringPlus(getName(), getDesc());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return C12238m.areEqual(this.f23709a, bVar.f23709a) && C12238m.areEqual(this.f23710b, bVar.f23710b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e
        public String getDesc() {
            return this.f23710b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e
        public String getName() {
            return this.f23709a;
        }

        public int hashCode() {
            return this.f23710b.hashCode() + (this.f23709a.hashCode() * 31);
        }
    }

    public AbstractC11672e(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }
}
