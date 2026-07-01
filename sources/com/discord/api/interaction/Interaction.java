package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Interaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Interaction {
    public static final int TYPE_INTERACTION_APPLICATION_COMMAND = 2;
    public static final int TYPE_INTERACTION_PING = 1;
    private final Long id;
    private final Interaction2 member;
    private final String name;
    private final Integer type;
    private final User user;

    public Interaction() {
        this.id = null;
        this.type = null;
        this.name = null;
        this.user = null;
        this.member = null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Interaction)) {
            return false;
        }
        Interaction interaction = (Interaction) other;
        return Intrinsics3.areEqual(this.id, interaction.id) && Intrinsics3.areEqual(this.type, interaction.type) && Intrinsics3.areEqual(this.name, interaction.name) && Intrinsics3.areEqual(this.user, interaction.user) && Intrinsics3.areEqual(this.member, interaction.member);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Integer num = this.type;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        Interaction2 interaction2 = this.member;
        return iHashCode4 + (interaction2 != null ? interaction2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Interaction(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }

    public Interaction(Long l, Integer num, String str, User user, Interaction2 interaction2) {
        this.id = l;
        this.type = num;
        this.name = str;
        this.user = user;
        this.member = null;
    }
}
