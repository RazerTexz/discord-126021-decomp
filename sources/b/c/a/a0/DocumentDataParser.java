package b.c.a.a0;

import b.c.a.a0.i0.JsonReader2;
import b.c.a.y.DocumentData;
import java.io.IOException;

/* JADX INFO: renamed from: b.c.a.a0.h, reason: use source file name */
/* JADX INFO: compiled from: DocumentDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser a = new DocumentDataParser();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader2.a f332b = JsonReader2.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // b.c.a.a0.ValueParser
    public DocumentData a(JsonReader2 jsonReader2, float f) throws IOException {
        jsonReader2.b();
        String strT = null;
        String strT2 = null;
        float fN = 0.0f;
        int i = 3;
        int iQ = 0;
        float fN2 = 0.0f;
        float fN3 = 0.0f;
        int iA = 0;
        int iA2 = 0;
        float fN4 = 0.0f;
        boolean zF = true;
        while (jsonReader2.e()) {
            switch (jsonReader2.y(f332b)) {
                case 0:
                    strT = jsonReader2.t();
                    break;
                case 1:
                    strT2 = jsonReader2.t();
                    break;
                case 2:
                    fN = (float) jsonReader2.n();
                    break;
                case 3:
                    int iQ2 = jsonReader2.q();
                    i = (iQ2 <= 2 && iQ2 >= 0) ? b.c.a.y.b.com$airbnb$lottie$model$DocumentData$Justification$s$values()[iQ2] : 3;
                    break;
                case 4:
                    iQ = jsonReader2.q();
                    break;
                case 5:
                    fN2 = (float) jsonReader2.n();
                    break;
                case 6:
                    fN3 = (float) jsonReader2.n();
                    break;
                case 7:
                    iA = JsonUtils.a(jsonReader2);
                    break;
                case 8:
                    iA2 = JsonUtils.a(jsonReader2);
                    break;
                case 9:
                    fN4 = (float) jsonReader2.n();
                    break;
                case 10:
                    zF = jsonReader2.f();
                    break;
                default:
                    jsonReader2.A();
                    jsonReader2.C();
                    break;
            }
        }
        jsonReader2.d();
        return new DocumentData(strT, strT2, fN, i, iQ, fN2, fN3, iA, iA2, fN4, zF);
    }
}
