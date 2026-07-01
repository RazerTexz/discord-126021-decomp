package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.SettingsMemberView;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsAuditLogFilterUserListitemBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialRadioButton f2541b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SettingsMemberView e;

    public WidgetServerSettingsAuditLogFilterUserListitemBinding(@NonNull FrameLayout frameLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull SettingsMemberView settingsMemberView) {
        this.a = frameLayout;
        this.f2541b = materialRadioButton;
        this.c = imageView;
        this.d = textView;
        this.e = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
