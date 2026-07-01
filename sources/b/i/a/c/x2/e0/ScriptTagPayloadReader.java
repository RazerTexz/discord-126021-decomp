package b.i.a.c.x2.e0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.d, reason: use source file name */
/* JADX INFO: compiled from: ScriptTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScriptTagPayloadReader extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1173b;
    public long[] c;
    public long[] d;

    public ScriptTagPayloadReader() {
        super(new DummyTrackOutput());
        this.f1173b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    @Nullable
    public static Object d(ParsableByteArray parsableByteArray, int i) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(parsableByteArray.m()));
        }
        if (i == 1) {
            return Boolean.valueOf(parsableByteArray.t() == 1);
        }
        if (i == 2) {
            return f(parsableByteArray);
        }
        if (i != 3) {
            if (i == 8) {
                return e(parsableByteArray);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(parsableByteArray.m())).doubleValue());
                parsableByteArray.F(2);
                return date;
            }
            int iW = parsableByteArray.w();
            ArrayList arrayList = new ArrayList(iW);
            for (int i2 = 0; i2 < iW; i2++) {
                Object objD = d(parsableByteArray, parsableByteArray.t());
                if (objD != null) {
                    arrayList.add(objD);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strF = f(parsableByteArray);
            int iT = parsableByteArray.t();
            if (iT == 9) {
                return map;
            }
            Object objD2 = d(parsableByteArray, iT);
            if (objD2 != null) {
                map.put(strF, objD2);
            }
        }
    }

    public static HashMap<String, Object> e(ParsableByteArray parsableByteArray) {
        int iW = parsableByteArray.w();
        HashMap<String, Object> map = new HashMap<>(iW);
        for (int i = 0; i < iW; i++) {
            String strF = f(parsableByteArray);
            Object objD = d(parsableByteArray, parsableByteArray.t());
            if (objD != null) {
                map.put(strF, objD);
            }
        }
        return map;
    }

    public static String f(ParsableByteArray parsableByteArray) {
        int iY = parsableByteArray.y();
        int i = parsableByteArray.f984b;
        parsableByteArray.F(iY);
        return new String(parsableByteArray.a, i, iY);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j) {
        if (parsableByteArray.t() != 2 || !"onMetaData".equals(f(parsableByteArray)) || parsableByteArray.t() != 8) {
            return false;
        }
        HashMap<String, Object> mapE = e(parsableByteArray);
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
