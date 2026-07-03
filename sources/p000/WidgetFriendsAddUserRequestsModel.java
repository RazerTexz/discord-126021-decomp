package p000;

import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetFriendsAddUserRequestsModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Set<Long> outgoingIds;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Set<Long> incomingIds;

    public WidgetFriendsAddUserRequestsModel(Set<Long> set, Set<Long> set2) {
        C12238m.checkNotNullParameter(set, "outgoingIds");
        C12238m.checkNotNullParameter(set2, "incomingIds");
        this.outgoingIds = set;
        this.incomingIds = set2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetFriendsAddUserRequestsModel)) {
            return false;
        }
        WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel = (WidgetFriendsAddUserRequestsModel) other;
        return C12238m.areEqual(this.outgoingIds, widgetFriendsAddUserRequestsModel.outgoingIds) && C12238m.areEqual(this.incomingIds, widgetFriendsAddUserRequestsModel.incomingIds);
    }

    public int hashCode() {
        Set<Long> set = this.outgoingIds;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Set<Long> set2 = this.incomingIds;
        return iHashCode + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("WidgetFriendsAddUserRequestsModel(outgoingIds=");
        sbM833U.append(this.outgoingIds);
        sbM833U.append(", incomingIds=");
        return C1643a.m826N(sbM833U, this.incomingIds, ")");
    }
}
