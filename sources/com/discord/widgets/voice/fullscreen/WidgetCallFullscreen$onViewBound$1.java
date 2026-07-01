package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$onViewBound$1 extends AccessibilityDelegateCompat {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$onViewBound$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        Integer numValueOf = event != null ? Integer.valueOf(event.getEventType()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 8) || (numValueOf != null && numValueOf.intValue() == 32768)) {
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).disableControlFading();
        }
        return super.onRequestSendAccessibilityEvent(host, child, event);
    }
}
