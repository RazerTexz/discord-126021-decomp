package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageChannelModeratorPermissions$viewBinding$2 extends k implements Function1<View, WidgetStageChannelModeratorPermissionsBinding> {
    public static final WidgetStageChannelModeratorPermissions$viewBinding$2 INSTANCE = new WidgetStageChannelModeratorPermissions$viewBinding$2();

    public WidgetStageChannelModeratorPermissions$viewBinding$2() {
        super(1, WidgetStageChannelModeratorPermissionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageChannelModeratorPermissionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageChannelModeratorPermissionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.add_permission_owner_button;
        AddPermissionOwnerView addPermissionOwnerView = (AddPermissionOwnerView) view.findViewById(R$id.add_permission_owner_button);
        if (addPermissionOwnerView != null) {
            i = R$id.members_permission_owners_list;
            PermissionOwnerListView permissionOwnerListView = (PermissionOwnerListView) view.findViewById(R$id.members_permission_owners_list);
            if (permissionOwnerListView != null) {
                i = R$id.roles_permission_owners_list;
                PermissionOwnerListView permissionOwnerListView2 = (PermissionOwnerListView) view.findViewById(R$id.roles_permission_owners_list);
                if (permissionOwnerListView2 != null) {
                    return new WidgetStageChannelModeratorPermissionsBinding((CoordinatorLayout) view, addPermissionOwnerView, permissionOwnerListView, permissionOwnerListView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
