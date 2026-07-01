package com.discord.widgets.guilds.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.databinding.WidgetGuildProfileEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter extends RecyclerView.Adapter<WidgetGuildProfileSheetEmojisAdapter2> {
    private List<? extends WidgetGuildProfileSheetEmojisAdapter3> data = Collections2.emptyList();
    private Function0<Unit> onClickEmoji = WidgetGuildProfileSheetEmojisAdapter6.INSTANCE;

    private final List<WidgetGuildProfileSheetEmojisAdapter3> getEmojiItems(List<? extends Emoji> emojis, int maxEmojisToShow) {
        List listTake = _Collections.take(emojis, maxEmojisToShow);
        ArrayList arrayList = new ArrayList();
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(new WidgetGuildProfileSheetEmojisAdapter3.EmojiData((Emoji) it.next()));
        }
        int size = emojis.size() - arrayList.size();
        if (size > 0) {
            if (arrayList.size() == maxEmojisToShow) {
                arrayList.remove(Collections2.getLastIndex(arrayList));
                size++;
            }
            arrayList.add(new WidgetGuildProfileSheetEmojisAdapter3.MoreEmoji(Math.min(size, 99)));
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
        Intrinsics3.checkNotNullParameter(emojis, "emojis");
        this.data = getEmojiItems(emojis, maxEmojisToShow);
        notifyDataSetChanged();
    }

    public final void setOnClickEmoji(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClickEmoji = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(WidgetGuildProfileSheetEmojisAdapter2 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter.onBindViewHolder.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildProfileSheetEmojisAdapter.this.getOnClickEmoji().invoke();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetGuildProfileSheetEmojisAdapter2 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_guild_profile_emoji_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
            WidgetGuildProfileEmojiItemBinding widgetGuildProfileEmojiItemBinding = new WidgetGuildProfileEmojiItemBinding(simpleDraweeView, simpleDraweeView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildProfileEmojiItemBinding, "WidgetGuildProfileEmojiI….context), parent, false)");
            return new WidgetGuildProfileSheetEmojisAdapter4(widgetGuildProfileEmojiItemBinding);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException(outline.q("invalid view type: ", viewType));
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_guild_profile_emoji_extra, parent, false);
        Objects.requireNonNull(viewInflate2, "rootView");
        WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding = new WidgetGuildProfileEmojiExtraBinding((TextView) viewInflate2);
        Intrinsics3.checkNotNullExpressionValue(widgetGuildProfileEmojiExtraBinding, "WidgetGuildProfileEmojiE….context), parent, false)");
        return new WidgetGuildProfileSheetEmojisAdapter5(widgetGuildProfileEmojiExtraBinding);
    }
}
