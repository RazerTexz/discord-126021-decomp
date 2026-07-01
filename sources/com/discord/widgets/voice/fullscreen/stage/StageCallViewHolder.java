package com.discord.widgets.voice.fullscreen.stage;

import androidx.annotation.LayoutRes;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class StageCallViewHolder extends MGRecyclerViewHolder<StageCallAdapter, StageCallItem> {
    public /* synthetic */ StageCallViewHolder(int i, StageCallAdapter stageCallAdapter, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, stageCallAdapter);
    }

    private StageCallViewHolder(@LayoutRes int i, StageCallAdapter stageCallAdapter) {
        super(i, stageCallAdapter);
        this.itemView.setOnClickListener(new StageCallViewHolder$1(this, stageCallAdapter));
    }
}
