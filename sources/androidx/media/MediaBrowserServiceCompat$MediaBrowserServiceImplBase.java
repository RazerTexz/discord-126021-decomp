package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$MediaBrowserServiceImplBase implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    private Messenger mMessenger;
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public Bundle getBrowserRootHints() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = this.this$0.mCurConnection;
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
        if (mediaBrowserServiceCompat$ConnectionRecord.rootHints == null) {
            return null;
        }
        return new Bundle(this.this$0.mCurConnection.rootHints);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = this.this$0.mCurConnection;
        if (mediaBrowserServiceCompat$ConnectionRecord != null) {
            return mediaBrowserServiceCompat$ConnectionRecord.browserInfo;
        }
        throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(@NonNull String str, Bundle bundle) {
        this.this$0.mHandler.post(new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2(this, str, bundle));
    }

    public void notifyChildrenChangedOnHandler(MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, String str, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(str);
        if (list != null) {
            for (Pair<IBinder, Bundle> pair : list) {
                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                    this.this$0.performLoadChildren(str, mediaBrowserServiceCompat$ConnectionRecord, pair.second, bundle);
                }
            }
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public IBinder onBind(Intent intent) {
        if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
            return this.mMessenger.getBinder();
        }
        return null;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        this.mMessenger = new Messenger(this.this$0.mHandler);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$0.mHandler.post(new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(this, mediaSessionCompat$Token));
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(@NonNull MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, @NonNull String str, Bundle bundle) {
        this.this$0.mHandler.post(new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3(this, mediaSessionManager$RemoteUserInfo, str, bundle));
    }
}
