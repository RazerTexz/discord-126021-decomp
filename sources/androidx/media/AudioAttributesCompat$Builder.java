package androidx.media;

import android.os.Build$VERSION;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat$Builder {
    public final AudioAttributesImpl$Builder mBuilderImpl;

    public AudioAttributesCompat$Builder() {
        if (AudioAttributesCompat.sForceLegacyBehavior) {
            this.mBuilderImpl = new AudioAttributesImplBase$Builder();
        } else if (Build$VERSION.SDK_INT >= 26) {
            this.mBuilderImpl = new AudioAttributesImplApi26$Builder();
        } else {
            this.mBuilderImpl = new AudioAttributesImplApi21$Builder();
        }
    }

    public AudioAttributesCompat build() {
        return new AudioAttributesCompat(this.mBuilderImpl.build());
    }

    public AudioAttributesCompat$Builder setContentType(int i) {
        this.mBuilderImpl.setContentType(i);
        return this;
    }

    public AudioAttributesCompat$Builder setFlags(int i) {
        this.mBuilderImpl.setFlags(i);
        return this;
    }

    public AudioAttributesCompat$Builder setLegacyStreamType(int i) {
        this.mBuilderImpl.setLegacyStreamType(i);
        return this;
    }

    public AudioAttributesCompat$Builder setUsage(int i) {
        this.mBuilderImpl.setUsage(i);
        return this;
    }

    public AudioAttributesCompat$Builder(AudioAttributesCompat audioAttributesCompat) {
        if (AudioAttributesCompat.sForceLegacyBehavior) {
            this.mBuilderImpl = new AudioAttributesImplBase$Builder(audioAttributesCompat);
        } else if (Build$VERSION.SDK_INT >= 26) {
            this.mBuilderImpl = new AudioAttributesImplApi26$Builder(audioAttributesCompat.unwrap());
        } else {
            this.mBuilderImpl = new AudioAttributesImplApi21$Builder(audioAttributesCompat.unwrap());
        }
    }
}
