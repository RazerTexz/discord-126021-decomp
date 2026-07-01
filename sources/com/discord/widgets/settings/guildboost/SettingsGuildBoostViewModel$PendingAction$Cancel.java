package com.discord.widgets.settings.guildboost;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGuildBoostViewModel$PendingAction$Cancel extends SettingsGuildBoostViewModel$PendingAction {
    private final long slotId;

    public SettingsGuildBoostViewModel$PendingAction$Cancel(long j) {
        super(null);
        this.slotId = j;
    }

    public static /* synthetic */ SettingsGuildBoostViewModel$PendingAction$Cancel copy$default(SettingsGuildBoostViewModel$PendingAction$Cancel settingsGuildBoostViewModel$PendingAction$Cancel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = settingsGuildBoostViewModel$PendingAction$Cancel.slotId;
        }
        return settingsGuildBoostViewModel$PendingAction$Cancel.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSlotId() {
        return this.slotId;
    }

    public final SettingsGuildBoostViewModel$PendingAction$Cancel copy(long slotId) {
        return new SettingsGuildBoostViewModel$PendingAction$Cancel(slotId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsGuildBoostViewModel$PendingAction$Cancel) && this.slotId == ((SettingsGuildBoostViewModel$PendingAction$Cancel) other).slotId;
        }
        return true;
    }

    public final long getSlotId() {
        return this.slotId;
    }

    public int hashCode() {
        return b.a(this.slotId);
    }

    public String toString() {
        return a.C(a.U("Cancel(slotId="), this.slotId, ")");
    }
}
