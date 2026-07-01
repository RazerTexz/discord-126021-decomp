package com.discord.widgets.voice.fullscreen;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement extends WidgetCallFullscreenViewModel$Event {
    private final int messageResId;

    public WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement(@StringRes int i) {
        super(null);
        this.messageResId = i;
    }

    public static /* synthetic */ WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement copy$default(WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement widgetCallFullscreenViewModel$Event$AccessibilityAnnouncement, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetCallFullscreenViewModel$Event$AccessibilityAnnouncement.messageResId;
        }
        return widgetCallFullscreenViewModel$Event$AccessibilityAnnouncement.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMessageResId() {
        return this.messageResId;
    }

    public final WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement copy(@StringRes int messageResId) {
        return new WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement(messageResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement) && this.messageResId == ((WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement) other).messageResId;
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
