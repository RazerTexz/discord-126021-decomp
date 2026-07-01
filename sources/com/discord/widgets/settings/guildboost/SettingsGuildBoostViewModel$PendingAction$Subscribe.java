package com.discord.widgets.settings.guildboost;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGuildBoostViewModel$PendingAction$Subscribe extends SettingsGuildBoostViewModel$PendingAction {
    private final long slotId;
    private final Long targetGuildId;

    public /* synthetic */ SettingsGuildBoostViewModel$PendingAction$Subscribe(long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : l);
    }

    public static /* synthetic */ SettingsGuildBoostViewModel$PendingAction$Subscribe copy$default(SettingsGuildBoostViewModel$PendingAction$Subscribe settingsGuildBoostViewModel$PendingAction$Subscribe, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = settingsGuildBoostViewModel$PendingAction$Subscribe.slotId;
        }
        if ((i & 2) != 0) {
            l = settingsGuildBoostViewModel$PendingAction$Subscribe.targetGuildId;
        }
        return settingsGuildBoostViewModel$PendingAction$Subscribe.copy(j, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSlotId() {
        return this.slotId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getTargetGuildId() {
        return this.targetGuildId;
    }

    public final SettingsGuildBoostViewModel$PendingAction$Subscribe copy(long slotId, Long targetGuildId) {
        return new SettingsGuildBoostViewModel$PendingAction$Subscribe(slotId, targetGuildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGuildBoostViewModel$PendingAction$Subscribe)) {
            return false;
        }
        SettingsGuildBoostViewModel$PendingAction$Subscribe settingsGuildBoostViewModel$PendingAction$Subscribe = (SettingsGuildBoostViewModel$PendingAction$Subscribe) other;
        return this.slotId == settingsGuildBoostViewModel$PendingAction$Subscribe.slotId && m.areEqual(this.targetGuildId, settingsGuildBoostViewModel$PendingAction$Subscribe.targetGuildId);
    }

    public final long getSlotId() {
        return this.slotId;
    }

    public final Long getTargetGuildId() {
        return this.targetGuildId;
    }

    public int hashCode() {
        int iA = b.a(this.slotId) * 31;
        Long l = this.targetGuildId;
        return iA + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Subscribe(slotId=");
        sbU.append(this.slotId);
        sbU.append(", targetGuildId=");
        return a.G(sbU, this.targetGuildId, ")");
    }

    public SettingsGuildBoostViewModel$PendingAction$Subscribe(long j, Long l) {
        super(null);
        this.slotId = j;
        this.targetGuildId = l;
    }
}
