package p507d0.p579g0;

/* JADX INFO: renamed from: d0.g0.i */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC12092i {
    IGNORE_CASE(2, 0, 2),
    MULTILINE(8, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    LITERAL(16, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    UNIX_LINES(1, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    COMMENTS(4, 0, 2),
    DOT_MATCHES_ALL(32, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    CANON_EQ(128, 0, 2);

    private final int mask;
    private final int value;

    EnumC12092i(int i, int i2, int i3) {
        i2 = (i3 & 2) != 0 ? i : i2;
        this.value = i;
        this.mask = i2;
    }

    public int getValue() {
        return this.value;
    }
}
