package b.a.q.k0;

import android.database.ContentObserver;
import android.os.Handler;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends ContentObserver {
    public final /* synthetic */ DiscordAudioManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(DiscordAudioManager discordAudioManager, Handler handler) {
        super(handler);
        this.a = discordAudioManager;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        super.onChange(z2);
        DiscordAudioManager discordAudioManager = this.a;
        int streamVolume = discordAudioManager.e.getStreamVolume(3);
        discordAudioManager.w = streamVolume;
        SerializedSubject<Integer, Integer> serializedSubject = discordAudioManager.f2787y;
        serializedSubject.k.onNext(Integer.valueOf(streamVolume));
    }
}
