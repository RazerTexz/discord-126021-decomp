package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RoleAutocompletable extends Autocompletable {
    private final boolean canMention;
    private final GuildRole role;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleAutocompletable(GuildRole guildRole, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(guildRole, "role");
        this.role = guildRole;
        this.canMention = z2;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + guildRole.getName());
    }

    public static /* synthetic */ RoleAutocompletable copy$default(RoleAutocompletable roleAutocompletable, GuildRole guildRole, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = roleAutocompletable.role;
        }
        if ((i & 2) != 0) {
            z2 = roleAutocompletable.canMention;
        }
        return roleAutocompletable.copy(guildRole, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanMention() {
        return this.canMention;
    }

    public final RoleAutocompletable copy(GuildRole role, boolean canMention) {
        Intrinsics3.checkNotNullParameter(role, "role");
        return new RoleAutocompletable(role, canMention);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleAutocompletable)) {
            return false;
        }
        RoleAutocompletable roleAutocompletable = (RoleAutocompletable) other;
        return Intrinsics3.areEqual(this.role, roleAutocompletable.role) && this.canMention == roleAutocompletable.canMention;
    }

    public final boolean getCanMention() {
        return this.canMention;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbQ = outline.Q('<');
        sbQ.append(leadingIdentifier().getIdentifier());
        sbQ.append('&');
        sbQ.append(this.role.getId());
        sbQ.append('>');
        return sbQ.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        GuildRole guildRole = this.role;
        int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
        boolean z2 = this.canMention;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RoleAutocompletable(role=");
        sbU.append(this.role);
        sbU.append(", canMention=");
        return outline.O(sbU, this.canMention, ")");
    }
}
