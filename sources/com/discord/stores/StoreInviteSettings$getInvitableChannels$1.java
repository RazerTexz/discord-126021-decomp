package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$getInvitableChannels$1<T1, T2, R> implements Func2<Map<Long, ? extends Channel>, Map<Long, ? extends Map<Long, ? extends Long>>, Map<Long, ? extends Channel>> {
    public final /* synthetic */ long $guildId;

    public StoreInviteSettings$getInvitableChannels$1(long j) {
        this.$guildId = j;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Map<Long, ? extends Long>> map2) {
        return call2((Map<Long, Channel>) map, (Map<Long, ? extends Map<Long, Long>>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Channel> call2(Map<Long, Channel> map, Map<Long, ? extends Map<Long, Long>> map2) {
        HashMap map3 = new HashMap();
        Map<Long, Long> map4 = map2.get(Long.valueOf(this.$guildId));
        if (map4 != null) {
            for (Map$Entry<Long, Long> map$Entry : map4.entrySet()) {
                long jLongValue = map$Entry.getKey().longValue();
                long jLongValue2 = map$Entry.getValue().longValue();
                Channel channel = map.get(Long.valueOf(jLongValue));
                if (channel != null) {
                    m.checkNotNullParameter(channel, "$this$isInvitableChannel");
                    if ((ChannelUtils.v(channel) || ChannelUtils.w(channel)) && PermissionUtils.INSTANCE.hasAccess(channel, Long.valueOf(jLongValue2)) && PermissionUtils.can(1L, Long.valueOf(jLongValue2))) {
                        map3.put(Long.valueOf(jLongValue), channel);
                    }
                }
            }
        }
        return map3;
    }
}
