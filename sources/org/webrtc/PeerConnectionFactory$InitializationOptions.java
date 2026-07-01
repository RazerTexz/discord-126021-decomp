package org.webrtc;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnectionFactory$InitializationOptions {
    public final Context applicationContext;
    public final boolean enableInternalTracer;
    public final String fieldTrials;

    @Nullable
    public Loggable loggable;

    @Nullable
    public Logging$Severity loggableSeverity;
    public final NativeLibraryLoader nativeLibraryLoader;
    public final String nativeLibraryName;

    public /* synthetic */ PeerConnectionFactory$InitializationOptions(Context context, String str, boolean z2, NativeLibraryLoader nativeLibraryLoader, String str2, Loggable loggable, Logging$Severity logging$Severity, PeerConnectionFactory$1 peerConnectionFactory$1) {
        this(context, str, z2, nativeLibraryLoader, str2, loggable, logging$Severity);
    }

    public static PeerConnectionFactory$InitializationOptions$Builder builder(Context context) {
        return new PeerConnectionFactory$InitializationOptions$Builder(context);
    }

    private PeerConnectionFactory$InitializationOptions(Context context, String str, boolean z2, NativeLibraryLoader nativeLibraryLoader, String str2, @Nullable Loggable loggable, @Nullable Logging$Severity logging$Severity) {
        this.applicationContext = context;
        this.fieldTrials = str;
        this.enableInternalTracer = z2;
        this.nativeLibraryLoader = nativeLibraryLoader;
        this.nativeLibraryName = str2;
        this.loggable = loggable;
        this.loggableSeverity = logging$Severity;
    }
}
