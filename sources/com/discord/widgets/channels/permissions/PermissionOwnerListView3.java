package com.discord.widgets.channels.permissions;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.PermissionOwnerListView$Adapter$onRemoveClicked$1, reason: use source file name */
/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView3 extends Lambda implements Function1<PermissionOwner, Unit> {
    public static final PermissionOwnerListView3 INSTANCE = new PermissionOwnerListView3();

    public PermissionOwnerListView3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
        invoke2(permissionOwner);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PermissionOwner permissionOwner) {
        Intrinsics3.checkNotNullParameter(permissionOwner, "it");
    }
}
