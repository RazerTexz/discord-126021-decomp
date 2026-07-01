package com.discord.widgets.hubs;

import com.discord.api.hubs.WaitlistSignup;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlistViewModel$joinWaitlist$1 extends o implements Function1<RestCallState<? extends WaitlistSignup>, Unit> {
    public final /* synthetic */ WidgetHubWaitlistViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlistViewModel$joinWaitlist$1(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel) {
        super(1);
        this.this$0 = widgetHubWaitlistViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends WaitlistSignup> restCallState) {
        invoke2((RestCallState<WaitlistSignup>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<WaitlistSignup> restCallState) {
        m.checkNotNullParameter(restCallState, "async");
        HubWaitlistState hubWaitlistStateAccess$getViewState$p = WidgetHubWaitlistViewModel.access$getViewState$p(this.this$0);
        if (hubWaitlistStateAccess$getViewState$p != null) {
            WidgetHubWaitlistViewModel.access$updateViewState(this.this$0, hubWaitlistStateAccess$getViewState$p.copy(restCallState));
        }
    }
}
