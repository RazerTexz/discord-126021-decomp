package com.discord.databinding;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionDetailsBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputEditText f2433b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final GuildSubscriptionRoleImageUploadView d;

    @NonNull
    public final TextInputEditText e;

    @NonNull
    public final TextInputLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final View j;

    public WidgetGuildRoleSubscriptionDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ScrollView scrollView, @NonNull GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, @NonNull TextInputEditText textInputEditText2, @NonNull TextInputLayout textInputLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view) {
        this.a = constraintLayout;
        this.f2433b = textInputEditText;
        this.c = textInputLayout;
        this.d = guildSubscriptionRoleImageUploadView;
        this.e = textInputEditText2;
        this.f = textInputLayout2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
