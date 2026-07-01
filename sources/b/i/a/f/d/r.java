package b.i.a.f.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1342b;
    public int c = 0;

    public r(Context context) {
        this.a = context;
    }

    public final synchronized int a() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (b.i.a.f.e.p.b.a(this.a).a.getPackageManager().checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!b.i.a.f.e.o.f.A0()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.c = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.c = 2;
            return 2;
        }
        Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
        if (b.i.a.f.e.o.f.A0()) {
            this.c = 2;
        } else {
            this.c = 1;
        }
        return this.c;
    }

    @Nullable
    public final PackageInfo b(String str) {
        try {
            return b.i.a.f.e.p.b.a(this.a).a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager$NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            b.d.b.a.a.h0(strValueOf.length() + 23, "Failed to find package ", strValueOf, "Metadata");
            return null;
        }
    }
}
