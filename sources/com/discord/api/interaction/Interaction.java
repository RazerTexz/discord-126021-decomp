package com.discord.api.interaction;

import b.d.b.a.a;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: Interaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Interaction {
    public static final Interaction$Companion Companion = new Interaction$Companion(null);
    public static final int TYPE_INTERACTION_APPLICATION_COMMAND = 2;
    public static final int TYPE_INTERACTION_PING = 1;
    private final Long id;
    private final Member member;
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
        return m.areEqual(this.id, interaction.id) && m.areEqual(this.type, interaction.type) && m.areEqual(this.name, interaction.name) && m.areEqual(this.user, interaction.user) && m.areEqual(this.member, interaction.member);
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
        Member member = this.member;
        return iHashCode4 + (member != null ? member.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Interaction(id=");
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

    public Interaction(Long l, Integer num, String str, User user, Member member) {
        this.id = l;
        this.type = num;
        this.name = str;
        this.user = user;
        this.member = null;
    }
}
