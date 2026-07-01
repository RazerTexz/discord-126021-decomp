package b.c.a.y.l;

/* JADX INFO: compiled from: PolystarShape.java */
/* JADX INFO: loaded from: classes.dex */
public enum h$a {
    STAR(1),
    POLYGON(2);

    private final int value;

    h$a(int i) {
        this.value = i;
    }

    public static h$a f(int i) {
        h$a[] h_aArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            h$a h_a = h_aArrValues[i2];
            if (h_a.value == i) {
                return h_a;
            }
        }
        return null;
    }
}
