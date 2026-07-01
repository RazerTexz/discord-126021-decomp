package com.discord.widgets.channels.memberlist;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList$onViewBoundOrOnResume$3 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ WidgetChannelMembersList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersList$onViewBoundOrOnResume$3(WidgetChannelMembersList widgetChannelMembersList) {
        super(1);
        this.this$0 = widgetChannelMembersList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        WidgetChannelMembersList.access$updateRanges(this.this$0);
    }
}
