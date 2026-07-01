package com.discord.widgets.voice.controls;


/* JADX INFO: compiled from: VoiceControlsOutputSelectorState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum VoiceControlsOutputSelectorState {
    SPEAKER_ON(2131232135, true, false),
    SPEAKER_OFF(2131232137, false, false),
    BLUETOOTH_ON_AND_MORE(2131232136, true, true),
    SPEAKER_ON_AND_MORE(2131232135, true, true),
    SPEAKER_OFF_AND_MORE(2131232137, false, true);

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
