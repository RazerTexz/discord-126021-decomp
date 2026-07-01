package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsView$configureScreenShareButtonSparkle$1 implements View$OnClickListener {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WidgetVoiceBottomSheet$FeatureContext $featureContext;
    public final /* synthetic */ boolean $forwardToFullscreenIfVideoActivated;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Function0 $onNavigateToScreenShareNfxSheet;
    public final /* synthetic */ Function0 $onScreenSharePressed;
    public final /* synthetic */ AnchoredVoiceControlsView this$0;

    public AnchoredVoiceControlsView$configureScreenShareButtonSparkle$1(AnchoredVoiceControlsView anchoredVoiceControlsView, FragmentManager fragmentManager, long j, long j2, boolean z2, WidgetVoiceBottomSheet$FeatureContext widgetVoiceBottomSheet$FeatureContext, Function0 function0, Function0 function1) {
        this.this$0 = anchoredVoiceControlsView;
        this.$fragmentManager = fragmentManager;
        this.$channelId = j;
        this.$guildId = j2;
        this.$forwardToFullscreenIfVideoActivated = z2;
        this.$featureContext = widgetVoiceBottomSheet$FeatureContext;
        this.$onNavigateToScreenShareNfxSheet = function0;
        this.$onScreenSharePressed = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AnchoredVoiceControlsView.access$getTooltipManager$p(this.this$0).a(ScreenShareButtonSparkleTooltip.INSTANCE);
        WidgetScreenShareNfxSheet$Companion widgetScreenShareNfxSheet$Companion = WidgetScreenShareNfxSheet.Companion;
        if (!widgetScreenShareNfxSheet$Companion.canShow()) {
            this.$onScreenSharePressed.invoke();
        } else {
            widgetScreenShareNfxSheet$Companion.show(this.$fragmentManager, this.$channelId, this.$guildId, new WidgetScreenShareNfxSheet$VoiceBottomSheetParams(this.$forwardToFullscreenIfVideoActivated, this.$featureContext));
            this.$onNavigateToScreenShareNfxSheet.invoke();
        }
    }
}
