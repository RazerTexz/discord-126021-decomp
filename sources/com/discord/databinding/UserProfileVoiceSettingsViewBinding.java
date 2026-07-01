package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: loaded from: classes.dex */
public final class UserProfileVoiceSettingsViewBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SwitchMaterial f2168b;

    @NonNull
    public final SwitchMaterial c;

    @NonNull
    public final TextView d;

    @NonNull
    public final VolumeSliderView e;

    public UserProfileVoiceSettingsViewBinding(@NonNull LinearLayout linearLayout, @NonNull SwitchMaterial switchMaterial, @NonNull SwitchMaterial switchMaterial2, @NonNull TextView textView, @NonNull VolumeSliderView volumeSliderView) {
        this.a = linearLayout;
        this.f2168b = switchMaterial;
        this.c = switchMaterial2;
        this.d = textView;
        this.e = volumeSliderView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
