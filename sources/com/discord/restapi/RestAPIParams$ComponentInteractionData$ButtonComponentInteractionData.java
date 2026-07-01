package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.botuikit.ComponentType;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData extends RestAPIParams$ComponentInteractionData {
    private final ComponentType componentType;
    private final String customId;

    public /* synthetic */ RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData(ComponentType componentType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ComponentType.BUTTON : componentType, str);
    }

    public static /* synthetic */ RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData copy$default(RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData restAPIParams$ComponentInteractionData$ButtonComponentInteractionData, ComponentType componentType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            componentType = restAPIParams$ComponentInteractionData$ButtonComponentInteractionData.componentType;
        }
        if ((i & 2) != 0) {
            str = restAPIParams$ComponentInteractionData$ButtonComponentInteractionData.customId;
        }
        return restAPIParams$ComponentInteractionData$ButtonComponentInteractionData.copy(componentType, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ComponentType getComponentType() {
        return this.componentType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    public final RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData copy(ComponentType componentType, String customId) {
        m.checkNotNullParameter(componentType, "componentType");
        m.checkNotNullParameter(customId, "customId");
        return new RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData(componentType, customId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData)) {
            return false;
        }
        RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData restAPIParams$ComponentInteractionData$ButtonComponentInteractionData = (RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData) other;
        return m.areEqual(this.componentType, restAPIParams$ComponentInteractionData$ButtonComponentInteractionData.componentType) && m.areEqual(this.customId, restAPIParams$ComponentInteractionData$ButtonComponentInteractionData.customId);
    }

    public final ComponentType getComponentType() {
        return this.componentType;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public int hashCode() {
        ComponentType componentType = this.componentType;
        int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
        String str = this.customId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ButtonComponentInteractionData(componentType=");
        sbU.append(this.componentType);
        sbU.append(", customId=");
        return a.J(sbU, this.customId, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestAPIParams$ComponentInteractionData$ButtonComponentInteractionData(ComponentType componentType, String str) {
        super(null);
        m.checkNotNullParameter(componentType, "componentType");
        m.checkNotNullParameter(str, "customId");
        this.componentType = componentType;
        this.customId = str;
    }
}
