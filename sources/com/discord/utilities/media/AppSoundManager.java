package com.discord.utilities.media;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.LazyJVM;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager {
    private final Context context;
    private Map<Integer, SoundPlayer> soundPlayers;

    /* JADX INFO: compiled from: AppSoundManager.kt */
    public static final class Provider {
        public static final Provider INSTANCE = new Provider();

        /* JADX INFO: renamed from: INSTANCE$delegate, reason: from kotlin metadata */
        private static final Lazy INSTANCE = LazyJVM.lazy(AppSoundManager2.INSTANCE);

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(appSound, "sound");
            Intrinsics3.checkNotNullParameter(function0, "onCompletion");
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(appSound.getContentType()).setUsage(appSound.getUsage()).build());
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(appSound.getResId());
                Intrinsics3.checkNotNullExpressionValue(assetFileDescriptorOpenRawResourceFd, "assetFileDescriptor");
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
            Object objM97constructorimpl;
            try {
                Result2.a aVar = Result2.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                boolean z2 = true;
                if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                    z2 = false;
                }
                objM97constructorimpl = Result2.m97constructorimpl(Boolean.valueOf(z2));
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                AppLog.g.w("Error checking if MediaPlayer is playing", thM99exceptionOrNullimpl);
            }
            Boolean bool = Boolean.FALSE;
            if (Result2.m101isFailureimpl(objM97constructorimpl)) {
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
                Result2.a aVar = Result2.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                objM97constructorimpl = Result2.m97constructorimpl(unit);
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                Logger.e$default(AppLog.g, "Error starting MediaPlayer in invalid state", thM99exceptionOrNullimpl, null, 4, null);
            }
        }

        public final void stop() {
            Object objM97constructorimpl;
            Unit unit;
            try {
                Result2.a aVar = Result2.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                objM97constructorimpl = Result2.m97constructorimpl(unit);
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                AppLog.g.w("Called stop on uninitialized MediaPlayer", thM99exceptionOrNullimpl);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.media.AppSoundManager$play$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppSoundManager.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppSound $sound;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AppSound appSound) {
            super(0);
            this.$sound = appSound;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
        Intrinsics3.checkNotNullParameter(application, "application");
        this.context = application;
        this.soundPlayers = new LinkedHashMap();
    }

    public final boolean isPlaying(AppSound sound) {
        Intrinsics3.checkNotNullParameter(sound, "sound");
        return this.soundPlayers.containsKey(Integer.valueOf(sound.getResId()));
    }

    public final void play(AppSound sound) {
        Intrinsics3.checkNotNullParameter(sound, "sound");
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
        this.soundPlayers.put(Integer.valueOf(sound.getResId()), new SoundPlayer(this.context, sound, new AnonymousClass1(sound)));
        SoundPlayer soundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer3 != null) {
            soundPlayer3.start();
        }
    }

    public final void stop(AppSound sound) {
        SoundPlayer soundPlayer;
        Intrinsics3.checkNotNullParameter(sound, "sound");
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
