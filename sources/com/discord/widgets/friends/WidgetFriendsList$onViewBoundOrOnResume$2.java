package com.discord.widgets.friends;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsList$onViewBoundOrOnResume$2 extends k implements Function1<FriendsListViewModel$Event, Unit> {
    public WidgetFriendsList$onViewBoundOrOnResume$2(WidgetFriendsList widgetFriendsList) {
        super(1, widgetFriendsList, WidgetFriendsList.class, "handleEvent", "handleEvent(Lcom/discord/widgets/friends/FriendsListViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel$Event friendsListViewModel$Event) {
        invoke2(friendsListViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FriendsListViewModel$Event friendsListViewModel$Event) {
        m.checkNotNullParameter(friendsListViewModel$Event, "p1");
        WidgetFriendsList.access$handleEvent((WidgetFriendsList) this.receiver, friendsListViewModel$Event);
    }
}
