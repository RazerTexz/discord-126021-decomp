package b.i.a.f.h.l;

import android.net.Uri;
import android.util.Log;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l2<T> {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile t2 f1456b;
    public static u2 c;
    public static final AtomicInteger d;
    public final q2 e;
    public final String f;
    public final T g;
    public volatile int h = -1;
    public volatile T i;
    public final boolean j;

    static {
        new AtomicReference();
        c = new u2(n2.a);
        d = new AtomicInteger();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l2(q2 q2Var, String str, Object obj, boolean z2, m2 m2Var) {
        if (q2Var.a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.e = q2Var;
        this.f = str;
        this.g = obj;
        this.j = z2;
    }

    public abstract T a(Object obj);

    public final String b(String str) {
        if (str != null && str.isEmpty()) {
            return this.f;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.f);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    public final String c() {
        Objects.requireNonNull(this.e);
        return b("");
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
    public final T d() {
        T tA;
        Object objG;
        x2<h2> x2VarA;
        h2 h2VarC;
        Uri uri;
        String str;
        Map<String, String> map;
        String strValueOf;
        String str2;
        b2 b2VarA;
        Object objG2;
        boolean z2 = true;
        if (!this.j) {
            u2 u2Var = c;
            String str3 = this.f;
            Objects.requireNonNull(u2Var);
            Objects.requireNonNull(str3, "flagName must not be null");
            b.i.a.f.e.o.f.q2(true, "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i = d.get();
        if (this.h < i) {
            synchronized (this) {
                if (this.h < i) {
                    t2 t2Var = f1456b;
                    b.i.a.f.e.o.f.q2(t2Var != null, "Must call PhenotypeFlag.init() first");
                    String str4 = (String) c2.a(t2Var.a()).g("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                    if (str4 == null || !u1.c.matcher(str4).matches()) {
                        z2 = false;
                    }
                    String str5 = null;
                    if (!z2) {
                        if (this.e.a != null) {
                            b2VarA = j2.a(t2Var.a(), this.e.a) ? y1.a(t2Var.a().getContentResolver(), this.e.a) : null;
                        } else {
                            b2VarA = s2.a(t2Var.a());
                        }
                        if (b2VarA != null && (objG2 = b2VarA.g(c())) != null) {
                            tA = a(objG2);
                        }
                        if (tA != null) {
                            c2 c2VarA = c2.a(t2Var.a());
                            Objects.requireNonNull(this.e);
                            objG = c2VarA.g(b(""));
                            if (objG != null) {
                                tA = a(objG);
                            } else {
                                tA = null;
                            }
                            if (tA != null) {
                                tA = this.g;
                            }
                        }
                        x2VarA = t2Var.b().a();
                        if (x2VarA.b()) {
                            h2VarC = x2VarA.c();
                            q2 q2Var = this.e;
                            uri = q2Var.a;
                            Objects.requireNonNull(q2Var);
                            str = this.f;
                            Objects.requireNonNull(h2VarC);
                            if (uri != null) {
                                map = h2VarC.a.get(uri.toString());
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
                                tA = this.g;
                            } else {
                                tA = a(str5);
                            }
                        }
                        this.i = tA;
                        this.h = i;
                    } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                        String strValueOf2 = String.valueOf(c());
                        Log.d("PhenotypeFlag", strValueOf2.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf2) : new String("Bypass reading Phenotype values for flag: "));
                    }
                    tA = null;
                    if (tA != null) {
                        c2 c2VarA2 = c2.a(t2Var.a());
                        Objects.requireNonNull(this.e);
                        objG = c2VarA2.g(b(""));
                        if (objG != null) {
                            tA = a(objG);
                        } else {
                            tA = null;
                        }
                        if (tA != null) {
                            tA = this.g;
                        }
                    }
                    x2VarA = t2Var.b().a();
                    if (x2VarA.b()) {
                        h2VarC = x2VarA.c();
                        q2 q2Var2 = this.e;
                        uri = q2Var2.a;
                        Objects.requireNonNull(q2Var2);
                        str = this.f;
                        Objects.requireNonNull(h2VarC);
                        if (uri != null) {
                            map = h2VarC.a.get(uri.toString());
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
                            tA = this.g;
                        } else {
                            tA = a(str5);
                        }
                    }
                    this.i = tA;
                    this.h = i;
                }
            }
        }
        return this.i;
    }
}
