package com.discord.widgets.guilds.invite;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserAffinities;
import com.discord.stores.StoreUserRelationships;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: InviteSuggestionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsManager {
    private final StoreChannels storeChannels;
    private final StoreMessagesMostRecent storeMessagesMostRecent;
    private final StoreUserAffinities storeUserAffinities;
    private final StoreUserRelationships storeUserRelationships;
    private final StoreUser storeUsers;

    public InviteSuggestionsManager() {
        this(null, null, null, null, null, 31, null);
    }

    public InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships) {
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeMessagesMostRecent, "storeMessagesMostRecent");
        m.checkNotNullParameter(storeUserAffinities, "storeUserAffinities");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.storeChannels = storeChannels;
        this.storeMessagesMostRecent = storeMessagesMostRecent;
        this.storeUserAffinities = storeUserAffinities;
        this.storeUsers = storeUser;
        this.storeUserRelationships = storeUserRelationships;
    }

    public static final /* synthetic */ StoreUserRelationships access$getStoreUserRelationships$p(InviteSuggestionsManager inviteSuggestionsManager) {
        return inviteSuggestionsManager.storeUserRelationships;
    }

    public static final /* synthetic */ StoreUser access$getStoreUsers$p(InviteSuggestionsManager inviteSuggestionsManager) {
        return inviteSuggestionsManager.storeUsers;
    }

    public final Observable<List<InviteSuggestion>> observeInviteSuggestions() {
        Observable<List<InviteSuggestion>> observableI = Observable.i(this.storeChannels.observePrivateChannels(), this.storeMessagesMostRecent.observeRecentMessageIds().Z(1), this.storeUserAffinities.observeAffinityUserIds().Y(new InviteSuggestionsManager$observeInviteSuggestions$1(this)), InviteSuggestionsManager$observeInviteSuggestions$2.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest… inviteSuggestionList\n  }");
        return observableI;
    }

    public /* synthetic */ InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.Companion.getMessagesMostRecent() : storeMessagesMostRecent, (i & 4) != 0 ? StoreStream.Companion.getUserAffinities() : storeUserAffinities, (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.Companion.getUserRelationships() : storeUserRelationships);
    }
}
