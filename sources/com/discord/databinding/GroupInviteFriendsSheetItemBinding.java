package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;

/* JADX INFO: loaded from: classes.dex */
public final class GroupInviteFriendsSheetItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15113a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15114b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15115c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialCheckBox f15116d;

    public GroupInviteFriendsSheetItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull MaterialCheckBox materialCheckBox) {
        this.f15113a = constraintLayout;
        this.f15114b = simpleDraweeView;
        this.f15115c = textView;
        this.f15116d = materialCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15113a;
    }
}
