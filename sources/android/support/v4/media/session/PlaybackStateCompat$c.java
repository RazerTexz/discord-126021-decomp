package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState$Builder;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
public class PlaybackStateCompat$c {
    @DoNotInline
    public static Bundle a(PlaybackState playbackState) {
        return playbackState.getExtras();
    }

    @DoNotInline
    public static void b(PlaybackState$Builder playbackState$Builder, Bundle bundle) {
        playbackState$Builder.setExtras(bundle);
    }
}
