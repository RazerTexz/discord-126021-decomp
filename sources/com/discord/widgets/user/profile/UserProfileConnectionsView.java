package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.UserProfileConnectionsViewBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView extends LinearLayout {
    private final UserProfileConnectionsViewBinding binding;
    private final UserProfileConnectionsView$ConnectedAccountsAdapter connectedAccountsAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileConnectionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.user_profile_connections_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.user_profile_connections_mutual_friends_item;
        TextView textView = (TextView) viewInflate.findViewById(R$id.user_profile_connections_mutual_friends_item);
        if (textView != null) {
            i = R$id.user_profile_connections_mutual_guilds_item;
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.user_profile_connections_mutual_guilds_item);
            if (textView2 != null) {
                i = R$id.user_profile_connections_view_recycler;
                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.user_profile_connections_view_recycler);
                if (recyclerView != null) {
                    UserProfileConnectionsViewBinding userProfileConnectionsViewBinding = new UserProfileConnectionsViewBinding((LinearLayout) viewInflate, textView, textView2, recyclerView);
                    m.checkNotNullExpressionValue(userProfileConnectionsViewBinding, "UserProfileConnectionsVi…rom(context), this, true)");
                    this.binding = userProfileConnectionsViewBinding;
                    MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
                    m.checkNotNullExpressionValue(recyclerView, "binding.userProfileConnectionsViewRecycler");
                    this.connectedAccountsAdapter = (UserProfileConnectionsView$ConnectedAccountsAdapter) mGRecyclerAdapter$Companion.configure(new UserProfileConnectionsView$ConnectedAccountsAdapter(recyclerView));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.binding.d.setHasFixedSize(false);
        ViewCompat.setNestedScrollingEnabled(this.binding.d, false);
    }

    public final void updateViewState(UserProfileConnectionsView$ViewState viewState, Function3<? super String, ? super Integer, ? super String, Unit> onConnectedAccountClick, Function0<Unit> onMutualGuildsItemClick, Function0<Unit> onMutualFriendsItemClick) {
        m.checkNotNullParameter(viewState, "viewState");
        m.checkNotNullParameter(onConnectedAccountClick, "onConnectedAccountClick");
        m.checkNotNullParameter(onMutualGuildsItemClick, "onMutualGuildsItemClick");
        m.checkNotNullParameter(onMutualFriendsItemClick, "onMutualFriendsItemClick");
        this.connectedAccountsAdapter.setOnConnectedAccountClick(new UserProfileConnectionsView$updateViewState$1(onConnectedAccountClick));
        this.connectedAccountsAdapter.setData(viewState.getConnectedAccountItems());
        this.binding.c.setOnClickListener(new UserProfileConnectionsView$updateViewState$2(onMutualGuildsItemClick));
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.userProfileConnectionsMutualGuildsItem");
        textView.setVisibility(viewState.getShowMutualGuildsAndFriends() ? 0 : 8);
        this.binding.f2164b.setOnClickListener(new UserProfileConnectionsView$updateViewState$3(onMutualFriendsItemClick));
        TextView textView2 = this.binding.f2164b;
        m.checkNotNullExpressionValue(textView2, "binding.userProfileConnectionsMutualFriendsItem");
        textView2.setVisibility(viewState.getShowMutualGuildsAndFriends() ? 0 : 8);
    }
}
