package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.f.h.l.j2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3706j2 {

    /* JADX INFO: renamed from: a */
    public static volatile AbstractC3888x2<Boolean> f10029a = C3875w2.f10378j;

    /* JADX INFO: renamed from: b */
    public static final Object f10030b = new Object();

    /* JADX INFO: renamed from: a */
    public static boolean m4968a(Context context, Uri uri) {
        ProviderInfo providerInfoResolveContentProvider;
        boolean z2;
        String authority = uri.getAuthority();
        boolean z3 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        }
        if (f10029a.mo5342b()) {
            return f10029a.mo5343c().booleanValue();
        }
        synchronized (f10030b) {
            if (f10029a.mo5342b()) {
                return f10029a.mo5343c().booleanValue();
            }
            if ("com.google.android.gms".equals(context.getPackageName()) || ((providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName))) {
                try {
                    z2 = (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & Opcodes.LOR) != 0;
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (z2) {
                    z3 = true;
                }
            }
            f10029a = AbstractC3888x2.m5355a(Boolean.valueOf(z3));
            return f10029a.mo5343c().booleanValue();
        }
    }
}
