package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.UserProfileVoiceSettingsViewBinding;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.a0.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UserProfileVoiceSettingsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileVoiceSettingsView extends LinearLayout {
    private final UserProfileVoiceSettingsViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileVoiceSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.user_profile_voice_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.user_sheet_deafen;
        SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(R$id.user_sheet_deafen);
        if (switchMaterial != null) {
            i = R$id.user_sheet_muted;
            SwitchMaterial switchMaterial2 = (SwitchMaterial) viewInflate.findViewById(R$id.user_sheet_muted);
            if (switchMaterial2 != null) {
                i = R$id.user_sheet_volume_label;
                TextView textView = (TextView) viewInflate.findViewById(R$id.user_sheet_volume_label);
                if (textView != null) {
                    i = R$id.user_sheet_volume_slider;
                    VolumeSliderView volumeSliderView = (VolumeSliderView) viewInflate.findViewById(R$id.user_sheet_volume_slider);
                    if (volumeSliderView != null) {
                        UserProfileVoiceSettingsViewBinding userProfileVoiceSettingsViewBinding = new UserProfileVoiceSettingsViewBinding((LinearLayout) viewInflate, switchMaterial, switchMaterial2, textView, volumeSliderView);
                        m.checkNotNullExpressionValue(userProfileVoiceSettingsViewBinding, "UserProfileVoiceSettings…rom(context), this, true)");
                        this.binding = userProfileVoiceSettingsViewBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnDeafenChecked(Function1<? super Boolean, Unit> onChecked) {
        m.checkNotNullParameter(onChecked, "onChecked");
        this.binding.f2168b.setOnCheckedChangeListener(new UserProfileVoiceSettingsView$setOnDeafenChecked$1(onChecked));
    }

    public final void setOnMuteChecked(Function1<? super Boolean, Unit> onChecked) {
        m.checkNotNullParameter(onChecked, "onChecked");
        this.binding.c.setOnCheckedChangeListener(new UserProfileVoiceSettingsView$setOnMuteChecked$1(onChecked));
    }

    public final void setOnVolumeChange(Function2<? super Float, ? super Boolean, Unit> onProgressChanged) {
        m.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        this.binding.e.setOnVolumeChange(onProgressChanged);
    }

    public final void updateView(UserProfileVoiceSettingsView$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        VolumeSliderView volumeSliderView = this.binding.e;
        Float outputVolume = viewState.getOutputVolume();
        int iRoundToInt = outputVolume != null ? a.roundToInt(outputVolume.floatValue()) : 0;
        SeekBar seekBar = volumeSliderView.binding.d;
        m.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        VolumeSliderView volumeSliderView2 = this.binding.e;
        m.checkNotNullExpressionValue(volumeSliderView2, "binding.userSheetVolumeSlider");
        volumeSliderView2.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.userSheetVolumeLabel");
        textView.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        SwitchMaterial switchMaterial = this.binding.c;
        m.checkNotNullExpressionValue(switchMaterial, "binding.userSheetMuted");
        switchMaterial.setChecked(viewState.isMuted());
        SwitchMaterial switchMaterial2 = this.binding.f2168b;
        m.checkNotNullExpressionValue(switchMaterial2, "binding.userSheetDeafen");
        switchMaterial2.setVisibility(viewState.isDeafened() != null ? 0 : 8);
        SwitchMaterial switchMaterial3 = this.binding.f2168b;
        m.checkNotNullExpressionValue(switchMaterial3, "binding.userSheetDeafen");
        Boolean boolIsDeafened = viewState.isDeafened();
        switchMaterial3.setChecked(boolIsDeafened != null ? boolIsDeafened.booleanValue() : false);
    }
}
