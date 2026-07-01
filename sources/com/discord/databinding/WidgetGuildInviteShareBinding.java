package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.ViewInviteSettingsSheet;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteShareBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2418b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final CheckedSetting e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final TextInputLayout h;

    @NonNull
    public final RecyclerView i;

    @NonNull
    public final AppViewFlipper j;

    @NonNull
    public final ViewInviteSettingsSheet k;

    public WidgetGuildInviteShareBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.a = coordinatorLayout;
        this.f2418b = view;
        this.c = textView;
        this.d = textView2;
        this.e = checkedSetting;
        this.f = imageView;
        this.g = materialButton;
        this.h = textInputLayout;
        this.i = recyclerView;
        this.j = appViewFlipper;
        this.k = viewInviteSettingsSheet;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
