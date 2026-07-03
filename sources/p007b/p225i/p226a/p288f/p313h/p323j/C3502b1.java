package p007b.p225i.p226a.p288f.p313h.p323j;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.i.a.f.h.j.b1 */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(24)
public final class C3502b1 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public static final Method f9674a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public static final Method f9675b;

    /* JADX INFO: renamed from: c */
    public static volatile InterfaceC3508d1 f9676c;

    static {
        Method declaredMethod;
        Method declaredMethod2 = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
                declaredMethod = null;
            }
        } else {
            declaredMethod = null;
        }
        f9674a = declaredMethod;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod2 = UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused2) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        f9675b = declaredMethod2;
        f9676c = C3505c1.f9683a;
    }
}
