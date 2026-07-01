package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioAttributes$Builder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class AudioAttributesImplApi21$Builder implements AudioAttributesImpl$Builder {
    public final AudioAttributes$Builder mFwkBuilder;

    public AudioAttributesImplApi21$Builder() {
        this.mFwkBuilder = new AudioAttributes$Builder();
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImpl build() {
        return new AudioAttributesImplApi21(this.mFwkBuilder.build());
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
    public AudioAttributesImplApi21$Builder setContentType(int i) {
        this.mFwkBuilder.setContentType(i);
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplApi21$Builder setFlags(int i) {
        this.mFwkBuilder.setFlags(i);
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplApi21$Builder setLegacyStreamType(int i) {
        this.mFwkBuilder.setLegacyStreamType(i);
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplApi21$Builder setUsage(int i) {
        if (i == 16) {
            i = 12;
        }
        this.mFwkBuilder.setUsage(i);
        return this;
    }

    public AudioAttributesImplApi21$Builder(Object obj) {
        this.mFwkBuilder = new AudioAttributes$Builder((AudioAttributes) obj);
    }
}
