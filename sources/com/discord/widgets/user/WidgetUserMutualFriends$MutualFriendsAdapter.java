package com.discord.widgets.user;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.user.profile.WidgetUserProfileEmptyListItem;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$MutualFriendsAdapter extends MGRecyclerAdapterSimple<WidgetUserMutualFriends$Model$Item> {
    private final AppFragment fragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualFriends$MutualFriendsAdapter(RecyclerView recyclerView, AppFragment appFragment) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(appFragment, "fragment");
        this.fragment = appFragment;
    }

    public static final /* synthetic */ AppFragment access$getFragment$p(WidgetUserMutualFriends$MutualFriendsAdapter widgetUserMutualFriends$MutualFriendsAdapter) {
        return widgetUserMutualFriends$MutualFriendsAdapter.fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, WidgetUserMutualFriends$Model$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetUserProfileEmptyListItem(R$layout.widget_user_profile_adapter_item_empty, this, 2130969607, 2131893268);
        }
        if (viewType == 1) {
            return new WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
