package com.discord.panels;

import android.view.View;
import android.view.View$OnLayoutChangeListener;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class OverlappingPanelsLayout$b implements View$OnLayoutChangeListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public OverlappingPanelsLayout$b(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this.j;
        if (i9 == 0) {
            if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) && i3 != i7) {
                OverlappingPanelsLayout.access$handleStartPanelWidthUpdate((OverlappingPanelsLayout) this.k);
                return;
            } else {
                if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) || i == i5) {
                    return;
                }
                OverlappingPanelsLayout.access$handleStartPanelWidthUpdate((OverlappingPanelsLayout) this.k);
                return;
            }
        }
        if (i9 != 1) {
            throw null;
        }
        if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) && i != i5) {
            OverlappingPanelsLayout.access$handleEndPanelWidthUpdate((OverlappingPanelsLayout) this.k);
        } else {
            if (OverlappingPanelsLayout.access$isLeftToRight$p((OverlappingPanelsLayout) this.k) || i3 == i7) {
                return;
            }
            OverlappingPanelsLayout.access$handleEndPanelWidthUpdate((OverlappingPanelsLayout) this.k);
        }
    }
}
