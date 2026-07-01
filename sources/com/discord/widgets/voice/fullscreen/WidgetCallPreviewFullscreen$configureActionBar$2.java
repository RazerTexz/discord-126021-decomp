package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureActionBar$2<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetCallPreviewFullscreenViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    public WidgetCallPreviewFullscreen$configureActionBar$2(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel$ViewState widgetCallPreviewFullscreenViewModel$ViewState) {
        this.this$0 = widgetCallPreviewFullscreen;
        this.$viewState = widgetCallPreviewFullscreenViewModel$ViewState;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364392) {
            return;
        }
        ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.this$0, this.$viewState.getVoiceChannel(), "Fullscreen Voice Channel Preview", null, null, 24, null);
    }
}
