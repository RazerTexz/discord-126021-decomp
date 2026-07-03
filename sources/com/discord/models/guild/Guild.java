package com.discord.models.guild;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.guilds.GuildUtilsKt;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Guild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Guild {
    private final Long afkChannelId;
    private final int afkTimeout;
    private final int approximatePresenceCount;
    private final String banner;
    private final int defaultMessageNotifications;
    private final String description;
    private final List<GuildEmoji> emojis;
    private final GuildExplicitContentFilter explicitContentFilter;
    private final Set<GuildFeature> features;
    private final GuildHubType hubType;
    private final String icon;
    private final long id;
    private final String joinedAt;
    private final GuildMaxVideoChannelUsers maxVideoChannelUsers;
    private final int memberCount;
    private final int mfaLevel;
    private final String name;
    private final boolean nsfw;
    private final long ownerId;
    private final String preferredLocale;
    private final int premiumSubscriptionCount;
    private final int premiumTier;
    private final Long publicUpdatesChannelId;
    private final String region;
    private final List<GuildRole> roles;
    private final Long rulesChannelId;
    private final String shortName;
    private final String splash;
    private final List<Sticker> stickers;
    private final int systemChannelFlags;
    private final Long systemChannelId;
    private final boolean unavailable;
    private final String vanityUrlCode;
    private final GuildVerificationLevel verificationLevel;
    private final GuildWelcomeScreen welcomeScreen;

    public Guild() {
        this(null, null, null, null, null, 0, 0L, null, 0L, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, false, null, -1, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Guild(List<GuildRole> list, List<GuildEmoji> list2, List<Sticker> list3, String str, String str2, int i, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, boolean z2, int i2, int i3, Long l, Long l2, Set<? extends GuildFeature> set, int i4, String str5, String str6, int i5, int i6, int i7, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i8, boolean z3, GuildHubType guildHubType) {
        C12238m.checkNotNullParameter(list, "roles");
        C12238m.checkNotNullParameter(list2, "emojis");
        C12238m.checkNotNullParameter(list3, "stickers");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(guildVerificationLevel, "verificationLevel");
        C12238m.checkNotNullParameter(guildExplicitContentFilter, "explicitContentFilter");
        C12238m.checkNotNullParameter(set, "features");
        C12238m.checkNotNullParameter(guildMaxVideoChannelUsers, "maxVideoChannelUsers");
        this.roles = list;
        this.emojis = list2;
        this.stickers = list3;
        this.name = str;
        this.description = str2;
        this.defaultMessageNotifications = i;
        this.id = j;
        this.region = str3;
        this.ownerId = j2;
        this.icon = str4;
        this.verificationLevel = guildVerificationLevel;
        this.explicitContentFilter = guildExplicitContentFilter;
        this.unavailable = z2;
        this.mfaLevel = i2;
        this.afkTimeout = i3;
        this.afkChannelId = l;
        this.systemChannelId = l2;
        this.features = set;
        this.memberCount = i4;
        this.banner = str5;
        this.splash = str6;
        this.premiumTier = i5;
        this.premiumSubscriptionCount = i6;
        this.systemChannelFlags = i7;
        this.joinedAt = str7;
        this.rulesChannelId = l3;
        this.publicUpdatesChannelId = l4;
        this.preferredLocale = str8;
        this.welcomeScreen = guildWelcomeScreen;
        this.maxVideoChannelUsers = guildMaxVideoChannelUsers;
        this.vanityUrlCode = str9;
        this.approximatePresenceCount = i8;
        this.nsfw = z3;
        this.hubType = guildHubType;
        this.shortName = GuildUtilsKt.computeShortName(str);
    }

    public final boolean canHaveAnimatedBanner() {
        return hasFeature(GuildFeature.ANIMATED_BANNER);
    }

    public final boolean canHaveBanner() {
        return hasFeature(GuildFeature.BANNER) || hasFeature(GuildFeature.VERIFIED) || this.premiumTier >= 2;
    }

    public final boolean canHaveSplash() {
        return hasFeature(GuildFeature.INVITE_SPLASH) || hasFeature(GuildFeature.VERIFIED) || this.premiumTier >= 1;
    }

    public final boolean canHaveVanityURL() {
        return this.features.contains(GuildFeature.VANITY_URL) || this.premiumTier >= 3;
    }

    public final List<GuildRole> component1() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final GuildVerificationLevel getVerificationLevel() {
        return this.verificationLevel;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final GuildExplicitContentFilter getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getUnavailable() {
        return this.unavailable;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getMfaLevel() {
        return this.mfaLevel;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getAfkTimeout() {
        return this.afkTimeout;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Long getAfkChannelId() {
        return this.afkChannelId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Long getSystemChannelId() {
        return this.systemChannelId;
    }

    public final Set<GuildFeature> component18() {
        return this.features;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    public final List<GuildEmoji> component2() {
        return this.emojis;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getPremiumTier() {
        return this.premiumTier;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final int getSystemChannelFlags() {
        return this.systemChannelFlags;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getJoinedAt() {
        return this.joinedAt;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Long getPublicUpdatesChannelId() {
        return this.publicUpdatesChannelId;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getPreferredLocale() {
        return this.preferredLocale;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final GuildWelcomeScreen getWelcomeScreen() {
        return this.welcomeScreen;
    }

    public final List<Sticker> component3() {
        return this.stickers;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final GuildMaxVideoChannelUsers getMaxVideoChannelUsers() {
        return this.maxVideoChannelUsers;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getVanityUrlCode() {
        return this.vanityUrlCode;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final int getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final boolean getNsfw() {
        return this.nsfw;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final GuildHubType getHubType() {
        return this.hubType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDefaultMessageNotifications() {
        return this.defaultMessageNotifications;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getOwnerId() {
        return this.ownerId;
    }

    public final Guild copy(List<GuildRole> roles, List<GuildEmoji> emojis, List<Sticker> stickers, String name, String description, int defaultMessageNotifications, long id2, String region, long ownerId, String icon, GuildVerificationLevel verificationLevel, GuildExplicitContentFilter explicitContentFilter, boolean unavailable, int mfaLevel, int afkTimeout, Long afkChannelId, Long systemChannelId, Set<? extends GuildFeature> features, int memberCount, String banner, String splash, int premiumTier, int premiumSubscriptionCount, int systemChannelFlags, String joinedAt, Long rulesChannelId, Long publicUpdatesChannelId, String preferredLocale, GuildWelcomeScreen welcomeScreen, GuildMaxVideoChannelUsers maxVideoChannelUsers, String vanityUrlCode, int approximatePresenceCount, boolean nsfw, GuildHubType hubType) {
        C12238m.checkNotNullParameter(roles, "roles");
        C12238m.checkNotNullParameter(emojis, "emojis");
        C12238m.checkNotNullParameter(stickers, "stickers");
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(verificationLevel, "verificationLevel");
        C12238m.checkNotNullParameter(explicitContentFilter, "explicitContentFilter");
        C12238m.checkNotNullParameter(features, "features");
        C12238m.checkNotNullParameter(maxVideoChannelUsers, "maxVideoChannelUsers");
        return new Guild(roles, emojis, stickers, name, description, defaultMessageNotifications, id2, region, ownerId, icon, verificationLevel, explicitContentFilter, unavailable, mfaLevel, afkTimeout, afkChannelId, systemChannelId, features, memberCount, banner, splash, premiumTier, premiumSubscriptionCount, systemChannelFlags, joinedAt, rulesChannelId, publicUpdatesChannelId, preferredLocale, welcomeScreen, maxVideoChannelUsers, vanityUrlCode, approximatePresenceCount, nsfw, hubType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Guild)) {
            return false;
        }
        Guild guild = (Guild) other;
        return C12238m.areEqual(this.roles, guild.roles) && C12238m.areEqual(this.emojis, guild.emojis) && C12238m.areEqual(this.stickers, guild.stickers) && C12238m.areEqual(this.name, guild.name) && C12238m.areEqual(this.description, guild.description) && this.defaultMessageNotifications == guild.defaultMessageNotifications && this.id == guild.id && C12238m.areEqual(this.region, guild.region) && this.ownerId == guild.ownerId && C12238m.areEqual(this.icon, guild.icon) && C12238m.areEqual(this.verificationLevel, guild.verificationLevel) && C12238m.areEqual(this.explicitContentFilter, guild.explicitContentFilter) && this.unavailable == guild.unavailable && this.mfaLevel == guild.mfaLevel && this.afkTimeout == guild.afkTimeout && C12238m.areEqual(this.afkChannelId, guild.afkChannelId) && C12238m.areEqual(this.systemChannelId, guild.systemChannelId) && C12238m.areEqual(this.features, guild.features) && this.memberCount == guild.memberCount && C12238m.areEqual(this.banner, guild.banner) && C12238m.areEqual(this.splash, guild.splash) && this.premiumTier == guild.premiumTier && this.premiumSubscriptionCount == guild.premiumSubscriptionCount && this.systemChannelFlags == guild.systemChannelFlags && C12238m.areEqual(this.joinedAt, guild.joinedAt) && C12238m.areEqual(this.rulesChannelId, guild.rulesChannelId) && C12238m.areEqual(this.publicUpdatesChannelId, guild.publicUpdatesChannelId) && C12238m.areEqual(this.preferredLocale, guild.preferredLocale) && C12238m.areEqual(this.welcomeScreen, guild.welcomeScreen) && C12238m.areEqual(this.maxVideoChannelUsers, guild.maxVideoChannelUsers) && C12238m.areEqual(this.vanityUrlCode, guild.vanityUrlCode) && this.approximatePresenceCount == guild.approximatePresenceCount && this.nsfw == guild.nsfw && C12238m.areEqual(this.hubType, guild.hubType);
    }

    public final Long getAfkChannelId() {
        return this.afkChannelId;
    }

    public final int getAfkTimeout() {
        return this.afkTimeout;
    }

    public final int getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    public final String getBanner() {
        return this.banner;
    }

    public final int getDefaultMessageNotifications() {
        return this.defaultMessageNotifications;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<GuildEmoji> getEmojis() {
        return this.emojis;
    }

    public final GuildExplicitContentFilter getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    public final Set<GuildFeature> getFeatures() {
        return this.features;
    }

    public final GuildHubType getHubType() {
        return this.hubType;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    public final String getJoinedAt() {
        return this.joinedAt;
    }

    public final GuildMaxVideoChannelUsers getMaxVideoChannelUsers() {
        return this.maxVideoChannelUsers;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final int getMfaLevel() {
        return this.mfaLevel;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNsfw() {
        return this.nsfw;
    }

    public final long getOwnerId() {
        return this.ownerId;
    }

    public final String getPreferredLocale() {
        return this.preferredLocale;
    }

    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    public final int getPremiumTier() {
        return this.premiumTier;
    }

    public final Long getPublicUpdatesChannelId() {
        return this.publicUpdatesChannelId;
    }

    public final String getRegion() {
        return this.region;
    }

    public final List<GuildRole> getRoles() {
        return this.roles;
    }

    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final String getSplash() {
        return this.splash;
    }

    public final List<Sticker> getStickers() {
        return this.stickers;
    }

    public final int getSystemChannelFlags() {
        return this.systemChannelFlags;
    }

    public final Long getSystemChannelId() {
        return this.systemChannelId;
    }

    public final boolean getUnavailable() {
        return this.unavailable;
    }

    public final String getVanityUrlCode() {
        return this.vanityUrlCode;
    }

    public final GuildVerificationLevel getVerificationLevel() {
        return this.verificationLevel;
    }

    public final GuildWelcomeScreen getWelcomeScreen() {
        return this.welcomeScreen;
    }

    public final boolean hasFeature(GuildFeature feature) {
        C12238m.checkNotNullParameter(feature, "feature");
        return this.features.contains(feature);
    }

    public final boolean hasIcon() {
        String str = this.icon;
        return !(str == null || str.length() == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        List<GuildRole> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<GuildEmoji> list2 = this.emojis;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Sticker> list3 = this.stickers;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iM3a = (C0002b.m3a(this.id) + ((((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.defaultMessageNotifications) * 31)) * 31;
        String str3 = this.region;
        int iM3a2 = (C0002b.m3a(this.ownerId) + ((iM3a + (str3 != null ? str3.hashCode() : 0)) * 31)) * 31;
        String str4 = this.icon;
        int iHashCode5 = (iM3a2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        GuildVerificationLevel guildVerificationLevel = this.verificationLevel;
        int iHashCode6 = (iHashCode5 + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
        GuildExplicitContentFilter guildExplicitContentFilter = this.explicitContentFilter;
        int iHashCode7 = (iHashCode6 + (guildExplicitContentFilter != null ? guildExplicitContentFilter.hashCode() : 0)) * 31;
        boolean z2 = this.unavailable;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (((((iHashCode7 + r2) * 31) + this.mfaLevel) * 31) + this.afkTimeout) * 31;
        Long l = this.afkChannelId;
        int iHashCode8 = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.systemChannelId;
        int iHashCode9 = (iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Set<GuildFeature> set = this.features;
        int iHashCode10 = (((iHashCode9 + (set != null ? set.hashCode() : 0)) * 31) + this.memberCount) * 31;
        String str5 = this.banner;
        int iHashCode11 = (iHashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.splash;
        int iHashCode12 = (((((((iHashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.premiumTier) * 31) + this.premiumSubscriptionCount) * 31) + this.systemChannelFlags) * 31;
        String str7 = this.joinedAt;
        int iHashCode13 = (iHashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Long l3 = this.rulesChannelId;
        int iHashCode14 = (iHashCode13 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.publicUpdatesChannelId;
        int iHashCode15 = (iHashCode14 + (l4 != null ? l4.hashCode() : 0)) * 31;
        String str8 = this.preferredLocale;
        int iHashCode16 = (iHashCode15 + (str8 != null ? str8.hashCode() : 0)) * 31;
        GuildWelcomeScreen guildWelcomeScreen = this.welcomeScreen;
        int iHashCode17 = (iHashCode16 + (guildWelcomeScreen != null ? guildWelcomeScreen.hashCode() : 0)) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.maxVideoChannelUsers;
        int iHashCode18 = (iHashCode17 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        String str9 = this.vanityUrlCode;
        int iHashCode19 = (((iHashCode18 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.approximatePresenceCount) * 31;
        boolean z3 = this.nsfw;
        int i2 = (iHashCode19 + (z3 ? 1 : z3)) * 31;
        GuildHubType guildHubType = this.hubType;
        return i2 + (guildHubType != null ? guildHubType.hashCode() : 0);
    }

    public final boolean isHub() {
        return hasFeature(GuildFeature.HUB);
    }

    public final boolean isOwner(long userId) {
        return this.ownerId == userId;
    }

    public final Guild merge(com.discord.api.guild.Guild apiGuild) {
        C12238m.checkNotNullParameter(apiGuild, "apiGuild");
        List listEmptyList = C12147n.emptyList();
        List<GuildEmoji> listM7864k = apiGuild.m7864k();
        if (listM7864k == null) {
            listM7864k = C12147n.emptyList();
        }
        List list = null;
        String strM7877x = apiGuild.getName();
        String strM7862i = apiGuild.getDescription();
        if (strM7862i == null) {
            strM7862i = this.description;
        }
        Integer numM7861h = apiGuild.getDefaultMessageNotifications();
        int iIntValue = numM7861h != null ? numM7861h.intValue() : this.defaultMessageNotifications;
        long jM7871r = apiGuild.getId() != 0 ? apiGuild.getId() : this.id;
        String strM7841F = apiGuild.getRegion();
        if (strM7841F == null) {
            strM7841F = this.region;
        }
        long jM7879z = apiGuild.getOwnerId() != 0 ? apiGuild.getOwnerId() : this.ownerId;
        String strM7870q = apiGuild.getIcon();
        if (strM7870q == null) {
            strM7870q = this.icon;
        }
        String str = strM7870q;
        GuildVerificationLevel guildVerificationLevelM7852Q = apiGuild.getVerificationLevel();
        if (guildVerificationLevelM7852Q == null) {
            guildVerificationLevelM7852Q = this.verificationLevel;
        }
        GuildVerificationLevel guildVerificationLevel = guildVerificationLevelM7852Q;
        GuildExplicitContentFilter guildExplicitContentFilterM7865l = apiGuild.getExplicitContentFilter();
        if (guildExplicitContentFilterM7865l == null) {
            guildExplicitContentFilterM7865l = this.explicitContentFilter;
        }
        GuildExplicitContentFilter guildExplicitContentFilter = guildExplicitContentFilterM7865l;
        boolean zM7850O = apiGuild.getUnavailable();
        int iM7876w = apiGuild.getMfaLevel();
        int iM7856c = apiGuild.getAfkTimeout() != 0 ? apiGuild.getAfkTimeout() : this.afkTimeout;
        Long lM7855b = apiGuild.getAfkChannelId();
        Long lM7848M = apiGuild.getSystemChannelId();
        Set set = C12163u.toSet(apiGuild.m7866m());
        int i = 0;
        String strM7858e = apiGuild.getBanner();
        String strM7844I = apiGuild.getSplash();
        if (strM7844I == null) {
            strM7844I = this.splash;
        }
        String str2 = strM7844I;
        int iM7838C = apiGuild.getPremiumTier();
        int iM7837B = apiGuild.getPremiumSubscriptionCount();
        int iM7847L = apiGuild.getSystemChannelFlags();
        String strM7872s = apiGuild.getJoinedAt();
        if (strM7872s == null) {
            strM7872s = this.joinedAt;
        }
        String str3 = strM7872s;
        Long lM7843H = apiGuild.getRulesChannelId();
        if (lM7843H == null) {
            lM7843H = this.rulesChannelId;
        }
        Long l = lM7843H;
        Long lM7840E = apiGuild.getPublicUpdatesChannelId();
        if (lM7840E == null) {
            lM7840E = this.publicUpdatesChannelId;
        }
        Long l2 = lM7840E;
        String strM7836A = apiGuild.getPreferredLocale();
        if (strM7836A == null) {
            strM7836A = this.preferredLocale;
        }
        String str4 = strM7836A;
        GuildWelcomeScreen guildWelcomeScreenM7854S = apiGuild.getWelcomeScreen();
        if (guildWelcomeScreenM7854S == null) {
            guildWelcomeScreenM7854S = this.welcomeScreen;
        }
        GuildWelcomeScreen guildWelcomeScreen = guildWelcomeScreenM7854S;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsersM7873t = apiGuild.getMaxVideoChannelUsers();
        if (guildMaxVideoChannelUsersM7873t == null) {
            guildMaxVideoChannelUsersM7873t = this.maxVideoChannelUsers;
        }
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = guildMaxVideoChannelUsersM7873t;
        String strM7851P = apiGuild.getVanityUrlCode();
        if (strM7851P == null) {
            strM7851P = this.vanityUrlCode;
        }
        return new Guild(listEmptyList, listM7864k, list, strM7877x, strM7862i, iIntValue, jM7871r, strM7841F, jM7879z, str, guildVerificationLevel, guildExplicitContentFilter, zM7850O, iM7876w, iM7856c, lM7855b, lM7848M, set, i, strM7858e, str2, iM7838C, iM7837B, iM7847L, str3, l, l2, str4, guildWelcomeScreen, guildMaxVideoChannelUsers, strM7851P, apiGuild.getApproximatePresenceCount() != 0 ? apiGuild.getApproximatePresenceCount() : this.approximatePresenceCount, apiGuild.getNsfw(), apiGuild.getHubType(), 4, 0, null);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Guild(roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", emojis=");
        sbM833U.append(this.emojis);
        sbM833U.append(", stickers=");
        sbM833U.append(this.stickers);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", defaultMessageNotifications=");
        sbM833U.append(this.defaultMessageNotifications);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", region=");
        sbM833U.append(this.region);
        sbM833U.append(", ownerId=");
        sbM833U.append(this.ownerId);
        sbM833U.append(", icon=");
        sbM833U.append(this.icon);
        sbM833U.append(", verificationLevel=");
        sbM833U.append(this.verificationLevel);
        sbM833U.append(", explicitContentFilter=");
        sbM833U.append(this.explicitContentFilter);
        sbM833U.append(", unavailable=");
        sbM833U.append(this.unavailable);
        sbM833U.append(", mfaLevel=");
        sbM833U.append(this.mfaLevel);
        sbM833U.append(", afkTimeout=");
        sbM833U.append(this.afkTimeout);
        sbM833U.append(", afkChannelId=");
        sbM833U.append(this.afkChannelId);
        sbM833U.append(", systemChannelId=");
        sbM833U.append(this.systemChannelId);
        sbM833U.append(", features=");
        sbM833U.append(this.features);
        sbM833U.append(", memberCount=");
        sbM833U.append(this.memberCount);
        sbM833U.append(", banner=");
        sbM833U.append(this.banner);
        sbM833U.append(", splash=");
        sbM833U.append(this.splash);
        sbM833U.append(", premiumTier=");
        sbM833U.append(this.premiumTier);
        sbM833U.append(", premiumSubscriptionCount=");
        sbM833U.append(this.premiumSubscriptionCount);
        sbM833U.append(", systemChannelFlags=");
        sbM833U.append(this.systemChannelFlags);
        sbM833U.append(", joinedAt=");
        sbM833U.append(this.joinedAt);
        sbM833U.append(", rulesChannelId=");
        sbM833U.append(this.rulesChannelId);
        sbM833U.append(", publicUpdatesChannelId=");
        sbM833U.append(this.publicUpdatesChannelId);
        sbM833U.append(", preferredLocale=");
        sbM833U.append(this.preferredLocale);
        sbM833U.append(", welcomeScreen=");
        sbM833U.append(this.welcomeScreen);
        sbM833U.append(", maxVideoChannelUsers=");
        sbM833U.append(this.maxVideoChannelUsers);
        sbM833U.append(", vanityUrlCode=");
        sbM833U.append(this.vanityUrlCode);
        sbM833U.append(", approximatePresenceCount=");
        sbM833U.append(this.approximatePresenceCount);
        sbM833U.append(", nsfw=");
        sbM833U.append(this.nsfw);
        sbM833U.append(", hubType=");
        sbM833U.append(this.hubType);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ Guild(List list, List list2, List list3, String str, String str2, int i, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, boolean z2, int i2, int i3, Long l, Long l2, Set set, int i4, String str5, String str6, int i5, int i6, int i7, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i8, boolean z3, GuildHubType guildHubType, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? C12147n.emptyList() : list, (i9 & 2) != 0 ? C12147n.emptyList() : list2, (i9 & 4) != 0 ? C12147n.emptyList() : list3, (i9 & 8) != 0 ? "" : str, (i9 & 16) != 0 ? null : str2, (i9 & 32) != 0 ? ModelNotificationSettings.FREQUENCY_ALL : i, (i9 & 64) != 0 ? 0L : j, (i9 & 128) != 0 ? null : str3, (i9 & 256) == 0 ? j2 : 0L, (i9 & 512) != 0 ? null : str4, (i9 & 1024) != 0 ? GuildVerificationLevel.NONE : guildVerificationLevel, (i9 & 2048) != 0 ? GuildExplicitContentFilter.NONE : guildExplicitContentFilter, (i9 & 4096) != 0 ? false : z2, (i9 & 8192) != 0 ? 0 : i2, (i9 & 16384) != 0 ? 0 : i3, (i9 & 32768) != 0 ? null : l, (i9 & 65536) != 0 ? null : l2, (i9 & 131072) != 0 ? C12148n0.emptySet() : set, (i9 & 262144) != 0 ? 0 : i4, (i9 & 524288) != 0 ? null : str5, (i9 & 1048576) != 0 ? null : str6, (i9 & 2097152) != 0 ? 0 : i5, (i9 & 4194304) != 0 ? 0 : i6, (i9 & 8388608) != 0 ? 0 : i7, (i9 & 16777216) != 0 ? null : str7, (i9 & 33554432) != 0 ? null : l3, (i9 & 67108864) != 0 ? null : l4, (i9 & 134217728) != 0 ? null : str8, (i9 & 268435456) != 0 ? null : guildWelcomeScreen, (i9 & 536870912) != 0 ? GuildMaxVideoChannelUsers.Unlimited.INSTANCE : guildMaxVideoChannelUsers, (i9 & BasicMeasure.EXACTLY) != 0 ? null : str9, (i9 & Integer.MIN_VALUE) != 0 ? 0 : i8, (i10 & 1) == 0 ? z3 : false, (i10 & 2) != 0 ? null : guildHubType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Guild(com.discord.api.guild.Guild guild) {
        C12238m.checkNotNullParameter(guild, "apiGuild");
        List<GuildRole> listM7842G = guild.m7842G();
        List<GuildRole> listEmptyList = listM7842G == null ? C12147n.emptyList() : listM7842G;
        List<GuildEmoji> listM7864k = guild.m7864k();
        List<GuildEmoji> listEmptyList2 = listM7864k == null ? C12147n.emptyList() : listM7864k;
        List list = null;
        String strM7877x = guild.getName();
        String strM7862i = guild.getDescription();
        Integer numM7861h = guild.getDefaultMessageNotifications();
        int iIntValue = numM7861h != null ? numM7861h.intValue() : ModelNotificationSettings.FREQUENCY_ALL;
        long jM7871r = guild.getId();
        String strM7841F = guild.getRegion();
        long jM7879z = guild.getOwnerId();
        String strM7870q = guild.getIcon();
        GuildVerificationLevel guildVerificationLevelM7852Q = guild.getVerificationLevel();
        GuildVerificationLevel guildVerificationLevel = guildVerificationLevelM7852Q == null ? GuildVerificationLevel.NONE : guildVerificationLevelM7852Q;
        GuildExplicitContentFilter guildExplicitContentFilterM7865l = guild.getExplicitContentFilter();
        GuildExplicitContentFilter guildExplicitContentFilter = guildExplicitContentFilterM7865l == null ? GuildExplicitContentFilter.NONE : guildExplicitContentFilterM7865l;
        boolean zM7850O = guild.getUnavailable();
        int iM7876w = guild.getMfaLevel();
        int iM7856c = guild.getAfkTimeout();
        Long lM7855b = guild.getAfkChannelId();
        Long lM7848M = guild.getSystemChannelId();
        Set set = C12163u.toSet(guild.m7866m());
        int iM7874u = guild.getMemberCount();
        String strM7858e = guild.getBanner();
        String strM7844I = guild.getSplash();
        int iM7838C = guild.getPremiumTier();
        int iM7837B = guild.getPremiumSubscriptionCount();
        int iM7847L = guild.getSystemChannelFlags();
        String strM7872s = guild.getJoinedAt();
        Long lM7843H = guild.getRulesChannelId();
        Long lM7840E = guild.getPublicUpdatesChannelId();
        String strM7836A = guild.getPreferredLocale();
        GuildWelcomeScreen guildWelcomeScreenM7854S = guild.getWelcomeScreen();
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsersM7873t = guild.getMaxVideoChannelUsers();
        this(listEmptyList, listEmptyList2, list, strM7877x, strM7862i, iIntValue, jM7871r, strM7841F, jM7879z, strM7870q, guildVerificationLevel, guildExplicitContentFilter, zM7850O, iM7876w, iM7856c, lM7855b, lM7848M, set, iM7874u, strM7858e, strM7844I, iM7838C, iM7837B, iM7847L, strM7872s, lM7843H, lM7840E, strM7836A, guildWelcomeScreenM7854S, guildMaxVideoChannelUsersM7873t == null ? GuildMaxVideoChannelUsers.Unlimited.INSTANCE : guildMaxVideoChannelUsersM7873t, guild.getVanityUrlCode(), guild.getApproximatePresenceCount(), guild.getNsfw(), guild.getHubType(), 4, 0, null);
    }
}
