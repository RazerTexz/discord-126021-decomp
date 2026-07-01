package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$4 extends MediaBrowserServiceCompat$Result<Bundle> {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final /* synthetic */ ResultReceiver val$receiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$4(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.this$0 = mediaBrowserServiceCompat;
        this.val$receiver = resultReceiver;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public void onErrorSent(@Nullable Bundle bundle) {
        this.val$receiver.b(-1, bundle);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public void onProgressUpdateSent(@Nullable Bundle bundle) {
        this.val$receiver.b(1, bundle);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public /* bridge */ /* synthetic */ void onResultSent(@Nullable Bundle bundle) {
        onResultSent2(bundle);
    }

    /* JADX INFO: renamed from: onResultSent, reason: avoid collision after fix types in other method */
    public void onResultSent2(@Nullable Bundle bundle) {
        this.val$receiver.b(0, bundle);
    }
}
