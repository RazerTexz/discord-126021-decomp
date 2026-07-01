package androidx.core.app;

import android.content.ComponentName;
import java.util.ArrayDeque;
import x.a.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class NotificationManagerCompat$SideChannelManager$ListenerRecord {
    public final ComponentName componentName;
    public a service;
    public boolean bound = false;
    public ArrayDeque<NotificationManagerCompat$Task> taskQueue = new ArrayDeque<>();
    public int retryCount = 0;

    public NotificationManagerCompat$SideChannelManager$ListenerRecord(ComponentName componentName) {
        this.componentName = componentName;
    }
}
