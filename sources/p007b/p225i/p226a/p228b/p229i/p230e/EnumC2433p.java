package p007b.p225i.p226a.p228b.p229i.p230e;

import android.util.SparseArray;

/* JADX INFO: renamed from: b.i.a.b.i.e.p */
/* JADX INFO: compiled from: QosTier.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2433p {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: p */
    public static final SparseArray<EnumC2433p> f5244p;
    private final int value;

    static {
        EnumC2433p enumC2433p = DEFAULT;
        EnumC2433p enumC2433p2 = UNMETERED_ONLY;
        EnumC2433p enumC2433p3 = UNMETERED_OR_DAILY;
        EnumC2433p enumC2433p4 = FAST_IF_RADIO_AWAKE;
        EnumC2433p enumC2433p5 = NEVER;
        EnumC2433p enumC2433p6 = UNRECOGNIZED;
        SparseArray<EnumC2433p> sparseArray = new SparseArray<>();
        f5244p = sparseArray;
        sparseArray.put(0, enumC2433p);
        sparseArray.put(1, enumC2433p2);
        sparseArray.put(2, enumC2433p3);
        sparseArray.put(3, enumC2433p4);
        sparseArray.put(4, enumC2433p5);
        sparseArray.put(-1, enumC2433p6);
    }

    EnumC2433p(int i) {
        this.value = i;
    }
}
