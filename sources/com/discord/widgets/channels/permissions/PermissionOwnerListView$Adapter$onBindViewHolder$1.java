package com.discord.widgets.channels.permissions;

import com.discord.widgets.channels.permissions.PermissionOwnerListView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView$Adapter$onBindViewHolder$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ PermissionOwnerListView.Item $item;
    public final /* synthetic */ PermissionOwnerListView.Adapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView$Adapter$onBindViewHolder$1(PermissionOwnerListView.Adapter adapter, PermissionOwnerListView.Item item) {
        super(0);
        this.this$0 = adapter;
        this.$item = item;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getOnRemoveClicked().invoke(this.$item.getPermissionOwner());
    }
}
