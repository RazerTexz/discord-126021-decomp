package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.util.DynamiteApi;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;
import p007b.p225i.p226a.p288f.p312g.C3425a;
import p007b.p225i.p226a.p288f.p312g.C3426b;
import p007b.p225i.p226a.p288f.p312g.C3427c;
import p007b.p225i.p226a.p288f.p312g.C3428d;
import p007b.p225i.p226a.p288f.p312g.C3429e;
import p007b.p225i.p226a.p288f.p312g.C3430f;
import p007b.p225i.p226a.p288f.p312g.C3431g;
import p007b.p225i.p226a.p288f.p312g.C3432h;
import p007b.p225i.p226a.p288f.p312g.C3434j;
import p007b.p225i.p226a.p288f.p312g.C3435k;
import p007b.p225i.p226a.p288f.p312g.C3436l;
import p007b.p225i.p226a.p288f.p312g.InterfaceC3433i;
import p007b.p225i.p226a.p288f.p313h.p320g.C3483c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class DynamiteModule {

    /* JADX INFO: renamed from: d */
    @Nullable
    public static Boolean f20574d = null;

    /* JADX INFO: renamed from: e */
    @Nullable
    public static String f20575e = null;

    /* JADX INFO: renamed from: f */
    public static int f20576f = -1;

    /* JADX INFO: renamed from: j */
    @Nullable
    public static C3435k f20580j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public static C3436l f20581k;

    /* JADX INFO: renamed from: l */
    public final Context f20582l;

    /* JADX INFO: renamed from: g */
    public static final ThreadLocal<C3431g> f20577g = new ThreadLocal<>();

    /* JADX INFO: renamed from: h */
    public static final ThreadLocal<Long> f20578h = new C3426b();

    /* JADX INFO: renamed from: i */
    public static final InterfaceC3433i f20579i = new C3427c();

    /* JADX INFO: renamed from: a */
    @RecentlyNonNull
    public static final InterfaceC10803a f20571a = new C3428d();

    /* JADX INFO: renamed from: b */
    @RecentlyNonNull
    public static final InterfaceC10803a f20572b = new C3429e();

    /* JADX INFO: renamed from: c */
    @RecentlyNonNull
    public static final InterfaceC10803a f20573c = new C3430f();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @RecentlyNullable
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.dynamite.DynamiteModule$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface InterfaceC10803a {
        /* JADX INFO: renamed from: a */
        C3434j mo4384a(Context context, String str, InterfaceC3433i interfaceC3433i) throws LoadingException;
    }

    public DynamiteModule(Context context) {
        Objects.requireNonNull(context, "null reference");
        this.f20582l = context;
    }

    /* JADX INFO: renamed from: a */
    public static int m9042a(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
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
            if (C1460d.m524h0(declaredField.get(null), str)) {
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
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", strValueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: c */
    public static DynamiteModule m9043c(@RecentlyNonNull Context context, @RecentlyNonNull InterfaceC10803a interfaceC10803a, @RecentlyNonNull String str) throws LoadingException {
        Boolean bool;
        InterfaceC3422a interfaceC3422aM4385i;
        DynamiteModule dynamiteModule;
        C3436l c3436l;
        Boolean boolValueOf;
        InterfaceC3422a interfaceC3422aM4389i;
        ThreadLocal<C3431g> threadLocal = f20577g;
        C3431g c3431g = threadLocal.get();
        C3431g c3431g2 = new C3431g(null);
        threadLocal.set(c3431g2);
        ThreadLocal<Long> threadLocal2 = f20578h;
        long jLongValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            C3434j c3434jMo4384a = interfaceC10803a.mo4384a(context, str, f20579i);
            int i = c3434jMo4384a.f9618a;
            int i2 = c3434jMo4384a.f9619b;
            StringBuilder sb = new StringBuilder(str.length() + 68 + str.length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            int i3 = c3434jMo4384a.f9620c;
            if (i3 == 0 || ((i3 == -1 && c3434jMo4384a.f9618a == 0) || (i3 == 1 && c3434jMo4384a.f9619b == 0))) {
                int i4 = c3434jMo4384a.f9618a;
                int i5 = c3434jMo4384a.f9619b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(".");
                throw new LoadingException(sb2.toString());
            }
            if (i3 == -1) {
                DynamiteModule dynamiteModuleM9047g = m9047g(context, str);
                if (jLongValue == 0) {
                    threadLocal2.remove();
                } else {
                    threadLocal2.set(Long.valueOf(jLongValue));
                }
                Cursor cursor = c3431g2.f9616a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(c3431g);
                return dynamiteModuleM9047g;
            }
            if (i3 != 1) {
                throw new LoadingException("VersionPolicy returned invalid code:0");
            }
            try {
                int i6 = c3434jMo4384a.f9619b;
                try {
                    synchronized (DynamiteModule.class) {
                        bool = f20574d;
                    }
                    if (bool == null) {
                        throw new LoadingException("Failed to determine which loading route to use.");
                    }
                    if (bool.booleanValue()) {
                        StringBuilder sb3 = new StringBuilder(str.length() + 51);
                        sb3.append("Selected remote version of ");
                        sb3.append(str);
                        sb3.append(", version >= ");
                        sb3.append(i6);
                        Log.i("DynamiteModule", sb3.toString());
                        synchronized (DynamiteModule.class) {
                            c3436l = f20581k;
                        }
                        if (c3436l == null) {
                            throw new LoadingException("DynamiteLoaderV2 was not cached.");
                        }
                        C3431g c3431g3 = threadLocal.get();
                        if (c3431g3 == null || c3431g3.f9616a == null) {
                            throw new LoadingException("No result cursor");
                        }
                        Context applicationContext = context.getApplicationContext();
                        Cursor cursor2 = c3431g3.f9616a;
                        new BinderC3423b(null);
                        synchronized (DynamiteModule.class) {
                            boolValueOf = Boolean.valueOf(f20576f >= 2);
                        }
                        if (boolValueOf.booleanValue()) {
                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                            interfaceC3422aM4389i = c3436l.m4390t0(new BinderC3423b(applicationContext), str, i6, new BinderC3423b(cursor2));
                        } else {
                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                            interfaceC3422aM4389i = c3436l.m4389i(new BinderC3423b(applicationContext), str, i6, new BinderC3423b(cursor2));
                        }
                        Context context2 = (Context) BinderC3423b.m4381i(interfaceC3422aM4389i);
                        if (context2 == null) {
                            throw new LoadingException("Failed to get module context");
                        }
                        dynamiteModule = new DynamiteModule(context2);
                    } else {
                        StringBuilder sb4 = new StringBuilder(str.length() + 51);
                        sb4.append("Selected remote version of ");
                        sb4.append(str);
                        sb4.append(", version >= ");
                        sb4.append(i6);
                        Log.i("DynamiteModule", sb4.toString());
                        C3435k c3435kM9049i = m9049i(context);
                        if (c3435kM9049i == null) {
                            throw new LoadingException("Failed to create IDynamiteLoader.");
                        }
                        Parcel parcelM4407c = c3435kM9049i.m4407c(6, c3435kM9049i.m4408g());
                        int i7 = parcelM4407c.readInt();
                        parcelM4407c.recycle();
                        if (i7 >= 3) {
                            C3431g c3431g4 = threadLocal.get();
                            if (c3431g4 == null) {
                                throw new LoadingException("No cached result cursor holder");
                            }
                            interfaceC3422aM4385i = c3435kM9049i.m4388v0(new BinderC3423b(context), str, i6, new BinderC3423b(c3431g4.f9616a));
                        } else if (i7 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                            interfaceC3422aM4385i = c3435kM9049i.m4386t0(new BinderC3423b(context), str, i6);
                        } else {
                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                            interfaceC3422aM4385i = c3435kM9049i.m4385i(new BinderC3423b(context), str, i6);
                        }
                        if (BinderC3423b.m4381i(interfaceC3422aM4385i) == null) {
                            throw new LoadingException("Failed to load remote module.");
                        }
                        dynamiteModule = new DynamiteModule((Context) BinderC3423b.m4381i(interfaceC3422aM4385i));
                    }
                    if (jLongValue == 0) {
                        threadLocal2.remove();
                    } else {
                        threadLocal2.set(Long.valueOf(jLongValue));
                    }
                    Cursor cursor3 = c3431g2.f9616a;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    threadLocal.set(c3431g);
                    return dynamiteModule;
                } catch (RemoteException e) {
                    throw new LoadingException("Failed to load remote module.", e);
                } catch (LoadingException e2) {
                    throw e2;
                } catch (Throwable th) {
                    try {
                        Objects.requireNonNull(context, "null reference");
                    } catch (Exception e3) {
                        Log.e("CrashUtils", "Error adding exception to DropBox!", e3);
                    }
                    throw new LoadingException("Failed to load remote module.", th);
                }
            } catch (LoadingException e4) {
                String strValueOf = String.valueOf(e4.getMessage());
                Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to load remote module: ".concat(strValueOf) : new String("Failed to load remote module: "));
                int i8 = c3434jMo4384a.f9618a;
                if (i8 == 0 || interfaceC10803a.mo4384a(context, str, new C3432h(i8)).f9620c != -1) {
                    throw new LoadingException("Remote load failed. No local fallback found.", e4);
                }
                DynamiteModule dynamiteModuleM9047g2 = m9047g(context, str);
                if (jLongValue == 0) {
                    f20578h.remove();
                } else {
                    f20578h.set(Long.valueOf(jLongValue));
                }
                Cursor cursor4 = c3431g2.f9616a;
                if (cursor4 != null) {
                    cursor4.close();
                }
                f20577g.set(c3431g);
                return dynamiteModuleM9047g2;
            }
        } catch (Throwable th2) {
            if (jLongValue == 0) {
                f20578h.remove();
            } else {
                f20578h.set(Long.valueOf(jLongValue));
            }
            Cursor cursor5 = c3431g2.f9616a;
            if (cursor5 != null) {
                cursor5.close();
            }
            f20577g.set(c3431g);
            throw th2;
        }
    }

    /* JADX INFO: renamed from: d */
    public static int m9044d(@RecentlyNonNull Context context, @RecentlyNonNull String str, boolean z2) {
        ClassLoader c3425a;
        Throwable th;
        Cursor cursor;
        RemoteException e;
        int i;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f20574d;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader != null) {
                                    if (classLoader == ClassLoader.getSystemClassLoader()) {
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            m9048h(classLoader);
                                        } catch (LoadingException unused) {
                                        }
                                        bool = Boolean.TRUE;
                                    }
                                } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int iM9045e = m9045e(context, str, z2);
                                        String str2 = f20575e;
                                        if (str2 != null && !str2.isEmpty()) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                String str3 = f20575e;
                                                Objects.requireNonNull(str3, "null reference");
                                                c3425a = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str4 = f20575e;
                                                Objects.requireNonNull(str4, "null reference");
                                                c3425a = new C3425a(str4, ClassLoader.getSystemClassLoader());
                                            }
                                            m9048h(c3425a);
                                            declaredField.set(null, c3425a);
                                            f20574d = Boolean.TRUE;
                                            return iM9045e;
                                        }
                                        return iM9045e;
                                    } catch (LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                                f20574d = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String strValueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(strValueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return m9045e(context, str, z2);
                    } catch (LoadingException e3) {
                        String strValueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", strValueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                C3435k c3435kM9049i = m9049i(context);
                try {
                    if (c3435kM9049i == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelM4407c = c3435kM9049i.m4407c(6, c3435kM9049i.m4408g());
                        int i2 = parcelM4407c.readInt();
                        parcelM4407c.recycle();
                        if (i2 >= 3) {
                            cursor = (Cursor) BinderC3423b.m4381i(c3435kM9049i.m4387u0(new BinderC3423b(context), str, z2, f20578h.get().longValue()));
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        i = cursor.getInt(0);
                                        cursor2 = (i <= 0 || !m9046f(cursor)) ? cursor : null;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (RemoteException e4) {
                                    e = e4;
                                    cursor2 = cursor;
                                    String strValueOf3 = String.valueOf(e.getMessage());
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
                        if (i2 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            BinderC3423b binderC3423b = new BinderC3423b(context);
                            Parcel parcelM4408g = c3435kM9049i.m4408g();
                            C3483c.m4410b(parcelM4408g, binderC3423b);
                            parcelM4408g.writeString(str);
                            parcelM4408g.writeInt(z2 ? 1 : 0);
                            Parcel parcelM4407c2 = c3435kM9049i.m4407c(5, parcelM4408g);
                            i = parcelM4407c2.readInt();
                            parcelM4407c2.recycle();
                        } else {
                            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            BinderC3423b binderC3423b2 = new BinderC3423b(context);
                            Parcel parcelM4408g2 = c3435kM9049i.m4408g();
                            C3483c.m4410b(parcelM4408g2, binderC3423b2);
                            parcelM4408g2.writeString(str);
                            parcelM4408g2.writeInt(z2 ? 1 : 0);
                            Parcel parcelM4407c3 = c3435kM9049i.m4407c(3, parcelM4408g2);
                            i = parcelM4407c3.readInt();
                            parcelM4407c3.recycle();
                        }
                        return i;
                    } catch (RemoteException e5) {
                        e = e5;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                }
            }
        } catch (Throwable th5) {
            try {
                Objects.requireNonNull(context, "null reference");
            } catch (Exception e6) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e6);
            }
            throw th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX INFO: renamed from: e */
    public static int m9045e(Context context, String str, boolean z2) throws Throwable {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z2 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(f20578h.get().longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    f20575e = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        f20576f = cursorQuery.getInt(columnIndex);
                                    }
                                }
                                cursor = m9046f(cursorQuery) ? null : cursorQuery;
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (e instanceof LoadingException) {
                            throw e;
                        }
                        throw new LoadingException("V2 version check failed", e);
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
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.");
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: renamed from: f */
    public static boolean m9046f(Cursor cursor) {
        C3431g c3431g = f20577g.get();
        if (c3431g == null || c3431g.f9616a != null) {
            return false;
        }
        c3431g.f9616a = cursor;
        return true;
    }

    /* JADX INFO: renamed from: g */
    public static DynamiteModule m9047g(Context context, String str) {
        String strValueOf = String.valueOf(str);
        Log.i("DynamiteModule", strValueOf.length() != 0 ? "Selected local version of ".concat(strValueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    /* JADX INFO: renamed from: h */
    public static void m9048h(ClassLoader classLoader) throws LoadingException {
        C3436l c3436l;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                c3436l = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                c3436l = iInterfaceQueryLocalInterface instanceof C3436l ? (C3436l) iInterfaceQueryLocalInterface : new C3436l(iBinder);
            }
            f20581k = c3436l;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: i */
    public static C3435k m9049i(Context context) {
        C3435k c3435k;
        synchronized (DynamiteModule.class) {
            C3435k c3435k2 = f20580j;
            if (c3435k2 != null) {
                return c3435k2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    c3435k = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    c3435k = iInterfaceQueryLocalInterface instanceof C3435k ? (C3435k) iInterfaceQueryLocalInterface : new C3435k(iBinder);
                }
                if (c3435k != null) {
                    f20580j = c3435k;
                    return c3435k;
                }
            } catch (Exception e) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: b */
    public IBinder m9050b(@RecentlyNonNull String str) throws LoadingException {
        try {
            return (IBinder) this.f20582l.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException(str.length() != 0 ? "Failed to instantiate module class: ".concat(str) : new String("Failed to instantiate module class: "), e);
        }
    }
}
