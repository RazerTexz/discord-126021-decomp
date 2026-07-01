package com.discord.widgets.guilds.invite;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$initBottomSheet$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildInviteShareCompact this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareCompact$initBottomSheet$1(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        super(0);
        this.this$0 = widgetGuildInviteShareCompact;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(this.this$0).setState(5);
    }
}
