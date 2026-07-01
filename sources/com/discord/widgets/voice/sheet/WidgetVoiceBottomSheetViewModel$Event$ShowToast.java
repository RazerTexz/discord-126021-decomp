package com.discord.widgets.voice.sheet;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$Event$ShowToast extends WidgetVoiceBottomSheetViewModel$Event {
    private final int toastResId;

    public WidgetVoiceBottomSheetViewModel$Event$ShowToast(@StringRes int i) {
        super(null);
        this.toastResId = i;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$Event$ShowToast copy$default(WidgetVoiceBottomSheetViewModel$Event$ShowToast widgetVoiceBottomSheetViewModel$Event$ShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetVoiceBottomSheetViewModel$Event$ShowToast.toastResId;
        }
        return widgetVoiceBottomSheetViewModel$Event$ShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getToastResId() {
        return this.toastResId;
    }

    public final WidgetVoiceBottomSheetViewModel$Event$ShowToast copy(@StringRes int toastResId) {
        return new WidgetVoiceBottomSheetViewModel$Event$ShowToast(toastResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceBottomSheetViewModel$Event$ShowToast) && this.toastResId == ((WidgetVoiceBottomSheetViewModel$Event$ShowToast) other).toastResId;
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
