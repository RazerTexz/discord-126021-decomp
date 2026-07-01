package com.discord.widgets.guilds.profile;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$BottomActions {
    private final boolean showJoinServer;
    private final boolean showUploadEmoji;
    private final boolean showViewServer;

    public WidgetGuildProfileSheetViewModel$BottomActions(boolean z2, boolean z3, boolean z4) {
        this.showUploadEmoji = z2;
        this.showJoinServer = z3;
        this.showViewServer = z4;
    }

    public static /* synthetic */ WidgetGuildProfileSheetViewModel$BottomActions copy$default(WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetGuildProfileSheetViewModel$BottomActions.showUploadEmoji;
        }
        if ((i & 2) != 0) {
            z3 = widgetGuildProfileSheetViewModel$BottomActions.showJoinServer;
        }
        if ((i & 4) != 0) {
            z4 = widgetGuildProfileSheetViewModel$BottomActions.showViewServer;
        }
        return widgetGuildProfileSheetViewModel$BottomActions.copy(z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowUploadEmoji() {
        return this.showUploadEmoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowJoinServer() {
        return this.showJoinServer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowViewServer() {
        return this.showViewServer;
    }

    public final WidgetGuildProfileSheetViewModel$BottomActions copy(boolean showUploadEmoji, boolean showJoinServer, boolean showViewServer) {
        return new WidgetGuildProfileSheetViewModel$BottomActions(showUploadEmoji, showJoinServer, showViewServer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildProfileSheetViewModel$BottomActions)) {
            return false;
        }
        WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions = (WidgetGuildProfileSheetViewModel$BottomActions) other;
        return this.showUploadEmoji == widgetGuildProfileSheetViewModel$BottomActions.showUploadEmoji && this.showJoinServer == widgetGuildProfileSheetViewModel$BottomActions.showJoinServer && this.showViewServer == widgetGuildProfileSheetViewModel$BottomActions.showViewServer;
    }

    public final boolean getShowJoinServer() {
        return this.showJoinServer;
    }

    public final boolean getShowUploadEmoji() {
        return this.showUploadEmoji;
    }

    public final boolean getShowViewServer() {
        return this.showViewServer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.showUploadEmoji;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.showJoinServer;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.showViewServer;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = a.U("BottomActions(showUploadEmoji=");
        sbU.append(this.showUploadEmoji);
        sbU.append(", showJoinServer=");
        sbU.append(this.showJoinServer);
        sbU.append(", showViewServer=");
        return a.O(sbU, this.showViewServer, ")");
    }
}
