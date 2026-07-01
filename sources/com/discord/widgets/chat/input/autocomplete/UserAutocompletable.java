package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class UserAutocompletable extends Autocompletable {
    private final List<String> autoTextMatchers;
    private final boolean canUserReadChannel;
    private final GuildMember guildMember;
    private final String nickname;
    private final Presence presence;
    private final List<String> textMatchers;
    private final User user;

    public /* synthetic */ UserAutocompletable(User user, GuildMember guildMember, String str, Presence presence, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? null : guildMember, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : presence, (i & 16) != 0 ? true : z2);
    }

    public static /* synthetic */ UserAutocompletable copy$default(UserAutocompletable userAutocompletable, User user, GuildMember guildMember, String str, Presence presence, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userAutocompletable.user;
        }
        if ((i & 2) != 0) {
            guildMember = userAutocompletable.guildMember;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 4) != 0) {
            str = userAutocompletable.nickname;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            presence = userAutocompletable.presence;
        }
        Presence presence2 = presence;
        if ((i & 16) != 0) {
            z2 = userAutocompletable.canUserReadChannel;
        }
        return userAutocompletable.copy(user, guildMember2, str2, presence2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanUserReadChannel() {
        return this.canUserReadChannel;
    }

    public final UserAutocompletable copy(User user, GuildMember guildMember, String nickname, Presence presence, boolean canUserReadChannel) {
        m.checkNotNullParameter(user, "user");
        return new UserAutocompletable(user, guildMember, nickname, presence, canUserReadChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAutocompletable)) {
            return false;
        }
        UserAutocompletable userAutocompletable = (UserAutocompletable) other;
        return m.areEqual(this.user, userAutocompletable.user) && m.areEqual(this.guildMember, userAutocompletable.guildMember) && m.areEqual(this.nickname, userAutocompletable.nickname) && m.areEqual(this.presence, userAutocompletable.presence) && this.canUserReadChannel == userAutocompletable.canUserReadChannel;
    }

    public final List<String> getAutoTextMatchers() {
        return this.autoTextMatchers;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getAutocompleteTextMatchers() {
        return this.autoTextMatchers;
    }

    public final boolean getCanUserReadChannel() {
        return this.canUserReadChannel;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbQ = a.Q('<');
        sbQ.append(leadingIdentifier().getIdentifier());
        sbQ.append(this.user.getId());
        sbQ.append('>');
        return sbQ.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        String str = this.nickname;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Presence presence = this.presence;
        int iHashCode4 = (iHashCode3 + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.canUserReadChannel;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        StringBuilder sbU = a.U("UserAutocompletable(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", nickname=");
        sbU.append(this.nickname);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", canUserReadChannel=");
        return a.O(sbU, this.canUserReadChannel, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAutocompletable(User user, GuildMember guildMember, String str, Presence presence, boolean z2) {
        super(null);
        m.checkNotNullParameter(user, "user");
        List<String> listListOf = null;
        this.user = user;
        this.guildMember = guildMember;
        this.nickname = str;
        this.presence = presence;
        this.canUserReadChannel = z2;
        this.textMatchers = d0.t.m.listOf(leadingIdentifier().getIdentifier() + user.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
        if (str != null) {
            listListOf = d0.t.m.listOf(leadingIdentifier().getIdentifier() + str);
        }
        this.autoTextMatchers = listListOf;
    }
}
