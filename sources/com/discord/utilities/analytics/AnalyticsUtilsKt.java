package com.discord.utilities.analytics;

import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtilsKt {
    public static final /* synthetic */ TrackGuild access$fill(TrackGuild trackGuild) {
        return fill(trackGuild);
    }

    private static final TrackGuild fill(TrackGuild trackGuild) {
        Long guildId;
        if (trackGuild != null && (guildId = trackGuild.getGuildId()) != null) {
            long jLongValue = guildId.longValue();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            Guild guild = storeStream$Companion.getGuilds().getGuild(jLongValue);
            if (guild != null) {
                long id2 = storeStream$Companion.getUsers().getMeSnapshot().getId();
                return TrackGuild.a(trackGuild, null, null, null, null, null, null, null, null, null, Boolean.valueOf(storeStream$Companion.getGuilds().getMember(jLongValue, id2) != null), null, Boolean.valueOf(guild.isOwner(id2)), 1535);
            }
        }
        return trackGuild;
    }
}
