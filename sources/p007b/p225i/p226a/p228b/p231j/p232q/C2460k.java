package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.b.j.q.k */
/* JADX INFO: compiled from: MetadataBackendRegistry.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2460k implements InterfaceC2454e {

    /* JADX INFO: renamed from: a */
    public final a f5318a;

    /* JADX INFO: renamed from: b */
    public final C2458i f5319b;

    /* JADX INFO: renamed from: c */
    public final Map<String, InterfaceC2462m> f5320c;

    /* JADX INFO: renamed from: b.i.a.b.j.q.k$a */
    /* JADX INFO: compiled from: MetadataBackendRegistry.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final Context f5321a;

        /* JADX INFO: renamed from: b */
        public Map<String, String> f5322b = null;

        public a(Context context) {
            this.f5321a = context;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003a  */
        /* JADX WARN: Code duplicated, block: B:17:0x0044  */
        /* JADX WARN: Code duplicated, block: B:20:0x0057  */
        @Nullable
        /* JADX INFO: renamed from: a */
        public InterfaceC2453d m2371a(String str) {
            Bundle bundle;
            Map<String, String> mapEmptyMap;
            Object obj;
            if (this.f5322b == null) {
                Context context = this.f5321a;
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
                        this.f5322b = mapEmptyMap;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
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
                this.f5322b = mapEmptyMap;
            }
            String str4 = this.f5322b.get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (InterfaceC2453d) Class.forName(str4).asSubclass(InterfaceC2453d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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

    public C2460k(Context context, C2458i c2458i) {
        a aVar = new a(context);
        this.f5320c = new HashMap();
        this.f5318a = aVar;
        this.f5319b = c2458i;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2454e
    @Nullable
    public synchronized InterfaceC2462m get(String str) {
        if (this.f5320c.containsKey(str)) {
            return this.f5320c.get(str);
        }
        InterfaceC2453d interfaceC2453dM2371a = this.f5318a.m2371a(str);
        if (interfaceC2453dM2371a == null) {
            return null;
        }
        C2458i c2458i = this.f5319b;
        InterfaceC2462m interfaceC2462mCreate = interfaceC2453dM2371a.create(new C2452c(c2458i.f5312a, c2458i.f5313b, c2458i.f5314c, str));
        this.f5320c.put(str, interfaceC2462mCreate);
        return interfaceC2462mCreate;
    }
}
