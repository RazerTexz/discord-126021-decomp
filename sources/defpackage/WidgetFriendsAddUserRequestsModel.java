package defpackage;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetFriendsAddUserRequestsModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Set<Long> outgoingIds;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Set<Long> incomingIds;

    public WidgetFriendsAddUserRequestsModel(Set<Long> set, Set<Long> set2) {
        m.checkNotNullParameter(set, "outgoingIds");
        m.checkNotNullParameter(set2, "incomingIds");
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
        return m.areEqual(this.outgoingIds, widgetFriendsAddUserRequestsModel.outgoingIds) && m.areEqual(this.incomingIds, widgetFriendsAddUserRequestsModel.incomingIds);
    }

    public int hashCode() {
        Set<Long> set = this.outgoingIds;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Set<Long> set2 = this.incomingIds;
        return iHashCode + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetFriendsAddUserRequestsModel(outgoingIds=");
        sbU.append(this.outgoingIds);
        sbU.append(", incomingIds=");
        return a.N(sbU, this.incomingIds, ")");
    }
}
