package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import b.d.b.a.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    private static final float EPSILON = 1.0E-5f;

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    public static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    public static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    public static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static final int RESULT_OK = 0;

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    public MediaBrowserServiceCompat$ConnectionRecord mCurConnection;
    private MediaBrowserServiceCompat$MediaBrowserServiceImpl mImpl;
    public MediaSessionCompat$Token mSession;
    public static final String TAG = "MBServiceCompat";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public final MediaBrowserServiceCompat$ConnectionRecord mConnectionFromFwk = new MediaBrowserServiceCompat$ConnectionRecord(this, MediaSessionManager$RemoteUserInfo.LEGACY_CONTROLLER, -1, -1, null, null);
    public final ArrayList<MediaBrowserServiceCompat$ConnectionRecord> mPendingConnections = new ArrayList<>();
    public final ArrayMap<IBinder, MediaBrowserServiceCompat$ConnectionRecord> mConnections = new ArrayMap<>();
    public final MediaBrowserServiceCompat$ServiceHandler mHandler = new MediaBrowserServiceCompat$ServiceHandler(this);

    public void addSubscription(String str, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> arrayList = mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (Pair<IBinder, Bundle> pair : arrayList) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        arrayList.add(new Pair<>(iBinder, bundle));
        mediaBrowserServiceCompat$ConnectionRecord.subscriptions.put(str, arrayList);
        performLoadChildren(str, mediaBrowserServiceCompat$ConnectionRecord, bundle, null);
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        onSubscribe(str, bundle);
        this.mCurConnection = null;
    }

    public List<MediaBrowserCompat$MediaItem> applyOptions(List<MediaBrowserCompat$MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int size = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.emptyList();
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i3, size);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @NonNull
    public final MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    @Nullable
    public MediaSessionCompat$Token getSessionToken() {
        return this.mSession;
    }

    public boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i = Build$VERSION.SDK_INT;
        if (i >= 28) {
            this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi28(this);
        } else if (i >= 26) {
            this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi26(this);
        } else if (i >= 23) {
            this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(this);
        } else {
            this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(this);
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull MediaBrowserServiceCompat$Result<Bundle> mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.sendError(null);
    }

    @Nullable
    public abstract MediaBrowserServiceCompat$BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> mediaBrowserServiceCompat$Result);

    public void onLoadChildren(@NonNull String str, @NonNull MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> mediaBrowserServiceCompat$Result, @NonNull Bundle bundle) {
        mediaBrowserServiceCompat$Result.setFlags(1);
        onLoadChildren(str, mediaBrowserServiceCompat$Result);
    }

    public void onLoadItem(String str, @NonNull MediaBrowserServiceCompat$Result<MediaBrowserCompat$MediaItem> mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.setFlags(2);
        mediaBrowserServiceCompat$Result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.setFlags(4);
        mediaBrowserServiceCompat$Result.sendResult(null);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public void onSubscribe(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public void onUnsubscribe(String str) {
    }

    public void performCustomAction(String str, Bundle bundle, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, ResultReceiver resultReceiver) {
        MediaBrowserServiceCompat$4 mediaBrowserServiceCompat$4 = new MediaBrowserServiceCompat$4(this, str, resultReceiver);
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        onCustomAction(str, bundle, mediaBrowserServiceCompat$4);
        this.mCurConnection = null;
        if (mediaBrowserServiceCompat$4.isDone()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    public void performLoadChildren(String str, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, Bundle bundle, Bundle bundle2) {
        MediaBrowserServiceCompat$1 mediaBrowserServiceCompat$1 = new MediaBrowserServiceCompat$1(this, str, mediaBrowserServiceCompat$ConnectionRecord, str, bundle, bundle2);
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        if (bundle == null) {
            onLoadChildren(str, mediaBrowserServiceCompat$1);
        } else {
            onLoadChildren(str, mediaBrowserServiceCompat$1, bundle);
        }
        this.mCurConnection = null;
        if (!mediaBrowserServiceCompat$1.isDone()) {
            throw new IllegalStateException(a.K(a.U("onLoadChildren must call detach() or sendResult() before returning for package="), mediaBrowserServiceCompat$ConnectionRecord.pkg, " id=", str));
        }
    }

    public void performLoadItem(String str, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, ResultReceiver resultReceiver) {
        MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2 = new MediaBrowserServiceCompat$2(this, str, resultReceiver);
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        onLoadItem(str, mediaBrowserServiceCompat$2);
        this.mCurConnection = null;
        if (!mediaBrowserServiceCompat$2.isDone()) {
            throw new IllegalStateException(a.w("onLoadItem must call detach() or sendResult() before returning for id=", str));
        }
    }

    public void performSearch(String str, Bundle bundle, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, ResultReceiver resultReceiver) {
        MediaBrowserServiceCompat$3 mediaBrowserServiceCompat$3 = new MediaBrowserServiceCompat$3(this, str, resultReceiver);
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        onSearch(str, bundle, mediaBrowserServiceCompat$3);
        this.mCurConnection = null;
        if (!mediaBrowserServiceCompat$3.isDone()) {
            throw new IllegalStateException(a.w("onSearch must call detach() or sendResult() before returning for query=", str));
        }
    }

    public boolean removeSubscription(String str, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, IBinder iBinder) {
        boolean z2 = false;
        try {
            if (iBinder == null) {
                boolean z3 = mediaBrowserServiceCompat$ConnectionRecord.subscriptions.remove(str) != null;
                this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
                onUnsubscribe(str);
                this.mCurConnection = null;
                return z3;
            }
            List<Pair<IBinder, Bundle>> list = mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator<Pair<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().first) {
                        it.remove();
                        z2 = true;
                    }
                }
                if (list.size() == 0) {
                    mediaBrowserServiceCompat$ConnectionRecord.subscriptions.remove(str);
                }
            }
            this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
            return z2;
        } catch (Throwable th) {
            this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
            throw th;
        }
    }

    public void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token) {
        if (mediaSessionCompat$Token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.mSession = mediaSessionCompat$Token;
        this.mImpl.setSessionToken(mediaSessionCompat$Token);
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle != null) {
            this.mImpl.notifyChildrenChanged(str, bundle);
            return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void notifyChildrenChanged(@NonNull MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (mediaSessionManager$RemoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle != null) {
            this.mImpl.notifyChildrenChanged(mediaSessionManager$RemoteUserInfo, str, bundle);
            return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
}
