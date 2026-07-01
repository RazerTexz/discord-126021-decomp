package b.i.c.m.d.m.x;

import android.util.Base64;
import android.util.JsonReader;
import b.i.c.m.d.m.m;
import b.i.c.m.d.m.v;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements h$a {
    public static final e a = new e();

    @Override // b.i.c.m.d.m.x.h$a
    public Object a(JsonReader jsonReader) throws IOException {
        b.i.c.p.a aVar = h.a;
        jsonReader.beginObject();
        Long lValueOf = null;
        Long lValueOf2 = null;
        String strNextString = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "name":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null name");
                    break;
                case "size":
                    lValueOf2 = Long.valueOf(jsonReader.nextLong());
                    break;
                case "uuid":
                    str = new String(Base64.decode(jsonReader.nextString(), 2), v.a);
                    break;
                case "baseAddress":
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strW = lValueOf == null ? " baseAddress" : "";
        if (lValueOf2 == null) {
            strW = b.d.b.a.a.w(strW, " size");
        }
        if (strNextString == null) {
            strW = b.d.b.a.a.w(strW, " name");
        }
        if (strW.isEmpty()) {
            return new m(lValueOf.longValue(), lValueOf2.longValue(), strNextString, str, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }
}
