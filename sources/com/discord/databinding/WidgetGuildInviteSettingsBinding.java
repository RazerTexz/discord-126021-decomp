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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Spinner f2417b;

    @NonNull
    public final RadioGroup c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final RadioGroup e;

    @NonNull
    public final CheckedSetting f;

    public WidgetGuildInviteSettingsBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull RadioGroup radioGroup, @NonNull MaterialButton materialButton, @NonNull RadioGroup radioGroup2, @NonNull CheckedSetting checkedSetting) {
        this.a = linearLayout;
        this.f2417b = spinner;
        this.c = radioGroup;
        this.d = materialButton;
        this.e = radioGroup2;
        this.f = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
