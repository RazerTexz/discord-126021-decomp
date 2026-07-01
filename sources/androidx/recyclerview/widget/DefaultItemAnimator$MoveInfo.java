package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator$MoveInfo {
    public int fromX;
    public int fromY;
    public RecyclerView$ViewHolder holder;
    public int toX;
    public int toY;

    public DefaultItemAnimator$MoveInfo(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, int i3, int i4) {
        this.holder = recyclerView$ViewHolder;
        this.fromX = i;
        this.fromY = i2;
        this.toX = i3;
        this.toY = i4;
    }
}
