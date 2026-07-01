package com.discord.widgets.settings.guildboost;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGuildBoostViewModel$PendingAction$Transfer extends SettingsGuildBoostViewModel$PendingAction {
    private final long previousGuildId;
    private final ModelGuildBoostSlot slot;
    private final Long targetGuildId;

    public /* synthetic */ SettingsGuildBoostViewModel$PendingAction$Transfer(ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(modelGuildBoostSlot, j, (i & 4) != 0 ? null : l);
    }

    public static /* synthetic */ SettingsGuildBoostViewModel$PendingAction$Transfer copy$default(SettingsGuildBoostViewModel$PendingAction$Transfer settingsGuildBoostViewModel$PendingAction$Transfer, ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildBoostSlot = settingsGuildBoostViewModel$PendingAction$Transfer.slot;
        }
        if ((i & 2) != 0) {
            j = settingsGuildBoostViewModel$PendingAction$Transfer.previousGuildId;
        }
        if ((i & 4) != 0) {
            l = settingsGuildBoostViewModel$PendingAction$Transfer.targetGuildId;
        }
        return settingsGuildBoostViewModel$PendingAction$Transfer.copy(modelGuildBoostSlot, j, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildBoostSlot getSlot() {
        return this.slot;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPreviousGuildId() {
        return this.previousGuildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getTargetGuildId() {
        return this.targetGuildId;
    }

    public final SettingsGuildBoostViewModel$PendingAction$Transfer copy(ModelGuildBoostSlot slot, long previousGuildId, Long targetGuildId) {
        m.checkNotNullParameter(slot, "slot");
        return new SettingsGuildBoostViewModel$PendingAction$Transfer(slot, previousGuildId, targetGuildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGuildBoostViewModel$PendingAction$Transfer)) {
            return false;
        }
        SettingsGuildBoostViewModel$PendingAction$Transfer settingsGuildBoostViewModel$PendingAction$Transfer = (SettingsGuildBoostViewModel$PendingAction$Transfer) other;
        return m.areEqual(this.slot, settingsGuildBoostViewModel$PendingAction$Transfer.slot) && this.previousGuildId == settingsGuildBoostViewModel$PendingAction$Transfer.previousGuildId && m.areEqual(this.targetGuildId, settingsGuildBoostViewModel$PendingAction$Transfer.targetGuildId);
    }

    public final long getPreviousGuildId() {
        return this.previousGuildId;
    }

    public final ModelGuildBoostSlot getSlot() {
        return this.slot;
    }

    public final Long getTargetGuildId() {
        return this.targetGuildId;
    }

    public int hashCode() {
        ModelGuildBoostSlot modelGuildBoostSlot = this.slot;
        int iA = (b.a(this.previousGuildId) + ((modelGuildBoostSlot != null ? modelGuildBoostSlot.hashCode() : 0) * 31)) * 31;
        Long l = this.targetGuildId;
        return iA + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Transfer(slot=");
        sbU.append(this.slot);
        sbU.append(", previousGuildId=");
        sbU.append(this.previousGuildId);
        sbU.append(", targetGuildId=");
        return a.G(sbU, this.targetGuildId, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostViewModel$PendingAction$Transfer(ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l) {
        super(null);
        m.checkNotNullParameter(modelGuildBoostSlot, "slot");
        this.slot = modelGuildBoostSlot;
        this.previousGuildId = j;
        this.targetGuildId = l;
    }
}
