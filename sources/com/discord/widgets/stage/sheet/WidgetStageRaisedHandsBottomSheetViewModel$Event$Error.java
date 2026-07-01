package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageRaisedHandsBottomSheetViewModel$Event$Error extends WidgetStageRaisedHandsBottomSheetViewModel$Event {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel$Event$Error(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$Event$Error copy$default(WidgetStageRaisedHandsBottomSheetViewModel$Event$Error widgetStageRaisedHandsBottomSheetViewModel$Event$Error, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = widgetStageRaisedHandsBottomSheetViewModel$Event$Error.error;
        }
        return widgetStageRaisedHandsBottomSheetViewModel$Event$Error.copy(error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final WidgetStageRaisedHandsBottomSheetViewModel$Event$Error copy(Error error) {
        m.checkNotNullParameter(error, "error");
        return new WidgetStageRaisedHandsBottomSheetViewModel$Event$Error(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetStageRaisedHandsBottomSheetViewModel$Event$Error) && m.areEqual(this.error, ((WidgetStageRaisedHandsBottomSheetViewModel$Event$Error) other).error);
        }
        return true;
    }

    public final Error getError() {
        return this.error;
    }

    public int hashCode() {
        Error error = this.error;
        if (error != null) {
            return error.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Error(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
