package com.discord.widgets.channels.permissions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView$Adapter$onRemoveClicked$1 extends o implements Function1<PermissionOwner, Unit> {
    public static final PermissionOwnerListView$Adapter$onRemoveClicked$1 INSTANCE = new PermissionOwnerListView$Adapter$onRemoveClicked$1();

    public PermissionOwnerListView$Adapter$onRemoveClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
        invoke2(permissionOwner);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PermissionOwner permissionOwner) {
        m.checkNotNullParameter(permissionOwner, "it");
    }
}
