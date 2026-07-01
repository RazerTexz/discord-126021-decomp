package com.discord.widgets.channels;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$onViewBoundOrOnResume$2 extends o implements Function1<Object, Unit> {
    public final /* synthetic */ WidgetGroupInviteFriends this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriends$onViewBoundOrOnResume$2(WidgetGroupInviteFriends widgetGroupInviteFriends) {
        super(1);
        this.this$0 = widgetGroupInviteFriends;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        WidgetGroupInviteFriends.access$getFilterPublisher$p(this.this$0).onNext(String.valueOf(obj));
    }
}
