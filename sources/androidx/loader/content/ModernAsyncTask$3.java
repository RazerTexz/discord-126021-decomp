package androidx.loader.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [Result] */
/* JADX INFO: loaded from: classes.dex */
public class ModernAsyncTask$3<Result> extends FutureTask<Result> {
    public final /* synthetic */ ModernAsyncTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModernAsyncTask$3(ModernAsyncTask modernAsyncTask, Callable callable) {
        super(callable);
        this.this$0 = modernAsyncTask;
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        try {
            this.this$0.postResultIfNotInvoked(get());
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (CancellationException unused) {
            this.this$0.postResultIfNotInvoked(null);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th);
        }
    }
}
