package p007b.p225i.p361c.p369m.p370d.p373k;

import java.io.File;
import java.io.IOException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p378o.C4715h;

/* JADX INFO: renamed from: b.i.c.m.d.k.m0 */
/* JADX INFO: compiled from: CrashlyticsFileMarker.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4642m0 {

    /* JADX INFO: renamed from: a */
    public final String f12348a;

    /* JADX INFO: renamed from: b */
    public final C4715h f12349b;

    public C4642m0(String str, C4715h c4715h) {
        this.f12348a = str;
        this.f12349b = c4715h;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6444a() {
        try {
            return m6445b().createNewFile();
        } catch (IOException e) {
            C4592b c4592b = C4592b.f12227a;
            StringBuilder sbM833U = C1643a.m833U("Error creating marker: ");
            sbM833U.append(this.f12348a);
            c4592b.m6374e(sbM833U.toString(), e);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final File m6445b() {
        return new File(this.f12349b.m6636a(), this.f12348a);
    }
}
