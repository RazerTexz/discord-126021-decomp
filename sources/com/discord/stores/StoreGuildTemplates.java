package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error$Type;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildTemplates extends StoreV2 {
    private final Dispatcher dispatcher;
    private String dynamicLinkGuildTemplateCode;
    private final Map<String, StoreGuildTemplates$GuildTemplateState> guildTemplatesByCode;
    private Map<String, ? extends StoreGuildTemplates$GuildTemplateState> guildTemplatesByCodeSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    public StoreGuildTemplates(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildTemplatesByCode = new LinkedHashMap();
        this.guildTemplatesByCodeSnapshot = h0.emptyMap();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildTemplates storeGuildTemplates) {
        return storeGuildTemplates.dispatcher;
    }

    public static final /* synthetic */ String access$getDynamicLinkGuildTemplateCode$p(StoreGuildTemplates storeGuildTemplates) {
        return storeGuildTemplates.dynamicLinkGuildTemplateCode;
    }

    public static final /* synthetic */ Map access$getGuildTemplatesByCode$p(StoreGuildTemplates storeGuildTemplates) {
        return storeGuildTemplates.guildTemplatesByCode;
    }

    public static final /* synthetic */ void access$handleRequestGuildTemplateError(StoreGuildTemplates storeGuildTemplates, String str, Error$Type error$Type) {
        storeGuildTemplates.handleRequestGuildTemplateError(str, error$Type);
    }

    public static final /* synthetic */ void access$handleRequestGuildTemplateSuccess(StoreGuildTemplates storeGuildTemplates, ModelGuildTemplate modelGuildTemplate) {
        storeGuildTemplates.handleRequestGuildTemplateSuccess(modelGuildTemplate);
    }

    public static final /* synthetic */ void access$requestGuildTemplate(StoreGuildTemplates storeGuildTemplates, String str) {
        storeGuildTemplates.requestGuildTemplate(str);
    }

    public static final /* synthetic */ void access$setDynamicLinkGuildTemplateCode$p(StoreGuildTemplates storeGuildTemplates, String str) {
        storeGuildTemplates.dynamicLinkGuildTemplateCode = str;
    }

    @StoreThread
    private final void handleRequestGuildTemplateError(String guildTemplateCode, Error$Type errorType) {
        int iOrdinal = errorType.ordinal();
        if (iOrdinal == 3) {
            this.guildTemplatesByCode.put(guildTemplateCode, StoreGuildTemplates$GuildTemplateState$Invalid.INSTANCE);
            markChanged();
            AnalyticsTracker.guildTemplateResolveFailed(guildTemplateCode);
        } else {
            if (iOrdinal != 11) {
                return;
            }
            this.guildTemplatesByCode.put(guildTemplateCode, StoreGuildTemplates$GuildTemplateState$LoadFailed.INSTANCE);
            markChanged();
        }
    }

    @StoreThread
    private final void handleRequestGuildTemplateSuccess(ModelGuildTemplate guildTemplate) {
        this.guildTemplatesByCode.put(guildTemplate.getCode(), new StoreGuildTemplates$GuildTemplateState$Resolved(guildTemplate));
        markChanged();
        AnalyticsTracker.INSTANCE.guildTemplateResolved(guildTemplate);
    }

    private final void requestGuildTemplate(String guildTemplateCode) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildTemplateCode(guildTemplateCode), false, 1, null), StoreGuildTemplates.class, (Context) null, (Function1) null, new StoreGuildTemplates$requestGuildTemplate$2(this, guildTemplateCode), (Function0) null, (Function0) null, new StoreGuildTemplates$requestGuildTemplate$1(this), 54, (Object) null);
    }

    public final void clearDynamicLinkGuildTemplateCode() {
        setDynamicLinkGuildTemplateCode(null);
    }

    public final String getDynamicLinkGuildTemplateCode() {
        return this.dynamicLinkGuildTemplateCode;
    }

    public final StoreGuildTemplates$GuildTemplateState getGuildTemplate(String guildTemplateCode) {
        m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return this.guildTemplatesByCodeSnapshot.get(guildTemplateCode);
    }

    public final void maybeInitTemplateState(String guildTemplateCode) {
        m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        this.dispatcher.schedule(new StoreGuildTemplates$maybeInitTemplateState$1(this, guildTemplateCode));
    }

    public final Observable<String> observeDynamicLinkGuildTemplateCode() {
        Observable<String> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildTemplates$observeDynamicLinkGuildTemplateCode$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreGuildTemplates$GuildTemplateState> observeGuildTemplate(String guildTemplateCode) {
        m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        Observable<StoreGuildTemplates$GuildTemplateState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildTemplates$observeGuildTemplate$1(this, guildTemplateCode), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setDynamicLinkGuildTemplateCode(String guildTemplateCode) {
        this.dispatcher.schedule(new StoreGuildTemplates$setDynamicLinkGuildTemplateCode$1(this, guildTemplateCode));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildTemplatesByCodeSnapshot = new HashMap(this.guildTemplatesByCode);
    }
}
