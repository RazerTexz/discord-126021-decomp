package androidx.media;

import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi26(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public Bundle getBrowserRootHints() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = mediaBrowserServiceCompat.mCurConnection;
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
        if (mediaBrowserServiceCompat$ConnectionRecord == mediaBrowserServiceCompat.mConnectionFromFwk) {
            return this.mServiceFwk.getBrowserRootHints();
        }
        if (mediaBrowserServiceCompat$ConnectionRecord.rootHints == null) {
            return null;
        }
        return new Bundle(this.this$0.mCurConnection.rootHints);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
    public void notifyChildrenChangedForFramework(String str, Bundle bundle) {
        if (bundle != null) {
            this.mServiceFwk.notifyChildrenChanged(str, bundle);
        } else {
            super.notifyChildrenChangedForFramework(str, bundle);
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26(this, this.this$0);
        this.mServiceFwk = mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26;
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.onCreate();
    }

    public void onLoadChildren(String str, MediaBrowserServiceCompat$ResultWrapper<List<Parcel>> mediaBrowserServiceCompat$ResultWrapper, Bundle bundle) {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1(this, str, mediaBrowserServiceCompat$ResultWrapper, bundle);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        mediaBrowserServiceCompat.mCurConnection = mediaBrowserServiceCompat.mConnectionFromFwk;
        mediaBrowserServiceCompat.onLoadChildren(str, mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1, bundle);
        this.this$0.mCurConnection = null;
    }
}
