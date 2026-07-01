package android.support.v4.media;

import android.os.Bundle;
import androidx.media.MediaBrowserCompatUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$j {
    public final List<MediaBrowserCompat$k> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Bundle> f18b = new ArrayList();

    public MediaBrowserCompat$k a(Bundle bundle) {
        for (int i = 0; i < this.f18b.size(); i++) {
            if (MediaBrowserCompatUtils.areSameOptions(this.f18b.get(i), bundle)) {
                return this.a.get(i);
            }
        }
        return null;
    }
}
