package b.i.a.f.i.b;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences$Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.f.h.l.fc;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t9 extends r5 {
    public static final String[] c = {"firebase_", "google_", "ga_"};
    public static final String[] d = {"_err"};
    public SecureRandom e;
    public final AtomicLong f;
    public int g;
    public Integer h;

    public t9(u4 u4Var) {
        super(u4Var);
        this.h = null;
        this.f = new AtomicLong(0L);
    }

    public static Bundle A(List<zzku> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzku zzkuVar : list) {
            String str = zzkuVar.n;
            if (str != null) {
                bundle.putString(zzkuVar.k, str);
            } else {
                Long l = zzkuVar.m;
                if (l != null) {
                    bundle.putLong(zzkuVar.k, l.longValue());
                } else {
                    Double d2 = zzkuVar.p;
                    if (d2 != null) {
                        bundle.putDouble(zzkuVar.k, d2.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public static String E(String str, int i, boolean z2) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z2) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static void F(Bundle bundle, int i, String str, Object obj) {
        if (l0(bundle, i)) {
            bundle.putString("_ev", E(str, 40, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    public static boolean U(Context context) {
        Objects.requireNonNull(context, "null reference");
        return Build$VERSION.SDK_INT >= 24 ? k0(context, "com.google.android.gms.measurement.AppMeasurementJobService") : k0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean V(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean W(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean X(String str) {
        b.c.a.a0.d.w(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean d0(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return !TextUtils.isEmpty(str4);
            }
            return !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static boolean e0(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (q0(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] g0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList<Bundle> j0(List<zzz> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzz zzzVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzzVar.j);
            bundle.putString("origin", zzzVar.k);
            bundle.putLong("creation_timestamp", zzzVar.m);
            bundle.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, zzzVar.l.k);
            b.i.a.f.e.o.f.d2(bundle, zzzVar.l.w0());
            bundle.putBoolean("active", zzzVar.n);
            String str = zzzVar.o;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaq zzaqVar = zzzVar.p;
            if (zzaqVar != null) {
                bundle.putString("timed_out_event_name", zzaqVar.j);
                zzap zzapVar = zzzVar.p.k;
                if (zzapVar != null) {
                    bundle.putBundle("timed_out_event_params", zzapVar.x0());
                }
            }
            bundle.putLong("trigger_timeout", zzzVar.q);
            zzaq zzaqVar2 = zzzVar.r;
            if (zzaqVar2 != null) {
                bundle.putString("triggered_event_name", zzaqVar2.j);
                zzap zzapVar2 = zzzVar.r.k;
                if (zzapVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzapVar2.x0());
                }
            }
            bundle.putLong("triggered_timestamp", zzzVar.l.l);
            bundle.putLong("time_to_live", zzzVar.f3016s);
            zzaq zzaqVar3 = zzzVar.t;
            if (zzaqVar3 != null) {
                bundle.putString("expired_event_name", zzaqVar3.j);
                zzap zzapVar3 = zzzVar.t.k;
                if (zzapVar3 != null) {
                    bundle.putBundle("expired_event_params", zzapVar3.x0());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean k0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager$NameNotFoundException unused) {
        }
    }

    public static boolean l0(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static boolean q0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean r0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static long u(long j, long j2) {
        return ((j2 * 60000) + j) / 86400000;
    }

    public static long v(zzap zzapVar) {
        long length = 0;
        if (zzapVar == null) {
            return 0L;
        }
        Iterator<String> it = zzapVar.j.keySet().iterator();
        while (it.hasNext()) {
            Object objW0 = zzapVar.w0(it.next());
            if (objW0 instanceof Parcelable[]) {
                length += (long) ((Parcelable[]) objW0).length;
            }
        }
        return length;
    }

    public static long w(byte[] bArr) {
        Objects.requireNonNull(bArr, "null reference");
        int i = 0;
        b.c.a.a0.d.F(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
        }
        return j;
    }

    public static MessageDigest x0() {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public final zzaq B(String str, String str2, Bundle bundle, String str3, long j, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (t(str2, z3) != 0) {
            g().f.b("Invalid conditional property event name", d().y(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleZ = z(str, str2, bundle2, Collections.singletonList("_o"), false);
        if (z2) {
            bundleZ = y(bundleZ);
        }
        return new zzaq(str2, new zzap(bundleZ), str3, j);
    }

    public final Object C(int i, Object obj, boolean z2, boolean z3) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return E(String.valueOf(obj), i, z2);
        }
        if (!z3 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleY = y((Bundle) parcelable);
                if (!bundleY.isEmpty()) {
                    arrayList.add(bundleY);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final Object D(String str, Object obj) {
        if ("_ev".equals(str)) {
            return C(256, obj, true, true);
        }
        return C(r0(str) ? 256 : 100, obj, false, true);
    }

    @WorkerThread
    public final void G(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            g().i.b("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void H(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                e().I(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void I(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            g().k.c("Not putting event parameter. Invalid value type. name, type", d().x(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void J(fc fcVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            fcVar.f(bundle);
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning int value to wrapper", e);
        }
    }

    public final void K(fc fcVar, long j) {
        try {
            fcVar.f(b.d.b.a.a.T("r", j));
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning long value to wrapper", e);
        }
    }

    public final void L(fc fcVar, Bundle bundle) {
        try {
            fcVar.f(bundle);
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning bundle value to wrapper", e);
        }
    }

    public final void M(fc fcVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            fcVar.f(bundle);
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning string value to wrapper", e);
        }
    }

    public final void N(fc fcVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            fcVar.f(bundle);
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning bundle list to wrapper", e);
        }
    }

    public final void O(fc fcVar, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z2);
        try {
            fcVar.f(bundle);
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning boolean value to wrapper", e);
        }
    }

    public final void P(fc fcVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            fcVar.f(bundle);
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning byte array to wrapper", e);
        }
    }

    public final void Q(u3 u3Var, int i) {
        int i2 = 0;
        for (String str : new TreeSet(u3Var.d.keySet())) {
            if (X(str) && (i2 = i2 + 1) > i) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i);
                sb.append(" params");
                g().h.c(sb.toString(), d().u(u3Var.a), d().s(u3Var.d));
                l0(u3Var.d, 5);
                u3Var.d.remove(str);
            }
        }
    }

    public final void R(v9 v9Var, int i, String str, String str2, int i2) {
        S(v9Var, null, i, str, str2, i2);
    }

    public final void S(v9 v9Var, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        l0(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        if (((b.i.a.f.h.l.g8) b.i.a.f.h.l.h8.j.a()).a() && this.a.h.o(p.O0)) {
            v9Var.a(str, bundle);
        } else {
            this.a.s().H("auto", "_err", bundle);
        }
    }

    public final void T(String str, String str2, String str3, Bundle bundle, @Nullable List<String> list, boolean z2) {
        int iU0;
        int iS;
        if (bundle == null) {
            return;
        }
        int i = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str4)) {
                iU0 = z2 ? u0(str4) : 0;
                if (iU0 == 0) {
                    iU0 = w0(str4);
                }
            } else {
                iU0 = 0;
            }
            if (iU0 != 0) {
                F(bundle, iU0, str4, iU0 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (W(bundle.get(str4))) {
                    g().k.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    iS = 22;
                } else {
                    iS = s(str, str2, str4, bundle.get(str4), bundle, list, z2, false);
                }
                if (iS != 0 && !"_ev".equals(str4)) {
                    F(bundle, iS, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (X(str4) && !e0(str4, u5.d) && (i = i + 1) > 0) {
                    g().h.c("Item cannot contain custom parameters", d().u(str2), d().s(bundle));
                    l0(bundle, 23);
                    bundle.remove(str4);
                }
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public final boolean Y(String str, double d2) {
        try {
            SharedPreferences$Editor sharedPreferences$EditorEdit = this.a.f1570b.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            sharedPreferences$EditorEdit.putString(Constants.DEEPLINK, str);
            sharedPreferences$EditorEdit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return sharedPreferences$EditorEdit.commit();
        } catch (Exception e) {
            g().f.b("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    public final boolean Z(String str, int i, String str2) {
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        g().h.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    public final boolean a0(String str, String str2) {
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            g().h.b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            g().h.c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                g().h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean b0(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i) {
                g().k.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean c0(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            Objects.requireNonNull(str, "null reference");
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (this.a.v()) {
                g().h.b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", q3.s(str));
            }
            return false;
        }
        if (b.i.a.f.h.l.da.b() && this.a.h.o(p.f1561j0) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.a.v()) {
                g().h.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        Objects.requireNonNull(str2, "null reference");
        if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
            return true;
        }
        g().h.b("Invalid admob_app_id. Analytics disabled.", q3.s(str2));
        return false;
    }

    public final boolean f0(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z2;
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        }
        String[] strArr3 = c;
        int length = strArr3.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z2 = false;
                break;
            }
            if (str2.startsWith(strArr3[i])) {
                z2 = true;
                break;
            }
            i++;
        }
        if (z2) {
            g().h.c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !e0(str2, strArr) || (strArr2 != null && e0(str2, strArr2))) {
            return true;
        }
        g().h.c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final int h0(String str) {
        if (!m0("user property", str)) {
            return 6;
        }
        if (f0("user property", x5.a, null, str)) {
            return !Z("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    public final int i0(String str, Object obj) {
        return "_ldl".equals(str) ? b0("user property referrer", str, z0(str), obj) : b0("user property", str, z0(str), obj) ? 0 : 7;
    }

    @Override // b.i.a.f.i.b.r5
    @WorkerThread
    public final void m() {
        b();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                g().i.a("Utils falling back to Random for random id");
            }
        }
        this.f.set(jNextLong);
    }

    public final boolean m0(String str, String str2) {
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            g().h.b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            g().h.c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                g().h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final Object n0(String str, Object obj) {
        return "_ldl".equals(str) ? C(z0(str), obj, true, false) : C(z0(str), obj, false, false);
    }

    public final boolean o0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = b.i.a.f.e.p.b.a(context).a.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager$NameNotFoundException e) {
            g().f.b("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            g().f.b("Error obtaining certificate", e2);
            return true;
        }
    }

    @WorkerThread
    public final boolean p0(String str) {
        b();
        if (b.i.a.f.e.p.b.a(this.a.f1570b).a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        g().m.b("Permission not granted", str);
        return false;
    }

    @Override // b.i.a.f.i.b.r5
    public final boolean r() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:29:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    /* JADX WARN: Code duplicated, block: B:32:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x008c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0095  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a9  */
    @WorkerThread
    public final int s(String str, String str2, String str3, Object obj, Bundle bundle, @Nullable List<String> list, boolean z2, boolean z3) {
        int i;
        int size;
        boolean z4;
        ArrayList arrayList;
        Parcelable[] parcelableArr;
        b();
        boolean z5 = true;
        if (!W(obj)) {
            i = 0;
        } else {
            if (!z3) {
                return 21;
            }
            if (!e0(str3, u5.c)) {
                return 20;
            }
            q7 q7VarX = this.a.x();
            q7VarX.b();
            q7VarX.t();
            if (!(!q7VarX.G() || q7VarX.e().y0() >= 200900)) {
                return 25;
            }
            boolean z6 = obj instanceof Parcelable[];
            if (z6) {
                size = ((Parcelable[]) obj).length;
            } else {
                if (obj instanceof ArrayList) {
                    size = ((ArrayList) obj).size();
                } else {
                    z4 = true;
                }
                if (z4) {
                    i = 0;
                } else {
                    if (z6) {
                        parcelableArr = (Parcelable[]) obj;
                        if (parcelableArr.length > 200) {
                            bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                        }
                    } else if (obj instanceof ArrayList) {
                        arrayList = (ArrayList) obj;
                        if (arrayList.size() > 200) {
                            bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                        }
                    }
                    i = 17;
                }
            }
            if (size > 200) {
                g().k.d("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                if (z6) {
                    parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i = 17;
            } else {
                i = 0;
            }
        }
        if (b0("param", str3, ((this.a.h.u(str, p.R) && r0(str2)) || r0(str3)) ? 256 : 100, obj)) {
            return i;
        }
        if (!z3) {
            return 4;
        }
        if (obj instanceof Bundle) {
            T(str, str2, str3, (Bundle) obj, list, z2);
        } else if (!(obj instanceof Parcelable[])) {
            if (!(obj instanceof ArrayList)) {
                z5 = false;
                break;
            }
            ArrayList arrayList2 = (ArrayList) obj;
            int size2 = arrayList2.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                int i3 = i2 + 1;
                if (!(obj2 instanceof Bundle)) {
                    g().k.c("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str3);
                    z5 = false;
                    break;
                }
                T(str, str2, str3, (Bundle) obj2, list, z2);
                i2 = i3;
            }
        } else {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    g().k.c("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                    z5 = false;
                    break;
                }
                T(str, str2, str3, (Bundle) parcelable, list, z2);
            }
        }
        if (z5) {
            return i;
        }
        return 4;
    }

    public final boolean s0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.a.h.h("debug.firebase.analytics.app", "").equals(str);
    }

    public final int t(String str, boolean z2) {
        if (!m0("event", str)) {
            return 2;
        }
        if (z2) {
            if (!f0("event", v5.a, v5.f1577b, str)) {
                return 13;
            }
        } else if (!f0("event", v5.a, null, str)) {
            return 13;
        }
        return !Z("event", 40, str) ? 2 : 0;
    }

    public final long t0() {
        long andIncrement;
        long j;
        if (this.f.get() != 0) {
            synchronized (this.f) {
                this.f.compareAndSet(-1L, 1L);
                andIncrement = this.f.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f) {
            long jNanoTime = System.nanoTime();
            Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i = this.g + 1;
            this.g = i;
            j = jNextLong + ((long) i);
        }
        return j;
    }

    public final int u0(String str) {
        if (!a0("event param", str)) {
            return 3;
        }
        if (f0("event param", null, null, str)) {
            return !Z("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    @WorkerThread
    public final SecureRandom v0() {
        b();
        if (this.e == null) {
            this.e = new SecureRandom();
        }
        return this.e;
    }

    public final int w0(String str) {
        if (!m0("event param", str)) {
            return 3;
        }
        if (f0("event param", null, null, str)) {
            return !Z("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public final Bundle x(@NonNull Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(Constants.MEDIUM, queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("term", queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("content", queryParameter6);
            }
            String queryParameter7 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("aclid", queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("cp1", queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("anid", queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            g().i.b("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final Bundle y(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objD = D(str, bundle.get(str));
                if (objD == null) {
                    g().k.b("Param value can't be null", d().x(str));
                } else {
                    I(bundle2, str, objD);
                }
            }
        }
        return bundle2;
    }

    public final int y0() {
        if (this.h == null) {
            b.i.a.f.e.c cVar = b.i.a.f.e.c.f1346b;
            Context context = this.a.f1570b;
            Objects.requireNonNull(cVar);
            AtomicBoolean atomicBoolean = b.i.a.f.e.e.a;
            int i = 0;
            try {
                i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager$NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.h = Integer.valueOf(i / 1000);
        }
        return this.h.intValue();
    }

    public final Bundle z(String str, String str2, Bundle bundle, @Nullable List list, boolean z2) {
        int iU0;
        int i;
        t9 t9Var = this;
        boolean zE0 = e0(str2, v5.d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iT = t9Var.a.h.t();
        int i2 = 0;
        for (String str3 : t9Var.a.h.u(str, p.Z) ? new TreeSet<>(bundle.keySet()) : bundle.keySet()) {
            if (list == null || !list.contains(str3)) {
                iU0 = z2 ? t9Var.u0(str3) : 0;
                if (iU0 == 0) {
                    iU0 = t9Var.w0(str3);
                }
            } else {
                iU0 = 0;
            }
            if (iU0 != 0) {
                F(bundle2, iU0, str3, iU0 == 3 ? str3 : null);
                bundle2.remove(str3);
                i = iT;
            } else {
                i = iT;
                int iS = s(str, str2, str3, bundle.get(str3), bundle2, list, z2, zE0);
                if (iS == 17) {
                    F(bundle2, iS, str3, Boolean.FALSE);
                } else if (iS != 0 && !"_ev".equals(str3)) {
                    F(bundle2, iS, iS == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (X(str3)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Event can't contain more than ");
                        sb.append(i);
                        sb.append(" params");
                        g().h.c(sb.toString(), d().u(str2), d().s(bundle));
                        l0(bundle2, 5);
                        bundle2.remove(str3);
                        i2 = i3;
                    } else {
                        i2 = i3;
                    }
                }
                iT = i;
                t9Var = this;
            }
            iT = i;
            t9Var = this;
        }
        return bundle2;
    }

    public final int z0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (this.a.h.o(p.f1559h0) && "_lgclid".equals(str)) ? 100 : 36;
    }
}
