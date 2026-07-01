package b.i.a.f.h.l;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import java.util.HashMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c2 implements b2 {

    @GuardedBy("GservicesLoader.class")
    public static c2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1437b;
    public final ContentObserver c;

    public c2(Context context) {
        this.f1437b = context;
        f2 f2Var = new f2();
        this.c = f2Var;
        context.getContentResolver().registerContentObserver(u1.a, true, f2Var);
    }

    public static c2 a(Context context) {
        c2 c2Var;
        synchronized (c2.class) {
            if (a == null) {
                a = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new c2(context) : new c2();
            }
            c2Var = a;
        }
        return c2Var;
    }

    @Override // b.i.a.f.h.l.b2
    public final Object g(final String str) {
        if (this.f1437b == null) {
            return null;
        }
        try {
            return (String) b.i.a.f.e.o.f.T1(new d2(this, str) { // from class: b.i.a.f.h.l.g2
                public final c2 a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final String f1443b;

                {
                    this.a = this;
                    this.f1443b = str;
                }

                /* JADX WARN: Code duplicated, block: B:40:0x00d6 A[Catch: all -> 0x011f, DONT_GENERATE, TryCatch #2 {, blocks: (B:4:0x000f, B:6:0x0015, B:10:0x005f, B:12:0x006a, B:15:0x0075, B:17:0x0078, B:19:0x007e, B:21:0x0086, B:23:0x008a, B:40:0x00d6, B:25:0x0092, B:32:0x00b9, B:43:0x00d9, B:44:0x00dc, B:33:0x00bc, B:35:0x00c9, B:38:0x00d4, B:45:0x00dd, B:46:0x00e0, B:7:0x0035, B:9:0x003d, B:28:0x00a7, B:30:0x00ad), top: B:74:0x000f, inners: #0 }] */
                @Override // b.i.a.f.h.l.d2
                public final Object a() {
                    String str2;
                    c2 c2Var = this.a;
                    String str3 = this.f1443b;
                    ContentResolver contentResolver = c2Var.f1437b.getContentResolver();
                    Uri uri = u1.a;
                    synchronized (u1.class) {
                        if (u1.f == null) {
                            u1.e.set(false);
                            u1.f = new HashMap<>();
                            u1.k = new Object();
                            u1.l = false;
                            contentResolver.registerContentObserver(u1.a, true, new t1());
                        } else if (u1.e.getAndSet(false)) {
                            u1.f.clear();
                            u1.g.clear();
                            u1.h.clear();
                            u1.i.clear();
                            u1.j.clear();
                            u1.k = new Object();
                            u1.l = false;
                        }
                        Object obj = u1.k;
                        str2 = null;
                        if (u1.f.containsKey(str3)) {
                            String str4 = u1.f.get(str3);
                            str2 = str4 != null ? str4 : null;
                        } else {
                            for (String str5 : u1.m) {
                                if (str3.startsWith(str5)) {
                                    if (!u1.l || u1.f.isEmpty()) {
                                        String[] strArr = u1.m;
                                        HashMap<String, String> map = u1.f;
                                        Cursor cursorQuery = contentResolver.query(u1.f1496b, null, null, strArr, null);
                                        TreeMap treeMap = new TreeMap();
                                        if (cursorQuery != null) {
                                            while (cursorQuery.moveToNext()) {
                                                try {
                                                    treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                                                } catch (Throwable th) {
                                                    cursorQuery.close();
                                                    throw th;
                                                }
                                            }
                                            cursorQuery.close();
                                        }
                                        map.putAll(treeMap);
                                        u1.l = true;
                                        if (u1.f.containsKey(str3)) {
                                            String str6 = u1.f.get(str3);
                                            str2 = str6 != null ? str6 : null;
                                        }
                                    }
                                }
                            }
                            Cursor cursorQuery2 = contentResolver.query(u1.a, null, null, new String[]{str3}, null);
                            if (cursorQuery2 != null) {
                                try {
                                    if (cursorQuery2.moveToFirst()) {
                                        String string = cursorQuery2.getString(1);
                                        if (string != null && string.equals(null)) {
                                            string = null;
                                        }
                                        u1.a(obj, str3, string);
                                        str2 = string != null ? string : null;
                                    } else {
                                        u1.a(obj, str3, null);
                                    }
                                } finally {
                                    cursorQuery2.close();
                                }
                            } else if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                        }
                    }
                    return str2;
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    public c2() {
        this.f1437b = null;
        this.c = null;
    }
}
