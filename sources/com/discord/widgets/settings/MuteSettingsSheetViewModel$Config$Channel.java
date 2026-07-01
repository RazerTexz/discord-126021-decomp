package com.discord.widgets.settings;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MuteSettingsSheetViewModel$Config$Channel extends MuteSettingsSheetViewModel$Config {
    private final long channelId;

    public MuteSettingsSheetViewModel$Config$Channel(long j) {
        super(null);
        this.channelId = j;
    }

    public static /* synthetic */ MuteSettingsSheetViewModel$Config$Channel copy$default(MuteSettingsSheetViewModel$Config$Channel muteSettingsSheetViewModel$Config$Channel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = muteSettingsSheetViewModel$Config$Channel.channelId;
        }
        return muteSettingsSheetViewModel$Config$Channel.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final MuteSettingsSheetViewModel$Config$Channel copy(long channelId) {
        return new MuteSettingsSheetViewModel$Config$Channel(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MuteSettingsSheetViewModel$Config$Channel) && this.channelId == ((MuteSettingsSheetViewModel$Config$Channel) other).channelId;
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
        return a.C(a.U("Channel(channelId="), this.channelId, ")");
    }
}
