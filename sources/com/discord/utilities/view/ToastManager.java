package com.discord.utilities.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import java.io.Closeable;

/* JADX INFO: compiled from: ToastManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ToastManager implements Closeable {
    private Toast toast;

    public static /* synthetic */ void show$default(ToastManager toastManager, Context context, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        toastManager.show(context, i, i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Toast toast = this.toast;
        if (toast != null) {
            toast.cancel();
        }
        this.toast = null;
    }

    @MainThread
    public final void show(Context context, @StringRes int i) {
        show$default(this, context, i, 0, 4, (Object) null);
    }

    @MainThread
    public final void show(Context context, @StringRes int stringRes, int duration) {
        Intrinsics3.checkNotNullParameter(context, "context");
        show(context, context.getString(stringRes), duration);
    }

    @SuppressLint({"ShowToast"})
    @MainThread
    public void show(Context context, CharSequence text, int duration) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Toast toastMakeText = Toast.makeText(context, text, duration);
        Intrinsics3.checkNotNullExpressionValue(toastMakeText, "Toast.makeText(context, text, duration)");
        show(toastMakeText);
    }

    public static /* synthetic */ void show$default(ToastManager toastManager, Context context, CharSequence charSequence, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            toastManager.show(context, charSequence, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    @MainThread
    public void show(Toast newToast) {
        Intrinsics3.checkNotNullParameter(newToast, "newToast");
        Toast toast = this.toast;
        if (toast != null) {
            toast.cancel();
        }
        newToast.show();
        this.toast = newToast;
    }
}
