package com.discord.chips_view;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView$d implements Runnable {
    public final /* synthetic */ ChipsView j;

    public ChipsView$d(ChipsView chipsView) {
        this.j = chipsView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.fullScroll(130);
    }
}
