package androidx.core.app;

import android.app.Notification;
import android.os.Binder;
import android.os.RemoteException;
import x.a.b.a.a$a;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompatSideChannelService$NotificationSideChannelStub extends a$a {
    public final /* synthetic */ NotificationCompatSideChannelService this$0;

    public NotificationCompatSideChannelService$NotificationSideChannelStub(NotificationCompatSideChannelService notificationCompatSideChannelService) {
        this.this$0 = notificationCompatSideChannelService;
    }

    @Override // x.a.b.a.a
    public void cancel(String str, int i, String str2) throws RemoteException {
        this.this$0.checkPermission(Binder.getCallingUid(), str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.this$0.cancel(str, i, str2);
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // x.a.b.a.a
    public void cancelAll(String str) {
        this.this$0.checkPermission(Binder.getCallingUid(), str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.this$0.cancelAll(str);
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // x.a.b.a.a
    public void notify(String str, int i, String str2, Notification notification) throws RemoteException {
        this.this$0.checkPermission(Binder.getCallingUid(), str);
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.this$0.notify(str, i, str2, notification);
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
