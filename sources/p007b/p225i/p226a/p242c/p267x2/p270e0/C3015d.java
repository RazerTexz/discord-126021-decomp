package p007b.p225i.p226a.p242c.p267x2.p270e0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3023g;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.d */
/* JADX INFO: compiled from: ScriptTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3015d extends TagPayloadReader {

    /* JADX INFO: renamed from: b */
    public long f8142b;

    /* JADX INFO: renamed from: c */
    public long[] f8143c;

    /* JADX INFO: renamed from: d */
    public long[] f8144d;

    public C3015d() {
        super(new C3023g());
        this.f8142b = -9223372036854775807L;
        this.f8143c = new long[0];
        this.f8144d = new long[0];
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public static Object m3661d(C2757x c2757x, int i) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(c2757x.m3093m()));
        }
        if (i == 1) {
            return Boolean.valueOf(c2757x.m3100t() == 1);
        }
        if (i == 2) {
            return m3663f(c2757x);
        }
        if (i != 3) {
            if (i == 8) {
                return m3662e(c2757x);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(c2757x.m3093m())).doubleValue());
                c2757x.m3080F(2);
                return date;
            }
            int iM3103w = c2757x.m3103w();
            ArrayList arrayList = new ArrayList(iM3103w);
            for (int i2 = 0; i2 < iM3103w; i2++) {
                Object objM3661d = m3661d(c2757x, c2757x.m3100t());
                if (objM3661d != null) {
                    arrayList.add(objM3661d);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strM3663f = m3663f(c2757x);
            int iM3100t = c2757x.m3100t();
            if (iM3100t == 9) {
                return map;
            }
            Object objM3661d2 = m3661d(c2757x, iM3100t);
            if (objM3661d2 != null) {
                map.put(strM3663f, objM3661d2);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static HashMap<String, Object> m3662e(C2757x c2757x) {
        int iM3103w = c2757x.m3103w();
        HashMap<String, Object> map = new HashMap<>(iM3103w);
        for (int i = 0; i < iM3103w; i++) {
            String strM3663f = m3663f(c2757x);
            Object objM3661d = m3661d(c2757x, c2757x.m3100t());
            if (objM3661d != null) {
                map.put(strM3663f, objM3661d);
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: f */
    public static String m3663f(C2757x c2757x) {
        int iM3105y = c2757x.m3105y();
        int i = c2757x.f6794b;
        c2757x.m3080F(iM3105y);
        return new String(c2757x.f6793a, i, iM3105y);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: b */
    public boolean mo3657b(C2757x c2757x) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: c */
    public boolean mo3658c(C2757x c2757x, long j) {
        if (c2757x.m3100t() != 2 || !"onMetaData".equals(m3663f(c2757x)) || c2757x.m3100t() != 8) {
            return false;
        }
        HashMap<String, Object> mapM3662e = m3662e(c2757x);
        Object obj = mapM3662e.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f8142b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapM3662e.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f8143c = new long[size];
                this.f8144d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f8143c = new long[0];
                        this.f8144d = new long[0];
                        break;
                    }
                    this.f8143c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f8144d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }
}
