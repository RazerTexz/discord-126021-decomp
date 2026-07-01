package com.discord.widgets.chat.overlay;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatOverlay$OldMessageModel {
    public static final WidgetChatOverlay$OldMessageModel$Companion Companion = new WidgetChatOverlay$OldMessageModel$Companion(null);
    private final long channelId;
    private final boolean isViewingOldMessages;

    public WidgetChatOverlay$OldMessageModel(long j, boolean z2) {
        this.channelId = j;
        this.isViewingOldMessages = z2;
    }

    public static /* synthetic */ WidgetChatOverlay$OldMessageModel copy$default(WidgetChatOverlay$OldMessageModel widgetChatOverlay$OldMessageModel, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetChatOverlay$OldMessageModel.channelId;
        }
        if ((i & 2) != 0) {
            z2 = widgetChatOverlay$OldMessageModel.isViewingOldMessages;
        }
        return widgetChatOverlay$OldMessageModel.copy(j, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsViewingOldMessages() {
        return this.isViewingOldMessages;
    }

    public final WidgetChatOverlay$OldMessageModel copy(long channelId, boolean isViewingOldMessages) {
        return new WidgetChatOverlay$OldMessageModel(channelId, isViewingOldMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatOverlay$OldMessageModel)) {
            return false;
        }
        WidgetChatOverlay$OldMessageModel widgetChatOverlay$OldMessageModel = (WidgetChatOverlay$OldMessageModel) other;
        return this.channelId == widgetChatOverlay$OldMessageModel.channelId && this.isViewingOldMessages == widgetChatOverlay$OldMessageModel.isViewingOldMessages;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        boolean z2 = this.isViewingOldMessages;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iA + r1;
    }

    public final boolean isViewingOldMessages() {
        return this.isViewingOldMessages;
    }

    public String toString() {
        StringBuilder sbU = a.U("OldMessageModel(channelId=");
        sbU.append(this.channelId);
        sbU.append(", isViewingOldMessages=");
        return a.O(sbU, this.isViewingOldMessages, ")");
    }
}
