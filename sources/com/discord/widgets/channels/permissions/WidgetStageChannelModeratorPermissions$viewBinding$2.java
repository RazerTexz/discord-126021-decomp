package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageChannelModeratorPermissions$viewBinding$2 extends C12236k implements Function1<View, WidgetStageChannelModeratorPermissionsBinding> {
    public static final WidgetStageChannelModeratorPermissions$viewBinding$2 INSTANCE = new WidgetStageChannelModeratorPermissions$viewBinding$2();

    public WidgetStageChannelModeratorPermissions$viewBinding$2() {
        super(1, WidgetStageChannelModeratorPermissionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStageChannelModeratorPermissionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.add_permission_owner_button;
        AddPermissionOwnerView addPermissionOwnerView = (AddPermissionOwnerView) view.findViewById(C5419R.id.add_permission_owner_button);
        if (addPermissionOwnerView != null) {
            i = C5419R.id.members_permission_owners_list;
            PermissionOwnerListView permissionOwnerListView = (PermissionOwnerListView) view.findViewById(C5419R.id.members_permission_owners_list);
            if (permissionOwnerListView != null) {
                i = C5419R.id.roles_permission_owners_list;
                PermissionOwnerListView permissionOwnerListView2 = (PermissionOwnerListView) view.findViewById(C5419R.id.roles_permission_owners_list);
                if (permissionOwnerListView2 != null) {
                    return new WidgetStageChannelModeratorPermissionsBinding((CoordinatorLayout) view, addPermissionOwnerView, permissionOwnerListView, permissionOwnerListView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
