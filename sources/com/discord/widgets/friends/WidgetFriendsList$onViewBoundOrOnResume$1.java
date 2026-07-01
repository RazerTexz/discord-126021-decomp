package com.discord.widgets.friends;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsList$onViewBoundOrOnResume$1 extends k implements Function1<FriendsListViewModel$ViewState, Unit> {
    public WidgetFriendsList$onViewBoundOrOnResume$1(WidgetFriendsList widgetFriendsList) {
        super(1, widgetFriendsList, WidgetFriendsList.class, "configureUI", "configureUI(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel$ViewState friendsListViewModel$ViewState) {
        invoke2(friendsListViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FriendsListViewModel$ViewState friendsListViewModel$ViewState) {
        m.checkNotNullParameter(friendsListViewModel$ViewState, "p1");
        WidgetFriendsList.access$configureUI((WidgetFriendsList) this.receiver, friendsListViewModel$ViewState);
    }
}
