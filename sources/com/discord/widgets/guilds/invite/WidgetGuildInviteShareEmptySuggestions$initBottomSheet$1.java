package com.discord.widgets.guilds.invite;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions$initBottomSheet$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildInviteShareEmptySuggestions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareEmptySuggestions$initBottomSheet$1(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        super(0);
        this.this$0 = widgetGuildInviteShareEmptySuggestions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(this.this$0).setState(5);
    }
}
