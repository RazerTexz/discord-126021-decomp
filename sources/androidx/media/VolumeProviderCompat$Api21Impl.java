package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class VolumeProviderCompat$Api21Impl {
    private VolumeProviderCompat$Api21Impl() {
    }

    @DoNotInline
    public static void setCurrentVolume(VolumeProvider volumeProvider, int i) {
        volumeProvider.setCurrentVolume(i);
    }
}
