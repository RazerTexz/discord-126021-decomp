package com.discord.widgets.channels.permissions;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$handleStoreState$usersWithModeratorPermissions$3 */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7569x81232338 extends AbstractC12240o implements Function1<PermissionOverwrite, Boolean> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel.StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7569x81232338(WidgetStageChannelModeratorPermissionsViewModel.StoreState storeState) {
        super(1);
        this.$storeState = storeState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
        return Boolean.valueOf(invoke2(permissionOverwrite));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
        C12238m.checkNotNullParameter(permissionOverwrite, "it");
        return !((WidgetStageChannelModeratorPermissionsViewModel.StoreState.Valid) this.$storeState).getGuild().isOwner(permissionOverwrite.m8131e());
    }
}
