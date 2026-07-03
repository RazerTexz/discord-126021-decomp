package com.discord.api.botuikit;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActionRowComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActionRowComponent extends LayoutComponent {
    private final List<Component> components;
    private final ComponentType type;

    @Override // com.discord.api.botuikit.LayoutComponent
    /* JADX INFO: renamed from: a */
    public List<Component> mo7593a() {
        return this.components;
    }

    /* JADX INFO: renamed from: b */
    public final List<Component> m7594b() {
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
        return C12238m.areEqual(this.type, actionRowComponent.type) && C12238m.areEqual(this.components, actionRowComponent.components);
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
        StringBuilder sbM833U = C1643a.m833U("ActionRowComponent(type=");
        sbM833U.append(this.type);
        sbM833U.append(", components=");
        return C1643a.m824L(sbM833U, this.components, ")");
    }
}
