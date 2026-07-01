package com.discord.widgets.channels.threads.browser;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter extends MGRecyclerAdapterSimple<WidgetThreadBrowserAdapter$Item> {
    private final Function1<Channel, Unit> onOpenThread;
    private final Function1<Channel, Unit> onThreadSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadBrowserAdapter(RecyclerView recyclerView, Function1<? super Channel, Unit> function1, Function1<? super Channel, Unit> function2) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function1, "onOpenThread");
        m.checkNotNullParameter(function2, "onThreadSettings");
        this.onOpenThread = function1;
        this.onThreadSettings = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onThreadClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.onOpenThread.invoke(channel);
    }

    public final void onThreadLongClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.onThreadSettings.invoke(channel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, WidgetThreadBrowserAdapter$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        int iOrdinal = WidgetThreadBrowserAdapter$ItemType.Companion.fromOrdinal(viewType).ordinal();
        if (iOrdinal == 0) {
            return new WidgetThreadBrowserAdapter$WarningItem(this);
        }
        if (iOrdinal == 1) {
            return new WidgetThreadBrowserAdapter$ThreadItem(this);
        }
        if (iOrdinal == 2) {
            return new WidgetThreadBrowserAdapter$HeaderItem(this);
        }
        if (iOrdinal == 3) {
            return new WidgetThreadBrowserAdapter$LoadingItem(this);
        }
        throw new NoWhenBranchMatchedException();
    }
}
