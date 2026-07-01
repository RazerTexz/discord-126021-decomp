package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri$Builder;
import android.os.Build$VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.i.a.f.f.a;
import b.i.a.f.g.b;
import b.i.a.f.g.c;
import b.i.a.f.g.d;
import b.i.a.f.g.e;
import b.i.a.f.g.f;
import b.i.a.f.g.g;
import b.i.a.f.g.h;
import b.i.a.f.g.i;
import b.i.a.f.g.j;
import b.i.a.f.g.k;
import b.i.a.f.g.l;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class DynamiteModule {

    @Nullable
    public static Boolean d = null;

    @Nullable
    public static String e = null;
    public static int f = -1;

    @Nullable
    public static k j;

    @Nullable
    public static l k;
    public final Context l;
    public static final ThreadLocal<g> g = new ThreadLocal<>();
    public static final ThreadLocal<Long> h = new b();
    public static final i i = new c();

    @RecentlyNonNull
    public static final DynamiteModule$a a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RecentlyNonNull
    public static final DynamiteModule$a f3006b = new e();

    @RecentlyNonNull
    public static final DynamiteModule$a c = new f();

    public DynamiteModule(Context context) {
        Objects.requireNonNull(context, "null reference");
        this.l = context;
    }

    public static int a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".");
            sb.append("ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (b.c.a.a0.d.h0(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String strValueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(strValueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String strValueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", strValueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @RecentlyNonNull
    public static DynamiteModule c(@RecentlyNonNull Context context, @RecentlyNonNull DynamiteModule$a dynamiteModule$a, @RecentlyNonNull String str) throws DynamiteModule$LoadingException {
        Boolean bool;
        a aVarI;
        DynamiteModule dynamiteModule;
        l lVar;
        Boolean boolValueOf;
        a aVarI2;
        ThreadLocal<g> threadLocal = g;
        g gVar = threadLocal.get();
        g gVar2 = new g(null);
        threadLocal.set(gVar2);
        ThreadLocal<Long> threadLocal2 = h;
        long jLongValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            j jVarA = dynamiteModule$a.a(context, str, i);
            int i2 = jVarA.a;
            int i3 = jVarA.f1402b;
            StringBuilder sb = new StringBuilder(str.length() + 68 + str.length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = jVarA.c;
            if (i4 == 0 || ((i4 == -1 && jVarA.a == 0) || (i4 == 1 && jVarA.f1402b == 0))) {
                int i5 = jVarA.a;
                int i6 = jVarA.f1402b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new DynamiteModule$LoadingException(sb2.toString());
            }
            if (i4 == -1) {
                DynamiteModule dynamiteModuleG = g(context, str);
                if (jLongValue == 0) {
                    threadLocal2.remove();
                } else {
                    threadLocal2.set(Long.valueOf(jLongValue));
                }
                Cursor cursor = gVar2.a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(gVar);
                return dynamiteModuleG;
            }
            if (i4 != 1) {
                throw new DynamiteModule$LoadingException("VersionPolicy returned invalid code:0");
            }
            try {
                int i7 = jVarA.f1402b;
                try {
                    synchronized (DynamiteModule.class) {
                        bool = d;
                    }
                    if (bool == null) {
                        throw new DynamiteModule$LoadingException("Failed to determine which loading route to use.");
                    }
                    if (bool.booleanValue()) {
                        StringBuilder sb3 = new StringBuilder(str.length() + 51);
                        sb3.append("Selected remote version of ");
                        sb3.append(str);
                        sb3.append(", version >= ");
                        sb3.append(i7);
                        Log.i("DynamiteModule", sb3.toString());
                        synchronized (DynamiteModule.class) {
                            lVar = k;
                        }
                        if (lVar == null) {
                            throw new DynamiteModule$LoadingException("DynamiteLoaderV2 was not cached.");
                        }
                        g gVar3 = threadLocal.get();
                        if (gVar3 == null || gVar3.a == null) {
                            throw new DynamiteModule$LoadingException("No result cursor");
                        }
                        Context applicationContext = context.getApplicationContext();
                        Cursor cursor2 = gVar3.a;
                        new b.i.a.f.f.b(null);
                        synchronized (DynamiteModule.class) {
                            boolValueOf = Boolean.valueOf(f >= 2);
                        }
                        if (boolValueOf.booleanValue()) {
                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                            aVarI2 = lVar.t0(new b.i.a.f.f.b(applicationContext), str, i7, new b.i.a.f.f.b(cursor2));
                        } else {
                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                            aVarI2 = lVar.i(new b.i.a.f.f.b(applicationContext), str, i7, new b.i.a.f.f.b(cursor2));
                        }
                        Context context2 = (Context) b.i.a.f.f.b.i(aVarI2);
                        if (context2 == null) {
                            throw new DynamiteModule$LoadingException("Failed to get module context");
                        }
                        dynamiteModule = new DynamiteModule(context2);
                    } else {
                        StringBuilder sb4 = new StringBuilder(str.length() + 51);
                        sb4.append("Selected remote version of ");
                        sb4.append(str);
                        sb4.append(", version >= ");
                        sb4.append(i7);
                        Log.i("DynamiteModule", sb4.toString());
                        k kVarI = i(context);
                        if (kVarI == null) {
                            throw new DynamiteModule$LoadingException("Failed to create IDynamiteLoader.");
                        }
                        Parcel parcelC = kVarI.c(6, kVarI.g());
                        int i8 = parcelC.readInt();
                        parcelC.recycle();
                        if (i8 >= 3) {
                            g gVar4 = threadLocal.get();
                            if (gVar4 == null) {
                                throw new DynamiteModule$LoadingException("No cached result cursor holder");
                            }
                            aVarI = kVarI.v0(new b.i.a.f.f.b(context), str, i7, new b.i.a.f.f.b(gVar4.a));
                        } else if (i8 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                            aVarI = kVarI.t0(new b.i.a.f.f.b(context), str, i7);
                        } else {
                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                            aVarI = kVarI.i(new b.i.a.f.f.b(context), str, i7);
                        }
                        if (b.i.a.f.f.b.i(aVarI) == null) {
                            throw new DynamiteModule$LoadingException("Failed to load remote module.");
                        }
                        dynamiteModule = new DynamiteModule((Context) b.i.a.f.f.b.i(aVarI));
                    }
                    if (jLongValue == 0) {
                        threadLocal2.remove();
                    } else {
                        threadLocal2.set(Long.valueOf(jLongValue));
                    }
                    Cursor cursor3 = gVar2.a;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    threadLocal.set(gVar);
                    return dynamiteModule;
                } catch (RemoteException e2) {
                    throw new DynamiteModule$LoadingException("Failed to load remote module.", e2);
                } catch (DynamiteModule$LoadingException e3) {
                    throw e3;
                } catch (Throwable th) {
                    try {
                        Objects.requireNonNull(context, "null reference");
                    } catch (Exception e4) {
                        Log.e("CrashUtils", "Error adding exception to DropBox!", e4);
                    }
                    throw new DynamiteModule$LoadingException("Failed to load remote module.", th);
                }
            } catch (DynamiteModule$LoadingException e5) {
                String strValueOf = String.valueOf(e5.getMessage());
                Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to load remote module: ".concat(strValueOf) : new String("Failed to load remote module: "));
                int i9 = jVarA.a;
                if (i9 == 0 || dynamiteModule$a.a(context, str, new h(i9)).c != -1) {
                    throw new DynamiteModule$LoadingException("Remote load failed. No local fallback found.", e5);
                }
                DynamiteModule dynamiteModuleG2 = g(context, str);
                if (jLongValue == 0) {
                    h.remove();
                } else {
                    h.set(Long.valueOf(jLongValue));
                }
                Cursor cursor4 = gVar2.a;
                if (cursor4 != null) {
                    cursor4.close();
                }
                g.set(gVar);
                return dynamiteModuleG2;
            }
        } catch (Throwable th2) {
            if (jLongValue == 0) {
                h.remove();
            } else {
                h.set(Long.valueOf(jLongValue));
            }
            Cursor cursor5 = gVar2.a;
            if (cursor5 != null) {
                cursor5.close();
            }
            g.set(gVar);
            throw th2;
        }
    }

    public static int d(@RecentlyNonNull Context context, @RecentlyNonNull String str, boolean z2) {
        ClassLoader aVar;
        Throwable th;
        Cursor cursor;
        RemoteException e2;
        int i2;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = d;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule$DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader != null) {
                                    if (classLoader == ClassLoader.getSystemClassLoader()) {
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            h(classLoader);
                                        } catch (DynamiteModule$LoadingException unused) {
                                        }
                                        bool = Boolean.TRUE;
                                    }
                                } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int iE = e(context, str, z2);
                                        String str2 = e;
                                        if (str2 != null && !str2.isEmpty()) {
                                            if (Build$VERSION.SDK_INT >= 29) {
                                                String str3 = e;
                                                Objects.requireNonNull(str3, "null reference");
                                                aVar = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str4 = e;
                                                Objects.requireNonNull(str4, "null reference");
                                                aVar = new b.i.a.f.g.a(str4, ClassLoader.getSystemClassLoader());
                                            }
                                            h(aVar);
                                            declaredField.set(null, aVar);
                                            d = Boolean.TRUE;
                                            return iE;
                                        }
                                        return iE;
                                    } catch (DynamiteModule$LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                                d = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e3) {
                        String strValueOf = String.valueOf(e3);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(strValueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return e(context, str, z2);
                    } catch (DynamiteModule$LoadingException e4) {
                        String strValueOf2 = String.valueOf(e4.getMessage());
                        Log.w("DynamiteModule", strValueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                k kVarI = i(context);
                try {
                    if (kVarI == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelC = kVarI.c(6, kVarI.g());
                        int i3 = parcelC.readInt();
                        parcelC.recycle();
                        if (i3 >= 3) {
                            cursor = (Cursor) b.i.a.f.f.b.i(kVarI.u0(new b.i.a.f.f.b(context), str, z2, h.get().longValue()));
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        i2 = cursor.getInt(0);
                                        cursor2 = (i2 <= 0 || !f(cursor)) ? cursor : null;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (RemoteException e5) {
                                    e2 = e5;
                                    cursor2 = cursor;
                                    String strValueOf3 = String.valueOf(e2.getMessage());
                                    Log.w("DynamiteModule", strValueOf3.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf3) : new String("Failed to retrieve remote module version: "));
                                    if (cursor2 == null) {
                                        return 0;
                                    }
                                    cursor2.close();
                                    return 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor == null) {
                                return 0;
                            }
                            cursor.close();
                            return 0;
                        }
                        if (i3 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            b.i.a.f.f.b bVar = new b.i.a.f.f.b(context);
                            Parcel parcelG = kVarI.g();
                            b.i.a.f.h.g.c.b(parcelG, bVar);
                            parcelG.writeString(str);
                            parcelG.writeInt(z2 ? 1 : 0);
                            Parcel parcelC2 = kVarI.c(5, parcelG);
                            i2 = parcelC2.readInt();
                            parcelC2.recycle();
                        } else {
                            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            b.i.a.f.f.b bVar2 = new b.i.a.f.f.b(context);
                            Parcel parcelG2 = kVarI.g();
                            b.i.a.f.h.g.c.b(parcelG2, bVar2);
                            parcelG2.writeString(str);
                            parcelG2.writeInt(z2 ? 1 : 0);
                            Parcel parcelC3 = kVarI.c(3, parcelG2);
                            i2 = parcelC3.readInt();
                            parcelC3.recycle();
                        }
                        return i2;
                    } catch (RemoteException e6) {
                        e2 = e6;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                }
            }
        } catch (Throwable th5) {
            try {
                Objects.requireNonNull(context, "null reference");
            } catch (Exception e7) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e7);
            }
            throw th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    public static int e(Context context, String str, boolean z2) throws Throwable {
        Exception e2;
        Throwable th;
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(new Uri$Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z2 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(h.get().longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int i2 = cursorQuery.getInt(0);
                            if (i2 > 0) {
                                synchronized (DynamiteModule.class) {
                                    e = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        f = cursorQuery.getInt(columnIndex);
                                    }
                                }
                                cursor = f(cursorQuery) ? null : cursorQuery;
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i2;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        if (e2 instanceof DynamiteModule$LoadingException) {
                            throw e2;
                        }
                        throw new DynamiteModule$LoadingException("V2 version check failed", e2);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new DynamiteModule$LoadingException("Failed to connect to dynamite module ContentResolver.");
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e2 = e4;
        }
    }

    public static boolean f(Cursor cursor) {
        g gVar = g.get();
        if (gVar == null || gVar.a != null) {
            return false;
        }
        gVar.a = cursor;
        return true;
    }

    public static DynamiteModule g(Context context, String str) {
        String strValueOf = String.valueOf(str);
        Log.i("DynamiteModule", strValueOf.length() != 0 ? "Selected local version of ".concat(strValueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    public static void h(ClassLoader classLoader) throws DynamiteModule$LoadingException {
        l lVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                lVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                lVar = iInterfaceQueryLocalInterface instanceof l ? (l) iInterfaceQueryLocalInterface : new l(iBinder);
            }
            k = lVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e2);
        }
    }

    @Nullable
    public static k i(Context context) {
        k kVar;
        synchronized (DynamiteModule.class) {
            k kVar2 = j;
            if (kVar2 != null) {
                return kVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    kVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    kVar = iInterfaceQueryLocalInterface instanceof k ? (k) iInterfaceQueryLocalInterface : new k(iBinder);
                }
                if (kVar != null) {
                    j = kVar;
                    return kVar;
                }
            } catch (Exception e2) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    @RecentlyNonNull
    public IBinder b(@RecentlyNonNull String str) throws DynamiteModule$LoadingException {
        try {
            return (IBinder) this.l.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new DynamiteModule$LoadingException(str.length() != 0 ? "Failed to instantiate module class: ".concat(str) : new String("Failed to instantiate module class: "), e2);
        }
    }
}
