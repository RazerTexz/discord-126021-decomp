package com.discord.utilities.media;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager {
    private final Context context;
    private Map<Integer, SoundPlayer> soundPlayers;

    /* JADX INFO: compiled from: AppSoundManager.kt */
    public static final class Provider {
        public static final Provider INSTANCE = new Provider();

        /* JADX INFO: renamed from: INSTANCE$delegate, reason: from kotlin metadata */
        private static final Lazy INSTANCE = C12083g.lazy(AppSoundManager$Provider$INSTANCE$2.INSTANCE);

        private Provider() {
        }

        private final AppSoundManager getINSTANCE() {
            return (AppSoundManager) INSTANCE.getValue();
        }

        public final AppSoundManager get() {
            return getINSTANCE();
        }
    }

    /* JADX INFO: compiled from: AppSoundManager.kt */
    public static final class SoundPlayer {
        private MediaPlayer mediaPlayer;

        public SoundPlayer(final Context context, final AppSound appSound, final Function0<Unit> function0) throws IOException {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(appSound, "sound");
            C12238m.checkNotNullParameter(function0, "onCompletion");
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(appSound.getContentType()).setUsage(appSound.getUsage()).build());
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(appSound.getResId());
                C12238m.checkNotNullExpressionValue(assetFileDescriptorOpenRawResourceFd, "assetFileDescriptor");
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                mediaPlayer.setLooping(appSound.getShouldLoop());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.discord.utilities.media.AppSoundManager$SoundPlayer$$special$$inlined$apply$lambda$1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                        function0.invoke();
                    }
                });
                try {
                    mediaPlayer.prepare();
                } catch (IOException unused) {
                    this.mediaPlayer = null;
                }
            }
        }

        public final boolean isPlaying() {
            Object objM11474constructorimpl;
            try {
                C12112k.a aVar = C12112k.f25169j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                boolean z2 = true;
                if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                    z2 = false;
                }
                objM11474constructorimpl = C12112k.m11474constructorimpl(Boolean.valueOf(z2));
            } catch (Throwable th) {
                C12112k.a aVar2 = C12112k.f25169j;
                objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
            }
            Throwable thM11476exceptionOrNullimpl = C12112k.m11476exceptionOrNullimpl(objM11474constructorimpl);
            if (thM11476exceptionOrNullimpl != null) {
                AppLog.f14950g.mo8370w("Error checking if MediaPlayer is playing", thM11476exceptionOrNullimpl);
            }
            Boolean bool = Boolean.FALSE;
            if (C12112k.m11478isFailureimpl(objM11474constructorimpl)) {
                objM11474constructorimpl = bool;
            }
            return ((Boolean) objM11474constructorimpl).booleanValue();
        }

        public final Unit release() {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null) {
                return null;
            }
            mediaPlayer.release();
            return Unit.f27425a;
        }

        public final void start() {
            Object objM11474constructorimpl;
            Unit unit;
            try {
                C12112k.a aVar = C12112k.f25169j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    unit = Unit.f27425a;
                } else {
                    unit = null;
                }
                objM11474constructorimpl = C12112k.m11474constructorimpl(unit);
            } catch (Throwable th) {
                C12112k.a aVar2 = C12112k.f25169j;
                objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
            }
            Throwable thM11476exceptionOrNullimpl = C12112k.m11476exceptionOrNullimpl(objM11474constructorimpl);
            if (thM11476exceptionOrNullimpl != null) {
                Logger.e$default(AppLog.f14950g, "Error starting MediaPlayer in invalid state", thM11476exceptionOrNullimpl, null, 4, null);
            }
        }

        public final void stop() {
            Object objM11474constructorimpl;
            Unit unit;
            try {
                C12112k.a aVar = C12112k.f25169j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    unit = Unit.f27425a;
                } else {
                    unit = null;
                }
                objM11474constructorimpl = C12112k.m11474constructorimpl(unit);
            } catch (Throwable th) {
                C12112k.a aVar2 = C12112k.f25169j;
                objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
            }
            Throwable thM11476exceptionOrNullimpl = C12112k.m11476exceptionOrNullimpl(objM11474constructorimpl);
            if (thM11476exceptionOrNullimpl != null) {
                AppLog.f14950g.mo8370w("Called stop on uninitialized MediaPlayer", thM11476exceptionOrNullimpl);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.media.AppSoundManager$play$1 */
    /* JADX INFO: compiled from: AppSoundManager.kt */
    public static final class C67931 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ AppSound $sound;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67931(AppSound appSound) {
            super(0);
            this.$sound = appSound;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$sound.getShouldLoop()) {
                return;
            }
            AppSoundManager.this.stop(this.$sound);
        }
    }

    public AppSoundManager(Application application) {
        C12238m.checkNotNullParameter(application, "application");
        this.context = application;
        this.soundPlayers = new LinkedHashMap();
    }

    public final boolean isPlaying(AppSound sound) {
        C12238m.checkNotNullParameter(sound, "sound");
        return this.soundPlayers.containsKey(Integer.valueOf(sound.getResId()));
    }

    public final void play(AppSound sound) {
        C12238m.checkNotNullParameter(sound, "sound");
        if (isPlaying(sound)) {
            SoundPlayer soundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (soundPlayer != null) {
                soundPlayer.stop();
            }
            SoundPlayer soundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (soundPlayer2 != null) {
                soundPlayer2.release();
            }
        }
        this.soundPlayers.put(Integer.valueOf(sound.getResId()), new SoundPlayer(this.context, sound, new C67931(sound)));
        SoundPlayer soundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer3 != null) {
            soundPlayer3.start();
        }
    }

    public final void stop(AppSound sound) {
        SoundPlayer soundPlayer;
        C12238m.checkNotNullParameter(sound, "sound");
        SoundPlayer soundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer2 != null && soundPlayer2.isPlaying() && (soundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()))) != null) {
            soundPlayer.stop();
        }
        SoundPlayer soundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer3 != null) {
            soundPlayer3.release();
        }
        this.soundPlayers.remove(Integer.valueOf(sound.getResId()));
    }
}
