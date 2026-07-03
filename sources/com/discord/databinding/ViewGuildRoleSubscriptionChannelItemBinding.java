package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionChannelItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15464a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15465b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15466c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f15467d;

    public ViewGuildRoleSubscriptionChannelItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f15464a = linearLayout;
        this.f15465b = textView;
        this.f15466c = imageView;
        this.f15467d = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15464a;
    }
}
