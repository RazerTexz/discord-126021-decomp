package com.discord.utilities.recycler;


/* JADX INFO: compiled from: SelfHealingLinearLayoutManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelfHealingLinearLayoutManager$resetAdapter$1 implements Runnable {
    public final /* synthetic */ SelfHealingLinearLayoutManager this$0;

    public SelfHealingLinearLayoutManager$resetAdapter$1(SelfHealingLinearLayoutManager selfHealingLinearLayoutManager) {
        this.this$0 = selfHealingLinearLayoutManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SelfHealingLinearLayoutManager.access$getAdapter$p(this.this$0).notifyDataSetChanged();
        SelfHealingLinearLayoutManager.access$getRecyclerView$p(this.this$0).invalidate();
    }
}
