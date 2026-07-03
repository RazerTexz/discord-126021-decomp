package androidx.constraintlayout.solver.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x */
    public int f119x;

    /* JADX INFO: renamed from: y */
    public int f120y;

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f119x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f120y) && i2 < i3 + this.height;
    }

    public int getCenterX() {
        return (this.f119x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f120y + this.height) / 2;
    }

    public void grow(int i, int i2) {
        this.f119x -= i;
        this.f120y -= i2;
        this.width = (i * 2) + this.width;
        this.height = (i2 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i3 = this.f119x;
        int i4 = rectangle.f119x;
        return i3 >= i4 && i3 < i4 + rectangle.width && (i = this.f120y) >= (i2 = rectangle.f120y) && i < i2 + rectangle.height;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f119x = i;
        this.f120y = i2;
        this.width = i3;
        this.height = i4;
    }
}
