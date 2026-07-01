package com.discord.widgets.settings.profile;

import b.d.b.a.a;
import com.discord.api.user.UserProfile;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.premium.PremiumUtilsKt;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.g0.t;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsUserProfileViewModel$ViewState$Loaded extends SettingsUserProfileViewModel$ViewState {
    private final List<Node<MessageRenderContext>> bioAst;
    private final boolean canEditNickname;
    private final boolean canHaveAnimatedAvatars;
    private final NullSerializable<String> currentAvatar;
    private final NullSerializable<String> currentBannerColorHex;
    private final NullSerializable<String> currentBannerImage;
    private final String currentBio;
    private final String currentNickname;
    private final Guild guild;
    private final boolean hasAvatarForDisplay;
    private final boolean hasBannerImageForDisplay;
    private final boolean hasMemberAvatarForDisplay;
    private final boolean hasMemberBannerForDisplay;
    private final boolean hasUserAvatarForDisplay;
    private final boolean hasUserBannerForDisplay;
    private final boolean isBioChanged;
    private final boolean isDirty;
    private final boolean isEditingBio;
    private final GuildMember meMember;
    private final String nonDefaultColorPreviewHex;
    private final boolean showBioEditor;
    private final boolean showSaveFab;
    private final MeUser user;
    private final UserProfile userProfile;

    public /* synthetic */ SettingsUserProfileViewModel$ViewState$Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(meUser, guild, guildMember, userProfile, (i & 16) != 0 ? null : nullSerializable, (i & 32) != 0 ? null : nullSerializable2, (i & 64) != 0 ? null : nullSerializable3, (i & 128) != 0 ? null : str, str2, list, z2, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsUserProfileViewModel$ViewState$Loaded copy$default(SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded, MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, Object obj) {
        return settingsUserProfileViewModel$ViewState$Loaded.copy((i & 1) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.user : meUser, (i & 2) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.guild : guild, (i & 4) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.meMember : guildMember, (i & 8) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.userProfile : userProfile, (i & 16) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.currentAvatar : nullSerializable, (i & 32) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.currentBannerImage : nullSerializable2, (i & 64) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.currentBannerColorHex : nullSerializable3, (i & 128) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.currentNickname : str, (i & 256) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.currentBio : str2, (i & 512) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.bioAst : list, (i & 1024) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.isEditingBio : z2, (i & 2048) != 0 ? settingsUserProfileViewModel$ViewState$Loaded.canEditNickname : z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getUser() {
        return this.user;
    }

    public final List<Node<MessageRenderContext>> component10() {
        return this.bioAst;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsEditingBio() {
        return this.isEditingBio;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getCanEditNickname() {
        return this.canEditNickname;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getMeMember() {
        return this.meMember;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public final NullSerializable<String> component5() {
        return this.currentAvatar;
    }

    public final NullSerializable<String> component6() {
        return this.currentBannerImage;
    }

    public final NullSerializable<String> component7() {
        return this.currentBannerColorHex;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCurrentNickname() {
        return this.currentNickname;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCurrentBio() {
        return this.currentBio;
    }

    public final SettingsUserProfileViewModel$ViewState$Loaded copy(MeUser user, Guild guild, GuildMember meMember, UserProfile userProfile, NullSerializable<String> currentAvatar, NullSerializable<String> currentBannerImage, NullSerializable<String> currentBannerColorHex, String currentNickname, String currentBio, List<Node<MessageRenderContext>> bioAst, boolean isEditingBio, boolean canEditNickname) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userProfile, "userProfile");
        return new SettingsUserProfileViewModel$ViewState$Loaded(user, guild, meMember, userProfile, currentAvatar, currentBannerImage, currentBannerColorHex, currentNickname, currentBio, bioAst, isEditingBio, canEditNickname);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            return false;
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) other;
        return m.areEqual(this.user, settingsUserProfileViewModel$ViewState$Loaded.user) && m.areEqual(this.guild, settingsUserProfileViewModel$ViewState$Loaded.guild) && m.areEqual(this.meMember, settingsUserProfileViewModel$ViewState$Loaded.meMember) && m.areEqual(this.userProfile, settingsUserProfileViewModel$ViewState$Loaded.userProfile) && m.areEqual(this.currentAvatar, settingsUserProfileViewModel$ViewState$Loaded.currentAvatar) && m.areEqual(this.currentBannerImage, settingsUserProfileViewModel$ViewState$Loaded.currentBannerImage) && m.areEqual(this.currentBannerColorHex, settingsUserProfileViewModel$ViewState$Loaded.currentBannerColorHex) && m.areEqual(this.currentNickname, settingsUserProfileViewModel$ViewState$Loaded.currentNickname) && m.areEqual(this.currentBio, settingsUserProfileViewModel$ViewState$Loaded.currentBio) && m.areEqual(this.bioAst, settingsUserProfileViewModel$ViewState$Loaded.bioAst) && this.isEditingBio == settingsUserProfileViewModel$ViewState$Loaded.isEditingBio && this.canEditNickname == settingsUserProfileViewModel$ViewState$Loaded.canEditNickname;
    }

    public final List<Node<MessageRenderContext>> getBioAst() {
        return this.bioAst;
    }

    public final boolean getCanEditNickname() {
        return this.canEditNickname;
    }

    public final boolean getCanHaveAnimatedAvatars() {
        return this.canHaveAnimatedAvatars;
    }

    public final NullSerializable<String> getCurrentAvatar() {
        return this.currentAvatar;
    }

    public final NullSerializable<String> getCurrentBannerColorHex() {
        return this.currentBannerColorHex;
    }

    public final NullSerializable<String> getCurrentBannerImage() {
        return this.currentBannerImage;
    }

    public final String getCurrentBio() {
        return this.currentBio;
    }

    public final String getCurrentNickname() {
        return this.currentNickname;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean getHasAvatarForDisplay() {
        return this.hasAvatarForDisplay;
    }

    public final boolean getHasBannerImageForDisplay() {
        return this.hasBannerImageForDisplay;
    }

    public final GuildMember getMeMember() {
        return this.meMember;
    }

    public final String getNonDefaultColorPreviewHex() {
        return this.nonDefaultColorPreviewHex;
    }

    public final boolean getShowBioEditor() {
        return this.showBioEditor;
    }

    public final boolean getShowSaveFab() {
        return this.showSaveFab;
    }

    public final MeUser getUser() {
        return this.user;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    public int hashCode() {
        MeUser meUser = this.user;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        GuildMember guildMember = this.meMember;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        UserProfile userProfile = this.userProfile;
        int iHashCode4 = (iHashCode3 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable = this.currentAvatar;
        int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable2 = this.currentBannerImage;
        int iHashCode6 = (iHashCode5 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable3 = this.currentBannerColorHex;
        int iHashCode7 = (iHashCode6 + (nullSerializable3 != null ? nullSerializable3.hashCode() : 0)) * 31;
        String str = this.currentNickname;
        int iHashCode8 = (iHashCode7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.currentBio;
        int iHashCode9 = (iHashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Node<MessageRenderContext>> list = this.bioAst;
        int iHashCode10 = (iHashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isEditingBio;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode10 + r1) * 31;
        boolean z3 = this.canEditNickname;
        return i + (z3 ? 1 : z3);
    }

    /* JADX INFO: renamed from: isBioChanged, reason: from getter */
    public final boolean getIsBioChanged() {
        return this.isBioChanged;
    }

    /* JADX INFO: renamed from: isDirty, reason: from getter */
    public final boolean getIsDirty() {
        return this.isDirty;
    }

    public final boolean isEditingBio() {
        return this.isEditingBio;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(user=");
        sbU.append(this.user);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", meMember=");
        sbU.append(this.meMember);
        sbU.append(", userProfile=");
        sbU.append(this.userProfile);
        sbU.append(", currentAvatar=");
        sbU.append(this.currentAvatar);
        sbU.append(", currentBannerImage=");
        sbU.append(this.currentBannerImage);
        sbU.append(", currentBannerColorHex=");
        sbU.append(this.currentBannerColorHex);
        sbU.append(", currentNickname=");
        sbU.append(this.currentNickname);
        sbU.append(", currentBio=");
        sbU.append(this.currentBio);
        sbU.append(", bioAst=");
        sbU.append(this.bioAst);
        sbU.append(", isEditingBio=");
        sbU.append(this.isEditingBio);
        sbU.append(", canEditNickname=");
        return a.O(sbU, this.canEditNickname, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    public SettingsUserProfileViewModel$ViewState$Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, NullSerializable<String> nullSerializable3, String str, String str2, List<Node<MessageRenderContext>> list, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        super(null);
        m.checkNotNullParameter(meUser, "user");
        m.checkNotNullParameter(userProfile, "userProfile");
        this.user = meUser;
        this.guild = guild;
        this.meMember = guildMember;
        this.userProfile = userProfile;
        this.currentAvatar = nullSerializable;
        this.currentBannerImage = nullSerializable2;
        this.currentBannerColorHex = nullSerializable3;
        this.currentNickname = str;
        this.currentBio = str2;
        this.bioAst = list;
        this.isEditingBio = z2;
        this.canEditNickname = z3;
        boolean z6 = false;
        if (nullSerializable == null && nullSerializable2 == null && nullSerializable3 == null) {
            String bio = guildMember != null ? "" : "";
            if (!(!m.areEqual(str2, bio))) {
                if (guildMember != null) {
                    String nick = guildMember.getNick();
                    z4 = m.areEqual(nick == null ? "" : nick, str == null ? "" : str) ^ true;
                }
            }
        }
        this.isDirty = z4;
        this.showSaveFab = z4 && !z2;
        this.isBioChanged = !m.areEqual(str2, meUser.getBio());
        if (z2) {
            z5 = true;
        } else {
            if (str2 == null || t.isBlank(str2)) {
                z5 = true;
            } else {
                z5 = false;
            }
        }
        this.showBioEditor = z5;
        this.nonDefaultColorPreviewHex = ((nullSerializable3 instanceof NullSerializable$b) || (nullSerializable3 instanceof NullSerializable$a)) ? nullSerializable3.a() : meUser.getBannerColor();
        boolean z7 = guildMember == null && meUser.getAvatar() != null;
        this.hasUserAvatarForDisplay = z7;
        boolean z8 = guildMember != null && guildMember.hasAvatar();
        this.hasMemberAvatarForDisplay = z8;
        this.hasAvatarForDisplay = !(nullSerializable instanceof NullSerializable$a) && ((nullSerializable instanceof NullSerializable$b) || z7 || z8);
        boolean z9 = guildMember == null && meUser.getBanner() != null;
        this.hasUserBannerForDisplay = z9;
        boolean z10 = guildMember != null && guildMember.hasBanner();
        this.hasMemberBannerForDisplay = z10;
        if (!(nullSerializable2 instanceof NullSerializable$a) && ((nullSerializable2 instanceof NullSerializable$b) || z9 || z10)) {
            z6 = true;
        }
        this.hasBannerImageForDisplay = z6;
        this.canHaveAnimatedAvatars = PremiumUtilsKt.grantsAccessToCustomTagAndAnimatedAvatarFeatures(meUser.getPremiumTier());
    }
}
