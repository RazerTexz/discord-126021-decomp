package com.discord.widgets.chat.input.gifpicker;

import androidx.cardview.widget.CardView;
import com.discord.databinding.GifItemViewBinding;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifViewHolder$Gif extends GifViewHolder {
    private final GifItemViewBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public GifViewHolder$Gif(GifItemViewBinding gifItemViewBinding) {
        m.checkNotNullParameter(gifItemViewBinding, "binding");
        CardView cardView = gifItemViewBinding.a;
        m.checkNotNullExpressionValue(cardView, "binding.root");
        super(cardView, null);
        this.binding = gifItemViewBinding;
        this.itemView.setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(GifViewHolder$Gif gifViewHolder$Gif, GifAdapterItem$GifItem gifAdapterItem$GifItem, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        gifViewHolder$Gif.configure(gifAdapterItem$GifItem, i, function1);
    }

    private final void setGifImage(ModelGif gif) {
        String gifImageUrl = gif.getGifImageUrl();
        SimpleDraweeView simpleDraweeView = this.binding.f2112b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.gifItemImage");
        MGImages.setImage$default(simpleDraweeView, d0.t.m.listOf(gifImageUrl), 0, 0, false, null, null, null, 252, null);
    }

    public final void configure(GifAdapterItem$GifItem gifItem, int columnWidthPx, Function1<? super GifAdapterItem$GifItem, Unit> onSelectGif) {
        m.checkNotNullParameter(gifItem, "gifItem");
        ModelGif gif = gifItem.getGif();
        float height = columnWidthPx * (gif.getHeight() / gif.getWidth());
        CardView cardView = this.binding.a;
        m.checkNotNullExpressionValue(cardView, "binding.root");
        cardView.getLayoutParams().height = (int) height;
        setGifImage(gif);
        this.binding.a.setOnClickListener(new GifViewHolder$Gif$configure$1(onSelectGif, gifItem));
    }
}
