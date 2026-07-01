package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2705b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SwitchMaterial d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final SwitchMaterial h;

    @NonNull
    public final TextView i;

    public WidgetVoiceSettingsBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SwitchMaterial switchMaterial, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull NestedScrollView nestedScrollView2, @NonNull TextView textView5, @NonNull SwitchMaterial switchMaterial2, @NonNull TextView textView6) {
        this.a = nestedScrollView;
        this.f2705b = textView;
        this.c = textView2;
        this.d = switchMaterial;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = switchMaterial2;
        this.i = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
