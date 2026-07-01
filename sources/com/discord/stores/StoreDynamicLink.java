package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import j0.l.e.k;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Emitter$BackpressureMode;
import rx.Observable;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink {
    private static final StoreDynamicLink$Companion Companion = new StoreDynamicLink$Companion(null);

    @Deprecated
    private static final long DYNAMIC_LINK_TIMEOUT_MS = 1000;
    private final Dispatcher dispatcher;
    private final StoreStream stream;

    public StoreDynamicLink(StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreDynamicLink storeDynamicLink) {
        return storeDynamicLink.stream;
    }

    public static final /* synthetic */ void access$handleDataReceived(StoreDynamicLink storeDynamicLink, StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData, Context context) {
        storeDynamicLink.handleDataReceived(storeDynamicLink$DynamicLinkData, context);
    }

    private final Observable<Uri> getDynamicLinkObservable(Intent intent) {
        Observable observableO = Observable.o(new StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1(intent), Emitter$BackpressureMode.BUFFER);
        m.checkNotNullExpressionValue(observableO, "Observable.create({\n    ….BackpressureMode.BUFFER)");
        Observable<Uri> observableM = Observable.I(new k(Uri.EMPTY).q(1000L, TimeUnit.MILLISECONDS), observableO).M(StoreDynamicLink$getDynamicLinkObservable$1.INSTANCE);
        m.checkNotNullExpressionValue(observableM, "Observable\n        .merg…ErrorReturn { Uri.EMPTY }");
        return observableM;
    }

    private final void handleDataReceived(StoreDynamicLink$DynamicLinkData data, Context context) {
        String guildTemplateCode;
        String inviteCode;
        this.dispatcher.schedule(new StoreDynamicLink$handleDataReceived$1(this, data));
        if (data != null && (inviteCode = data.getInviteCode()) != null && (!t.isBlank(inviteCode))) {
            IntentUtils$RouteBuilders intentUtils$RouteBuilders = IntentUtils$RouteBuilders.INSTANCE;
            String inviteCode2 = data.getInviteCode();
            Objects.requireNonNull(inviteCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, intentUtils$RouteBuilders.selectInvite(w.trim(inviteCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if (data != null && (guildTemplateCode = data.getGuildTemplateCode()) != null && (!t.isBlank(guildTemplateCode))) {
            IntentUtils$RouteBuilders intentUtils$RouteBuilders2 = IntentUtils$RouteBuilders.INSTANCE;
            String guildTemplateCode2 = data.getGuildTemplateCode();
            Objects.requireNonNull(guildTemplateCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, intentUtils$RouteBuilders2.selectGuildTemplate(w.trim(guildTemplateCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if ((data != null ? data.getUri() : null) != null) {
            Intent data2 = new Intent().setData(data.getUri());
            m.checkNotNullExpressionValue(data2, "Intent().setData(data.uri)");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, data2, context, null, 4, null);
        }
    }

    public final void storeLinkIfExists(Intent intent, Context context) {
        m.checkNotNullParameter(intent, "intent");
        m.checkNotNullParameter(context, "context");
        Observable<R> observableG = getDynamicLinkObservable(intent).G(StoreDynamicLink$storeLinkIfExists$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "getDynamicLinkObservable…ode, authToken)\n        }");
        Observable observableU = ObservableExtensionsKt.computationBuffered(observableG).r().u(StoreDynamicLink$storeLinkIfExists$2.INSTANCE);
        m.checkNotNullExpressionValue(observableU, "getDynamicLinkObservable…  )\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableU, StoreDynamicLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreDynamicLink$storeLinkIfExists$3(this, context), 62, (Object) null);
    }
}
