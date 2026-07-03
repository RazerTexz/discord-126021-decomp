package p007b.p225i.p226a.p288f.p313h.p325l;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.c2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3608c2 implements InterfaceC3594b2 {

    /* JADX INFO: renamed from: a */
    @GuardedBy("GservicesLoader.class")
    public static C3608c2 f9871a;

    /* JADX INFO: renamed from: b */
    public final Context f9872b;

    /* JADX INFO: renamed from: c */
    public final ContentObserver f9873c;

    public C3608c2(Context context) {
        this.f9872b = context;
        C3650f2 c3650f2 = new C3650f2();
        this.f9873c = c3650f2;
        context.getContentResolver().registerContentObserver(C3848u1.f10333a, true, c3650f2);
    }

    /* JADX INFO: renamed from: a */
    public static C3608c2 m4602a(Context context) {
        C3608c2 c3608c2;
        synchronized (C3608c2.class) {
            if (f9871a == null) {
                f9871a = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C3608c2(context) : new C3608c2();
            }
            c3608c2 = f9871a;
        }
        return c3608c2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3594b2
    /* JADX INFO: renamed from: g */
    public final Object mo4567g(final String str) {
        if (this.f9872b == null) {
            return null;
        }
        try {
            return (String) C3404f.m4248T1(new InterfaceC3622d2(this, str) { // from class: b.i.a.f.h.l.g2

                /* JADX INFO: renamed from: a */
                public final C3608c2 f9964a;

                /* JADX INFO: renamed from: b */
                public final String f9965b;

                {
                    this.f9964a = this;
                    this.f9965b = str;
                }

                /* JADX WARN: Code duplicated, block: B:40:0x00d6 A[Catch: all -> 0x011f, DONT_GENERATE, TryCatch #2 {all -> 0x011f, blocks: (B:4:0x000f, B:6:0x0015, B:10:0x005f, B:12:0x006a, B:15:0x0075, B:17:0x0078, B:19:0x007e, B:21:0x0086, B:23:0x008a, B:40:0x00d6, B:25:0x0092, B:32:0x00b9, B:43:0x00d9, B:44:0x00dc, B:33:0x00bc, B:35:0x00c9, B:38:0x00d4, B:45:0x00dd, B:46:0x00e0, B:7:0x0035, B:9:0x003d, B:28:0x00a7, B:30:0x00ad), top: B:74:0x000f, inners: #0 }] */
                @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3622d2
                /* JADX INFO: renamed from: a */
                public final Object mo4628a() {
                    String str2;
                    C3608c2 c3608c2 = this.f9964a;
                    String str3 = this.f9965b;
                    ContentResolver contentResolver = c3608c2.f9872b.getContentResolver();
                    Uri uri = C3848u1.f10333a;
                    synchronized (C3848u1.class) {
                        try {
                            if (C3848u1.f10338f == null) {
                                C3848u1.f10337e.set(false);
                                C3848u1.f10338f = new HashMap<>();
                                C3848u1.f10343k = new Object();
                                C3848u1.f10344l = false;
                                contentResolver.registerContentObserver(C3848u1.f10333a, true, new C3835t1());
                            } else if (C3848u1.f10337e.getAndSet(false)) {
                                C3848u1.f10338f.clear();
                                C3848u1.f10339g.clear();
                                C3848u1.f10340h.clear();
                                C3848u1.f10341i.clear();
                                C3848u1.f10342j.clear();
                                C3848u1.f10343k = new Object();
                                C3848u1.f10344l = false;
                            }
                            Object obj = C3848u1.f10343k;
                            str2 = null;
                            if (C3848u1.f10338f.containsKey(str3)) {
                                String str4 = C3848u1.f10338f.get(str3);
                                str2 = str4 != null ? str4 : null;
                            } else {
                                for (String str5 : C3848u1.f10345m) {
                                    if (str3.startsWith(str5)) {
                                        if (!C3848u1.f10344l || C3848u1.f10338f.isEmpty()) {
                                            String[] strArr = C3848u1.f10345m;
                                            HashMap<String, String> map = C3848u1.f10338f;
                                            Cursor cursorQuery = contentResolver.query(C3848u1.f10334b, null, null, strArr, null);
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
                                            C3848u1.f10344l = true;
                                            if (C3848u1.f10338f.containsKey(str3)) {
                                                String str6 = C3848u1.f10338f.get(str3);
                                                str2 = str6 != null ? str6 : null;
                                            }
                                        }
                                    }
                                }
                                Cursor cursorQuery2 = contentResolver.query(C3848u1.f10333a, null, null, new String[]{str3}, null);
                                if (cursorQuery2 != null) {
                                    try {
                                        if (cursorQuery2.moveToFirst()) {
                                            String string = cursorQuery2.getString(1);
                                            if (string != null && string.equals(null)) {
                                                string = null;
                                            }
                                            C3848u1.m5308a(obj, str3, string);
                                            str2 = string != null ? string : null;
                                        } else {
                                            C3848u1.m5308a(obj, str3, null);
                                        }
                                    } finally {
                                        cursorQuery2.close();
                                    }
                                } else if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
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

    public C3608c2() {
        this.f9872b = null;
        this.f9873c = null;
    }
}
