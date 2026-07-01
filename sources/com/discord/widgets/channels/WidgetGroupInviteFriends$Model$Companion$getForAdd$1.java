package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForAdd$1<T, R> implements b<Channel, Observable<? extends WidgetGroupInviteFriends$Model>> {
    public final /* synthetic */ Observable $addedUsersPublisher;
    public final /* synthetic */ Observable $filterPublisher;

    public WidgetGroupInviteFriends$Model$Companion$getForAdd$1(Observable observable, Observable observable2) {
        this.$addedUsersPublisher = observable;
        this.$filterPublisher = observable2;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends$Model> call2(Channel channel) {
        Object widgetGroupInviteFriends$sam$rx_functions_Func2$0;
        if (channel == null) {
            return new k(null);
        }
        Observable observable = this.$addedUsersPublisher;
        Observable observable2 = this.$filterPublisher;
        WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1 widgetGroupInviteFriends$Model$Companion$getForAdd$1$1 = WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1.INSTANCE;
        if (widgetGroupInviteFriends$Model$Companion$getForAdd$1$1 != null) {
            widgetGroupInviteFriends$sam$rx_functions_Func2$0 = widgetGroupInviteFriends$Model$Companion$getForAdd$1$1;
            widgetGroupInviteFriends$sam$rx_functions_Func2$0 = new WidgetGroupInviteFriends$sam$rx_functions_Func2$0(widgetGroupInviteFriends$Model$Companion$getForAdd$1$1);
        }
        widgetGroupInviteFriends$sam$rx_functions_Func2$0 = widgetGroupInviteFriends$Model$Companion$getForAdd$1$1;
        return Observable.j(observable, observable2, (Func2) widgetGroupInviteFriends$sam$rx_functions_Func2$0).Y(new WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2(channel));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends$Model> call(Channel channel) {
        return call2(channel);
    }
}
