package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil$Range {
    public int newListEnd;
    public int newListStart;
    public int oldListEnd;
    public int oldListStart;

    public DiffUtil$Range() {
    }

    public int newSize() {
        return this.newListEnd - this.newListStart;
    }

    public int oldSize() {
        return this.oldListEnd - this.oldListStart;
    }

    public DiffUtil$Range(int i, int i2, int i3, int i4) {
        this.oldListStart = i;
        this.oldListEnd = i2;
        this.newListStart = i3;
        this.newListEnd = i4;
    }
}
