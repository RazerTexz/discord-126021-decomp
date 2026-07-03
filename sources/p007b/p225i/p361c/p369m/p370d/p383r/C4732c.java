package p007b.p225i.p361c.p369m.p370d.p383r;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import p007b.p225i.p226a.p228b.InterfaceC2410e;
import p007b.p225i.p226a.p228b.InterfaceC2411f;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h;

/* JADX INFO: renamed from: b.i.c.m.d.r.c */
/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4732c {

    /* JADX INFO: renamed from: a */
    public static final C4704h f12723a = new C4704h();

    /* JADX INFO: renamed from: b */
    public static final String f12724b = m6679a("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* JADX INFO: renamed from: c */
    public static final String f12725c = m6679a("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* JADX INFO: renamed from: d */
    public static final InterfaceC2410e<AbstractC4695v, byte[]> f12726d = new InterfaceC2410e() { // from class: b.i.c.m.d.r.b
        @Override // p007b.p225i.p226a.p228b.InterfaceC2410e
        public Object apply(Object obj) {
            return C4732c.f12723a.m6620g((AbstractC4695v) obj).getBytes(Charset.forName(Constants.ENCODING));
        }
    };

    /* JADX INFO: renamed from: e */
    public final InterfaceC2411f<AbstractC4695v> f12727e;

    public C4732c(InterfaceC2411f<AbstractC4695v> interfaceC2411f, InterfaceC2410e<AbstractC4695v, byte[]> interfaceC2410e) {
        this.f12727e = interfaceC2411f;
    }

    /* JADX INFO: renamed from: a */
    public static String m6679a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }
}
