package com.discord.utilities.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer$OnCompletionListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager$SoundPlayer$$special$$inlined$apply$lambda$1 implements MediaPlayer$OnCompletionListener {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onCompletion$inlined;
    public final /* synthetic */ AppSound $sound$inlined;
    public final /* synthetic */ AppSoundManager$SoundPlayer this$0;

    public AppSoundManager$SoundPlayer$$special$$inlined$apply$lambda$1(AppSoundManager$SoundPlayer appSoundManager$SoundPlayer, AppSound appSound, Context context, Function0 function0) {
        this.this$0 = appSoundManager$SoundPlayer;
        this.$sound$inlined = appSound;
        this.$context$inlined = context;
        this.$onCompletion$inlined = function0;
    }

    @Override // android.media.MediaPlayer$OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.$onCompletion$inlined.invoke();
    }
}
