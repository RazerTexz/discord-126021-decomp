package androidx.media;

import android.media.VolumeProvider;

/* JADX INFO: loaded from: classes.dex */
public class VolumeProviderCompat$1 extends VolumeProvider {
    public final /* synthetic */ VolumeProviderCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VolumeProviderCompat$1(VolumeProviderCompat volumeProviderCompat, int i, int i2, int i3, String str) {
        super(i, i2, i3, str);
        this.this$0 = volumeProviderCompat;
    }

    @Override // android.media.VolumeProvider
    public void onAdjustVolume(int i) {
        this.this$0.onAdjustVolume(i);
    }

    @Override // android.media.VolumeProvider
    public void onSetVolumeTo(int i) {
        this.this$0.onSetVolumeTo(i);
    }
}
