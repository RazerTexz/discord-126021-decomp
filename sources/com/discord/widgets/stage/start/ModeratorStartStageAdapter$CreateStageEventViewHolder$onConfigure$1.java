package com.discord.widgets.stage.start;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ ModeratorStartStageItem $data;
    public final /* synthetic */ ModeratorStartStageAdapter$CreateStageEventViewHolder this$0;

    public ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1(ModeratorStartStageAdapter$CreateStageEventViewHolder moderatorStartStageAdapter$CreateStageEventViewHolder, ModeratorStartStageItem moderatorStartStageItem) {
        this.this$0 = moderatorStartStageAdapter$CreateStageEventViewHolder;
        this.$data = moderatorStartStageItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.getOnItemClicked().invoke(this.$data);
    }
}
