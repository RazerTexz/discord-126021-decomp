package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ StageCallItem$MediaItem $item;
    public final /* synthetic */ MediaViewHolder this$0;

    public MediaViewHolder$onConfigure$1(MediaViewHolder mediaViewHolder, StageCallItem$MediaItem stageCallItem$MediaItem) {
        this.this$0 = mediaViewHolder;
        this.$item = stageCallItem$MediaItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MediaViewHolder.access$getAdapter$p(this.this$0).getOnMediaParticipantTapped().invoke(this.$item.getUserOrStreamParticipant());
    }
}
