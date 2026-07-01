package b.i.a.f.e.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.base.R;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static final SimpleArrayMap<String, String> a = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static Locale f1390b;

    @Nullable
    public static String a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.b.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.b.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return b(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return b(context, "common_google_play_services_network_error_title");
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
                return b(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return b(context, "common_google_play_services_restricted_profile_title");
        }
    }

    @Nullable
    public static String b(Context context, String str) {
        Resources resourcesForApplication;
        SimpleArrayMap<String, String> simpleArrayMap = a;
        synchronized (simpleArrayMap) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(f1390b)) {
                simpleArrayMap.clear();
                f1390b = locale;
            }
            String str2 = simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            int i = b.i.a.f.e.d.e;
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
                a.put(str, string);
                return string;
            }
            String strValueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", strValueOf2.length() != 0 ? "Got empty resource: ".concat(strValueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    public static String c(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strB = b(context, str);
        if (strB == null) {
            strB = resources.getString(com.google.android.gms.common.R.a.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strB, str2);
    }

    public static String d(Context context) {
        String packageName = context.getPackageName();
        try {
            b.i.a.f.e.p.a aVarA = b.i.a.f.e.p.b.a(context);
            return aVarA.a.getPackageManager().getApplicationLabel(aVarA.a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    @NonNull
    public static String e(Context context, int i) {
        Resources resources = context.getResources();
        String strD = d(context);
        if (i == 1) {
            return resources.getString(R.b.common_google_play_services_install_text, strD);
        }
        if (i == 2) {
            return AnimatableValueParser.a1(context) ? resources.getString(R.b.common_google_play_services_wear_update_text) : resources.getString(R.b.common_google_play_services_update_text, strD);
        }
        if (i == 3) {
            return resources.getString(R.b.common_google_play_services_enable_text, strD);
        }
        if (i == 5) {
            return c(context, "common_google_play_services_invalid_account_text", strD);
        }
        if (i == 7) {
            return c(context, "common_google_play_services_network_error_text", strD);
        }
        if (i == 9) {
            return resources.getString(R.b.common_google_play_services_unsupported_text, strD);
        }
        if (i == 20) {
            return c(context, "common_google_play_services_restricted_profile_text", strD);
        }
        switch (i) {
            case 16:
                return c(context, "common_google_play_services_api_unavailable_text", strD);
            case 17:
                return c(context, "common_google_play_services_sign_in_failed_text", strD);
            case 18:
                return resources.getString(R.b.common_google_play_services_updating_text, strD);
            default:
                return resources.getString(com.google.android.gms.common.R.a.common_google_play_services_unknown_issue, strD);
        }
    }
}
