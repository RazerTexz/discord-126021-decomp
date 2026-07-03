package com.discord.api.interaction;

import com.discord.api.botuikit.Component;
import com.discord.api.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InteractionModalCreate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InteractionModalCreate implements Serializable {
    private final Application application;
    private final List<Component> components;
    private final String customId;
    private final long id;
    private final String nonce;
    private final String title;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: b */
    public final List<Component> m8010b() {
        return this.components;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionModalCreate)) {
            return false;
        }
        InteractionModalCreate interactionModalCreate = (InteractionModalCreate) other;
        return this.id == interactionModalCreate.id && C12238m.areEqual(this.customId, interactionModalCreate.customId) && C12238m.areEqual(this.application, interactionModalCreate.application) && C12238m.areEqual(this.title, interactionModalCreate.title) && C12238m.areEqual(this.components, interactionModalCreate.components) && C12238m.areEqual(this.nonce, interactionModalCreate.nonce);
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.customId;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode2 = (iHashCode + (application != null ? application.hashCode() : 0)) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Component> list = this.components;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.nonce;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InteractionModalCreate(id=");
        sbM833U.append(this.id);
        sbM833U.append(", customId=");
        sbM833U.append(this.customId);
        sbM833U.append(", application=");
        sbM833U.append(this.application);
        sbM833U.append(", title=");
        sbM833U.append(this.title);
        sbM833U.append(", components=");
        sbM833U.append(this.components);
        sbM833U.append(", nonce=");
        return C1643a.m822J(sbM833U, this.nonce, ")");
    }
}
