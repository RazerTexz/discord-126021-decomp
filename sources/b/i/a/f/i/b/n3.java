package b.i.a.f.i.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import b.i.a.f.h.l.ib;
import b.i.a.f.h.l.lb;
import com.google.android.gms.common.R$a;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n3 extends a5 {
    public String c;
    public String d;
    public int e;
    public String f;
    public long g;
    public long h;
    public List<String> i;
    public int j;
    public String k;
    public String l;
    public String m;

    public n3(u4 u4Var, long j) {
        super(u4Var);
        this.h = j;
    }

    @Override // b.i.a.f.i.b.a5
    public final boolean v() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:126:0x02d7 A[Catch: Resources$NotFoundException -> 0x02dc, TRY_LEAVE, TryCatch #2 {Resources$NotFoundException -> 0x02dc, blocks: (B:123:0x02c4, B:126:0x02d7), top: B:155:0x02c4 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:133:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:135:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:138:0x0307  */
    /* JADX WARN: Code duplicated, block: B:142:0x031c  */
    /* JADX WARN: Code duplicated, block: B:144:0x0320  */
    /* JADX WARN: Code duplicated, block: B:146:0x032b  */
    /* JADX WARN: Code duplicated, block: B:155:0x02c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x02fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:? A[LOOP:0: B:136:0x0301->B:163:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0188  */
    public final void w() {
        Status status;
        boolean z2;
        Integer numValueOf;
        String[] stringArray;
        Iterator<String> it;
        String installerPackageName = EnvironmentCompat.MEDIA_UNKNOWN;
        String str = "Unknown";
        String packageName = this.a.f1570b.getPackageName();
        PackageManager packageManager = this.a.f1570b.getPackageManager();
        int i = Integer.MIN_VALUE;
        if (packageManager == null) {
            g().f.b("PackageManager is null, app identity information might be inaccurate. appId", q3.s(packageName));
        } else {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                g().f.b("Error retrieving app installer package name. appId", q3.s(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.a.f1570b.getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        applicationLabel.toString();
                    }
                    str = packageInfo.versionName;
                    i = packageInfo.versionCode;
                }
            } catch (PackageManager$NameNotFoundException unused2) {
                g().f.c("Error retrieving package info. appId, appName", q3.s(packageName), "Unknown");
            }
        }
        this.c = packageName;
        this.f = installerPackageName;
        this.d = str;
        this.e = i;
        this.g = 0L;
        Context context = this.a.f1570b;
        Object obj = b.i.a.f.e.h.j.h.a;
        b.c.a.a0.d.z(context, "Context must not be null.");
        synchronized (b.i.a.f.e.h.j.h.a) {
            if (b.i.a.f.e.h.j.h.f1365b == null) {
                b.i.a.f.e.h.j.h.f1365b = new b.i.a.f.e.h.j.h(context);
            }
            status = b.i.a.f.e.h.j.h.f1365b.d;
        }
        boolean z3 = true;
        boolean z4 = status != null && status.w0();
        boolean z5 = !TextUtils.isEmpty(this.a.c) && "am".equals(this.a.d);
        boolean z6 = z4 | z5;
        if (!z6) {
            if (status == null) {
                g().g.a("GoogleService failed to initialize (no status)");
            } else {
                g().g.c("GoogleService failed to initialize, status", Integer.valueOf(status.p), status.q);
            }
        }
        if (z6) {
            int iE = this.a.e();
            switch (iE) {
                case 0:
                    g().n.a("App measurement collection enabled");
                    break;
                case 1:
                    g().l.a("App measurement deactivated via the manifest");
                    break;
                case 2:
                    g().n.a("App measurement deactivated via the init parameters");
                    break;
                case 3:
                    g().l.a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                    break;
                case 4:
                    g().l.a("App measurement disabled via the manifest");
                    break;
                case 5:
                    g().n.a("App measurement disabled via the init parameters");
                    break;
                case 6:
                    g().k.a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                    break;
                case 7:
                    g().l.a("App measurement disabled via the global data collection setting");
                    break;
                case 8:
                    g().l.a("App measurement disabled due to denied storage consent");
                    break;
                default:
                    g().l.a("App measurement disabled");
                    g().g.a("Invalid scion state in identity");
                    break;
            }
            if (iE == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.k = "";
        this.l = "";
        this.m = "";
        if (z5) {
            this.l = this.a.c;
        }
        List<String> listAsList = null;
        try {
            String strV1 = (((lb) ib.j.a()).a() && this.a.h.o(p.C0)) ? b.i.a.f.e.o.f.V1(this.a.f1570b, "google_app_id") : b.i.a.f.e.h.j.h.a("getGoogleAppId").c;
            this.k = TextUtils.isEmpty(strV1) ? "" : strV1;
            if (b.i.a.f.h.l.da.b() && this.a.h.o(p.f1561j0)) {
                Context context2 = this.a.f1570b;
                Objects.requireNonNull(context2, "null reference");
                Resources resources = context2.getResources();
                String resourcePackageName = resources.getResourcePackageName(R$a.common_google_play_services_unknown_issue);
                int identifier = resources.getIdentifier("ga_app_id", "string", resourcePackageName);
                String string = identifier == 0 ? null : resources.getString(identifier);
                this.m = TextUtils.isEmpty(string) ? "" : string;
                if (!TextUtils.isEmpty(strV1) || !TextUtils.isEmpty(string)) {
                    int identifier2 = resources.getIdentifier("admob_app_id", "string", resourcePackageName);
                    this.l = identifier2 == 0 ? null : resources.getString(identifier2);
                }
            } else if (!TextUtils.isEmpty(strV1)) {
                Context context3 = this.a.f1570b;
                Objects.requireNonNull(context3, "null reference");
                Resources resources2 = context3.getResources();
                int identifier3 = resources2.getIdentifier("admob_app_id", "string", resources2.getResourcePackageName(R$a.common_google_play_services_unknown_issue));
                this.l = identifier3 == 0 ? null : resources2.getString(identifier3);
            }
            if (z2) {
                g().n.c("App measurement enabled for app package, google app id", this.c, TextUtils.isEmpty(this.k) ? this.l : this.k);
            }
        } catch (IllegalStateException e) {
            g().f.c("Fetching Google App Id failed with exception. appId", q3.s(packageName), e);
        }
        this.i = null;
        c cVar = this.a.h;
        Objects.requireNonNull(cVar);
        b.c.a.a0.d.w("analytics.safelisted_events");
        Bundle bundleD = cVar.D();
        if (bundleD != null) {
            if (bundleD.containsKey("analytics.safelisted_events")) {
                numValueOf = Integer.valueOf(bundleD.getInt("analytics.safelisted_events"));
            }
            if (numValueOf != null) {
                try {
                    stringArray = cVar.a.f1570b.getResources().getStringArray(numValueOf.intValue());
                    if (stringArray == null) {
                        listAsList = Arrays.asList(stringArray);
                    }
                } catch (Resources$NotFoundException e2) {
                    cVar.g().f.b("Failed to load string array from metadata: resource not found", e2);
                }
            }
            if (listAsList != null) {
                if (listAsList.size() == 0) {
                    g().k.a("Safelisted event list is empty. Ignoring");
                } else {
                    it = listAsList.iterator();
                    while (it.hasNext()) {
                        if (!e().m0("safelisted event", it.next())) {
                        }
                    }
                }
                z3 = false;
            }
            if (z3) {
                this.i = listAsList;
            }
            if (packageManager != null) {
                this.j = b.i.a.f.e.o.f.E0(this.a.f1570b) ? 1 : 0;
            } else {
                this.j = 0;
            }
        }
        cVar.g().f.a("Failed to load metadata: Metadata bundle is null");
        numValueOf = null;
        if (numValueOf != null) {
            stringArray = cVar.a.f1570b.getResources().getStringArray(numValueOf.intValue());
            if (stringArray == null) {
                listAsList = Arrays.asList(stringArray);
            }
        }
        if (listAsList != null) {
            if (listAsList.size() == 0) {
                g().k.a("Safelisted event list is empty. Ignoring");
            } else {
                it = listAsList.iterator();
                while (it.hasNext()) {
                    if (!e().m0("safelisted event", it.next())) {
                    }
                }
            }
            z3 = false;
        }
        if (z3) {
            this.i = listAsList;
        }
        if (packageManager != null) {
            this.j = b.i.a.f.e.o.f.E0(this.a.f1570b) ? 1 : 0;
        } else {
            this.j = 0;
        }
    }
}
