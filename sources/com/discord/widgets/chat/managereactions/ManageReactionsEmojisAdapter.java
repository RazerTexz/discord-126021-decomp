package com.discord.widgets.chat.managereactions;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ManageReactionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsEmojisAdapter extends MGRecyclerAdapterSimple<ManageReactionsEmojisAdapter$ReactionEmojiItem> {
    public static final ManageReactionsEmojisAdapter$Companion Companion = new ManageReactionsEmojisAdapter$Companion(null);
    private static final int TYPE_REACTION_EMOJI_ITEM = 0;
    private Function1<? super String, Unit> onEmojiSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsEmojisAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public final Function1<String, Unit> getOnEmojiSelectedListener() {
        return this.onEmojiSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnEmojiSelectedListener(Function1<? super String, Unit> function1) {
        this.onEmojiSelectedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, ManageReactionsEmojisAdapter$ReactionEmojiItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ManageReactionsEmojisAdapter$ReactionEmojiViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
