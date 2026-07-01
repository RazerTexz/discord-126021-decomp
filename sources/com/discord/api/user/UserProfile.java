package com.discord.api.user;

import b.d.b.a.a;
import com.discord.api.application.ProfileApplication;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.guildmember.GuildMember;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: UserProfile.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfile {
    private final ProfileApplication application;
    private final List<ConnectedAccount> connectedAccounts;
    private final GuildMember guildMember;
    private final List<UserProfile$GuildReference> mutualGuilds;
    private final String premiumGuildSince;
    private final String premiumSince;
    private final User user;

    public UserProfile() {
        this(null, null, null, null, null, null, null, Opcodes.LAND);
    }

    public UserProfile(List<ConnectedAccount> list, List<UserProfile$GuildReference> list2, User user, String str, String str2, GuildMember guildMember, ProfileApplication profileApplication) {
        m.checkNotNullParameter(list, "connectedAccounts");
        m.checkNotNullParameter(list2, "mutualGuilds");
        m.checkNotNullParameter(user, "user");
        this.connectedAccounts = list;
        this.mutualGuilds = list2;
        this.user = user;
        this.premiumSince = str;
        this.premiumGuildSince = str2;
        this.guildMember = guildMember;
        this.application = profileApplication;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final ProfileApplication getApplication() {
        return this.application;
    }

    public final List<ConnectedAccount> b() {
        return this.connectedAccounts;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final List<UserProfile$GuildReference> d() {
        return this.mutualGuilds;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getPremiumGuildSince() {
        return this.premiumGuildSince;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfile)) {
            return false;
        }
        UserProfile userProfile = (UserProfile) other;
        return m.areEqual(this.connectedAccounts, userProfile.connectedAccounts) && m.areEqual(this.mutualGuilds, userProfile.mutualGuilds) && m.areEqual(this.user, userProfile.user) && m.areEqual(this.premiumSince, userProfile.premiumSince) && m.areEqual(this.premiumGuildSince, userProfile.premiumGuildSince) && m.areEqual(this.guildMember, userProfile.guildMember) && m.areEqual(this.application, userProfile.application);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        List<ConnectedAccount> list = this.connectedAccounts;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<UserProfile$GuildReference> list2 = this.mutualGuilds;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.premiumSince;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumGuildSince;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode6 = (iHashCode5 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        ProfileApplication profileApplication = this.application;
        return iHashCode6 + (profileApplication != null ? profileApplication.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserProfile(connectedAccounts=");
        sbU.append(this.connectedAccounts);
        sbU.append(", mutualGuilds=");
        sbU.append(this.mutualGuilds);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", premiumGuildSince=");
        sbU.append(this.premiumGuildSince);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserProfile(List list, List list2, User user, String str, String str2, GuildMember guildMember, ProfileApplication profileApplication, int i) {
        this((i & 1) != 0 ? n.emptyList() : null, (i & 2) != 0 ? n.emptyList() : null, (i & 4) != 0 ? new User(0L, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194300) : null, null, null, null, null);
        int i2 = i & 8;
        int i3 = i & 16;
        int i4 = i & 32;
        int i5 = i & 64;
    }
}
