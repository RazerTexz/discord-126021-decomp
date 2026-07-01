package com.discord.widgets.guilds.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.databinding.WidgetGuildProfileEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter extends RecyclerView$Adapter<BaseEmojiViewHolder> {
    private List<? extends EmojiItem> data = n.emptyList();
    private Function0<Unit> onClickEmoji = WidgetGuildProfileSheetEmojisAdapter$onClickEmoji$1.INSTANCE;

    private final List<EmojiItem> getEmojiItems(List<? extends Emoji> emojis, int maxEmojisToShow) {
        List listTake = u.take(emojis, maxEmojisToShow);
        ArrayList arrayList = new ArrayList();
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(new EmojiItem$EmojiData((Emoji) it.next()));
        }
        int size = emojis.size() - arrayList.size();
        if (size > 0) {
            if (arrayList.size() == maxEmojisToShow) {
                arrayList.remove(n.getLastIndex(arrayList));
                size++;
            }
            arrayList.add(new EmojiItem$MoreEmoji(Math.min(size, 99)));
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType();
    }

    public final Function0<Unit> getOnClickEmoji() {
        return this.onClickEmoji;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((BaseEmojiViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends Emoji> emojis, int maxEmojisToShow) {
        m.checkNotNullParameter(emojis, "emojis");
        this.data = getEmojiItems(emojis, maxEmojisToShow);
        notifyDataSetChanged();
    }

    public final void setOnClickEmoji(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onClickEmoji = function0;
    }

    public void onBindViewHolder(BaseEmojiViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
        holder.itemView.setOnClickListener(new WidgetGuildProfileSheetEmojisAdapter$onBindViewHolder$1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public BaseEmojiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.widget_guild_profile_emoji_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
            WidgetGuildProfileEmojiItemBinding widgetGuildProfileEmojiItemBinding = new WidgetGuildProfileEmojiItemBinding(simpleDraweeView, simpleDraweeView);
            m.checkNotNullExpressionValue(widgetGuildProfileEmojiItemBinding, "WidgetGuildProfileEmojiI….context), parent, false)");
            return new EmojiViewHolder(widgetGuildProfileEmojiItemBinding);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException(a.q("invalid view type: ", viewType));
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.widget_guild_profile_emoji_extra, parent, false);
        Objects.requireNonNull(viewInflate2, "rootView");
        WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding = new WidgetGuildProfileEmojiExtraBinding((TextView) viewInflate2);
        m.checkNotNullExpressionValue(widgetGuildProfileEmojiExtraBinding, "WidgetGuildProfileEmojiE….context), parent, false)");
        return new MoreEmojiViewHolder(widgetGuildProfileEmojiExtraBinding);
    }
}
