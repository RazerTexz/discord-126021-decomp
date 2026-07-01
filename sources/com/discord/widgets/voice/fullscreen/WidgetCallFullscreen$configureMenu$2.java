package com.discord.widgets.voice.fullscreen;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureMenu$2<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureMenu$2(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        this.this$0 = widgetCallFullscreen;
        this.$viewState = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_text_in_voice);
        boolean zContains = this.$viewState.getMenuItems().contains(WidgetCallFullscreenViewModel$MenuItem.TEXT_IN_VOICE);
        m.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
        menuItemFindItem.setVisible(zContains);
        if (zContains) {
            View actionView = menuItemFindItem.getActionView();
            TextView textView = actionView != null ? (TextView) actionView.findViewById(R$id.text_in_voice_count) : null;
            View actionView2 = menuItemFindItem.getActionView();
            ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(R$id.text_in_voice_icon) : null;
            int textInVoiceMentionsCount = this.$viewState.getTextInVoiceMentionsCount();
            int textInVoiceUnreadsCount = this.$viewState.getTextInVoiceUnreadsCount();
            if (textInVoiceMentionsCount > 0) {
                if (textView != null) {
                    ViewKt.setVisible(textView, true);
                }
                if (imageView != null) {
                    imageView.setImageResource(2131232190);
                }
                if (textView != null) {
                    textView.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), 2131231189));
                }
                if (textView != null) {
                    textView.setText(String.valueOf(Math.min(99, textInVoiceMentionsCount)));
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), 2131100487));
                }
            } else if (textInVoiceUnreadsCount > 0) {
                if (textView != null) {
                    ViewKt.setVisible(textView, true);
                }
                if (imageView != null) {
                    imageView.setImageResource(2131232190);
                }
                if (textView != null) {
                    textView.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), 2131231191));
                }
                if (textView != null) {
                    textView.setText(String.valueOf(Math.min(99, textInVoiceUnreadsCount)));
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), 2131099689));
                }
            } else {
                if (imageView != null) {
                    imageView.setImageResource(2131232191);
                }
                if (textView != null) {
                    ViewKt.setVisible(textView, false);
                }
            }
            menuItemFindItem.getActionView().setOnClickListener(new WidgetCallFullscreen$configureMenu$2$1(this));
        }
        MenuItem menuItemFindItem2 = menu.findItem(R$id.menu_call_switch_camera);
        m.checkNotNullExpressionValue(menuItemFindItem2, "switchCameraMenuItem");
        menuItemFindItem2.setVisible(this.$viewState.getMenuItems().contains(WidgetCallFullscreenViewModel$MenuItem.SWITCH_CAMERA));
        MenuItem menuItemFindItem3 = menu.findItem(R$id.menu_call_voice_settings);
        m.checkNotNullExpressionValue(menuItemFindItem3, "voiceSettingsMenuItem");
        menuItemFindItem3.setVisible(this.$viewState.getMenuItems().contains(WidgetCallFullscreenViewModel$MenuItem.VOICE_SETTINGS));
        MenuItem menuItemFindItem4 = menu.findItem(R$id.menu_call_overlay_launcher);
        m.checkNotNullExpressionValue(menuItemFindItem4, "overlayLauncherMenuItem");
        menuItemFindItem4.setVisible(this.$viewState.getMenuItems().contains(WidgetCallFullscreenViewModel$MenuItem.LAUNCH_OVERLAY));
        MenuItem menuItemFindItem5 = menu.findItem(R$id.menu_call_video_list);
        m.checkNotNullExpressionValue(menuItemFindItem5, "listMenuItem");
        menuItemFindItem5.setVisible(this.$viewState.getMenuItems().contains(WidgetCallFullscreenViewModel$MenuItem.SHOW_PARTICIPANT_LIST));
    }
}
