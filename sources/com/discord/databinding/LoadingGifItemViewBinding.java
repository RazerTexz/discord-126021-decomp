package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class LoadingGifItemViewBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    public LoadingGifItemViewBinding(@NonNull CardView cardView) {
        this.a = cardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
