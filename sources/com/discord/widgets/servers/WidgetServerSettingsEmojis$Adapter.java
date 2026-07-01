package com.discord.widgets.servers;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter extends MGRecyclerAdapterSimple<WidgetServerSettingsEmojis$Item> {
    private Function2<? super View, ? super ModelEmojiGuild, Unit> onEmojiItemClicked;
    private Function0<Unit> onUploadEmoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Adapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onUploadEmoji = WidgetServerSettingsEmojis$Adapter$onUploadEmoji$1.INSTANCE;
        this.onEmojiItemClicked = WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1.INSTANCE;
    }

    public final Function2<View, ModelEmojiGuild, Unit> getOnEmojiItemClicked() {
        return this.onEmojiItemClicked;
    }

    public final Function0<Unit> getOnUploadEmoji() {
        return this.onUploadEmoji;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnEmojiItemClicked(Function2<? super View, ? super ModelEmojiGuild, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onEmojiItemClicked = function2;
    }

    public final void setOnUploadEmoji(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onUploadEmoji = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetServerSettingsEmojis$Adapter, WidgetServerSettingsEmojis$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder(this);
        }
        if (viewType == 1) {
            return new WidgetServerSettingsEmojis$Adapter$EmojiSectionViewHolder(this);
        }
        if (viewType == 2) {
            return new WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder(this);
        }
        if (viewType == 3) {
            return new WidgetServerSettingsEmojis$Adapter$EmojiEmptyViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
