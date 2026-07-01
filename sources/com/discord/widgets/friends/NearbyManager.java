package com.discord.widgets.friends;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.h.j.k;
import b.i.a.f.j.b.a;
import b.i.a.f.j.b.b;
import b.i.a.f.j.b.c;
import b.i.a.f.j.b.e.a0;
import b.i.a.f.j.b.e.i;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.friends.NearbyManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.internal.zzcb;
import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NearbyManager {
    public static final int CONNECTION_ERROR = 99;
    public static final int PERMISSION_DENIED = 98;
    private Long meUserId;
    private MessageListener messageListener;
    private PublishOptions messagePublishOptions;
    private MessagesClient messagesClient;
    private Message outboundMessage;
    private SubscribeOptions subscribeOptions;
    private final HashSet<Long> nearbyUserIds = new HashSet<>();
    private final BehaviorSubject<NearbyState> nearbyStateSubject = BehaviorSubject.l0(NearbyState.Uninitialized.INSTANCE);

    /* JADX INFO: compiled from: NearbyManager.kt */
    public static abstract class NearbyState {

        /* JADX INFO: compiled from: NearbyManager.kt */
        public static final /* data */ class Connected extends NearbyState {
            private final Set<Long> nearbyUserIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Connected(Set<Long> set) {
                super(null);
                Intrinsics3.checkNotNullParameter(set, "nearbyUserIds");
                this.nearbyUserIds = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Connected copy$default(Connected connected, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = connected.nearbyUserIds;
                }
                return connected.copy(set);
            }

            public final Set<Long> component1() {
                return this.nearbyUserIds;
            }

            public final Connected copy(Set<Long> nearbyUserIds) {
                Intrinsics3.checkNotNullParameter(nearbyUserIds, "nearbyUserIds");
                return new Connected(nearbyUserIds);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connected) && Intrinsics3.areEqual(this.nearbyUserIds, ((Connected) other).nearbyUserIds);
                }
                return true;
            }

            public final Set<Long> getNearbyUserIds() {
                return this.nearbyUserIds;
            }

            public int hashCode() {
                Set<Long> set = this.nearbyUserIds;
                if (set != null) {
                    return set.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.N(outline.U("Connected(nearbyUserIds="), this.nearbyUserIds, ")");
            }
        }

        /* JADX INFO: compiled from: NearbyManager.kt */
        public static final /* data */ class Disconnected extends NearbyState {
            private final int code;

            public Disconnected(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Disconnected copy$default(Disconnected disconnected, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = disconnected.code;
                }
                return disconnected.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Disconnected copy(int code) {
                return new Disconnected(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Disconnected) && this.code == ((Disconnected) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.B(outline.U("Disconnected(code="), this.code, ")");
            }
        }

        /* JADX INFO: compiled from: NearbyManager.kt */
        public static final class Uninitialized extends NearbyState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private NearbyState() {
        }

        public /* synthetic */ NearbyState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void buildClient(FragmentActivity fragmentActivity) {
        a aVar = new a(new a.C0042a(), null);
        AnimatableValueParser.z(fragmentActivity, "Activity must not be null");
        AnimatableValueParser.z(aVar, "Options must not be null");
        i iVar = new i(fragmentActivity, aVar);
        final k kVarM = iVar.m(new c() { // from class: com.discord.widgets.friends.NearbyManager$buildClient$$inlined$also$lambda$1
            @Override // b.i.a.f.j.b.c
            public void onPermissionChanged(boolean permissionGranted) {
                super.onPermissionChanged(permissionGranted);
                if (!permissionGranted) {
                    this.this$0.nearbyStateSubject.onNext(new NearbyManager.NearbyState.Disconnected(98));
                } else {
                    AnalyticsTracker.nearbyConnected();
                    this.this$0.nearbyStateSubject.onNext(new NearbyManager.NearbyState.Connected(new HashSet(this.this$0.nearbyUserIds)));
                }
            }
        });
        iVar.k(kVarM, new a0(kVarM) { // from class: b.i.a.f.j.b.e.n
            public final b.i.a.f.e.h.j.k a;

            {
                this.a = kVarM;
            }

            @Override // b.i.a.f.j.b.e.a0
            public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
                b.i.a.f.e.h.j.k kVar2 = this.a;
                if (!fVar.A.a(kVar2.c)) {
                    b.i.a.f.h.m.o<k.a, IBinder> oVar = fVar.A;
                    oVar.a.put(kVar2.c, new WeakReference<>(new b.i.a.f.h.m.m(kVar2)));
                }
                zzcb zzcbVar = new zzcb(1, new b.i.a.f.h.m.j(kVar), fVar.A.b(kVar2.c), false, null, null);
                zzcbVar.m = true;
                ((u0) fVar.w()).s(zzcbVar);
            }
        }, new a0(kVarM) { // from class: b.i.a.f.j.b.e.o
            public final b.i.a.f.e.h.j.k a;

            {
                this.a = kVarM;
            }

            @Override // b.i.a.f.j.b.e.a0
            public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
                b.i.a.f.e.h.j.k kVar2 = this.a;
                Objects.requireNonNull(fVar);
                b.i.a.f.h.m.j jVar = new b.i.a.f.h.m.j(kVar);
                if (!fVar.A.a(kVar2.c)) {
                    jVar.g(new Status(0, null));
                    return;
                }
                zzcb zzcbVar = new zzcb(1, jVar, fVar.A.b(kVar2.c), false, null, null);
                zzcbVar.m = false;
                ((u0) fVar.w()).s(zzcbVar);
                b.i.a.f.h.m.o<k.a, IBinder> oVar = fVar.A;
                oVar.a.remove(kVar2.c);
            }
        });
        this.messagesClient = iVar;
    }

    private final synchronized void foundUserId(long userId) {
        Long l = this.meUserId;
        if (l == null || userId != l.longValue()) {
            this.nearbyUserIds.add(Long.valueOf(userId));
            this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
        }
    }

    private final synchronized void lostUserId(long userId) {
        this.nearbyUserIds.remove(Long.valueOf(userId));
        this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
    }

    private final Long parseUserId(Message message) {
        byte[] bArr = message.l;
        Intrinsics3.checkNotNullExpressionValue(bArr, "message.content");
        String str = new String(bArr, Charsets2.a);
        if (str.charAt(0) == 'u') {
            try {
                String strSubstring = str.substring(2);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return Long.valueOf(Long.parseLong(strSubstring));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private final void setupBroadcaster(long userId) {
        this.messagePublishOptions = new PublishOptions(Strategy.j, new b() { // from class: com.discord.widgets.friends.NearbyManager.setupBroadcaster.1
            @Override // b.i.a.f.j.b.b
            public void onExpired() {
                super.onExpired();
                NearbyManager.this.activateNearby();
            }
        }, null);
        String strT = outline.t("u:", userId);
        Charset charset = Charsets2.a;
        Objects.requireNonNull(strT, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strT.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.outboundMessage = new Message(2, bytes, "", "", Message.j, 0L);
    }

    private final void setupListener() {
        this.messageListener = new MessageListener() { // from class: com.discord.widgets.friends.NearbyManager.setupListener.1
            @Override // com.google.android.gms.nearby.messages.MessageListener
            public void onFound(Message message) {
                Long userId;
                super.onFound(message);
                if (message == null || (userId = NearbyManager.this.parseUserId(message)) == null) {
                    return;
                }
                NearbyManager.this.foundUserId(userId.longValue());
            }

            @Override // com.google.android.gms.nearby.messages.MessageListener
            public void onLost(Message message) {
                Long userId;
                super.onLost(message);
                if (message == null || (userId = NearbyManager.this.parseUserId(message)) == null) {
                    return;
                }
                NearbyManager.this.lostUserId(userId.longValue());
            }
        };
        Strategy strategy = Strategy.j;
        this.subscribeOptions = new SubscribeOptions(Strategy.k, MessageFilter.j, null);
    }

    public final void activateNearby() {
        Message message;
        PublishOptions publishOptions;
        MessageListener messageListener;
        SubscribeOptions subscribeOptions;
        MessagesClient messagesClient = this.messagesClient;
        if (messagesClient == null || (message = this.outboundMessage) == null || (publishOptions = this.messagePublishOptions) == null || (messageListener = this.messageListener) == null || (subscribeOptions = this.subscribeOptions) == null) {
            return;
        }
        this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
        messagesClient.f(message, publishOptions);
        messagesClient.g(messageListener, subscribeOptions);
    }

    public final void buildClientAndPublish(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        if (this.messagesClient == null) {
            buildClient(fragmentActivity);
        }
        activateNearby();
    }

    public final void disableNearby() {
        Message message;
        MessageListener messageListener;
        MessagesClient messagesClient = this.messagesClient;
        if (messagesClient == null || (message = this.outboundMessage) == null || (messageListener = this.messageListener) == null) {
            return;
        }
        messagesClient.h(message);
        messagesClient.i(messageListener);
        this.nearbyUserIds.clear();
        this.nearbyStateSubject.onNext(NearbyState.Uninitialized.INSTANCE);
    }

    public final Observable<NearbyState> getState() {
        BehaviorSubject<NearbyState> behaviorSubject = this.nearbyStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "nearbyStateSubject");
        return behaviorSubject;
    }

    public final void initialize(long userId) {
        this.meUserId = Long.valueOf(userId);
        setupBroadcaster(userId);
        setupListener();
    }
}
