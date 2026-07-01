package b.i.c.r;

/* JADX INFO: compiled from: HeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public enum d$a {
    NONE(0),
    SDK(1),
    GLOBAL(2),
    COMBINED(3);

    private final int code;

    d$a(int i) {
        this.code = i;
    }

    public int f() {
        return this.code;
    }
}
