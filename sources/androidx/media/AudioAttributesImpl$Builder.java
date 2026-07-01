package androidx.media;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface AudioAttributesImpl$Builder {
    @NonNull
    AudioAttributesImpl build();

    @NonNull
    AudioAttributesImpl$Builder setContentType(int i);

    @NonNull
    AudioAttributesImpl$Builder setFlags(int i);

    @NonNull
    AudioAttributesImpl$Builder setLegacyStreamType(int i);

    @NonNull
    AudioAttributesImpl$Builder setUsage(int i);
}
