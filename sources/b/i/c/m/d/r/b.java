package b.i.c.m.d.r;

import b.i.a.b.e;
import b.i.c.m.d.m.v;
import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements e {
    public static final b a = new b();

    @Override // b.i.a.b.e
    public Object apply(Object obj) {
        return c.a.g((v) obj).getBytes(Charset.forName(Constants.ENCODING));
    }
}
