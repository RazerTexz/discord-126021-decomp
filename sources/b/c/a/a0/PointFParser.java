package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.a0.i0.JsonReader2;
import java.io.IOException;

/* JADX INFO: renamed from: b.c.a.a0.w, reason: use source file name */
/* JADX INFO: compiled from: PointFParser.java */
/* JADX INFO: loaded from: classes.dex */
public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser a = new PointFParser();

    @Override // b.c.a.a0.ValueParser
    public PointF a(JsonReader2 jsonReader2, float f) throws IOException {
        JsonReader2.b bVarU = jsonReader2.u();
        if (bVarU == JsonReader2.b.BEGIN_ARRAY) {
            return JsonUtils.b(jsonReader2, f);
        }
        if (bVarU == JsonReader2.b.BEGIN_OBJECT) {
            return JsonUtils.b(jsonReader2, f);
        }
        if (bVarU == JsonReader2.b.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader2.n()) * f, ((float) jsonReader2.n()) * f);
            while (jsonReader2.e()) {
                jsonReader2.C();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarU);
    }
}
