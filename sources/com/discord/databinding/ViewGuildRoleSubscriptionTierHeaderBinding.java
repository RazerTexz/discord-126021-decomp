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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2199b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ViewGuildRoleSubscriptionTierHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull Button button) {
        this.a = linearLayout;
        this.f2199b = textView;
        this.c = simpleDraweeView;
        this.d = textView2;
        this.e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
