package com.discord.restapi;

import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UpdateGuild {
    public static final RestAPIParams$UpdateGuild$Companion Companion = new RestAPIParams$UpdateGuild$Companion(null);
    private final Long afkChannelId;
    private final Integer afkTimeout;
    private final String banner;
    private final Integer defaultMessageNotifications;
    private final GuildExplicitContentFilter explicitContentFilter;
    private final List<GuildFeature> features;
    private final String icon;
    private final String name;
    private final String preferredLocale;
    private final Long publicUpdatesChannelId;
    private final Long rulesChannelId;
    private final String splash;
    private final Integer systemChannelFlags;
    private final Long systemChannelId;
    private final GuildVerificationLevel verificationLevel;

    public RestAPIParams$UpdateGuild() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RestAPIParams$UpdateGuild(Long l, Integer num, Long l2, Integer num2, String str, String str2, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, String str3, String str4, Integer num3, List<? extends GuildFeature> list, Long l3, Long l4, String str5) {
        this.afkChannelId = l;
        this.afkTimeout = num;
        this.systemChannelId = l2;
        this.defaultMessageNotifications = num2;
        this.icon = str;
        this.name = str2;
        this.verificationLevel = guildVerificationLevel;
        this.explicitContentFilter = guildExplicitContentFilter;
        this.splash = str3;
        this.banner = str4;
        this.systemChannelFlags = num3;
        this.features = list;
        this.rulesChannelId = l3;
        this.publicUpdatesChannelId = l4;
        this.preferredLocale = str5;
    }

    public static final RestAPIParams$UpdateGuild createForExplicitContentFilter(GuildExplicitContentFilter guildExplicitContentFilter) {
        return Companion.createForExplicitContentFilter(guildExplicitContentFilter);
    }

    public static final RestAPIParams$UpdateGuild createForVerificationLevel(GuildVerificationLevel guildVerificationLevel) {
        return Companion.createForVerificationLevel(guildVerificationLevel);
    }

    public final List<GuildFeature> getFeatures() {
        return this.features;
    }

    public final String getPreferredLocale() {
        return this.preferredLocale;
    }

    public final Long getPublicUpdatesChannelId() {
        return this.publicUpdatesChannelId;
    }

    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    public /* synthetic */ RestAPIParams$UpdateGuild(Long l, Integer num, Long l2, Integer num2, String str, String str2, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, String str3, String str4, Integer num3, List list, Long l3, Long l4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : guildVerificationLevel, (i & 128) != 0 ? null : guildExplicitContentFilter, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : list, (i & 4096) != 0 ? null : l3, (i & 8192) != 0 ? null : l4, (i & 16384) == 0 ? str5 : null);
    }
}
