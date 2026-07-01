package com.discord.widgets.guilds.leave;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class LeaveGuildDialogViewModel$StoreState$Valid extends LeaveGuildDialogViewModel$StoreState {
    private final Guild guild;
    private final boolean isLurking;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGuildDialogViewModel$StoreState$Valid(Guild guild, boolean z2) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.isLurking = z2;
    }

    public static /* synthetic */ LeaveGuildDialogViewModel$StoreState$Valid copy$default(LeaveGuildDialogViewModel$StoreState$Valid leaveGuildDialogViewModel$StoreState$Valid, Guild guild, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = leaveGuildDialogViewModel$StoreState$Valid.guild;
        }
        if ((i & 2) != 0) {
            z2 = leaveGuildDialogViewModel$StoreState$Valid.isLurking;
        }
        return leaveGuildDialogViewModel$StoreState$Valid.copy(guild, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    public final LeaveGuildDialogViewModel$StoreState$Valid copy(Guild guild, boolean isLurking) {
        m.checkNotNullParameter(guild, "guild");
        return new LeaveGuildDialogViewModel$StoreState$Valid(guild, isLurking);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveGuildDialogViewModel$StoreState$Valid)) {
            return false;
        }
        LeaveGuildDialogViewModel$StoreState$Valid leaveGuildDialogViewModel$StoreState$Valid = (LeaveGuildDialogViewModel$StoreState$Valid) other;
        return m.areEqual(this.guild, leaveGuildDialogViewModel$StoreState$Valid.guild) && this.isLurking == leaveGuildDialogViewModel$StoreState$Valid.isLurking;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.isLurking;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(", isLurking=");
        return a.O(sbU, this.isLurking, ")");
    }
}
