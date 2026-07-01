package com.discord.widgets.user.profile;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView$ConnectedAccountsAdapter extends MGRecyclerAdapterSimple<UserProfileConnectionsView$ConnectedAccountItem> {
    private Function3<? super String, ? super Integer, ? super String, Unit> onConnectedAccountClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileConnectionsView$ConnectedAccountsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        this.onConnectedAccountClick = UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1.INSTANCE;
    }

    public final Function3<String, Integer, String, Unit> getOnConnectedAccountClick() {
        return this.onConnectedAccountClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnConnectedAccountClick(Function3<? super String, ? super Integer, ? super String, Unit> function3) {
        m.checkNotNullParameter(function3, "<set-?>");
        this.onConnectedAccountClick = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<UserProfileConnectionsView$ConnectedAccountsAdapter, UserProfileConnectionsView$ConnectedAccountItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new UserProfileConnectionsView$ViewHolder(R$layout.icon_list_item_text_view, this);
    }
}
