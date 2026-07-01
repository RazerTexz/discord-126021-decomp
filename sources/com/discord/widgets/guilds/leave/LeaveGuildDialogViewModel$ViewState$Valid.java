package com.discord.widgets.guilds.leave;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class LeaveGuildDialogViewModel$ViewState$Valid extends LeaveGuildDialogViewModel$ViewState {
    private final Guild guild;
    private final boolean isLoading;
    private final boolean isLurking;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGuildDialogViewModel$ViewState$Valid(Guild guild, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.isLoading = z2;
        this.isLurking = z3;
    }

    public static /* synthetic */ LeaveGuildDialogViewModel$ViewState$Valid copy$default(LeaveGuildDialogViewModel$ViewState$Valid leaveGuildDialogViewModel$ViewState$Valid, Guild guild, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = leaveGuildDialogViewModel$ViewState$Valid.guild;
        }
        if ((i & 2) != 0) {
            z2 = leaveGuildDialogViewModel$ViewState$Valid.isLoading;
        }
        if ((i & 4) != 0) {
            z3 = leaveGuildDialogViewModel$ViewState$Valid.isLurking;
        }
        return leaveGuildDialogViewModel$ViewState$Valid.copy(guild, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    public final LeaveGuildDialogViewModel$ViewState$Valid copy(Guild guild, boolean isLoading, boolean isLurking) {
        m.checkNotNullParameter(guild, "guild");
        return new LeaveGuildDialogViewModel$ViewState$Valid(guild, isLoading, isLurking);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveGuildDialogViewModel$ViewState$Valid)) {
            return false;
        }
        LeaveGuildDialogViewModel$ViewState$Valid leaveGuildDialogViewModel$ViewState$Valid = (LeaveGuildDialogViewModel$ViewState$Valid) other;
        return m.areEqual(this.guild, leaveGuildDialogViewModel$ViewState$Valid.guild) && this.isLoading == leaveGuildDialogViewModel$ViewState$Valid.isLoading && this.isLurking == leaveGuildDialogViewModel$ViewState$Valid.isLurking;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.isLoading;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isLurking;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(", isLoading=");
        sbU.append(this.isLoading);
        sbU.append(", isLurking=");
        return a.O(sbU, this.isLurking, ")");
    }
}
