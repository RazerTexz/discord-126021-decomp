package b.i.c.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Callable {
    public final Context j;
    public final Intent k;

    public b(Context context, Intent intent) {
        this.j = context;
        this.k = intent;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        ServiceInfo serviceInfo;
        String str2;
        int i;
        ComponentName componentNameStartService;
        Context context = this.j;
        Intent intent = this.k;
        v vVarA = v.a();
        Objects.requireNonNull(vVarA);
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Starting service");
        }
        vVarA.e.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        synchronized (vVarA) {
            str = vVarA.f1774b;
            if (str == null) {
                ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent2, 0);
                if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                    Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                } else if (!context.getPackageName().equals(serviceInfo.packageName) || (str2 = serviceInfo.name) == null) {
                    String str3 = serviceInfo.packageName;
                    String str4 = serviceInfo.name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
                    sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                    sb.append(str3);
                    sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                    sb.append(str4);
                    Log.e("FirebaseInstanceId", sb.toString());
                } else {
                    if (str2.startsWith(".")) {
                        String strValueOf = String.valueOf(context.getPackageName());
                        String strValueOf2 = String.valueOf(serviceInfo.name);
                        vVarA.f1774b = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                    } else {
                        vVarA.f1774b = serviceInfo.name;
                    }
                    str = vVarA.f1774b;
                }
                str = null;
            }
        }
        if (str != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", str.length() != 0 ? "Restricting intent to a specific service: ".concat(str) : new String("Restricting intent to a specific service: "));
            }
            intent2.setClassName(context.getPackageName(), str);
        }
        try {
            if (vVarA.c(context)) {
                componentNameStartService = y.a(context, intent2);
            } else {
                componentNameStartService = context.startService(intent2);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService == null) {
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                i = 404;
            } else {
                i = -1;
            }
        } catch (IllegalStateException e) {
            String strValueOf3 = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 45);
            sb2.append("Failed to start service while in background: ");
            sb2.append(strValueOf3);
            Log.e("FirebaseInstanceId", sb2.toString());
            i = 402;
        } catch (SecurityException e2) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e2);
            i = 401;
        }
        return Integer.valueOf(i);
    }
}
