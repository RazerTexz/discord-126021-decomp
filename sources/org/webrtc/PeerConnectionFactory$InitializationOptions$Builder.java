package org.webrtc;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnectionFactory$InitializationOptions$Builder {
    private final Context applicationContext;
    private boolean enableInternalTracer;

    @Nullable
    private Loggable loggable;

    @Nullable
    private Logging$Severity loggableSeverity;
    private String fieldTrials = "";
    private NativeLibraryLoader nativeLibraryLoader = new NativeLibrary$DefaultLoader();
    private String nativeLibraryName = "jingle_peerconnection_so";

    public PeerConnectionFactory$InitializationOptions$Builder(Context context) {
        this.applicationContext = context;
    }

    public PeerConnectionFactory$InitializationOptions createInitializationOptions() {
        return new PeerConnectionFactory$InitializationOptions(this.applicationContext, this.fieldTrials, this.enableInternalTracer, this.nativeLibraryLoader, this.nativeLibraryName, this.loggable, this.loggableSeverity, null);
    }

    public PeerConnectionFactory$InitializationOptions$Builder setEnableInternalTracer(boolean z2) {
        this.enableInternalTracer = z2;
        return this;
    }

    public PeerConnectionFactory$InitializationOptions$Builder setFieldTrials(String str) {
        this.fieldTrials = str;
        return this;
    }

    public PeerConnectionFactory$InitializationOptions$Builder setInjectableLogger(Loggable loggable, Logging$Severity logging$Severity) {
        this.loggable = loggable;
        this.loggableSeverity = logging$Severity;
        return this;
    }

    public PeerConnectionFactory$InitializationOptions$Builder setNativeLibraryLoader(NativeLibraryLoader nativeLibraryLoader) {
        this.nativeLibraryLoader = nativeLibraryLoader;
        return this;
    }

    public PeerConnectionFactory$InitializationOptions$Builder setNativeLibraryName(String str) {
        this.nativeLibraryName = str;
        return this;
    }
}
