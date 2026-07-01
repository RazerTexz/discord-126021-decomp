package com.discord.widgets.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetFriendsListAdapterItemLoadingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListLoadingAdapter extends RecyclerView$Adapter<RecyclerView$ViewHolder> {
    public static final WidgetFriendsListLoadingAdapter$Companion Companion = new WidgetFriendsListLoadingAdapter$Companion(null);
    private static final int LOADING_CELLS_COUNT = 15;

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return 15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.widget_friends_list_adapter_item_loading, parent, false);
        int i = R$id.blank_item_avatar_placeholder;
        View viewFindViewById = viewInflate.findViewById(R$id.blank_item_avatar_placeholder);
        if (viewFindViewById != null) {
            i = R$id.blank_item_username_placeholder;
            View viewFindViewById2 = viewInflate.findViewById(R$id.blank_item_username_placeholder);
            if (viewFindViewById2 != null) {
                WidgetFriendsListAdapterItemLoadingBinding widgetFriendsListAdapterItemLoadingBinding = new WidgetFriendsListAdapterItemLoadingBinding((ConstraintLayout) viewInflate, viewFindViewById, viewFindViewById2);
                m.checkNotNullExpressionValue(widgetFriendsListAdapterItemLoadingBinding, "WidgetFriendsListAdapter….context), parent, false)");
                return new FriendsListLoadingViewHolder(widgetFriendsListAdapterItemLoadingBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
