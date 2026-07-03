package com.discord.api.message.embed;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmbedField.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EmbedField {
    private final Boolean inline;
    private final String name;
    private final String value;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedField)) {
            return false;
        }
        EmbedField embedField = (EmbedField) other;
        return C12238m.areEqual(this.name, embedField.name) && C12238m.areEqual(this.value, embedField.value) && C12238m.areEqual(this.inline, embedField.inline);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.inline;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmbedField(name=");
        sbM833U.append(this.name);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(", inline=");
        return C1643a.m816D(sbM833U, this.inline, ")");
    }
}
