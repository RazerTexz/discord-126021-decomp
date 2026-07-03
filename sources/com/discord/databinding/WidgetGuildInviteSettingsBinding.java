package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16798a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Spinner f16799b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RadioGroup f16800c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f16801d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RadioGroup f16802e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CheckedSetting f16803f;

    public WidgetGuildInviteSettingsBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull RadioGroup radioGroup, @NonNull MaterialButton materialButton, @NonNull RadioGroup radioGroup2, @NonNull CheckedSetting checkedSetting) {
        this.f16798a = linearLayout;
        this.f16799b = spinner;
        this.f16800c = radioGroup;
        this.f16801d = materialButton;
        this.f16802e = radioGroup2;
        this.f16803f = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16798a;
    }
}
