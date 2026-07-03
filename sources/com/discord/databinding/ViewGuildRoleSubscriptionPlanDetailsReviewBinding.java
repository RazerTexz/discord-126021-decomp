package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionPlanDetailsReviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15483a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15484b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15485c;

    public ViewGuildRoleSubscriptionPlanDetailsReviewBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f15483a = linearLayout;
        this.f15484b = simpleDraweeView;
        this.f15485c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15483a;
    }
}
