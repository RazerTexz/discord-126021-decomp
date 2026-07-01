package com.discord.widgets.chat.input.applicationcommands;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.discord.models.commands.ApplicationCommandOption;

/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter$highlightOption$$inlined$let$lambda$1 implements Runnable {
    public final /* synthetic */ ApplicationCommandOption $commandOption$inlined;
    public final /* synthetic */ int $position;
    public final /* synthetic */ SelectedApplicationCommandAdapter this$0;

    public SelectedApplicationCommandAdapter$highlightOption$$inlined$let$lambda$1(int i, SelectedApplicationCommandAdapter selectedApplicationCommandAdapter, ApplicationCommandOption applicationCommandOption) {
        this.$position = i;
        this.this$0 = selectedApplicationCommandAdapter;
        this.$commandOption$inlined = applicationCommandOption;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$position;
        if (i == 1) {
            i = 0;
        }
        SelectedApplicationCommandAdapter.access$getScroller$p(this.this$0).setTargetPosition(i);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.this$0.getRecycler().getLayoutManager();
        if (linearLayoutManager != null) {
            linearLayoutManager.startSmoothScroll(SelectedApplicationCommandAdapter.access$getScroller$p(this.this$0));
        }
    }
}
