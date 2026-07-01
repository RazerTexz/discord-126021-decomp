package com.discord.widgets.friends;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$onViewBound$1 extends o implements Function2<String, Integer, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$onViewBound$1(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(2);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return Unit.a;
    }

    public final void invoke(String str, int i) {
        m.checkNotNullParameter(str, "username");
        WidgetFriendsFindNearby.sendFriendRequest$default(this.this$0, str, i, null, 4, null);
    }
}
