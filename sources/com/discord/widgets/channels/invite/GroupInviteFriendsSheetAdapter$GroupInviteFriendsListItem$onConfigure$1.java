package com.discord.widgets.channels.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.user.User;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;

/* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ User $modelUser;
    public final /* synthetic */ GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem this$0;

    public GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1(GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem groupInviteFriendsSheetAdapter$GroupInviteFriendsListItem, User user) {
        this.this$0 = groupInviteFriendsSheetAdapter$GroupInviteFriendsListItem;
        this.$modelUser = user;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MaterialCheckBox materialCheckBox = GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
        GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem.access$getAdapter$p(this.this$0).getOnUserChecked().invoke(this.$modelUser, Boolean.valueOf(materialCheckBox.isChecked()));
    }
}
