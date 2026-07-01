package com.discord.widgets.settings.account;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter extends MGRecyclerAdapterSimple<WidgetSettingsBlockedUsersViewModel$Item> {
    private Function1<? super User, Unit> onClickUnblock;
    private Function1<? super User, Unit> onClickUserProfile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsBlockedUsersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickUnblock = WidgetSettingsBlockedUsersAdapter$onClickUnblock$1.INSTANCE;
        this.onClickUserProfile = WidgetSettingsBlockedUsersAdapter$onClickUserProfile$1.INSTANCE;
    }

    public final Function1<User, Unit> getOnClickUnblock() {
        return this.onClickUnblock;
    }

    public final Function1<User, Unit> getOnClickUserProfile() {
        return this.onClickUserProfile;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickUnblock(Function1<? super User, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickUnblock = function1;
    }

    public final void setOnClickUserProfile(Function1<? super User, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickUserProfile = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetSettingsBlockedUsersAdapter, WidgetSettingsBlockedUsersViewModel$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder(R$layout.widget_settings_item_blocked_user, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
