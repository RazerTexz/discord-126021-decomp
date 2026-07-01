package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import androidx.collection.LruCache;
import androidx.media.AudioAttributesCompat;
import b.a.b.a;
import b.i.d.e;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.interaction.Interaction;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.domain.NonceGenerator$Companion;
import com.discord.models.message.Message;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.restapi.RestAPIParams$ComponentInteractionData;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreatorsKt;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$Success;
import com.discord.utilities.messagesend.MessageResult$UnknownFailure;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.google.gson.Gson;
import com.lytefast.flexinput.model.Attachment;
import d0.g0.t;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions extends StoreV2 {
    private static final String CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET = "CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET";
    public static final StoreApplicationInteractions$Companion Companion = new StoreApplicationInteractions$Companion(null);
    private static final ObservationDeck$UpdateSource ComponentStateUpdate = new StoreApplicationInteractions$Companion$ComponentStateUpdate$1();
    private static final ObservationDeck$UpdateSource SentInteractionsUpdate = new StoreApplicationInteractions$Companion$SentInteractionsUpdate$1();
    public static final long TYPE_COMPONENT_INTERACTION = 3;
    public static final long TYPE_MODAL_INTERACTION = 5;
    private Map<String, ApplicationCommandLocalSendData> applicationCommandLocalSendDataSet;
    private Map<String, ApplicationCommandLocalSendData> applicationCommandLocalSendDataSnapshot;
    private final Clock clock;
    private final Map<String, StoreApplicationInteractions$ComponentLocation> componentInteractions;
    private final Dispatcher dispatcher;
    private final Gson gson;
    private final Map<Long, Map<Integer, StoreApplicationInteractions$InteractionSendState>> interactionComponentSendState;
    private Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState>> interactionComponentSendStateSnapshot;
    private final HashMap<Long, StoreApplicationInteractions$State> interactionData;
    private Map<Long, ? extends StoreApplicationInteractions$State> interactionDataSnapshot;
    private final PublishSubject<InteractionModalCreate> interactionModalCreate;
    private final NonceGenerator nonceGenerator;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final LruCache<String, StoreApplicationInteractions$SentInteraction> sentInteractions;
    private Map<String, StoreApplicationInteractions$SentInteraction> sentInteractionsSnapshot;
    private String sessionId;
    private final SharedPreferences sharedPrefs;
    private final StoreLocalActionComponentState storeLocalActionComponentState;
    private final StoreMessages storeMessages;
    private final StoreStream storeStream;
    private final StoreUser storeUser;

    public /* synthetic */ StoreApplicationInteractions(StoreStream storeStream, Dispatcher dispatcher, StoreMessages storeMessages, StoreLocalActionComponentState storeLocalActionComponentState, StoreUser storeUser, Clock clock, SharedPreferences sharedPreferences, ObservationDeck observationDeck, RestAPI restAPI, NonceGenerator nonceGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeMessages, storeLocalActionComponentState, storeUser, clock, (i & 64) != 0 ? SharedPreferencesProvider.INSTANCE.get() : sharedPreferences, (i & 128) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 256) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 512) != 0 ? new NonceGenerator() : nonceGenerator);
    }

    public static final /* synthetic */ void access$addInteractionStateToComponent(StoreApplicationInteractions storeApplicationInteractions, long j, int i, StoreApplicationInteractions$InteractionSendState storeApplicationInteractions$InteractionSendState) {
        storeApplicationInteractions.addInteractionStateToComponent(j, i, storeApplicationInteractions$InteractionSendState);
    }

    public static final /* synthetic */ ObservationDeck$UpdateSource access$getComponentStateUpdate$cp() {
        return ComponentStateUpdate;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.restAPI;
    }

    public static final /* synthetic */ Map access$getSentInteractionsSnapshot$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.sentInteractionsSnapshot;
    }

    public static final /* synthetic */ ObservationDeck$UpdateSource access$getSentInteractionsUpdate$cp() {
        return SentInteractionsUpdate;
    }

    public static final /* synthetic */ String access$getSessionId$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.sessionId;
    }

    public static final /* synthetic */ StoreLocalActionComponentState access$getStoreLocalActionComponentState$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.storeLocalActionComponentState;
    }

    public static final /* synthetic */ StoreMessages access$getStoreMessages$p(StoreApplicationInteractions storeApplicationInteractions) {
        return storeApplicationInteractions.storeMessages;
    }

    public static final /* synthetic */ void access$handleApplicationCommandResult(StoreApplicationInteractions storeApplicationInteractions, MessageResult messageResult, ApplicationCommandLocalSendData applicationCommandLocalSendData, Function0 function0, Function1 function1) {
        storeApplicationInteractions.handleApplicationCommandResult(messageResult, applicationCommandLocalSendData, function0, function1);
    }

    public static final /* synthetic */ void access$handleInteractionDataFetchFailure(StoreApplicationInteractions storeApplicationInteractions, long j) {
        storeApplicationInteractions.handleInteractionDataFetchFailure(j);
    }

    public static final /* synthetic */ void access$handleInteractionDataFetchStart(StoreApplicationInteractions storeApplicationInteractions, long j) {
        storeApplicationInteractions.handleInteractionDataFetchStart(j);
    }

    public static final /* synthetic */ void access$handleInteractionDataFetchSuccess(StoreApplicationInteractions storeApplicationInteractions, long j, ApplicationCommandData applicationCommandData) {
        storeApplicationInteractions.handleInteractionDataFetchSuccess(j, applicationCommandData);
    }

    public static final /* synthetic */ void access$handleSendApplicationCommandRequest(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, Function0 function0, Function1 function1) {
        storeApplicationInteractions.handleSendApplicationCommandRequest(applicationCommandLocalSendData, list, function0, function1);
    }

    public static final /* synthetic */ void access$removeApplicationCommandSendData(StoreApplicationInteractions storeApplicationInteractions, String str) {
        storeApplicationInteractions.removeApplicationCommandSendData(str);
    }

    public static final /* synthetic */ void access$setSentInteractionsSnapshot$p(StoreApplicationInteractions storeApplicationInteractions, Map map) {
        storeApplicationInteractions.sentInteractionsSnapshot = map;
    }

    public static final /* synthetic */ void access$setSessionId$p(StoreApplicationInteractions storeApplicationInteractions, String str) {
        storeApplicationInteractions.sessionId = str;
    }

    @StoreThread
    private final void addInteractionStateToComponent(long messageId, int componentIndex, StoreApplicationInteractions$InteractionSendState sendState) {
        this.interactionComponentSendState.put(Long.valueOf(messageId), g0.mapOf(o.to(Integer.valueOf(componentIndex), sendState)));
        markChanged(ComponentStateUpdate);
    }

    private final Message buildApplicationCommandLocalMessage(ApplicationCommandLocalSendData localSendData, boolean isLoading, boolean isFailed) {
        return LocalMessageCreatorsKt.createLocalApplicationCommandMessage(localSendData.getNonce(), localSendData.getApplicationCommandName(), localSendData.getChannelId(), UserUtils.INSTANCE.synthesizeApiUser(this.storeUser.getMeSnapshot()), toUser(localSendData.getApplication()), isFailed, isLoading, localSendData.getInteractionId(), this.clock);
    }

    public static /* synthetic */ Message buildApplicationCommandLocalMessage$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return storeApplicationInteractions.buildApplicationCommandLocalMessage(applicationCommandLocalSendData, z2, z3);
    }

    @StoreThread
    private final void clearCache() {
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.sharedPrefs.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, null);
        sharedPreferences$EditorEdit.apply();
        this.applicationCommandLocalSendDataSet.clear();
        markChanged();
    }

    private final void clearComponentInteractionSendSuccessAndFailures() {
        this.dispatcher.schedule(new StoreApplicationInteractions$clearComponentInteractionSendSuccessAndFailures$1(this));
    }

    @StoreThread
    private final void handleApplicationCommandRequestStateUpdate(ApplicationCommandLocalSendData localSendData, Long interactionId) {
        upsertApplicationCommandSendData(ApplicationCommandLocalSendData.copy$default(localSendData, 0L, 0L, null, null, null, null, null, null, null, null, interactionId, AudioAttributesCompat.FLAG_ALL, null));
    }

    public static /* synthetic */ void handleApplicationCommandRequestStateUpdate$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeApplicationInteractions.handleApplicationCommandRequestStateUpdate(applicationCommandLocalSendData, l);
    }

    @StoreThread
    private final void handleApplicationCommandResult(MessageResult result, ApplicationCommandLocalSendData localSendData, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(localSendData.getNonceString());
        boolean z2 = (applicationCommandLocalSendData != null ? applicationCommandLocalSendData.getInteractionId() : null) == null;
        if (result instanceof MessageResult$Success) {
            if (onSuccess != null) {
                onSuccess.invoke();
            }
            if (z2) {
                handleApplicationCommandRequestStateUpdate$default(this, localSendData, null, 2, null);
                return;
            }
            return;
        }
        if (!(result instanceof MessageResult$UnknownFailure)) {
            if (z2) {
                this.storeStream.handleInteractionFailure(new InteractionStateUpdate(localSendData.getInteractionId(), localSendData.getNonceString()));
            }
        } else {
            if (onFail != null) {
                onFail.invoke(((MessageResult$UnknownFailure) result).getError());
            }
            if (z2) {
                this.storeStream.handleInteractionFailure(new InteractionStateUpdate(localSendData.getInteractionId(), localSendData.getNonceString()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleApplicationCommandResult$default(StoreApplicationInteractions storeApplicationInteractions, MessageResult messageResult, ApplicationCommandLocalSendData applicationCommandLocalSendData, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        storeApplicationInteractions.handleApplicationCommandResult(messageResult, applicationCommandLocalSendData, function0, function1);
    }

    private final void handleComponentInteractionMessage(StoreApplicationInteractions$ComponentLocation componentLocation) {
        addInteractionStateToComponent(componentLocation.getMessageId(), componentLocation.getComponentIndex(), StoreApplicationInteractions$InteractionSendState$Success.INSTANCE);
    }

    @StoreThread
    private final void handleInteractionDataFetchFailure(long interactionId) {
        this.interactionData.put(Long.valueOf(interactionId), StoreApplicationInteractions$State$Failure.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleInteractionDataFetchStart(long interactionId) {
        this.interactionData.put(Long.valueOf(interactionId), StoreApplicationInteractions$State$Fetching.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleInteractionDataFetchSuccess(long interactionId, ApplicationCommandData interactionData) {
        this.interactionData.put(Long.valueOf(interactionId), new StoreApplicationInteractions$State$Loaded(interactionData));
        markChanged();
    }

    public static /* synthetic */ void handleInteractionFailure$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeApplicationInteractions.handleInteractionFailure(applicationCommandLocalSendData, l);
    }

    @StoreThread
    private final void handleSendApplicationCommandRequest(ApplicationCommandLocalSendData localSendData, List<? extends Attachment<?>> attachments, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail) {
        upsertApplicationCommandSendData(localSendData);
        ObservableExtensionsKt.appSubscribe$default(sendApplicationCommandObservable(localSendData, attachments), StoreApplicationInteractions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreApplicationInteractions$handleSendApplicationCommandRequest$1(this, localSendData, onSuccess, onFail), 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleSendApplicationCommandRequest$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        storeApplicationInteractions.handleSendApplicationCommandRequest(applicationCommandLocalSendData, list, function0, function1);
    }

    @StoreThread
    private final void loadCachedApplicationCommandSendDataSet() {
        Map<String, ApplicationCommandLocalSendData> linkedHashMap;
        try {
            String string = this.sharedPrefs.getString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, null);
            if (string == null || t.isBlank(string)) {
                linkedHashMap = new LinkedHashMap<>();
            } else {
                Object objG = this.gson.g(string, new StoreApplicationInteractions$loadCachedApplicationCommandSendDataSet$type$1().getType());
                m.checkNotNullExpressionValue(objG, "gson.fromJson(cachedDataSet, type)");
                linkedHashMap = (Map) objG;
            }
            this.applicationCommandLocalSendDataSet = linkedHashMap;
        } catch (Exception e) {
            clearCache();
            this.applicationCommandLocalSendDataSet.clear();
            Logger.e$default(AppLog.g, "Error restoring cached command send data", e, null, 4, null);
        }
        markChanged();
    }

    @StoreThread
    private final void markAllLocalApplicationCommandRequestsAsFailed() {
        for (ApplicationCommandLocalSendData applicationCommandLocalSendData : this.applicationCommandLocalSendDataSet.values()) {
            this.storeStream.handleInteractionFailure(new InteractionStateUpdate(applicationCommandLocalSendData.getInteractionId(), applicationCommandLocalSendData.getNonceString()));
        }
    }

    @StoreThread
    private final void removeApplicationCommandSendData(String nonce) {
        if (this.applicationCommandLocalSendDataSet.remove(nonce) != null) {
            markChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendApplicationCommand$default(StoreApplicationInteractions storeApplicationInteractions, long j, Long l, String str, com.discord.widgets.chat.input.models.ApplicationCommandData applicationCommandData, List list, Function0 function0, Function1 function1, int i, Object obj) {
        storeApplicationInteractions.sendApplicationCommand(j, l, str, applicationCommandData, (i & 16) != 0 ? null : list, function0, function1);
    }

    private final Observable<MessageResult> sendApplicationCommandObservable(ApplicationCommandLocalSendData localSendData, List<? extends Attachment<?>> attachments) {
        Message messageBuildApplicationCommandLocalMessage$default = buildApplicationCommandLocalMessage$default(this, localSendData, false, false, 6, null);
        this.sentInteractions.put(localSendData.getNonceString(), new StoreApplicationInteractions$SentInteraction(localSendData.getChannelId(), null, localSendData.getGuildId(), null, 8, null));
        return this.storeMessages.sendMessage(messageBuildApplicationCommandLocalMessage$default, localSendData, attachments);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable sendApplicationCommandObservable$default(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return storeApplicationInteractions.sendApplicationCommandObservable(applicationCommandLocalSendData, list);
    }

    private final User toUser(Application application) {
        User bot = application.getBot();
        if (bot != null) {
            return bot;
        }
        long id2 = application.getId();
        String name = application.getName();
        String icon = application.getIcon();
        return new User(id2, name, icon != null ? new NullSerializable$b(icon) : new NullSerializable$a(null, 1), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194296);
    }

    @StoreThread
    private final void upsertApplicationCommandSendData(ApplicationCommandLocalSendData localSendData) {
        this.applicationCommandLocalSendDataSet.put(localSendData.getNonceString(), localSendData);
        markChanged();
    }

    public final void fetchInteractionDataIfNonExisting(long interactionId, long channelId, long messageId, String messageNonce) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        StoreApplicationInteractions$State storeApplicationInteractions$State = this.interactionData.get(Long.valueOf(interactionId));
        if ((storeApplicationInteractions$State instanceof StoreApplicationInteractions$State$Fetching) || (storeApplicationInteractions$State instanceof StoreApplicationInteractions$State$Loaded)) {
            return;
        }
        if (!(messageNonce == null || t.isBlank(messageNonce)) && this.applicationCommandLocalSendDataSnapshot.containsKey(messageNonce) && (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSnapshot.get(messageNonce)) != null) {
            this.dispatcher.schedule(new StoreApplicationInteractions$fetchInteractionDataIfNonExisting$$inlined$let$lambda$1(applicationCommandLocalSendData, this, interactionId));
        } else {
            this.dispatcher.schedule(new StoreApplicationInteractions$fetchInteractionDataIfNonExisting$2(this, interactionId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getInteractionData(channelId, messageId), false, 1, null), StoreApplicationInteractions.class, (Context) null, (Function1) null, new StoreApplicationInteractions$fetchInteractionDataIfNonExisting$4(this, interactionId), (Function0) null, (Function0) null, new StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3(this, interactionId), 54, (Object) null);
        }
    }

    public final Map<String, ApplicationCommandLocalSendData> getApplicationCommandLocalSendDataSet$app_productionGoogleRelease() {
        return this.applicationCommandLocalSendDataSet;
    }

    public final Map<Long, Map<Integer, StoreApplicationInteractions$InteractionSendState>> getComponentInteractionData() {
        return this.interactionComponentSendStateSnapshot;
    }

    public final Map<String, StoreApplicationInteractions$ComponentLocation> getComponentInteractions() {
        return this.componentInteractions;
    }

    public final Map<Long, Map<Integer, StoreApplicationInteractions$InteractionSendState>> getInteractionComponentSendState() {
        return this.interactionComponentSendState;
    }

    public final Map<Long, Map<Integer, StoreApplicationInteractions$InteractionSendState>> getInteractionComponentSendStateSnapshot() {
        return this.interactionComponentSendStateSnapshot;
    }

    public final StoreApplicationInteractions$State getInteractionData(long interactionId) {
        return this.interactionDataSnapshot.get(Long.valueOf(interactionId));
    }

    public final LruCache<String, StoreApplicationInteractions$SentInteraction> getSentInteractions$app_productionGoogleRelease() {
        return this.sentInteractions;
    }

    @StoreThread
    public final void handleChannelSelected() {
        clearComponentInteractionSendSuccessAndFailures();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
    }

    @StoreThread
    public final void handleConnectionReady(boolean connectionReady) {
        if (connectionReady) {
            markAllLocalApplicationCommandRequestsAsFailed();
        }
    }

    @StoreThread
    public final void handleInteractionCreate(InteractionStateUpdate interactionStateUpdate) {
        m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(interactionStateUpdate.getNonce());
        if (applicationCommandLocalSendData != null) {
            handleApplicationCommandRequestStateUpdate(applicationCommandLocalSendData, interactionStateUpdate.getId());
        }
    }

    @StoreThread
    public final void handleInteractionFailure(InteractionStateUpdate interactionStateUpdate) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        StoreApplicationInteractions$SentInteraction storeApplicationInteractions$SentInteraction = this.sentInteractions.get(interactionStateUpdate.getNonce());
        if (storeApplicationInteractions$SentInteraction != null) {
            storeApplicationInteractions$SentInteraction.setState(StoreApplicationInteractions$SentInteractionState.FAILURE);
            markChanged(SentInteractionsUpdate);
        }
        if (!this.componentInteractions.containsKey(interactionStateUpdate.getNonce())) {
            if (!this.applicationCommandLocalSendDataSet.containsKey(interactionStateUpdate.getNonce()) || (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(interactionStateUpdate.getNonce())) == null) {
                return;
            }
            handleInteractionFailure(applicationCommandLocalSendData, interactionStateUpdate.getId());
            return;
        }
        StoreApplicationInteractions$ComponentLocation storeApplicationInteractions$ComponentLocation = this.componentInteractions.get(interactionStateUpdate.getNonce());
        if (storeApplicationInteractions$ComponentLocation != null) {
            this.storeLocalActionComponentState.clearState(storeApplicationInteractions$ComponentLocation.getMessageId(), Integer.valueOf(storeApplicationInteractions$ComponentLocation.getComponentIndex()));
            this.componentInteractions.remove(interactionStateUpdate.getNonce());
            addInteractionStateToComponent(storeApplicationInteractions$ComponentLocation.getMessageId(), storeApplicationInteractions$ComponentLocation.getComponentIndex(), new StoreApplicationInteractions$InteractionSendState$Failed(null, 1, null));
        }
    }

    @StoreThread
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        m.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        this.interactionModalCreate.k.onNext(interactionModalCreate);
    }

    @StoreThread
    public final void handleInteractionSuccess(InteractionStateUpdate interactionStateUpdate) {
        StoreApplicationInteractions$ComponentLocation storeApplicationInteractions$ComponentLocation;
        m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        StoreApplicationInteractions$SentInteraction storeApplicationInteractions$SentInteraction = this.sentInteractions.get(interactionStateUpdate.getNonce());
        if (storeApplicationInteractions$SentInteraction != null) {
            storeApplicationInteractions$SentInteraction.setState(StoreApplicationInteractions$SentInteractionState.SUCCESS);
            markChanged(SentInteractionsUpdate);
        }
        if (!this.componentInteractions.containsKey(interactionStateUpdate.getNonce()) || (storeApplicationInteractions$ComponentLocation = this.componentInteractions.get(interactionStateUpdate.getNonce())) == null) {
            return;
        }
        this.interactionComponentSendState.remove(Long.valueOf(storeApplicationInteractions$ComponentLocation.getMessageId()));
        this.componentInteractions.remove(interactionStateUpdate.getNonce());
        markChanged(ComponentStateUpdate);
    }

    @StoreThread
    public final void handleLocalMessageDelete(Message message) {
        m.checkNotNullParameter(message, "message");
        String nonce = message.getNonce();
        if (nonce != null) {
            removeApplicationCommandSendData(nonce);
        }
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        handleMessagesCreateOrLoad(d0.t.m.listOf(new Message(message)));
    }

    @StoreThread
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        boolean z2;
        m.checkNotNullParameter(message, "message");
        Map<String, StoreApplicationInteractions$ComponentLocation> map = this.componentInteractions;
        if (map.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator<Map$Entry<String, StoreApplicationInteractions$ComponentLocation>> it = map.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getValue().getMessageId() == message.getId()) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (z2) {
            this.storeLocalActionComponentState.clearState(message.getId(), null);
            Map<String, StoreApplicationInteractions$ComponentLocation> map2 = this.componentInteractions;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map$Entry<String, StoreApplicationInteractions$ComponentLocation> map$Entry : map2.entrySet()) {
                if (map$Entry.getValue().getMessageId() == message.getId()) {
                    linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
                }
            }
            Iterator it2 = linkedHashMap.keySet().iterator();
            while (it2.hasNext()) {
                this.componentInteractions.remove((String) it2.next());
            }
            markChanged(ComponentStateUpdate);
        }
        if (this.interactionComponentSendState.containsKey(Long.valueOf(message.getId()))) {
            this.interactionComponentSendState.remove(Long.valueOf(message.getId()));
            markChanged(ComponentStateUpdate);
        }
    }

    @StoreThread
    public final void handleMessagesCreateOrLoad(List<Message> messagesList) {
        m.checkNotNullParameter(messagesList, "messagesList");
        for (Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce == null || !this.componentInteractions.containsKey(nonce)) {
                Interaction interaction = message.getInteraction();
                ApplicationCommandLocalSendData applicationCommandLocalSendData = null;
                Object obj = null;
                Long id2 = interaction != null ? interaction.getId() : null;
                if (!(nonce == null || t.isBlank(nonce)) && this.applicationCommandLocalSendDataSet.containsKey(nonce)) {
                    applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(nonce);
                } else if (id2 != null) {
                    for (Object obj2 : this.applicationCommandLocalSendDataSet.values()) {
                        if (m.areEqual(((ApplicationCommandLocalSendData) obj2).getInteractionId(), id2)) {
                            obj = obj2;
                            break;
                        }
                    }
                    applicationCommandLocalSendData = (ApplicationCommandLocalSendData) obj;
                }
                if (applicationCommandLocalSendData != null) {
                    removeApplicationCommandSendData(applicationCommandLocalSendData.getNonceString());
                    this.storeMessages.deleteLocalMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString());
                }
            } else {
                StoreApplicationInteractions$ComponentLocation storeApplicationInteractions$ComponentLocation = this.componentInteractions.get(nonce);
                if (storeApplicationInteractions$ComponentLocation == null) {
                    return;
                }
                handleComponentInteractionMessage(storeApplicationInteractions$ComponentLocation);
                this.componentInteractions.remove(nonce);
            }
        }
    }

    @StoreThread
    public final void handlePreLogout() {
        this.applicationCommandLocalSendDataSet.clear();
        markChanged();
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        loadCachedApplicationCommandSendDataSet();
    }

    public final Observable<Map<Long, Map<Integer, StoreApplicationInteractions$InteractionSendState>>> observeComponentInteractionState() {
        Observable<Map<Long, Map<Integer, StoreApplicationInteractions$InteractionSendState>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{ComponentStateUpdate}, false, null, null, new StoreApplicationInteractions$observeComponentInteractionState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreApplicationInteractions$State> observeInteractionData(long interactionId) {
        Observable<StoreApplicationInteractions$State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationInteractions$observeInteractionData$1(this, interactionId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<InteractionModalCreate> observeModalCreate() {
        PublishSubject<InteractionModalCreate> publishSubject = this.interactionModalCreate;
        m.checkNotNullExpressionValue(publishSubject, "interactionModalCreate");
        return publishSubject;
    }

    public final Observable<Map<String, StoreApplicationInteractions$SentInteraction>> observeSentInteractions() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{SentInteractionsUpdate}, false, null, null, new StoreApplicationInteractions$observeSentInteractions$1(this), 14, null);
    }

    public final void resendApplicationCommand(Message message) {
        String nonce;
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        m.checkNotNullParameter(message, "message");
        Integer type = message.getType();
        if (type == null || type.intValue() != -4 || (nonce = message.getNonce()) == null || (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSnapshot.get(nonce)) == null) {
            return;
        }
        this.dispatcher.schedule(new StoreApplicationInteractions$resendApplicationCommand$1(this, message, nonce, ApplicationCommandLocalSendData.copy$default(applicationCommandLocalSendData, NonceGenerator$Companion.computeNonce$default(NonceGenerator.Companion, null, 1, null), 0L, null, null, null, null, null, null, null, null, null, 1022, null)));
    }

    public final void sendApplicationCommand(long channelId, Long guildId, String version, com.discord.widgets.chat.input.models.ApplicationCommandData data, List<? extends Attachment<?>> attachments, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFail, "onFail");
        this.dispatcher.schedule(new StoreApplicationInteractions$sendApplicationCommand$1(this, new ApplicationCommandLocalSendData(this.nonceGenerator.nonce(), channelId, guildId, data.getApplicationCommand().getGuildId(), data.getApplication(), this.sessionId, data.getApplicationCommand().getName(), data.getApplicationCommand().getId(), data.getValues(), version, null, 1024, null), attachments, onSuccess, onFail));
    }

    public final void sendComponentInteraction(long applicationId, Long guildId, long channelId, long messageId, int componentIndex, RestAPIParams$ComponentInteractionData data, Long messageFlags) {
        m.checkNotNullParameter(data, "data");
        this.dispatcher.schedule(new StoreApplicationInteractions$sendComponentInteraction$1(this, messageId, componentIndex, String.valueOf(this.nonceGenerator.nonce()), channelId, guildId, applicationId, messageFlags, data));
    }

    public final void sendModalInteraction(InteractionModalCreate modal, List<Pair<String, String>> components, Function1<? super String, Unit> onNext, Function0<Unit> onError) {
        m.checkNotNullParameter(modal, "modal");
        m.checkNotNullParameter(components, "components");
        m.checkNotNullParameter(onNext, "onNext");
        m.checkNotNullParameter(onError, "onError");
        StoreApplicationInteractions$SentInteraction storeApplicationInteractions$SentInteraction = this.sentInteractions.get(modal.getNonce());
        if (storeApplicationInteractions$SentInteraction != null) {
            m.checkNotNullExpressionValue(storeApplicationInteractions$SentInteraction, "sentInteractions[modal.nonce] ?: return");
            long jNonce = this.nonceGenerator.nonce();
            this.sentInteractions.put(String.valueOf(jNonce), storeApplicationInteractions$SentInteraction);
            this.dispatcher.schedule(new StoreApplicationInteractions$sendModalInteraction$1(this, modal, storeApplicationInteractions$SentInteraction, jNonce, components, onNext, onError));
        }
    }

    public final void setInteractionComponentSendStateSnapshot(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions$InteractionSendState>> map) {
        m.checkNotNullParameter(map, "<set-?>");
        this.interactionComponentSendStateSnapshot = map;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.interactionDataSnapshot = new HashMap(this.interactionData);
        this.interactionComponentSendStateSnapshot = new HashMap(this.interactionComponentSendState);
        Map<String, StoreApplicationInteractions$SentInteraction> mapSnapshot = this.sentInteractions.snapshot();
        m.checkNotNullExpressionValue(mapSnapshot, "sentInteractions.snapshot()");
        this.sentInteractionsSnapshot = mapSnapshot;
        HashMap map = new HashMap(this.applicationCommandLocalSendDataSet);
        this.applicationCommandLocalSendDataSnapshot = map;
        String strM = this.gson.m(map);
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.sharedPrefs.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, strM);
        sharedPreferences$EditorEdit.apply();
    }

    public StoreApplicationInteractions(StoreStream storeStream, Dispatcher dispatcher, StoreMessages storeMessages, StoreLocalActionComponentState storeLocalActionComponentState, StoreUser storeUser, Clock clock, SharedPreferences sharedPreferences, ObservationDeck observationDeck, RestAPI restAPI, NonceGenerator nonceGenerator) {
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storeLocalActionComponentState, "storeLocalActionComponentState");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(sharedPreferences, "sharedPrefs");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(nonceGenerator, "nonceGenerator");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.storeMessages = storeMessages;
        this.storeLocalActionComponentState = storeLocalActionComponentState;
        this.storeUser = storeUser;
        this.clock = clock;
        this.sharedPrefs = sharedPreferences;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.nonceGenerator = nonceGenerator;
        this.componentInteractions = new LinkedHashMap();
        this.interactionComponentSendState = new LinkedHashMap();
        this.interactionComponentSendStateSnapshot = h0.emptyMap();
        this.applicationCommandLocalSendDataSnapshot = new LinkedHashMap();
        this.applicationCommandLocalSendDataSet = new LinkedHashMap();
        this.interactionDataSnapshot = h0.emptyMap();
        this.interactionData = new HashMap<>();
        this.sentInteractions = new LruCache<>(5);
        this.sentInteractionsSnapshot = h0.emptyMap();
        e eVar = new e();
        a.a(eVar);
        this.gson = eVar.a();
        this.interactionModalCreate = PublishSubject.k0();
    }

    @StoreThread
    private final void handleInteractionFailure(ApplicationCommandLocalSendData localSendData, Long interactionId) {
        handleApplicationCommandRequestStateUpdate(localSendData, interactionId);
    }
}
