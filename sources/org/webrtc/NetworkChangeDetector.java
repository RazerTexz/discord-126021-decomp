package org.webrtc;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface NetworkChangeDetector {
    void destroy();

    @Nullable
    List<NetworkChangeDetector$NetworkInformation> getActiveNetworkList();

    NetworkChangeDetector$ConnectionType getCurrentConnectionType();

    boolean supportNetworkCallback();
}
