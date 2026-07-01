package com.discord.widgets.guilds.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildListAdapter$Operation$MoveAbove extends WidgetGuildListAdapter$Operation {
    private final int fromPosition;
    private final int targetPosition;

    public WidgetGuildListAdapter$Operation$MoveAbove(int i, int i2) {
        super(null);
        this.fromPosition = i;
        this.targetPosition = i2;
    }

    public static /* synthetic */ WidgetGuildListAdapter$Operation$MoveAbove copy$default(WidgetGuildListAdapter$Operation$MoveAbove widgetGuildListAdapter$Operation$MoveAbove, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = widgetGuildListAdapter$Operation$MoveAbove.fromPosition;
        }
        if ((i3 & 2) != 0) {
            i2 = widgetGuildListAdapter$Operation$MoveAbove.targetPosition;
        }
        return widgetGuildListAdapter$Operation$MoveAbove.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFromPosition() {
        return this.fromPosition;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTargetPosition() {
        return this.targetPosition;
    }

    public final WidgetGuildListAdapter$Operation$MoveAbove copy(int fromPosition, int targetPosition) {
        return new WidgetGuildListAdapter$Operation$MoveAbove(fromPosition, targetPosition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildListAdapter$Operation$MoveAbove)) {
            return false;
        }
        WidgetGuildListAdapter$Operation$MoveAbove widgetGuildListAdapter$Operation$MoveAbove = (WidgetGuildListAdapter$Operation$MoveAbove) other;
        return this.fromPosition == widgetGuildListAdapter$Operation$MoveAbove.fromPosition && this.targetPosition == widgetGuildListAdapter$Operation$MoveAbove.targetPosition;
    }

    public final int getFromPosition() {
        return this.fromPosition;
    }

    public final int getTargetPosition() {
        return this.targetPosition;
    }

    public int hashCode() {
        return (this.fromPosition * 31) + this.targetPosition;
    }

    public String toString() {
        StringBuilder sbU = a.U("MoveAbove(fromPosition=");
        sbU.append(this.fromPosition);
        sbU.append(", targetPosition=");
        return a.B(sbU, this.targetPosition, ")");
    }
}
