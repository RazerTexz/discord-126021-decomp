package b.i.c.m.d.m.x;

import android.util.Base64;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements h$a {
    public static final b a = new b();

    @Override // b.i.c.m.d.m.x.h$a
    public Object a(JsonReader jsonReader) throws IOException {
        b.i.c.p.a aVar = h.a;
        jsonReader.beginObject();
        String strNextString = null;
        byte[] bArrDecode = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("filename")) {
                strNextString = jsonReader.nextString();
                Objects.requireNonNull(strNextString, "Null filename");
            } else if (strNextName.equals("contents")) {
                bArrDecode = Base64.decode(jsonReader.nextString(), 2);
                Objects.requireNonNull(bArrDecode, "Null contents");
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        String strW = strNextString == null ? " filename" : "";
        if (bArrDecode == null) {
            strW = b.d.b.a.a.w(strW, " contents");
        }
        if (strW.isEmpty()) {
            return new b.i.c.m.d.m.e(strNextString, bArrDecode, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }
}
