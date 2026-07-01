package com.discord.widgets.voice.sheet;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast extends WidgetNoiseCancellationBottomSheetViewModel$Event {
    private final int toastResId;

    public WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast(@StringRes int i) {
        super(null);
        this.toastResId = i;
    }

    public static /* synthetic */ WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast copy$default(WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast widgetNoiseCancellationBottomSheetViewModel$Event$ShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetNoiseCancellationBottomSheetViewModel$Event$ShowToast.toastResId;
        }
        return widgetNoiseCancellationBottomSheetViewModel$Event$ShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getToastResId() {
        return this.toastResId;
    }

    public final WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast copy(@StringRes int toastResId) {
        return new WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast(toastResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast) && this.toastResId == ((WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast) other).toastResId;
        }
        return true;
    }

    public final int getToastResId() {
        return this.toastResId;
    }

    public int hashCode() {
        return this.toastResId;
    }

    public String toString() {
        return a.B(a.U("ShowToast(toastResId="), this.toastResId, ")");
    }
}
