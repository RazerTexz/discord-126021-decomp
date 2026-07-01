package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil$Diagonal {
    public final int size;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f36x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f37y;

    public DiffUtil$Diagonal(int i, int i2, int i3) {
        this.f36x = i;
        this.f37y = i2;
        this.size = i3;
    }

    public int endX() {
        return this.f36x + this.size;
    }

    public int endY() {
        return this.f37y + this.size;
    }
}
