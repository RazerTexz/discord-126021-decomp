package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.y1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3900y1 implements InterfaceC3594b2 {

    /* JADX INFO: renamed from: a */
    @GuardedBy("ConfigurationContentLoader.class")
    public static final Map<Uri, C3900y1> f10417a = new ArrayMap();

    /* JADX INFO: renamed from: b */
    public static final String[] f10418b = {"key", "value"};

    /* JADX INFO: renamed from: c */
    public final ContentResolver f10419c;

    /* JADX INFO: renamed from: d */
    public final Uri f10420d;

    /* JADX INFO: renamed from: e */
    public final ContentObserver f10421e;

    /* JADX INFO: renamed from: f */
    public final Object f10422f;

    /* JADX INFO: renamed from: g */
    public volatile Map<String, String> f10423g;

    /* JADX INFO: renamed from: h */
    @GuardedBy("this")
    public final List<InterfaceC3913z1> f10424h;

    public C3900y1(ContentResolver contentResolver, Uri uri) {
        C3580a2 c3580a2 = new C3580a2(this);
        this.f10421e = c3580a2;
        this.f10422f = new Object();
        this.f10424h = new ArrayList();
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.f10419c = contentResolver;
        this.f10420d = uri;
        contentResolver.registerContentObserver(uri, false, c3580a2);
    }

    /* JADX INFO: renamed from: a */
    public static C3900y1 m5376a(ContentResolver contentResolver, Uri uri) {
        C3900y1 c3900y1;
        synchronized (C3900y1.class) {
            Map<Uri, C3900y1> map = f10417a;
            c3900y1 = map.get(uri);
            if (c3900y1 == null) {
                try {
                    C3900y1 c3900y2 = new C3900y1(contentResolver, uri);
                    try {
                        map.put(uri, c3900y2);
                    } catch (SecurityException unused) {
                    }
                    c3900y1 = c3900y2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return c3900y1;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m5377c() {
        for (C3900y1 c3900y1 : f10417a.values()) {
            c3900y1.f10419c.unregisterContentObserver(c3900y1.f10421e);
        }
        f10417a.clear();
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
    /* JADX INFO: renamed from: b */
    public final Map<String, String> m5378b() {
        ?? r0;
        Map<String, String> map;
        Map<String, String> map2 = this.f10423g;
        ?? r1 = map2;
        if (map2 == null) {
            synchronized (this.f10422f) {
                Map<String, String> map3 = this.f10423g;
                r0 = map3;
                if (map3 == null) {
                    ?? AllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map = (Map) C3404f.m4248T1(new InterfaceC3622d2(this) { // from class: b.i.a.f.h.l.x1

                                /* JADX INFO: renamed from: a */
                                public final C3900y1 f10399a;

                                {
                                    this.f10399a = this;
                                }

                                @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3622d2
                                /* JADX INFO: renamed from: a */
                                public final Object mo4628a() {
                                    C3900y1 c3900y1 = this.f10399a;
                                    Cursor cursorQuery = c3900y1.f10419c.query(c3900y1.f10420d, C3900y1.f10418b, null, null, null);
                                    if (cursorQuery == null) {
                                        return Collections.emptyMap();
                                    }
                                    try {
                                        int count = cursorQuery.getCount();
                                        if (count == 0) {
                                            return Collections.emptyMap();
                                        }
                                        Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                                        while (cursorQuery.moveToNext()) {
                                            arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                                        }
                                        return arrayMap;
                                    } finally {
                                        cursorQuery.close();
                                    }
                                }
                            });
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
                    this.f10423g = map;
                    AllowThreadDiskReads = map;
                    r0 = AllowThreadDiskReads;
                }
            }
            r1 = r0;
        }
        return r1 != 0 ? r1 : Collections.emptyMap();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3594b2
    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object mo4567g(String str) {
        return m5378b().get(str);
    }
}
