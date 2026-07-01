package com.discord.widgets.voice.controls;

import com.discord.R;

/* JADX INFO: compiled from: VoiceControlsOutputSelectorState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum VoiceControlsOutputSelectorState {
    SPEAKER_ON(R.drawable.ic_sound_24dp, true, false),
    SPEAKER_OFF(R.drawable.ic_sound_quiet_24dp, false, false),
    BLUETOOTH_ON_AND_MORE(R.drawable.ic_sound_bluetooth_24dp, true, true),
    SPEAKER_ON_AND_MORE(R.drawable.ic_sound_24dp, true, true),
    SPEAKER_OFF_AND_MORE(R.drawable.ic_sound_quiet_24dp, false, true);

    private final int audioOutputIconRes;
    private final boolean isButtonActive;
    private final boolean showMoreOptions;

    VoiceControlsOutputSelectorState(int i, boolean z2, boolean z3) {
        this.audioOutputIconRes = i;
        this.isButtonActive = z2;
        this.showMoreOptions = z3;
    }

    public final int getAudioOutputIconRes() {
        return this.audioOutputIconRes;
    }

    public final boolean getShowMoreOptions() {
        return this.showMoreOptions;
    }

    /* JADX INFO: renamed from: isButtonActive, reason: from getter */
    public final boolean getIsButtonActive() {
        return this.isButtonActive;
    }
}
