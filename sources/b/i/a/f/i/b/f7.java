package b.i.a.f.i.b;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public final class f7 implements Runnable {
    public final URL j;
    public final x4 k;
    public final String l;
    public final /* synthetic */ d7 m;

    public f7(d7 d7Var, String str, URL url, x4 x4Var) {
        this.m = d7Var;
        AnimatableValueParser.w(str);
        this.j = url;
        this.k = x4Var;
        this.l = str;
    }

    public final void a(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.m.f().v(new Runnable(this, i, exc, bArr, map) { // from class: b.i.a.f.i.b.e7
            public final f7 j;
            public final int k;
            public final Exception l;
            public final byte[] m;
            public final Map n;

            {
                this.j = this;
                this.k = i;
                this.l = exc;
                this.m = bArr;
                this.n = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<ResolveInfo> listQueryIntentActivities;
                f7 f7Var = this.j;
                int i2 = this.k;
                Exception exc2 = this.l;
                byte[] bArr2 = this.m;
                u4 u4Var = f7Var.k.a;
                boolean z2 = true;
                if (!((i2 == 200 || i2 == 204 || i2 == 304) && exc2 == null)) {
                    u4Var.g().i.c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), exc2);
                    return;
                }
                u4Var.o().f1526y.a(true);
                if (bArr2.length == 0) {
                    u4Var.g().m.a("Deferred Deep Link response empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr2));
                    String strOptString = jSONObject.optString(Constants.DEEPLINK, "");
                    String strOptString2 = jSONObject.optString("gclid", "");
                    double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                    if (TextUtils.isEmpty(strOptString)) {
                        u4Var.g().m.a("Deferred Deep Link is empty.");
                        return;
                    }
                    t9 t9VarT = u4Var.t();
                    if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = t9VarT.a.f1570b.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                        z2 = false;
                    }
                    if (!z2) {
                        u4Var.g().i.c("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("gclid", strOptString2);
                    bundle.putString("_cis", "ddp");
                    u4Var.q.H("auto", "_cmp", bundle);
                    t9 t9VarT2 = u4Var.t();
                    if (TextUtils.isEmpty(strOptString) || !t9VarT2.Y(strOptString, dOptDouble)) {
                        return;
                    }
                    t9VarT2.a.f1570b.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                } catch (JSONException e) {
                    u4Var.g().f.b("Failed to parse the Deferred Deep Link response. exception", e);
                }
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnectionS;
        Map<String, List<String>> headerFields;
        this.m.a();
        int responseCode = 0;
        try {
            httpURLConnectionS = this.m.s(this.j);
            try {
                responseCode = httpURLConnectionS.getResponseCode();
                headerFields = httpURLConnectionS.getHeaderFields();
                try {
                    byte[] bArrT = d7.t(httpURLConnectionS);
                    httpURLConnectionS.disconnect();
                    a(responseCode, null, bArrT, headerFields);
                } catch (IOException e) {
                    e = e;
                    if (httpURLConnectionS != null) {
                        httpURLConnectionS.disconnect();
                    }
                    a(responseCode, e, null, headerFields);
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnectionS != null) {
                        httpURLConnectionS.disconnect();
                    }
                    a(responseCode, null, null, headerFields);
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
            httpURLConnectionS = null;
            headerFields = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionS = null;
            headerFields = null;
        }
    }
}
