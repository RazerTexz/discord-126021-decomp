package b.c.a.a0;

import b.c.a.a0.i0.c$a;
import java.io.IOException;

/* JADX INFO: compiled from: DocumentDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements h0<b.c.a.y.c> {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c$a f332b = c$a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // b.c.a.a0.h0
    public b.c.a.y.c a(b.c.a.a0.i0.c cVar, float f) throws IOException {
        cVar.b();
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
        while (cVar.e()) {
            switch (cVar.y(f332b)) {
                case 0:
                    strT = cVar.t();
                    break;
                case 1:
                    strT2 = cVar.t();
                    break;
                case 2:
                    fN = (float) cVar.n();
                    break;
                case 3:
                    int iQ2 = cVar.q();
                    i = (iQ2 <= 2 && iQ2 >= 0) ? b.c.a.y.b.com$airbnb$lottie$model$DocumentData$Justification$s$values()[iQ2] : 3;
                    break;
                case 4:
                    iQ = cVar.q();
                    break;
                case 5:
                    fN2 = (float) cVar.n();
                    break;
                case 6:
                    fN3 = (float) cVar.n();
                    break;
                case 7:
                    iA = p.a(cVar);
                    break;
                case 8:
                    iA2 = p.a(cVar);
                    break;
                case 9:
                    fN4 = (float) cVar.n();
                    break;
                case 10:
                    zF = cVar.f();
                    break;
                default:
                    cVar.A();
                    cVar.C();
                    break;
            }
        }
        cVar.d();
        return new b.c.a.y.c(strT, strT2, fN, i, iQ, fN2, fN3, iA, iA2, fN4, zF);
    }
}
