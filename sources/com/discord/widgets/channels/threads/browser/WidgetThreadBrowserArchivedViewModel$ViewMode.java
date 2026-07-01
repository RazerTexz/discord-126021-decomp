package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import com.discord.stores.ArchivedThreadsStore$ThreadListingType;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserArchivedViewModel$ViewMode {
    private final boolean isModeratorMode;
    private final ArchivedThreadsStore$ThreadListingType threadListingType;
    private final WidgetThreadBrowserArchivedViewModel$VisibilityMode visibility;

    public WidgetThreadBrowserArchivedViewModel$ViewMode(WidgetThreadBrowserArchivedViewModel$VisibilityMode widgetThreadBrowserArchivedViewModel$VisibilityMode, boolean z2) {
        ArchivedThreadsStore$ThreadListingType archivedThreadsStore$ThreadListingType;
        m.checkNotNullParameter(widgetThreadBrowserArchivedViewModel$VisibilityMode, "visibility");
        this.visibility = widgetThreadBrowserArchivedViewModel$VisibilityMode;
        this.isModeratorMode = z2;
        if (widgetThreadBrowserArchivedViewModel$VisibilityMode.ordinal() == 0) {
            archivedThreadsStore$ThreadListingType = ArchivedThreadsStore$ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS;
        } else if (!z2) {
            archivedThreadsStore$ThreadListingType = ArchivedThreadsStore$ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
        } else {
            if (!z2) {
                throw new NoWhenBranchMatchedException();
            }
            archivedThreadsStore$ThreadListingType = ArchivedThreadsStore$ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS;
        }
        this.threadListingType = archivedThreadsStore$ThreadListingType;
    }

    public static /* synthetic */ WidgetThreadBrowserArchivedViewModel$ViewMode copy$default(WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode, WidgetThreadBrowserArchivedViewModel$VisibilityMode widgetThreadBrowserArchivedViewModel$VisibilityMode, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetThreadBrowserArchivedViewModel$VisibilityMode = widgetThreadBrowserArchivedViewModel$ViewMode.visibility;
        }
        if ((i & 2) != 0) {
            z2 = widgetThreadBrowserArchivedViewModel$ViewMode.isModeratorMode;
        }
        return widgetThreadBrowserArchivedViewModel$ViewMode.copy(widgetThreadBrowserArchivedViewModel$VisibilityMode, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetThreadBrowserArchivedViewModel$VisibilityMode getVisibility() {
        return this.visibility;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsModeratorMode() {
        return this.isModeratorMode;
    }

    public final WidgetThreadBrowserArchivedViewModel$ViewMode copy(WidgetThreadBrowserArchivedViewModel$VisibilityMode visibility, boolean isModeratorMode) {
        m.checkNotNullParameter(visibility, "visibility");
        return new WidgetThreadBrowserArchivedViewModel$ViewMode(visibility, isModeratorMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserArchivedViewModel$ViewMode)) {
            return false;
        }
        WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode = (WidgetThreadBrowserArchivedViewModel$ViewMode) other;
        return m.areEqual(this.visibility, widgetThreadBrowserArchivedViewModel$ViewMode.visibility) && this.isModeratorMode == widgetThreadBrowserArchivedViewModel$ViewMode.isModeratorMode;
    }

    public final ArchivedThreadsStore$ThreadListingType getThreadListingType() {
        return this.threadListingType;
    }

    public final WidgetThreadBrowserArchivedViewModel$VisibilityMode getVisibility() {
        return this.visibility;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        WidgetThreadBrowserArchivedViewModel$VisibilityMode widgetThreadBrowserArchivedViewModel$VisibilityMode = this.visibility;
        int iHashCode = (widgetThreadBrowserArchivedViewModel$VisibilityMode != null ? widgetThreadBrowserArchivedViewModel$VisibilityMode.hashCode() : 0) * 31;
        boolean z2 = this.isModeratorMode;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isModeratorMode() {
        return this.isModeratorMode;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewMode(visibility=");
        sbU.append(this.visibility);
        sbU.append(", isModeratorMode=");
        return a.O(sbU, this.isModeratorMode, ")");
    }
}
