package androidx.recyclerview.widget;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator$ChangeInfo {
    public int fromX;
    public int fromY;
    public RecyclerView$ViewHolder newHolder;
    public RecyclerView$ViewHolder oldHolder;
    public int toX;
    public int toY;

    private DefaultItemAnimator$ChangeInfo(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        this.oldHolder = recyclerView$ViewHolder;
        this.newHolder = recyclerView$ViewHolder2;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChangeInfo{oldHolder=");
        sbU.append(this.oldHolder);
        sbU.append(", newHolder=");
        sbU.append(this.newHolder);
        sbU.append(", fromX=");
        sbU.append(this.fromX);
        sbU.append(", fromY=");
        sbU.append(this.fromY);
        sbU.append(", toX=");
        sbU.append(this.toX);
        sbU.append(", toY=");
        return a.A(sbU, this.toY, '}');
    }

    public DefaultItemAnimator$ChangeInfo(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2, int i, int i2, int i3, int i4) {
        this(recyclerView$ViewHolder, recyclerView$ViewHolder2);
        this.fromX = i;
        this.fromY = i2;
        this.toX = i3;
        this.toY = i4;
    }
}
