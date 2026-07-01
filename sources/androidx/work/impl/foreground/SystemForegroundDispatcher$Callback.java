package androidx.work.impl.foreground;

import android.app.Notification;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface SystemForegroundDispatcher$Callback {
    void cancelNotification(int i);

    void notify(int i, @NonNull Notification notification);

    void startForeground(int i, int i2, @NonNull Notification notification);

    void stop();
}
