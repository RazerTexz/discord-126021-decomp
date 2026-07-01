package com.discord.api.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ActionRowComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActionRowComponent extends Component8 {
    private final List<Component> components;
    private final Component6 type;

    @Override // com.discord.api.botuikit.Component8
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
        return Intrinsics3.areEqual(this.type, actionRowComponent.type) && Intrinsics3.areEqual(this.components, actionRowComponent.components);
    }

    @Override // com.discord.api.botuikit.Component
    public Component6 getType() {
        return this.type;
    }

    public int hashCode() {
        Component6 component6 = this.type;
        int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
        List<Component> list = this.components;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActionRowComponent(type=");
        sbU.append(this.type);
        sbU.append(", components=");
        return outline.L(sbU, this.components, ")");
    }
}
