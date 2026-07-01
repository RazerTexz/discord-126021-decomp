package com.discord.widgets.voice.sheet;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement extends WidgetVoiceBottomSheetViewModel$Event {
    private final int messageResId;

    public WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement(@StringRes int i) {
        super(null);
        this.messageResId = i;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement copy$default(WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement widgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement.messageResId;
        }
        return widgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMessageResId() {
        return this.messageResId;
    }

    public final WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement copy(@StringRes int messageResId) {
        return new WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement(messageResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement) && this.messageResId == ((WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement) other).messageResId;
        }
        return true;
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    public int hashCode() {
        return this.messageResId;
    }

    public String toString() {
        return a.B(a.U("AccessibilityAnnouncement(messageResId="), this.messageResId, ")");
    }
}
