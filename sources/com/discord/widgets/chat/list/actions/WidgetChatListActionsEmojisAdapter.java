package com.discord.widgets.chat.list.actions;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.list.actions.WidgetChatListActionsEmojisAdapter2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter extends MGRecyclerAdapterSimple<WidgetChatListActionsEmojisAdapter2> {
    private Function1<? super Emoji, Unit> onClickEmoji;
    private Function0<Unit> onClickMoreEmojis;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickEmoji = WidgetChatListActionsEmojisAdapter5.INSTANCE;
        this.onClickMoreEmojis = WidgetChatListActionsEmojisAdapter6.INSTANCE;
    }

    private final List<WidgetChatListActionsEmojisAdapter2> getEmojiItems(List<? extends Emoji> emojis, int emojisToShow) {
        if (emojis.isEmpty() || emojisToShow <= 0) {
            return Collections2.emptyList();
        }
        List listTake = _Collections.take(emojis, emojisToShow - 1);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listTake, 10));
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(new WidgetChatListActionsEmojisAdapter2.EmojiData((Emoji) it.next()));
        }
        List<WidgetChatListActionsEmojisAdapter2> mutableList = _Collections.toMutableList((Collection) arrayList);
        mutableList.add(WidgetChatListActionsEmojisAdapter2.MoreEmoji.INSTANCE);
        return mutableList;
    }

    public final Function1<Emoji, Unit> getOnClickEmoji() {
        return this.onClickEmoji;
    }

    public final Function0<Unit> getOnClickMoreEmojis() {
        return this.onClickMoreEmojis;
    }

    public final void setData(List<? extends Emoji> emojis, int emojisToShow) {
        Intrinsics3.checkNotNullParameter(emojis, "emojis");
        setData(getEmojiItems(emojis, emojisToShow));
    }

    public final void setOnClickEmoji(Function1<? super Emoji, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickEmoji = function1;
    }

    public final void setOnClickMoreEmojis(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClickMoreEmojis = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetChatListActionsEmojisAdapter2> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetChatListActionsEmojisAdapter3(this);
        }
        if (viewType == 1) {
            return new WidgetChatListActionsEmojisAdapter4(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
