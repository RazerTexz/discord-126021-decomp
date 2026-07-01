package org.webrtc;

import android.content.Context;
import org.webrtc.NetworkChangeDetector;

/* JADX INFO: loaded from: classes3.dex */
public interface NetworkChangeDetectorFactory {
    NetworkChangeDetector create(NetworkChangeDetector.Observer observer, Context context);
}
