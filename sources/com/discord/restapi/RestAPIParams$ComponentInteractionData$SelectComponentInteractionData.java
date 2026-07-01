package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.botuikit.ComponentType;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ComponentInteractionData$SelectComponentInteractionData extends RestAPIParams$ComponentInteractionData {
    private final ComponentType componentType;
    private final String customId;
    private final List<String> values;

    public /* synthetic */ RestAPIParams$ComponentInteractionData$SelectComponentInteractionData(ComponentType componentType, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ComponentType.SELECT : componentType, str, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$ComponentInteractionData$SelectComponentInteractionData copy$default(RestAPIParams$ComponentInteractionData$SelectComponentInteractionData restAPIParams$ComponentInteractionData$SelectComponentInteractionData, ComponentType componentType, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            componentType = restAPIParams$ComponentInteractionData$SelectComponentInteractionData.componentType;
        }
        if ((i & 2) != 0) {
            str = restAPIParams$ComponentInteractionData$SelectComponentInteractionData.customId;
        }
        if ((i & 4) != 0) {
            list = restAPIParams$ComponentInteractionData$SelectComponentInteractionData.values;
        }
        return restAPIParams$ComponentInteractionData$SelectComponentInteractionData.copy(componentType, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ComponentType getComponentType() {
        return this.componentType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    public final List<String> component3() {
        return this.values;
    }

    public final RestAPIParams$ComponentInteractionData$SelectComponentInteractionData copy(ComponentType componentType, String customId, List<String> values) {
        m.checkNotNullParameter(componentType, "componentType");
        m.checkNotNullParameter(customId, "customId");
        m.checkNotNullParameter(values, "values");
        return new RestAPIParams$ComponentInteractionData$SelectComponentInteractionData(componentType, customId, values);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ComponentInteractionData$SelectComponentInteractionData)) {
            return false;
        }
        RestAPIParams$ComponentInteractionData$SelectComponentInteractionData restAPIParams$ComponentInteractionData$SelectComponentInteractionData = (RestAPIParams$ComponentInteractionData$SelectComponentInteractionData) other;
        return m.areEqual(this.componentType, restAPIParams$ComponentInteractionData$SelectComponentInteractionData.componentType) && m.areEqual(this.customId, restAPIParams$ComponentInteractionData$SelectComponentInteractionData.customId) && m.areEqual(this.values, restAPIParams$ComponentInteractionData$SelectComponentInteractionData.values);
    }

    public final ComponentType getComponentType() {
        return this.componentType;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final List<String> getValues() {
        return this.values;
    }

    public int hashCode() {
        ComponentType componentType = this.componentType;
        int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<String> list = this.values;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectComponentInteractionData(componentType=");
        sbU.append(this.componentType);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", values=");
        return a.L(sbU, this.values, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestAPIParams$ComponentInteractionData$SelectComponentInteractionData(ComponentType componentType, String str, List<String> list) {
        super(null);
        m.checkNotNullParameter(componentType, "componentType");
        m.checkNotNullParameter(str, "customId");
        m.checkNotNullParameter(list, "values");
        this.componentType = componentType;
        this.customId = str;
        this.values = list;
    }
}
