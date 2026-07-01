package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForCreate$2<T, R> implements b<WidgetGroupInviteFriends$Model$Companion$AddedUsersInput, Observable<? extends WidgetGroupInviteFriends$Model>> {
    public static final WidgetGroupInviteFriends$Model$Companion$getForCreate$2 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getForCreate$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends$Model> call(WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput) {
        return call2(widgetGroupInviteFriends$Model$Companion$AddedUsersInput);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends$Model> call2(WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput) {
        return WidgetGroupInviteFriends$Model$Companion.access$getFilteredFriends(WidgetGroupInviteFriends$Model.Companion, null, widgetGroupInviteFriends$Model$Companion$AddedUsersInput.getFilter()).G(new WidgetGroupInviteFriends$Model$Companion$getForCreate$2$1(widgetGroupInviteFriends$Model$Companion$AddedUsersInput)).Y(new WidgetGroupInviteFriends$Model$Companion$getForCreate$2$2(widgetGroupInviteFriends$Model$Companion$AddedUsersInput));
    }
}
