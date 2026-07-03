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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ScrollView f16927a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f16928b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputEditText f16929c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f16930d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final Group f16931e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16932f;

    public WidgetGuildRoleSubscriptionPlanDetailsBinding(@NonNull ScrollView scrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextInputEditText textInputEditText, @NonNull TextView textView3, @NonNull TextInputLayout textInputLayout, @NonNull View view, @NonNull Group group, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageView imageView, @NonNull ScrollView scrollView2) {
        this.f16927a = scrollView;
        this.f16928b = simpleDraweeView;
        this.f16929c = textInputEditText;
        this.f16930d = textInputLayout;
        this.f16931e = group;
        this.f16932f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16927a;
    }
}
