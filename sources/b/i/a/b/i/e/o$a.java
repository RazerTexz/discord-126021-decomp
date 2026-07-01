package b.i.a.b.i.e;

import android.util.SparseArray;

/* JADX INFO: compiled from: NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public enum o$a {
    UNKNOWN_MOBILE_SUBTYPE(0),
    GPRS(1),
    EDGE(2),
    UMTS(3),
    CDMA(4),
    EVDO_0(5),
    EVDO_A(6),
    RTT(7),
    HSDPA(8),
    HSUPA(9),
    HSPA(10),
    IDEN(11),
    EVDO_B(12),
    LTE(13),
    EHRPD(14),
    HSPAP(15),
    GSM(16),
    TD_SCDMA(17),
    IWLAN(18),
    LTE_CA(19),
    COMBINED(100);

    public static final SparseArray<o$a> E;
    private final int value;

    static {
        o$a o_a = UNKNOWN_MOBILE_SUBTYPE;
        o$a o_a2 = GPRS;
        o$a o_a3 = EDGE;
        o$a o_a4 = UMTS;
        o$a o_a5 = CDMA;
        o$a o_a6 = EVDO_0;
        o$a o_a7 = EVDO_A;
        o$a o_a8 = RTT;
        o$a o_a9 = HSDPA;
        o$a o_a10 = HSUPA;
        o$a o_a11 = HSPA;
        o$a o_a12 = IDEN;
        o$a o_a13 = EVDO_B;
        o$a o_a14 = LTE;
        o$a o_a15 = EHRPD;
        o$a o_a16 = HSPAP;
        o$a o_a17 = GSM;
        o$a o_a18 = TD_SCDMA;
        o$a o_a19 = IWLAN;
        o$a o_a20 = LTE_CA;
        SparseArray<o$a> sparseArray = new SparseArray<>();
        E = sparseArray;
        sparseArray.put(0, o_a);
        sparseArray.put(1, o_a2);
        sparseArray.put(2, o_a3);
        sparseArray.put(3, o_a4);
        sparseArray.put(4, o_a5);
        sparseArray.put(5, o_a6);
        sparseArray.put(6, o_a7);
        sparseArray.put(7, o_a8);
        sparseArray.put(8, o_a9);
        sparseArray.put(9, o_a10);
        sparseArray.put(10, o_a11);
        sparseArray.put(11, o_a12);
        sparseArray.put(12, o_a13);
        sparseArray.put(13, o_a14);
        sparseArray.put(14, o_a15);
        sparseArray.put(15, o_a16);
        sparseArray.put(16, o_a17);
        sparseArray.put(17, o_a18);
        sparseArray.put(18, o_a19);
        sparseArray.put(19, o_a20);
    }

    o$a(int i) {
        this.value = i;
    }

    public int f() {
        return this.value;
    }
}
