package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.PeriodicWorkRequest;
import d0.z.d.Intrinsics3;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: androidx.work.PeriodicWorkRequestKt, reason: use source file name */
/* JADX INFO: compiled from: PeriodicWorkRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PeriodicWorkRequest2 {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "repeatIntervalTimeUnit");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, timeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration) {
        Intrinsics3.checkParameterIsNotNull(duration, "repeatInterval");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, duration);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "repeatIntervalTimeUnit");
        Intrinsics3.checkParameterIsNotNull(timeUnit2, "flexTimeIntervalUnit");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, j, timeUnit, j2, timeUnit2);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        Intrinsics3.checkParameterIsNotNull(duration, "repeatInterval");
        Intrinsics3.checkParameterIsNotNull(duration2, "flexTimeInterval");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, duration, duration2);
    }
}
