package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ String val$parentId;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, String str, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        this.val$parentId = str;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<IBinder> it = this.this$1.this$0.mConnections.keySet().iterator();
        while (it.hasNext()) {
            this.this$1.notifyChildrenChangedForCompatOnHandler(this.this$1.this$0.mConnections.get(it.next()), this.val$parentId, this.val$options);
        }
    }
}
