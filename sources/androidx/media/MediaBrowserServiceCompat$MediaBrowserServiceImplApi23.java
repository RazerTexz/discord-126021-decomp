package androidx.media;

import android.os.Parcel;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23(this, this.this$0);
        this.mServiceFwk = mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23;
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23.onCreate();
    }

    public void onLoadItem(String str, MediaBrowserServiceCompat$ResultWrapper<Parcel> mediaBrowserServiceCompat$ResultWrapper) {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1(this, str, mediaBrowserServiceCompat$ResultWrapper);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        mediaBrowserServiceCompat.mCurConnection = mediaBrowserServiceCompat.mConnectionFromFwk;
        mediaBrowserServiceCompat.onLoadItem(str, mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1);
        this.this$0.mCurConnection = null;
    }
}
