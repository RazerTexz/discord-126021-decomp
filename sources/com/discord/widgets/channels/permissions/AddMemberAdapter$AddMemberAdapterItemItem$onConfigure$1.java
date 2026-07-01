package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ AddMemberAdapter$Item$PermissionOwnerItem $item;
    public final /* synthetic */ AddMemberAdapter$AddMemberAdapterItemItem this$0;

    public AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$1(AddMemberAdapter$AddMemberAdapterItemItem addMemberAdapter$AddMemberAdapterItemItem, AddMemberAdapter$Item$PermissionOwnerItem addMemberAdapter$Item$PermissionOwnerItem) {
        this.this$0 = addMemberAdapter$AddMemberAdapterItemItem;
        this.$item = addMemberAdapter$Item$PermissionOwnerItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AddMemberAdapter$AddMemberAdapterItemItem.access$handleClick(this.this$0, this.$item);
    }
}
