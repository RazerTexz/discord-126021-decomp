package b.c.a.a0;

import b.c.a.a0.i0.JsonReader2;
import b.c.a.c0.ScaleXY;
import java.io.IOException;

/* JADX INFO: renamed from: b.c.a.a0.a0, reason: use source file name */
/* JADX INFO: compiled from: ScaleXYParser.java */
/* JADX INFO: loaded from: classes.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {
    public static final ScaleXYParser a = new ScaleXYParser();

    @Override // b.c.a.a0.ValueParser
    public ScaleXY a(JsonReader2 jsonReader2, float f) throws IOException {
        boolean z2 = jsonReader2.u() == JsonReader2.b.BEGIN_ARRAY;
        if (z2) {
            jsonReader2.a();
        }
        float fN = (float) jsonReader2.n();
        float fN2 = (float) jsonReader2.n();
        while (jsonReader2.e()) {
            jsonReader2.C();
        }
        if (z2) {
            jsonReader2.c();
        }
        return new ScaleXY((fN / 100.0f) * f, (fN2 / 100.0f) * f);
    }
}
