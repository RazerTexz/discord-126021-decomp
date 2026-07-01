package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.R$id;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.DiscordOverlayService$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$Companion;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureMenu$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureMenu$1(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        this.this$0 = widgetCallFullscreen;
        this.$viewState = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_call_overlay_launcher /* 2131364365 */:
                DiscordOverlayService$Companion discordOverlayService$Companion = DiscordOverlayService.Companion;
                m.checkNotNullExpressionValue(context, "context");
                discordOverlayService$Companion.launchForConnect(context);
                break;
            case R$id.menu_call_switch_camera /* 2131364366 */:
                WidgetCallFullscreen.access$getViewModel$p(this.this$0).switchCameraInputPressed();
                break;
            case R$id.menu_call_video_list /* 2131364367 */:
                WidgetVoiceBottomSheet$Companion widgetVoiceBottomSheet$Companion = WidgetVoiceBottomSheet.Companion;
                FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                widgetVoiceBottomSheet$Companion.show(parentFragmentManager, this.$viewState.getCallModel().getChannel().getId(), false, WidgetVoiceBottomSheet$FeatureContext.FULLSCREEN_CALL).setOnStreamPreviewClickedListener(new WidgetCallFullscreen$configureMenu$1$1(this));
                break;
            case R$id.menu_call_voice_settings /* 2131364368 */:
                WidgetVoiceSettingsBottomSheet$Companion widgetVoiceSettingsBottomSheet$Companion = WidgetVoiceSettingsBottomSheet.Companion;
                Long lValueOf = Long.valueOf(this.$viewState.getCallModel().getChannel().getId());
                FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                widgetVoiceSettingsBottomSheet$Companion.show(lValueOf, parentFragmentManager2);
                break;
        }
    }
}
