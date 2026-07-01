package com.discord.widgets.channels.list;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelListModel$Companion$TextLikeChannelData {
    private final boolean hide;
    private final boolean locked;
    private final int mentionCount;
    private final boolean selected;
    private final boolean unread;

    public WidgetChannelListModel$Companion$TextLikeChannelData(boolean z2, int i, boolean z3, boolean z4, boolean z5) {
        this.selected = z2;
        this.mentionCount = i;
        this.unread = z3;
        this.locked = z4;
        this.hide = z5;
    }

    public static /* synthetic */ WidgetChannelListModel$Companion$TextLikeChannelData copy$default(WidgetChannelListModel$Companion$TextLikeChannelData widgetChannelListModel$Companion$TextLikeChannelData, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = widgetChannelListModel$Companion$TextLikeChannelData.selected;
        }
        if ((i2 & 2) != 0) {
            i = widgetChannelListModel$Companion$TextLikeChannelData.mentionCount;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z3 = widgetChannelListModel$Companion$TextLikeChannelData.unread;
        }
        boolean z6 = z3;
        if ((i2 & 8) != 0) {
            z4 = widgetChannelListModel$Companion$TextLikeChannelData.locked;
        }
        boolean z7 = z4;
        if ((i2 & 16) != 0) {
            z5 = widgetChannelListModel$Companion$TextLikeChannelData.hide;
        }
        return widgetChannelListModel$Companion$TextLikeChannelData.copy(z2, i3, z6, z7, z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMentionCount() {
        return this.mentionCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUnread() {
        return this.unread;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHide() {
        return this.hide;
    }

    public final WidgetChannelListModel$Companion$TextLikeChannelData copy(boolean selected, int mentionCount, boolean unread, boolean locked, boolean hide) {
        return new WidgetChannelListModel$Companion$TextLikeChannelData(selected, mentionCount, unread, locked, hide);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelListModel$Companion$TextLikeChannelData)) {
            return false;
        }
        WidgetChannelListModel$Companion$TextLikeChannelData widgetChannelListModel$Companion$TextLikeChannelData = (WidgetChannelListModel$Companion$TextLikeChannelData) other;
        return this.selected == widgetChannelListModel$Companion$TextLikeChannelData.selected && this.mentionCount == widgetChannelListModel$Companion$TextLikeChannelData.mentionCount && this.unread == widgetChannelListModel$Companion$TextLikeChannelData.unread && this.locked == widgetChannelListModel$Companion$TextLikeChannelData.locked && this.hide == widgetChannelListModel$Companion$TextLikeChannelData.hide;
    }

    public final boolean getHide() {
        return this.hide;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final int getMentionCount() {
        return this.mentionCount;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.selected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = ((r0 * 31) + this.mentionCount) * 31;
        boolean z3 = this.unread;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.locked;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.hide;
        return i3 + (z5 ? 1 : z5);
    }

    public String toString() {
        StringBuilder sbU = a.U("TextLikeChannelData(selected=");
        sbU.append(this.selected);
        sbU.append(", mentionCount=");
        sbU.append(this.mentionCount);
        sbU.append(", unread=");
        sbU.append(this.unread);
        sbU.append(", locked=");
        sbU.append(this.locked);
        sbU.append(", hide=");
        return a.O(sbU, this.hide, ")");
    }
}
