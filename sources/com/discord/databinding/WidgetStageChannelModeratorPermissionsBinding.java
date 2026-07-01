package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.channels.permissions.AddPermissionOwnerView;
import com.discord.widgets.channels.permissions.PermissionOwnerListView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelModeratorPermissionsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AddPermissionOwnerView f2652b;

    @NonNull
    public final PermissionOwnerListView c;

    @NonNull
    public final PermissionOwnerListView d;

    public WidgetStageChannelModeratorPermissionsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AddPermissionOwnerView addPermissionOwnerView, @NonNull PermissionOwnerListView permissionOwnerListView, @NonNull PermissionOwnerListView permissionOwnerListView2) {
        this.a = coordinatorLayout;
        this.f2652b = addPermissionOwnerView;
        this.c = permissionOwnerListView;
        this.d = permissionOwnerListView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
