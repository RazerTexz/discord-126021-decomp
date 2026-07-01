package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class AudioAttributesImplApi26$Builder extends AudioAttributesImplApi21$Builder {
    public AudioAttributesImplApi26$Builder() {
    }

    @Override // androidx.media.AudioAttributesImplApi21$Builder, androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImpl build() {
        return new AudioAttributesImplApi26(this.mFwkBuilder.build());
    }

    @Override // androidx.media.AudioAttributesImplApi21$Builder, androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AudioAttributesImpl$Builder setUsage(int i) {
        return setUsage(i);
    }

    public AudioAttributesImplApi26$Builder(Object obj) {
        super(obj);
    }

    @Override // androidx.media.AudioAttributesImplApi21$Builder, androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AudioAttributesImplApi21$Builder setUsage(int i) {
        return setUsage(i);
    }

    @Override // androidx.media.AudioAttributesImplApi21$Builder, androidx.media.AudioAttributesImpl$Builder
    @NonNull
    public AudioAttributesImplApi26$Builder setUsage(int i) {
        this.mFwkBuilder.setUsage(i);
        return this;
    }
}
