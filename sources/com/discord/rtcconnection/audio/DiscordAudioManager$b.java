package com.discord.rtcconnection.audio;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.q.k0.h;
import b.a.q.l0.a$a;
import b.a.q.l0.a$b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.rtcconnection.enums.ScoAudioState$b;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAudioManager$b implements h {
    public final /* synthetic */ DiscordAudioManager a;

    public DiscordAudioManager$b(DiscordAudioManager discordAudioManager) {
        this.a = discordAudioManager;
    }

    @Override // b.a.q.k0.h
    public void a(Context context, boolean z2) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(context, "context");
    }

    @Override // b.a.q.k0.h
    @MainThread
    public void b(Context context, ScoAudioState$b scoAudioState$b) {
        boolean z2;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(scoAudioState$b, "scoAudioStateUpdate");
        int iOrdinal = scoAudioState$b.a.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            d.b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + scoAudioState$b);
            this.a.j();
            return;
        }
        d.b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + scoAudioState$b);
        DiscordAudioManager discordAudioManager = this.a;
        DiscordAudioManager$BluetoothScoState discordAudioManager$BluetoothScoState = discordAudioManager.o;
        discordAudioManager.k();
        int iOrdinal2 = discordAudioManager$BluetoothScoState.ordinal();
        if (iOrdinal2 == 2) {
            synchronized (this.a.i) {
                z2 = this.a.D;
            }
            if (z2) {
                d.b1("DiscordAudioManager", "SCO off detected directly from ON. Refreshing Bluetooth device");
                this.a.j();
                this.a.l();
                return;
            }
            return;
        }
        if (iOrdinal2 != 3) {
            return;
        }
        StringBuilder sbU = a.U("Unable to turn on SCO. Clearing Bluetooth device. mode: ");
        sbU.append(this.a.e.getMode());
        d.b1("DiscordAudioManager", sbU.toString());
        synchronized (this.a.i) {
            DiscordAudioManager discordAudioManager2 = this.a;
            List<DiscordAudioManager$AudioDevice> list = discordAudioManager2.r;
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice : list) {
                arrayList.add(discordAudioManager$AudioDevice.type.ordinal() != 5 ? DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 15) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 1));
            }
            discordAudioManager2.r = arrayList;
            discordAudioManager2.f2785s.k.onNext(arrayList);
        }
        DiscordAudioManager discordAudioManager3 = this.a;
        discordAudioManager3.a(discordAudioManager3.r);
    }

    @Override // b.a.q.k0.h
    public void c(Context context) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(context, "context");
    }

    @Override // b.a.q.k0.h
    public void d(Context context, boolean z2) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(context, "context");
    }

    @Override // b.a.q.k0.h
    @MainThread
    public void e(Context context, b.a.q.l0.a aVar) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(aVar, "wiredHeadsetState");
        d.b1("DiscordAudioManager", "[onWiredHeadsetPlug] wiredHeadsetState = " + aVar);
        if (m.areEqual(aVar, a$b.a)) {
            synchronized (this.a.i) {
                DiscordAudioManager discordAudioManager = this.a;
                List<DiscordAudioManager$AudioDevice> list = discordAudioManager.r;
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice : list) {
                    int iOrdinal = discordAudioManager$AudioDevice.type.ordinal();
                    arrayList.add(iOrdinal != 3 ? iOrdinal != 4 ? DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 15) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, this.a.h, null, null, 13) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 13));
                }
                discordAudioManager.r = arrayList;
                discordAudioManager.f2785s.k.onNext(arrayList);
            }
        } else if (aVar instanceof a$a) {
            synchronized (this.a.i) {
                DiscordAudioManager discordAudioManager2 = this.a;
                List<DiscordAudioManager$AudioDevice> list2 = discordAudioManager2.r;
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(list2, 10));
                for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice2 : list2) {
                    int iOrdinal2 = discordAudioManager$AudioDevice2.type.ordinal();
                    arrayList2.add(iOrdinal2 != 3 ? iOrdinal2 != 4 ? DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice2, null, false, null, null, 15) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice2, null, false, null, null, 13) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice2, null, true, null, null, 13));
                }
                discordAudioManager2.r = arrayList2;
                discordAudioManager2.f2785s.k.onNext(arrayList2);
            }
        }
        this.a.l();
    }
}
