package b.c.a.a0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import b.c.a.a0.i0.JsonReader2;
import b.d.b.a.outline;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.a0.p, reason: use source file name */
/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class JsonUtils {
    public static final JsonReader2.a a = JsonReader2.a.a("x", "y");

    @ColorInt
    public static int a(JsonReader2 jsonReader2) throws IOException {
        jsonReader2.a();
        int iN = (int) (jsonReader2.n() * 255.0d);
        int iN2 = (int) (jsonReader2.n() * 255.0d);
        int iN3 = (int) (jsonReader2.n() * 255.0d);
        while (jsonReader2.e()) {
            jsonReader2.C();
        }
        jsonReader2.c();
        return Color.argb(255, iN, iN2, iN3);
    }

    public static PointF b(JsonReader2 jsonReader2, float f) throws IOException {
        int iOrdinal = jsonReader2.u().ordinal();
        if (iOrdinal == 0) {
            jsonReader2.a();
            float fN = (float) jsonReader2.n();
            float fN2 = (float) jsonReader2.n();
            while (jsonReader2.u() != JsonReader2.b.END_ARRAY) {
                jsonReader2.C();
            }
            jsonReader2.c();
            return new PointF(fN * f, fN2 * f);
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 6) {
                StringBuilder sbU = outline.U("Unknown point starts with ");
                sbU.append(jsonReader2.u());
                throw new IllegalArgumentException(sbU.toString());
            }
            float fN3 = (float) jsonReader2.n();
            float fN4 = (float) jsonReader2.n();
            while (jsonReader2.e()) {
                jsonReader2.C();
            }
            return new PointF(fN3 * f, fN4 * f);
        }
        jsonReader2.b();
        float fD = 0.0f;
        float fD2 = 0.0f;
        while (jsonReader2.e()) {
            int iY = jsonReader2.y(a);
            if (iY == 0) {
                fD = d(jsonReader2);
            } else if (iY != 1) {
                jsonReader2.A();
                jsonReader2.C();
            } else {
                fD2 = d(jsonReader2);
            }
        }
        jsonReader2.d();
        return new PointF(fD * f, fD2 * f);
    }

    public static List<PointF> c(JsonReader2 jsonReader2, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader2.a();
        while (jsonReader2.u() == JsonReader2.b.BEGIN_ARRAY) {
            jsonReader2.a();
            arrayList.add(b(jsonReader2, f));
            jsonReader2.c();
        }
        jsonReader2.c();
        return arrayList;
    }

    public static float d(JsonReader2 jsonReader2) throws IOException {
        JsonReader2.b bVarU = jsonReader2.u();
        int iOrdinal = bVarU.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 6) {
                return (float) jsonReader2.n();
            }
            throw new IllegalArgumentException("Unknown value for token of type " + bVarU);
        }
        jsonReader2.a();
        float fN = (float) jsonReader2.n();
        while (jsonReader2.e()) {
            jsonReader2.C();
        }
        jsonReader2.c();
        return fN;
    }
}
