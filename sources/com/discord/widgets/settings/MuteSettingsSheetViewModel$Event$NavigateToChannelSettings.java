package com.discord.widgets.settings;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MuteSettingsSheetViewModel$Event$NavigateToChannelSettings extends MuteSettingsSheetViewModel$Event {
    private final long channelId;

    public MuteSettingsSheetViewModel$Event$NavigateToChannelSettings(long j) {
        super(null);
        this.channelId = j;
    }

    public static /* synthetic */ MuteSettingsSheetViewModel$Event$NavigateToChannelSettings copy$default(MuteSettingsSheetViewModel$Event$NavigateToChannelSettings muteSettingsSheetViewModel$Event$NavigateToChannelSettings, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = muteSettingsSheetViewModel$Event$NavigateToChannelSettings.channelId;
        }
        return muteSettingsSheetViewModel$Event$NavigateToChannelSettings.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final MuteSettingsSheetViewModel$Event$NavigateToChannelSettings copy(long channelId) {
        return new MuteSettingsSheetViewModel$Event$NavigateToChannelSettings(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MuteSettingsSheetViewModel$Event$NavigateToChannelSettings) && this.channelId == ((MuteSettingsSheetViewModel$Event$NavigateToChannelSettings) other).channelId;
        }
        return true;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        return b.a(this.channelId);
    }

    public String toString() {
        return a.C(a.U("NavigateToChannelSettings(channelId="), this.channelId, ")");
    }
}
