package com.discord.widgets.friends;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$onViewBound$3 extends o implements Function2<Long, Boolean, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$onViewBound$3(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(2);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
        invoke(l.longValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(long j, boolean z2) {
        WidgetFriendsFindNearby.access$declineFriendRequest(this.this$0, j, z2);
    }
}
