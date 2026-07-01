package androidx.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.util.Log;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$1 extends MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final /* synthetic */ MediaBrowserServiceCompat$ConnectionRecord val$connection;
    public final /* synthetic */ Bundle val$notifyChildrenChangedOptions;
    public final /* synthetic */ String val$parentId;
    public final /* synthetic */ Bundle val$subscribeOptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$1(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, String str, Bundle bundle, Bundle bundle2) {
        super(obj);
        this.this$0 = mediaBrowserServiceCompat;
        this.val$connection = mediaBrowserServiceCompat$ConnectionRecord;
        this.val$parentId = str;
        this.val$subscribeOptions = bundle;
        this.val$notifyChildrenChangedOptions = bundle2;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public /* bridge */ /* synthetic */ void onResultSent(@Nullable List<MediaBrowserCompat$MediaItem> list) {
        onResultSent2(list);
    }

    /* JADX INFO: renamed from: onResultSent, reason: avoid collision after fix types in other method */
    public void onResultSent2(@Nullable List<MediaBrowserCompat$MediaItem> list) {
        if (this.this$0.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
            if (MediaBrowserServiceCompat.DEBUG) {
                StringBuilder sbU = a.U("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                sbU.append(this.val$connection.pkg);
                sbU.append(" id=");
                sbU.append(this.val$parentId);
                Log.d(MediaBrowserServiceCompat.TAG, sbU.toString());
                return;
            }
            return;
        }
        if ((getFlags() & 1) != 0) {
            list = this.this$0.applyOptions(list, this.val$subscribeOptions);
        }
        try {
            this.val$connection.callbacks.onLoadChildren(this.val$parentId, list, this.val$subscribeOptions, this.val$notifyChildrenChangedOptions);
        } catch (RemoteException unused) {
            StringBuilder sbU2 = a.U("Calling onLoadChildren() failed for id=");
            sbU2.append(this.val$parentId);
            sbU2.append(" package=");
            a.r0(sbU2, this.val$connection.pkg, MediaBrowserServiceCompat.TAG);
        }
    }
}
