package com.discord.utilities.guilds;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.voice.Bitrate;
import d0.d0.f;
import d0.t.g0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.text.Regex;

/* JADX INFO: compiled from: GuildUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildUtilsKt {
    public static final Map<Long, GuildMember> asMap(List<GuildMember> list) {
        m.checkNotNullParameter(list, "$this$asMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Long.valueOf(((GuildMember) obj).getUser().getId()), obj);
        }
        return linkedHashMap;
    }

    public static final String computeShortName(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new Regex("\\s").replace(new Regex("(\\w)(\\w*)").replace(new Regex("'s ").replace(str, " "), "$1"), "");
    }

    public static final Guild createApiGuild(com.discord.models.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new Guild(guild.getRoles(), guild.getEmojis(), guild.getStickers(), guild.getName(), guild.getDescription(), Integer.valueOf(guild.getDefaultMessageNotifications()), guild.getId(), guild.getRegion(), guild.getOwnerId(), guild.getIcon(), guild.getVerificationLevel(), guild.getExplicitContentFilter(), null, null, null, null, guild.getUnavailable(), guild.getMfaLevel(), guild.getAfkTimeout(), guild.getAfkChannelId(), guild.getSystemChannelId(), u.toList(guild.getFeatures()), guild.getMemberCount(), guild.getBanner(), guild.getSplash(), guild.getPremiumTier(), guild.getPremiumSubscriptionCount(), guild.getSystemChannelFlags(), guild.getJoinedAt(), guild.getRulesChannelId(), guild.getPublicUpdatesChannelId(), guild.getPreferredLocale(), guild.getWelcomeScreen(), guild.getMaxVideoChannelUsers(), guild.getVanityUrlCode(), 0, guild.getApproximatePresenceCount(), null, null, null, null, guild.getNsfw(), null, null, n.emptyList(), guild.getHubType());
    }

    public static final GuildRole getGuildRole(Long l) {
        if (l == null) {
            return null;
        }
        for (Map$Entry<Long, Map<Long, GuildRole>> map$Entry : StoreStream.Companion.getGuilds().getRoles().entrySet()) {
            if (map$Entry.getValue().containsKey(l)) {
                return map$Entry.getValue().get(l);
            }
        }
        return null;
    }

    public static final int getMaxFileSizeMB(com.discord.models.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return PremiumUtils.INSTANCE.getGuildMaxFileSizeMB(guild.getPremiumTier());
    }

    public static final int getMaxVoiceBitrateKbps(com.discord.models.guild.Guild guild, Channel channel) {
        m.checkNotNullParameter(guild, "guild");
        return (channel == null || !ChannelUtils.D(channel)) ? getMaxVoiceBitrateKbps(guild.getPremiumTier(), guild.getFeatures().contains(GuildFeature.VIP_REGIONS)) : Bitrate.DEFAULT.getKbps();
    }

    public static final boolean isFullyGatedGuildRoleSubscriptionGuild(com.discord.models.guild.Guild guild, GuildRole guildRole) {
        m.checkNotNullParameter(guild, "$this$isFullyGatedGuildRoleSubscriptionGuild");
        return guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE) && !PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, guildRole, null);
    }

    public static /* synthetic */ boolean isFullyGatedGuildRoleSubscriptionGuild$default(com.discord.models.guild.Guild guild, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = getGuildRole(Long.valueOf(guild.getId()));
        }
        return isFullyGatedGuildRoleSubscriptionGuild(guild, guildRole);
    }

    public static final int getMaxVoiceBitrateKbps(int i, boolean z2) {
        if (z2) {
            return Bitrate.PREMIUM_TIER_3.getKbps();
        }
        if (i == 1) {
            return Bitrate.PREMIUM_TIER_1.getKbps();
        }
        if (i == 2) {
            return Bitrate.PREMIUM_TIER_2.getKbps();
        }
        if (i != 3) {
            return Bitrate.MAX.getKbps();
        }
        return Bitrate.PREMIUM_TIER_3.getKbps();
    }
}
