package com.discord.widgets.friends;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$onViewBoundOrOnResume$2 extends o implements Function1<WidgetFriendsFindNearby$Model, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$onViewBoundOrOnResume$2(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(1);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetFriendsFindNearby$Model widgetFriendsFindNearby$Model) {
        invoke2(widgetFriendsFindNearby$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetFriendsFindNearby$Model widgetFriendsFindNearby$Model) {
        m.checkNotNullParameter(widgetFriendsFindNearby$Model, "it");
        WidgetFriendsFindNearby.access$configureUI(this.this$0, widgetFriendsFindNearby$Model);
    }
}
