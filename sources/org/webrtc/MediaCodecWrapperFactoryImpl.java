package org.webrtc;

import android.media.MediaCodec;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {
    @Override // org.webrtc.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String str) throws IOException {
        return new MediaCodecWrapperFactoryImpl$MediaCodecWrapperImpl(MediaCodec.createByCodecName(str));
    }
}
