package androidx.constraintlayout.solver.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f31x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f32y;

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f31x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f32y) && i2 < i3 + this.height;
    }

    public int getCenterX() {
        return (this.f31x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f32y + this.height) / 2;
    }

    public void grow(int i, int i2) {
        this.f31x -= i;
        this.f32y -= i2;
        this.width = (i * 2) + this.width;
        this.height = (i2 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i3 = this.f31x;
        int i4 = rectangle.f31x;
        return i3 >= i4 && i3 < i4 + rectangle.width && (i = this.f32y) >= (i2 = rectangle.f32y) && i < i2 + rectangle.height;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f31x = i;
        this.f32y = i2;
        this.width = i3;
        this.height = i4;
    }
}
