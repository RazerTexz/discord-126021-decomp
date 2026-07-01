package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, R> implements Func4<Guild, Channel, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined$JoinedThread, MuteSettingsSheetViewModel$StoreState> {
    public static final MuteSettingsSheetViewModel$Companion$observeStoreState$1 INSTANCE = new MuteSettingsSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ MuteSettingsSheetViewModel$StoreState call(Guild guild, Channel channel, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        return call2(guild, channel, map, storeThreadsJoined$JoinedThread);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MuteSettingsSheetViewModel$StoreState call2(Guild guild, Channel channel, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        Long lValueOf;
        long guildId;
        long jLongValue;
        if (guild == null) {
            if (channel != null) {
                guildId = channel.getGuildId();
            } else {
                lValueOf = null;
            }
            if (lValueOf != null) {
                jLongValue = lValueOf.longValue();
            } else {
                jLongValue = 0;
            }
            return new MuteSettingsSheetViewModel$StoreState(guild, channel, map.get(Long.valueOf(jLongValue)), storeThreadsJoined$JoinedThread);
        }
        guildId = guild.getId();
        lValueOf = Long.valueOf(guildId);
        if (lValueOf != null) {
            jLongValue = lValueOf.longValue();
        } else {
            jLongValue = 0;
        }
        return new MuteSettingsSheetViewModel$StoreState(guild, channel, map.get(Long.valueOf(jLongValue)), storeThreadsJoined$JoinedThread);
    }
}
