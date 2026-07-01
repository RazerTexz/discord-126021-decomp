package com.discord.widgets.chat.input;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAutocompleteStickerAdapter extends MGRecyclerAdapterSimple<WidgetChatInputAutocompleteStickerAdapter2> {
    private final Function1<Sticker, Unit> onClickSticker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatInputAutocompleteStickerAdapter(RecyclerView recyclerView, Function1<? super Sticker, Unit> function1) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onClickSticker");
        this.onClickSticker = function1;
    }

    public final Function1<Sticker, Unit> getOnClickSticker() {
        return this.onClickSticker;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetChatInputAutocompleteStickerAdapter2> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetChatInputAutocompleteStickerAdapter3(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
