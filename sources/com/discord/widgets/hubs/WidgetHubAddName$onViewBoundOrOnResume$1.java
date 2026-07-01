package com.discord.widgets.hubs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAddName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddName$onViewBoundOrOnResume$1 extends o implements Function1<AddNameState, Unit> {
    public final /* synthetic */ WidgetHubAddName this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddName$onViewBoundOrOnResume$1(WidgetHubAddName widgetHubAddName) {
        super(1);
        this.this$0 = widgetHubAddName;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AddNameState addNameState) {
        invoke2(addNameState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AddNameState addNameState) {
        m.checkNotNullParameter(addNameState, "viewState");
        WidgetHubAddName.access$configureUI(this.this$0, addNameState);
    }
}
