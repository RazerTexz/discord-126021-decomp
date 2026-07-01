package b.i.a.c.x2.e0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.x;
import b.i.a.c.x2.g;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ScriptTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1173b;
    public long[] c;
    public long[] d;

    public d() {
        super(new g());
        this.f1173b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    @Nullable
    public static Object d(x xVar, int i) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(xVar.m()));
        }
        if (i == 1) {
            return Boolean.valueOf(xVar.t() == 1);
        }
        if (i == 2) {
            return f(xVar);
        }
        if (i != 3) {
            if (i == 8) {
                return e(xVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(xVar.m())).doubleValue());
                xVar.F(2);
                return date;
            }
            int iW = xVar.w();
            ArrayList arrayList = new ArrayList(iW);
            for (int i2 = 0; i2 < iW; i2++) {
                Object objD = d(xVar, xVar.t());
                if (objD != null) {
                    arrayList.add(objD);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strF = f(xVar);
            int iT = xVar.t();
            if (iT == 9) {
                return map;
            }
            Object objD2 = d(xVar, iT);
            if (objD2 != null) {
                map.put(strF, objD2);
            }
        }
    }

    public static HashMap<String, Object> e(x xVar) {
        int iW = xVar.w();
        HashMap<String, Object> map = new HashMap<>(iW);
        for (int i = 0; i < iW; i++) {
            String strF = f(xVar);
            Object objD = d(xVar, xVar.t());
            if (objD != null) {
                map.put(strF, objD);
            }
        }
        return map;
    }

    public static String f(x xVar) {
        int iY = xVar.y();
        int i = xVar.f984b;
        xVar.F(iY);
        return new String(xVar.a, i, iY);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(x xVar) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(x xVar, long j) {
        if (xVar.t() != 2 || !"onMetaData".equals(f(xVar)) || xVar.t() != 8) {
            return false;
        }
        HashMap<String, Object> mapE = e(xVar);
        Object obj = mapE.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f1173b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapE.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                    this.c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }
}
