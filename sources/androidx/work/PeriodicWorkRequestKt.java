package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PeriodicWorkRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest$Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit) {
        m.checkParameterIsNotNull(timeUnit, "repeatIntervalTimeUnit");
        m.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest$Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, timeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest$Builder PeriodicWorkRequestBuilder(Duration duration) {
        m.checkParameterIsNotNull(duration, "repeatInterval");
        m.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest$Builder(ListenableWorker.class, duration);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest$Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        m.checkParameterIsNotNull(timeUnit, "repeatIntervalTimeUnit");
        m.checkParameterIsNotNull(timeUnit2, "flexTimeIntervalUnit");
        m.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest$Builder(ListenableWorker.class, j, timeUnit, j2, timeUnit2);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest$Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        m.checkParameterIsNotNull(duration, "repeatInterval");
        m.checkParameterIsNotNull(duration2, "flexTimeInterval");
        m.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new PeriodicWorkRequest$Builder((Class<? extends ListenableWorker>) ListenableWorker.class, duration, duration2);
    }
}
