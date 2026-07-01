package b.c.a.a0;

import b.c.a.a0.i0.JsonReader2;
import java.io.IOException;

/* JADX INFO: renamed from: b.c.a.a0.i, reason: use source file name */
/* JADX INFO: compiled from: FloatParser.java */
/* JADX INFO: loaded from: classes.dex */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser a = new FloatParser();

    @Override // b.c.a.a0.ValueParser
    public Float a(JsonReader2 jsonReader2, float f) throws IOException {
        return Float.valueOf(JsonUtils.d(jsonReader2) * f);
    }
}
