package b.i.a.f.h.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.res.Resources$NotFoundException;
import android.os.Bundle;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 extends e {
    public String l;
    public String m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;

    public a1(g gVar) {
        super(gVar);
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        ApplicationInfo applicationInfo;
        int i;
        int i2;
        Context context = this.j.f1417b;
        i0 i0VarI = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager$NameNotFoundException e) {
            x("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            D("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0) {
            return;
        }
        g0 g0Var = new g0(this.j);
        try {
            i0VarI = g0Var.I(g0Var.j.c.getResources().getXml(i));
        } catch (Resources$NotFoundException e2) {
            g0Var.x("inflate() called with unknown resourceId", e2);
        }
        if (i0VarI != null) {
            C("Loading global XML config values");
            String str = i0VarI.a;
            if (str != null) {
                this.m = str;
                d("XML config - app name", str);
            }
            String str2 = i0VarI.f1420b;
            if (str2 != null) {
                this.l = str2;
                d("XML config - app version", str2);
            }
            String str3 = i0VarI.c;
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
                    b("XML config - log level", Integer.valueOf(i2));
                }
            }
            int i3 = i0VarI.d;
            if (i3 >= 0) {
                this.o = i3;
                this.n = true;
                d("XML config - dispatch period (sec)", Integer.valueOf(i3));
            }
            int i4 = i0VarI.e;
            if (i4 != -1) {
                boolean z2 = i4 == 1;
                this.q = z2;
                this.p = true;
                d("XML config - dry run", Boolean.valueOf(z2));
            }
        }
    }
}
