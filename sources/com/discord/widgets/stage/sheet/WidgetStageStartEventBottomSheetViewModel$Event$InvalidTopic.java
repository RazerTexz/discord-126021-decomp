package com.discord.widgets.stage.sheet;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic extends WidgetStageStartEventBottomSheetViewModel$Event {
    private final int failureMessageStringRes;

    public WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic(int i) {
        super(null);
        this.failureMessageStringRes = i;
    }

    public static /* synthetic */ WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic copy$default(WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic widgetStageStartEventBottomSheetViewModel$Event$InvalidTopic, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetStageStartEventBottomSheetViewModel$Event$InvalidTopic.failureMessageStringRes;
        }
        return widgetStageStartEventBottomSheetViewModel$Event$InvalidTopic.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public final WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic copy(int failureMessageStringRes) {
        return new WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic(failureMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic) && this.failureMessageStringRes == ((WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic) other).failureMessageStringRes;
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
        return a.B(a.U("InvalidTopic(failureMessageStringRes="), this.failureMessageStringRes, ")");
    }
}
