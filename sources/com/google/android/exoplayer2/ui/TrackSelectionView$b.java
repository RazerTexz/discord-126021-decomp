package com.google.android.exoplayer2.ui;

import android.view.View;
import android.view.View$OnClickListener;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class TrackSelectionView$b implements View$OnClickListener {
    public final /* synthetic */ TrackSelectionView j;

    public TrackSelectionView$b(TrackSelectionView trackSelectionView, TrackSelectionView$a trackSelectionView$a) {
        this.j = trackSelectionView;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        TrackSelectionView trackSelectionView = this.j;
        if (view == trackSelectionView.l) {
            trackSelectionView.t = true;
            trackSelectionView.o.clear();
        } else {
            if (view != trackSelectionView.m) {
                trackSelectionView.t = false;
                Object tag = view.getTag();
                Objects.requireNonNull(tag);
                trackSelectionView.o.get(((TrackSelectionView$c) tag).a);
                Objects.requireNonNull(null);
                throw null;
            }
            trackSelectionView.t = false;
            trackSelectionView.o.clear();
        }
        trackSelectionView.a();
    }
}
