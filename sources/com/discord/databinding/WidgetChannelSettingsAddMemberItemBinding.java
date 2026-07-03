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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15900a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ChannelPermissionOwnerView f15901b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialCheckBox f15902c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f15903d;

    public WidgetChannelSettingsAddMemberItemBinding(@NonNull FrameLayout frameLayout, @NonNull ChannelPermissionOwnerView channelPermissionOwnerView, @NonNull MaterialCheckBox materialCheckBox, @NonNull ConstraintLayout constraintLayout) {
        this.f15900a = frameLayout;
        this.f15901b = channelPermissionOwnerView;
        this.f15902c = materialCheckBox;
        this.f15903d = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15900a;
    }
}
