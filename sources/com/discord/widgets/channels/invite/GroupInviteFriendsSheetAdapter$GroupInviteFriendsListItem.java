package com.discord.widgets.channels.invite;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.GroupInviteFriendsSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;

/* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem extends MGRecyclerViewHolder<GroupInviteFriendsSheetAdapter, GroupInviteFriendsSheetAdapter$FriendItem> {
    private final GroupInviteFriendsSheetItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem(@LayoutRes int i, GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter) {
        super(i, groupInviteFriendsSheetAdapter);
        m.checkNotNullParameter(groupInviteFriendsSheetAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.friends_list_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.friends_list_item_avatar);
        if (simpleDraweeView != null) {
            i2 = R$id.friends_list_item_name;
            TextView textView = (TextView) view.findViewById(R$id.friends_list_item_name);
            if (textView != null) {
                i2 = R$id.user_selected_checkbox;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R$id.user_selected_checkbox);
                if (materialCheckBox != null) {
                    GroupInviteFriendsSheetItemBinding groupInviteFriendsSheetItemBinding = new GroupInviteFriendsSheetItemBinding((ConstraintLayout) view, simpleDraweeView, textView, materialCheckBox);
                    m.checkNotNullExpressionValue(groupInviteFriendsSheetItemBinding, "GroupInviteFriendsSheetItemBinding.bind(itemView)");
                    this.binding = groupInviteFriendsSheetItemBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ GroupInviteFriendsSheetAdapter access$getAdapter$p(GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem groupInviteFriendsSheetAdapter$GroupInviteFriendsListItem) {
        return (GroupInviteFriendsSheetAdapter) groupInviteFriendsSheetAdapter$GroupInviteFriendsListItem.adapter;
    }

    public static final /* synthetic */ GroupInviteFriendsSheetItemBinding access$getBinding$p(GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem groupInviteFriendsSheetAdapter$GroupInviteFriendsListItem) {
        return groupInviteFriendsSheetAdapter$GroupInviteFriendsListItem.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, GroupInviteFriendsSheetAdapter$FriendItem groupInviteFriendsSheetAdapter$FriendItem) {
        onConfigure2(i, groupInviteFriendsSheetAdapter$FriendItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, GroupInviteFriendsSheetAdapter$FriendItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        User user = data.getUser();
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
        textView.setText(user.getUsername());
        SimpleDraweeView simpleDraweeView = this.binding.f2115b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, 2131165300, null, null, null, 56, null);
        MaterialCheckBox materialCheckBox = this.binding.d;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
        materialCheckBox.setChecked(data.isSelected());
        this.binding.d.setOnClickListener(new GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1(this, user));
    }
}
