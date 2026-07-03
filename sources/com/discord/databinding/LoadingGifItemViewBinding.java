package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class LoadingGifItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f15182a;

    public LoadingGifItemViewBinding(@NonNull CardView cardView) {
        this.f15182a = cardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15182a;
    }
}
