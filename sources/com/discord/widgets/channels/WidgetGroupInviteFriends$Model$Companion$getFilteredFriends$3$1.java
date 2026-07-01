package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Presence>, Map<Long, ? extends User>, Map<Long, ? extends ModelApplicationStream>, WidgetGroupInviteFriends$Model$ModelAppUserRelationship> {
    public final /* synthetic */ Map $filteredFriends;

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3$1(Map map) {
        this.$filteredFriends = map;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetGroupInviteFriends$Model$ModelAppUserRelationship call(Map<Long, ? extends Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
        return call2((Map<Long, Presence>) map, map2, map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGroupInviteFriends$Model$ModelAppUserRelationship call2(Map<Long, Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
        Map map4 = this.$filteredFriends;
        m.checkNotNullExpressionValue(map4, "filteredFriends");
        m.checkNotNullExpressionValue(map, "presences");
        m.checkNotNullExpressionValue(map2, "users");
        m.checkNotNullExpressionValue(map3, "applicationStreams");
        return new WidgetGroupInviteFriends$Model$ModelAppUserRelationship(map4, map, map2, map3);
    }
}
