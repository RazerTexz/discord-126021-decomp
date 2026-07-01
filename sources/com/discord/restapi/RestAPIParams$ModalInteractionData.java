package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ModalInteractionData {
    private final List<RestAPIParams$ModalInteractionDataComponent> components;
    private final String customId;
    private final long id;

    public RestAPIParams$ModalInteractionData(long j, String str, List<RestAPIParams$ModalInteractionDataComponent> list) {
        m.checkNotNullParameter(str, "customId");
        m.checkNotNullParameter(list, "components");
        this.id = j;
        this.customId = str;
        this.components = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$ModalInteractionData copy$default(RestAPIParams$ModalInteractionData restAPIParams$ModalInteractionData, long j, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = restAPIParams$ModalInteractionData.id;
        }
        if ((i & 2) != 0) {
            str = restAPIParams$ModalInteractionData.customId;
        }
        if ((i & 4) != 0) {
            list = restAPIParams$ModalInteractionData.components;
        }
        return restAPIParams$ModalInteractionData.copy(j, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    public final List<RestAPIParams$ModalInteractionDataComponent> component3() {
        return this.components;
    }

    public final RestAPIParams$ModalInteractionData copy(long id2, String customId, List<RestAPIParams$ModalInteractionDataComponent> components) {
        m.checkNotNullParameter(customId, "customId");
        m.checkNotNullParameter(components, "components");
        return new RestAPIParams$ModalInteractionData(id2, customId, components);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ModalInteractionData)) {
            return false;
        }
        RestAPIParams$ModalInteractionData restAPIParams$ModalInteractionData = (RestAPIParams$ModalInteractionData) other;
        return this.id == restAPIParams$ModalInteractionData.id && m.areEqual(this.customId, restAPIParams$ModalInteractionData.customId) && m.areEqual(this.components, restAPIParams$ModalInteractionData.components);
    }

    public final List<RestAPIParams$ModalInteractionDataComponent> getComponents() {
        return this.components;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.customId;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<RestAPIParams$ModalInteractionDataComponent> list = this.components;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModalInteractionData(id=");
        sbU.append(this.id);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", components=");
        return a.L(sbU, this.components, ")");
    }
}
