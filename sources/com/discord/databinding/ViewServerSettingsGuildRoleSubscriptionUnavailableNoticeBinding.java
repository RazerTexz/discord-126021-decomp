package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15565a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15566b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15567c;

    public ViewServerSettingsGuildRoleSubscriptionUnavailableNoticeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15565a = constraintLayout;
        this.f15566b = textView;
        this.f15567c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15565a;
    }
}
