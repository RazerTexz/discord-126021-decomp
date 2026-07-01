package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public interface OpReorderer$Callback {
    AdapterHelper$UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

    void recycleUpdateOp(AdapterHelper$UpdateOp adapterHelper$UpdateOp);
}
