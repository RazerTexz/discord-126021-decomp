package com.discord.widgets.friends;

import d0.z.d.o;
import defpackage.WidgetFriendsAddUserRequestsModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$onViewBoundOrOnResume$1 extends o implements Function1<WidgetFriendsAddUserRequestsModel, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$onViewBoundOrOnResume$1(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(1);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
        invoke2(widgetFriendsAddUserRequestsModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
        WidgetFriendsFindNearby.access$getResultsAdapter$p(this.this$0).addFriendRequestUserIds(widgetFriendsAddUserRequestsModel.outgoingIds, widgetFriendsAddUserRequestsModel.incomingIds);
    }
}
