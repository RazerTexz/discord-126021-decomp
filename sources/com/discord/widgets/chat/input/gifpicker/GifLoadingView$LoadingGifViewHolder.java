package com.discord.widgets.chat.input.gifpicker;

import android.content.res.Resources;
import android.view.ViewGroup$LayoutParams;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.LoadingGifItemViewBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: GifLoadingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifLoadingView$LoadingGifViewHolder extends RecyclerView$ViewHolder {
    private final LoadingGifItemViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView$LoadingGifViewHolder(LoadingGifItemViewBinding loadingGifItemViewBinding) {
        super(loadingGifItemViewBinding.a);
        m.checkNotNullParameter(loadingGifItemViewBinding, "binding");
        this.binding = loadingGifItemViewBinding;
    }

    public final void configure(int heightDp) {
        CardView cardView = this.binding.a;
        m.checkNotNullExpressionValue(cardView, "binding.root");
        ViewGroup$LayoutParams layoutParams = cardView.getLayoutParams();
        CardView cardView2 = this.binding.a;
        m.checkNotNullExpressionValue(cardView2, "binding.root");
        Resources resources = cardView2.getResources();
        m.checkNotNullExpressionValue(resources, "binding.root.resources");
        layoutParams.height = (int) (heightDp * resources.getDisplayMetrics().density);
        CardView cardView3 = this.binding.a;
        m.checkNotNullExpressionValue(cardView3, "binding.root");
        cardView3.setLayoutParams(layoutParams);
    }
}
