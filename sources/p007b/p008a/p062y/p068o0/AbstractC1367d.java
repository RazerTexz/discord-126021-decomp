package p007b.p008a.p062y.p068o0;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.o0.d */
/* JADX INFO: compiled from: SpeakersItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1367d implements MGRecyclerDataPayload {

    /* JADX INFO: renamed from: j */
    public final String f2055j;

    /* JADX INFO: renamed from: k */
    public final int f2056k;

    /* JADX INFO: renamed from: b.a.y.o0.d$a */
    /* JADX INFO: compiled from: SpeakersItem.kt */
    public static final class a extends AbstractC1367d {

        /* JADX INFO: renamed from: l */
        public final User f2057l;

        /* JADX INFO: renamed from: m */
        public final GuildMember f2058m;

        /* JADX INFO: renamed from: n */
        public final String f2059n;

        /* JADX INFO: renamed from: o */
        public final String f2060o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(User user, GuildMember guildMember, String str, String str2) {
            super(String.valueOf(user.getId()), 0, null);
            C12238m.checkNotNullParameter(user, "user");
            C12238m.checkNotNullParameter(str, "displayName");
            C12238m.checkNotNullParameter(str2, "positionKey");
            this.f2057l = user;
            this.f2058m = guildMember;
            this.f2059n = str;
            this.f2060o = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C12238m.areEqual(this.f2057l, aVar.f2057l) && C12238m.areEqual(this.f2058m, aVar.f2058m) && C12238m.areEqual(this.f2059n, aVar.f2059n) && C12238m.areEqual(this.f2060o, aVar.f2060o);
        }

        public int hashCode() {
            User user = this.f2057l;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            GuildMember guildMember = this.f2058m;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            String str = this.f2059n;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f2060o;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("IndividualSpeakerItem(user=");
            sbM833U.append(this.f2057l);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.f2058m);
            sbM833U.append(", displayName=");
            sbM833U.append(this.f2059n);
            sbM833U.append(", positionKey=");
            return C1643a.m822J(sbM833U, this.f2060o, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.y.o0.d$b */
    /* JADX INFO: compiled from: SpeakersItem.kt */
    public static final class b extends AbstractC1367d {

        /* JADX INFO: renamed from: l */
        public final int f2061l;

        /* JADX INFO: renamed from: m */
        public final String f2062m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, String str) {
            super("other-speakers-count", 1, null);
            C12238m.checkNotNullParameter(str, "positionKey");
            this.f2061l = i;
            this.f2062m = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f2061l == bVar.f2061l && C12238m.areEqual(this.f2062m, bVar.f2062m);
        }

        public int hashCode() {
            int i = this.f2061l * 31;
            String str = this.f2062m;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("OtherSpeakersCountItem(otherSpeakersCount=");
            sbM833U.append(this.f2061l);
            sbM833U.append(", positionKey=");
            return C1643a.m822J(sbM833U, this.f2062m, ")");
        }
    }

    public AbstractC1367d(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.f2055j = str;
        this.f2056k = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.f2055j;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.f2056k;
    }
}
