package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.collection.LruCache;
import com.discord.api.botuikit.ComponentType;
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
import com.discord.models.message.Message;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreatorsKt;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p017b.C0850a;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.C4901e;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions extends StoreV2 {
    private static final String CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET = "CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource ComponentStateUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreApplicationInteractions$Companion$ComponentStateUpdate$1
    };
    private static final ObservationDeck.UpdateSource SentInteractionsUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreApplicationInteractions$Companion$SentInteractionsUpdate$1
    };
    public static final long TYPE_COMPONENT_INTERACTION = 3;
    public static final long TYPE_MODAL_INTERACTION = 5;
    private Map<String, ApplicationCommandLocalSendData> applicationCommandLocalSendDataSet;
    private Map<String, ApplicationCommandLocalSendData> applicationCommandLocalSendDataSnapshot;
    private final Clock clock;
    private final Map<String, ComponentLocation> componentInteractions;
    private final Dispatcher dispatcher;
    private final Gson gson;
    private final Map<Long, Map<Integer, InteractionSendState>> interactionComponentSendState;
    private Map<Long, ? extends Map<Integer, ? extends InteractionSendState>> interactionComponentSendStateSnapshot;
    private final HashMap<Long, State> interactionData;
    private Map<Long, ? extends State> interactionDataSnapshot;
    private final PublishSubject<InteractionModalCreate> interactionModalCreate;
    private final NonceGenerator nonceGenerator;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final LruCache<String, SentInteraction> sentInteractions;
    private Map<String, SentInteraction> sentInteractionsSnapshot;
    private String sessionId;
    private final SharedPreferences sharedPrefs;
    private final StoreLocalActionComponentState storeLocalActionComponentState;
    private final StoreMessages storeMessages;
    private final StoreStream storeStream;
    private final StoreUser storeUser;

    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ObservationDeck.UpdateSource getComponentStateUpdate() {
            return StoreApplicationInteractions.ComponentStateUpdate;
        }

        public final ObservationDeck.UpdateSource getSentInteractionsUpdate() {
            return StoreApplicationInteractions.SentInteractionsUpdate;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final /* data */ class ComponentLocation {
        private final int componentIndex;
        private final long messageId;

        public ComponentLocation(long j, int i) {
            this.messageId = j;
            this.componentIndex = i;
        }

        public static /* synthetic */ ComponentLocation copy$default(ComponentLocation componentLocation, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = componentLocation.messageId;
            }
            if ((i2 & 2) != 0) {
                i = componentLocation.componentIndex;
            }
            return componentLocation.copy(j, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getComponentIndex() {
            return this.componentIndex;
        }

        public final ComponentLocation copy(long messageId, int componentIndex) {
            return new ComponentLocation(messageId, componentIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ComponentLocation)) {
                return false;
            }
            ComponentLocation componentLocation = (ComponentLocation) other;
            return this.messageId == componentLocation.messageId && this.componentIndex == componentLocation.componentIndex;
        }

        public final int getComponentIndex() {
            return this.componentIndex;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public int hashCode() {
            return (C0002b.m3a(this.messageId) * 31) + this.componentIndex;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ComponentLocation(messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", componentIndex=");
            return C1643a.m814B(sbM833U, this.componentIndex, ")");
        }
    }

    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static abstract class InteractionSendState {

        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class Failed extends InteractionSendState {
            private final String errorMessage;

            /* JADX WARN: Multi-variable type inference failed */
            public Failed() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class Loading extends InteractionSendState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class Success extends InteractionSendState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private InteractionSendState() {
        }

        public /* synthetic */ InteractionSendState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final /* data */ class SentInteraction {
        private final long channelId;
        private final Long guildId;
        private final Long messageId;
        private SentInteractionState state;

        public SentInteraction(long j, Long l, Long l2, SentInteractionState sentInteractionState) {
            C12238m.checkNotNullParameter(sentInteractionState, "state");
            this.channelId = j;
            this.messageId = l;
            this.guildId = l2;
            this.state = sentInteractionState;
        }

        public static /* synthetic */ SentInteraction copy$default(SentInteraction sentInteraction, long j, Long l, Long l2, SentInteractionState sentInteractionState, int i, Object obj) {
            if ((i & 1) != 0) {
                j = sentInteraction.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                l = sentInteraction.messageId;
            }
            Long l3 = l;
            if ((i & 4) != 0) {
                l2 = sentInteraction.guildId;
            }
            Long l4 = l2;
            if ((i & 8) != 0) {
                sentInteractionState = sentInteraction.state;
            }
            return sentInteraction.copy(j2, l3, l4, sentInteractionState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final SentInteractionState getState() {
            return this.state;
        }

        public final SentInteraction copy(long channelId, Long messageId, Long guildId, SentInteractionState state) {
            C12238m.checkNotNullParameter(state, "state");
            return new SentInteraction(channelId, messageId, guildId, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SentInteraction)) {
                return false;
            }
            SentInteraction sentInteraction = (SentInteraction) other;
            return this.channelId == sentInteraction.channelId && C12238m.areEqual(this.messageId, sentInteraction.messageId) && C12238m.areEqual(this.guildId, sentInteraction.guildId) && C12238m.areEqual(this.state, sentInteraction.state);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Long getMessageId() {
            return this.messageId;
        }

        public final SentInteractionState getState() {
            return this.state;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.channelId) * 31;
            Long l = this.messageId;
            int iHashCode = (iM3a + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.guildId;
            int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
            SentInteractionState sentInteractionState = this.state;
            return iHashCode2 + (sentInteractionState != null ? sentInteractionState.hashCode() : 0);
        }

        public final void setState(SentInteractionState sentInteractionState) {
            C12238m.checkNotNullParameter(sentInteractionState, "<set-?>");
            this.state = sentInteractionState;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SentInteraction(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", state=");
            sbM833U.append(this.state);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ SentInteraction(long j, Long l, Long l2, SentInteractionState sentInteractionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, l, l2, (i & 8) != 0 ? SentInteractionState.SENDING : sentInteractionState);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public enum SentInteractionState {
        SENDING,
        FAILURE,
        SUCCESS
    }

    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final /* data */ class Loaded extends State {
            private final ApplicationCommandData commandOptions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ApplicationCommandData applicationCommandData) {
                super(null);
                C12238m.checkNotNullParameter(applicationCommandData, "commandOptions");
                this.commandOptions = applicationCommandData;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ApplicationCommandData applicationCommandData, int i, Object obj) {
                if ((i & 1) != 0) {
                    applicationCommandData = loaded.commandOptions;
                }
                return loaded.copy(applicationCommandData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ApplicationCommandData getCommandOptions() {
                return this.commandOptions;
            }

            public final Loaded copy(ApplicationCommandData commandOptions) {
                C12238m.checkNotNullParameter(commandOptions, "commandOptions");
                return new Loaded(commandOptions);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.commandOptions, ((Loaded) other).commandOptions);
                }
                return true;
            }

            public final ApplicationCommandData getCommandOptions() {
                return this.commandOptions;
            }

            public int hashCode() {
                ApplicationCommandData applicationCommandData = this.commandOptions;
                if (applicationCommandData != null) {
                    return applicationCommandData.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(commandOptions=");
                sbM833U.append(this.commandOptions);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$clearComponentInteractionSendSuccessAndFailures$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57211 extends AbstractC12240o implements Function0<Unit> {
        public C57211() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator<T> it = StoreApplicationInteractions.this.getInteractionComponentSendState().keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                Map<Integer, InteractionSendState> map = StoreApplicationInteractions.this.getInteractionComponentSendState().get(Long.valueOf(jLongValue));
                if (map != null) {
                    linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Integer, InteractionSendState> entry : map.entrySet()) {
                        if (entry.getValue() instanceof InteractionSendState.Loading) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    linkedHashMap = null;
                }
                if (linkedHashMap != null) {
                    linkedHashMap2.put(Long.valueOf(jLongValue), linkedHashMap);
                }
            }
            StoreApplicationInteractions.this.getInteractionComponentSendState().clear();
            StoreApplicationInteractions.this.getInteractionComponentSendState().putAll(linkedHashMap2);
            StoreApplicationInteractions.this.markChanged(StoreApplicationInteractions.INSTANCE.getComponentStateUpdate());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$2 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57232 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $interactionId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57232(long j) {
            super(0);
            this.$interactionId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationInteractions.this.handleInteractionDataFetchStart(this.$interactionId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57243 extends AbstractC12240o implements Function1<ApplicationCommandData, Unit> {
        public final /* synthetic */ long $interactionId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ ApplicationCommandData $interactionDetail;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ApplicationCommandData applicationCommandData) {
                super(0);
                this.$interactionDetail = applicationCommandData;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57243 c57243 = C57243.this;
                StoreApplicationInteractions.this.handleInteractionDataFetchSuccess(c57243.$interactionId, this.$interactionDetail);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57243(long j) {
            super(1);
            this.$interactionId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandData applicationCommandData) {
            invoke2(applicationCommandData);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandData applicationCommandData) {
            C12238m.checkNotNullParameter(applicationCommandData, "interactionDetail");
            StoreApplicationInteractions.this.dispatcher.schedule(new AnonymousClass1(applicationCommandData));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$4 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57254 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ long $interactionId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57254 c57254 = C57254.this;
                StoreApplicationInteractions.this.handleInteractionDataFetchFailure(c57254.$interactionId);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57254(long j) {
            super(1);
            this.$interactionId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreApplicationInteractions.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$handleSendApplicationCommandRequest$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57261 extends AbstractC12240o implements Function1<MessageResult, Unit> {
        public final /* synthetic */ ApplicationCommandLocalSendData $localSendData;
        public final /* synthetic */ Function1 $onFail;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$handleSendApplicationCommandRequest$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ MessageResult $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MessageResult messageResult) {
                super(0);
                this.$result = messageResult;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57261 c57261 = C57261.this;
                StoreApplicationInteractions.this.handleApplicationCommandResult(this.$result, c57261.$localSendData, c57261.$onSuccess, c57261.$onFail);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57261(ApplicationCommandLocalSendData applicationCommandLocalSendData, Function0 function0, Function1 function1) {
            super(1);
            this.$localSendData = applicationCommandLocalSendData;
            this.$onSuccess = function0;
            this.$onFail = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
            invoke2(messageResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageResult messageResult) {
            C12238m.checkNotNullParameter(messageResult, "result");
            StoreApplicationInteractions.this.dispatcher.schedule(new AnonymousClass1(messageResult));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$observeComponentInteractionState$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57281 extends AbstractC12240o implements Function0<Map<Long, ? extends Map<Integer, ? extends InteractionSendState>>> {
        public C57281() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Integer, ? extends InteractionSendState>> invoke() {
            return StoreApplicationInteractions.this.getComponentInteractionData();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$observeInteractionData$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57291 extends AbstractC12240o implements Function0<State> {
        public final /* synthetic */ long $interactionId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57291(long j) {
            super(0);
            this.$interactionId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreApplicationInteractions.this.getInteractionData(this.$interactionId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$observeSentInteractions$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57301 extends AbstractC12240o implements Function0<Map<String, ? extends SentInteraction>> {
        public C57301() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends SentInteraction> invoke() {
            return StoreApplicationInteractions.this.sentInteractionsSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$resendApplicationCommand$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57311 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Message $message;
        public final /* synthetic */ String $nonce;
        public final /* synthetic */ ApplicationCommandLocalSendData $updatedSendData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57311(Message message, String str, ApplicationCommandLocalSendData applicationCommandLocalSendData) {
            super(0);
            this.$message = message;
            this.$nonce = str;
            this.$updatedSendData = applicationCommandLocalSendData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationInteractions.this.storeMessages.deleteLocalMessage(this.$message.getChannelId(), this.$nonce);
            StoreApplicationInteractions.handleSendApplicationCommandRequest$default(StoreApplicationInteractions.this, this.$updatedSendData, null, null, null, 14, null);
            StoreApplicationInteractions.this.removeApplicationCommandSendData(this.$nonce);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendApplicationCommand$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57321 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $attachments;
        public final /* synthetic */ ApplicationCommandLocalSendData $localSendData;
        public final /* synthetic */ Function1 $onFail;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57321(ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, Function0 function0, Function1 function1) {
            super(0);
            this.$localSendData = applicationCommandLocalSendData;
            this.$attachments = list;
            this.$onSuccess = function0;
            this.$onFail = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationInteractions.this.handleSendApplicationCommandRequest(this.$localSendData, this.$attachments, this.$onSuccess, this.$onFail);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57331 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $applicationId;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ int $componentIndex;
        public final /* synthetic */ RestAPIParams.ComponentInteractionData $data;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ Long $messageFlags;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ String $nonce;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Void, Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class AnonymousClass4 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendComponentInteraction$1$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ Error $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(Error error) {
                    super(0);
                    this.$it = error;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreLocalActionComponentState storeLocalActionComponentState = StoreApplicationInteractions.this.storeLocalActionComponentState;
                    C57331 c57331 = C57331.this;
                    storeLocalActionComponentState.clearState(c57331.$messageId, Integer.valueOf(c57331.$componentIndex));
                    StoreApplicationInteractions.this.getComponentInteractions().remove(C57331.this.$nonce);
                    C57331 c57332 = C57331.this;
                    StoreApplicationInteractions storeApplicationInteractions = StoreApplicationInteractions.this;
                    long j = c57332.$messageId;
                    int i = c57332.$componentIndex;
                    Error.Response response = this.$it.getResponse();
                    C12238m.checkNotNullExpressionValue(response, "it.response");
                    storeApplicationInteractions.addInteractionStateToComponent(j, i, new InteractionSendState.Failed(response.getMessage()));
                }
            }

            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "it");
                StoreApplicationInteractions.this.dispatcher.schedule(new AnonymousClass1(error));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57331(long j, int i, String str, long j2, Long l, long j3, Long l2, RestAPIParams.ComponentInteractionData componentInteractionData) {
            super(0);
            this.$messageId = j;
            this.$componentIndex = i;
            this.$nonce = str;
            this.$channelId = j2;
            this.$guildId = l;
            this.$applicationId = j3;
            this.$messageFlags = l2;
            this.$data = componentInteractionData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            boolean z2;
            boolean z3;
            Collection<ComponentLocation> collectionValues = StoreApplicationInteractions.this.getComponentInteractions().values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else {
                        if (((ComponentLocation) it.next()).getMessageId() == this.$messageId) {
                            z2 = true;
                            break;
                        }
                    }
                }
            } else {
                z2 = false;
                break;
            }
            if (!z2) {
                StoreApplicationInteractions.this.getComponentInteractions().put(this.$nonce, new ComponentLocation(this.$messageId, this.$componentIndex));
                StoreApplicationInteractions.this.addInteractionStateToComponent(this.$messageId, this.$componentIndex, InteractionSendState.Loading.INSTANCE);
                StoreApplicationInteractions.this.getSentInteractions$app_productionGoogleRelease().put(this.$nonce, new SentInteraction(this.$channelId, Long.valueOf(this.$messageId), this.$guildId, null, 8, null));
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationInteractions.this.restAPI.sendComponentInteraction(new RestAPIParams.ComponentInteraction(3L, this.$channelId, this.$applicationId, this.$guildId, this.$messageId, this.$messageFlags, this.$data, StoreApplicationInteractions.this.sessionId, this.$nonce)), false, 1, null), (Class<?>) StoreApplicationInteractions.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass4()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), AnonymousClass3.INSTANCE);
                return;
            }
            Collection<ComponentLocation> collectionValues2 = StoreApplicationInteractions.this.getComponentInteractions().values();
            if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
                Iterator<T> it2 = collectionValues2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z3 = true;
                        break;
                    }
                    ComponentLocation componentLocation = (ComponentLocation) it2.next();
                    if (!(componentLocation.getMessageId() == this.$messageId && componentLocation.getComponentIndex() != this.$componentIndex)) {
                        z3 = false;
                        break;
                    }
                }
            } else {
                z3 = true;
                break;
            }
            if (z3) {
                StoreApplicationInteractions.this.storeLocalActionComponentState.clearState(this.$messageId, Integer.valueOf(this.$componentIndex));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendModalInteraction$1 */
    /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
    public static final class C57341 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $components;
        public final /* synthetic */ SentInteraction $localSendData;
        public final /* synthetic */ InteractionModalCreate $modal;
        public final /* synthetic */ long $nonce;
        public final /* synthetic */ Function0 $onError;
        public final /* synthetic */ Function1 $onNext;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendModalInteraction$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Void, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r4) {
                C57341 c57341 = C57341.this;
                c57341.$onNext.invoke(String.valueOf(c57341.$nonce));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$sendModalInteraction$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationInteractions.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Error, Unit> {
            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "it");
                C57341.this.$onError.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57341(InteractionModalCreate interactionModalCreate, SentInteraction sentInteraction, long j, List list, Function1 function1, Function0 function0) {
            super(0);
            this.$modal = interactionModalCreate;
            this.$localSendData = sentInteraction;
            this.$nonce = j;
            this.$components = list;
            this.$onNext = function1;
            this.$onError = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RestAPI restAPI = StoreApplicationInteractions.this.restAPI;
            long id2 = this.$modal.getApplication().getId();
            long channelId = this.$localSendData.getChannelId();
            Long guildId = this.$localSendData.getGuildId();
            long j = this.$nonce;
            String str = StoreApplicationInteractions.this.sessionId;
            long id3 = this.$modal.getId();
            String customId = this.$modal.getCustomId();
            List list = this.$components;
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                arrayList.add(new RestAPIParams.ModalInteractionDataComponent(ComponentType.ACTION_ROW, C12145m.listOf(new RestAPIParams.ModalInteractionDataComponent(ComponentType.TEXT, null, (String) pair.getFirst(), (String) pair.getSecond())), null, null));
                it = it;
                restAPI = restAPI;
                j = j;
                str = str;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(restAPI.sendModalInteraction(new RestAPIParams.ModalInteraction(5L, id2, null, channelId, guildId, str, j, new RestAPIParams.ModalInteractionData(id3, customId, arrayList))), false, 1, null), (Class<?>) StoreApplicationInteractions.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2());
        }
    }

    public /* synthetic */ StoreApplicationInteractions(StoreStream storeStream, Dispatcher dispatcher, StoreMessages storeMessages, StoreLocalActionComponentState storeLocalActionComponentState, StoreUser storeUser, Clock clock, SharedPreferences sharedPreferences, ObservationDeck observationDeck, RestAPI restAPI, NonceGenerator nonceGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeMessages, storeLocalActionComponentState, storeUser, clock, (i & 64) != 0 ? SharedPreferencesProvider.INSTANCE.get() : sharedPreferences, (i & 128) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 256) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 512) != 0 ? new NonceGenerator() : nonceGenerator);
    }

    @StoreThread
    private final void addInteractionStateToComponent(long messageId, int componentIndex, InteractionSendState sendState) {
        this.interactionComponentSendState.put(Long.valueOf(messageId), C12134g0.mapOf(C12116o.m10073to(Integer.valueOf(componentIndex), sendState)));
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
        SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, null);
        editorEdit.apply();
        this.applicationCommandLocalSendDataSet.clear();
        markChanged();
    }

    private final void clearComponentInteractionSendSuccessAndFailures() {
        this.dispatcher.schedule(new C57211());
    }

    @StoreThread
    private final void handleApplicationCommandRequestStateUpdate(ApplicationCommandLocalSendData localSendData, Long interactionId) {
        upsertApplicationCommandSendData(localSendData.copy((1791 & 1) != 0 ? localSendData.nonce : 0L, (1791 & 2) != 0 ? localSendData.channelId : 0L, (1791 & 4) != 0 ? localSendData.guildId : null, (1791 & 8) != 0 ? localSendData.commandGuildId : null, (1791 & 16) != 0 ? localSendData.application : null, (1791 & 32) != 0 ? localSendData.sessionId : null, (1791 & 64) != 0 ? localSendData.applicationCommandName : null, (1791 & 128) != 0 ? localSendData.applicationCommandId : null, (1791 & 256) != 0 ? localSendData.applicationCommandsValues : null, (1791 & 512) != 0 ? localSendData.version : null, (1791 & 1024) != 0 ? localSendData.interactionId : interactionId));
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
        if (result instanceof MessageResult.Success) {
            if (onSuccess != null) {
                onSuccess.invoke();
            }
            if (z2) {
                handleApplicationCommandRequestStateUpdate$default(this, localSendData, null, 2, null);
                return;
            }
            return;
        }
        if (!(result instanceof MessageResult.UnknownFailure)) {
            if (z2) {
                this.storeStream.handleInteractionFailure(new InteractionStateUpdate(localSendData.getInteractionId(), localSendData.getNonceString()));
            }
        } else {
            if (onFail != null) {
                onFail.invoke(((MessageResult.UnknownFailure) result).getError());
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

    private final void handleComponentInteractionMessage(ComponentLocation componentLocation) {
        addInteractionStateToComponent(componentLocation.getMessageId(), componentLocation.getComponentIndex(), InteractionSendState.Success.INSTANCE);
    }

    @StoreThread
    private final void handleInteractionDataFetchFailure(long interactionId) {
        this.interactionData.put(Long.valueOf(interactionId), State.Failure.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleInteractionDataFetchStart(long interactionId) {
        this.interactionData.put(Long.valueOf(interactionId), State.Fetching.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleInteractionDataFetchSuccess(long interactionId, ApplicationCommandData interactionData) {
        this.interactionData.put(Long.valueOf(interactionId), new State.Loaded(interactionData));
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
        ObservableExtensionsKt.appSubscribe(sendApplicationCommandObservable(localSendData, attachments), (Class<?>) StoreApplicationInteractions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C57261(localSendData, onSuccess, onFail));
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
            if (string == null || C12103t.isBlank(string)) {
                linkedHashMap = new LinkedHashMap<>();
            } else {
                Object objM9203g = this.gson.m9203g(string, new TypeToken<Map<String, ? extends ApplicationCommandLocalSendData>>() { // from class: com.discord.stores.StoreApplicationInteractions$loadCachedApplicationCommandSendDataSet$type$1
                }.getType());
                C12238m.checkNotNullExpressionValue(objM9203g, "gson.fromJson(cachedDataSet, type)");
                linkedHashMap = (Map) objM9203g;
            }
            this.applicationCommandLocalSendDataSet = linkedHashMap;
        } catch (Exception e) {
            clearCache();
            this.applicationCommandLocalSendDataSet.clear();
            Logger.e$default(AppLog.f14950g, "Error restoring cached command send data", e, null, 4, null);
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

    private final Observable<MessageResult> sendApplicationCommandObservable(ApplicationCommandLocalSendData localSendData, List<? extends Attachment<?>> attachments) {
        Message messageBuildApplicationCommandLocalMessage$default = buildApplicationCommandLocalMessage$default(this, localSendData, false, false, 6, null);
        this.sentInteractions.put(localSendData.getNonceString(), new SentInteraction(localSendData.getChannelId(), null, localSendData.getGuildId(), null, 8, null));
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
        return new User(id2, name, icon != null ? new NullSerializable.C5566b(icon) : new NullSerializable.C5565a(null, 1), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194296);
    }

    @StoreThread
    private final void upsertApplicationCommandSendData(ApplicationCommandLocalSendData localSendData) {
        this.applicationCommandLocalSendDataSet.put(localSendData.getNonceString(), localSendData);
        markChanged();
    }

    public final void fetchInteractionDataIfNonExisting(long interactionId, long channelId, long messageId, String messageNonce) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        State state = this.interactionData.get(Long.valueOf(interactionId));
        if ((state instanceof State.Fetching) || (state instanceof State.Loaded)) {
            return;
        }
        if (!(messageNonce == null || C12103t.isBlank(messageNonce)) && this.applicationCommandLocalSendDataSnapshot.containsKey(messageNonce) && (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSnapshot.get(messageNonce)) != null) {
            this.dispatcher.schedule(new C5722xe7ac5bbb(applicationCommandLocalSendData, this, interactionId));
        } else {
            this.dispatcher.schedule(new C57232(interactionId));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getInteractionData(channelId, messageId), false, 1, null), (Class<?>) StoreApplicationInteractions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C57254(interactionId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C57243(interactionId));
        }
    }

    /* JADX INFO: renamed from: getApplicationCommandLocalSendDataSet$app_productionGoogleRelease */
    public final Map<String, ApplicationCommandLocalSendData> m8506x27c7fac9() {
        return this.applicationCommandLocalSendDataSet;
    }

    public final Map<Long, Map<Integer, InteractionSendState>> getComponentInteractionData() {
        return this.interactionComponentSendStateSnapshot;
    }

    public final Map<String, ComponentLocation> getComponentInteractions() {
        return this.componentInteractions;
    }

    public final Map<Long, Map<Integer, InteractionSendState>> getInteractionComponentSendState() {
        return this.interactionComponentSendState;
    }

    public final Map<Long, Map<Integer, InteractionSendState>> getInteractionComponentSendStateSnapshot() {
        return this.interactionComponentSendStateSnapshot;
    }

    public final State getInteractionData(long interactionId) {
        return this.interactionDataSnapshot.get(Long.valueOf(interactionId));
    }

    public final LruCache<String, SentInteraction> getSentInteractions$app_productionGoogleRelease() {
        return this.sentInteractions;
    }

    @StoreThread
    public final void handleChannelSelected() {
        clearComponentInteractionSendSuccessAndFailures();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
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
        C12238m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(interactionStateUpdate.getNonce());
        if (applicationCommandLocalSendData != null) {
            handleApplicationCommandRequestStateUpdate(applicationCommandLocalSendData, interactionStateUpdate.getId());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @StoreThread
    public final void handleInteractionFailure(InteractionStateUpdate interactionStateUpdate) {
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        C12238m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        SentInteraction sentInteraction = this.sentInteractions.get(interactionStateUpdate.getNonce());
        int i = 1;
        if (sentInteraction != null) {
            sentInteraction.setState(SentInteractionState.FAILURE);
            markChanged(SentInteractionsUpdate);
        }
        if (!this.componentInteractions.containsKey(interactionStateUpdate.getNonce())) {
            if (!this.applicationCommandLocalSendDataSet.containsKey(interactionStateUpdate.getNonce()) || (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(interactionStateUpdate.getNonce())) == null) {
                return;
            }
            handleInteractionFailure(applicationCommandLocalSendData, interactionStateUpdate.getId());
            return;
        }
        ComponentLocation componentLocation = this.componentInteractions.get(interactionStateUpdate.getNonce());
        if (componentLocation != null) {
            this.storeLocalActionComponentState.clearState(componentLocation.getMessageId(), Integer.valueOf(componentLocation.getComponentIndex()));
            this.componentInteractions.remove(interactionStateUpdate.getNonce());
            addInteractionStateToComponent(componentLocation.getMessageId(), componentLocation.getComponentIndex(), new InteractionSendState.Failed(null, i, 0 == true ? 1 : 0));
        }
    }

    @StoreThread
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        C12238m.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        this.interactionModalCreate.f27650k.onNext(interactionModalCreate);
    }

    @StoreThread
    public final void handleInteractionSuccess(InteractionStateUpdate interactionStateUpdate) {
        ComponentLocation componentLocation;
        C12238m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        SentInteraction sentInteraction = this.sentInteractions.get(interactionStateUpdate.getNonce());
        if (sentInteraction != null) {
            sentInteraction.setState(SentInteractionState.SUCCESS);
            markChanged(SentInteractionsUpdate);
        }
        if (!this.componentInteractions.containsKey(interactionStateUpdate.getNonce()) || (componentLocation = this.componentInteractions.get(interactionStateUpdate.getNonce())) == null) {
            return;
        }
        this.interactionComponentSendState.remove(Long.valueOf(componentLocation.getMessageId()));
        this.componentInteractions.remove(interactionStateUpdate.getNonce());
        markChanged(ComponentStateUpdate);
    }

    @StoreThread
    public final void handleLocalMessageDelete(Message message) {
        C12238m.checkNotNullParameter(message, "message");
        String nonce = message.getNonce();
        if (nonce != null) {
            removeApplicationCommandSendData(nonce);
        }
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        handleMessagesCreateOrLoad(C12145m.listOf(new Message(message)));
    }

    @StoreThread
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        boolean z2;
        C12238m.checkNotNullParameter(message, "message");
        Map<String, ComponentLocation> map = this.componentInteractions;
        if (map.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator<Map.Entry<String, ComponentLocation>> it = map.entrySet().iterator();
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
            Map<String, ComponentLocation> map2 = this.componentInteractions;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ComponentLocation> entry : map2.entrySet()) {
                if (entry.getValue().getMessageId() == message.getId()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
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
        C12238m.checkNotNullParameter(messagesList, "messagesList");
        for (Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce == null || !this.componentInteractions.containsKey(nonce)) {
                Interaction interaction = message.getInteraction();
                ApplicationCommandLocalSendData applicationCommandLocalSendData = null;
                Object obj = null;
                Long id2 = interaction != null ? interaction.getId() : null;
                if (!(nonce == null || C12103t.isBlank(nonce)) && this.applicationCommandLocalSendDataSet.containsKey(nonce)) {
                    applicationCommandLocalSendData = this.applicationCommandLocalSendDataSet.get(nonce);
                } else if (id2 != null) {
                    for (Object obj2 : this.applicationCommandLocalSendDataSet.values()) {
                        if (C12238m.areEqual(((ApplicationCommandLocalSendData) obj2).getInteractionId(), id2)) {
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
                ComponentLocation componentLocation = this.componentInteractions.get(nonce);
                if (componentLocation == null) {
                    return;
                }
                handleComponentInteractionMessage(componentLocation);
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
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        loadCachedApplicationCommandSendDataSet();
    }

    public final Observable<Map<Long, Map<Integer, InteractionSendState>>> observeComponentInteractionState() {
        Observable<Map<Long, Map<Integer, InteractionSendState>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComponentStateUpdate}, false, null, null, new C57281(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<State> observeInteractionData(long interactionId) {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57291(interactionId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<InteractionModalCreate> observeModalCreate() {
        PublishSubject<InteractionModalCreate> publishSubject = this.interactionModalCreate;
        C12238m.checkNotNullExpressionValue(publishSubject, "interactionModalCreate");
        return publishSubject;
    }

    public final Observable<Map<String, SentInteraction>> observeSentInteractions() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{SentInteractionsUpdate}, false, null, null, new C57301(), 14, null);
    }

    public final void resendApplicationCommand(Message message) {
        String nonce;
        ApplicationCommandLocalSendData applicationCommandLocalSendData;
        C12238m.checkNotNullParameter(message, "message");
        Integer type = message.getType();
        if (type == null || type.intValue() != -4 || (nonce = message.getNonce()) == null || (applicationCommandLocalSendData = this.applicationCommandLocalSendDataSnapshot.get(nonce)) == null) {
            return;
        }
        this.dispatcher.schedule(new C57311(message, nonce, applicationCommandLocalSendData.copy((1791 & 1) != 0 ? applicationCommandLocalSendData.nonce : NonceGenerator.Companion.computeNonce$default(NonceGenerator.INSTANCE, null, 1, null), (1791 & 2) != 0 ? applicationCommandLocalSendData.channelId : 0L, (1791 & 4) != 0 ? applicationCommandLocalSendData.guildId : null, (1791 & 8) != 0 ? applicationCommandLocalSendData.commandGuildId : null, (1791 & 16) != 0 ? applicationCommandLocalSendData.application : null, (1791 & 32) != 0 ? applicationCommandLocalSendData.sessionId : null, (1791 & 64) != 0 ? applicationCommandLocalSendData.applicationCommandName : null, (1791 & 128) != 0 ? applicationCommandLocalSendData.applicationCommandId : null, (1791 & 256) != 0 ? applicationCommandLocalSendData.applicationCommandsValues : null, (1791 & 512) != 0 ? applicationCommandLocalSendData.version : null, (1791 & 1024) != 0 ? applicationCommandLocalSendData.interactionId : null)));
    }

    public final void sendApplicationCommand(long channelId, Long guildId, String version, com.discord.widgets.chat.input.models.ApplicationCommandData data, List<? extends Attachment<?>> attachments, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail) {
        C12238m.checkNotNullParameter(data, "data");
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        C12238m.checkNotNullParameter(onFail, "onFail");
        this.dispatcher.schedule(new C57321(new ApplicationCommandLocalSendData(this.nonceGenerator.nonce(), channelId, guildId, data.getApplicationCommand().getGuildId(), data.getApplication(), this.sessionId, data.getApplicationCommand().getName(), data.getApplicationCommand().getId(), data.getValues(), version, null, 1024, null), attachments, onSuccess, onFail));
    }

    public final void sendComponentInteraction(long applicationId, Long guildId, long channelId, long messageId, int componentIndex, RestAPIParams.ComponentInteractionData data, Long messageFlags) {
        C12238m.checkNotNullParameter(data, "data");
        this.dispatcher.schedule(new C57331(messageId, componentIndex, String.valueOf(this.nonceGenerator.nonce()), channelId, guildId, applicationId, messageFlags, data));
    }

    public final void sendModalInteraction(InteractionModalCreate modal, List<Pair<String, String>> components, Function1<? super String, Unit> onNext, Function0<Unit> onError) {
        C12238m.checkNotNullParameter(modal, "modal");
        C12238m.checkNotNullParameter(components, "components");
        C12238m.checkNotNullParameter(onNext, "onNext");
        C12238m.checkNotNullParameter(onError, "onError");
        SentInteraction sentInteraction = this.sentInteractions.get(modal.getNonce());
        if (sentInteraction != null) {
            C12238m.checkNotNullExpressionValue(sentInteraction, "sentInteractions[modal.nonce] ?: return");
            long jNonce = this.nonceGenerator.nonce();
            this.sentInteractions.put(String.valueOf(jNonce), sentInteraction);
            this.dispatcher.schedule(new C57341(modal, sentInteraction, jNonce, components, onNext, onError));
        }
    }

    public final void setInteractionComponentSendStateSnapshot(Map<Long, ? extends Map<Integer, ? extends InteractionSendState>> map) {
        C12238m.checkNotNullParameter(map, "<set-?>");
        this.interactionComponentSendStateSnapshot = map;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.interactionDataSnapshot = new HashMap(this.interactionData);
        this.interactionComponentSendStateSnapshot = new HashMap(this.interactionComponentSendState);
        Map<String, SentInteraction> mapSnapshot = this.sentInteractions.snapshot();
        C12238m.checkNotNullExpressionValue(mapSnapshot, "sentInteractions.snapshot()");
        this.sentInteractionsSnapshot = mapSnapshot;
        HashMap map = new HashMap(this.applicationCommandLocalSendDataSet);
        this.applicationCommandLocalSendDataSnapshot = map;
        String strM9209m = this.gson.m9209m(map);
        SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString(CACHE_KEY_APPLICATION_COMMAND_SEND_DATA_SET, strM9209m);
        editorEdit.apply();
    }

    public StoreApplicationInteractions(StoreStream storeStream, Dispatcher dispatcher, StoreMessages storeMessages, StoreLocalActionComponentState storeLocalActionComponentState, StoreUser storeUser, Clock clock, SharedPreferences sharedPreferences, ObservationDeck observationDeck, RestAPI restAPI, NonceGenerator nonceGenerator) {
        C12238m.checkNotNullParameter(storeStream, "storeStream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeMessages, "storeMessages");
        C12238m.checkNotNullParameter(storeLocalActionComponentState, "storeLocalActionComponentState");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(sharedPreferences, "sharedPrefs");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(nonceGenerator, "nonceGenerator");
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
        this.interactionComponentSendStateSnapshot = C12136h0.emptyMap();
        this.applicationCommandLocalSendDataSnapshot = new LinkedHashMap();
        this.applicationCommandLocalSendDataSet = new LinkedHashMap();
        this.interactionDataSnapshot = C12136h0.emptyMap();
        this.interactionData = new HashMap<>();
        this.sentInteractions = new LruCache<>(5);
        this.sentInteractionsSnapshot = C12136h0.emptyMap();
        C4901e c4901e = new C4901e();
        C0850a.m147a(c4901e);
        this.gson = c4901e.m6851a();
        this.interactionModalCreate = PublishSubject.m11133k0();
    }

    @StoreThread
    private final void handleInteractionFailure(ApplicationCommandLocalSendData localSendData, Long interactionId) {
        handleApplicationCommandRequestStateUpdate(localSendData, interactionId);
    }
}
