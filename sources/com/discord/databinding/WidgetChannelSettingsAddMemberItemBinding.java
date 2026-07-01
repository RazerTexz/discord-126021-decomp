package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.permissions.ChannelPermissionOwnerView;
import com.google.android.material.checkbox.MaterialCheckBox;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsAddMemberItemBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ChannelPermissionOwnerView f2271b;

    @NonNull
    public final MaterialCheckBox c;

    @NonNull
    public final ConstraintLayout d;

    public WidgetChannelSettingsAddMemberItemBinding(@NonNull FrameLayout frameLayout, @NonNull ChannelPermissionOwnerView channelPermissionOwnerView, @NonNull MaterialCheckBox materialCheckBox, @NonNull ConstraintLayout constraintLayout) {
        this.a = frameLayout;
        this.f2271b = channelPermissionOwnerView;
        this.c = materialCheckBox;
        this.d = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
