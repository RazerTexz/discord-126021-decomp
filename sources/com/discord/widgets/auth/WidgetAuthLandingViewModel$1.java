package com.discord.widgets.auth;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel$1 extends o implements Function1<WidgetAuthLandingViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetAuthLandingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel$1(WidgetAuthLandingViewModel widgetAuthLandingViewModel) {
        super(1);
        this.this$0 = widgetAuthLandingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel$StoreState widgetAuthLandingViewModel$StoreState) {
        invoke2(widgetAuthLandingViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthLandingViewModel$StoreState widgetAuthLandingViewModel$StoreState) {
        m.checkNotNullParameter(widgetAuthLandingViewModel$StoreState, "it");
        this.this$0.handleStoreState(widgetAuthLandingViewModel$StoreState);
    }
}
