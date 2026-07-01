package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionPlanDetailsBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2436b;

    @NonNull
    public final TextInputEditText c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final Group e;

    @NonNull
    public final ImageView f;

    public WidgetGuildRoleSubscriptionPlanDetailsBinding(@NonNull ScrollView scrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextInputEditText textInputEditText, @NonNull TextView textView3, @NonNull TextInputLayout textInputLayout, @NonNull View view, @NonNull Group group, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageView imageView, @NonNull ScrollView scrollView2) {
        this.a = scrollView;
        this.f2436b = simpleDraweeView;
        this.c = textInputEditText;
        this.d = textInputLayout;
        this.e = group;
        this.f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
