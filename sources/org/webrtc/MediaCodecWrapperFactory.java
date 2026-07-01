package org.webrtc;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String str) throws IOException;
}
