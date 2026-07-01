package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChangeGuildIdentityViewModel$ViewState$Loaded extends WidgetChangeGuildIdentityViewModel$ViewState {
    private final boolean canChangeNickname;
    private final NullSerializable<String> currentAvatar;
    private final String currentNickname;
    private final boolean dimmed;
    private final String displayedAvatarURL;
    private final boolean displayingGuildAvatar;
    private final Guild guild;
    private final boolean isDirty;
    private final MeUser meUser;
    private final GuildMember member;
    private final boolean shouldUpsell;
    private final boolean showSaveFab;

    public /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState$Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guild, meUser, guildMember, z2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : nullSerializable, (i & 64) != 0 ? false : z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState$Loaded copy$default(WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded, Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetChangeGuildIdentityViewModel$ViewState$Loaded.guild;
        }
        if ((i & 2) != 0) {
            meUser = widgetChangeGuildIdentityViewModel$ViewState$Loaded.meUser;
        }
        MeUser meUser2 = meUser;
        if ((i & 4) != 0) {
            guildMember = widgetChangeGuildIdentityViewModel$ViewState$Loaded.member;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 8) != 0) {
            z2 = widgetChangeGuildIdentityViewModel$ViewState$Loaded.canChangeNickname;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            str = widgetChangeGuildIdentityViewModel$ViewState$Loaded.currentNickname;
        }
        String str2 = str;
        if ((i & 32) != 0) {
            nullSerializable = widgetChangeGuildIdentityViewModel$ViewState$Loaded.currentAvatar;
        }
        NullSerializable nullSerializable2 = nullSerializable;
        if ((i & 64) != 0) {
            z3 = widgetChangeGuildIdentityViewModel$ViewState$Loaded.dimmed;
        }
        return widgetChangeGuildIdentityViewModel$ViewState$Loaded.copy(guild, meUser2, guildMember2, z4, str2, nullSerializable2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCurrentNickname() {
        return this.currentNickname;
    }

    public final NullSerializable<String> component6() {
        return this.currentAvatar;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDimmed() {
        return this.dimmed;
    }

    public final WidgetChangeGuildIdentityViewModel$ViewState$Loaded copy(Guild guild, MeUser meUser, GuildMember member, boolean canChangeNickname, String currentNickname, NullSerializable<String> currentAvatar, boolean dimmed) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(member, "member");
        return new WidgetChangeGuildIdentityViewModel$ViewState$Loaded(guild, meUser, member, canChangeNickname, currentNickname, currentAvatar, dimmed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChangeGuildIdentityViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded = (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) other;
        return m.areEqual(this.guild, widgetChangeGuildIdentityViewModel$ViewState$Loaded.guild) && m.areEqual(this.meUser, widgetChangeGuildIdentityViewModel$ViewState$Loaded.meUser) && m.areEqual(this.member, widgetChangeGuildIdentityViewModel$ViewState$Loaded.member) && this.canChangeNickname == widgetChangeGuildIdentityViewModel$ViewState$Loaded.canChangeNickname && m.areEqual(this.currentNickname, widgetChangeGuildIdentityViewModel$ViewState$Loaded.currentNickname) && m.areEqual(this.currentAvatar, widgetChangeGuildIdentityViewModel$ViewState$Loaded.currentAvatar) && this.dimmed == widgetChangeGuildIdentityViewModel$ViewState$Loaded.dimmed;
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final NullSerializable<String> getCurrentAvatar() {
        return this.currentAvatar;
    }

    public final String getCurrentNickname() {
        return this.currentNickname;
    }

    public final boolean getDimmed() {
        return this.dimmed;
    }

    public final String getDisplayedAvatarURL() {
        return this.displayedAvatarURL;
    }

    public final boolean getDisplayingGuildAvatar() {
        return this.displayingGuildAvatar;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final GuildMember getMember() {
        return this.member;
    }

    public final boolean getShouldUpsell() {
        return this.shouldUpsell;
    }

    public final boolean getShowSaveFab() {
        return this.showSaveFab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        MeUser meUser = this.meUser;
        int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        boolean z2 = this.canChangeNickname;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        String str = this.currentNickname;
        int iHashCode4 = (i + (str != null ? str.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable = this.currentAvatar;
        int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
        boolean z3 = this.dimmed;
        return iHashCode5 + (z3 ? 1 : z3);
    }

    /* JADX INFO: renamed from: isDirty, reason: from getter */
    public final boolean getIsDirty() {
        return this.isDirty;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(guild=");
        sbU.append(this.guild);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", canChangeNickname=");
        sbU.append(this.canChangeNickname);
        sbU.append(", currentNickname=");
        sbU.append(this.currentNickname);
        sbU.append(", currentAvatar=");
        sbU.append(this.currentAvatar);
        sbU.append(", dimmed=");
        return a.O(sbU, this.dimmed, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel$ViewState$Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable<String> nullSerializable, boolean z3) {
        String forGuildMember$default;
        super(null);
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(guildMember, "member");
        this.guild = guild;
        this.meUser = meUser;
        this.member = guildMember;
        this.canChangeNickname = z2;
        this.currentNickname = str;
        this.currentAvatar = nullSerializable;
        this.dimmed = z3;
        String nick = guildMember.getNick();
        boolean z4 = (m.areEqual(nick == null ? "" : nick, str) ^ true) || nullSerializable != null;
        this.isDirty = z4;
        this.showSaveFab = z4;
        if (!(nullSerializable instanceof NullSerializable)) {
            forGuildMember$default = guildMember.hasAvatar() ? IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, true, 2, null) : IconUtils.getForUser$default(meUser, true, null, 4, null);
        } else if (nullSerializable instanceof NullSerializable$b) {
            forGuildMember$default = (String) ((NullSerializable$b) nullSerializable).a();
        } else {
            if (!(nullSerializable instanceof NullSerializable$a)) {
                throw new NoWhenBranchMatchedException();
            }
            forGuildMember$default = IconUtils.getForUser$default(meUser, true, null, 4, null);
        }
        this.displayedAvatarURL = forGuildMember$default;
        this.displayingGuildAvatar = nullSerializable instanceof NullSerializable ? nullSerializable instanceof NullSerializable$b : guildMember.hasAvatar();
        this.shouldUpsell = !UserUtils.INSTANCE.isPremiumTier2(meUser);
    }
}
