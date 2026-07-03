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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f17516a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialRadioButton f17517b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f17518c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17519d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SettingsMemberView f17520e;

    public WidgetServerSettingsAuditLogFilterUserListitemBinding(@NonNull FrameLayout frameLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull SettingsMemberView settingsMemberView) {
        this.f17516a = frameLayout;
        this.f17517b = materialRadioButton;
        this.f17518c = imageView;
        this.f17519d = textView;
        this.f17520e = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17516a;
    }
}
