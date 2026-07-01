package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.botuikit.ComponentType;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ModalInteractionDataComponent {
    private final List<RestAPIParams$ModalInteractionDataComponent> components;
    private final String customId;
    private final ComponentType type;
    private final String value;

    public RestAPIParams$ModalInteractionDataComponent(ComponentType componentType, List<RestAPIParams$ModalInteractionDataComponent> list, String str, String str2) {
        m.checkNotNullParameter(componentType, "type");
        this.type = componentType;
        this.components = list;
        this.customId = str;
        this.value = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$ModalInteractionDataComponent copy$default(RestAPIParams$ModalInteractionDataComponent restAPIParams$ModalInteractionDataComponent, ComponentType componentType, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            componentType = restAPIParams$ModalInteractionDataComponent.type;
        }
        if ((i & 2) != 0) {
            list = restAPIParams$ModalInteractionDataComponent.components;
        }
        if ((i & 4) != 0) {
            str = restAPIParams$ModalInteractionDataComponent.customId;
        }
        if ((i & 8) != 0) {
            str2 = restAPIParams$ModalInteractionDataComponent.value;
        }
        return restAPIParams$ModalInteractionDataComponent.copy(componentType, list, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ComponentType getType() {
        return this.type;
    }

    public final List<RestAPIParams$ModalInteractionDataComponent> component2() {
        return this.components;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final RestAPIParams$ModalInteractionDataComponent copy(ComponentType type, List<RestAPIParams$ModalInteractionDataComponent> components, String customId, String value) {
        m.checkNotNullParameter(type, "type");
        return new RestAPIParams$ModalInteractionDataComponent(type, components, customId, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ModalInteractionDataComponent)) {
            return false;
        }
        RestAPIParams$ModalInteractionDataComponent restAPIParams$ModalInteractionDataComponent = (RestAPIParams$ModalInteractionDataComponent) other;
        return m.areEqual(this.type, restAPIParams$ModalInteractionDataComponent.type) && m.areEqual(this.components, restAPIParams$ModalInteractionDataComponent.components) && m.areEqual(this.customId, restAPIParams$ModalInteractionDataComponent.customId) && m.areEqual(this.value, restAPIParams$ModalInteractionDataComponent.value);
    }

    public final List<RestAPIParams$ModalInteractionDataComponent> getComponents() {
        return this.components;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final ComponentType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        ComponentType componentType = this.type;
        int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
        List<RestAPIParams$ModalInteractionDataComponent> list = this.components;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModalInteractionDataComponent(type=");
        sbU.append(this.type);
        sbU.append(", components=");
        sbU.append(this.components);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", value=");
        return a.J(sbU, this.value, ")");
    }
}
