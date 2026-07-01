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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2419b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final TextInputLayout g;

    @NonNull
    public final RecyclerView h;

    @NonNull
    public final AppViewFlipper i;

    @NonNull
    public final ViewInviteSettingsSheet j;

    public WidgetGuildInviteShareCompactBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.a = coordinatorLayout;
        this.f2419b = view;
        this.c = textView;
        this.d = textView2;
        this.e = imageView;
        this.f = materialButton;
        this.g = textInputLayout;
        this.h = recyclerView;
        this.i = appViewFlipper;
        this.j = viewInviteSettingsSheet;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
