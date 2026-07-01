package b.i.a.b.j.q;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MetadataBackendRegistry.java */
/* JADX INFO: loaded from: classes3.dex */
public class k$a {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f777b = null;

    public k$a(Context context) {
        this.a = context;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:20:0x0057  */
    @Nullable
    public d a(String str) {
        Bundle bundle;
        Map<String, String> mapEmptyMap;
        Object obj;
        if (this.f777b == null) {
            Context context = this.a;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                    if (bundle == null) {
                        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                        mapEmptyMap = Collections.emptyMap();
                    } else {
                        HashMap map = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            obj = bundle.get(str2);
                            if (!(obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String strTrim = str3.trim();
                                    if (!strTrim.isEmpty()) {
                                        map.put(strTrim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        mapEmptyMap = map;
                    }
                    this.f777b = mapEmptyMap;
                }
            } catch (PackageManager$NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
            }
            bundle = null;
            if (bundle == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                mapEmptyMap = Collections.emptyMap();
            } else {
                HashMap map2 = new HashMap();
                while (r7.hasNext()) {
                    obj = bundle.get(str2);
                    if (!(obj instanceof String)) {
                    }
                }
                mapEmptyMap = map2;
            }
            this.f777b = mapEmptyMap;
        }
        String str4 = this.f777b.get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (d) Class.forName(str4).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            Log.w("BackendRegistry", String.format("Class %s is not found.", str4), e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.w("BackendRegistry", String.format("Could not instantiate %s.", str4), e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w("BackendRegistry", String.format("Could not instantiate %s.", str4), e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w("BackendRegistry", String.format("Could not instantiate %s", str4), e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w("BackendRegistry", String.format("Could not instantiate %s", str4), e5);
            return null;
        }
    }
}
