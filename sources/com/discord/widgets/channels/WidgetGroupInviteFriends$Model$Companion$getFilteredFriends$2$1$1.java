package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.b;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1<T, R> implements b<Map<Long, ? extends User>, Observable<? extends Map<Long, Integer>>> {
    public final /* synthetic */ Map $relationships;
    public final /* synthetic */ WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1 this$0;

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1 widgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1, Map map) {
        this.this$0 = widgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1;
        this.$relationships = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends User> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, Integer>> call2(Map<Long, ? extends User> map) {
        return Observable.B(this.$relationships.entrySet()).y(new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$1(this, map)).g0(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$2.INSTANCE, WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$3.INSTANCE);
    }
}
