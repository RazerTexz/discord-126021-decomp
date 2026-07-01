package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.views.permissions.ChannelPermissionOwnerView;

/* JADX INFO: loaded from: classes.dex */
public final class RemovablePermissionOwnerViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ChannelPermissionOwnerView f2138b;

    @NonNull
    public final ImageView c;

    public RemovablePermissionOwnerViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ChannelPermissionOwnerView channelPermissionOwnerView, @NonNull ImageView imageView) {
        this.a = constraintLayout;
        this.f2138b = channelPermissionOwnerView;
        this.c = imageView;
    }

    @NonNull
    public static RemovablePermissionOwnerViewBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.removable_permission_owner_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.permission_owner_view;
        ChannelPermissionOwnerView channelPermissionOwnerView = (ChannelPermissionOwnerView) viewInflate.findViewById(R.id.permission_owner_view);
        if (channelPermissionOwnerView != null) {
            i = R.id.remove;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.remove);
            if (imageView != null) {
                return new RemovablePermissionOwnerViewBinding((ConstraintLayout) viewInflate, channelPermissionOwnerView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
