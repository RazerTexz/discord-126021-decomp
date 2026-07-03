package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.f7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public final class RunnableC4036f7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final URL f10722j;

    /* JADX INFO: renamed from: k */
    public final C4235x4 f10723k;

    /* JADX INFO: renamed from: l */
    public final String f10724l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4012d7 f10725m;

    public RunnableC4036f7(C4012d7 c4012d7, String str, URL url, C4235x4 c4235x4) {
        this.f10725m = c4012d7;
        C1460d.m583w(str);
        this.f10722j = url;
        this.f10723k = c4235x4;
        this.f10724l = str;
    }

    /* JADX INFO: renamed from: a */
    public final void m5598a(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f10725m.mo5725f().m5852v(new Runnable(this, i, exc, bArr, map) { // from class: b.i.a.f.i.b.e7

            /* JADX INFO: renamed from: j */
            public final RunnableC4036f7 f10689j;

            /* JADX INFO: renamed from: k */
            public final int f10690k;

            /* JADX INFO: renamed from: l */
            public final Exception f10691l;

            /* JADX INFO: renamed from: m */
            public final byte[] f10692m;

            /* JADX INFO: renamed from: n */
            public final Map f10693n;

            {
                this.f10689j = this;
                this.f10690k = i;
                this.f10691l = exc;
                this.f10692m = bArr;
                this.f10693n = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<ResolveInfo> listQueryIntentActivities;
                RunnableC4036f7 runnableC4036f7 = this.f10689j;
                int i2 = this.f10690k;
                Exception exc2 = this.f10691l;
                byte[] bArr2 = this.f10692m;
                C4202u4 c4202u4 = runnableC4036f7.f10723k.f11340a;
                boolean z2 = true;
                if (!((i2 == 200 || i2 == 204 || i2 == 304) && exc2 == null)) {
                    c4202u4.mo5726g().f11144i.m5862c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), exc2);
                    return;
                }
                c4202u4.m5946o().f10655y.m5596a(true);
                if (bArr2.length == 0) {
                    c4202u4.mo5726g().f11148m.m5860a("Deferred Deep Link response empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr2));
                    String strOptString = jSONObject.optString(Constants.DEEPLINK, "");
                    String strOptString2 = jSONObject.optString("gclid", "");
                    double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                    if (TextUtils.isEmpty(strOptString)) {
                        c4202u4.mo5726g().f11148m.m5860a("Deferred Deep Link is empty.");
                        return;
                    }
                    C4196t9 c4196t9M5949t = c4202u4.m5949t();
                    if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = c4196t9M5949t.f11202a.f11254b.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                        z2 = false;
                    }
                    if (!z2) {
                        c4202u4.mo5726g().f11144i.m5862c("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("gclid", strOptString2);
                    bundle.putString("_cis", "ddp");
                    c4202u4.f11269q.m5545H("auto", "_cmp", bundle);
                    C4196t9 c4196t9M5949t2 = c4202u4.m5949t();
                    if (TextUtils.isEmpty(strOptString) || !c4196t9M5949t2.m5907Y(strOptString, dOptDouble)) {
                        return;
                    }
                    c4196t9M5949t2.f11202a.f11254b.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                } catch (JSONException e) {
                    c4202u4.mo5726g().f11141f.m5861b("Failed to parse the Deferred Deep Link response. exception", e);
                }
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnectionM5583s;
        Map<String, List<String>> headerFields;
        this.f10725m.mo5847a();
        int responseCode = 0;
        try {
            httpURLConnectionM5583s = this.f10725m.m5583s(this.f10722j);
            try {
                responseCode = httpURLConnectionM5583s.getResponseCode();
                headerFields = httpURLConnectionM5583s.getHeaderFields();
                try {
                    byte[] bArrM5582t = C4012d7.m5582t(httpURLConnectionM5583s);
                    httpURLConnectionM5583s.disconnect();
                    m5598a(responseCode, null, bArrM5582t, headerFields);
                } catch (IOException e) {
                    e = e;
                    if (httpURLConnectionM5583s != null) {
                        httpURLConnectionM5583s.disconnect();
                    }
                    m5598a(responseCode, e, null, headerFields);
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnectionM5583s != null) {
                        httpURLConnectionM5583s.disconnect();
                    }
                    m5598a(responseCode, null, null, headerFields);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                headerFields = null;
            } catch (Throwable th2) {
                th = th2;
                headerFields = null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnectionM5583s = null;
            headerFields = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionM5583s = null;
            headerFields = null;
        }
    }
}
