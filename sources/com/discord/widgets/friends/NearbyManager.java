package com.discord.widgets.friends;

import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.d;
import b.i.a.f.e.h.j.k;
import b.i.a.f.j.b.a;
import b.i.a.f.j.b.a$a;
import b.i.a.f.j.b.e.i;
import b.i.a.f.j.b.e.n;
import b.i.a.f.j.b.e.o;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import d0.g0.c;
import d0.z.d.m;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Objects;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NearbyManager {
    public static final int CONNECTION_ERROR = 99;
    public static final NearbyManager$Companion Companion = new NearbyManager$Companion(null);
    public static final int PERMISSION_DENIED = 98;
    private Long meUserId;
    private MessageListener messageListener;
    private PublishOptions messagePublishOptions;
    private MessagesClient messagesClient;
    private Message outboundMessage;
    private SubscribeOptions subscribeOptions;
    private final HashSet<Long> nearbyUserIds = new HashSet<>();
    private final BehaviorSubject<NearbyManager$NearbyState> nearbyStateSubject = BehaviorSubject.l0(NearbyManager$NearbyState$Uninitialized.INSTANCE);

    public static final /* synthetic */ void access$foundUserId(NearbyManager nearbyManager, long j) {
        nearbyManager.foundUserId(j);
    }

    public static final /* synthetic */ BehaviorSubject access$getNearbyStateSubject$p(NearbyManager nearbyManager) {
        return nearbyManager.nearbyStateSubject;
    }

    public static final /* synthetic */ HashSet access$getNearbyUserIds$p(NearbyManager nearbyManager) {
        return nearbyManager.nearbyUserIds;
    }

    public static final /* synthetic */ void access$lostUserId(NearbyManager nearbyManager, long j) {
        nearbyManager.lostUserId(j);
    }

    public static final /* synthetic */ Long access$parseUserId(NearbyManager nearbyManager, Message message) {
        return nearbyManager.parseUserId(message);
    }

    private final void buildClient(FragmentActivity fragmentActivity) {
        a aVar = new a(new a$a(), null);
        d.z(fragmentActivity, "Activity must not be null");
        d.z(aVar, "Options must not be null");
        i iVar = new i(fragmentActivity, aVar);
        k kVarM = iVar.m(new NearbyManager$buildClient$$inlined$also$lambda$1(this));
        iVar.k(kVarM, new n(kVarM), new o(kVarM));
        this.messagesClient = iVar;
    }

    private final synchronized void foundUserId(long userId) {
        Long l = this.meUserId;
        if (l == null || userId != l.longValue()) {
            this.nearbyUserIds.add(Long.valueOf(userId));
            this.nearbyStateSubject.onNext(new NearbyManager$NearbyState$Connected(new HashSet(this.nearbyUserIds)));
        }
    }

    private final synchronized void lostUserId(long userId) {
        this.nearbyUserIds.remove(Long.valueOf(userId));
        this.nearbyStateSubject.onNext(new NearbyManager$NearbyState$Connected(new HashSet(this.nearbyUserIds)));
    }

    private final Long parseUserId(Message message) {
        byte[] bArr = message.l;
        m.checkNotNullExpressionValue(bArr, "message.content");
        String str = new String(bArr, c.a);
        if (str.charAt(0) == 'u') {
            try {
                String strSubstring = str.substring(2);
                m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return Long.valueOf(Long.parseLong(strSubstring));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private final void setupBroadcaster(long userId) {
        this.messagePublishOptions = new PublishOptions(Strategy.j, new NearbyManager$setupBroadcaster$1(this), null);
        String strT = b.d.b.a.a.t("u:", userId);
        Charset charset = c.a;
        Objects.requireNonNull(strT, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strT.getBytes(charset);
        m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.outboundMessage = new Message(2, bytes, "", "", Message.j, 0L);
    }

    private final void setupListener() {
        this.messageListener = new NearbyManager$setupListener$1(this);
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
        this.nearbyStateSubject.onNext(new NearbyManager$NearbyState$Connected(new HashSet(this.nearbyUserIds)));
        messagesClient.f(message, publishOptions);
        messagesClient.g(messageListener, subscribeOptions);
    }

    public final void buildClientAndPublish(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
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
        this.nearbyStateSubject.onNext(NearbyManager$NearbyState$Uninitialized.INSTANCE);
    }

    public final Observable<NearbyManager$NearbyState> getState() {
        BehaviorSubject<NearbyManager$NearbyState> behaviorSubject = this.nearbyStateSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "nearbyStateSubject");
        return behaviorSubject;
    }

    public final void initialize(long userId) {
        this.meUserId = Long.valueOf(userId);
        setupBroadcaster(userId);
        setupListener();
    }
}
