package com.discord.rtcconnection.mediaengine;

import android.content.Intent;
import co.discord.media_engine.Stats;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaEngineConnection {
    void a(Intent permission, ThumbnailEmitter thumbnailEmitter);

    boolean b();

    void c(boolean selfMute);

    void d(long userId, boolean offScreen);

    void destroy();

    void e(long userId, float volume);

    void f(KrispOveruseDetector$Status status);

    boolean g(long userId);

    MediaEngineConnection$Type getType();

    void h();

    void i(long userId, boolean disabled);

    void j(boolean isVideoBroadcast);

    void k(MediaEngineConnection$InputMode inputMode, MediaEngineConnection$c inputModeOptions);

    void l(MediaEngineConnection$d listener);

    void m(MediaEngineConnection$b quality);

    void n(Function1<? super Stats, Unit> onStats);

    void o(MediaEngineConnection$d listener);

    boolean p(long userId);

    void q(boolean active);

    void r(String audioCodec, String videoCodec);

    void s(long userId, int audioSsrc, Integer videoSsrc, boolean isMuted, float volume);

    void t(String mode, int[] secretKey);

    boolean u(long userId);

    void v(boolean selfDeaf);

    void w(long userId, boolean mute);
}
