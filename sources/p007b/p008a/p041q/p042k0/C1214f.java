package p007b.p008a.p041q.p042k0;

import android.database.ContentObserver;
import android.os.Handler;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: renamed from: b.a.q.k0.f */
/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1214f extends ContentObserver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DiscordAudioManager f1659a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1214f(DiscordAudioManager discordAudioManager, Handler handler) {
        super(handler);
        this.f1659a = discordAudioManager;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        super.onChange(z2);
        DiscordAudioManager discordAudioManager = this.f1659a;
        int streamVolume = discordAudioManager.f18834e.getStreamVolume(3);
        discordAudioManager.f18852w = streamVolume;
        SerializedSubject<Integer, Integer> serializedSubject = discordAudioManager.f18854y;
        serializedSubject.f27653k.onNext(Integer.valueOf(streamVolume));
    }
}
