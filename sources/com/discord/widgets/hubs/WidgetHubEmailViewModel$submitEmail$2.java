package com.discord.widgets.hubs;

import com.discord.api.hubs.EmailVerification;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailViewModel$submitEmail$2 extends o implements Function1<RestCallState<? extends EmailVerification>, Unit> {
    public final /* synthetic */ WidgetHubEmailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailViewModel$submitEmail$2(WidgetHubEmailViewModel widgetHubEmailViewModel) {
        super(1);
        this.this$0 = widgetHubEmailViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
        invoke2((RestCallState<EmailVerification>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<EmailVerification> restCallState) {
        m.checkNotNullParameter(restCallState, "it");
        WidgetHubEmailViewModel widgetHubEmailViewModel = this.this$0;
        WidgetHubEmailViewModel.access$updateViewState(widgetHubEmailViewModel, HubEmailState.copy$default(WidgetHubEmailViewModel.access$requireViewState(widgetHubEmailViewModel), null, null, null, restCallState, 7, null));
    }
}
