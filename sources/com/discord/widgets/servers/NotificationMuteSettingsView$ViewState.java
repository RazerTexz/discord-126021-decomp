package com.discord.widgets.servers;

import androidx.annotation.StringRes;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationMuteSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NotificationMuteSettingsView$ViewState {
    private final boolean isMuted;
    private final CharSequence muteDescriptionText;
    private final String muteEndTime;
    private final CharSequence rawMuteText;
    private final CharSequence rawMutedStatusText;
    private final int rawMutedUntilStatusResId;
    private final CharSequence rawUnmuteText;

    public NotificationMuteSettingsView$ViewState(boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, @StringRes int i, CharSequence charSequence4) {
        m.checkNotNullParameter(charSequence, "rawMuteText");
        m.checkNotNullParameter(charSequence3, "rawMutedStatusText");
        this.isMuted = z2;
        this.muteEndTime = str;
        this.rawMuteText = charSequence;
        this.rawUnmuteText = charSequence2;
        this.rawMutedStatusText = charSequence3;
        this.rawMutedUntilStatusResId = i;
        this.muteDescriptionText = charSequence4;
    }

    public static /* synthetic */ NotificationMuteSettingsView$ViewState copy$default(NotificationMuteSettingsView$ViewState notificationMuteSettingsView$ViewState, boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = notificationMuteSettingsView$ViewState.isMuted;
        }
        if ((i2 & 2) != 0) {
            str = notificationMuteSettingsView$ViewState.muteEndTime;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            charSequence = notificationMuteSettingsView$ViewState.rawMuteText;
        }
        CharSequence charSequence5 = charSequence;
        if ((i2 & 8) != 0) {
            charSequence2 = notificationMuteSettingsView$ViewState.rawUnmuteText;
        }
        CharSequence charSequence6 = charSequence2;
        if ((i2 & 16) != 0) {
            charSequence3 = notificationMuteSettingsView$ViewState.rawMutedStatusText;
        }
        CharSequence charSequence7 = charSequence3;
        if ((i2 & 32) != 0) {
            i = notificationMuteSettingsView$ViewState.rawMutedUntilStatusResId;
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            charSequence4 = notificationMuteSettingsView$ViewState.muteDescriptionText;
        }
        return notificationMuteSettingsView$ViewState.copy(z2, str2, charSequence5, charSequence6, charSequence7, i3, charSequence4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CharSequence getRawMuteText() {
        return this.rawMuteText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CharSequence getRawUnmuteText() {
        return this.rawUnmuteText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CharSequence getRawMutedStatusText() {
        return this.rawMutedStatusText;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRawMutedUntilStatusResId() {
        return this.rawMutedUntilStatusResId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CharSequence getMuteDescriptionText() {
        return this.muteDescriptionText;
    }

    public final NotificationMuteSettingsView$ViewState copy(boolean isMuted, String muteEndTime, CharSequence rawMuteText, CharSequence rawUnmuteText, CharSequence rawMutedStatusText, @StringRes int rawMutedUntilStatusResId, CharSequence muteDescriptionText) {
        m.checkNotNullParameter(rawMuteText, "rawMuteText");
        m.checkNotNullParameter(rawMutedStatusText, "rawMutedStatusText");
        return new NotificationMuteSettingsView$ViewState(isMuted, muteEndTime, rawMuteText, rawUnmuteText, rawMutedStatusText, rawMutedUntilStatusResId, muteDescriptionText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationMuteSettingsView$ViewState)) {
            return false;
        }
        NotificationMuteSettingsView$ViewState notificationMuteSettingsView$ViewState = (NotificationMuteSettingsView$ViewState) other;
        return this.isMuted == notificationMuteSettingsView$ViewState.isMuted && m.areEqual(this.muteEndTime, notificationMuteSettingsView$ViewState.muteEndTime) && m.areEqual(this.rawMuteText, notificationMuteSettingsView$ViewState.rawMuteText) && m.areEqual(this.rawUnmuteText, notificationMuteSettingsView$ViewState.rawUnmuteText) && m.areEqual(this.rawMutedStatusText, notificationMuteSettingsView$ViewState.rawMutedStatusText) && this.rawMutedUntilStatusResId == notificationMuteSettingsView$ViewState.rawMutedUntilStatusResId && m.areEqual(this.muteDescriptionText, notificationMuteSettingsView$ViewState.muteDescriptionText);
    }

    public final CharSequence getMuteDescriptionText() {
        return this.muteDescriptionText;
    }

    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    public final CharSequence getRawMuteText() {
        return this.rawMuteText;
    }

    public final CharSequence getRawMutedStatusText() {
        return this.rawMutedStatusText;
    }

    public final int getRawMutedUntilStatusResId() {
        return this.rawMutedUntilStatusResId;
    }

    public final CharSequence getRawUnmuteText() {
        return this.rawUnmuteText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z2 = this.isMuted;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.muteEndTime;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rawMuteText;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.rawUnmuteText;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.rawMutedStatusText;
        int iHashCode4 = (((iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31) + this.rawMutedUntilStatusResId) * 31;
        CharSequence charSequence4 = this.muteDescriptionText;
        return iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", muteEndTime=");
        sbU.append(this.muteEndTime);
        sbU.append(", rawMuteText=");
        sbU.append(this.rawMuteText);
        sbU.append(", rawUnmuteText=");
        sbU.append(this.rawUnmuteText);
        sbU.append(", rawMutedStatusText=");
        sbU.append(this.rawMutedStatusText);
        sbU.append(", rawMutedUntilStatusResId=");
        sbU.append(this.rawMutedUntilStatusResId);
        sbU.append(", muteDescriptionText=");
        return a.E(sbU, this.muteDescriptionText, ")");
    }

    public /* synthetic */ NotificationMuteSettingsView$ViewState(boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, str, charSequence, charSequence2, charSequence3, i, (i2 & 64) != 0 ? null : charSequence4);
    }
}
