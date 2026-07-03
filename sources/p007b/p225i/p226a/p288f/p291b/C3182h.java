package p007b.p225i.p226a.p288f.p291b;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.FutureTask;
import p007b.p225i.p226a.p288f.p291b.C3180f;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.a.f.b.h */
/* JADX INFO: loaded from: classes3.dex */
public final class C3182h<T> extends FutureTask<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C3180f.a f9202j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3182h(C3180f.a aVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f9202j = aVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = C3180f.this.f9199e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
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
