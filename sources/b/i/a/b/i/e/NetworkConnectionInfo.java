package b.i.a.b.i.e;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.a.b.i.e.o, reason: use source file name */
/* JADX INFO: compiled from: NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class NetworkConnectionInfo {

    /* JADX INFO: renamed from: b.i.a.b.i.e.o$a */
    /* JADX INFO: compiled from: NetworkConnectionInfo.java */
    public enum a {
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

        public static final SparseArray<a> E;
        private final int value;

        static {
            a aVar = UNKNOWN_MOBILE_SUBTYPE;
            a aVar2 = GPRS;
            a aVar3 = EDGE;
            a aVar4 = UMTS;
            a aVar5 = CDMA;
            a aVar6 = EVDO_0;
            a aVar7 = EVDO_A;
            a aVar8 = RTT;
            a aVar9 = HSDPA;
            a aVar10 = HSUPA;
            a aVar11 = HSPA;
            a aVar12 = IDEN;
            a aVar13 = EVDO_B;
            a aVar14 = LTE;
            a aVar15 = EHRPD;
            a aVar16 = HSPAP;
            a aVar17 = GSM;
            a aVar18 = TD_SCDMA;
            a aVar19 = IWLAN;
            a aVar20 = LTE_CA;
            SparseArray<a> sparseArray = new SparseArray<>();
            E = sparseArray;
            sparseArray.put(0, aVar);
            sparseArray.put(1, aVar2);
            sparseArray.put(2, aVar3);
            sparseArray.put(3, aVar4);
            sparseArray.put(4, aVar5);
            sparseArray.put(5, aVar6);
            sparseArray.put(6, aVar7);
            sparseArray.put(7, aVar8);
            sparseArray.put(8, aVar9);
            sparseArray.put(9, aVar10);
            sparseArray.put(10, aVar11);
            sparseArray.put(11, aVar12);
            sparseArray.put(12, aVar13);
            sparseArray.put(13, aVar14);
            sparseArray.put(14, aVar15);
            sparseArray.put(15, aVar16);
            sparseArray.put(16, aVar17);
            sparseArray.put(17, aVar18);
            sparseArray.put(18, aVar19);
            sparseArray.put(19, aVar20);
        }

        a(int i) {
            this.value = i;
        }

        public int f() {
            return this.value;
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.o$b */
    /* JADX INFO: compiled from: NetworkConnectionInfo.java */
    public enum b {
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

        public static final SparseArray<b> C;
        private final int value;

        static {
            b bVar = MOBILE;
            b bVar2 = WIFI;
            b bVar3 = MOBILE_MMS;
            b bVar4 = MOBILE_SUPL;
            b bVar5 = MOBILE_DUN;
            b bVar6 = MOBILE_HIPRI;
            b bVar7 = WIMAX;
            b bVar8 = BLUETOOTH;
            b bVar9 = DUMMY;
            b bVar10 = ETHERNET;
            b bVar11 = MOBILE_FOTA;
            b bVar12 = MOBILE_IMS;
            b bVar13 = MOBILE_CBS;
            b bVar14 = WIFI_P2P;
            b bVar15 = MOBILE_IA;
            b bVar16 = MOBILE_EMERGENCY;
            b bVar17 = PROXY;
            b bVar18 = VPN;
            b bVar19 = NONE;
            SparseArray<b> sparseArray = new SparseArray<>();
            C = sparseArray;
            sparseArray.put(0, bVar);
            sparseArray.put(1, bVar2);
            sparseArray.put(2, bVar3);
            sparseArray.put(3, bVar4);
            sparseArray.put(4, bVar5);
            sparseArray.put(5, bVar6);
            sparseArray.put(6, bVar7);
            sparseArray.put(7, bVar8);
            sparseArray.put(8, bVar9);
            sparseArray.put(9, bVar10);
            sparseArray.put(10, bVar11);
            sparseArray.put(11, bVar12);
            sparseArray.put(12, bVar13);
            sparseArray.put(13, bVar14);
            sparseArray.put(14, bVar15);
            sparseArray.put(15, bVar16);
            sparseArray.put(16, bVar17);
            sparseArray.put(17, bVar18);
            sparseArray.put(-1, bVar19);
        }

        b(int i) {
            this.value = i;
        }

        public int f() {
            return this.value;
        }
    }

    @Nullable
    public abstract a a();

    @Nullable
    public abstract b b();
}
