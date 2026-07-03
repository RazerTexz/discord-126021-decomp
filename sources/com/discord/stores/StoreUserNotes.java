package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelUserNote;
import com.discord.restapi.RestAPIParams;
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
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserNotes extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, UserNoteState> notesByUserId;
    private Map<Long, ? extends UserNoteState> notesByUserIdSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: StoreUserNotes.kt */
    public static abstract class UserNoteState {

        /* JADX INFO: compiled from: StoreUserNotes.kt */
        public static final class Empty extends UserNoteState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreUserNotes.kt */
        public static final /* data */ class Loaded extends UserNoteState {
            private final ModelUserNote note;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelUserNote modelUserNote) {
                super(null);
                C12238m.checkNotNullParameter(modelUserNote, "note");
                this.note = modelUserNote;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelUserNote modelUserNote, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelUserNote = loaded.note;
                }
                return loaded.copy(modelUserNote);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelUserNote getNote() {
                return this.note;
            }

            public final Loaded copy(ModelUserNote note) {
                C12238m.checkNotNullParameter(note, "note");
                return new Loaded(note);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.note, ((Loaded) other).note);
                }
                return true;
            }

            public final ModelUserNote getNote() {
                return this.note;
            }

            public int hashCode() {
                ModelUserNote modelUserNote = this.note;
                if (modelUserNote != null) {
                    return modelUserNote.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(note=");
                sbM833U.append(this.note);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: StoreUserNotes.kt */
        public static final class Loading extends UserNoteState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private UserNoteState() {
        }

        public /* synthetic */ UserNoteState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$loadNote$1 */
    /* JADX INFO: compiled from: StoreUserNotes.kt */
    public static final class C65801 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $userId;

        /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$loadNote$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserNotes.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ModelUserNote, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$loadNote$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreUserNotes.kt */
            public static final class C132651 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ ModelUserNote $note;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132651(ModelUserNote modelUserNote) {
                    super(0);
                    this.$note = modelUserNote;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreUserNotes.this.handleRequestUserNoteSuccess(this.$note);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserNote modelUserNote) {
                invoke2(modelUserNote);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserNote modelUserNote) {
                C12238m.checkNotNullParameter(modelUserNote, "note");
                StoreUserNotes.this.dispatcher.schedule(new C132651(modelUserNote));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$loadNote$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserNotes.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$loadNote$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreUserNotes.kt */
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
                    C65801 c65801 = C65801.this;
                    StoreUserNotes.this.handleRequestUserNoteError(c65801.$userId);
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
                StoreUserNotes.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65801(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreUserNotes.this.notesByUserId.containsKey(Long.valueOf(this.$userId))) {
                return;
            }
            StoreUserNotes.this.notesByUserId.put(Long.valueOf(this.$userId), UserNoteState.Loading.INSTANCE);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreUserNotes.this.restAPI.getUserNote(this.$userId), false, 1, null), (Class<?>) StoreUserNotes.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$observeUserNote$1 */
    /* JADX INFO: compiled from: StoreUserNotes.kt */
    public static final class C65811 extends AbstractC12240o implements Function0<UserNoteState> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65811(long j) {
            super(0);
            this.$userId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserNoteState invoke() {
            UserNoteState userNoteState = StoreUserNotes.this.getNotesByUserId().get(Long.valueOf(this.$userId));
            return userNoteState != null ? userNoteState : UserNoteState.Loading.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$saveNote$1 */
    /* JADX INFO: compiled from: StoreUserNotes.kt */
    public static final class C65821 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ String $note;
        public final /* synthetic */ long $userId;

        /* JADX INFO: renamed from: com.discord.stores.StoreUserNotes$saveNote$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserNotes.kt */
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
                C65821 c65821 = C65821.this;
                StoreUserNotes.this.updateNoteInternal(c65821.$userId, c65821.$note);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65821(long j, String str) {
            super(1);
            this.$userId = j;
            this.$note = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreUserNotes.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    public /* synthetic */ StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final void handleRequestUserNoteError(long userId) {
        this.notesByUserId.put(Long.valueOf(userId), UserNoteState.Empty.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleRequestUserNoteSuccess(ModelUserNote note) {
        long noteUserId = note.getNoteUserId();
        String note2 = note.getNote();
        if (note2 == null) {
            note2 = "";
        }
        updateNoteInternal(noteUserId, note2);
    }

    @StoreThread
    private final void updateNoteInternal(long userId, String note) {
        if (C12103t.isBlank(note)) {
            this.notesByUserId.put(Long.valueOf(userId), UserNoteState.Empty.INSTANCE);
        } else {
            this.notesByUserId.put(Long.valueOf(userId), new UserNoteState.Loaded(new ModelUserNote(userId, note)));
        }
        markChanged();
    }

    public final Map<Long, UserNoteState> getNotesByUserId() {
        return this.notesByUserIdSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.notesByUserId.clear();
        markChanged();
    }

    @StoreThread
    public final void handleNoteUpdate(ModelUserNote.Update update) {
        C12238m.checkNotNullParameter(update, "update");
        updateNoteInternal(update.getId(), update.getNote());
    }

    public final void loadNote(long userId) {
        this.dispatcher.schedule(new C65801(userId));
    }

    public final Observable<UserNoteState> observeUserNote(long userId) {
        Observable<UserNoteState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65811(userId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void saveNote(Context context, long userId, String note) {
        C12238m.checkNotNullParameter(note, "note");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserNotes(userId, new RestAPIParams.UserNoteUpdate(note)), false, 1, null), (Class<?>) StoreUserNotes.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65821(userId, note));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.notesByUserIdSnapshot = new HashMap(this.notesByUserId);
    }

    public StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.notesByUserId = new HashMap();
        this.notesByUserIdSnapshot = C12136h0.emptyMap();
    }
}
