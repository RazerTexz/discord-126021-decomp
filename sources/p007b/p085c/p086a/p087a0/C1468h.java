package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.C1564c;

/* JADX INFO: renamed from: b.c.a.a0.h */
/* JADX INFO: compiled from: DocumentDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1468h implements InterfaceC1469h0<C1564c> {

    /* JADX INFO: renamed from: a */
    public static final C1468h f2233a = new C1468h();

    /* JADX INFO: renamed from: b */
    public static final AbstractC1473c.a f2234b = AbstractC1473c.a.m616a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // p007b.p085c.p086a.p087a0.InterfaceC1469h0
    /* JADX INFO: renamed from: a */
    public C1564c mo413a(AbstractC1473c abstractC1473c, float f) throws IOException {
        abstractC1473c.mo604b();
        String strMo612t = null;
        String strMo612t2 = null;
        float fMo609n = 0.0f;
        int i = 3;
        int iMo610q = 0;
        float fMo609n2 = 0.0f;
        float fMo609n3 = 0.0f;
        int iM627a = 0;
        int iM627a2 = 0;
        float fMo609n4 = 0.0f;
        boolean zMo608f = true;
        while (abstractC1473c.mo607e()) {
            switch (abstractC1473c.mo615y(f2234b)) {
                case 0:
                    strMo612t = abstractC1473c.mo612t();
                    break;
                case 1:
                    strMo612t2 = abstractC1473c.mo612t();
                    break;
                case 2:
                    fMo609n = (float) abstractC1473c.mo609n();
                    break;
                case 3:
                    int iMo610q2 = abstractC1473c.mo610q();
                    i = (iMo610q2 <= 2 && iMo610q2 >= 0) ? C1563b.com$airbnb$lottie$model$DocumentData$Justification$s$values()[iMo610q2] : 3;
                    break;
                case 4:
                    iMo610q = abstractC1473c.mo610q();
                    break;
                case 5:
                    fMo609n2 = (float) abstractC1473c.mo609n();
                    break;
                case 6:
                    fMo609n3 = (float) abstractC1473c.mo609n();
                    break;
                case 7:
                    iM627a = C1481p.m627a(abstractC1473c);
                    break;
                case 8:
                    iM627a2 = C1481p.m627a(abstractC1473c);
                    break;
                case 9:
                    fMo609n4 = (float) abstractC1473c.mo609n();
                    break;
                case 10:
                    zMo608f = abstractC1473c.mo608f();
                    break;
                default:
                    abstractC1473c.mo600A();
                    abstractC1473c.mo601C();
                    break;
            }
        }
        abstractC1473c.mo606d();
        return new C1564c(strMo612t, strMo612t2, fMo609n, i, iMo610q, fMo609n2, fMo609n3, iM627a, iM627a2, fMo609n4, zMo608f);
    }
}
