package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.UserProfileVoiceSettingsViewBinding;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UserProfileVoiceSettingsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileVoiceSettingsView extends LinearLayout {
    private final UserProfileVoiceSettingsViewBinding binding;

    /* JADX INFO: compiled from: UserProfileVoiceSettingsView.kt */
    public static final /* data */ class ViewState {
        private final Boolean isDeafened;
        private final boolean isMuted;
        private final Float outputVolume;

        public ViewState(boolean z2, Boolean bool, Float f) {
            this.isMuted = z2;
            this.isDeafened = bool;
            this.outputVolume = f;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Boolean bool, Float f, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isMuted;
            }
            if ((i & 2) != 0) {
                bool = viewState.isDeafened;
            }
            if ((i & 4) != 0) {
                f = viewState.outputVolume;
            }
            return viewState.copy(z2, bool, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsDeafened() {
            return this.isDeafened;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Float getOutputVolume() {
            return this.outputVolume;
        }

        public final ViewState copy(boolean isMuted, Boolean isDeafened, Float outputVolume) {
            return new ViewState(isMuted, isDeafened, outputVolume);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMuted == viewState.isMuted && Intrinsics3.areEqual(this.isDeafened, viewState.isDeafened) && Intrinsics3.areEqual(this.outputVolume, viewState.outputVolume);
        }

        public final Float getOutputVolume() {
            return this.outputVolume;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Boolean bool = this.isDeafened;
            int iHashCode = (i + (bool != null ? bool.hashCode() : 0)) * 31;
            Float f = this.outputVolume;
            return iHashCode + (f != null ? f.hashCode() : 0);
        }

        public final Boolean isDeafened() {
            return this.isDeafened;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isMuted=");
            sbU.append(this.isMuted);
            sbU.append(", isDeafened=");
            sbU.append(this.isDeafened);
            sbU.append(", outputVolume=");
            sbU.append(this.outputVolume);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileVoiceSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_profile_voice_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.user_sheet_deafen;
        SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(R.id.user_sheet_deafen);
        if (switchMaterial != null) {
            i = R.id.user_sheet_muted;
            SwitchMaterial switchMaterial2 = (SwitchMaterial) viewInflate.findViewById(R.id.user_sheet_muted);
            if (switchMaterial2 != null) {
                i = R.id.user_sheet_volume_label;
                TextView textView = (TextView) viewInflate.findViewById(R.id.user_sheet_volume_label);
                if (textView != null) {
                    i = R.id.user_sheet_volume_slider;
                    VolumeSliderView volumeSliderView = (VolumeSliderView) viewInflate.findViewById(R.id.user_sheet_volume_slider);
                    if (volumeSliderView != null) {
                        UserProfileVoiceSettingsViewBinding userProfileVoiceSettingsViewBinding = new UserProfileVoiceSettingsViewBinding((LinearLayout) viewInflate, switchMaterial, switchMaterial2, textView, volumeSliderView);
                        Intrinsics3.checkNotNullExpressionValue(userProfileVoiceSettingsViewBinding, "UserProfileVoiceSettings…rom(context), this, true)");
                        this.binding = userProfileVoiceSettingsViewBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnDeafenChecked(final Function1<? super Boolean, Unit> onChecked) {
        Intrinsics3.checkNotNullParameter(onChecked, "onChecked");
        this.binding.f2168b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView.setOnDeafenChecked.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                onChecked.invoke(Boolean.valueOf(z2));
            }
        });
    }

    public final void setOnMuteChecked(final Function1<? super Boolean, Unit> onChecked) {
        Intrinsics3.checkNotNullParameter(onChecked, "onChecked");
        this.binding.c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView.setOnMuteChecked.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                onChecked.invoke(Boolean.valueOf(z2));
            }
        });
    }

    public final void setOnVolumeChange(Function2<? super Float, ? super Boolean, Unit> onProgressChanged) {
        Intrinsics3.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        this.binding.e.setOnVolumeChange(onProgressChanged);
    }

    public final void updateView(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        VolumeSliderView volumeSliderView = this.binding.e;
        Float outputVolume = viewState.getOutputVolume();
        int iRoundToInt = outputVolume != null ? MathJVM.roundToInt(outputVolume.floatValue()) : 0;
        SeekBar seekBar = volumeSliderView.binding.d;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        VolumeSliderView volumeSliderView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(volumeSliderView2, "binding.userSheetVolumeSlider");
        volumeSliderView2.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userSheetVolumeLabel");
        textView.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        SwitchMaterial switchMaterial = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.userSheetMuted");
        switchMaterial.setChecked(viewState.isMuted());
        SwitchMaterial switchMaterial2 = this.binding.f2168b;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial2, "binding.userSheetDeafen");
        switchMaterial2.setVisibility(viewState.isDeafened() != null ? 0 : 8);
        SwitchMaterial switchMaterial3 = this.binding.f2168b;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial3, "binding.userSheetDeafen");
        Boolean boolIsDeafened = viewState.isDeafened();
        switchMaterial3.setChecked(boolIsDeafened != null ? boolIsDeafened.booleanValue() : false);
    }
}
