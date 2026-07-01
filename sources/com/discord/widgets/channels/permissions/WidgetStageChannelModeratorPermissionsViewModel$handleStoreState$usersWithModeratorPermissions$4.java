package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4 extends o implements Function1<PermissionOverwrite, Long> {
    public static final WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4 INSTANCE = new WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4();

    public WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(PermissionOverwrite permissionOverwrite) {
        return Long.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(PermissionOverwrite permissionOverwrite) {
        m.checkNotNullParameter(permissionOverwrite, "it");
        return permissionOverwrite.e();
    }
}
