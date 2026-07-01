package com.discord.widgets.servers;

import b.d.b.a.a;

/* JADX INFO: compiled from: NotificationHighlightsSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NotificationHighlightsSettingsView$ViewState {
    private final boolean isMuted;
    private final int notifyHighlights;
    private final boolean serverTooLarge;

    public NotificationHighlightsSettingsView$ViewState(boolean z2, int i, boolean z3) {
        this.isMuted = z2;
        this.notifyHighlights = i;
        this.serverTooLarge = z3;
    }

    public static /* synthetic */ NotificationHighlightsSettingsView$ViewState copy$default(NotificationHighlightsSettingsView$ViewState notificationHighlightsSettingsView$ViewState, boolean z2, int i, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = notificationHighlightsSettingsView$ViewState.isMuted;
        }
        if ((i2 & 2) != 0) {
            i = notificationHighlightsSettingsView$ViewState.notifyHighlights;
        }
        if ((i2 & 4) != 0) {
            z3 = notificationHighlightsSettingsView$ViewState.serverTooLarge;
        }
        return notificationHighlightsSettingsView$ViewState.copy(z2, i, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNotifyHighlights() {
        return this.notifyHighlights;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getServerTooLarge() {
        return this.serverTooLarge;
    }

    public final NotificationHighlightsSettingsView$ViewState copy(boolean isMuted, int notifyHighlights, boolean serverTooLarge) {
        return new NotificationHighlightsSettingsView$ViewState(isMuted, notifyHighlights, serverTooLarge);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationHighlightsSettingsView$ViewState)) {
            return false;
        }
        NotificationHighlightsSettingsView$ViewState notificationHighlightsSettingsView$ViewState = (NotificationHighlightsSettingsView$ViewState) other;
        return this.isMuted == notificationHighlightsSettingsView$ViewState.isMuted && this.notifyHighlights == notificationHighlightsSettingsView$ViewState.notifyHighlights && this.serverTooLarge == notificationHighlightsSettingsView$ViewState.serverTooLarge;
    }

    public final int getNotifyHighlights() {
        return this.notifyHighlights;
    }

    public final boolean getServerTooLarge() {
        return this.serverTooLarge;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.isMuted;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = ((r0 * 31) + this.notifyHighlights) * 31;
        boolean z3 = this.serverTooLarge;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", notifyHighlights=");
        sbU.append(this.notifyHighlights);
        sbU.append(", serverTooLarge=");
        return a.O(sbU, this.serverTooLarge, ")");
    }
}
