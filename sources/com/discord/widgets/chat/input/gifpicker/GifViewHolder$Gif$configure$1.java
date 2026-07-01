package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifViewHolder$Gif$configure$1 implements View$OnClickListener {
    public final /* synthetic */ GifAdapterItem$GifItem $gifItem;
    public final /* synthetic */ Function1 $onSelectGif;

    public GifViewHolder$Gif$configure$1(Function1 function1, GifAdapterItem$GifItem gifAdapterItem$GifItem) {
        this.$onSelectGif = function1;
        this.$gifItem = gifAdapterItem$GifItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$onSelectGif;
        if (function1 != null) {
        }
    }
}
