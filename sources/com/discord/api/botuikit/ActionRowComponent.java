package com.discord.api.botuikit;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ActionRowComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActionRowComponent extends LayoutComponent {
    private final List<Component> components;
    private final ComponentType type;

    @Override // com.discord.api.botuikit.LayoutComponent
    public List<Component> a() {
        return this.components;
    }

    public final List<Component> b() {
        return this.components;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionRowComponent)) {
            return false;
        }
        ActionRowComponent actionRowComponent = (ActionRowComponent) other;
        return m.areEqual(this.type, actionRowComponent.type) && m.areEqual(this.components, actionRowComponent.components);
    }

    @Override // com.discord.api.botuikit.Component
    public ComponentType getType() {
        return this.type;
    }

    public int hashCode() {
        ComponentType componentType = this.type;
        int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
        List<Component> list = this.components;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ActionRowComponent(type=");
        sbU.append(this.type);
        sbU.append(", components=");
        return a.L(sbU, this.components, ")");
    }
}
