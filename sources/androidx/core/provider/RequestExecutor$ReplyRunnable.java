package androidx.core.provider;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class RequestExecutor$ReplyRunnable<T> implements Runnable {

    @NonNull
    private Callable<T> mCallable;

    @NonNull
    private Consumer<T> mConsumer;

    @NonNull
    private Handler mHandler;

    public RequestExecutor$ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        this.mCallable = callable;
        this.mConsumer = consumer;
        this.mHandler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        T tCall;
        try {
            tCall = this.mCallable.call();
        } catch (Exception unused) {
            tCall = null;
        }
        this.mHandler.post(new RequestExecutor$ReplyRunnable$1(this, this.mConsumer, tCall));
    }
}
