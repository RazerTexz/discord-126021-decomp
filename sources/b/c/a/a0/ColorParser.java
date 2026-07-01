package b.c.a.a0;

import android.graphics.Color;
import b.c.a.a0.i0.JsonReader2;
import java.io.IOException;

/* JADX INFO: renamed from: b.c.a.a0.f, reason: use source file name */
/* JADX INFO: compiled from: ColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class ColorParser implements ValueParser<Integer> {
    public static final ColorParser a = new ColorParser();

    @Override // b.c.a.a0.ValueParser
    public Integer a(JsonReader2 jsonReader2, float f) throws IOException {
        boolean z2 = jsonReader2.u() == JsonReader2.b.BEGIN_ARRAY;
        if (z2) {
            jsonReader2.a();
        }
        double dN = jsonReader2.n();
        double dN2 = jsonReader2.n();
        double dN3 = jsonReader2.n();
        double dN4 = jsonReader2.n();
        if (z2) {
            jsonReader2.c();
        }
        if (dN <= 1.0d && dN2 <= 1.0d && dN3 <= 1.0d) {
            dN *= 255.0d;
            dN2 *= 255.0d;
            dN3 *= 255.0d;
            if (dN4 <= 1.0d) {
                dN4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dN4, (int) dN, (int) dN2, (int) dN3));
    }
}
