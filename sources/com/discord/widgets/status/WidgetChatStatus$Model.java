package com.discord.widgets.status;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatStatus$Model {
    public static final WidgetChatStatus$Model$Companion Companion = new WidgetChatStatus$Model$Companion(null);
    private final boolean isUnreadEstimate;
    private final long unreadChannelId;
    private final int unreadCount;
    private final long unreadMessageId;
    private final boolean unreadVisible;

    public WidgetChatStatus$Model(boolean z2, long j, long j2, int i, boolean z3) {
        this.unreadVisible = z2;
        this.unreadMessageId = j;
        this.unreadChannelId = j2;
        this.unreadCount = i;
        this.isUnreadEstimate = z3;
    }

    public static /* synthetic */ WidgetChatStatus$Model copy$default(WidgetChatStatus$Model widgetChatStatus$Model, boolean z2, long j, long j2, int i, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = widgetChatStatus$Model.unreadVisible;
        }
        if ((i2 & 2) != 0) {
            j = widgetChatStatus$Model.unreadMessageId;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = widgetChatStatus$Model.unreadChannelId;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            i = widgetChatStatus$Model.unreadCount;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z3 = widgetChatStatus$Model.isUnreadEstimate;
        }
        return widgetChatStatus$Model.copy(z2, j3, j4, i3, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUnreadVisible() {
        return this.unreadVisible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUnreadMessageId() {
        return this.unreadMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getUnreadChannelId() {
        return this.unreadChannelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsUnreadEstimate() {
        return this.isUnreadEstimate;
    }

    public final WidgetChatStatus$Model copy(boolean unreadVisible, long unreadMessageId, long unreadChannelId, int unreadCount, boolean isUnreadEstimate) {
        return new WidgetChatStatus$Model(unreadVisible, unreadMessageId, unreadChannelId, unreadCount, isUnreadEstimate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatStatus$Model)) {
            return false;
        }
        WidgetChatStatus$Model widgetChatStatus$Model = (WidgetChatStatus$Model) other;
        return this.unreadVisible == widgetChatStatus$Model.unreadVisible && this.unreadMessageId == widgetChatStatus$Model.unreadMessageId && this.unreadChannelId == widgetChatStatus$Model.unreadChannelId && this.unreadCount == widgetChatStatus$Model.unreadCount && this.isUnreadEstimate == widgetChatStatus$Model.isUnreadEstimate;
    }

    public final long getUnreadChannelId() {
        return this.unreadChannelId;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final long getUnreadMessageId() {
        return this.unreadMessageId;
    }

    public final boolean getUnreadVisible() {
        return this.unreadVisible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.unreadVisible;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iA = (((b.a(this.unreadChannelId) + ((b.a(this.unreadMessageId) + (r0 * 31)) * 31)) * 31) + this.unreadCount) * 31;
        boolean z3 = this.isUnreadEstimate;
        return iA + (z3 ? 1 : z3);
    }

    public final boolean isUnreadEstimate() {
        return this.isUnreadEstimate;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(unreadVisible=");
        sbU.append(this.unreadVisible);
        sbU.append(", unreadMessageId=");
        sbU.append(this.unreadMessageId);
        sbU.append(", unreadChannelId=");
        sbU.append(this.unreadChannelId);
        sbU.append(", unreadCount=");
        sbU.append(this.unreadCount);
        sbU.append(", isUnreadEstimate=");
        return a.O(sbU, this.isUnreadEstimate, ")");
    }
}
