package p007b.p225i.p361c.p406w;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.w.r */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4880r {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final Bundle f13039a;

    public C4880r(@NonNull Bundle bundle) {
        this.f13039a = new Bundle(bundle);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m6820f(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    /* JADX INFO: renamed from: h */
    public static String m6821h(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6822a(String str) {
        String strM6826e = m6826e(str);
        return "1".equals(strM6826e) || Boolean.parseBoolean(strM6826e);
    }

    /* JADX INFO: renamed from: b */
    public Integer m6823b(String str) {
        String strM6826e = m6826e(str);
        if (TextUtils.isEmpty(strM6826e)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strM6826e));
        } catch (NumberFormatException unused) {
            String strM6821h = m6821h(str);
            C1643a.m874r0(C1643a.m831S(C1643a.m841b(strM6826e, C1643a.m841b(strM6821h, 38)), "Couldn't parse value of ", strM6821h, "(", strM6826e), ") into an int", "NotificationParams");
            return null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public JSONArray m6824c(String str) {
        String strM6826e = m6826e(str);
        if (TextUtils.isEmpty(strM6826e)) {
            return null;
        }
        try {
            return new JSONArray(strM6826e);
        } catch (JSONException unused) {
            String strM6821h = m6821h(str);
            C1643a.m874r0(C1643a.m831S(C1643a.m841b(strM6826e, C1643a.m841b(strM6821h, 50)), "Malformed JSON for key ", strM6821h, ": ", strM6826e), ", falling back to default", "NotificationParams");
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public String m6825d(Resources resources, String str, String str2) {
        String[] strArr;
        String strM6826e = m6826e(str2);
        if (!TextUtils.isEmpty(strM6826e)) {
            return strM6826e;
        }
        String strM6826e2 = m6826e(str2.concat("_loc_key"));
        if (TextUtils.isEmpty(strM6826e2)) {
            return null;
        }
        int identifier = resources.getIdentifier(strM6826e2, "string", str);
        if (identifier == 0) {
            String strM6821h = m6821h(str2.concat("_loc_key"));
            Log.w("NotificationParams", C1643a.m861l(str2.length() + C1643a.m841b(strM6821h, 49), strM6821h, " resource not found: ", str2, " Default value will be used."));
            return null;
        }
        JSONArray jSONArrayM6824c = m6824c(str2.concat("_loc_args"));
        if (jSONArrayM6824c == null) {
            strArr = null;
        } else {
            int length = jSONArrayM6824c.length();
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArrayM6824c.optString(i);
            }
        }
        if (strArr == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, strArr);
        } catch (MissingFormatArgumentException e) {
            String strM6821h2 = m6821h(str2);
            String string = Arrays.toString(strArr);
            StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(string, C1643a.m841b(strM6821h2, 58)), "Missing format argument for ", strM6821h2, ": ", string);
            sbM831S.append(" Default value will be used.");
            Log.w("NotificationParams", sbM831S.toString(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public String m6826e(String str) {
        Bundle bundle = this.f13039a;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String strReplace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (this.f13039a.containsKey(strReplace)) {
                str = strReplace;
            }
        }
        return bundle.getString(str);
    }

    /* JADX INFO: renamed from: g */
    public Bundle m6827g() {
        Bundle bundle = new Bundle(this.f13039a);
        for (String str : this.f13039a.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
