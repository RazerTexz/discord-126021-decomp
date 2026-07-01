package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$viewBinding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageChannelModeratorPermissions3 extends FunctionReferenceImpl implements Function1<View, WidgetStageChannelModeratorPermissionsBinding> {
    public static final WidgetStageChannelModeratorPermissions3 INSTANCE = new WidgetStageChannelModeratorPermissions3();

    public WidgetStageChannelModeratorPermissions3() {
        super(1, WidgetStageChannelModeratorPermissionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStageChannelModeratorPermissionsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_permission_owner_button;
        AddPermissionOwnerView addPermissionOwnerView = (AddPermissionOwnerView) view.findViewById(R.id.add_permission_owner_button);
        if (addPermissionOwnerView != null) {
            i = R.id.members_permission_owners_list;
            PermissionOwnerListView permissionOwnerListView = (PermissionOwnerListView) view.findViewById(R.id.members_permission_owners_list);
            if (permissionOwnerListView != null) {
                i = R.id.roles_permission_owners_list;
                PermissionOwnerListView permissionOwnerListView2 = (PermissionOwnerListView) view.findViewById(R.id.roles_permission_owners_list);
                if (permissionOwnerListView2 != null) {
                    return new WidgetStageChannelModeratorPermissionsBinding((CoordinatorLayout) view, addPermissionOwnerView, permissionOwnerListView, permissionOwnerListView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
