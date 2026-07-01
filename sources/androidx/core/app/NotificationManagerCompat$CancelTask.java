package androidx.core.app;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import x.a.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class NotificationManagerCompat$CancelTask implements NotificationManagerCompat$Task {
    public final boolean all;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f34id;
    public final String packageName;
    public final String tag;

    public NotificationManagerCompat$CancelTask(String str) {
        this.packageName = str;
        this.f34id = 0;
        this.tag = null;
        this.all = true;
    }

    @Override // androidx.core.app.NotificationManagerCompat$Task
    public void send(a aVar) throws RemoteException {
        if (this.all) {
            aVar.cancelAll(this.packageName);
        } else {
            aVar.cancel(this.packageName, this.f34id, this.tag);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("CancelTask[");
        sb.append("packageName:");
        sb.append(this.packageName);
        sb.append(", id:");
        sb.append(this.f34id);
        sb.append(", tag:");
        sb.append(this.tag);
        sb.append(", all:");
        return b.d.b.a.a.O(sb, this.all, "]");
    }

    public NotificationManagerCompat$CancelTask(String str, int i, String str2) {
        this.packageName = str;
        this.f34id = i;
        this.tag = str2;
        this.all = false;
    }
}
