package com.discord.models.botuikit;

import b.d.b.a.a;
import com.discord.api.botuikit.ComponentType;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ActionRowMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActionRowMessageComponent extends LayoutMessageComponent {
    private final List<MessageComponent> components;
    private final int index;
    private final ComponentType type;

    public /* synthetic */ ActionRowMessageComponent(ComponentType componentType, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentType, (i2 & 2) != 0 ? 0 : i, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionRowMessageComponent copy$default(ActionRowMessageComponent actionRowMessageComponent, ComponentType componentType, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            componentType = actionRowMessageComponent.getType();
        }
        if ((i2 & 2) != 0) {
            i = actionRowMessageComponent.getIndex();
        }
        if ((i2 & 4) != 0) {
            list = actionRowMessageComponent.components;
        }
        return actionRowMessageComponent.copy(componentType, i, list);
    }

    public final ComponentType component1() {
        return getType();
    }

    public final int component2() {
        return getIndex();
    }

    public final List<MessageComponent> component3() {
        return this.components;
    }

    public final ActionRowMessageComponent copy(ComponentType type, int index, List<? extends MessageComponent> components) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(components, "components");
        return new ActionRowMessageComponent(type, index, components);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionRowMessageComponent)) {
            return false;
        }
        ActionRowMessageComponent actionRowMessageComponent = (ActionRowMessageComponent) other;
        return m.areEqual(getType(), actionRowMessageComponent.getType()) && getIndex() == actionRowMessageComponent.getIndex() && m.areEqual(this.components, actionRowMessageComponent.components);
    }

    @Override // com.discord.models.botuikit.LayoutMessageComponent
    public List<MessageComponent> getChildren() {
        return this.components;
    }

    public final List<MessageComponent> getComponents() {
        return this.components;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public int getIndex() {
        return this.index;
    }

    @Override // com.discord.models.botuikit.MessageComponent
    public ComponentType getType() {
        return this.type;
    }

    public int hashCode() {
        ComponentType type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        List<MessageComponent> list = this.components;
        return index + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ActionRowMessageComponent(type=");
        sbU.append(getType());
        sbU.append(", index=");
        sbU.append(getIndex());
        sbU.append(", components=");
        return a.L(sbU, this.components, ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionRowMessageComponent(ComponentType componentType, int i, List<? extends MessageComponent> list) {
        m.checkNotNullParameter(componentType, "type");
        m.checkNotNullParameter(list, "components");
        this.type = componentType;
        this.index = i;
        this.components = list;
    }
}
