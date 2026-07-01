package com.discord.widgets.chat.managereactions;

import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReactions$EmojiResults;
import com.discord.stores.StoreMessageReactions$EmojiResults$Failure;
import com.discord.stores.StoreMessageReactions$EmojiResults$Loading;
import com.discord.stores.StoreMessageReactions$EmojiResults$Users;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider {
    private final long channelId;
    private final long messageId;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final SerializedSubject<String, String> targetedEmojiKeySubject;

    public ManageReactionsModelProvider(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.channelId = j;
        this.messageId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
        this.targetedEmojiKeySubject = new SerializedSubject<>(BehaviorSubject.l0(str));
    }

    public static final /* synthetic */ ManageReactionsModel access$createModel(ManageReactionsModelProvider manageReactionsModelProvider, List list, StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResults, MessageReactionEmoji messageReactionEmoji, boolean z2, long j, Map map) {
        return manageReactionsModelProvider.createModel(list, storeMessageReactions$EmojiResults, messageReactionEmoji, z2, j, map);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(ManageReactionsModelProvider manageReactionsModelProvider) {
        return manageReactionsModelProvider.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(ManageReactionsModelProvider manageReactionsModelProvider) {
        return manageReactionsModelProvider.storeGuilds;
    }

    public static final /* synthetic */ SerializedSubject access$getTargetedEmojiKeySubject$p(ManageReactionsModelProvider manageReactionsModelProvider) {
        return manageReactionsModelProvider.targetedEmojiKeySubject;
    }

    public static final /* synthetic */ Observable access$getUsersForReaction(ManageReactionsModelProvider manageReactionsModelProvider, MessageReactionEmoji messageReactionEmoji) {
        return manageReactionsModelProvider.getUsersForReaction(messageReactionEmoji);
    }

    private final ManageReactionsModel createModel(List<MessageReaction> reactions, StoreMessageReactions$EmojiResults results, MessageReactionEmoji targetedEmoji, boolean canManageMessages, long myId, Map<Long, GuildMember> guildMembers) {
        List listListOf;
        ArrayList arrayList = new ArrayList();
        for (MessageReaction messageReaction : reactions) {
            arrayList.add(new ManageReactionsEmojisAdapter$ReactionEmojiItem(messageReaction, m.areEqual(messageReaction.getEmoji(), targetedEmoji)));
        }
        if (results instanceof StoreMessageReactions$EmojiResults$Users) {
            StoreMessageReactions$EmojiResults$Users storeMessageReactions$EmojiResults$Users = (StoreMessageReactions$EmojiResults$Users) results;
            Collection<User> collectionValues = storeMessageReactions$EmojiResults$Users.getUsers().values();
            m.checkNotNullExpressionValue(collectionValues, "results.users.values");
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                m.checkNotNullExpressionValue(user, "user");
                arrayList2.add(new ManageReactionsResultsAdapter$ReactionUserItem(user, this.channelId, this.messageId, storeMessageReactions$EmojiResults$Users.getEmoji(), canManageMessages || user.getId() == myId, (GuildMember) a.f(user, guildMembers)));
            }
            listListOf = u.toList(arrayList2);
        } else if (results instanceof StoreMessageReactions$EmojiResults$Loading) {
            listListOf = d0.t.m.listOf(new ManageReactionsResultsAdapter$LoadingItem());
        } else {
            if (!(results instanceof StoreMessageReactions$EmojiResults$Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreMessageReactions$EmojiResults$Failure storeMessageReactions$EmojiResults$Failure = (StoreMessageReactions$EmojiResults$Failure) results;
            listListOf = d0.t.m.listOf(new ManageReactionsResultsAdapter$ErrorItem(storeMessageReactions$EmojiResults$Failure.getChannelId(), storeMessageReactions$EmojiResults$Failure.getMessageId(), storeMessageReactions$EmojiResults$Failure.getEmoji()));
        }
        return new ManageReactionsModel(arrayList, listListOf);
    }

    private final Observable<StoreMessageReactions$EmojiResults> getUsersForReaction(MessageReactionEmoji targetedEmoji) {
        return StoreStream.Companion.getMessageReactions().observeMessageReactions(this.channelId, this.messageId, targetedEmoji);
    }

    public final Observable<ManageReactionsModel> get() {
        ManageReactionsModelProvider$get$1 manageReactionsModelProvider$get$1 = new ManageReactionsModelProvider$get$1(this);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableG = storeStream$Companion.getMessages().observeMessagesForChannel(this.channelId, this.messageId).G(ManageReactionsModelProvider$get$reactionsObs$1.INSTANCE).G(ManageReactionsModelProvider$get$reactionsObs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…ion -> reaction.count } }");
        Observable observableY = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).Y(new ManageReactionsModelProvider$get$2(this, manageReactionsModelProvider$get$1, observableG, ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeChannels, this.storeGuilds}, false, null, null, new ManageReactionsModelProvider$get$guildMembersObservable$1(this), 14, null)));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…              }\n        }");
        Observable<ManageReactionsModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableR;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final void onEmojiTargeted(String emojiKey) {
        m.checkNotNullParameter(emojiKey, "emojiKey");
        this.targetedEmojiKeySubject.k.onNext(emojiKey);
    }

    public /* synthetic */ ManageReactionsModelProvider(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}
