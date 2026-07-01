package co.discord.media_engine;

import androidx.annotation.NonNull;
import org.webrtc.EglBase;
import org.webrtc.EglHelper;

/* JADX INFO: loaded from: classes.dex */
public final class SharedEglBaseContext {
    private static EglBase eglBase_;

    @NonNull
    public static synchronized EglBase.Context getEglContext() {
        if (eglBase_ == null) {
            eglBase_ = EglHelper.create();
        }
        return eglBase_.getEglBaseContext();
    }
}
