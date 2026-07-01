package b.i.a.f.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.k.u0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.google.android.gms.common.R;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f1346b;

    static {
        AtomicBoolean atomicBoolean = e.a;
        a = 12451000;
        f1346b = new c();
    }

    @RecentlyNullable
    public Intent a(@Nullable Context context, int i, @Nullable String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            Uri uri = u0.a;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && AnimatableValueParser.a1(context)) {
            Uri uri2 = u0.a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sbU = outline.U("gcore_");
        sbU.append(a);
        sbU.append("-");
        if (!TextUtils.isEmpty(str)) {
            sbU.append(str);
        }
        sbU.append("-");
        if (context != null) {
            sbU.append(context.getPackageName());
        }
        sbU.append("-");
        if (context != null) {
            try {
                sbU.append(b.i.a.f.e.p.b.a(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sbU.toString();
        Uri uri3 = u0.a;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_ID, "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:62:0x0104  */
    /* JADX WARN: Code duplicated, block: B:63:0x0106  */
    /* JADX WARN: Code duplicated, block: B:66:0x010b  */
    /* JADX WARN: Code duplicated, block: B:68:0x010f  */
    /* JADX WARN: Code duplicated, block: B:69:0x013f  */
    /* JADX WARN: Code duplicated, block: B:77:0x015b  */
    /* JADX WARN: Code duplicated, block: B:78:0x015d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0171  */
    /* JADX WARN: Code duplicated, block: B:84:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0175  */
    /* JADX WARN: Code duplicated, block: B:87:0x017b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x017c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public int b(@RecentlyNonNull Context context, int i) throws PackageManager.NameNotFoundException {
        boolean z2;
        PackageInfo packageInfo;
        int i2;
        int i3;
        int i4;
        ApplicationInfo applicationInfo;
        AtomicBoolean atomicBoolean = e.a;
        try {
            context.getResources().getString(R.a.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !e.d.get()) {
            b.i.a.f.e.k.f0.a(context);
            int i5 = b.i.a.f.e.k.f0.d;
            if (i5 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (i5 != 12451000) {
                throw new GooglePlayServicesIncorrectManifestValueException(i5);
            }
        }
        boolean zB = false;
        if (AnimatableValueParser.a1(context)) {
            z2 = false;
        } else {
            if (AnimatableValueParser.e == null) {
                AnimatableValueParser.e = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (AnimatableValueParser.e.booleanValue()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        AnimatableValueParser.l(i >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z2) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            f.a(context);
            if (f.d(packageInfo2, true)) {
                if (z2) {
                    Objects.requireNonNull(packageInfo, "null reference");
                    if (!f.d(packageInfo, true)) {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                    } else if (z2 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        i3 = packageInfo2.versionCode;
                        if (i3 == -1) {
                            i4 = -1;
                        } else {
                            i4 = i3 / 1000;
                        }
                        if (i4 < (i != -1 ? i / 1000 : -1)) {
                            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                            sb.append("Google Play services out of date for ");
                            sb.append(packageName);
                            sb.append(".  Requires ");
                            sb.append(i);
                            sb.append(" but found ");
                            sb.append(i3);
                            Log.w("GooglePlayServicesUtil", sb.toString());
                            i2 = 2;
                        } else {
                            applicationInfo = packageInfo2.applicationInfo;
                            if (applicationInfo == null) {
                                try {
                                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                                } catch (PackageManager.NameNotFoundException e) {
                                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e);
                                    i2 = 1;
                                }
                            }
                            if (applicationInfo.enabled) {
                                i2 = 0;
                            } else {
                                i2 = 3;
                            }
                        }
                    } else {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                    }
                } else {
                    if (z2) {
                    }
                    i3 = packageInfo2.versionCode;
                    if (i3 == -1) {
                        i4 = -1;
                    } else {
                        i4 = i3 / 1000;
                    }
                    if (i4 < (i != -1 ? i / 1000 : -1)) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 82);
                        sb2.append("Google Play services out of date for ");
                        sb2.append(packageName);
                        sb2.append(".  Requires ");
                        sb2.append(i);
                        sb2.append(" but found ");
                        sb2.append(i3);
                        Log.w("GooglePlayServicesUtil", sb2.toString());
                        i2 = 2;
                    } else {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        }
                        if (applicationInfo.enabled) {
                            i2 = 3;
                        } else {
                            i2 = 0;
                        }
                    }
                }
                if (i2 == 18) {
                    zB = true;
                } else if (i2 == 1) {
                    zB = e.b(context, "com.google.android.gms");
                }
                if (zB) {
                    return 18;
                }
                return i2;
            }
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            i2 = 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
        }
        if (i2 == 18) {
            zB = true;
        } else if (i2 == 1) {
            zB = e.b(context, "com.google.android.gms");
        }
        if (zB) {
            return 18;
        }
        return i2;
    }
}
