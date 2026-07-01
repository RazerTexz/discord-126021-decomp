package b.i.c.m.d.m.x;

import android.util.JsonReader;
import b.i.c.m.d.m.p;
import b.i.c.m.d.m.w;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements h$a {
    public static final d a = new d();

    @Override // b.i.c.m.d.m.x.h$a
    public Object a(JsonReader jsonReader) throws IOException {
        b.i.c.p.a aVar = h.a;
        jsonReader.beginObject();
        String strNextString = null;
        Integer numValueOf = null;
        w wVarA = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    wVarA = h.a(jsonReader, g.a);
                    break;
                case "name":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null name");
                    break;
                case "importance":
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strW = strNextString == null ? " name" : "";
        if (numValueOf == null) {
            strW = b.d.b.a.a.w(strW, " importance");
        }
        if (wVarA == null) {
            strW = b.d.b.a.a.w(strW, " frames");
        }
        if (strW.isEmpty()) {
            return new p(strNextString, numValueOf.intValue(), wVarA, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }
}
