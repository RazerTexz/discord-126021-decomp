package com.discord.widgets.friends;

import b.a.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$declineFriendRequest$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ int $successMessageStringRes;
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$declineFriendRequest$1(WidgetFriendsFindNearby widgetFriendsFindNearby, int i) {
        super(1);
        this.this$0 = widgetFriendsFindNearby;
        this.$successMessageStringRes = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r5) {
        m.g(this.this$0.getContext(), this.$successMessageStringRes, 0, null, 12);
    }
}
