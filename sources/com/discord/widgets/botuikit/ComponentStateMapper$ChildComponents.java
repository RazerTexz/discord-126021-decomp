package com.discord.widgets.botuikit;

import b.d.b.a.a;
import com.discord.api.botuikit.LayoutComponent;
import com.discord.models.botuikit.MessageComponent;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ComponentStateMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ComponentStateMapper$ChildComponents {
    private final MessageComponent[] components;
    private int currentComponentInsertionIndex;
    private final int layoutComponentIndex;
    private final LayoutComponent parentLayoutComponent;
    private final int total;

    public ComponentStateMapper$ChildComponents(int i, LayoutComponent layoutComponent, int i2, int i3) {
        this.layoutComponentIndex = i;
        this.parentLayoutComponent = layoutComponent;
        this.currentComponentInsertionIndex = i2;
        this.total = i3;
        MessageComponent[] messageComponentArr = new MessageComponent[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            messageComponentArr[i4] = null;
        }
        this.components = messageComponentArr;
    }

    public static /* synthetic */ ComponentStateMapper$ChildComponents copy$default(ComponentStateMapper$ChildComponents componentStateMapper$ChildComponents, int i, LayoutComponent layoutComponent, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = componentStateMapper$ChildComponents.layoutComponentIndex;
        }
        if ((i4 & 2) != 0) {
            layoutComponent = componentStateMapper$ChildComponents.parentLayoutComponent;
        }
        if ((i4 & 4) != 0) {
            i2 = componentStateMapper$ChildComponents.currentComponentInsertionIndex;
        }
        if ((i4 & 8) != 0) {
            i3 = componentStateMapper$ChildComponents.total;
        }
        return componentStateMapper$ChildComponents.copy(i, layoutComponent, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLayoutComponentIndex() {
        return this.layoutComponentIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LayoutComponent getParentLayoutComponent() {
        return this.parentLayoutComponent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCurrentComponentInsertionIndex() {
        return this.currentComponentInsertionIndex;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final ComponentStateMapper$ChildComponents copy(int layoutComponentIndex, LayoutComponent parentLayoutComponent, int currentComponentInsertionIndex, int total) {
        return new ComponentStateMapper$ChildComponents(layoutComponentIndex, parentLayoutComponent, currentComponentInsertionIndex, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComponentStateMapper$ChildComponents)) {
            return false;
        }
        ComponentStateMapper$ChildComponents componentStateMapper$ChildComponents = (ComponentStateMapper$ChildComponents) other;
        return this.layoutComponentIndex == componentStateMapper$ChildComponents.layoutComponentIndex && m.areEqual(this.parentLayoutComponent, componentStateMapper$ChildComponents.parentLayoutComponent) && this.currentComponentInsertionIndex == componentStateMapper$ChildComponents.currentComponentInsertionIndex && this.total == componentStateMapper$ChildComponents.total;
    }

    public final MessageComponent[] getComponents() {
        return this.components;
    }

    public final int getCurrentComponentInsertionIndex() {
        return this.currentComponentInsertionIndex;
    }

    public final int getLayoutComponentIndex() {
        return this.layoutComponentIndex;
    }

    public final LayoutComponent getParentLayoutComponent() {
        return this.parentLayoutComponent;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        int i = this.layoutComponentIndex * 31;
        LayoutComponent layoutComponent = this.parentLayoutComponent;
        return ((((i + (layoutComponent != null ? layoutComponent.hashCode() : 0)) * 31) + this.currentComponentInsertionIndex) * 31) + this.total;
    }

    public final void setCurrentComponentInsertionIndex(int i) {
        this.currentComponentInsertionIndex = i;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChildComponents(layoutComponentIndex=");
        sbU.append(this.layoutComponentIndex);
        sbU.append(", parentLayoutComponent=");
        sbU.append(this.parentLayoutComponent);
        sbU.append(", currentComponentInsertionIndex=");
        sbU.append(this.currentComponentInsertionIndex);
        sbU.append(", total=");
        return a.B(sbU, this.total, ")");
    }

    public /* synthetic */ ComponentStateMapper$ChildComponents(int i, LayoutComponent layoutComponent, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? null : layoutComponent, (i4 & 4) != 0 ? 0 : i2, i3);
    }
}
