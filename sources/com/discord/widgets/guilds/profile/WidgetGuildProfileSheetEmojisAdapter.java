package com.discord.widgets.guilds.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.databinding.WidgetGuildProfileEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter extends RecyclerView.Adapter<BaseEmojiViewHolder> {
    private List<? extends EmojiItem> data = C12147n.emptyList();
    private Function0<Unit> onClickEmoji = WidgetGuildProfileSheetEmojisAdapter$onClickEmoji$1.INSTANCE;

    private final List<EmojiItem> getEmojiItems(List<? extends Emoji> emojis, int maxEmojisToShow) {
        List listTake = C12163u.take(emojis, maxEmojisToShow);
        ArrayList arrayList = new ArrayList();
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(new EmojiItem.EmojiData((Emoji) it.next()));
        }
        int size = emojis.size() - arrayList.size();
        if (size > 0) {
            if (arrayList.size() == maxEmojisToShow) {
                arrayList.remove(C12147n.getLastIndex(arrayList));
                size++;
            }
            arrayList.add(new EmojiItem.MoreEmoji(Math.min(size, 99)));
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType();
    }

    public final Function0<Unit> getOnClickEmoji() {
        return this.onClickEmoji;
    }

    public final void setData(List<? extends Emoji> emojis, int maxEmojisToShow) {
        C12238m.checkNotNullParameter(emojis, "emojis");
        this.data = getEmojiItems(emojis, maxEmojisToShow);
        notifyDataSetChanged();
    }

    public final void setOnClickEmoji(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onClickEmoji = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseEmojiViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter.onBindViewHolder.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildProfileSheetEmojisAdapter.this.getOnClickEmoji().invoke();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseEmojiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_guild_profile_emoji_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
            WidgetGuildProfileEmojiItemBinding widgetGuildProfileEmojiItemBinding = new WidgetGuildProfileEmojiItemBinding(simpleDraweeView, simpleDraweeView);
            C12238m.checkNotNullExpressionValue(widgetGuildProfileEmojiItemBinding, "WidgetGuildProfileEmojiI….context), parent, false)");
            return new EmojiViewHolder(widgetGuildProfileEmojiItemBinding);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException(C1643a.m871q("invalid view type: ", viewType));
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_guild_profile_emoji_extra, parent, false);
        Objects.requireNonNull(viewInflate2, "rootView");
        WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding = new WidgetGuildProfileEmojiExtraBinding((TextView) viewInflate2);
        C12238m.checkNotNullExpressionValue(widgetGuildProfileEmojiExtraBinding, "WidgetGuildProfileEmojiE….context), parent, false)");
        return new MoreEmojiViewHolder(widgetGuildProfileEmojiExtraBinding);
    }
}
