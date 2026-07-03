package p007b.p225i.p226a.p288f.p313h.p325l;

import android.net.Uri;
import android.util.Log;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.l2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3732l2<T> {

    /* JADX INFO: renamed from: a */
    public static final Object f10069a = new Object();

    /* JADX INFO: renamed from: b */
    public static volatile AbstractC3836t2 f10070b;

    /* JADX INFO: renamed from: c */
    public static C3849u2 f10071c;

    /* JADX INFO: renamed from: d */
    public static final AtomicInteger f10072d;

    /* JADX INFO: renamed from: e */
    public final C3797q2 f10073e;

    /* JADX INFO: renamed from: f */
    public final String f10074f;

    /* JADX INFO: renamed from: g */
    public final T f10075g;

    /* JADX INFO: renamed from: h */
    public volatile int f10076h = -1;

    /* JADX INFO: renamed from: i */
    public volatile T f10077i;

    /* JADX INFO: renamed from: j */
    public final boolean f10078j;

    static {
        new AtomicReference();
        f10071c = new C3849u2(C3758n2.f10109a);
        f10072d = new AtomicInteger();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC3732l2(C3797q2 c3797q2, String str, Object obj, boolean z2, C3745m2 c3745m2) {
        if (c3797q2.f10263a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f10073e = c3797q2;
        this.f10074f = str;
        this.f10075g = obj;
        this.f10078j = z2;
    }

    /* JADX INFO: renamed from: a */
    public abstract T mo5047a(Object obj);

    /* JADX INFO: renamed from: b */
    public final String m5048b(String str) {
        if (str != null && str.isEmpty()) {
            return this.f10074f;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.f10074f);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    /* JADX INFO: renamed from: c */
    public final String m5049c() {
        Objects.requireNonNull(this.f10073e);
        return m5048b("");
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2 A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00db A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e4 A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f6 A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x010c A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x011a  */
    /* JADX WARN: Code duplicated, block: B:57:0x011b A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0125 A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x012a A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0139 A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x013c A[Catch: all -> 0x0146, TryCatch #0 {, blocks: (B:8:0x0021, B:10:0x0025, B:14:0x002d, B:16:0x0044, B:22:0x0055, B:24:0x005b, B:26:0x0069, B:30:0x0086, B:32:0x0090, B:50:0x00e6, B:52:0x00f6, B:54:0x010c, B:57:0x011b, B:59:0x0125, B:61:0x0130, B:60:0x012a, B:63:0x0139, B:64:0x013c, B:65:0x0140, B:43:0x00c2, B:45:0x00db, B:49:0x00e4, B:28:0x007c, B:33:0x0095, B:35:0x009e, B:37:0x00b0, B:39:0x00bb, B:38:0x00b5, B:66:0x0144), top: B:73:0x0021 }] */
    /* JADX INFO: renamed from: d */
    public final T m5050d() {
        T tMo5047a;
        Object objMo4567g;
        AbstractC3888x2<C3678h2> abstractC3888x2Mo4555a;
        C3678h2 c3678h2Mo5343c;
        Uri uri;
        String str;
        Map<String, String> map;
        String strValueOf;
        String str2;
        InterfaceC3594b2 interfaceC3594b2M5213a;
        Object objMo4567g2;
        boolean z2 = true;
        if (!this.f10078j) {
            C3849u2 c3849u2 = f10071c;
            String str3 = this.f10074f;
            Objects.requireNonNull(c3849u2);
            Objects.requireNonNull(str3, "flagName must not be null");
            C3404f.m4334q2(true, "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i = f10072d.get();
        if (this.f10076h < i) {
            synchronized (this) {
                if (this.f10076h < i) {
                    AbstractC3836t2 abstractC3836t2 = f10070b;
                    C3404f.m4334q2(abstractC3836t2 != null, "Must call PhenotypeFlag.init() first");
                    String str4 = (String) C3608c2.m4602a(abstractC3836t2.mo5277a()).mo4567g("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                    if (str4 == null || !C3848u1.f10335c.matcher(str4).matches()) {
                        z2 = false;
                    }
                    String str5 = null;
                    if (!z2) {
                        if (this.f10073e.f10263a != null) {
                            interfaceC3594b2M5213a = C3706j2.m4968a(abstractC3836t2.mo5277a(), this.f10073e.f10263a) ? C3900y1.m5376a(abstractC3836t2.mo5277a().getContentResolver(), this.f10073e.f10263a) : null;
                        } else {
                            interfaceC3594b2M5213a = C3823s2.m5213a(abstractC3836t2.mo5277a());
                        }
                        if (interfaceC3594b2M5213a != null && (objMo4567g2 = interfaceC3594b2M5213a.mo4567g(m5049c())) != null) {
                            tMo5047a = mo5047a(objMo4567g2);
                        }
                        if (tMo5047a != null) {
                            C3608c2 c3608c2M4602a = C3608c2.m4602a(abstractC3836t2.mo5277a());
                            Objects.requireNonNull(this.f10073e);
                            objMo4567g = c3608c2M4602a.mo4567g(m5048b(""));
                            if (objMo4567g != null) {
                                tMo5047a = mo5047a(objMo4567g);
                            } else {
                                tMo5047a = null;
                            }
                            if (tMo5047a != null) {
                                tMo5047a = this.f10075g;
                            }
                        }
                        abstractC3888x2Mo4555a = abstractC3836t2.mo5278b().mo4555a();
                        if (abstractC3888x2Mo4555a.mo5342b()) {
                            c3678h2Mo5343c = abstractC3888x2Mo4555a.mo5343c();
                            C3797q2 c3797q2 = this.f10073e;
                            uri = c3797q2.f10263a;
                            Objects.requireNonNull(c3797q2);
                            str = this.f10074f;
                            Objects.requireNonNull(c3678h2Mo5343c);
                            if (uri != null) {
                                map = c3678h2Mo5343c.f9982a.get(uri.toString());
                                if (map == null) {
                                    strValueOf = String.valueOf(str);
                                    if (strValueOf.length() != 0) {
                                        str2 = "".concat(strValueOf);
                                    } else {
                                        str2 = new String("");
                                    }
                                    str5 = map.get(str2);
                                }
                            }
                            if (str5 == null) {
                                tMo5047a = this.f10075g;
                            } else {
                                tMo5047a = mo5047a(str5);
                            }
                        }
                        this.f10077i = tMo5047a;
                        this.f10076h = i;
                    } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                        String strValueOf2 = String.valueOf(m5049c());
                        Log.d("PhenotypeFlag", strValueOf2.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf2) : new String("Bypass reading Phenotype values for flag: "));
                    }
                    tMo5047a = null;
                    if (tMo5047a != null) {
                        C3608c2 c3608c2M4602a2 = C3608c2.m4602a(abstractC3836t2.mo5277a());
                        Objects.requireNonNull(this.f10073e);
                        objMo4567g = c3608c2M4602a2.mo4567g(m5048b(""));
                        if (objMo4567g != null) {
                            tMo5047a = mo5047a(objMo4567g);
                        } else {
                            tMo5047a = null;
                        }
                        if (tMo5047a != null) {
                            tMo5047a = this.f10075g;
                        }
                    }
                    abstractC3888x2Mo4555a = abstractC3836t2.mo5278b().mo4555a();
                    if (abstractC3888x2Mo4555a.mo5342b()) {
                        c3678h2Mo5343c = abstractC3888x2Mo4555a.mo5343c();
                        C3797q2 c3797q3 = this.f10073e;
                        uri = c3797q3.f10263a;
                        Objects.requireNonNull(c3797q3);
                        str = this.f10074f;
                        Objects.requireNonNull(c3678h2Mo5343c);
                        if (uri != null) {
                            map = c3678h2Mo5343c.f9982a.get(uri.toString());
                            if (map == null) {
                                strValueOf = String.valueOf(str);
                                if (strValueOf.length() != 0) {
                                    str2 = "".concat(strValueOf);
                                } else {
                                    str2 = new String("");
                                }
                                str5 = map.get(str2);
                            }
                        }
                        if (str5 == null) {
                            tMo5047a = this.f10075g;
                        } else {
                            tMo5047a = mo5047a(str5);
                        }
                    }
                    this.f10077i = tMo5047a;
                    this.f10076h = i;
                }
            }
        }
        return this.f10077i;
    }
}
