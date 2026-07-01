package b.a.q;

import b.d.b.a.outline;
import com.discord.rtcconnection.MediaSinkWantsManager9;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.q.e, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsLadder3 {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f257b;
    public final Map<MediaSinkWantsManager9, MediaSinkWantsLadder6> c;
    public final List<c> d;
    public final MediaSinkWantsLadder5 e;

    /* JADX INFO: renamed from: b.a.q.e$a */
    /* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f258b;
        public final double c;
        public final int d;

        public a(int i, int i2, double d, int i3) {
            this.a = i;
            this.f258b = i2;
            this.c = d;
            this.d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f258b == aVar.f258b && Double.compare(this.c, aVar.c) == 0 && this.d == aVar.d;
        }

        public int hashCode() {
            return ((a0.a.a.a.a(this.c) + (((this.a * 31) + this.f258b) * 31)) * 31) + this.d;
        }

        public String toString() {
            StringBuilder sbU = outline.U("CandidateResolution(width=");
            sbU.append(this.a);
            sbU.append(", height=");
            sbU.append(this.f258b);
            sbU.append(", budgetPortion=");
            sbU.append(this.c);
            sbU.append(", pixelCount=");
            return outline.B(sbU, this.d, ")");
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
        public final MediaSinkWantsLadder6 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f259b;
        public final MediaSinkWantsManager9 c;

        public c(MediaSinkWantsLadder6 mediaSinkWantsLadder6, int i, MediaSinkWantsManager9 mediaSinkWantsManager9) {
            Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder6, "budget");
            Intrinsics3.checkNotNullParameter(mediaSinkWantsManager9, "wantValue");
            this.a = mediaSinkWantsLadder6;
            this.f259b = i;
            this.c = mediaSinkWantsManager9;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics3.areEqual(this.a, cVar.a) && this.f259b == cVar.f259b && Intrinsics3.areEqual(this.c, cVar.c);
        }

        public int hashCode() {
            MediaSinkWantsLadder6 mediaSinkWantsLadder6 = this.a;
            int iHashCode = (((mediaSinkWantsLadder6 != null ? mediaSinkWantsLadder6.hashCode() : 0) * 31) + this.f259b) * 31;
            MediaSinkWantsManager9 mediaSinkWantsManager9 = this.c;
            return iHashCode + (mediaSinkWantsManager9 != null ? mediaSinkWantsManager9.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("OrderedLadder(budget=");
            sbU.append(this.a);
            sbU.append(", pixelCount=");
            sbU.append(this.f259b);
            sbU.append(", wantValue=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    public MediaSinkWantsLadder3(MediaSinkWantsLadder5 mediaSinkWantsLadder5, int i) {
        MediaSinkWantsLadder6 mediaSinkWantsLadder6;
        Object objPrevious;
        MediaSinkWantsManager9 mediaSinkWantsManager9;
        MediaSinkWantsLadder5 mediaSinkWantsLadder7 = (i & 1) != 0 ? MediaSinkWantsLadder4.a : null;
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder7, "options");
        this.e = mediaSinkWantsLadder7;
        MediaSinkWantsLadder2 mediaSinkWantsLadder2 = mediaSinkWantsLadder7.a;
        int i2 = mediaSinkWantsLadder2.a * mediaSinkWantsLadder2.f256b;
        this.f257b = i2;
        Set of = Sets5.setOf((Object[]) new Double[]{Double.valueOf(0.0d), Double.valueOf(4.0d), Double.valueOf(8.0d), Double.valueOf(10.0d)});
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
        MediaSinkWantsManager9 mediaSinkWantsManager10 = MediaSinkWantsManager9.Hundred;
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
            } while (!(((a) objPrevious).d * i4 <= i2));
            a aVar = (a) objPrevious;
            aVar = aVar == null ? (a) _Collections.first((List) arrayList) : aVar;
            if (i5 != aVar.a) {
                linkedHashMap.put(mediaSinkWantsManager10, new MediaSinkWantsLadder6(aVar.a, aVar.f258b, aVar.c, mediaSinkWantsManager10.compareTo(MediaSinkWantsManager9.Twenty) <= 0 ? 12 : 20, 30));
                MediaSinkWantsManager9[] mediaSinkWantsManager9ArrValues = MediaSinkWantsManager9.values();
                int i6 = 10;
                while (true) {
                    if (i6 < 0) {
                        mediaSinkWantsManager9 = null;
                        break;
                    }
                    mediaSinkWantsManager9 = mediaSinkWantsManager9ArrValues[i6];
                    if (mediaSinkWantsManager9.getValue() < mediaSinkWantsManager10.getValue()) {
                        break;
                    } else {
                        i6--;
                    }
                }
                mediaSinkWantsManager10 = mediaSinkWantsManager9 == null ? MediaSinkWantsManager9.Zero : mediaSinkWantsManager9;
                i5 = aVar.a;
            }
            i4++;
            i2 = i2;
        }
        this.c = linkedHashMap;
        MediaSinkWantsManager9[] mediaSinkWantsManager9ArrValues2 = MediaSinkWantsManager9.values();
        ArrayList arrayList2 = new ArrayList(11);
        for (int i7 = 0; i7 < 11; i7++) {
            MediaSinkWantsManager9 mediaSinkWantsManager11 = mediaSinkWantsManager9ArrValues2[i7];
            arrayList2.add((mediaSinkWantsManager11 == MediaSinkWantsManager9.Zero || (mediaSinkWantsLadder6 = (MediaSinkWantsLadder6) linkedHashMap.get(mediaSinkWantsManager11)) == null) ? null : new c(mediaSinkWantsLadder6, mediaSinkWantsLadder6.f274b * mediaSinkWantsLadder6.a, mediaSinkWantsManager11));
        }
        this.d = _Collections.filterNotNull(arrayList2);
    }
}
