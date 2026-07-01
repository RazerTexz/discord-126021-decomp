package com.discord.utilities.view.grid;

import android.view.View;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FrameGridLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FrameGridLayout$Children {
    private final Map<String, View> boundChildren;
    private final List<View> unboundChildren;

    /* JADX WARN: Multi-variable type inference failed */
    public FrameGridLayout$Children(Map<String, ? extends View> map, List<? extends View> list) {
        m.checkNotNullParameter(map, "boundChildren");
        m.checkNotNullParameter(list, "unboundChildren");
        this.boundChildren = map;
        this.unboundChildren = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FrameGridLayout$Children copy$default(FrameGridLayout$Children frameGridLayout$Children, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = frameGridLayout$Children.boundChildren;
        }
        if ((i & 2) != 0) {
            list = frameGridLayout$Children.unboundChildren;
        }
        return frameGridLayout$Children.copy(map, list);
    }

    public final Map<String, View> component1() {
        return this.boundChildren;
    }

    public final List<View> component2() {
        return this.unboundChildren;
    }

    public final FrameGridLayout$Children copy(Map<String, ? extends View> boundChildren, List<? extends View> unboundChildren) {
        m.checkNotNullParameter(boundChildren, "boundChildren");
        m.checkNotNullParameter(unboundChildren, "unboundChildren");
        return new FrameGridLayout$Children(boundChildren, unboundChildren);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameGridLayout$Children)) {
            return false;
        }
        FrameGridLayout$Children frameGridLayout$Children = (FrameGridLayout$Children) other;
        return m.areEqual(this.boundChildren, frameGridLayout$Children.boundChildren) && m.areEqual(this.unboundChildren, frameGridLayout$Children.unboundChildren);
    }

    public final Map<String, View> getBoundChildren() {
        return this.boundChildren;
    }

    public final List<View> getUnboundChildren() {
        return this.unboundChildren;
    }

    public int hashCode() {
        Map<String, View> map = this.boundChildren;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        List<View> list = this.unboundChildren;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Children(boundChildren=");
        sbU.append(this.boundChildren);
        sbU.append(", unboundChildren=");
        return a.L(sbU, this.unboundChildren, ")");
    }
}
