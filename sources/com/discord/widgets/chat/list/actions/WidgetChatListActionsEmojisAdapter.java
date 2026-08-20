package com.discord.widgets.chat.list.actions;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter extends MGRecyclerAdapterSimple<EmojiItem> {
    private Function1<? super Emoji, Unit> onClickEmoji;
    private Function0<Unit> onClickMoreEmojis;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickEmoji = WidgetChatListActionsEmojisAdapter$onClickEmoji$1.INSTANCE;
        this.onClickMoreEmojis = WidgetChatListActionsEmojisAdapter$onClickMoreEmojis$1.INSTANCE;
    }

    private final List<EmojiItem> getEmojiItems(List<? extends Emoji> emojis, int emojisToShow) {
        if (emojis.isEmpty() || emojisToShow <= 0) {
            return C12147n.emptyList();
        }
        List listTake = C12163u.take(emojis, emojisToShow - 1);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listTake, 10));
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(new EmojiItem.EmojiData((Emoji) it.next()));
        }
        List<EmojiItem> mutableList = C12163u.toMutableList((Collection) arrayList);
        mutableList.add(EmojiItem.MoreEmoji.INSTANCE);
        return mutableList;
    }

    public final Function1<Emoji, Unit> getOnClickEmoji() {
        return this.onClickEmoji;
    }

    public final Function0<Unit> getOnClickMoreEmojis() {
        return this.onClickMoreEmojis;
    }

    public final void setData(List<? extends Emoji> emojis, int emojisToShow) {
        C12238m.checkNotNullParameter(emojis, "emojis");
        setData(getEmojiItems(emojis, emojisToShow));
    }

    public final void setOnClickEmoji(Function1<? super Emoji, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickEmoji = function1;
    }

    public final void setOnClickMoreEmojis(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onClickMoreEmojis = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, EmojiItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new EmojiViewHolder(this);
        }
        if (viewType == 1) {
            return new MoreEmojisViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
