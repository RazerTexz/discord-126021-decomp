package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.channels.permissions.AddPermissionOwnerView;
import com.discord.widgets.channels.permissions.PermissionOwnerListView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelModeratorPermissionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18151a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AddPermissionOwnerView f18152b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final PermissionOwnerListView f18153c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final PermissionOwnerListView f18154d;

    public WidgetStageChannelModeratorPermissionsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AddPermissionOwnerView addPermissionOwnerView, @NonNull PermissionOwnerListView permissionOwnerListView, @NonNull PermissionOwnerListView permissionOwnerListView2) {
        this.f18151a = coordinatorLayout;
        this.f18152b = addPermissionOwnerView;
        this.f18153c = permissionOwnerListView;
        this.f18154d = permissionOwnerListView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18151a;
    }
}
