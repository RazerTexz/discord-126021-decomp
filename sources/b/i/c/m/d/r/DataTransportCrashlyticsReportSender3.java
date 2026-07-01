package b.i.c.m.d.r;

import b.i.a.b.Transformer;
import b.i.a.b.Transport2;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.c.m.d.r.c, reason: use source file name */
/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public class DataTransportCrashlyticsReportSender3 {
    public static final CrashlyticsReportJsonTransform8 a = new CrashlyticsReportJsonTransform8();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1746b = a("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    public static final String c = a("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    public static final Transformer<CrashlyticsReport, byte[]> d = new Transformer() { // from class: b.i.c.m.d.r.b
        @Override // b.i.a.b.Transformer
        public Object apply(Object obj) {
            return DataTransportCrashlyticsReportSender3.a.g((CrashlyticsReport) obj).getBytes(Charset.forName(Constants.ENCODING));
        }
    };
    public final Transport2<CrashlyticsReport> e;

    public DataTransportCrashlyticsReportSender3(Transport2<CrashlyticsReport> transport2, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.e = transport2;
    }

    public static String a(String str, String str2) {
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
