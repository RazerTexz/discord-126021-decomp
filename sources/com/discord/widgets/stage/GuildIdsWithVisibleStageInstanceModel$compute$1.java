package com.discord.widgets.stage;

import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithVisibleStageInstanceModel$compute$1 extends o implements Function1<Map$Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Boolean> {
    public final /* synthetic */ Map $permissionsByChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIdsWithVisibleStageInstanceModel$compute$1(Map map) {
        super(1);
        this.$permissionsByChannel = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Map$Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> map$Entry) {
        return Boolean.valueOf(invoke2((Map$Entry<Long, ? extends Map<Long, StageInstance>>) map$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Map$Entry<Long, ? extends Map<Long, StageInstance>> map$Entry) {
        int i;
        m.checkNotNullParameter(map$Entry, "<name for destructuring parameter 0>");
        map$Entry.getKey().longValue();
        Set<Long> setKeySet = map$Entry.getValue().keySet();
        if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = setKeySet.iterator();
            i = 0;
            while (it.hasNext()) {
                if (PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) this.$permissionsByChannel.get(Long.valueOf(((Number) it.next()).longValue()))) && (i = i + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
        }
        return i > 0;
    }
}
