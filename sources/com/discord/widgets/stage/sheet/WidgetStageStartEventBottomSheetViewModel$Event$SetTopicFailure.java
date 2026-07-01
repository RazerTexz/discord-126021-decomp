package com.discord.widgets.stage.sheet;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure extends WidgetStageStartEventBottomSheetViewModel$Event {
    private final int failureMessageStringRes;

    public WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure(int i) {
        super(null);
        this.failureMessageStringRes = i;
    }

    public static /* synthetic */ WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure copy$default(WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure widgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure.failureMessageStringRes;
        }
        return widgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public final WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure copy(int failureMessageStringRes) {
        return new WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure(failureMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure) && this.failureMessageStringRes == ((WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure) other).failureMessageStringRes;
        }
        return true;
    }

    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public int hashCode() {
        return this.failureMessageStringRes;
    }

    public String toString() {
        return a.B(a.U("SetTopicFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
    }
}
