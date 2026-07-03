package p007b.p225i.p226a.p288f.p330i.p332b;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.C3260e;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3630da;
import p007b.p225i.p226a.p288f.p313h.p325l.C3684h8;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3670g8;

/* JADX INFO: renamed from: b.i.a.f.i.b.t9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4196t9 extends AbstractC4170r5 {

    /* JADX INFO: renamed from: c */
    public static final String[] f11231c = {"firebase_", "google_", "ga_"};

    /* JADX INFO: renamed from: d */
    public static final String[] f11232d = {"_err"};

    /* JADX INFO: renamed from: e */
    public SecureRandom f11233e;

    /* JADX INFO: renamed from: f */
    public final AtomicLong f11234f;

    /* JADX INFO: renamed from: g */
    public int f11235g;

    /* JADX INFO: renamed from: h */
    public Integer f11236h;

    public C4196t9(C4202u4 c4202u4) {
        super(c4202u4);
        this.f11236h = null;
        this.f11234f = new AtomicLong(0L);
    }

    /* JADX INFO: renamed from: A */
    public static Bundle m5871A(List<zzku> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzku zzkuVar : list) {
            String str = zzkuVar.f20674n;
            if (str != null) {
                bundle.putString(zzkuVar.f20671k, str);
            } else {
                Long l = zzkuVar.f20673m;
                if (l != null) {
                    bundle.putLong(zzkuVar.f20671k, l.longValue());
                } else {
                    Double d = zzkuVar.f20676p;
                    if (d != null) {
                        bundle.putDouble(zzkuVar.f20671k, d.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    /* JADX INFO: renamed from: E */
    public static String m5872E(String str, int i, boolean z2) {
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

    /* JADX INFO: renamed from: F */
    public static void m5873F(Bundle bundle, int i, String str, Object obj) {
        if (m5883l0(bundle, i)) {
            bundle.putString("_ev", m5872E(str, 40, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    /* JADX INFO: renamed from: U */
    public static boolean m5874U(Context context) {
        Objects.requireNonNull(context, "null reference");
        return Build.VERSION.SDK_INT >= 24 ? m5882k0(context, "com.google.android.gms.measurement.AppMeasurementJobService") : m5882k0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: renamed from: V */
    public static boolean m5875V(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* JADX INFO: renamed from: W */
    public static boolean m5876W(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* JADX INFO: renamed from: X */
    public static boolean m5877X(String str) {
        C1460d.m583w(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: renamed from: d0 */
    public static boolean m5878d0(String str, String str2, String str3, String str4) {
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

    /* JADX INFO: renamed from: e0 */
    public static boolean m5879e0(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (m5884q0(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g0 */
    public static byte[] m5880g0(Parcelable parcelable) {
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

    /* JADX INFO: renamed from: j0 */
    public static ArrayList<Bundle> m5881j0(List<zzz> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzz zzzVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzzVar.f20700j);
            bundle.putString("origin", zzzVar.f20701k);
            bundle.putLong("creation_timestamp", zzzVar.f20703m);
            bundle.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, zzzVar.f20702l.f20671k);
            C3404f.m4282d2(bundle, zzzVar.f20702l.m9117w0());
            bundle.putBoolean("active", zzzVar.f20704n);
            String str = zzzVar.f20705o;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaq zzaqVar = zzzVar.f20706p;
            if (zzaqVar != null) {
                bundle.putString("timed_out_event_name", zzaqVar.f20666j);
                zzap zzapVar = zzzVar.f20706p.f20667k;
                if (zzapVar != null) {
                    bundle.putBundle("timed_out_event_params", zzapVar.m9114x0());
                }
            }
            bundle.putLong("trigger_timeout", zzzVar.f20707q);
            zzaq zzaqVar2 = zzzVar.f20708r;
            if (zzaqVar2 != null) {
                bundle.putString("triggered_event_name", zzaqVar2.f20666j);
                zzap zzapVar2 = zzzVar.f20708r.f20667k;
                if (zzapVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzapVar2.m9114x0());
                }
            }
            bundle.putLong("triggered_timestamp", zzzVar.f20702l.f20672l);
            bundle.putLong("time_to_live", zzzVar.f20709s);
            zzaq zzaqVar3 = zzzVar.f20710t;
            if (zzaqVar3 != null) {
                bundle.putString("expired_event_name", zzaqVar3.f20666j);
                zzap zzapVar3 = zzzVar.f20710t.f20667k;
                if (zzapVar3 != null) {
                    bundle.putBundle("expired_event_params", zzapVar3.m9114x0());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: k0 */
    public static boolean m5882k0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX INFO: renamed from: l0 */
    public static boolean m5883l0(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    /* JADX INFO: renamed from: q0 */
    public static boolean m5884q0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX INFO: renamed from: r0 */
    public static boolean m5885r0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* JADX INFO: renamed from: u */
    public static long m5886u(long j, long j2) {
        return ((j2 * 60000) + j) / 86400000;
    }

    /* JADX INFO: renamed from: v */
    public static long m5887v(zzap zzapVar) {
        long length = 0;
        if (zzapVar == null) {
            return 0L;
        }
        Iterator<String> it = zzapVar.f20665j.keySet().iterator();
        while (it.hasNext()) {
            Object objM9113w0 = zzapVar.m9113w0(it.next());
            if (objM9113w0 instanceof Parcelable[]) {
                length += (long) ((Parcelable[]) objM9113w0).length;
            }
        }
        return length;
    }

    /* JADX INFO: renamed from: w */
    public static long m5888w(byte[] bArr) {
        Objects.requireNonNull(bArr, "null reference");
        int i = 0;
        C1460d.m432F(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
        }
        return j;
    }

    /* JADX INFO: renamed from: x0 */
    public static MessageDigest m5889x0() {
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

    /* JADX INFO: renamed from: B */
    public final zzaq m5890B(String str, String str2, Bundle bundle, String str3, long j, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m5921t(str2, z3) != 0) {
            mo5726g().f11141f.m5861b("Invalid conditional property event name", m5865d().m5769y(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleM5929z = m5929z(str, str2, bundle2, Collections.singletonList("_o"), false);
        if (z2) {
            bundleM5929z = m5927y(bundleM5929z);
        }
        return new zzaq(str2, new zzap(bundleM5929z), str3, j);
    }

    /* JADX INFO: renamed from: C */
    public final Object m5891C(int i, Object obj, boolean z2, boolean z3) {
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
            return m5872E(String.valueOf(obj), i, z2);
        }
        if (!z3 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleM5927y = m5927y((Bundle) parcelable);
                if (!bundleM5927y.isEmpty()) {
                    arrayList.add(bundleM5927y);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: renamed from: D */
    public final Object m5892D(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m5891C(256, obj, true, true);
        }
        return m5891C(m5885r0(str) ? 256 : 100, obj, false, true);
    }

    @WorkerThread
    /* JADX INFO: renamed from: G */
    public final void m5893G(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            mo5726g().f11144i.m5861b("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    /* JADX INFO: renamed from: H */
    public final void m5894H(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                m5866e().m5895I(bundle, str, bundle2.get(str));
            }
        }
    }

    /* JADX INFO: renamed from: I */
    public final void m5895I(Bundle bundle, String str, Object obj) {
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
            mo5726g().f11146k.m5862c("Not putting event parameter. Invalid value type. name, type", m5865d().m5768x(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    /* JADX INFO: renamed from: J */
    public final void m5896J(InterfaceC3660fc interfaceC3660fc, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            interfaceC3660fc.mo4619f(bundle);
        } catch (RemoteException e) {
            this.f11202a.mo5726g().f11144i.m5861b("Error returning int value to wrapper", e);
        }
    }

    /* JADX INFO: renamed from: K */
    public final void m5897K(InterfaceC3660fc interfaceC3660fc, long j) {
        try {
            interfaceC3660fc.mo4619f(C1643a.m832T("r", j));
        } catch (RemoteException e) {
            this.f11202a.mo5726g().f11144i.m5861b("Error returning long value to wrapper", e);
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m5898L(InterfaceC3660fc interfaceC3660fc, Bundle bundle) {
        try {
            interfaceC3660fc.mo4619f(bundle);
        } catch (RemoteException e) {
            this.f11202a.mo5726g().f11144i.m5861b("Error returning bundle value to wrapper", e);
        }
    }

    /* JADX INFO: renamed from: M */
    public final void m5899M(InterfaceC3660fc interfaceC3660fc, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            interfaceC3660fc.mo4619f(bundle);
        } catch (RemoteException e) {
            this.f11202a.mo5726g().f11144i.m5861b("Error returning string value to wrapper", e);
        }
    }

    /* JADX INFO: renamed from: N */
    public final void m5900N(InterfaceC3660fc interfaceC3660fc, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            interfaceC3660fc.mo4619f(bundle);
        } catch (RemoteException e) {
            this.f11202a.mo5726g().f11144i.m5861b("Error returning bundle list to wrapper", e);
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m5901O(InterfaceC3660fc interfaceC3660fc, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z2);
        try {
            interfaceC3660fc.mo4619f(bundle);
        } catch (RemoteException e) {
            this.f11202a.mo5726g().f11144i.m5861b("Error returning boolean value to wrapper", e);
        }
    }

    /* JADX INFO: renamed from: P */
    public final void m5902P(InterfaceC3660fc interfaceC3660fc, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            interfaceC3660fc.mo4619f(bundle);
        } catch (RemoteException e) {
            this.f11202a.mo5726g().f11144i.m5861b("Error returning byte array to wrapper", e);
        }
    }

    /* JADX INFO: renamed from: Q */
    public final void m5903Q(C4201u3 c4201u3, int i) {
        int i2 = 0;
        for (String str : new TreeSet(c4201u3.f11244d.keySet())) {
            if (m5877X(str) && (i2 = i2 + 1) > i) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i);
                sb.append(" params");
                mo5726g().f11143h.m5862c(sb.toString(), m5865d().m5766u(c4201u3.f11241a), m5865d().m5764s(c4201u3.f11244d));
                m5883l0(c4201u3.f11244d, 5);
                c4201u3.f11244d.remove(str);
            }
        }
    }

    /* JADX INFO: renamed from: R */
    public final void m5904R(InterfaceC4218v9 interfaceC4218v9, int i, String str, String str2, int i2) {
        m5905S(interfaceC4218v9, null, i, str, str2, i2);
    }

    /* JADX INFO: renamed from: S */
    public final void m5905S(InterfaceC4218v9 interfaceC4218v9, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m5883l0(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        if (((InterfaceC3670g8) C3684h8.f9995j.mo4555a()).mo4916a() && this.f11202a.f11260h.m5526o(C4142p.f11049O0)) {
            interfaceC4218v9.mo5762a(str, bundle);
        } else {
            this.f11202a.m5948s().m5545H("auto", "_err", bundle);
        }
    }

    /* JADX INFO: renamed from: T */
    public final void m5906T(String str, String str2, String str3, Bundle bundle, @Nullable List<String> list, boolean z2) {
        int iM5923u0;
        int iM5919s;
        if (bundle == null) {
            return;
        }
        int i = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str4)) {
                iM5923u0 = z2 ? m5923u0(str4) : 0;
                if (iM5923u0 == 0) {
                    iM5923u0 = m5925w0(str4);
                }
            } else {
                iM5923u0 = 0;
            }
            if (iM5923u0 != 0) {
                m5873F(bundle, iM5923u0, str4, iM5923u0 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (m5876W(bundle.get(str4))) {
                    mo5726g().f11146k.m5863d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    iM5919s = 22;
                } else {
                    iM5919s = m5919s(str, str2, str4, bundle.get(str4), bundle, list, z2, false);
                }
                if (iM5919s != 0 && !"_ev".equals(str4)) {
                    m5873F(bundle, iM5919s, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (m5877X(str4) && !m5879e0(str4, C4203u5.f11282d) && (i = i + 1) > 0) {
                    mo5726g().f11143h.m5862c("Item cannot contain custom parameters", m5865d().m5766u(str2), m5865d().m5764s(bundle));
                    m5883l0(bundle, 23);
                    bundle.remove(str4);
                }
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* JADX INFO: renamed from: Y */
    public final boolean m5907Y(String str, double d) {
        try {
            SharedPreferences.Editor editorEdit = this.f11202a.f11254b.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString(Constants.DEEPLINK, str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return editorEdit.commit();
        } catch (Exception e) {
            mo5726g().f11141f.m5861b("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: Z */
    public final boolean m5908Z(String str, int i, String str2) {
        if (str2 == null) {
            mo5726g().f11143h.m5861b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        mo5726g().f11143h.m5863d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    /* JADX INFO: renamed from: a0 */
    public final boolean m5909a0(String str, String str2) {
        if (str2 == null) {
            mo5726g().f11143h.m5861b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo5726g().f11143h.m5861b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            mo5726g().f11143h.m5862c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                mo5726g().f11143h.m5862c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    /* JADX INFO: renamed from: b0 */
    public final boolean m5910b0(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i) {
                mo5726g().f11146k.m5863d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: c0 */
    public final boolean m5911c0(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            Objects.requireNonNull(str, "null reference");
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (this.f11202a.m5951v()) {
                mo5726g().f11143h.m5861b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C4157q3.m5788s(str));
            }
            return false;
        }
        if (C3630da.m4644b() && this.f11202a.f11260h.m5526o(C4142p.f11080j0) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.f11202a.m5951v()) {
                mo5726g().f11143h.m5860a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        Objects.requireNonNull(str2, "null reference");
        if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
            return true;
        }
        mo5726g().f11143h.m5861b("Invalid admob_app_id. Analytics disabled.", C4157q3.m5788s(str2));
        return false;
    }

    /* JADX INFO: renamed from: f0 */
    public final boolean m5912f0(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z2;
        if (str2 == null) {
            mo5726g().f11143h.m5861b("Name is required and can't be null. Type", str);
            return false;
        }
        String[] strArr3 = f11231c;
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
            mo5726g().f11143h.m5862c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !m5879e0(str2, strArr) || (strArr2 != null && m5879e0(str2, strArr2))) {
            return true;
        }
        mo5726g().f11143h.m5862c("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* JADX INFO: renamed from: h0 */
    public final int m5913h0(String str) {
        if (!m5915m0("user property", str)) {
            return 6;
        }
        if (m5912f0("user property", C4236x5.f11341a, null, str)) {
            return !m5908Z("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    /* JADX INFO: renamed from: i0 */
    public final int m5914i0(String str, Object obj) {
        return "_ldl".equals(str) ? m5910b0("user property referrer", str, m5930z0(str), obj) : m5910b0("user property", str, m5930z0(str), obj) ? 0 : 7;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    @WorkerThread
    /* JADX INFO: renamed from: m */
    public final void mo5573m() {
        mo5848b();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                mo5726g().f11144i.m5860a("Utils falling back to Random for random id");
            }
        }
        this.f11234f.set(jNextLong);
    }

    /* JADX INFO: renamed from: m0 */
    public final boolean m5915m0(String str, String str2) {
        if (str2 == null) {
            mo5726g().f11143h.m5861b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo5726g().f11143h.m5861b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            mo5726g().f11143h.m5862c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                mo5726g().f11143h.m5862c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    /* JADX INFO: renamed from: n0 */
    public final Object m5916n0(String str, Object obj) {
        return "_ldl".equals(str) ? m5891C(m5930z0(str), obj, true, false) : m5891C(m5930z0(str), obj, false, false);
    }

    /* JADX INFO: renamed from: o0 */
    public final boolean m5917o0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = C3411b.m4376a(context).f9605a.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            mo5726g().f11141f.m5861b("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            mo5726g().f11141f.m5861b("Error obtaining certificate", e2);
            return true;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: p0 */
    public final boolean m5918p0(String str) {
        mo5848b();
        if (C3411b.m4376a(this.f11202a.f11254b).f9605a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        mo5726g().f11148m.m5861b("Permission not granted", str);
        return false;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    /* JADX INFO: renamed from: r */
    public final boolean mo5574r() {
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
    /* JADX INFO: renamed from: s */
    public final int m5919s(String str, String str2, String str3, Object obj, Bundle bundle, @Nullable List<String> list, boolean z2, boolean z3) {
        int i;
        int size;
        boolean z4;
        ArrayList arrayList;
        Parcelable[] parcelableArr;
        mo5848b();
        boolean z5 = true;
        if (!m5876W(obj)) {
            i = 0;
        } else {
            if (!z3) {
                return 21;
            }
            if (!m5879e0(str3, C4203u5.f11281c)) {
                return 20;
            }
            C4161q7 c4161q7M5953x = this.f11202a.m5953x();
            c4161q7M5953x.mo5848b();
            c4161q7M5953x.m5497t();
            if (!(!c4161q7M5953x.m5809G() || c4161q7M5953x.m5866e().m5928y0() >= 200900)) {
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
                mo5726g().f11146k.m5863d("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
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
        if (m5910b0("param", str3, ((this.f11202a.f11260h.m5532u(str, C4142p.f11052R) && m5885r0(str2)) || m5885r0(str3)) ? 256 : 100, obj)) {
            return i;
        }
        if (!z3) {
            return 4;
        }
        if (obj instanceof Bundle) {
            m5906T(str, str2, str3, (Bundle) obj, list, z2);
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
                    mo5726g().f11146k.m5862c("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str3);
                    z5 = false;
                    break;
                }
                m5906T(str, str2, str3, (Bundle) obj2, list, z2);
                i2 = i3;
            }
        } else {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    mo5726g().f11146k.m5862c("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                    z5 = false;
                    break;
                }
                m5906T(str, str2, str3, (Bundle) parcelable, list, z2);
            }
        }
        if (z5) {
            return i;
        }
        return 4;
    }

    /* JADX INFO: renamed from: s0 */
    public final boolean m5920s0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f11202a.f11260h.m5523h("debug.firebase.analytics.app", "").equals(str);
    }

    /* JADX INFO: renamed from: t */
    public final int m5921t(String str, boolean z2) {
        if (!m5915m0("event", str)) {
            return 2;
        }
        if (z2) {
            if (!m5912f0("event", C4214v5.f11304a, C4214v5.f11305b, str)) {
                return 13;
            }
        } else if (!m5912f0("event", C4214v5.f11304a, null, str)) {
            return 13;
        }
        return !m5908Z("event", 40, str) ? 2 : 0;
    }

    /* JADX INFO: renamed from: t0 */
    public final long m5922t0() {
        long andIncrement;
        long j;
        if (this.f11234f.get() != 0) {
            synchronized (this.f11234f) {
                this.f11234f.compareAndSet(-1L, 1L);
                andIncrement = this.f11234f.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f11234f) {
            long jNanoTime = System.nanoTime();
            Objects.requireNonNull((C3401c) this.f11202a.f11267o);
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i = this.f11235g + 1;
            this.f11235g = i;
            j = jNextLong + ((long) i);
        }
        return j;
    }

    /* JADX INFO: renamed from: u0 */
    public final int m5923u0(String str) {
        if (!m5909a0("event param", str)) {
            return 3;
        }
        if (m5912f0("event param", null, null, str)) {
            return !m5908Z("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    @WorkerThread
    /* JADX INFO: renamed from: v0 */
    public final SecureRandom m5924v0() {
        mo5848b();
        if (this.f11233e == null) {
            this.f11233e = new SecureRandom();
        }
        return this.f11233e;
    }

    /* JADX INFO: renamed from: w0 */
    public final int m5925w0(String str) {
        if (!m5915m0("event param", str)) {
            return 3;
        }
        if (m5912f0("event param", null, null, str)) {
            return !m5908Z("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    /* JADX INFO: renamed from: x */
    public final Bundle m5926x(@NonNull Uri uri) {
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
            mo5726g().f11144i.m5861b("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: y */
    public final Bundle m5927y(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objM5892D = m5892D(str, bundle.get(str));
                if (objM5892D == null) {
                    mo5726g().f11146k.m5861b("Param value can't be null", m5865d().m5768x(str));
                } else {
                    m5895I(bundle2, str, objM5892D);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: renamed from: y0 */
    public final int m5928y0() {
        if (this.f11236h == null) {
            C3256c c3256c = C3256c.f9307b;
            Context context = this.f11202a.f11254b;
            Objects.requireNonNull(c3256c);
            AtomicBoolean atomicBoolean = C3260e.f9309a;
            int i = 0;
            try {
                i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.f11236h = Integer.valueOf(i / 1000);
        }
        return this.f11236h.intValue();
    }

    /* JADX INFO: renamed from: z */
    public final Bundle m5929z(String str, String str2, Bundle bundle, @Nullable List list, boolean z2) {
        int iM5923u0;
        int i;
        C4196t9 c4196t9 = this;
        boolean zM5879e0 = m5879e0(str2, C4214v5.f11307d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iM5531t = c4196t9.f11202a.f11260h.m5531t();
        int i2 = 0;
        for (String str3 : c4196t9.f11202a.f11260h.m5532u(str, C4142p.f11060Z) ? new TreeSet<>(bundle.keySet()) : bundle.keySet()) {
            if (list == null || !list.contains(str3)) {
                iM5923u0 = z2 ? c4196t9.m5923u0(str3) : 0;
                if (iM5923u0 == 0) {
                    iM5923u0 = c4196t9.m5925w0(str3);
                }
            } else {
                iM5923u0 = 0;
            }
            if (iM5923u0 != 0) {
                m5873F(bundle2, iM5923u0, str3, iM5923u0 == 3 ? str3 : null);
                bundle2.remove(str3);
                i = iM5531t;
            } else {
                i = iM5531t;
                int iM5919s = m5919s(str, str2, str3, bundle.get(str3), bundle2, list, z2, zM5879e0);
                if (iM5919s == 17) {
                    m5873F(bundle2, iM5919s, str3, Boolean.FALSE);
                } else if (iM5919s != 0 && !"_ev".equals(str3)) {
                    m5873F(bundle2, iM5919s, iM5919s == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (m5877X(str3)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Event can't contain more than ");
                        sb.append(i);
                        sb.append(" params");
                        mo5726g().f11143h.m5862c(sb.toString(), m5865d().m5766u(str2), m5865d().m5764s(bundle));
                        m5883l0(bundle2, 5);
                        bundle2.remove(str3);
                        i2 = i3;
                    } else {
                        i2 = i3;
                    }
                }
                iM5531t = i;
                c4196t9 = this;
            }
            iM5531t = i;
            c4196t9 = this;
        }
        return bundle2;
    }

    /* JADX INFO: renamed from: z0 */
    public final int m5930z0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (this.f11202a.f11260h.m5526o(C4142p.f11076h0) && "_lgclid".equals(str)) ? 100 : 36;
    }
}
