package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.models.user.CoreUser;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2<T, R> implements b<WidgetGroupInviteFriends$Model$Companion$AddedUsersInput, Observable<? extends WidgetGroupInviteFriends$Model>> {
    public final /* synthetic */ Channel $channel;

    public WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends$Model> call(WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput) {
        return call2(widgetGroupInviteFriends$Model$Companion$AddedUsersInput);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends$Model> call2(WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput) {
        ArrayList arrayList;
        WidgetGroupInviteFriends$Model$Companion widgetGroupInviteFriends$Model$Companion = WidgetGroupInviteFriends$Model.Companion;
        List<User> listZ = this.$channel.z();
        if (listZ != null) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(listZ, 10));
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                arrayList.add(new CoreUser((User) it.next()));
            }
        } else {
            arrayList = null;
        }
        return WidgetGroupInviteFriends$Model$Companion.access$getFilteredFriends(widgetGroupInviteFriends$Model$Companion, arrayList, widgetGroupInviteFriends$Model$Companion$AddedUsersInput.getFilter()).G(new WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$2(widgetGroupInviteFriends$Model$Companion$AddedUsersInput)).Y(new WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$3(this, widgetGroupInviteFriends$Model$Companion$AddedUsersInput));
    }
}
