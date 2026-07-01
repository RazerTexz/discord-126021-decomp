package androidx.core.app;

import android.content.ComponentName;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class NotificationManagerCompat$ServiceConnectedEvent {
    public final ComponentName componentName;
    public final IBinder iBinder;

    public NotificationManagerCompat$ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
        this.componentName = componentName;
        this.iBinder = iBinder;
    }
}
