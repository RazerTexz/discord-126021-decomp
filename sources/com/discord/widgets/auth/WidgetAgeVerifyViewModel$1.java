package com.discord.widgets.auth;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel$1 extends o implements Function1<WidgetAgeVerifyViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetAgeVerifyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerifyViewModel$1(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel) {
        super(1);
        this.this$0 = widgetAgeVerifyViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel$StoreState widgetAgeVerifyViewModel$StoreState) {
        invoke2(widgetAgeVerifyViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAgeVerifyViewModel$StoreState widgetAgeVerifyViewModel$StoreState) {
        m.checkNotNullParameter(widgetAgeVerifyViewModel$StoreState, "storeState");
        WidgetAgeVerifyViewModel.access$handleStoreState(this.this$0, widgetAgeVerifyViewModel$StoreState);
    }
}
