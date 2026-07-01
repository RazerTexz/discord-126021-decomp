package com.discord.rtcconnection.audio;

import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAudioManager$d extends o implements Function0<DiscordAudioManager> {
    public static final DiscordAudioManager$d j = new DiscordAudioManager$d();

    public DiscordAudioManager$d() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public DiscordAudioManager invoke() {
        return new DiscordAudioManager(ApplicationProvider.INSTANCE.get());
    }
}
