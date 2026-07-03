package p007b.p225i.p226a.p288f.p333j;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.HashMap;
import java.util.TreeMap;
import p007b.p225i.p226a.p288f.p313h.p326m.C3939p;

/* JADX INFO: renamed from: b.i.a.f.j.a */
/* JADX INFO: loaded from: classes3.dex */
public final class C4263a {
    /* JADX INFO: renamed from: a */
    public static boolean m5980a(Context context) {
        Object obj;
        String str;
        boolean z2;
        String str2;
        Boolean bool;
        if (PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
            return true;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = C3939p.f10466a;
        synchronized (C3939p.class) {
            C3939p.m5409a(contentResolver);
            obj = C3939p.f10476k;
        }
        HashMap<String, Boolean> map = C3939p.f10472g;
        Boolean bool2 = Boolean.TRUE;
        synchronized (C3939p.class) {
            str = null;
            if (map.containsKey("gms:nearby:requires_gms_check")) {
                Boolean bool3 = map.get("gms:nearby:requires_gms_check");
                if (bool3 != null) {
                    bool2 = bool3;
                }
            } else {
                bool2 = null;
            }
        }
        Boolean bool4 = bool2;
        if (bool4 != null) {
            return bool4.booleanValue();
        }
        synchronized (C3939p.class) {
            C3939p.m5409a(contentResolver);
            Object obj2 = C3939p.f10476k;
            z2 = false;
            if (C3939p.f10471f.containsKey("gms:nearby:requires_gms_check")) {
                str2 = C3939p.f10471f.get("gms:nearby:requires_gms_check");
                if (str2 != null) {
                    str = str2;
                }
            } else {
                String[] strArr = C3939p.f10478m;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        Cursor cursorQuery = contentResolver.query(C3939p.f10466a, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    String string = cursorQuery.getString(1);
                                    if (string != null && string.equals(null)) {
                                        string = null;
                                    }
                                    C3939p.m5410b(obj2, "gms:nearby:requires_gms_check", string);
                                    if (string != null) {
                                        str = string;
                                    }
                                } else {
                                    C3939p.m5410b(obj2, "gms:nearby:requires_gms_check", null);
                                    if (cursorQuery != null) {
                                    }
                                }
                                cursorQuery.close();
                            } catch (Throwable th) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                throw th;
                            }
                        } else {
                            C3939p.m5410b(obj2, "gms:nearby:requires_gms_check", null);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    } else if (!"gms:nearby:requires_gms_check".startsWith(strArr[i])) {
                        i++;
                    } else if (!C3939p.f10477l || C3939p.f10471f.isEmpty()) {
                        String[] strArr2 = C3939p.f10478m;
                        HashMap<String, String> map2 = C3939p.f10471f;
                        Cursor cursorQuery2 = contentResolver.query(C3939p.f10467b, null, null, strArr2, null);
                        TreeMap treeMap = new TreeMap();
                        if (cursorQuery2 != null) {
                            while (cursorQuery2.moveToNext()) {
                                try {
                                    treeMap.put(cursorQuery2.getString(0), cursorQuery2.getString(1));
                                } catch (Throwable th2) {
                                    cursorQuery2.close();
                                    throw th2;
                                }
                            }
                            cursorQuery2.close();
                        }
                        map2.putAll(treeMap);
                        C3939p.f10477l = true;
                        if (C3939p.f10471f.containsKey("gms:nearby:requires_gms_check") && (str2 = C3939p.f10471f.get("gms:nearby:requires_gms_check")) != null) {
                            str = str2;
                        }
                    }
                }
            }
        }
        if (str == null || str.equals("")) {
            bool = bool4;
            z2 = true;
        } else {
            if (C3939p.f10468c.matcher(str).matches()) {
                bool4 = Boolean.TRUE;
            } else if (C3939p.f10469d.matcher(str).matches()) {
                bool = Boolean.FALSE;
            } else {
                Log.w("Gservices", "attempt to read gservices key gms:nearby:requires_gms_check (value \"" + str + "\") as boolean");
            }
            bool = bool4;
            z2 = true;
        }
        HashMap<String, Boolean> map3 = C3939p.f10472g;
        synchronized (C3939p.class) {
            if (obj == C3939p.f10476k) {
                map3.put("gms:nearby:requires_gms_check", bool);
                C3939p.f10471f.remove("gms:nearby:requires_gms_check");
            }
        }
        return z2;
    }
}
