package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.annotation.LayoutRes;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class StageCallViewHolder extends MGRecyclerViewHolder<StageCallAdapter, StageCallItem> {
    public /* synthetic */ StageCallViewHolder(int i, StageCallAdapter stageCallAdapter, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, stageCallAdapter);
    }

    private StageCallViewHolder(@LayoutRes int i, final StageCallAdapter stageCallAdapter) {
        super(i, stageCallAdapter);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.stage.StageCallViewHolder.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (StageCallViewHolder.this.getAdapterPosition() != -1) {
                    StageCallAdapter stageCallAdapter2 = stageCallAdapter;
                    stageCallAdapter2.onItemClick$app_productionGoogleRelease(stageCallAdapter2.getItem(StageCallViewHolder.this.getAdapterPosition()));
                }
            }
        });
    }
}
