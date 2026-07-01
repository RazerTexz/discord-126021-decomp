package com.discord.rtcconnection.audio;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioAttributes$Builder;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest$Builder;
import android.media.AudioManager;
import android.media.AudioManager$OnAudioFocusChangeListener;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings$System;
import b.a.q.k0.a;
import b.a.q.k0.b;
import b.a.q.k0.c;
import b.a.q.k0.f;
import b.c.a.a0.d;
import d0.g;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAudioManager {
    public static final Lazy a = g.lazy(DiscordAudioManager$d.j);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DiscordAudioManager$AudioDevice f2784b = new DiscordAudioManager$AudioDevice(null, false, null, null, 15);
    public static final List<DiscordAudioManager$DeviceTypes> c = n.listOf((Object[]) new DiscordAudioManager$DeviceTypes[]{DiscordAudioManager$DeviceTypes.EARPIECE, DiscordAudioManager$DeviceTypes.SPEAKERPHONE, DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET, DiscordAudioManager$DeviceTypes.WIRED_HEADSET});
    public static final DiscordAudioManager d = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final AudioManager e;
    public final BluetoothManager f;
    public final Lazy g;
    public final boolean h;
    public final Object i;
    public final long j;
    public final ContentResolver k;
    public final c l;
    public final a m;
    public BluetoothHeadset n;
    public DiscordAudioManager$BluetoothScoState o;
    public AudioManager$OnAudioFocusChangeListener p;
    public AudioFocusRequest q;
    public List<DiscordAudioManager$AudioDevice> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SerializedSubject<List<DiscordAudioManager$AudioDevice>, List<DiscordAudioManager$AudioDevice>> f2785s;
    public DiscordAudioManager$DeviceTypes t;
    public final SerializedSubject<DiscordAudioManager$DeviceTypes, DiscordAudioManager$DeviceTypes> u;
    public ContentObserver v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f2786x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final SerializedSubject<Integer, Integer> f2787y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public DiscordAudioManager$DeviceTypes f2788z;

    public DiscordAudioManager(Context context) {
        DiscordAudioManager$AudioDevice discordAudioManager$AudioDeviceA;
        m.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.e = (AudioManager) systemService;
        Object systemService2 = context.getSystemService("bluetooth");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.f = (BluetoothManager) systemService2;
        this.g = g.lazy(new DiscordAudioManager$e(context));
        this.h = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        this.i = this;
        Thread threadCurrentThread = Thread.currentThread();
        m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        this.j = threadCurrentThread.getId();
        ContentResolver contentResolver = context.getContentResolver();
        m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        this.k = contentResolver;
        this.l = new c(context, new DiscordAudioManager$c(this));
        this.m = new a(context, new DiscordAudioManager$b(this));
        new Handler(Looper.getMainLooper()).post(new DiscordAudioManager$a(this));
        this.o = DiscordAudioManager$BluetoothScoState.INVALID;
        List<DiscordAudioManager$AudioDevice> listListOf = n.listOf((Object[]) new DiscordAudioManager$AudioDevice[]{new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.SPEAKERPHONE, false, null, null, 14), new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.WIRED_HEADSET, false, null, null, 14), new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.EARPIECE, false, null, null, 14), new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
        ArrayList arrayList = new ArrayList();
        for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice : listListOf) {
            int iOrdinal = discordAudioManager$AudioDevice.type.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                discordAudioManager$AudioDeviceA = null;
            } else if (iOrdinal == 2) {
                discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, true, null, null, 13);
            } else if (iOrdinal == 3) {
                discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, this.e.isWiredHeadsetOn(), null, null, 13);
            } else if (iOrdinal == 4) {
                discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, this.h, null, null, 13);
            } else {
                if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 15);
            }
            if (discordAudioManager$AudioDeviceA != null) {
                arrayList.add(discordAudioManager$AudioDeviceA);
            }
        }
        this.r = arrayList;
        this.f2785s = new SerializedSubject<>(BehaviorSubject.l0(arrayList));
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes = DiscordAudioManager$DeviceTypes.INVALID;
        this.t = discordAudioManager$DeviceTypes;
        this.u = new SerializedSubject<>(BehaviorSubject.l0(discordAudioManager$DeviceTypes));
        this.f2786x = this.e.getStreamMaxVolume(3);
        this.f2787y = new SerializedSubject<>(BehaviorSubject.l0(Integer.valueOf(this.w)));
        this.f2788z = DiscordAudioManager$DeviceTypes.DEFAULT;
    }

    public static final DiscordAudioManager d() {
        return (DiscordAudioManager) a.getValue();
    }

    public static final List<DiscordAudioManager$AudioDevice> f() {
        return n.listOf((Object[]) new DiscordAudioManager$AudioDevice[]{new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.SPEAKERPHONE, false, null, null, 14), new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.WIRED_HEADSET, false, null, null, 14), new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.EARPIECE, false, null, null, 14), new DiscordAudioManager$AudioDevice(DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
    }

    public final void a(List<DiscordAudioManager$AudioDevice> list) {
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypesPrevious;
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes;
        synchronized (this.i) {
            List<DiscordAudioManager$DeviceTypes> list2 = c;
            ListIterator<DiscordAudioManager$DeviceTypes> listIterator = list2.listIterator(list2.size());
            do {
                if (!listIterator.hasPrevious()) {
                    discordAudioManager$DeviceTypesPrevious = null;
                    break;
                }
                discordAudioManager$DeviceTypesPrevious = listIterator.previous();
            } while (!list.get(discordAudioManager$DeviceTypesPrevious.getValue()).isAvailable);
            discordAudioManager$DeviceTypes = discordAudioManager$DeviceTypesPrevious;
            if (discordAudioManager$DeviceTypes == null) {
                discordAudioManager$DeviceTypes = DiscordAudioManager$DeviceTypes.SPEAKERPHONE;
            }
        }
        d.b1("DiscordAudioManager", "Default device to activate: " + discordAudioManager$DeviceTypes);
        b(discordAudioManager$DeviceTypes);
    }

    public final void b(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        boolean z2;
        synchronized (this.i) {
            z2 = !this.D;
        }
        if (z2) {
            d.f1("DiscordAudioManager", "Unable to activate audio output outside Discord-requested communication mode");
            return;
        }
        if (discordAudioManager$DeviceTypes == DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET) {
            j();
        } else {
            k();
        }
        boolean z3 = discordAudioManager$DeviceTypes == DiscordAudioManager$DeviceTypes.SPEAKERPHONE;
        if (this.e.isSpeakerphoneOn() != z3) {
            this.e.setSpeakerphoneOn(z3);
        }
        synchronized (this.i) {
            this.t = discordAudioManager$DeviceTypes;
            this.u.k.onNext(discordAudioManager$DeviceTypes);
        }
        d.b1("DiscordAudioManager", "Activated device: " + discordAudioManager$DeviceTypes);
    }

    public final void c() {
        Thread threadCurrentThread = Thread.currentThread();
        m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        if (threadCurrentThread.getId() != this.j) {
            throw new IllegalStateException("Method was not called from a valid thread");
        }
    }

    public final b e() {
        return (b) this.g.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00b0 A[Catch: all -> 0x0105, TryCatch #0 {, blocks: (B:51:0x0099, B:52:0x00aa, B:54:0x00b0, B:56:0x00c0, B:72:0x00f6, B:57:0x00cb, B:59:0x00d0, B:66:0x00e1, B:69:0x00ea, B:71:0x00f1, B:73:0x00fa), top: B:80:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c0 A[Catch: all -> 0x0105, TryCatch #0 {, blocks: (B:51:0x0099, B:52:0x00aa, B:54:0x00b0, B:56:0x00c0, B:72:0x00f6, B:57:0x00cb, B:59:0x00d0, B:66:0x00e1, B:69:0x00ea, B:71:0x00f1, B:73:0x00fa), top: B:80:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00cb A[Catch: all -> 0x0105, TryCatch #0 {, blocks: (B:51:0x0099, B:52:0x00aa, B:54:0x00b0, B:56:0x00c0, B:72:0x00f6, B:57:0x00cb, B:59:0x00d0, B:66:0x00e1, B:69:0x00ea, B:71:0x00f1, B:73:0x00fa), top: B:80:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00de  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e1 A[Catch: all -> 0x0105, TryCatch #0 {, blocks: (B:51:0x0099, B:52:0x00aa, B:54:0x00b0, B:56:0x00c0, B:72:0x00f6, B:57:0x00cb, B:59:0x00d0, B:66:0x00e1, B:69:0x00ea, B:71:0x00f1, B:73:0x00fa), top: B:80:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ea A[Catch: all -> 0x0105, TryCatch #0 {, blocks: (B:51:0x0099, B:52:0x00aa, B:54:0x00b0, B:56:0x00c0, B:72:0x00f6, B:57:0x00cb, B:59:0x00d0, B:66:0x00e1, B:69:0x00ea, B:71:0x00f1, B:73:0x00fa), top: B:80:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:80:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void g() {
        List<BluetoothDevice> listEmptyList;
        Object next;
        BluetoothDevice bluetoothDevice;
        boolean z2;
        ArrayList arrayList;
        boolean z3;
        String address;
        String name;
        DiscordAudioManager$AudioDevice discordAudioManager$AudioDeviceA;
        BluetoothDevice bluetoothDevice2;
        BluetoothHeadset bluetoothHeadset;
        if (!e().d) {
            d.f1("DiscordAudioManager", "refreshBluetoothHeadset() requires BLUETOOTH permission");
            return;
        }
        BluetoothHeadset bluetoothHeadset2 = this.n;
        if (bluetoothHeadset2 == null || (listEmptyList = bluetoothHeadset2.getConnectedDevices()) == null) {
            listEmptyList = n.emptyList();
        }
        Iterator<T> it = listEmptyList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                bluetoothDevice2 = (BluetoothDevice) next;
                bluetoothHeadset = this.n;
            }
        } while (!(bluetoothHeadset != null ? bluetoothHeadset.isAudioConnected(bluetoothDevice2) : false));
        BluetoothDevice bluetoothDevice3 = (BluetoothDevice) next;
        BluetoothHeadset bluetoothHeadset3 = this.n;
        if (bluetoothHeadset3 != null) {
            b.a.q.k0.d dVar = b.a.q.k0.d.c;
            m.checkNotNullParameter(bluetoothHeadset3, "headsetProfile");
            try {
                Method method = (Method) b.a.q.k0.d.f263b.getValue();
                Object objInvoke = method != null ? method.invoke(bluetoothHeadset3, new Object[0]) : null;
                if (!(objInvoke instanceof BluetoothDevice)) {
                    objInvoke = null;
                }
                bluetoothDevice = (BluetoothDevice) objInvoke;
            } catch (Throwable unused) {
                bluetoothDevice = null;
            }
        } else {
            bluetoothDevice = null;
        }
        if (bluetoothDevice3 == null) {
            bluetoothDevice3 = bluetoothDevice;
        }
        if (e().d) {
            BluetoothAdapter adapter = this.f.getAdapter();
            if (adapter != null) {
                int profileConnectionState = adapter.getProfileConnectionState(1);
                if (adapter.isEnabled() && profileConnectionState == 2) {
                    z2 = true;
                }
            }
            synchronized (this.i) {
                List<DiscordAudioManager$AudioDevice> list = this.r;
                arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice : list) {
                    if (discordAudioManager$AudioDevice.type.ordinal() != 5) {
                        discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 15);
                    } else {
                        if (this.D || this.t != DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET) {
                            z3 = z2;
                        } else {
                            z3 = bluetoothDevice3 != null;
                        }
                        if (bluetoothDevice3 != null) {
                            address = bluetoothDevice3.getAddress();
                        } else {
                            address = null;
                        }
                        if (bluetoothDevice3 != null) {
                            name = bluetoothDevice3.getName();
                        } else {
                            name = null;
                        }
                        discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, z3, address, name, 1);
                    }
                    arrayList.add(discordAudioManager$AudioDeviceA);
                }
                this.r = arrayList;
                this.f2785s.k.onNext(arrayList);
            }
        }
        d.f1("DiscordAudioManager", "hasBluetoothHeadset() requires BLUETOOTH permission");
        z2 = false;
        synchronized (this.i) {
            List<DiscordAudioManager$AudioDevice> list2 = this.r;
            arrayList = new ArrayList(o.collectionSizeOrDefault(list2, 10));
            while (r4.hasNext()) {
                if (discordAudioManager$AudioDevice.type.ordinal() != 5) {
                    discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 15);
                } else {
                    if (this.D) {
                        z3 = z2;
                    } else {
                        z3 = z2;
                    }
                    if (bluetoothDevice3 != null) {
                        address = bluetoothDevice3.getAddress();
                    } else {
                        address = null;
                    }
                    if (bluetoothDevice3 != null) {
                        name = bluetoothDevice3.getName();
                    } else {
                        name = null;
                    }
                    discordAudioManager$AudioDeviceA = DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, z3, address, name, 1);
                }
                arrayList.add(discordAudioManager$AudioDeviceA);
            }
            this.r = arrayList;
            this.f2785s.k.onNext(arrayList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:62:0x0105  */
    public final void h(boolean z2) {
        AudioFocusRequest audioFocusRequest;
        c();
        if (!e().f262b) {
            d.f1("DiscordAudioManager", "MODIFY_AUDIO_SETTINGS is missing. Client will run with reduced functionality");
            return;
        }
        boolean z3 = false;
        if (z2) {
            Looper looperMyLooper = Looper.myLooper();
            f fVar = new f(this, looperMyLooper != null ? new Handler(looperMyLooper) : null);
            this.k.registerContentObserver(Settings$System.CONTENT_URI, true, fVar);
            this.v = fVar;
            this.A = this.e.isSpeakerphoneOn();
            this.B = this.e.isMicrophoneMute();
            this.C = this.e.isBluetoothScoOn();
            i(true);
            synchronized (this.i) {
                AudioManager$OnAudioFocusChangeListener audioManager$OnAudioFocusChangeListener = this.p;
                if (audioManager$OnAudioFocusChangeListener != null) {
                    if (Build$VERSION.SDK_INT >= 26) {
                        AudioFocusRequest$Builder audioFocusRequest$Builder = new AudioFocusRequest$Builder(1);
                        AudioAttributes$Builder audioAttributes$Builder = new AudioAttributes$Builder();
                        audioAttributes$Builder.setUsage(2);
                        audioAttributes$Builder.setContentType(1);
                        audioFocusRequest$Builder.setAcceptsDelayedFocusGain(true);
                        Looper looperMyLooper2 = Looper.myLooper();
                        m.checkNotNull(looperMyLooper2);
                        audioFocusRequest$Builder.setOnAudioFocusChangeListener(audioManager$OnAudioFocusChangeListener, new Handler(looperMyLooper2));
                        audioFocusRequest$Builder.setAudioAttributes(audioAttributes$Builder.build());
                        AudioFocusRequest audioFocusRequestBuild = audioFocusRequest$Builder.build();
                        this.q = audioFocusRequestBuild;
                        if (this.e.requestAudioFocus(audioFocusRequestBuild) == 1) {
                            z3 = true;
                        }
                    } else if (this.e.requestAudioFocus(audioManager$OnAudioFocusChangeListener, 0, 1) == 1) {
                        z3 = true;
                    }
                    if (z3) {
                        d.b1("DiscordAudioManager", "Successful requestAudioFocus()");
                    } else {
                        d.f1("DiscordAudioManager", "Unable to requestAudioFocus()");
                    }
                }
            }
            l();
            return;
        }
        ContentObserver contentObserver = this.v;
        if (contentObserver != null) {
            this.k.unregisterContentObserver(contentObserver);
        }
        this.v = null;
        b(DiscordAudioManager$DeviceTypes.INVALID);
        synchronized (this.i) {
            this.f2788z = DiscordAudioManager$DeviceTypes.DEFAULT;
        }
        i(false);
        if (Build$VERSION.SDK_INT >= 26) {
            synchronized (this.i) {
                audioFocusRequest = this.q;
            }
            if (audioFocusRequest != null && this.e.abandonAudioFocusRequest(audioFocusRequest) == 1) {
                z3 = true;
            }
            if (z3) {
                d.b1("DiscordAudioManager", "Successful releaseAudioFocus()");
            } else {
                d.f1("DiscordAudioManager", "Unable to releaseAudioFocus()");
            }
        } else {
            synchronized (this.i) {
                AudioManager$OnAudioFocusChangeListener audioManager$OnAudioFocusChangeListener2 = this.p;
                if (audioManager$OnAudioFocusChangeListener2 != null) {
                    if (this.e.abandonAudioFocus(audioManager$OnAudioFocusChangeListener2) == 1) {
                        z3 = true;
                    }
                    if (z3) {
                        d.b1("DiscordAudioManager", "Successful releaseAudioFocus()");
                    } else {
                        d.f1("DiscordAudioManager", "Unable to releaseAudioFocus()");
                    }
                }
            }
        }
        boolean z4 = this.B;
        if (this.e.isMicrophoneMute() != z4) {
            this.e.setMicrophoneMute(z4);
        }
        boolean z5 = this.A;
        if (this.e.isSpeakerphoneOn() != z5) {
            this.e.setSpeakerphoneOn(z5);
        }
        if (this.C) {
            j();
        }
    }

    public final void i(boolean z2) {
        try {
            this.e.setMode(z2 ? 3 : 0);
        } catch (SecurityException unused) {
        }
        synchronized (this.i) {
            this.D = z2;
        }
    }

    public final synchronized void j() {
        DiscordAudioManager$BluetoothScoState discordAudioManager$BluetoothScoState;
        DiscordAudioManager$BluetoothScoState discordAudioManager$BluetoothScoState2 = this.o;
        DiscordAudioManager$BluetoothScoState discordAudioManager$BluetoothScoState3 = DiscordAudioManager$BluetoothScoState.ON;
        if (discordAudioManager$BluetoothScoState2 != discordAudioManager$BluetoothScoState3 && discordAudioManager$BluetoothScoState2 != (discordAudioManager$BluetoothScoState = DiscordAudioManager$BluetoothScoState.TURNING_ON)) {
            if (this.e.isBluetoothScoOn()) {
                this.o = discordAudioManager$BluetoothScoState3;
            } else {
                this.o = discordAudioManager$BluetoothScoState;
                this.e.startBluetoothSco();
            }
        }
    }

    public final synchronized void k() {
        DiscordAudioManager$BluetoothScoState discordAudioManager$BluetoothScoState = this.o;
        if (discordAudioManager$BluetoothScoState == DiscordAudioManager$BluetoothScoState.ON || discordAudioManager$BluetoothScoState == DiscordAudioManager$BluetoothScoState.TURNING_ON) {
            if (!this.e.isBluetoothScoOn()) {
                this.o = DiscordAudioManager$BluetoothScoState.OFF;
            } else {
                this.o = DiscordAudioManager$BluetoothScoState.TURNING_OFF;
                this.e.stopBluetoothSco();
            }
        }
    }

    public final void l() {
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes;
        ArrayList arrayList;
        synchronized (this.i) {
            discordAudioManager$DeviceTypes = this.f2788z;
        }
        g();
        synchronized (this.i) {
            List<DiscordAudioManager$AudioDevice> list = this.r;
            arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DiscordAudioManager$AudioDevice.a((DiscordAudioManager$AudioDevice) it.next(), null, false, null, null, 15));
            }
        }
        if (discordAudioManager$DeviceTypes == DiscordAudioManager$DeviceTypes.DEFAULT || !arrayList.get(discordAudioManager$DeviceTypes.getValue()).isAvailable) {
            a(arrayList);
        } else {
            b(discordAudioManager$DeviceTypes);
        }
    }
}
