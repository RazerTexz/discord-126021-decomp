package b.a.y.o0;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: SpeakersItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d$a extends d {
    public final User l;
    public final GuildMember m;
    public final String n;
    public final String o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(User user, GuildMember guildMember, String str, String str2) {
        super(String.valueOf(user.getId()), 0, null);
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(str, "displayName");
        m.checkNotNullParameter(str2, "positionKey");
        this.l = user;
        this.m = guildMember;
        this.n = str;
        this.o = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d$a)) {
            return false;
        }
        d$a d_a = (d$a) obj;
        return m.areEqual(this.l, d_a.l) && m.areEqual(this.m, d_a.m) && m.areEqual(this.n, d_a.n) && m.areEqual(this.o, d_a.o);
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
        StringBuilder sbU = b.d.b.a.a.U("IndividualSpeakerItem(user=");
        sbU.append(this.l);
        sbU.append(", guildMember=");
        sbU.append(this.m);
        sbU.append(", displayName=");
        sbU.append(this.n);
        sbU.append(", positionKey=");
        return b.d.b.a.a.J(sbU, this.o, ")");
    }
}
