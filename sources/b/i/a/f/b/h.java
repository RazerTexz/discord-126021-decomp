package b.i.a.f.b;

import android.util.Log;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
public final class h<T> extends FutureTask<T> {
    public final /* synthetic */ f$a j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f$a f_a, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.j = f_a;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Thread$UncaughtExceptionHandler thread$UncaughtExceptionHandler = this.j.j.e;
        if (thread$UncaughtExceptionHandler != null) {
            thread$UncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
            sb.append("MeasurementExecutor: job failed with ");
            sb.append(strValueOf);
            Log.e("GAv4", sb.toString());
        }
        super.setException(th);
    }
}
