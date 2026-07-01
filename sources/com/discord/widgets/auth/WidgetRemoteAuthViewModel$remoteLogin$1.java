package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuthViewModel$remoteLogin$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetRemoteAuthViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel$remoteLogin$1(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel) {
        super(1);
        this.this$0 = widgetRemoteAuthViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        WidgetRemoteAuthViewModel.access$updateViewState(this.this$0, WidgetRemoteAuthViewModel$ViewState$Succeeded.INSTANCE);
    }
}
