package com.discord.widgets.home;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelNsfw$toggleContainerVisibility$3 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ Function1 $onToggleNsfw;
    public final /* synthetic */ WidgetHomePanelNsfw this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHomePanelNsfw$toggleContainerVisibility$3(WidgetHomePanelNsfw widgetHomePanelNsfw, Function1 function1) {
        super(1);
        this.this$0 = widgetHomePanelNsfw;
        this.$onToggleNsfw = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        WidgetHomePanelNsfw.access$setContainerViewHidden(this.this$0, true, this.$onToggleNsfw);
    }
}
