package com.discord.widgets.settings.guildboost;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGuildBoostViewModel$PendingAction$Uncancel extends SettingsGuildBoostViewModel$PendingAction {
    private final long slotId;

    public SettingsGuildBoostViewModel$PendingAction$Uncancel(long j) {
        super(null);
        this.slotId = j;
    }

    public static /* synthetic */ SettingsGuildBoostViewModel$PendingAction$Uncancel copy$default(SettingsGuildBoostViewModel$PendingAction$Uncancel settingsGuildBoostViewModel$PendingAction$Uncancel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = settingsGuildBoostViewModel$PendingAction$Uncancel.slotId;
        }
        return settingsGuildBoostViewModel$PendingAction$Uncancel.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSlotId() {
        return this.slotId;
    }

    public final SettingsGuildBoostViewModel$PendingAction$Uncancel copy(long slotId) {
        return new SettingsGuildBoostViewModel$PendingAction$Uncancel(slotId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsGuildBoostViewModel$PendingAction$Uncancel) && this.slotId == ((SettingsGuildBoostViewModel$PendingAction$Uncancel) other).slotId;
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
        return a.C(a.U("Uncancel(slotId="), this.slotId, ")");
    }
}
