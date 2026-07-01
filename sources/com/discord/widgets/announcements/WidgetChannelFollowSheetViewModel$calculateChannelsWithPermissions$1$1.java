package com.discord.widgets.announcements;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1$1<T, R> implements b<Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Channel>>> {
    public final /* synthetic */ Map $perms;

    public WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1$1(Map map) {
        this.$perms = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Channel>> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005f  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, List<Channel>> call2(Map<Long, Channel> map) {
        boolean z2;
        m.checkNotNullExpressionValue(map, "it");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Channel> map$Entry : map.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            Channel value = map$Entry.getValue();
            if (value.getType() == 5 || value.getType() == 0) {
                Long l = (Long) this.$perms.get(Long.valueOf(jLongValue));
                if (PermissionUtils.can(Permission.MANAGE_WEBHOOKS, Long.valueOf(l != null ? l.longValue() : 0L))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        Collection collectionValues = linkedHashMap.values();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (T t : collectionValues) {
            Long lValueOf = Long.valueOf(((Channel) t).getGuildId());
            Object arrayList = linkedHashMap2.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap2.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(t);
        }
        return linkedHashMap2;
    }
}
