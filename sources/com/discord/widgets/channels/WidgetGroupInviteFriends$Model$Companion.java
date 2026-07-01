package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion {
    private WidgetGroupInviteFriends$Model$Companion() {
    }

    public static final /* synthetic */ Observable access$getFilteredFriends(WidgetGroupInviteFriends$Model$Companion widgetGroupInviteFriends$Model$Companion, Collection collection, String str) {
        return widgetGroupInviteFriends$Model$Companion.getFilteredFriends(collection, str);
    }

    @SuppressLint({"DefaultLocale"})
    private final Observable<WidgetGroupInviteFriends$Model$ModelAppUserRelationship> getFilteredFriends(Collection<? extends User> oldExcludeUsers, String nameFilter) {
        if (oldExcludeUsers == null) {
            oldExcludeUsers = n.emptyList();
        }
        Observable<WidgetGroupInviteFriends$Model$ModelAppUserRelationship> observableY = Observable.B(oldExcludeUsers).G(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1.INSTANCE).f0().A(new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2(nameFilter)).Y(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "Observable\n            .…          }\n            }");
        return observableY;
    }

    private final Observable<WidgetGroupInviteFriends$Model> getForAdd(long channelId, Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
        Observable observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new WidgetGroupInviteFriends$Model$Companion$getForAdd$1(addedUsersPublisher, filterPublisher));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
        return observableY;
    }

    private final Observable<WidgetGroupInviteFriends$Model> getForCreate(Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
        WidgetGroupInviteFriends$Model$Companion$getForCreate$1 widgetGroupInviteFriends$Model$Companion$getForCreate$1 = WidgetGroupInviteFriends$Model$Companion$getForCreate$1.INSTANCE;
        Object widgetGroupInviteFriends$sam$rx_functions_Func2$0 = widgetGroupInviteFriends$Model$Companion$getForCreate$1;
        if (widgetGroupInviteFriends$Model$Companion$getForCreate$1 != null) {
            widgetGroupInviteFriends$sam$rx_functions_Func2$0 = new WidgetGroupInviteFriends$sam$rx_functions_Func2$0(widgetGroupInviteFriends$Model$Companion$getForCreate$1);
        }
        Observable<WidgetGroupInviteFriends$Model> observableY = Observable.j(addedUsersPublisher, filterPublisher, (Func2) widgetGroupInviteFriends$sam$rx_functions_Func2$0).Y(WidgetGroupInviteFriends$Model$Companion$getForCreate$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "Observable\n            .…          }\n            }");
        return observableY;
    }

    public static /* synthetic */ void getMODE_CREATE$annotations() {
    }

    public final Observable<WidgetGroupInviteFriends$Model> get(long channelId, Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
        m.checkNotNullParameter(addedUsersPublisher, "addedUsersPublisher");
        m.checkNotNullParameter(filterPublisher, "filterPublisher");
        return channelId == -1 ? getForCreate(addedUsersPublisher, filterPublisher) : getForAdd(channelId, addedUsersPublisher, filterPublisher);
    }

    public final Observable<? extends Collection<User>> getFriendChanges(Observable<Collection<User>> addedUsers) {
        m.checkNotNullParameter(addedUsers, "addedUsers");
        Observable<? extends Collection<User>> observableR = StoreStream.Companion.getUserRelationships().observeForType(1).Y(new WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1(addedUsers)).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetGroupInviteFriends$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
