package p007b.p225i.p226a.p288f.p298d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.d.r */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3243r {

    /* JADX INFO: renamed from: a */
    public final Context f9283a;

    /* JADX INFO: renamed from: b */
    public int f9284b;

    /* JADX INFO: renamed from: c */
    public int f9285c = 0;

    public C3243r(Context context) {
        this.f9283a = context;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized int m4010a() {
        int i = this.f9285c;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.f9283a.getPackageManager();
        if (C3411b.m4376a(this.f9283a).f9605a.getPackageManager().checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!C3404f.m4190A0()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f9285c = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f9285c = 2;
            return 2;
        }
        Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
        if (C3404f.m4190A0()) {
            this.f9285c = 2;
        } else {
            this.f9285c = 1;
        }
        return this.f9285c;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public final PackageInfo m4011b(String str) {
        try {
            return C3411b.m4376a(this.f9283a).f9605a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            C1643a.m854h0(strValueOf.length() + 23, "Failed to find package ", strValueOf, "Metadata");
            return null;
        }
    }
}
