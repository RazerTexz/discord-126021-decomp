package com.discord.api.voice.state;


/* JADX INFO: compiled from: StageRequestToSpeakState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StageRequestToSpeakState {
    NONE(false, true),
    REQUESTED_TO_SPEAK(true, true),
    REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK(true, false),
    ON_STAGE(false, false);

    private final boolean canBeInvitedToSpeak;
    private final boolean isRequestingToSpeak;

    StageRequestToSpeakState(boolean z2, boolean z3) {
        this.isRequestingToSpeak = z2;
        this.canBeInvitedToSpeak = z3;
    }

    public final boolean getCanBeInvitedToSpeak() {
        return this.canBeInvitedToSpeak;
    }

    /* JADX INFO: renamed from: isRequestingToSpeak, reason: from getter */
    public final boolean getIsRequestingToSpeak() {
        return this.isRequestingToSpeak;
    }
}
