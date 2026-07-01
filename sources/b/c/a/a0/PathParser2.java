package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.a0.i0.JsonReader2;
import java.io.IOException;

/* JADX INFO: renamed from: b.c.a.a0.v, reason: use source file name */
/* JADX INFO: compiled from: PathParser.java */
/* JADX INFO: loaded from: classes.dex */
public class PathParser2 implements ValueParser<PointF> {
    public static final PathParser2 a = new PathParser2();

    @Override // b.c.a.a0.ValueParser
    public PointF a(JsonReader2 jsonReader2, float f) throws IOException {
        return JsonUtils.b(jsonReader2, f);
    }
}
