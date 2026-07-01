package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MuteSettingsSheetViewModel$ViewState$Loaded extends MuteSettingsSheetViewModel$ViewState {
    private final boolean isChannelMuted;
    private final boolean isGuildMuted;
    private final String muteEndTime;
    private final int notificationSetting;
    private final MuteSettingsSheetViewModel$SettingsType settingsType;
    private final String subtitle;

    public /* synthetic */ MuteSettingsSheetViewModel$ViewState$Loaded(MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType, String str, boolean z2, boolean z3, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(muteSettingsSheetViewModel$SettingsType, str, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? ModelNotificationSettings.FREQUENCY_UNSET : i);
    }

    public static /* synthetic */ MuteSettingsSheetViewModel$ViewState$Loaded copy$default(MuteSettingsSheetViewModel$ViewState$Loaded muteSettingsSheetViewModel$ViewState$Loaded, MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType, String str, boolean z2, boolean z3, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            muteSettingsSheetViewModel$SettingsType = muteSettingsSheetViewModel$ViewState$Loaded.settingsType;
        }
        if ((i2 & 2) != 0) {
            str = muteSettingsSheetViewModel$ViewState$Loaded.subtitle;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            z2 = muteSettingsSheetViewModel$ViewState$Loaded.isChannelMuted;
        }
        boolean z4 = z2;
        if ((i2 & 8) != 0) {
            z3 = muteSettingsSheetViewModel$ViewState$Loaded.isGuildMuted;
        }
        boolean z5 = z3;
        if ((i2 & 16) != 0) {
            str2 = muteSettingsSheetViewModel$ViewState$Loaded.muteEndTime;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            i = muteSettingsSheetViewModel$ViewState$Loaded.notificationSetting;
        }
        return muteSettingsSheetViewModel$ViewState$Loaded.copy(muteSettingsSheetViewModel$SettingsType, str3, z4, z5, str4, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MuteSettingsSheetViewModel$SettingsType getSettingsType() {
        return this.settingsType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsChannelMuted() {
        return this.isChannelMuted;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsGuildMuted() {
        return this.isGuildMuted;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getNotificationSetting() {
        return this.notificationSetting;
    }

    public final MuteSettingsSheetViewModel$ViewState$Loaded copy(MuteSettingsSheetViewModel$SettingsType settingsType, String subtitle, boolean isChannelMuted, boolean isGuildMuted, String muteEndTime, int notificationSetting) {
        m.checkNotNullParameter(settingsType, "settingsType");
        m.checkNotNullParameter(subtitle, "subtitle");
        return new MuteSettingsSheetViewModel$ViewState$Loaded(settingsType, subtitle, isChannelMuted, isGuildMuted, muteEndTime, notificationSetting);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MuteSettingsSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        MuteSettingsSheetViewModel$ViewState$Loaded muteSettingsSheetViewModel$ViewState$Loaded = (MuteSettingsSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.settingsType, muteSettingsSheetViewModel$ViewState$Loaded.settingsType) && m.areEqual(this.subtitle, muteSettingsSheetViewModel$ViewState$Loaded.subtitle) && this.isChannelMuted == muteSettingsSheetViewModel$ViewState$Loaded.isChannelMuted && this.isGuildMuted == muteSettingsSheetViewModel$ViewState$Loaded.isGuildMuted && m.areEqual(this.muteEndTime, muteSettingsSheetViewModel$ViewState$Loaded.muteEndTime) && this.notificationSetting == muteSettingsSheetViewModel$ViewState$Loaded.notificationSetting;
    }

    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    public final int getNotificationSetting() {
        return this.notificationSetting;
    }

    public final MuteSettingsSheetViewModel$SettingsType getSettingsType() {
        return this.settingsType;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType = this.settingsType;
        int iHashCode = (muteSettingsSheetViewModel$SettingsType != null ? muteSettingsSheetViewModel$SettingsType.hashCode() : 0) * 31;
        String str = this.subtitle;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isChannelMuted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.isGuildMuted;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        String str2 = this.muteEndTime;
        return ((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.notificationSetting;
    }

    public final boolean isChannelMuted() {
        return this.isChannelMuted;
    }

    public final boolean isGuildMuted() {
        return this.isGuildMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(settingsType=");
        sbU.append(this.settingsType);
        sbU.append(", subtitle=");
        sbU.append(this.subtitle);
        sbU.append(", isChannelMuted=");
        sbU.append(this.isChannelMuted);
        sbU.append(", isGuildMuted=");
        sbU.append(this.isGuildMuted);
        sbU.append(", muteEndTime=");
        sbU.append(this.muteEndTime);
        sbU.append(", notificationSetting=");
        return a.B(sbU, this.notificationSetting, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MuteSettingsSheetViewModel$ViewState$Loaded(MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType, String str, boolean z2, boolean z3, String str2, int i) {
        super(null);
        m.checkNotNullParameter(muteSettingsSheetViewModel$SettingsType, "settingsType");
        m.checkNotNullParameter(str, "subtitle");
        this.settingsType = muteSettingsSheetViewModel$SettingsType;
        this.subtitle = str;
        this.isChannelMuted = z2;
        this.isGuildMuted = z3;
        this.muteEndTime = str2;
        this.notificationSetting = i;
    }
}
