package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid extends WidgetStageChannelModeratorPermissionsViewModel$ViewState {
    private final boolean canEditModerators;
    private final List<PermissionOwnerListView$Item> memberItems;
    private final List<PermissionOwnerListView$Item> roleItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid(List<PermissionOwnerListView$Item> list, List<PermissionOwnerListView$Item> list2, boolean z2) {
        super(null);
        m.checkNotNullParameter(list, "roleItems");
        m.checkNotNullParameter(list2, "memberItems");
        this.roleItems = list;
        this.memberItems = list2;
        this.canEditModerators = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid copy$default(WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid, List list, List list2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.roleItems;
        }
        if ((i & 2) != 0) {
            list2 = widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.memberItems;
        }
        if ((i & 4) != 0) {
            z2 = widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.canEditModerators;
        }
        return widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.copy(list, list2, z2);
    }

    public final List<PermissionOwnerListView$Item> component1() {
        return this.roleItems;
    }

    public final List<PermissionOwnerListView$Item> component2() {
        return this.memberItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanEditModerators() {
        return this.canEditModerators;
    }

    public final WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid copy(List<PermissionOwnerListView$Item> roleItems, List<PermissionOwnerListView$Item> memberItems, boolean canEditModerators) {
        m.checkNotNullParameter(roleItems, "roleItems");
        m.checkNotNullParameter(memberItems, "memberItems");
        return new WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid(roleItems, memberItems, canEditModerators);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid)) {
            return false;
        }
        WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid = (WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid) other;
        return m.areEqual(this.roleItems, widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.roleItems) && m.areEqual(this.memberItems, widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.memberItems) && this.canEditModerators == widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.canEditModerators;
    }

    public final boolean getCanEditModerators() {
        return this.canEditModerators;
    }

    public final List<PermissionOwnerListView$Item> getMemberItems() {
        return this.memberItems;
    }

    public final List<PermissionOwnerListView$Item> getRoleItems() {
        return this.roleItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        List<PermissionOwnerListView$Item> list = this.roleItems;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<PermissionOwnerListView$Item> list2 = this.memberItems;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.canEditModerators;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(roleItems=");
        sbU.append(this.roleItems);
        sbU.append(", memberItems=");
        sbU.append(this.memberItems);
        sbU.append(", canEditModerators=");
        return a.O(sbU, this.canEditModerators, ")");
    }
}
