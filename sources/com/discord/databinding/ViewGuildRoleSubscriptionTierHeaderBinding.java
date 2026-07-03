package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionTierHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15493a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15494b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15495c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15496d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15497e;

    public ViewGuildRoleSubscriptionTierHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull Button button) {
        this.f15493a = linearLayout;
        this.f15494b = textView;
        this.f15495c = simpleDraweeView;
        this.f15496d = textView2;
        this.f15497e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15493a;
    }
}
