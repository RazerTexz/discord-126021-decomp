package androidx.media;

import android.content.Intent;
import android.media.session.MediaSession$Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x.a.b.b.a.b;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    public Messenger mMessenger;
    public final List<Bundle> mRootExtrasList = new ArrayList();
    public MediaBrowserService mServiceFwk;
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public Bundle getBrowserRootHints() {
        if (this.mMessenger == null) {
            return null;
        }
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = this.this$0.mCurConnection;
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
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
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(String str, Bundle bundle) {
        notifyChildrenChangedForFramework(str, bundle);
        notifyChildrenChangedForCompat(str, bundle);
    }

    public void notifyChildrenChangedForCompat(String str, Bundle bundle) {
        this.this$0.mHandler.post(new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3(this, str, bundle));
    }

    public void notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, String str, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(str);
        if (list != null) {
            for (Pair<IBinder, Bundle> pair : list) {
                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                    this.this$0.performLoadChildren(str, mediaBrowserServiceCompat$ConnectionRecord, pair.second, bundle);
                }
            }
        }
    }

    public void notifyChildrenChangedForFramework(String str, Bundle bundle) {
        this.mServiceFwk.notifyChildrenChanged(str);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public IBinder onBind(Intent intent) {
        return this.mServiceFwk.onBind(intent);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21(this, this.this$0);
        this.mServiceFwk = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21;
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21.onCreate();
    }

    public MediaBrowserServiceCompat$BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        Bundle extras;
        int i2;
        if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
            extras = null;
            i2 = -1;
        } else {
            bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
            this.mMessenger = new Messenger(this.this$0.mHandler);
            extras = new Bundle();
            extras.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            BundleCompat.putBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
            MediaSessionCompat$Token mediaSessionCompat$Token = this.this$0.mSession;
            if (mediaSessionCompat$Token != null) {
                b bVarB = mediaSessionCompat$Token.b();
                BundleCompat.putBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER, bVarB == null ? null : bVarB.asBinder());
            } else {
                this.mRootExtrasList.add(extras);
            }
            int i3 = bundle.getInt(MediaBrowserProtocol.EXTRA_CALLING_PID, -1);
            bundle.remove(MediaBrowserProtocol.EXTRA_CALLING_PID);
            i2 = i3;
        }
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(this.this$0, str, i2, i, bundle, null);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        mediaBrowserServiceCompat.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        MediaBrowserServiceCompat$BrowserRoot mediaBrowserServiceCompat$BrowserRootOnGetRoot = mediaBrowserServiceCompat.onGetRoot(str, i, bundle);
        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = this.this$0;
        mediaBrowserServiceCompat2.mCurConnection = null;
        if (mediaBrowserServiceCompat$BrowserRootOnGetRoot == null) {
            return null;
        }
        if (this.mMessenger != null) {
            mediaBrowserServiceCompat2.mPendingConnections.add(mediaBrowserServiceCompat$ConnectionRecord);
        }
        if (extras == null) {
            extras = mediaBrowserServiceCompat$BrowserRootOnGetRoot.getExtras();
        } else if (mediaBrowserServiceCompat$BrowserRootOnGetRoot.getExtras() != null) {
            extras.putAll(mediaBrowserServiceCompat$BrowserRootOnGetRoot.getExtras());
        }
        return new MediaBrowserServiceCompat$BrowserRoot(mediaBrowserServiceCompat$BrowserRootOnGetRoot.getRootId(), extras);
    }

    public void onLoadChildren(String str, MediaBrowserServiceCompat$ResultWrapper<List<Parcel>> mediaBrowserServiceCompat$ResultWrapper) {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2(this, str, mediaBrowserServiceCompat$ResultWrapper);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        mediaBrowserServiceCompat.mCurConnection = mediaBrowserServiceCompat.mConnectionFromFwk;
        mediaBrowserServiceCompat.onLoadChildren(str, mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2);
        this.this$0.mCurConnection = null;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1(this, mediaSessionCompat$Token));
    }

    public void setSessionTokenOnHandler(MediaSessionCompat$Token mediaSessionCompat$Token) {
        if (!this.mRootExtrasList.isEmpty()) {
            b bVarB = mediaSessionCompat$Token.b();
            if (bVarB != null) {
                Iterator<Bundle> it = this.mRootExtrasList.iterator();
                while (it.hasNext()) {
                    BundleCompat.putBinder(it.next(), MediaBrowserProtocol.EXTRA_SESSION_BINDER, bVarB.asBinder());
                }
            }
            this.mRootExtrasList.clear();
        }
        this.mServiceFwk.setSessionToken((MediaSession$Token) mediaSessionCompat$Token.k);
    }

    public void notifyChildrenChangedForCompat(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String str, Bundle bundle) {
        this.this$0.mHandler.post(new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4(this, mediaSessionManager$RemoteUserInfo, str, bundle));
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String str, Bundle bundle) {
        notifyChildrenChangedForCompat(mediaSessionManager$RemoteUserInfo, str, bundle);
    }
}
