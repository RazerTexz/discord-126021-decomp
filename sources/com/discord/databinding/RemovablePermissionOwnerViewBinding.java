package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.permissions.ChannelPermissionOwnerView;

/* JADX INFO: loaded from: classes.dex */
public final class RemovablePermissionOwnerViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15225a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ChannelPermissionOwnerView f15226b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15227c;

    public RemovablePermissionOwnerViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ChannelPermissionOwnerView channelPermissionOwnerView, @NonNull ImageView imageView) {
        this.f15225a = constraintLayout;
        this.f15226b = channelPermissionOwnerView;
        this.f15227c = imageView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static RemovablePermissionOwnerViewBinding m8389a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.removable_permission_owner_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.permission_owner_view;
        ChannelPermissionOwnerView channelPermissionOwnerView = (ChannelPermissionOwnerView) viewInflate.findViewById(C5419R.id.permission_owner_view);
        if (channelPermissionOwnerView != null) {
            i = C5419R.id.remove;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.remove);
            if (imageView != null) {
                return new RemovablePermissionOwnerViewBinding((ConstraintLayout) viewInflate, channelPermissionOwnerView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15225a;
    }
}
