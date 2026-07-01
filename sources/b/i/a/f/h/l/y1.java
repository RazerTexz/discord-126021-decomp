package b.i.a.f.h.l;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y1 implements b2 {

    @GuardedBy("ConfigurationContentLoader.class")
    public static final Map<Uri, y1> a = new ArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1503b = {"key", "value"};
    public final ContentResolver c;
    public final Uri d;
    public final ContentObserver e;
    public final Object f;
    public volatile Map<String, String> g;

    @GuardedBy("this")
    public final List<z1> h;

    public y1(ContentResolver contentResolver, Uri uri) {
        a2 a2Var = new a2(this);
        this.e = a2Var;
        this.f = new Object();
        this.h = new ArrayList();
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.c = contentResolver;
        this.d = uri;
        contentResolver.registerContentObserver(uri, false, a2Var);
    }

    public static y1 a(ContentResolver contentResolver, Uri uri) {
        y1 y1Var;
        synchronized (y1.class) {
            Map<Uri, y1> map = a;
            y1Var = map.get(uri);
            if (y1Var == null) {
                try {
                    y1 y1Var2 = new y1(contentResolver, uri);
                    try {
                        map.put(uri, y1Var2);
                    } catch (SecurityException unused) {
                    }
                    y1Var = y1Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return y1Var;
    }

    public static synchronized void c() {
        for (y1 y1Var : a.values()) {
            y1Var.c.unregisterContentObserver(y1Var.e);
        }
        a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final Map<String, String> b() {
        ?? r0;
        Map<String, String> map;
        Map<String, String> map2 = this.g;
        ?? r1 = map2;
        if (map2 == null) {
            synchronized (this.f) {
                Map<String, String> map3 = this.g;
                r0 = map3;
                if (map3 == null) {
                    ?? AllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map = (Map) b.i.a.f.e.o.f.T1(new x1(this));
                            StrictMode.setThreadPolicy(AllowThreadDiskReads);
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(AllowThreadDiskReads);
                            throw th;
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                        StrictMode.setThreadPolicy(AllowThreadDiskReads);
                        map = null;
                    }
                    this.g = map;
                    AllowThreadDiskReads = map;
                    r0 = AllowThreadDiskReads;
                }
            }
            r1 = r0;
        }
        return r1 != 0 ? r1 : Collections.emptyMap();
    }

    @Override // b.i.a.f.h.l.b2
    public final /* synthetic */ Object g(String str) {
        return b().get(str);
    }
}
