package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.widgets.guilds.invite.ViewInviteSettingsSheet;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteShareCompactBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16815a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16816b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16817c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16818d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f16819e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f16820f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f16821g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final RecyclerView f16822h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final AppViewFlipper f16823i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ViewInviteSettingsSheet f16824j;

    public WidgetGuildInviteShareCompactBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.f16815a = coordinatorLayout;
        this.f16816b = view;
        this.f16817c = textView;
        this.f16818d = textView2;
        this.f16819e = imageView;
        this.f16820f = materialButton;
        this.f16821g = textInputLayout;
        this.f16822h = recyclerView;
        this.f16823i = appViewFlipper;
        this.f16824j = viewInviteSettingsSheet;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16815a;
    }
}
