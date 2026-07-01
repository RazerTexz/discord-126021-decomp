package b.i.a.f.i.b;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e7 implements Runnable {
    public final f7 j;
    public final int k;
    public final Exception l;
    public final byte[] m;
    public final Map n;

    public e7(f7 f7Var, int i, Exception exc, byte[] bArr, Map map) {
        this.j = f7Var;
        this.k = i;
        this.l = exc;
        this.m = bArr;
        this.n = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<ResolveInfo> listQueryIntentActivities;
        f7 f7Var = this.j;
        int i = this.k;
        Exception exc = this.l;
        byte[] bArr = this.m;
        u4 u4Var = f7Var.k.a;
        boolean z2 = true;
        if (!((i == 200 || i == 204 || i == 304) && exc == null)) {
            u4Var.g().i.c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), exc);
            return;
        }
        u4Var.o().f1526y.a(true);
        if (bArr.length == 0) {
            u4Var.g().m.a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
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
}
