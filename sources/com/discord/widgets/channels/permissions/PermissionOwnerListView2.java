package com.discord.widgets.channels.permissions;

import com.discord.widgets.channels.permissions.PermissionOwnerListView;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.PermissionOwnerListView$Adapter$onBindViewHolder$1, reason: use source file name */
/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PermissionOwnerListView.Item $item;
    public final /* synthetic */ PermissionOwnerListView.Adapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView2(PermissionOwnerListView.Adapter adapter, PermissionOwnerListView.Item item) {
        super(0);
        this.this$0 = adapter;
        this.$item = item;
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
