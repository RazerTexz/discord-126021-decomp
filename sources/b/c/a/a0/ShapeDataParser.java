package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.MiscUtils;
import b.c.a.y.CubicCurveData;
import b.c.a.y.l.ShapeData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.a0.b0, reason: use source file name */
/* JADX INFO: compiled from: ShapeDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser a = new ShapeDataParser();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader2.a f327b = JsonReader2.a.a("c", "v", "i", "o");

    @Override // b.c.a.a0.ValueParser
    public ShapeData a(JsonReader2 jsonReader2, float f) throws IOException {
        if (jsonReader2.u() == JsonReader2.b.BEGIN_ARRAY) {
            jsonReader2.a();
        }
        jsonReader2.b();
        List<PointF> listC = null;
        List<PointF> listC2 = null;
        List<PointF> listC3 = null;
        boolean zF = false;
        while (jsonReader2.e()) {
            int iY = jsonReader2.y(f327b);
            if (iY == 0) {
                zF = jsonReader2.f();
            } else if (iY == 1) {
                listC = JsonUtils.c(jsonReader2, f);
            } else if (iY == 2) {
                listC2 = JsonUtils.c(jsonReader2, f);
            } else if (iY != 3) {
                jsonReader2.A();
                jsonReader2.C();
            } else {
                listC3 = JsonUtils.c(jsonReader2, f);
            }
        }
        jsonReader2.d();
        if (jsonReader2.u() == JsonReader2.b.END_ARRAY) {
            jsonReader2.c();
        }
        if (listC == null || listC2 == null || listC3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listC.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        }
        int size = listC.size();
        PointF pointF = listC.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listC.get(i);
            int i2 = i - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a(listC.get(i2), listC3.get(i2)), MiscUtils.a(pointF2, listC2.get(i)), pointF2));
        }
        if (zF) {
            PointF pointF3 = listC.get(0);
            int i3 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a(listC.get(i3), listC3.get(i3)), MiscUtils.a(pointF3, listC2.get(0)), pointF3));
        }
        return new ShapeData(pointF, zF, arrayList);
    }
}
