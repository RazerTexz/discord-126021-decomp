package com.discord.widgets.hubs;

import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddNameViewModel$setName$2 extends o implements Function1<RestCallState<? extends Void>, Unit> {
    public final /* synthetic */ WidgetHubAddNameViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddNameViewModel$setName$2(WidgetHubAddNameViewModel widgetHubAddNameViewModel) {
        super(1);
        this.this$0 = widgetHubAddNameViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends Void> restCallState) {
        invoke2((RestCallState<Void>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<Void> restCallState) {
        m.checkNotNullParameter(restCallState, "async");
        AddNameState addNameStateAccess$getViewState$p = WidgetHubAddNameViewModel.access$getViewState$p(this.this$0);
        if (addNameStateAccess$getViewState$p != null) {
            WidgetHubAddNameViewModel.access$updateViewState(this.this$0, AddNameState.copy$default(addNameStateAccess$getViewState$p, null, null, restCallState, 3, null));
        }
    }
}
