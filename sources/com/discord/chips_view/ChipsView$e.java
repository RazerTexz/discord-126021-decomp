package com.discord.chips_view;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView$e implements Runnable {
    public final /* synthetic */ ChipsView j;
    public final /* synthetic */ boolean k;

    public ChipsView$e(ChipsView chipsView, boolean z2) {
        this.j = chipsView;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChipsView chipsView = this.j;
        boolean z2 = this.k;
        int i = ChipsView.j;
        chipsView.c(z2);
    }
}
