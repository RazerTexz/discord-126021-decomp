package com.discord.widgets.channels.permissions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView$Adapter$onBindViewHolder$1 extends o implements Function0<Unit> {
    public final /* synthetic */ PermissionOwnerListView$Item $item;
    public final /* synthetic */ PermissionOwnerListView$Adapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView$Adapter$onBindViewHolder$1(PermissionOwnerListView$Adapter permissionOwnerListView$Adapter, PermissionOwnerListView$Item permissionOwnerListView$Item) {
        super(0);
        this.this$0 = permissionOwnerListView$Adapter;
        this.$item = permissionOwnerListView$Item;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getOnRemoveClicked().invoke(this.$item.getPermissionOwner());
    }
}
