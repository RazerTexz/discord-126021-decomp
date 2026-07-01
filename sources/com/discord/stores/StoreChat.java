package com.discord.stores;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.user.UserUtils;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChat extends StoreV2 {
    private final Dispatcher dispatcher;
    private StoreChat$EditingMessage editingMessage;
    private final PublishSubject<StoreChat$Event> eventSubject;
    private final List<Long> expandedBlockedMessageGroups;
    private List<Long> expandedBlockedMessageGroupsSnapshot;
    private StoreChat$InteractionState interactionState;
    private final ObservationDeck observationDeck;

    public /* synthetic */ StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreChat$EditingMessage access$getEditingMessage$p(StoreChat storeChat) {
        return storeChat.editingMessage;
    }

    public static final /* synthetic */ List access$getExpandedBlockedMessageGroups$p(StoreChat storeChat) {
        return storeChat.expandedBlockedMessageGroups;
    }

    public static final /* synthetic */ StoreChat$InteractionState access$getInteractionState$p(StoreChat storeChat) {
        return storeChat.interactionState;
    }

    public static final /* synthetic */ void access$setEditingMessage$p(StoreChat storeChat, StoreChat$EditingMessage storeChat$EditingMessage) {
        storeChat.editingMessage = storeChat$EditingMessage;
    }

    public static final /* synthetic */ void access$setInteractionState$p(StoreChat storeChat, StoreChat$InteractionState storeChat$InteractionState) {
        storeChat.interactionState = storeChat$InteractionState;
    }

    public final void appendMention(User user, long guildId) {
        if (user != null) {
            if (user.getUsername().length() == 0) {
                return;
            }
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.Companion.getGatewaySocket(), guildId, user.getUsername(), null, null, 12, null);
            StringBuilder sbU = a.U("@");
            sbU.append(user.getUsername());
            sbU.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            String string = sbU.toString();
            this.eventSubject.k.onNext(new StoreChat$Event$AppendChatText(string + ' '));
        }
    }

    public final StoreChat$EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    public final List<Long> getExpandedBlockedMessageGroups() {
        return this.expandedBlockedMessageGroupsSnapshot;
    }

    public final StoreChat$InteractionState getInteractionState() {
        return this.interactionState;
    }

    public final Observable<StoreChat$EditingMessage> observeEditingMessage() {
        Observable<StoreChat$EditingMessage> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChat$observeEditingMessage$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreChat$Event> observeEvents() {
        PublishSubject<StoreChat$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<List<Long>> observeExpandedBlockedMessageIds() {
        Observable<List<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChat$observeExpandedBlockedMessageIds$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreChat$InteractionState> observeInteractionState() {
        Observable observableG = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChat$observeInteractionState$1(this), 14, null).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<StoreChat$InteractionState> observableR = observableG.r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void replaceChatText(String text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.eventSubject.k.onNext(new StoreChat$Event$ReplaceChatText(text + ' '));
    }

    public final void setEditingMessage(StoreChat$EditingMessage editingMessage) {
        this.dispatcher.schedule(new StoreChat$setEditingMessage$1(this, editingMessage));
    }

    public final void setInteractionState(StoreChat$InteractionState interactionState) {
        m.checkNotNullParameter(interactionState, "interactionState");
        this.dispatcher.schedule(new StoreChat$setInteractionState$1(this, interactionState));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.expandedBlockedMessageGroupsSnapshot = new ArrayList(this.expandedBlockedMessageGroups);
    }

    public final void toggleBlockedMessageGroup(long messageId) {
        this.dispatcher.schedule(new StoreChat$toggleBlockedMessageGroup$1(this, messageId));
    }

    public StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.expandedBlockedMessageGroups = new ArrayList();
        this.expandedBlockedMessageGroupsSnapshot = n.emptyList();
        this.eventSubject = PublishSubject.k0();
    }
}
