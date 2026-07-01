package com.discord.widgets.user.profile;

import b.d.b.a.a;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.streams.StreamContext;
import d0.g;
import d0.g0.t;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfileHeaderViewModel$ViewState$Loaded extends UserProfileHeaderViewModel$ViewState {
    private final boolean allowAnimatedEmojis;
    private final boolean allowAnimationInReducedMotion;

    /* JADX INFO: renamed from: avatarColorId$delegate, reason: from kotlin metadata */
    private final Lazy avatarColorId;
    private final String banner;
    private final String bannerColorHex;
    private final boolean editable;
    private final GuildMember guildMember;

    /* JADX INFO: renamed from: guildMemberColorId$delegate, reason: from kotlin metadata */
    private final Lazy guildMemberColorId;
    private final List<GuildMember> guildMembersForAka;
    private final boolean hasGuildMemberAvatar;
    private final boolean hasNickname;
    private final boolean isMe;
    private final boolean isMeUserPremium;
    private final boolean isMeUserVerified;
    private final boolean isProfileLoaded;
    private final Presence presence;
    private final boolean reducedMotionEnabled;
    private final boolean shouldAnimateBanner;
    private final boolean shouldShowGIFTag;
    private final boolean showAkas;
    private final boolean showMediumAvatar;
    private final boolean showPresence;
    private final boolean showSmallAvatar;
    private final StreamContext streamContext;
    private final User user;
    private final UserProfile userProfile;

    public /* synthetic */ UserProfileHeaderViewModel$ViewState$Loaded(User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, str2, (i & 8) != 0 ? null : guildMember, (i & 16) != 0 ? n.emptyList() : list, (i & 32) != 0 ? null : presence, (i & 64) != 0 ? null : streamContext, (i & 128) != 0 ? StoreUserProfile.Companion.getEMPTY_PROFILE() : userProfile, z2, z3, (i & 1024) != 0 ? false : z4, z5, (i & 4096) != 0 ? false : z6, (i & 8192) != 0 ? false : z7, (i & 16384) != 0 ? false : z8, (i & 32768) != 0 ? false : z9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserProfileHeaderViewModel$ViewState$Loaded copy$default(UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded, User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, Object obj) {
        return userProfileHeaderViewModel$ViewState$Loaded.copy((i & 1) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.user : user, (i & 2) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.banner : str, (i & 4) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.bannerColorHex : str2, (i & 8) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.guildMember : guildMember, (i & 16) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.guildMembersForAka : list, (i & 32) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.presence : presence, (i & 64) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.streamContext : streamContext, (i & 128) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.userProfile : userProfile, (i & 256) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.isMeUserPremium : z2, (i & 512) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.isMeUserVerified : z3, (i & 1024) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.allowAnimatedEmojis : z4, (i & 2048) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.showPresence : z5, (i & 4096) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.editable : z6, (i & 8192) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.reducedMotionEnabled : z7, (i & 16384) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.allowAnimationInReducedMotion : z8, (i & 32768) != 0 ? userProfileHeaderViewModel$ViewState$Loaded.isMe : z9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsMeUserVerified() {
        return this.isMeUserVerified;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShowPresence() {
        return this.showPresence;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getEditable() {
        return this.editable;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getAllowAnimationInReducedMotion() {
        return this.allowAnimationInReducedMotion;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBannerColorHex() {
        return this.bannerColorHex;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final List<GuildMember> component5() {
        return this.guildMembersForAka;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsMeUserPremium() {
        return this.isMeUserPremium;
    }

    public final UserProfileHeaderViewModel$ViewState$Loaded copy(User user, String banner, String bannerColorHex, GuildMember guildMember, List<GuildMember> guildMembersForAka, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean isMeUserPremium, boolean isMeUserVerified, boolean allowAnimatedEmojis, boolean showPresence, boolean editable, boolean reducedMotionEnabled, boolean allowAnimationInReducedMotion, boolean isMe) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(guildMembersForAka, "guildMembersForAka");
        m.checkNotNullParameter(userProfile, "userProfile");
        return new UserProfileHeaderViewModel$ViewState$Loaded(user, banner, bannerColorHex, guildMember, guildMembersForAka, presence, streamContext, userProfile, isMeUserPremium, isMeUserVerified, allowAnimatedEmojis, showPresence, editable, reducedMotionEnabled, allowAnimationInReducedMotion, isMe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileHeaderViewModel$ViewState$Loaded)) {
            return false;
        }
        UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded = (UserProfileHeaderViewModel$ViewState$Loaded) other;
        return m.areEqual(this.user, userProfileHeaderViewModel$ViewState$Loaded.user) && m.areEqual(this.banner, userProfileHeaderViewModel$ViewState$Loaded.banner) && m.areEqual(this.bannerColorHex, userProfileHeaderViewModel$ViewState$Loaded.bannerColorHex) && m.areEqual(this.guildMember, userProfileHeaderViewModel$ViewState$Loaded.guildMember) && m.areEqual(this.guildMembersForAka, userProfileHeaderViewModel$ViewState$Loaded.guildMembersForAka) && m.areEqual(this.presence, userProfileHeaderViewModel$ViewState$Loaded.presence) && m.areEqual(this.streamContext, userProfileHeaderViewModel$ViewState$Loaded.streamContext) && m.areEqual(this.userProfile, userProfileHeaderViewModel$ViewState$Loaded.userProfile) && this.isMeUserPremium == userProfileHeaderViewModel$ViewState$Loaded.isMeUserPremium && this.isMeUserVerified == userProfileHeaderViewModel$ViewState$Loaded.isMeUserVerified && this.allowAnimatedEmojis == userProfileHeaderViewModel$ViewState$Loaded.allowAnimatedEmojis && this.showPresence == userProfileHeaderViewModel$ViewState$Loaded.showPresence && this.editable == userProfileHeaderViewModel$ViewState$Loaded.editable && this.reducedMotionEnabled == userProfileHeaderViewModel$ViewState$Loaded.reducedMotionEnabled && this.allowAnimationInReducedMotion == userProfileHeaderViewModel$ViewState$Loaded.allowAnimationInReducedMotion && this.isMe == userProfileHeaderViewModel$ViewState$Loaded.isMe;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final boolean getAllowAnimationInReducedMotion() {
        return this.allowAnimationInReducedMotion;
    }

    public final String getAvatarColorId() {
        return (String) this.avatarColorId.getValue();
    }

    public final String getBanner() {
        return this.banner;
    }

    public final String getBannerColorHex() {
        return this.bannerColorHex;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getGuildMemberColorId() {
        return (String) this.guildMemberColorId.getValue();
    }

    public final List<GuildMember> getGuildMembersForAka() {
        return this.guildMembersForAka;
    }

    public final boolean getHasGuildMemberAvatar() {
        return this.hasGuildMemberAvatar;
    }

    public final boolean getHasNickname() {
        return this.hasNickname;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    public final boolean getShouldAnimateBanner() {
        return this.shouldAnimateBanner;
    }

    public final boolean getShouldShowGIFTag() {
        return this.shouldShowGIFTag;
    }

    public final boolean getShowAkas() {
        return this.showAkas;
    }

    public final boolean getShowMediumAvatar() {
        return this.showMediumAvatar;
    }

    public final boolean getShowPresence() {
        return this.showPresence;
    }

    public final boolean getShowSmallAvatar() {
        return this.showSmallAvatar;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public final User getUser() {
        return this.user;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        String str = this.banner;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bannerColorHex;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        List<GuildMember> list = this.guildMembersForAka;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Presence presence = this.presence;
        int iHashCode6 = (iHashCode5 + (presence != null ? presence.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        UserProfile userProfile = this.userProfile;
        int iHashCode8 = (iHashCode7 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
        boolean z2 = this.isMeUserPremium;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode8 + r1) * 31;
        boolean z3 = this.isMeUserVerified;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.allowAnimatedEmojis;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.showPresence;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.editable;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.reducedMotionEnabled;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.allowAnimationInReducedMotion;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i7 = (i6 + r7) * 31;
        boolean z9 = this.isMe;
        return i7 + (z9 ? 1 : z9);
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final boolean isMeUserPremium() {
        return this.isMeUserPremium;
    }

    public final boolean isMeUserVerified() {
        return this.isMeUserVerified;
    }

    /* JADX INFO: renamed from: isProfileLoaded, reason: from getter */
    public final boolean getIsProfileLoaded() {
        return this.isProfileLoaded;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(user=");
        sbU.append(this.user);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", bannerColorHex=");
        sbU.append(this.bannerColorHex);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", guildMembersForAka=");
        sbU.append(this.guildMembersForAka);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(", userProfile=");
        sbU.append(this.userProfile);
        sbU.append(", isMeUserPremium=");
        sbU.append(this.isMeUserPremium);
        sbU.append(", isMeUserVerified=");
        sbU.append(this.isMeUserVerified);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", showPresence=");
        sbU.append(this.showPresence);
        sbU.append(", editable=");
        sbU.append(this.editable);
        sbU.append(", reducedMotionEnabled=");
        sbU.append(this.reducedMotionEnabled);
        sbU.append(", allowAnimationInReducedMotion=");
        sbU.append(this.allowAnimationInReducedMotion);
        sbU.append(", isMe=");
        return a.O(sbU, this.isMe, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel$ViewState$Loaded(User user, String str, String str2, GuildMember guildMember, List<GuildMember> list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        String nick;
        super(null);
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(list, "guildMembersForAka");
        m.checkNotNullParameter(userProfile, "userProfile");
        this.user = user;
        this.banner = str;
        this.bannerColorHex = str2;
        this.guildMember = guildMember;
        this.guildMembersForAka = list;
        this.presence = presence;
        this.streamContext = streamContext;
        this.userProfile = userProfile;
        this.isMeUserPremium = z2;
        this.isMeUserVerified = z3;
        this.allowAnimatedEmojis = z4;
        this.showPresence = z5;
        this.editable = z6;
        this.reducedMotionEnabled = z7;
        this.allowAnimationInReducedMotion = z8;
        this.isMe = z9;
        boolean z10 = false;
        boolean z11 = guildMember != null && guildMember.hasAvatar();
        this.hasGuildMemberAvatar = z11;
        boolean z12 = !t.isBlank((guildMember == null || (nick = guildMember.getNick()) == null) ? "" : nick);
        this.hasNickname = z12;
        this.showMediumAvatar = z11 && !z12;
        this.showSmallAvatar = z11 && z12;
        this.shouldAnimateBanner = !z7 || z8;
        this.shouldShowGIFTag = z7 && !z8 && str != null && t.startsWith$default(str, "a_", false, 2, null);
        this.isProfileLoaded = !m.areEqual(userProfile, StoreUserProfile.Companion.getEMPTY_PROFILE());
        this.avatarColorId = g.lazy(new UserProfileHeaderViewModel$ViewState$Loaded$avatarColorId$2(this));
        this.guildMemberColorId = g.lazy(new UserProfileHeaderViewModel$ViewState$Loaded$guildMemberColorId$2(this));
        if ((!list.isEmpty()) && !z9) {
            z10 = true;
        }
        this.showAkas = z10;
    }
}
