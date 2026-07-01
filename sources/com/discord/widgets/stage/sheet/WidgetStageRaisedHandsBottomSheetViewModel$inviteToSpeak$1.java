package com.discord.widgets.stage.sheet;

import com.discord.utilities.error.Error;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$1 extends k implements Function1<Error, Unit> {
    public WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$1(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "emitError", "emitError(Lcom/discord/utilities/error/Error;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "p1");
        WidgetStageRaisedHandsBottomSheetViewModel.access$emitError((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver, error);
    }
}
