package com.discord.utilities.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes$Builder;
import android.media.MediaPlayer;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.k;
import d0.k$a;
import d0.l;
import d0.z.d.m;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager$SoundPlayer {
    private MediaPlayer mediaPlayer;

    public AppSoundManager$SoundPlayer(Context context, AppSound appSound, Function0<Unit> function0) throws IOException {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(appSound, "sound");
        m.checkNotNullParameter(function0, "onCompletion");
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setAudioAttributes(new AudioAttributes$Builder().setContentType(appSound.getContentType()).setUsage(appSound.getUsage()).build());
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(appSound.getResId());
            m.checkNotNullExpressionValue(assetFileDescriptorOpenRawResourceFd, "assetFileDescriptor");
            mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
            mediaPlayer.setLooping(appSound.getShouldLoop());
            mediaPlayer.setOnCompletionListener(new AppSoundManager$SoundPlayer$$special$$inlined$apply$lambda$1(this, appSound, context, function0));
            try {
                mediaPlayer.prepare();
            } catch (IOException unused) {
                this.mediaPlayer = null;
            }
        }
    }

    public final boolean isPlaying() {
        Object objM97constructorimpl;
        try {
            k$a k_a = k.j;
            MediaPlayer mediaPlayer = this.mediaPlayer;
            boolean z2 = true;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                z2 = false;
            }
            objM97constructorimpl = k.m97constructorimpl(Boolean.valueOf(z2));
        } catch (Throwable th) {
            k$a k_a2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
        Throwable thM99exceptionOrNullimpl = k.m99exceptionOrNullimpl(objM97constructorimpl);
        if (thM99exceptionOrNullimpl != null) {
            AppLog.g.w("Error checking if MediaPlayer is playing", thM99exceptionOrNullimpl);
        }
        Boolean bool = Boolean.FALSE;
        if (k.m101isFailureimpl(objM97constructorimpl)) {
            objM97constructorimpl = bool;
        }
        return ((Boolean) objM97constructorimpl).booleanValue();
    }

    public final Unit release() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return null;
        }
        mediaPlayer.release();
        return Unit.a;
    }

    public final void start() {
        Object objM97constructorimpl;
        Unit unit;
        try {
            k$a k_a = k.j;
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                unit = Unit.a;
            } else {
                unit = null;
            }
            objM97constructorimpl = k.m97constructorimpl(unit);
        } catch (Throwable th) {
            k$a k_a2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
        Throwable thM99exceptionOrNullimpl = k.m99exceptionOrNullimpl(objM97constructorimpl);
        if (thM99exceptionOrNullimpl != null) {
            Logger.e$default(AppLog.g, "Error starting MediaPlayer in invalid state", thM99exceptionOrNullimpl, null, 4, null);
        }
    }

    public final void stop() {
        Object objM97constructorimpl;
        Unit unit;
        try {
            k$a k_a = k.j;
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                unit = Unit.a;
            } else {
                unit = null;
            }
            objM97constructorimpl = k.m97constructorimpl(unit);
        } catch (Throwable th) {
            k$a k_a2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
        Throwable thM99exceptionOrNullimpl = k.m99exceptionOrNullimpl(objM97constructorimpl);
        if (thM99exceptionOrNullimpl != null) {
            AppLog.g.w("Called stop on uninitialized MediaPlayer", thM99exceptionOrNullimpl);
        }
    }
}
