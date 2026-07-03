package p007b.p008a.p041q;

import com.discord.rtcconnection.EncodeQuality;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0001a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.e */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1196e {

    /* JADX INFO: renamed from: a */
    public static final b f1613a = new b(null);

    /* JADX INFO: renamed from: b */
    public final int f1614b;

    /* JADX INFO: renamed from: c */
    public final Map<EncodeQuality, C1244n> f1615c;

    /* JADX INFO: renamed from: d */
    public final List<c> f1616d;

    /* JADX INFO: renamed from: e */
    public final C1207j0 f1617e;

    /* JADX INFO: renamed from: b.a.q.e$a */
    /* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f1618a;

        /* JADX INFO: renamed from: b */
        public final int f1619b;

        /* JADX INFO: renamed from: c */
        public final double f1620c;

        /* JADX INFO: renamed from: d */
        public final int f1621d;

        public a(int i, int i2, double d, int i3) {
            this.f1618a = i;
            this.f1619b = i2;
            this.f1620c = d;
            this.f1621d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1618a == aVar.f1618a && this.f1619b == aVar.f1619b && Double.compare(this.f1620c, aVar.f1620c) == 0 && this.f1621d == aVar.f1621d;
        }

        public int hashCode() {
            return ((C0001a.m2a(this.f1620c) + (((this.f1618a * 31) + this.f1619b) * 31)) * 31) + this.f1621d;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CandidateResolution(width=");
            sbM833U.append(this.f1618a);
            sbM833U.append(", height=");
            sbM833U.append(this.f1619b);
            sbM833U.append(", budgetPortion=");
            sbM833U.append(this.f1620c);
            sbM833U.append(", pixelCount=");
            return C1643a.m814B(sbM833U, this.f1621d, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.q.e$b */
    /* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.q.e$c */
    /* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final C1244n f1622a;

        /* JADX INFO: renamed from: b */
        public final int f1623b;

        /* JADX INFO: renamed from: c */
        public final EncodeQuality f1624c;

        public c(C1244n c1244n, int i, EncodeQuality encodeQuality) {
            C12238m.checkNotNullParameter(c1244n, "budget");
            C12238m.checkNotNullParameter(encodeQuality, "wantValue");
            this.f1622a = c1244n;
            this.f1623b = i;
            this.f1624c = encodeQuality;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return C12238m.areEqual(this.f1622a, cVar.f1622a) && this.f1623b == cVar.f1623b && C12238m.areEqual(this.f1624c, cVar.f1624c);
        }

        public int hashCode() {
            C1244n c1244n = this.f1622a;
            int iHashCode = (((c1244n != null ? c1244n.hashCode() : 0) * 31) + this.f1623b) * 31;
            EncodeQuality encodeQuality = this.f1624c;
            return iHashCode + (encodeQuality != null ? encodeQuality.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("OrderedLadder(budget=");
            sbM833U.append(this.f1622a);
            sbM833U.append(", pixelCount=");
            sbM833U.append(this.f1623b);
            sbM833U.append(", wantValue=");
            sbM833U.append(this.f1624c);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    public C1196e(C1207j0 c1207j0, int i) {
        C1244n c1244n;
        Object objPrevious;
        EncodeQuality encodeQuality;
        C1207j0 c1207j1 = (i & 1) != 0 ? C1198f.f1625a : null;
        C12238m.checkNotNullParameter(c1207j1, "options");
        this.f1617e = c1207j1;
        C1190b c1190b = c1207j1.f1635a;
        int i2 = c1190b.f1602a * c1190b.f1603b;
        this.f1614b = i2;
        Set of = C12148n0.setOf((Object[]) new Double[]{Double.valueOf(0.0d), Double.valueOf(4.0d), Double.valueOf(8.0d), Double.valueOf(10.0d)});
        ArrayList arrayList = new ArrayList();
        for (int i3 = 1; i3 < 4096; i3++) {
            double d = i3;
            double d2 = (d * 16.0d) / 9.0d;
            if (of.contains(Double.valueOf(d2 % 16.0d)) && of.contains(Double.valueOf(d % 16.0d))) {
                double d3 = d * d2;
                arrayList.add(new a((int) d2, i3, d3 / ((double) i2), (int) d3));
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        EncodeQuality encodeQuality2 = EncodeQuality.Hundred;
        int i4 = 1;
        int i5 = 0;
        while (i4 <= 25) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!(((a) objPrevious).f1621d * i4 <= i2));
            a aVar = (a) objPrevious;
            aVar = aVar == null ? (a) C12163u.first((List) arrayList) : aVar;
            if (i5 != aVar.f1618a) {
                linkedHashMap.put(encodeQuality2, new C1244n(aVar.f1618a, aVar.f1619b, aVar.f1620c, encodeQuality2.compareTo(EncodeQuality.Twenty) <= 0 ? 12 : 20, 30));
                EncodeQuality[] encodeQualityArrValues = EncodeQuality.values();
                int i6 = 10;
                while (true) {
                    if (i6 < 0) {
                        encodeQuality = null;
                        break;
                    }
                    encodeQuality = encodeQualityArrValues[i6];
                    if (encodeQuality.getValue() < encodeQuality2.getValue()) {
                        break;
                    } else {
                        i6--;
                    }
                }
                encodeQuality2 = encodeQuality == null ? EncodeQuality.Zero : encodeQuality;
                i5 = aVar.f1618a;
            }
            i4++;
            i2 = i2;
        }
        this.f1615c = linkedHashMap;
        EncodeQuality[] encodeQualityArrValues2 = EncodeQuality.values();
        ArrayList arrayList2 = new ArrayList(11);
        for (int i7 = 0; i7 < 11; i7++) {
            EncodeQuality encodeQuality3 = encodeQualityArrValues2[i7];
            arrayList2.add((encodeQuality3 == EncodeQuality.Zero || (c1244n = (C1244n) linkedHashMap.get(encodeQuality3)) == null) ? null : new c(c1244n, c1244n.f1759b * c1244n.f1758a, encodeQuality3));
        }
        this.f1616d = C12163u.filterNotNull(arrayList2);
    }
}
