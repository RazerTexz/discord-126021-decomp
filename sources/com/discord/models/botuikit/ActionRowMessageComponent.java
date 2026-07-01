package com.discord.models.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.Component6;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ActionRowMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActionRowMessageComponent extends MessageComponent3 {
    private final List<MessageComponent> components;
    private final int index;
    private final Component6 type;

    public /* synthetic */ ActionRowMessageComponent(Component6 component6, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(component6, (i2 & 2) != 0 ? 0 : i, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionRowMessageComponent copy$default(ActionRowMessageComponent actionRowMessageComponent, Component6 component6, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            component6 = actionRowMessageComponent.getType();
        }
        if ((i2 & 2) != 0) {
            i = actionRowMessageComponent.getIndex();
        }
        if ((i2 & 4) != 0) {
            list = actionRowMessageComponent.components;
        }
        return actionRowMessageComponent.copy(component6, i, list);
    }

    public final Component6 component1() {
        return getType();
    }

    public final int component2() {
        return getIndex();
    }

    public final List<MessageComponent> component3() {
        return this.components;
    }

    public final ActionRowMessageComponent copy(Component6 type, int index, List<? extends MessageComponent> components) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(components, "components");
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
        return Intrinsics3.areEqual(getType(), actionRowMessageComponent.getType()) && getIndex() == actionRowMessageComponent.getIndex() && Intrinsics3.areEqual(this.components, actionRowMessageComponent.components);
    }

    @Override // com.discord.models.botuikit.MessageComponent3
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
    public Component6 getType() {
        return this.type;
    }

    public int hashCode() {
        Component6 type = getType();
        int index = (getIndex() + ((type != null ? type.hashCode() : 0) * 31)) * 31;
        List<MessageComponent> list = this.components;
        return index + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActionRowMessageComponent(type=");
        sbU.append(getType());
        sbU.append(", index=");
        sbU.append(getIndex());
        sbU.append(", components=");
        return outline.L(sbU, this.components, ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionRowMessageComponent(Component6 component6, int i, List<? extends MessageComponent> list) {
        Intrinsics3.checkNotNullParameter(component6, "type");
        Intrinsics3.checkNotNullParameter(list, "components");
        this.type = component6;
        this.index = i;
        this.components = list;
    }
}
