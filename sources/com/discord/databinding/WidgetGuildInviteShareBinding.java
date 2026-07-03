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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16804a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16805b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16806c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16807d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f16808e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16809f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f16810g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextInputLayout f16811h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final RecyclerView f16812i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final AppViewFlipper f16813j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final ViewInviteSettingsSheet f16814k;

    public WidgetGuildInviteShareBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.f16804a = coordinatorLayout;
        this.f16805b = view;
        this.f16806c = textView;
        this.f16807d = textView2;
        this.f16808e = checkedSetting;
        this.f16809f = imageView;
        this.f16810g = materialButton;
        this.f16811h = textInputLayout;
        this.f16812i = recyclerView;
        this.f16813j = appViewFlipper;
        this.f16814k = viewInviteSettingsSheet;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16804a;
    }
}
