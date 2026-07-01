package androidx.media;

import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import android.service.media.MediaBrowserService$Result;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaBrowserServiceCompat$ResultWrapper<T> {
    public MediaBrowserService$Result mResultFwk;

    public MediaBrowserServiceCompat$ResultWrapper(MediaBrowserService$Result mediaBrowserService$Result) {
        this.mResultFwk = mediaBrowserService$Result;
    }

    public void detach() {
        this.mResultFwk.detach();
    }

    public List<MediaBrowser$MediaItem> parcelListToItemList(List<Parcel> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcel parcel : list) {
            parcel.setDataPosition(0);
            arrayList.add((MediaBrowser$MediaItem) MediaBrowser$MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sendResult(T t) {
        if (t instanceof List) {
            this.mResultFwk.sendResult(parcelListToItemList((List) t));
            return;
        }
        if (!(t instanceof Parcel)) {
            this.mResultFwk.sendResult(null);
            return;
        }
        Parcel parcel = (Parcel) t;
        parcel.setDataPosition(0);
        this.mResultFwk.sendResult(MediaBrowser$MediaItem.CREATOR.createFromParcel(parcel));
        parcel.recycle();
    }
}
