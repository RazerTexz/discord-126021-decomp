package androidx.appcompat.app;

import android.content.res.Resources$NotFoundException;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$1 implements Thread$UncaughtExceptionHandler {
    public final /* synthetic */ Thread$UncaughtExceptionHandler val$defHandler;

    public AppCompatDelegateImpl$1(Thread$UncaughtExceptionHandler thread$UncaughtExceptionHandler) {
        this.val$defHandler = thread$UncaughtExceptionHandler;
    }

    private boolean shouldWrapException(Throwable th) {
        String message;
        if (!(th instanceof Resources$NotFoundException) || (message = th.getMessage()) == null) {
            return false;
        }
        return message.contains("drawable") || message.contains("Drawable");
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        if (!shouldWrapException(th)) {
            this.val$defHandler.uncaughtException(thread, th);
            return;
        }
        Resources$NotFoundException resources$NotFoundException = new Resources$NotFoundException(th.getMessage() + AppCompatDelegateImpl.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
        resources$NotFoundException.initCause(th.getCause());
        resources$NotFoundException.setStackTrace(th.getStackTrace());
        this.val$defHandler.uncaughtException(thread, resources$NotFoundException);
    }
}
