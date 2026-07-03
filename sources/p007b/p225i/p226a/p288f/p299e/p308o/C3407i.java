package p007b.p225i.p226a.p288f.p299e.p308o;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.lang.reflect.Method;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.e.o.i */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3407i {

    /* JADX INFO: renamed from: a */
    @Nullable
    public static final Method f9598a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public static final Method f9599b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public static final Method f9600c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public static final Method f9601d;

    static {
        Method method;
        Method method2;
        Method method3;
        Process.myUid();
        Method method4 = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f9598a = method;
        try {
            method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f9599b = method2;
        try {
            method3 = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        f9600c = method3;
        try {
            WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
        }
        try {
            method4 = WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception unused5) {
        }
        f9601d = method4;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4372a(@RecentlyNonNull Context context) {
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        return C3411b.m4376a(context).f9605a.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }
}
