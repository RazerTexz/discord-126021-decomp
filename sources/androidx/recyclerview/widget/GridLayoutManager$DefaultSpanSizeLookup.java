package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public final class GridLayoutManager$DefaultSpanSizeLookup extends GridLayoutManager$SpanSizeLookup {
    @Override // androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup
    public int getSpanIndex(int i, int i2) {
        return i % i2;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup
    public int getSpanSize(int i) {
        return 1;
    }
}
