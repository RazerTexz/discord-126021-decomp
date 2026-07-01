package com.discord.widgets.chat.list;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.discord.player.AppMediaPlayer;
import com.discord.player.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import d0.z.d.m;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineMediaView$updateUI$5 implements View$OnClickListener {
    public final /* synthetic */ MediaSource $mediaSource;
    public final /* synthetic */ InlineMediaView this$0;

    public InlineMediaView$updateUI$5(InlineMediaView inlineMediaView, MediaSource mediaSource) {
        this.this$0 = inlineMediaView;
        this.$mediaSource = mediaSource;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PlayerView playerView = InlineMediaView.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        playerView.setVisibility(0);
        AppMediaPlayer appMediaPlayerAccess$getAppMediaPlayer$p = InlineMediaView.access$getAppMediaPlayer$p(this.this$0);
        if (appMediaPlayerAccess$getAppMediaPlayer$p != null) {
            MediaSource mediaSource = this.$mediaSource;
            PlayerView playerView2 = InlineMediaView.access$getBinding$p(this.this$0).f;
            m.checkNotNullExpressionValue(playerView2, "binding.inlineMediaPlayerView");
            AppMediaPlayer.b(appMediaPlayerAccess$getAppMediaPlayer$p, mediaSource, true, false, 0L, playerView2, null, 40);
        }
        ImageView imageView = InlineMediaView.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(imageView, "binding.inlineMediaPlayButton");
        imageView.setVisibility(8);
        ProgressBar progressBar = InlineMediaView.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
        progressBar.setVisibility(0);
    }
}
