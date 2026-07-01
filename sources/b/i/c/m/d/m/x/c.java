package b.i.c.m.d.m.x;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements h$a {
    public static final c a = new c();

    @Override // b.i.c.m.d.m.x.h$a
    public Object a(JsonReader jsonReader) throws IOException {
        b.i.c.p.a aVar = h.a;
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("key")) {
                strNextString = jsonReader.nextString();
                Objects.requireNonNull(strNextString, "Null key");
            } else if (strNextName.equals("value")) {
                strNextString2 = jsonReader.nextString();
                Objects.requireNonNull(strNextString2, "Null value");
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        String strW = strNextString == null ? " key" : "";
        if (strNextString2 == null) {
            strW = b.d.b.a.a.w(strW, " value");
        }
        if (strW.isEmpty()) {
            return new b.i.c.m.d.m.c(strNextString, strNextString2, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }
}
