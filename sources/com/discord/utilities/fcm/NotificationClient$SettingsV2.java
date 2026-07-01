package com.discord.utilities.fcm;

import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NotificationClient$SettingsV2 {
    private final boolean isAuthed;
    private final boolean isDisableBlink;
    private final boolean isDisableSound;
    private final boolean isDisableVibrate;
    private final boolean isEnabled;
    private final boolean isEnabledInApp;
    private final boolean isWake;
    private final String locale;
    private final Set<Long> sendBlockedChannels;
    private final String token;

    public NotificationClient$SettingsV2() {
        this(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public NotificationClient$SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set<Long> set) {
        m.checkNotNullParameter(str2, "locale");
        m.checkNotNullParameter(set, "sendBlockedChannels");
        this.isEnabled = z2;
        this.isEnabledInApp = z3;
        this.isWake = z4;
        this.isDisableBlink = z5;
        this.isDisableSound = z6;
        this.isDisableVibrate = z7;
        this.token = str;
        this.locale = str2;
        this.sendBlockedChannels = set;
        this.isAuthed = str != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationClient$SettingsV2 copy$default(NotificationClient$SettingsV2 notificationClient$SettingsV2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set set, int i, Object obj) {
        return notificationClient$SettingsV2.copy((i & 1) != 0 ? notificationClient$SettingsV2.isEnabled : z2, (i & 2) != 0 ? notificationClient$SettingsV2.isEnabledInApp : z3, (i & 4) != 0 ? notificationClient$SettingsV2.isWake : z4, (i & 8) != 0 ? notificationClient$SettingsV2.isDisableBlink : z5, (i & 16) != 0 ? notificationClient$SettingsV2.isDisableSound : z6, (i & 32) != 0 ? notificationClient$SettingsV2.isDisableVibrate : z7, (i & 64) != 0 ? notificationClient$SettingsV2.token : str, (i & 128) != 0 ? notificationClient$SettingsV2.locale : str2, (i & 256) != 0 ? notificationClient$SettingsV2.sendBlockedChannels : set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsEnabledInApp() {
        return this.isEnabledInApp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsWake() {
        return this.isWake;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsDisableBlink() {
        return this.isDisableBlink;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsDisableSound() {
        return this.isDisableSound;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsDisableVibrate() {
        return this.isDisableVibrate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final Set<Long> component9() {
        return this.sendBlockedChannels;
    }

    public final NotificationClient$SettingsV2 copy(boolean isEnabled, boolean isEnabledInApp, boolean isWake, boolean isDisableBlink, boolean isDisableSound, boolean isDisableVibrate, String token, String locale, Set<Long> sendBlockedChannels) {
        m.checkNotNullParameter(locale, "locale");
        m.checkNotNullParameter(sendBlockedChannels, "sendBlockedChannels");
        return new NotificationClient$SettingsV2(isEnabled, isEnabledInApp, isWake, isDisableBlink, isDisableSound, isDisableVibrate, token, locale, sendBlockedChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationClient$SettingsV2)) {
            return false;
        }
        NotificationClient$SettingsV2 notificationClient$SettingsV2 = (NotificationClient$SettingsV2) other;
        return this.isEnabled == notificationClient$SettingsV2.isEnabled && this.isEnabledInApp == notificationClient$SettingsV2.isEnabledInApp && this.isWake == notificationClient$SettingsV2.isWake && this.isDisableBlink == notificationClient$SettingsV2.isDisableBlink && this.isDisableSound == notificationClient$SettingsV2.isDisableSound && this.isDisableVibrate == notificationClient$SettingsV2.isDisableVibrate && m.areEqual(this.token, notificationClient$SettingsV2.token) && m.areEqual(this.locale, notificationClient$SettingsV2.locale) && m.areEqual(this.sendBlockedChannels, notificationClient$SettingsV2.sendBlockedChannels);
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Set<Long> getSendBlockedChannels() {
        return this.sendBlockedChannels;
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public int hashCode() {
        boolean z2 = this.isEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isEnabledInApp;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isWake;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isDisableBlink;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.isDisableSound;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.isDisableVibrate;
        int i6 = (i5 + (z7 ? 1 : z7)) * 31;
        String str = this.token;
        int iHashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.locale;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<Long> set = this.sendBlockedChannels;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isAuthed, reason: from getter */
    public final boolean getIsAuthed() {
        return this.isAuthed;
    }

    public final boolean isDisableBlink() {
        return this.isDisableBlink;
    }

    public final boolean isDisableSound() {
        return this.isDisableSound;
    }

    public final boolean isDisableVibrate() {
        return this.isDisableVibrate;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isEnabledInApp() {
        return this.isEnabledInApp;
    }

    public final boolean isWake() {
        return this.isWake;
    }

    public String toString() {
        StringBuilder sbU = a.U("SettingsV2(isEnabled=");
        sbU.append(this.isEnabled);
        sbU.append(", isEnabledInApp=");
        sbU.append(this.isEnabledInApp);
        sbU.append(", isWake=");
        sbU.append(this.isWake);
        sbU.append(", isDisableBlink=");
        sbU.append(this.isDisableBlink);
        sbU.append(", isDisableSound=");
        sbU.append(this.isDisableSound);
        sbU.append(", isDisableVibrate=");
        sbU.append(this.isDisableVibrate);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", locale=");
        sbU.append(this.locale);
        sbU.append(", sendBlockedChannels=");
        return a.N(sbU, this.sendBlockedChannels, ")");
    }

    public /* synthetic */ NotificationClient$SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2, (i & 2) == 0 ? z3 : true, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? null : str, (i & 128) != 0 ? "" : str2, (i & 256) != 0 ? new HashSet(0) : set);
    }
}
