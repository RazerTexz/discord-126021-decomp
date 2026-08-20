package com.discord.widgets.friends;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.fragment.app.FragmentActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.internal.zzcb;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3936m;
import p007b.p225i.p226a.p288f.p313h.p326m.C3938o;
import p007b.p225i.p226a.p288f.p333j.p334b.C4264a;
import p007b.p225i.p226a.p288f.p333j.p334b.C4265b;
import p007b.p225i.p226a.p288f.p333j.p334b.C4266c;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4286i;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0;
import p507d0.p579g0.C12086c;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

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
    private final BehaviorSubject<NearbyState> nearbyStateSubject = BehaviorSubject.m11130l0(NearbyState.Uninitialized.INSTANCE);

    /* JADX INFO: compiled from: NearbyManager.kt */
    public static abstract class NearbyState {

        /* JADX INFO: compiled from: NearbyManager.kt */
        public static final /* data */ class Connected extends NearbyState {
            private final Set<Long> nearbyUserIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Connected(Set<Long> set) {
                super(null);
                C12238m.checkNotNullParameter(set, "nearbyUserIds");
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
                C12238m.checkNotNullParameter(nearbyUserIds, "nearbyUserIds");
                return new Connected(nearbyUserIds);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connected) && C12238m.areEqual(this.nearbyUserIds, ((Connected) other).nearbyUserIds);
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
                return C1643a.m826N(C1643a.m833U("Connected(nearbyUserIds="), this.nearbyUserIds, ")");
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
                return C1643a.m814B(C1643a.m833U("Disconnected(code="), this.code, ")");
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
        C4264a c4264a = new C4264a(new C4264a.a(), null);
        C1460d.m595z(fragmentActivity, "Activity must not be null");
        C1460d.m595z(c4264a, "Options must not be null");
        C4286i c4286i = new C4286i(fragmentActivity, c4264a);
        final C3301k c3301kM5990m = c4286i.m5990m(new C4266c() { // from class: com.discord.widgets.friends.NearbyManager$buildClient$$inlined$also$lambda$1
            @Override // p007b.p225i.p226a.p288f.p333j.p334b.C4266c
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
        c4286i.m5988k(c3301kM5990m, new InterfaceC4269a0(c3301kM5990m) { // from class: b.i.a.f.j.b.e.n

            /* JADX INFO: renamed from: a */
            public final C3301k f11427a;

            {
                this.f11427a = c3301kM5990m;
            }

            @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
            /* JADX INFO: renamed from: a */
            public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
                C3301k c3301k2 = this.f11427a;
                if (!c4280f.f11408A.m5407a(c3301k2.f9430c)) {
                    C3938o<C3301k.a, IBinder> c3938o = c4280f.f11408A;
                    c3938o.f10465a.put(c3301k2.f9430c, new WeakReference<>(new BinderC3936m(c3301k2)));
                }
                zzcb zzcbVar = new zzcb(1, new BinderC3933j(c3301k), c4280f.f11408A.m5408b(c3301k2.f9430c), false, null, null);
                zzcbVar.f20793m = true;
                ((InterfaceC4311u0) c4280f.m4142w()).mo5996s(zzcbVar);
            }
        }, new InterfaceC4269a0(c3301kM5990m) { // from class: b.i.a.f.j.b.e.o

            /* JADX INFO: renamed from: a */
            public final C3301k f11428a;

            {
                this.f11428a = c3301kM5990m;
            }

            @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
            /* JADX INFO: renamed from: a */
            public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
                C3301k c3301k2 = this.f11428a;
                Objects.requireNonNull(c4280f);
                BinderC3933j binderC3933j = new BinderC3933j(c3301k);
                if (!c4280f.f11408A.m5407a(c3301k2.f9430c)) {
                    binderC3933j.m5406g(new Status(0, null));
                    return;
                }
                zzcb zzcbVar = new zzcb(1, binderC3933j, c4280f.f11408A.m5408b(c3301k2.f9430c), false, null, null);
                zzcbVar.f20793m = false;
                ((InterfaceC4311u0) c4280f.m4142w()).mo5996s(zzcbVar);
                C3938o<C3301k.a, IBinder> c3938o = c4280f.f11408A;
                c3938o.f10465a.remove(c3301k2.f9430c);
            }
        });
        this.messagesClient = c4286i;
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
        byte[] bArr = message.f20713l;
        C12238m.checkNotNullExpressionValue(bArr, "message.content");
        String str = new String(bArr, C12086c.f25136a);
        if (str.charAt(0) == 'u') {
            try {
                String strSubstring = str.substring(2);
                C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return Long.valueOf(Long.parseLong(strSubstring));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private final void setupBroadcaster(long userId) {
        this.messagePublishOptions = new PublishOptions(Strategy.f20727j, new C4265b() { // from class: com.discord.widgets.friends.NearbyManager.setupBroadcaster.1
            @Override // p007b.p225i.p226a.p288f.p333j.p334b.C4265b
            public void onExpired() {
                super.onExpired();
                NearbyManager.this.activateNearby();
            }
        }, null);
        String strM877t = C1643a.m877t("u:", userId);
        Charset charset = C12086c.f25136a;
        Objects.requireNonNull(strM877t, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strM877t.getBytes(charset);
        C12238m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.outboundMessage = new Message(2, bytes, "", "", Message.f20711j, 0L);
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
        Strategy strategy = Strategy.f20727j;
        this.subscribeOptions = new SubscribeOptions(Strategy.f20728k, MessageFilter.f20718j, null);
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
        messagesClient.mo5984f(message, publishOptions);
        messagesClient.mo5985g(messageListener, subscribeOptions);
    }

    public final void buildClientAndPublish(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
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
        messagesClient.mo5986h(message);
        messagesClient.mo5987i(messageListener);
        this.nearbyUserIds.clear();
        this.nearbyStateSubject.onNext(NearbyState.Uninitialized.INSTANCE);
    }

    public final Observable<NearbyState> getState() {
        BehaviorSubject<NearbyState> behaviorSubject = this.nearbyStateSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "nearbyStateSubject");
        return behaviorSubject;
    }

    public final void initialize(long userId) {
        this.meUserId = Long.valueOf(userId);
        setupBroadcaster(userId);
        setupListener();
    }
}
