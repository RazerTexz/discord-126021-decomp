package com.discord.utilities.voice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import d0.z.d.m;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService$Connection$connection$1 implements ServiceConnection {
    public final /* synthetic */ VoiceEngineForegroundService$Connection this$0;

    public VoiceEngineForegroundService$Connection$connection$1(VoiceEngineForegroundService$Connection voiceEngineForegroundService$Connection) {
        this.this$0 = voiceEngineForegroundService$Connection;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName className, IBinder binder) {
        m.checkNotNullParameter(className, "className");
        m.checkNotNullParameter(binder, "binder");
        VoiceEngineForegroundService$Connection.access$setService$p(this.this$0, ((VoiceEngineForegroundService$LocalBinder) binder).getService());
        this.this$0.setUnbinding(false);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName className) {
        m.checkNotNullParameter(className, "className");
        this.this$0.setUnbinding(false);
        VoiceEngineForegroundService$Connection.access$setService$p(this.this$0, null);
    }
}
