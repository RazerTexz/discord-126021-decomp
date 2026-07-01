package com.discord.widgets.servers.member_verification;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel$1 extends o implements Function1<WidgetMemberVerificationViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetMemberVerificationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerificationViewModel$1(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel) {
        super(1);
        this.this$0 = widgetMemberVerificationViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetMemberVerificationViewModel$StoreState widgetMemberVerificationViewModel$StoreState) {
        invoke2(widgetMemberVerificationViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetMemberVerificationViewModel$StoreState widgetMemberVerificationViewModel$StoreState) {
        m.checkNotNullParameter(widgetMemberVerificationViewModel$StoreState, "storeState");
        WidgetMemberVerificationViewModel.access$handleStoreState(this.this$0, widgetMemberVerificationViewModel$StoreState);
    }
}
