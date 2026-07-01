package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallViewHolder$1 implements View$OnClickListener {
    public final /* synthetic */ StageCallAdapter $adapter;
    public final /* synthetic */ StageCallViewHolder this$0;

    public StageCallViewHolder$1(StageCallViewHolder stageCallViewHolder, StageCallAdapter stageCallAdapter) {
        this.this$0 = stageCallViewHolder;
        this.$adapter = stageCallAdapter;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.this$0.getAdapterPosition() != -1) {
            StageCallAdapter stageCallAdapter = this.$adapter;
            stageCallAdapter.onItemClick$app_productionGoogleRelease(stageCallAdapter.getItem(this.this$0.getAdapterPosition()));
        }
    }
}
