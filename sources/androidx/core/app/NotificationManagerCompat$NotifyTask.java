package androidx.core.app;

import android.app.Notification;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import x.a.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class NotificationManagerCompat$NotifyTask implements NotificationManagerCompat$Task {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f35id;
    public final Notification notif;
    public final String packageName;
    public final String tag;

    public NotificationManagerCompat$NotifyTask(String str, int i, String str2, Notification notification) {
        this.packageName = str;
        this.f35id = i;
        this.tag = str2;
        this.notif = notification;
    }

    @Override // androidx.core.app.NotificationManagerCompat$Task
    public void send(a aVar) throws RemoteException {
        aVar.notify(this.packageName, this.f35id, this.tag, this.notif);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("NotifyTask[");
        sb.append("packageName:");
        sb.append(this.packageName);
        sb.append(", id:");
        sb.append(this.f35id);
        sb.append(", tag:");
        return b.d.b.a.a.J(sb, this.tag, "]");
    }
}
