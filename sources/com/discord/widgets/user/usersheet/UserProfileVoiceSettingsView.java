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
import com.discord.C5419R;
import com.discord.databinding.UserProfileVoiceSettingsViewBinding;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p508a0.C11210a;
import p507d0.p592z.p594d.C12238m;

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
            return this.isMuted == viewState.isMuted && C12238m.areEqual(this.isDeafened, viewState.isDeafened) && C12238m.areEqual(this.outputVolume, viewState.outputVolume);
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
            StringBuilder sbM833U = C1643a.m833U("ViewState(isMuted=");
            sbM833U.append(this.isMuted);
            sbM833U.append(", isDeafened=");
            sbM833U.append(this.isDeafened);
            sbM833U.append(", outputVolume=");
            sbM833U.append(this.outputVolume);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileVoiceSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.user_profile_voice_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.user_sheet_deafen;
        SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(C5419R.id.user_sheet_deafen);
        if (switchMaterial != null) {
            i = C5419R.id.user_sheet_muted;
            SwitchMaterial switchMaterial2 = (SwitchMaterial) viewInflate.findViewById(C5419R.id.user_sheet_muted);
            if (switchMaterial2 != null) {
                i = C5419R.id.user_sheet_volume_label;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.user_sheet_volume_label);
                if (textView != null) {
                    i = C5419R.id.user_sheet_volume_slider;
                    VolumeSliderView volumeSliderView = (VolumeSliderView) viewInflate.findViewById(C5419R.id.user_sheet_volume_slider);
                    if (volumeSliderView != null) {
                        UserProfileVoiceSettingsViewBinding userProfileVoiceSettingsViewBinding = new UserProfileVoiceSettingsViewBinding((LinearLayout) viewInflate, switchMaterial, switchMaterial2, textView, volumeSliderView);
                        C12238m.checkNotNullExpressionValue(userProfileVoiceSettingsViewBinding, "UserProfileVoiceSettings…rom(context), this, true)");
                        this.binding = userProfileVoiceSettingsViewBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnDeafenChecked(final Function1<? super Boolean, Unit> onChecked) {
        C12238m.checkNotNullParameter(onChecked, "onChecked");
        this.binding.f15356b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView.setOnDeafenChecked.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                onChecked.invoke(Boolean.valueOf(z2));
            }
        });
    }

    public final void setOnMuteChecked(final Function1<? super Boolean, Unit> onChecked) {
        C12238m.checkNotNullParameter(onChecked, "onChecked");
        this.binding.f15357c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView.setOnMuteChecked.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                onChecked.invoke(Boolean.valueOf(z2));
            }
        });
    }

    public final void setOnVolumeChange(Function2<? super Float, ? super Boolean, Unit> onProgressChanged) {
        C12238m.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        this.binding.f15359e.setOnVolumeChange(onProgressChanged);
    }

    public final void updateView(ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        VolumeSliderView volumeSliderView = this.binding.f15359e;
        Float outputVolume = viewState.getOutputVolume();
        int iRoundToInt = outputVolume != null ? C11210a.roundToInt(outputVolume.floatValue()) : 0;
        SeekBar seekBar = volumeSliderView.binding.f1034d;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        VolumeSliderView volumeSliderView2 = this.binding.f15359e;
        C12238m.checkNotNullExpressionValue(volumeSliderView2, "binding.userSheetVolumeSlider");
        volumeSliderView2.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        TextView textView = this.binding.f15358d;
        C12238m.checkNotNullExpressionValue(textView, "binding.userSheetVolumeLabel");
        textView.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        SwitchMaterial switchMaterial = this.binding.f15357c;
        C12238m.checkNotNullExpressionValue(switchMaterial, "binding.userSheetMuted");
        switchMaterial.setChecked(viewState.isMuted());
        SwitchMaterial switchMaterial2 = this.binding.f15356b;
        C12238m.checkNotNullExpressionValue(switchMaterial2, "binding.userSheetDeafen");
        switchMaterial2.setVisibility(viewState.isDeafened() != null ? 0 : 8);
        SwitchMaterial switchMaterial3 = this.binding.f15356b;
        C12238m.checkNotNullExpressionValue(switchMaterial3, "binding.userSheetDeafen");
        Boolean boolIsDeafened = viewState.isDeafened();
        switchMaterial3.setChecked(boolIsDeafened != null ? boolIsDeafened.booleanValue() : false);
    }
}
