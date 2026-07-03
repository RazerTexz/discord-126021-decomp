package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import java.util.Locale;

/* JADX INFO: renamed from: b.i.a.f.h.j.a1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3499a1 extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public String f9666l;

    /* JADX INFO: renamed from: m */
    public String f9667m;

    /* JADX INFO: renamed from: n */
    public boolean f9668n;

    /* JADX INFO: renamed from: o */
    public int f9669o;

    /* JADX INFO: renamed from: p */
    public boolean f9670p;

    /* JADX INFO: renamed from: q */
    public boolean f9671q;

    public C3499a1(C3515g c3515g) {
        super(c3515g);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        ApplicationInfo applicationInfo;
        int i;
        int i2;
        Context context = this.f9684j.f9722b;
        C3521i0 c3521i0M4505I = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            m4439x("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            m4428D("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0) {
            return;
        }
        C3516g0 c3516g0 = new C3516g0(this.f9684j);
        try {
            c3521i0M4505I = c3516g0.m4505I(c3516g0.f9684j.f9723c.getResources().getXml(i));
        } catch (Resources.NotFoundException e2) {
            c3516g0.m4439x("inflate() called with unknown resourceId", e2);
        }
        if (c3521i0M4505I != null) {
            m4427C("Loading global XML config values");
            String str = c3521i0M4505I.f9737a;
            if (str != null) {
                this.f9667m = str;
                m4432d("XML config - app name", str);
            }
            String str2 = c3521i0M4505I.f9738b;
            if (str2 != null) {
                this.f9666l = str2;
                m4432d("XML config - app version", str2);
            }
            String str3 = c3521i0M4505I.f9739c;
            if (str3 != null) {
                String lowerCase = str3.toLowerCase(Locale.US);
                if ("verbose".equals(lowerCase)) {
                    i2 = 0;
                } else if ("info".equals(lowerCase)) {
                    i2 = 1;
                } else if ("warning".equals(lowerCase)) {
                    i2 = 2;
                } else {
                    i2 = "error".equals(lowerCase) ? 3 : -1;
                }
                if (i2 >= 0) {
                    m4431b("XML config - log level", Integer.valueOf(i2));
                }
            }
            int i3 = c3521i0M4505I.f9740d;
            if (i3 >= 0) {
                this.f9669o = i3;
                this.f9668n = true;
                m4432d("XML config - dispatch period (sec)", Integer.valueOf(i3));
            }
            int i4 = c3521i0M4505I.f9741e;
            if (i4 != -1) {
                boolean z2 = i4 == 1;
                this.f9671q = z2;
                this.f9670p = true;
                m4432d("XML config - dry run", Boolean.valueOf(z2));
            }
        }
    }
}
