package com.discord.widgets.voice.feedback.call;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSheetViewModel$1 extends o implements Function1<CallFeedbackSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ CallFeedbackSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallFeedbackSheetViewModel$1(CallFeedbackSheetViewModel callFeedbackSheetViewModel) {
        super(1);
        this.this$0 = callFeedbackSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CallFeedbackSheetViewModel$StoreState callFeedbackSheetViewModel$StoreState) {
        invoke2(callFeedbackSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CallFeedbackSheetViewModel$StoreState callFeedbackSheetViewModel$StoreState) {
        m.checkNotNullParameter(callFeedbackSheetViewModel$StoreState, "storeState");
        CallFeedbackSheetViewModel.access$setMostRecentStoreState$p(this.this$0, callFeedbackSheetViewModel$StoreState);
    }
}
