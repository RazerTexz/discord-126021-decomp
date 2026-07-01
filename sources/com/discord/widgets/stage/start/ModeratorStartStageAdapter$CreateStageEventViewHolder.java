package com.discord.widgets.stage.start;

import android.view.View;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ModeratorStartStageAdapter$CreateStageEventViewHolder extends MGRecyclerViewHolder<ModeratorStartStageAdapter, ModeratorStartStageItem> {
    private final View rootView;
    public final /* synthetic */ ModeratorStartStageAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageAdapter$CreateStageEventViewHolder(ModeratorStartStageAdapter moderatorStartStageAdapter, View view) {
        super(view, moderatorStartStageAdapter);
        m.checkNotNullParameter(view, "rootView");
        this.this$0 = moderatorStartStageAdapter;
        this.rootView = view;
    }

    public final View getRootView() {
        return this.rootView;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ModeratorStartStageItem moderatorStartStageItem) {
        onConfigure2(i, moderatorStartStageItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ModeratorStartStageItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.rootView.setOnClickListener(new ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1(this, data));
    }
}
