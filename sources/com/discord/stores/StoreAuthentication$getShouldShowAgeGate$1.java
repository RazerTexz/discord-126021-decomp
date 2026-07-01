package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.TimeUtils;
import rx.functions.Func3;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$getShouldShowAgeGate$1<T1, T2, T3, R> implements Func3<MeUser, String, Channel, StoreNavigation$AgeGate> {
    public static final StoreAuthentication$getShouldShowAgeGate$1 INSTANCE = new StoreAuthentication$getShouldShowAgeGate$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StoreNavigation$AgeGate call(MeUser meUser, String str, Channel channel) {
        return call2(meUser, str, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreNavigation$AgeGate call2(MeUser meUser, String str, Channel channel) {
        long uTCDate = TimeUtils.parseUTCDate("2021-02-05T12:00:00+0000");
        if (!meUser.getHasBirthday() && (meUser.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH > uTCDate) {
            return StoreNavigation$AgeGate.REGISTER_AGE_GATE;
        }
        if (str != null || meUser.getHasBirthday() || channel == null || !channel.getNsfw()) {
            return null;
        }
        return StoreNavigation$AgeGate.NSFW_CHANNEL_AGE_GATE;
    }
}
