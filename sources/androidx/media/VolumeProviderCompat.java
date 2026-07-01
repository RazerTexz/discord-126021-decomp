package androidx.media;

import android.media.VolumeProvider;
import android.os.Build$VERSION;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private VolumeProviderCompat$Callback mCallback;
    private final String mControlId;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private VolumeProvider mVolumeProviderFwk;

    public VolumeProviderCompat(int i, int i2, int i3) {
        this(i, i2, i3, null);
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public final String getVolumeControlId() {
        return this.mControlId;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderFwk == null) {
            if (Build$VERSION.SDK_INT >= 30) {
                this.mVolumeProviderFwk = new VolumeProviderCompat$1(this, this.mControlType, this.mMaxVolume, this.mCurrentVolume, this.mControlId);
            } else {
                this.mVolumeProviderFwk = new VolumeProviderCompat$2(this, this.mControlType, this.mMaxVolume, this.mCurrentVolume);
            }
        }
        return this.mVolumeProviderFwk;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(VolumeProviderCompat$Callback volumeProviderCompat$Callback) {
        this.mCallback = volumeProviderCompat$Callback;
    }

    public final void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        VolumeProviderCompat$Api21Impl.setCurrentVolume((VolumeProvider) getVolumeProvider(), i);
        VolumeProviderCompat$Callback volumeProviderCompat$Callback = this.mCallback;
        if (volumeProviderCompat$Callback != null) {
            volumeProviderCompat$Callback.onVolumeChanged(this);
        }
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public VolumeProviderCompat(int i, int i2, int i3, @Nullable String str) {
        this.mControlType = i;
        this.mMaxVolume = i2;
        this.mCurrentVolume = i3;
        this.mControlId = str;
    }
}
