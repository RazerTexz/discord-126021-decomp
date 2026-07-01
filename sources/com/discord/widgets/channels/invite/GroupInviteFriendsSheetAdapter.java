package com.discord.widgets.channels.invite;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter extends MGRecyclerAdapterSimple<GroupInviteFriendsSheetAdapter$FriendItem> {
    private final Function2<User, Boolean, Unit> onUserChecked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupInviteFriendsSheetAdapter(RecyclerView recyclerView, Function2<? super User, ? super Boolean, Unit> function2) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function2, "onUserChecked");
        this.onUserChecked = function2;
    }

    public final Function2<User, Boolean, Unit> getOnUserChecked() {
        return this.onUserChecked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, GroupInviteFriendsSheetAdapter$FriendItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem(R$layout.group_invite_friends_sheet_item, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
