package org.webrtc;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public enum PeerConnection$AdapterType {
    UNKNOWN(0),
    ETHERNET(1),
    WIFI(2),
    CELLULAR(4),
    VPN(8),
    LOOPBACK(16),
    ADAPTER_TYPE_ANY(32),
    CELLULAR_2G(64),
    CELLULAR_3G(128),
    CELLULAR_4G(256),
    CELLULAR_5G(512);

    private static final Map<Integer, PeerConnection$AdapterType> BY_BITMASK = new HashMap();
    public final Integer bitMask;

    static {
        PeerConnection$AdapterType[] peerConnection$AdapterTypeArrValues = values();
        for (int i = 0; i < 11; i++) {
            PeerConnection$AdapterType peerConnection$AdapterType = peerConnection$AdapterTypeArrValues[i];
            BY_BITMASK.put(peerConnection$AdapterType.bitMask, peerConnection$AdapterType);
        }
    }

    PeerConnection$AdapterType(Integer num) {
        this.bitMask = num;
    }

    @Nullable
    @CalledByNative("AdapterType")
    public static PeerConnection$AdapterType fromNativeIndex(int i) {
        return BY_BITMASK.get(Integer.valueOf(i));
    }
}
