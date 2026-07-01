package com.discord.stores;

import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberVerificationForm extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, StoreGuildMemberVerificationForm$MemberVerificationFormData> memberVerificationFormSnapshot;
    private final HashMap<Long, StoreGuildMemberVerificationForm$MemberVerificationFormData> memberVerificationFormState;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    public /* synthetic */ StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getMemberVerificationFormState$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.memberVerificationFormState;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.restAPI;
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchFailed(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchStart(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchStart(j);
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchSuccess(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j, ModelMemberVerificationForm modelMemberVerificationForm) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchSuccess(j, modelMemberVerificationForm);
    }

    @StoreThread
    private final void handleMemberVerificationFormFetchFailed(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new StoreGuildMemberVerificationForm$MemberVerificationFormData(StoreGuildMemberVerificationForm$FetchStates.FAILED, null));
        markChanged();
    }

    @StoreThread
    private final void handleMemberVerificationFormFetchStart(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new StoreGuildMemberVerificationForm$MemberVerificationFormData(StoreGuildMemberVerificationForm$FetchStates.FETCHING, null));
        markChanged();
    }

    @StoreThread
    private final void handleMemberVerificationFormFetchSuccess(long guildId, ModelMemberVerificationForm memberVerificationForm) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new StoreGuildMemberVerificationForm$MemberVerificationFormData(StoreGuildMemberVerificationForm$FetchStates.SUCCEEDED, memberVerificationForm));
        markChanged();
    }

    public final void fetchMemberVerificationForm(long guildId) {
        this.dispatcher.schedule(new StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1(this, guildId));
    }

    public final StoreGuildMemberVerificationForm$MemberVerificationFormData getMemberVerificationFormData(long guildId) {
        return this.memberVerificationFormSnapshot.get(Long.valueOf(guildId));
    }

    public final Observable<StoreGuildMemberVerificationForm$MemberVerificationFormData> observeMemberVerificationFormData(long guildId) {
        Observable<StoreGuildMemberVerificationForm$MemberVerificationFormData> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildMemberVerificationForm$observeMemberVerificationFormData$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.memberVerificationFormSnapshot = new HashMap(this.memberVerificationFormState);
    }

    public StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.memberVerificationFormSnapshot = h0.emptyMap();
        this.memberVerificationFormState = new HashMap<>();
    }
}
