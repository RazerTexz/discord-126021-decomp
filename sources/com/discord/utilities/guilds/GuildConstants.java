package com.discord.utilities.guilds;

import com.discord.utilities.premium.GuildBoostTierAmounts;

/* JADX INFO: renamed from: com.discord.utilities.guilds.GuildConstantsKt, reason: use source file name */
/* JADX INFO: compiled from: GuildConstants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildConstants {
    public static final int FILE_SIZE_STANDARD_8MB = 8;
    public static final int GLOBAL_SEARCH_LARGE_GUILD_THRESHOLD = 200;
    public static final int INVITE_LARGE_GUILD_THRESHOLD = 200;
    public static final int MAX_GUILD_MEMBERS_NOTIFY_ALL_MESSAGES = 2500;
    public static final int MAX_GUILD_MEMBERS_NOTIFY_HIGHLIGHTS = 2500;
    public static final int PREMIUM_TIER_0_FILE_SIZE_20MB = 20;
    public static final int PREMIUM_TIER_1_FILE_SIZE_50MB = 50;
    public static final int PREMIUM_TIER_2_FILE_SIZE_100MB = 100;
    public static final int STAFF_FILE_SIZE_200MB = 200;
    public static final int SYSTEM_CHANNEL_FLAG_SUPPRESS_BOOST = 2;
    public static final int SYSTEM_CHANNEL_FLAG_SUPPRESS_JOIN = 1;
    public static final int SYSTEM_CHANNEL_FLAG_SUPPRESS_JOIN_REPLIES = 8;
    public static final int SYSTEM_CHANNEL_FLAG_SUPPRESS_ROLE_SUBSCRIPTION_PURCHASE_NOTIFICATIONS = 16;
    public static final int SYSTEM_CHANNEL_FLAG_SUPPRESS_ROLE_SUBSCRIPTION_PURCHASE_NOTIFICATION_REPLIES = 32;
    private static final GuildBoostTierAmounts GUILD_BOOST_TIER_AMOUNTS = new GuildBoostTierAmounts(2, 7, 14);
    private static final GuildBoostTierAmounts GUILD_BOOST_TIER_AMOUNTS_EXP_SMALL_GUILDS = new GuildBoostTierAmounts(2, 3, 4);
    private static final GuildBoostTierAmounts GUILD_BOOST_TIER_AMOUNTS_EXP_MEDIUM_GUILDS = new GuildBoostTierAmounts(2, 7, 10);

    public static final GuildBoostTierAmounts getGUILD_BOOST_TIER_AMOUNTS() {
        return GUILD_BOOST_TIER_AMOUNTS;
    }

    public static final GuildBoostTierAmounts getGUILD_BOOST_TIER_AMOUNTS_EXP_MEDIUM_GUILDS() {
        return GUILD_BOOST_TIER_AMOUNTS_EXP_MEDIUM_GUILDS;
    }

    public static final GuildBoostTierAmounts getGUILD_BOOST_TIER_AMOUNTS_EXP_SMALL_GUILDS() {
        return GUILD_BOOST_TIER_AMOUNTS_EXP_SMALL_GUILDS;
    }
}
