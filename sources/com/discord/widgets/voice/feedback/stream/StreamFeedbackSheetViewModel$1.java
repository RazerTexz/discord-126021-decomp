package com.discord.widgets.voice.feedback.stream;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel$1 extends o implements Function1<StreamFeedbackSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ StreamFeedbackSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFeedbackSheetViewModel$1(StreamFeedbackSheetViewModel streamFeedbackSheetViewModel) {
        super(1);
        this.this$0 = streamFeedbackSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StreamFeedbackSheetViewModel$StoreState streamFeedbackSheetViewModel$StoreState) {
        invoke2(streamFeedbackSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StreamFeedbackSheetViewModel$StoreState streamFeedbackSheetViewModel$StoreState) {
        m.checkNotNullParameter(streamFeedbackSheetViewModel$StoreState, "storeState");
        StreamFeedbackSheetViewModel.access$setMostRecentStoreState$p(this.this$0, streamFeedbackSheetViewModel$StoreState);
    }
}
