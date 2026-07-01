package com.discord.widgets.forums;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter extends MGRecyclerAdapterSimple<ForumBrowserItem> {
    private final RecyclerView$ItemDecoration itemDecoration;
    private final Function1<Channel, Unit> onPostClick;
    private final Function1<Channel, Unit> onPostLongClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetForumBrowserAdapter(RecyclerView recyclerView, Function1<? super Channel, Unit> function1, Function1<? super Channel, Unit> function2) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function1, "onPostClick");
        m.checkNotNullParameter(function2, "onPostLongClick");
        this.onPostClick = function1;
        this.onPostLongClick = function2;
        this.itemDecoration = new WidgetForumBrowserAdapter$itemDecoration$1(this);
    }

    public static final /* synthetic */ List access$getInternalData$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.getInternalData();
    }

    public static final /* synthetic */ Function1 access$getOnPostClick$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.onPostClick;
    }

    public static final /* synthetic */ Function1 access$getOnPostLongClick$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.onPostLongClick;
    }

    public final RecyclerView$ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, ForumBrowserItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetForumBrowserAdapter$HeaderItem(this);
        }
        if (viewType == 1) {
            return new WidgetForumBrowserAdapter$PostItem(this);
        }
        if (viewType == 2) {
            return new WidgetForumBrowserAdapter$LoadingItem(this);
        }
        throw new IllegalStateException(a.q("Invalid view type: ", viewType));
    }
}
