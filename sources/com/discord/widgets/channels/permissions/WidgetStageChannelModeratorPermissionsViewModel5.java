package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel5 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel.StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissionsViewModel5(WidgetStageChannelModeratorPermissionsViewModel.StoreState storeState) {
        super(1);
        this.$storeState = storeState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "it");
        return !((WidgetStageChannelModeratorPermissionsViewModel.StoreState.Valid) this.$storeState).getGuild().isOwner(permissionOverwrite.e());
    }
}
