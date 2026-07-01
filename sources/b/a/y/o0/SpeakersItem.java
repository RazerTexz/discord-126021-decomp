package b.a.y.o0;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.y.o0.d, reason: use source file name */
/* JADX INFO: compiled from: SpeakersItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SpeakersItem implements MGRecyclerDataPayload {
    public final String j;
    public final int k;

    /* JADX INFO: renamed from: b.a.y.o0.d$a */
    /* JADX INFO: compiled from: SpeakersItem.kt */
    public static final class a extends SpeakersItem {
        public final User l;
        public final GuildMember m;
        public final String n;
        public final String o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(User user, GuildMember guildMember, String str, String str2) {
            super(String.valueOf(user.getId()), 0, null);
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(str, "displayName");
            Intrinsics3.checkNotNullParameter(str2, "positionKey");
            this.l = user;
            this.m = guildMember;
            this.n = str;
            this.o = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.l, aVar.l) && Intrinsics3.areEqual(this.m, aVar.m) && Intrinsics3.areEqual(this.n, aVar.n) && Intrinsics3.areEqual(this.o, aVar.o);
        }

        public int hashCode() {
            User user = this.l;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            GuildMember guildMember = this.m;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            String str = this.n;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.o;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("IndividualSpeakerItem(user=");
            sbU.append(this.l);
            sbU.append(", guildMember=");
            sbU.append(this.m);
            sbU.append(", displayName=");
            sbU.append(this.n);
            sbU.append(", positionKey=");
            return outline.J(sbU, this.o, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.y.o0.d$b */
    /* JADX INFO: compiled from: SpeakersItem.kt */
    public static final class b extends SpeakersItem {
        public final int l;
        public final String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, String str) {
            super("other-speakers-count", 1, null);
            Intrinsics3.checkNotNullParameter(str, "positionKey");
            this.l = i;
            this.m = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.l == bVar.l && Intrinsics3.areEqual(this.m, bVar.m);
        }

        public int hashCode() {
            int i = this.l * 31;
            String str = this.m;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("OtherSpeakersCountItem(otherSpeakersCount=");
            sbU.append(this.l);
            sbU.append(", positionKey=");
            return outline.J(sbU, this.m, ")");
        }
    }

    public SpeakersItem(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.j = str;
        this.k = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.j;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.k;
    }
}
