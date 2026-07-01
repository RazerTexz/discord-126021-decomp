package androidx.media;

import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase$Builder implements AudioAttributesImpl$Builder {
    private int mContentType;
    private int mFlags;
    private int mLegacyStream;
    private int mUsage;

    public AudioAttributesImplBase$Builder() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private AudioAttributesImplBase$Builder setInternalLegacyStreamType(int i) {
        switch (i) {
            case 0:
                this.mContentType = 1;
                break;
            case 1:
                this.mContentType = 4;
                break;
            case 2:
                this.mContentType = 4;
                break;
            case 3:
                this.mContentType = 2;
                break;
            case 4:
                this.mContentType = 4;
                break;
            case 5:
                this.mContentType = 4;
                break;
            case 6:
                this.mContentType = 1;
                this.mFlags |= 4;
                break;
            case 7:
                this.mFlags = 1 | this.mFlags;
                this.mContentType = 4;
                break;
            case 8:
                this.mContentType = 4;
                break;
            case 9:
                this.mContentType = 4;
                break;
            case 10:
                this.mContentType = 1;
                break;
            default:
                Log.e(AudioAttributesCompat.TAG, "Invalid stream type " + i + " for AudioAttributesCompat");
                break;
        }
        this.mUsage = AudioAttributesImplBase.usageForStreamType(i);
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImpl build() {
        return new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AudioAttributesImpl$Builder setContentType(int i) {
        return setContentType(i);
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AudioAttributesImpl$Builder setFlags(int i) {
        return setFlags(i);
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AudioAttributesImpl$Builder setLegacyStreamType(int i) {
        return setLegacyStreamType(i);
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AudioAttributesImpl$Builder setUsage(int i) {
        return setUsage(i);
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplBase$Builder setContentType(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            this.mContentType = i;
        } else {
            this.mContentType = 0;
        }
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplBase$Builder setFlags(int i) {
        this.mFlags = (i & AudioAttributesCompat.FLAG_ALL) | this.mFlags;
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplBase$Builder setLegacyStreamType(int i) {
        if (i == 10) {
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }
        this.mLegacyStream = i;
        return setInternalLegacyStreamType(i);
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplBase$Builder setUsage(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                this.mUsage = i;
                return this;
            case 16:
                this.mUsage = 12;
                return this;
            default:
                this.mUsage = 0;
                return this;
        }
    }

    public AudioAttributesImplBase$Builder(AudioAttributesCompat audioAttributesCompat) {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
        this.mUsage = audioAttributesCompat.getUsage();
        this.mContentType = audioAttributesCompat.getContentType();
        this.mFlags = audioAttributesCompat.getFlags();
        this.mLegacyStream = audioAttributesCompat.getRawLegacyStreamType();
    }
}
