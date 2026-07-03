package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f18482a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18483b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18484c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SwitchMaterial f18485d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f18486e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f18487f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f18488g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final SwitchMaterial f18489h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f18490i;

    public WidgetVoiceSettingsBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SwitchMaterial switchMaterial, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull NestedScrollView nestedScrollView2, @NonNull TextView textView5, @NonNull SwitchMaterial switchMaterial2, @NonNull TextView textView6) {
        this.f18482a = nestedScrollView;
        this.f18483b = textView;
        this.f18484c = textView2;
        this.f18485d = switchMaterial;
        this.f18486e = textView3;
        this.f18487f = textView4;
        this.f18488g = textView5;
        this.f18489h = switchMaterial2;
        this.f18490i = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18482a;
    }
}
