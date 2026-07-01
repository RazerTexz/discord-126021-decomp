package com.discord.widgets.settings;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MuteSettingsSheetViewModel$Config$Guild extends MuteSettingsSheetViewModel$Config {
    private final long guildId;

    public MuteSettingsSheetViewModel$Config$Guild(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ MuteSettingsSheetViewModel$Config$Guild copy$default(MuteSettingsSheetViewModel$Config$Guild muteSettingsSheetViewModel$Config$Guild, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = muteSettingsSheetViewModel$Config$Guild.guildId;
        }
        return muteSettingsSheetViewModel$Config$Guild.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final MuteSettingsSheetViewModel$Config$Guild copy(long guildId) {
        return new MuteSettingsSheetViewModel$Config$Guild(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MuteSettingsSheetViewModel$Config$Guild) && this.guildId == ((MuteSettingsSheetViewModel$Config$Guild) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("Guild(guildId="), this.guildId, ")");
    }
}
