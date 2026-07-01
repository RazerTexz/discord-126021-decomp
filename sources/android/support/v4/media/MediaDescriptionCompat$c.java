package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription$Builder;
import android.net.Uri;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class MediaDescriptionCompat$c {
    @Nullable
    @DoNotInline
    public static Uri a(MediaDescription mediaDescription) {
        return mediaDescription.getMediaUri();
    }

    @DoNotInline
    public static void b(MediaDescription$Builder mediaDescription$Builder, @Nullable Uri uri) {
        mediaDescription$Builder.setMediaUri(uri);
    }
}
