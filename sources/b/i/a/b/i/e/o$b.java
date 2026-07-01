package b.i.a.b.i.e;

import android.util.SparseArray;

/* JADX INFO: compiled from: NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public enum o$b {
    MOBILE(0),
    WIFI(1),
    MOBILE_MMS(2),
    MOBILE_SUPL(3),
    MOBILE_DUN(4),
    MOBILE_HIPRI(5),
    WIMAX(6),
    BLUETOOTH(7),
    DUMMY(8),
    ETHERNET(9),
    MOBILE_FOTA(10),
    MOBILE_IMS(11),
    MOBILE_CBS(12),
    WIFI_P2P(13),
    MOBILE_IA(14),
    MOBILE_EMERGENCY(15),
    PROXY(16),
    VPN(17),
    NONE(-1);

    public static final SparseArray<o$b> C;
    private final int value;

    static {
        o$b o_b = MOBILE;
        o$b o_b2 = WIFI;
        o$b o_b3 = MOBILE_MMS;
        o$b o_b4 = MOBILE_SUPL;
        o$b o_b5 = MOBILE_DUN;
        o$b o_b6 = MOBILE_HIPRI;
        o$b o_b7 = WIMAX;
        o$b o_b8 = BLUETOOTH;
        o$b o_b9 = DUMMY;
        o$b o_b10 = ETHERNET;
        o$b o_b11 = MOBILE_FOTA;
        o$b o_b12 = MOBILE_IMS;
        o$b o_b13 = MOBILE_CBS;
        o$b o_b14 = WIFI_P2P;
        o$b o_b15 = MOBILE_IA;
        o$b o_b16 = MOBILE_EMERGENCY;
        o$b o_b17 = PROXY;
        o$b o_b18 = VPN;
        o$b o_b19 = NONE;
        SparseArray<o$b> sparseArray = new SparseArray<>();
        C = sparseArray;
        sparseArray.put(0, o_b);
        sparseArray.put(1, o_b2);
        sparseArray.put(2, o_b3);
        sparseArray.put(3, o_b4);
        sparseArray.put(4, o_b5);
        sparseArray.put(5, o_b6);
        sparseArray.put(6, o_b7);
        sparseArray.put(7, o_b8);
        sparseArray.put(8, o_b9);
        sparseArray.put(9, o_b10);
        sparseArray.put(10, o_b11);
        sparseArray.put(11, o_b12);
        sparseArray.put(12, o_b13);
        sparseArray.put(13, o_b14);
        sparseArray.put(14, o_b15);
        sparseArray.put(15, o_b16);
        sparseArray.put(16, o_b17);
        sparseArray.put(17, o_b18);
        sparseArray.put(-1, o_b19);
    }

    o$b(int i) {
        this.value = i;
    }

    public int f() {
        return this.value;
    }
}
