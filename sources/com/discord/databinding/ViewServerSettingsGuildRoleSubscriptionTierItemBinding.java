package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewServerSettingsGuildRoleSubscriptionTierItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15560a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15561b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15562c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15563d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15564e;

    public ViewServerSettingsGuildRoleSubscriptionTierItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15560a = constraintLayout;
        this.f15561b = textView;
        this.f15562c = simpleDraweeView;
        this.f15563d = textView2;
        this.f15564e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15560a;
    }
}
