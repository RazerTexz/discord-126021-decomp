package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.google.android.gms.base.C10796R;
import com.google.android.gms.common.C10800R;
import java.util.Locale;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3258d;
import p007b.p225i.p226a.p288f.p299e.p310p.C3410a;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.e.k.l */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3365l {

    /* JADX INFO: renamed from: a */
    public static final SimpleArrayMap<String, String> f9534a = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: b */
    @Nullable
    public static Locale f9535b;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static String m4166a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C10796R.b.common_google_play_services_install_title);
            case 2:
                return resources.getString(C10796R.b.common_google_play_services_update_title);
            case 3:
                return resources.getString(C10796R.b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m4167b(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m4167b(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m4167b(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m4167b(context, "common_google_play_services_restricted_profile_title");
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static String m4167b(Context context, String str) {
        Resources resourcesForApplication;
        SimpleArrayMap<String, String> simpleArrayMap = f9534a;
        synchronized (simpleArrayMap) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(f9535b)) {
                simpleArrayMap.clear();
                f9535b = locale;
            }
            String str2 = simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            int i = C3258d.f9308e;
            try {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            } catch (PackageManager.NameNotFoundException unused) {
                resourcesForApplication = null;
            }
            if (resourcesForApplication == null) {
                return null;
            }
            int identifier = resourcesForApplication.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String strValueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", strValueOf.length() != 0 ? "Missing resource: ".concat(strValueOf) : new String("Missing resource: "));
                return null;
            }
            String string = resourcesForApplication.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                f9534a.put(str, string);
                return string;
            }
            String strValueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", strValueOf2.length() != 0 ? "Got empty resource: ".concat(strValueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m4168c(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strM4167b = m4167b(context, str);
        if (strM4167b == null) {
            strM4167b = resources.getString(C10800R.a.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strM4167b, str2);
    }

    /* JADX INFO: renamed from: d */
    public static String m4169d(Context context) {
        String packageName = context.getPackageName();
        try {
            C3410a c3410aM4376a = C3411b.m4376a(context);
            return c3410aM4376a.f9605a.getPackageManager().getApplicationLabel(c3410aM4376a.f9605a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    @NonNull
    /* JADX INFO: renamed from: e */
    public static String m4170e(Context context, int i) {
        Resources resources = context.getResources();
        String strM4169d = m4169d(context);
        if (i == 1) {
            return resources.getString(C10796R.b.common_google_play_services_install_text, strM4169d);
        }
        if (i == 2) {
            return C1460d.m497a1(context) ? resources.getString(C10796R.b.common_google_play_services_wear_update_text) : resources.getString(C10796R.b.common_google_play_services_update_text, strM4169d);
        }
        if (i == 3) {
            return resources.getString(C10796R.b.common_google_play_services_enable_text, strM4169d);
        }
        if (i == 5) {
            return m4168c(context, "common_google_play_services_invalid_account_text", strM4169d);
        }
        if (i == 7) {
            return m4168c(context, "common_google_play_services_network_error_text", strM4169d);
        }
        if (i == 9) {
            return resources.getString(C10796R.b.common_google_play_services_unsupported_text, strM4169d);
        }
        if (i == 20) {
            return m4168c(context, "common_google_play_services_restricted_profile_text", strM4169d);
        }
        switch (i) {
            case 16:
                return m4168c(context, "common_google_play_services_api_unavailable_text", strM4169d);
            case 17:
                return m4168c(context, "common_google_play_services_sign_in_failed_text", strM4169d);
            case 18:
                return resources.getString(C10796R.b.common_google_play_services_updating_text, strM4169d);
            default:
                return resources.getString(C10800R.a.common_google_play_services_unknown_issue, strM4169d);
        }
    }
}
