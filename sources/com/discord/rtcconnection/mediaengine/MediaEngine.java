package com.discord.rtcconnection.mediaengine;

import androidx.annotation.AnyThread;
import b.a.q.c;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.hammerandchisel.libdiscord.Discord;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaEngine {
    Observable<Unit> a();

    void b(RtcRegion[] regionsWithIps, Function1<? super String[], Unit> callback);

    c c();

    @AnyThread
    void d(MediaEngine$VoiceConfig voiceConfig);

    Observable<MediaEngine$AudioInfo> e();

    void f(int deviceIndex);

    MediaEngineConnection g(long userId, MediaEngine$a options, MediaEngineConnection$Type type, Function1<? super Exception, Unit> onFailure);

    List<MediaEngineConnection> getConnections();

    void h(MediaEngine$OpenSLUsageMode openSLUsageMode);

    Discord i();

    void j(Function1<? super VideoInputDeviceDescription[], Unit> devicesCallback);

    void k(boolean enabled);

    void l(Function1<? super MediaEngine$LocalVoiceStatus, Unit> voiceStatusListener);
}
