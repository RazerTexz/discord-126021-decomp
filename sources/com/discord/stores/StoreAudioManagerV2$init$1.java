package com.discord.stores;

import android.content.Context;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$init$1 implements Runnable {
    public final /* synthetic */ StoreAudioManagerV2 this$0;

    public StoreAudioManagerV2$init$1(StoreAudioManagerV2 storeAudioManagerV2) {
        this.this$0 = storeAudioManagerV2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        Observable<List<DiscordAudioManager$AudioDevice>> observableR = DiscordAudioManager.d().f2785s.r();
        m.checkNotNullExpressionValue(observableR, "audioDevicesSubject.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAudioManagerV2$init$1$1(this), 62, (Object) null);
        Observable<DiscordAudioManager$DeviceTypes> observableR2 = DiscordAudioManager.d().u.r();
        m.checkNotNullExpressionValue(observableR2, "activeAudioDeviceSubject.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR2, this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAudioManagerV2$init$1$2(this), 62, (Object) null);
        Observable<Integer> observableR3 = DiscordAudioManager.d().f2787y.r();
        m.checkNotNullExpressionValue(observableR3, "currentMediaVolumeSubject.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR3, this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAudioManagerV2$init$1$3(this), 62, (Object) null);
    }
}
