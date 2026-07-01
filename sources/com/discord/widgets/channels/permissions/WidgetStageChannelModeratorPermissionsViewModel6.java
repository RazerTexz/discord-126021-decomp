package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$4, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel6 extends Lambda implements Function1<PermissionOverwrite, Long> {
    public static final WidgetStageChannelModeratorPermissionsViewModel6 INSTANCE = new WidgetStageChannelModeratorPermissionsViewModel6();

    public WidgetStageChannelModeratorPermissionsViewModel6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(PermissionOverwrite permissionOverwrite) {
        return Long.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(PermissionOverwrite permissionOverwrite) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "it");
        return permissionOverwrite.e();
    }
}
