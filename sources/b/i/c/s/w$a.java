package b.i.c.s;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class w$a {
    public static final long a = TimeUnit.DAYS.toMillis(7);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1776b = 0;
    public final String c;
    public final String d;
    public final long e;

    public w$a(String str, String str2, long j) {
        this.c = str;
        this.d = str2;
        this.e = j;
    }

    public static String a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String strValueOf = String.valueOf(e);
            b.d.b.a.a.h0(strValueOf.length() + 24, "Failed to encode token: ", strValueOf, "FirebaseInstanceId");
            return null;
        }
    }

    public static w$a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new w$a(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new w$a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String strValueOf = String.valueOf(e);
            b.d.b.a.a.h0(strValueOf.length() + 23, "Failed to parse token: ", strValueOf, "FirebaseInstanceId");
            return null;
        }
    }
}
