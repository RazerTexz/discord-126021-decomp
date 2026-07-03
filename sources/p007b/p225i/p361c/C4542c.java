package p007b.p225i.p361c;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.badge.BadgeDrawable;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.ComponentCallbacks2C3281c;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;
import p007b.p225i.p226a.p288f.p299e.p308o.C3405g;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4579k;
import p007b.p225i.p361c.p368l.C4585q;
import p007b.p225i.p361c.p368l.C4586r;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p396q.C4796a;
import p007b.p225i.p361c.p396q.InterfaceC4797b;
import p007b.p225i.p361c.p396q.InterfaceC4798c;
import p007b.p225i.p361c.p400t.InterfaceC4836a;
import p007b.p225i.p361c.p405v.C4862a;

/* JADX INFO: renamed from: b.i.c.c */
/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4542c {

    /* JADX INFO: renamed from: a */
    public static final Object f12115a = new Object();

    /* JADX INFO: renamed from: b */
    public static final Executor f12116b = new d(null);

    /* JADX INFO: renamed from: c */
    public static final Map<String, C4542c> f12117c = new ArrayMap();

    /* JADX INFO: renamed from: d */
    public final Context f12118d;

    /* JADX INFO: renamed from: e */
    public final String f12119e;

    /* JADX INFO: renamed from: f */
    public final C4548i f12120f;

    /* JADX INFO: renamed from: g */
    public final C4579k f12121g;

    /* JADX INFO: renamed from: j */
    public final C4586r<C4862a> f12124j;

    /* JADX INFO: renamed from: h */
    public final AtomicBoolean f12122h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i */
    public final AtomicBoolean f12123i = new AtomicBoolean();

    /* JADX INFO: renamed from: k */
    public final List<b> f12125k = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b.i.c.c$b */
    /* JADX INFO: compiled from: FirebaseApp.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void m6335a(boolean z2);
    }

    /* JADX INFO: renamed from: b.i.c.c$c */
    /* JADX INFO: compiled from: FirebaseApp.java */
    @TargetApi(14)
    public static class c implements ComponentCallbacks2C3281c.a {

        /* JADX INFO: renamed from: a */
        public static AtomicReference<c> f12126a = new AtomicReference<>();

        @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.ComponentCallbacks2C3281c.a
        /* JADX INFO: renamed from: a */
        public void mo4066a(boolean z2) {
            Object obj = C4542c.f12115a;
            synchronized (C4542c.f12115a) {
                for (C4542c c4542c : new ArrayList(C4542c.f12117c.values())) {
                    if (c4542c.f12122h.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator<b> it = c4542c.f12125k.iterator();
                        while (it.hasNext()) {
                            it.next().m6335a(z2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.c.c$d */
    /* JADX INFO: compiled from: FirebaseApp.java */
    public static class d implements Executor {

        /* JADX INFO: renamed from: j */
        public static final Handler f12127j = new Handler(Looper.getMainLooper());

        public d(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            f12127j.post(runnable);
        }
    }

    /* JADX INFO: renamed from: b.i.c.c$e */
    /* JADX INFO: compiled from: FirebaseApp.java */
    @TargetApi(24)
    public static class e extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        public static AtomicReference<e> f12128a = new AtomicReference<>();

        /* JADX INFO: renamed from: b */
        public final Context f12129b;

        public e(Context context) {
            this.f12129b = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object obj = C4542c.f12115a;
            synchronized (C4542c.f12115a) {
                Iterator<C4542c> it = C4542c.f12117c.values().iterator();
                while (it.hasNext()) {
                    it.next().m6332d();
                }
            }
            this.f12129b.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006b  */
    /* JADX WARN: Code duplicated, block: B:16:0x0075  */
    /* JADX WARN: Code duplicated, block: B:19:0x0088  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2 A[SYNTHETIC] */
    public C4542c(final Context context, String str, C4548i c4548i) {
        Bundle bundle;
        List<String> listEmptyList;
        ArrayList arrayList;
        Class<?> cls;
        new CopyOnWriteArrayList();
        this.f12118d = context;
        C1460d.m583w(str);
        this.f12119e = str;
        Objects.requireNonNull(c4548i, "null reference");
        this.f12120f = c4548i;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
                if (bundle == null) {
                    Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (String str2 : bundle.keySet()) {
                        if (!"com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                            arrayList2.add(str2.substring(31));
                        }
                    }
                    listEmptyList = arrayList2;
                }
                arrayList = new ArrayList();
                for (String str3 : listEmptyList) {
                    try {
                        cls = Class.forName(str3);
                        if (InterfaceC4575g.class.isAssignableFrom(cls)) {
                            arrayList.add((InterfaceC4575g) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        } else {
                            Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str3, "com.google.firebase.components.ComponentRegistrar"));
                        }
                    } catch (ClassNotFoundException e2) {
                        Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str3), e2);
                    } catch (IllegalAccessException e3) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str3), e3);
                    } catch (InstantiationException e4) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str3), e4);
                    } catch (NoSuchMethodException e5) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str3), e5);
                    } catch (InvocationTargetException e6) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str3), e6);
                    }
                }
                arrayList.add(new FirebaseCommonRegistrar());
                this.f12121g = new C4579k(f12116b, arrayList, C4572d.m6349c(context, Context.class, new Class[0]), C4572d.m6349c(this, C4542c.class, new Class[0]), C4572d.m6349c(c4548i, C4548i.class, new Class[0]));
                this.f12124j = new C4586r<>(new InterfaceC4836a(this, context) { // from class: b.i.c.b

                    /* JADX INFO: renamed from: a */
                    public final C4542c f12113a;

                    /* JADX INFO: renamed from: b */
                    public final Context f12114b;

                    {
                        this.f12113a = this;
                        this.f12114b = context;
                    }

                    @Override // p007b.p225i.p361c.p400t.InterfaceC4836a
                    public Object get() {
                        C4542c c4542c = this.f12113a;
                        Context context2 = this.f12114b;
                        Object obj = C4542c.f12115a;
                        return new C4862a(context2, c4542c.m6331c(), (InterfaceC4798c) c4542c.f12121g.mo6346a(InterfaceC4798c.class));
                    }
                });
            }
            Log.w("ComponentDiscovery", "Context has no PackageManager.");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        bundle = null;
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList();
            while (r4.hasNext()) {
                if (!"com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2))) {
                }
            }
            listEmptyList = arrayList3;
        }
        arrayList = new ArrayList();
        while (r13.hasNext()) {
            cls = Class.forName(str3);
            if (InterfaceC4575g.class.isAssignableFrom(cls)) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str3, "com.google.firebase.components.ComponentRegistrar"));
            } else {
                arrayList.add((InterfaceC4575g) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
        }
        arrayList.add(new FirebaseCommonRegistrar());
        this.f12121g = new C4579k(f12116b, arrayList, C4572d.m6349c(context, Context.class, new Class[0]), C4572d.m6349c(this, C4542c.class, new Class[0]), C4572d.m6349c(c4548i, C4548i.class, new Class[0]));
        this.f12124j = new C4586r<>(new InterfaceC4836a(this, context) { // from class: b.i.c.b

            /* JADX INFO: renamed from: a */
            public final C4542c f12113a;

            /* JADX INFO: renamed from: b */
            public final Context f12114b;

            {
                this.f12113a = this;
                this.f12114b = context;
            }

            @Override // p007b.p225i.p361c.p400t.InterfaceC4836a
            public Object get() {
                C4542c c4542c = this.f12113a;
                Context context2 = this.f12114b;
                Object obj = C4542c.f12115a;
                return new C4862a(context2, c4542c.m6331c(), (InterfaceC4798c) c4542c.f12121g.mo6346a(InterfaceC4798c.class));
            }
        });
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static C4542c m6327b() {
        C4542c c4542c;
        synchronized (f12115a) {
            c4542c = f12117c.get("[DEFAULT]");
            if (c4542c == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + C3405g.m4370a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return c4542c;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public static C4542c m6328e(@NonNull Context context) {
        synchronized (f12115a) {
            if (f12117c.containsKey("[DEFAULT]")) {
                return m6327b();
            }
            C4548i c4548iM6337a = C4548i.m6337a(context);
            if (c4548iM6337a == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return m6329f(context, c4548iM6337a);
        }
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static C4542c m6329f(@NonNull Context context, @NonNull C4548i c4548i) {
        C4542c c4542c;
        AtomicReference<c> atomicReference = c.f12126a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            if (c.f12126a.get() == null) {
                c cVar = new c();
                if (c.f12126a.compareAndSet(null, cVar)) {
                    ComponentCallbacks2C3281c.m4064a(application);
                    ComponentCallbacks2C3281c componentCallbacks2C3281c = ComponentCallbacks2C3281c.f9349j;
                    Objects.requireNonNull(componentCallbacks2C3281c);
                    synchronized (componentCallbacks2C3281c) {
                        componentCallbacks2C3281c.f9352m.add(cVar);
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f12115a) {
            Map<String, C4542c> map = f12117c;
            C1460d.m435G(!map.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            C1460d.m595z(context, "Application context cannot be null.");
            c4542c = new C4542c(context, "[DEFAULT]", c4548i);
            map.put("[DEFAULT]", c4542c);
        }
        c4542c.m6332d();
        return c4542c;
    }

    /* JADX INFO: renamed from: a */
    public final void m6330a() {
        C1460d.m435G(!this.f12123i.get(), "FirebaseApp was deleted");
    }

    /* JADX INFO: renamed from: c */
    public String m6331c() {
        StringBuilder sb = new StringBuilder();
        m6330a();
        byte[] bytes = this.f12119e.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        m6330a();
        byte[] bytes2 = this.f12120f.f12135b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    /* JADX INFO: renamed from: d */
    public final void m6332d() {
        Queue<C4796a<?>> queue;
        Set<Map.Entry<InterfaceC4797b<Object>, Executor>> setEmptySet;
        if (!UserManagerCompat.isUserUnlocked(this.f12118d)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            m6330a();
            sb.append(this.f12119e);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f12118d;
            if (e.f12128a.get() == null) {
                e eVar = new e(context);
                if (e.f12128a.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Device unlocked: initializing all Firebase APIs for app ");
        m6330a();
        sb2.append(this.f12119e);
        Log.i("FirebaseApp", sb2.toString());
        C4579k c4579k = this.f12121g;
        boolean zM6334h = m6334h();
        for (Map.Entry<C4572d<?>, C4586r<?>> entry : c4579k.f12192b.entrySet()) {
            C4572d<?> key = entry.getKey();
            C4586r<?> value = entry.getValue();
            int i = key.f12177c;
            if (!(i == 1)) {
                if (!(i == 2) || !zM6334h) {
                }
            }
            value.get();
        }
        C4585q c4585q = c4579k.f12195e;
        synchronized (c4585q) {
            queue = c4585q.f12207b;
            if (queue != null) {
                c4585q.f12207b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (final C4796a<?> c4796a : queue) {
                Objects.requireNonNull(c4796a);
                synchronized (c4585q) {
                    Queue<C4796a<?>> queue2 = c4585q.f12207b;
                    if (queue2 != null) {
                        queue2.add(c4796a);
                    } else {
                        synchronized (c4585q) {
                            ConcurrentHashMap<InterfaceC4797b<Object>, Executor> concurrentHashMap = c4585q.f12206a.get(null);
                            setEmptySet = concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
                        }
                        for (final Map.Entry<InterfaceC4797b<Object>, Executor> entry2 : setEmptySet) {
                            entry2.getValue().execute(new Runnable(entry2, c4796a) { // from class: b.i.c.l.p

                                /* JADX INFO: renamed from: j */
                                public final Map.Entry f12204j;

                                /* JADX INFO: renamed from: k */
                                public final C4796a f12205k;

                                {
                                    this.f12204j = entry2;
                                    this.f12205k = c4796a;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Map.Entry entry3 = this.f12204j;
                                    ((InterfaceC4797b) entry3.getKey()).mo6343a(this.f12205k);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4542c)) {
            return false;
        }
        String str = this.f12119e;
        C4542c c4542c = (C4542c) obj;
        c4542c.m6330a();
        return str.equals(c4542c.f12119e);
    }

    /* JADX INFO: renamed from: g */
    public boolean m6333g() {
        boolean z2;
        m6330a();
        C4862a c4862a = this.f12124j.get();
        synchronized (c4862a) {
            z2 = c4862a.f13011d;
        }
        return z2;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: h */
    public boolean m6334h() {
        m6330a();
        return "[DEFAULT]".equals(this.f12119e);
    }

    public int hashCode() {
        return this.f12119e.hashCode();
    }

    public String toString() {
        C3361j c3361j = new C3361j(this);
        c3361j.m4162a(ModelAuditLogEntry.CHANGE_KEY_NAME, this.f12119e);
        c3361j.m4162a("options", this.f12120f);
        return c3361j.toString();
    }
}
