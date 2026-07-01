package com.discord.widgets.voice.fullscreen;

import android.view.View;
import com.discord.widgets.voice.controls.VoiceControlsSheetSwipeTooltip;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$bottomSheetCallback$1 extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$bottomSheetCallback$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onSlide(View bottomSheet, float slideOffset) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).stopIdle();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onStateChanged(View bottomSheet, int newState) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
        WidgetCallFullscreen.access$getBinding$p(this.this$0).f2248y.handleSheetState(newState);
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).handleBottomSheetState(newState);
        if (newState == 3) {
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).stopIdle();
            WidgetCallFullscreen.access$getTooltipManager$p(this.this$0).a(VoiceControlsSheetSwipeTooltip.INSTANCE);
        } else {
            if (newState != 4) {
                return;
            }
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).startIdle();
        }
    }
}
