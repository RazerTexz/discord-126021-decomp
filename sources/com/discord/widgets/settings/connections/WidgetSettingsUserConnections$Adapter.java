package com.discord.widgets.settings.connections;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter extends MGRecyclerAdapterSimple<WidgetSettingsUserConnections$UserConnectionItem> {
    private final FragmentManager fragmentManager;
    private final Function1<String, Unit> onJoinIntegration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsUserConnections$Adapter(RecyclerView recyclerView, FragmentManager fragmentManager, Function1<? super String, Unit> function1) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(function1, "onJoinIntegration");
        this.fragmentManager = fragmentManager;
        this.onJoinIntegration = function1;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final Function1<String, Unit> getOnJoinIntegration() {
        return this.onJoinIntegration;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetSettingsUserConnections$Adapter, WidgetSettingsUserConnections$UserConnectionItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetSettingsUserConnections$Adapter$ViewHolder(this, R$layout.widget_settings_item_connected_account, this);
    }
}
