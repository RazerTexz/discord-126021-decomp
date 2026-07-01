package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserNote$Update;
import com.discord.restapi.RestAPIParams$UserNoteUpdate;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserNotes extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, StoreUserNotes$UserNoteState> notesByUserId;
    private Map<Long, ? extends StoreUserNotes$UserNoteState> notesByUserIdSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    public /* synthetic */ StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.dispatcher;
    }

    public static final /* synthetic */ Map access$getNotesByUserId$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.notesByUserId;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreUserNotes storeUserNotes) {
        return storeUserNotes.restAPI;
    }

    public static final /* synthetic */ void access$handleRequestUserNoteError(StoreUserNotes storeUserNotes, long j) {
        storeUserNotes.handleRequestUserNoteError(j);
    }

    public static final /* synthetic */ void access$handleRequestUserNoteSuccess(StoreUserNotes storeUserNotes, ModelUserNote modelUserNote) {
        storeUserNotes.handleRequestUserNoteSuccess(modelUserNote);
    }

    public static final /* synthetic */ void access$updateNoteInternal(StoreUserNotes storeUserNotes, long j, String str) {
        storeUserNotes.updateNoteInternal(j, str);
    }

    @StoreThread
    private final void handleRequestUserNoteError(long userId) {
        this.notesByUserId.put(Long.valueOf(userId), StoreUserNotes$UserNoteState$Empty.INSTANCE);
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
        if (t.isBlank(note)) {
            this.notesByUserId.put(Long.valueOf(userId), StoreUserNotes$UserNoteState$Empty.INSTANCE);
        } else {
            this.notesByUserId.put(Long.valueOf(userId), new StoreUserNotes$UserNoteState$Loaded(new ModelUserNote(userId, note)));
        }
        markChanged();
    }

    public final Map<Long, StoreUserNotes$UserNoteState> getNotesByUserId() {
        return this.notesByUserIdSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.notesByUserId.clear();
        markChanged();
    }

    @StoreThread
    public final void handleNoteUpdate(ModelUserNote$Update update) {
        m.checkNotNullParameter(update, "update");
        updateNoteInternal(update.getId(), update.getNote());
    }

    public final void loadNote(long userId) {
        this.dispatcher.schedule(new StoreUserNotes$loadNote$1(this, userId));
    }

    public final Observable<StoreUserNotes$UserNoteState> observeUserNote(long userId) {
        Observable<StoreUserNotes$UserNoteState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserNotes$observeUserNote$1(this, userId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void saveNote(Context context, long userId, String note) {
        m.checkNotNullParameter(note, "note");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserNotes(userId, new RestAPIParams$UserNoteUpdate(note)), false, 1, null), StoreUserNotes.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserNotes$saveNote$1(this, userId, note), 60, (Object) null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.notesByUserIdSnapshot = new HashMap(this.notesByUserId);
    }

    public StoreUserNotes(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.notesByUserId = new HashMap();
        this.notesByUserIdSnapshot = h0.emptyMap();
    }
}
