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
import com.discord.api.user.NsfwAllowance;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureActionBar$3<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetCallPreviewFullscreenViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    public WidgetCallPreviewFullscreen$configureActionBar$3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel$ViewState widgetCallPreviewFullscreenViewModel$ViewState) {
        this.this$0 = widgetCallPreviewFullscreen;
        this.$viewState = widgetCallPreviewFullscreenViewModel$ViewState;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        boolean z2 = this.$viewState.isChannelNsfw() && (this.$viewState.isNsfwUnconsented() || this.$viewState.getNsfwAllowed() == NsfwAllowance.DISALLOWED);
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_text_in_voice);
        boolean z3 = this.$viewState.getTextInVoiceEnabled() && this.$viewState.isConnectEnabled() && !z2;
        m.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
        menuItemFindItem.setVisible(z3);
        if (z3) {
            View actionView = menuItemFindItem.getActionView();
            TextView textView = actionView != null ? (TextView) actionView.findViewById(R$id.text_in_voice_count) : null;
            View actionView2 = menuItemFindItem.getActionView();
            ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(R$id.text_in_voice_icon) : null;
            int channelMentionsCount = this.$viewState.getChannelMentionsCount();
            if (channelMentionsCount > 0) {
                if (textView != null) {
                    ViewKt.setVisible(textView, true);
                }
                if (imageView != null) {
                    imageView.setImageResource(2131232189);
                }
                if (textView != null) {
                    textView.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), 2131231189));
                }
                if (textView != null) {
                    textView.setText(String.valueOf(Math.min(99, channelMentionsCount)));
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(this.this$0.requireContext(), 2131100487));
                }
            } else {
                if (textView != null) {
                    ViewKt.setVisible(textView, false);
                }
                if (imageView != null) {
                    imageView.setImageResource(2131232188);
                }
            }
            menuItemFindItem.getActionView().setOnClickListener(new WidgetCallPreviewFullscreen$configureActionBar$3$1(this));
        }
        MenuItem menuItemFindItem2 = menu.findItem(R$id.menu_invite);
        m.checkNotNullExpressionValue(menuItemFindItem2, "inviteMenuItem");
        menuItemFindItem2.setVisible(!z2);
    }
}
