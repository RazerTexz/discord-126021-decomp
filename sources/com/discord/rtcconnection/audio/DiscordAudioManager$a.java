package com.discord.rtcconnection.audio;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import b.a.q.k0.a;
import b.a.q.k0.c;
import b.a.q.k0.e;
import b.c.a.a0.d;
import com.discord.rtcconnection.enums.AudioManagerBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import org.webrtc.ThreadUtils;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAudioManager$a implements Runnable {
    public final /* synthetic */ DiscordAudioManager j;

    public DiscordAudioManager$a(DiscordAudioManager discordAudioManager) {
        this.j = discordAudioManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DiscordAudioManager discordAudioManager = this.j;
        a aVar = discordAudioManager.m;
        Objects.requireNonNull(aVar);
        ThreadUtils.checkIsOnMainThread();
        boolean profileProxy = false;
        List listListOf = n.listOf((Object[]) new AudioManagerBroadcastAction[]{AudioManagerBroadcastAction.HeadsetPlug, AudioManagerBroadcastAction.ScoAudioStateUpdated});
        d.b1("AudioManagerBroadcastReceiver", "registering for broadcasts with actions: " + listListOf);
        IntentFilter intentFilter = new IntentFilter();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            intentFilter.addAction(((AudioManagerBroadcastAction) it.next()).getAction());
        }
        aVar.f261b.registerReceiver(aVar, intentFilter);
        c cVar = discordAudioManager.l;
        Objects.requireNonNull(cVar);
        ThreadUtils.checkIsOnMainThread();
        if (!cVar.l) {
            StringBuilder sbU = b.d.b.a.a.U("registering for broadcasts with actions: ");
            Set<BluetoothBroadcastAction> set = c.j;
            sbU.append(set);
            d.b1("BluetoothBroadcastReceiver", sbU.toString());
            IntentFilter intentFilter2 = new IntentFilter();
            Iterator<T> it2 = set.iterator();
            while (it2.hasNext()) {
                intentFilter2.addAction(((BluetoothBroadcastAction) it2.next()).getAction());
            }
            cVar.n.registerReceiver(cVar, intentFilter2);
            b.a.q.k0.d dVar = b.a.q.k0.d.c;
            Lazy lazy = b.a.q.k0.d.a;
            if (((String) lazy.getValue()) != null) {
                Context context = cVar.n;
                m.checkNotNullParameter(context, "context");
                m.checkNotNullParameter(cVar, "receiver");
                try {
                    String str = (String) lazy.getValue();
                    if (str != null) {
                        context.registerReceiver(cVar, new IntentFilter(str));
                    }
                } catch (Throwable unused) {
                }
            }
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    profileProxy = defaultAdapter.getProfileProxy(cVar.n, cVar, 1);
                }
            } catch (SecurityException e) {
                d.f1("BluetoothBroadcastReceiver", "failed to get BluetoothHeadset profile: " + e);
            }
            if (profileProxy) {
                d.b1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy");
            } else {
                d.c1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy failed", null);
            }
            cVar.l = true;
        }
        e eVar = new e(discordAudioManager);
        synchronized (discordAudioManager.i) {
            discordAudioManager.p = eVar;
        }
    }
}
