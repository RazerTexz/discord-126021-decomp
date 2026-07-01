package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel3 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
    public static final WidgetStageChannelModeratorPermissionsViewModel3 INSTANCE = new WidgetStageChannelModeratorPermissionsViewModel3();

    public WidgetStageChannelModeratorPermissionsViewModel3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "overwrite");
        return permissionOverwrite.getType() == PermissionOverwrite.Type.MEMBER;
    }
}
