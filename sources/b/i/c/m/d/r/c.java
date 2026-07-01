package b.i.c.m.d.r;

import b.i.a.b.e;
import b.i.a.b.f;
import b.i.c.m.d.m.v;
import b.i.c.m.d.m.x.h;

/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1746b = a("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    public static final String c = a("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    public static final e<v, byte[]> d = b.a;
    public final f<v> e;

    public c(f<v> fVar, e<v, byte[]> eVar) {
        this.e = fVar;
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
