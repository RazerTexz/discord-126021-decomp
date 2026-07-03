package com.discord.stores;

import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberVerificationForm extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, MemberVerificationFormData> memberVerificationFormSnapshot;
    private final HashMap<Long, MemberVerificationFormData> memberVerificationFormState;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
    public enum FetchStates {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
    public static final /* data */ class MemberVerificationFormData {
        private final FetchStates fetchState;
        private final ModelMemberVerificationForm form;

        public MemberVerificationFormData(FetchStates fetchStates, ModelMemberVerificationForm modelMemberVerificationForm) {
            C12238m.checkNotNullParameter(fetchStates, "fetchState");
            this.fetchState = fetchStates;
            this.form = modelMemberVerificationForm;
        }

        public static /* synthetic */ MemberVerificationFormData copy$default(MemberVerificationFormData memberVerificationFormData, FetchStates fetchStates, ModelMemberVerificationForm modelMemberVerificationForm, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchStates = memberVerificationFormData.fetchState;
            }
            if ((i & 2) != 0) {
                modelMemberVerificationForm = memberVerificationFormData.form;
            }
            return memberVerificationFormData.copy(fetchStates, modelMemberVerificationForm);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelMemberVerificationForm getForm() {
            return this.form;
        }

        public final MemberVerificationFormData copy(FetchStates fetchState, ModelMemberVerificationForm form) {
            C12238m.checkNotNullParameter(fetchState, "fetchState");
            return new MemberVerificationFormData(fetchState, form);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberVerificationFormData)) {
                return false;
            }
            MemberVerificationFormData memberVerificationFormData = (MemberVerificationFormData) other;
            return C12238m.areEqual(this.fetchState, memberVerificationFormData.fetchState) && C12238m.areEqual(this.form, memberVerificationFormData.form);
        }

        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        public final ModelMemberVerificationForm getForm() {
            return this.form;
        }

        public int hashCode() {
            FetchStates fetchStates = this.fetchState;
            int iHashCode = (fetchStates != null ? fetchStates.hashCode() : 0) * 31;
            ModelMemberVerificationForm modelMemberVerificationForm = this.form;
            return iHashCode + (modelMemberVerificationForm != null ? modelMemberVerificationForm.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("MemberVerificationFormData(fetchState=");
            sbM833U.append(this.fetchState);
            sbM833U.append(", form=");
            sbM833U.append(this.form);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1 */
    /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
    public static final class C60351 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ModelMemberVerificationForm, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
            public static final class C132551 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ ModelMemberVerificationForm $memberVerificationForm;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132551(ModelMemberVerificationForm modelMemberVerificationForm) {
                    super(0);
                    this.$memberVerificationForm = modelMemberVerificationForm;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C60351 c60351 = C60351.this;
                    StoreGuildMemberVerificationForm.this.handleMemberVerificationFormFetchSuccess(c60351.$guildId, this.$memberVerificationForm);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationForm modelMemberVerificationForm) {
                invoke2(modelMemberVerificationForm);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelMemberVerificationForm modelMemberVerificationForm) {
                C12238m.checkNotNullParameter(modelMemberVerificationForm, "memberVerificationForm");
                StoreGuildMemberVerificationForm.this.dispatcher.schedule(new C132551(modelMemberVerificationForm));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
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
                    C60351 c60351 = C60351.this;
                    StoreGuildMemberVerificationForm.this.handleMemberVerificationFormFetchFailed(c60351.$guildId);
                }
            }

            public AnonymousClass2() {
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
                StoreGuildMemberVerificationForm.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60351(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MemberVerificationFormData memberVerificationFormData = (MemberVerificationFormData) StoreGuildMemberVerificationForm.this.memberVerificationFormState.get(Long.valueOf(this.$guildId));
            if ((memberVerificationFormData != null ? memberVerificationFormData.getFetchState() : null) == FetchStates.FETCHING) {
                return;
            }
            StoreGuildMemberVerificationForm.this.handleMemberVerificationFormFetchStart(this.$guildId);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreGuildMemberVerificationForm.this.restAPI.getGuildMemberVerificationForm(this.$guildId), false, 1, null), (Class<?>) StoreGuildMemberVerificationForm.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberVerificationForm$observeMemberVerificationFormData$1 */
    /* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
    public static final class C60361 extends AbstractC12240o implements Function0<MemberVerificationFormData> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60361(long j) {
            super(0);
            this.$guildId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberVerificationFormData invoke() {
            return StoreGuildMemberVerificationForm.this.getMemberVerificationFormData(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final void handleMemberVerificationFormFetchFailed(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.FAILED, null));
        markChanged();
    }

    @StoreThread
    private final void handleMemberVerificationFormFetchStart(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.FETCHING, null));
        markChanged();
    }

    @StoreThread
    private final void handleMemberVerificationFormFetchSuccess(long guildId, ModelMemberVerificationForm memberVerificationForm) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.SUCCEEDED, memberVerificationForm));
        markChanged();
    }

    public final void fetchMemberVerificationForm(long guildId) {
        this.dispatcher.schedule(new C60351(guildId));
    }

    public final MemberVerificationFormData getMemberVerificationFormData(long guildId) {
        return this.memberVerificationFormSnapshot.get(Long.valueOf(guildId));
    }

    public final Observable<MemberVerificationFormData> observeMemberVerificationFormData(long guildId) {
        Observable<MemberVerificationFormData> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60361(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.memberVerificationFormSnapshot = new HashMap(this.memberVerificationFormState);
    }

    public StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.memberVerificationFormSnapshot = C12136h0.emptyMap();
        this.memberVerificationFormState = new HashMap<>();
    }
}
