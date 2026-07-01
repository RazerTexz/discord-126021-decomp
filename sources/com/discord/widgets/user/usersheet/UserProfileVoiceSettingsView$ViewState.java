package com.discord.widgets.user.usersheet;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: UserProfileVoiceSettingsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfileVoiceSettingsView$ViewState {
    private final Boolean isDeafened;
    private final boolean isMuted;
    private final Float outputVolume;

    public UserProfileVoiceSettingsView$ViewState(boolean z2, Boolean bool, Float f) {
        this.isMuted = z2;
        this.isDeafened = bool;
        this.outputVolume = f;
    }

    public static /* synthetic */ UserProfileVoiceSettingsView$ViewState copy$default(UserProfileVoiceSettingsView$ViewState userProfileVoiceSettingsView$ViewState, boolean z2, Boolean bool, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = userProfileVoiceSettingsView$ViewState.isMuted;
        }
        if ((i & 2) != 0) {
            bool = userProfileVoiceSettingsView$ViewState.isDeafened;
        }
        if ((i & 4) != 0) {
            f = userProfileVoiceSettingsView$ViewState.outputVolume;
        }
        return userProfileVoiceSettingsView$ViewState.copy(z2, bool, f);
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

    public final UserProfileVoiceSettingsView$ViewState copy(boolean isMuted, Boolean isDeafened, Float outputVolume) {
        return new UserProfileVoiceSettingsView$ViewState(isMuted, isDeafened, outputVolume);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileVoiceSettingsView$ViewState)) {
            return false;
        }
        UserProfileVoiceSettingsView$ViewState userProfileVoiceSettingsView$ViewState = (UserProfileVoiceSettingsView$ViewState) other;
        return this.isMuted == userProfileVoiceSettingsView$ViewState.isMuted && m.areEqual(this.isDeafened, userProfileVoiceSettingsView$ViewState.isDeafened) && m.areEqual(this.outputVolume, userProfileVoiceSettingsView$ViewState.outputVolume);
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
        StringBuilder sbU = a.U("ViewState(isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", isDeafened=");
        sbU.append(this.isDeafened);
        sbU.append(", outputVolume=");
        sbU.append(this.outputVolume);
        sbU.append(")");
        return sbU.toString();
    }
}
