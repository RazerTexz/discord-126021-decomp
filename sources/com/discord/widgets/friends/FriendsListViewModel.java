package com.discord.widgets.friends;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreContactSync;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreFriendSuggestions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12138i0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12153q;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p653p.C12781a;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Cancellable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel extends AbstractC0859d0<ViewState> {
    private static final int COLLAPSED_ITEM_COUNT = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOCATION = "Friends List";
    private Cancellable computeItemJob;
    private final PublishSubject<Event> eventSubject;
    private boolean isPendingSectionExpanded;
    private boolean isSuggestedSectionExpanded;
    private ListSections listSections;
    private final RestAPI restAPI;
    private final StoreChannels storeChannels;
    private final Observable<StoreState> storeObservable;

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$1 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83561 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C83561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) throws Exception {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) throws Exception {
            C12238m.checkNotNullParameter(storeState, "storeState");
            FriendsListViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            final StoreChannelsSelected channelsSelected = companion.getChannelsSelected();
            final StoreUserPresence presences = companion.getPresences();
            final StoreUser users = companion.getUsers();
            final StoreUserRelationships userRelationships = companion.getUserRelationships();
            final StoreUserConnections userConnections = companion.getUserConnections();
            final StoreApplicationStreaming applicationStreaming = companion.getApplicationStreaming();
            final StoreExperiments experiments = companion.getExperiments();
            final StoreContactSync contactSync = companion.getContactSync();
            final StoreFriendSuggestions friendSuggestions = companion.getFriendSuggestions();
            Observable<StoreState> observableM11083G = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{companion.getChannelsSelected(), companion.getPresences(), companion.getUsers(), companion.getUserRelationships(), companion.getApplicationStreaming(), companion.getUserConnections(), companion.getExperiments(), companion.getContactSync()}, false, null, null, 14, null), 1L, TimeUnit.SECONDS).m11083G(new InterfaceC12589b<Unit, StoreState>() { // from class: com.discord.widgets.friends.FriendsListViewModel$Companion$observeStores$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final FriendsListViewModel.StoreState call(Unit unit) {
                    boolean z2;
                    boolean z3;
                    long id2 = channelsSelected.getId();
                    SnowflakePartitionMap.CopiablePartitionMap<Presence> presences2 = presences.getPresences();
                    Map<Long, User> users2 = users.getUsers();
                    StoreUserRelationships.UserRelationshipsState relationshipsStateSnapshot = userRelationships.getRelationshipsStateSnapshot();
                    Map<Long, ModelApplicationStream> streamsByUser = applicationStreaming.getStreamsByUser();
                    StoreUserConnections.State stateSnapshot = userConnections.getStateSnapshot();
                    boolean z4 = stateSnapshot instanceof Collection;
                    if (!z4 || !stateSnapshot.isEmpty()) {
                        Iterator<ConnectedAccount> it = stateSnapshot.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (C12238m.areEqual(it.next().getType(), "contacts")) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (!z4 || !stateSnapshot.isEmpty()) {
                        Iterator<ConnectedAccount> it2 = stateSnapshot.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z3 = false;
                                break;
                            }
                            ConnectedAccount next = it2.next();
                            if (C12238m.areEqual(next.getType(), "contacts") && next.getFriendSync()) {
                                z3 = true;
                                break;
                            }
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                    Experiment userExperiment = experiments.getUserExperiment("2021-04_contact_sync_android_main", !z2);
                    boolean z5 = (userExperiment == null || userExperiment.getBucket() != 1 || z2) ? false : true;
                    boolean z6 = !contactSync.getFriendsListUpsellDismissed() && (userExperiment != null && userExperiment.getBucket() == 1 && !z3);
                    return new FriendsListViewModel.StoreState(z5 && !z6, z6, id2, relationshipsStateSnapshot, users2, presences2, streamsByUser, (userExperiment == null || userExperiment.getBucket() != 1) ? C12136h0.emptyMap() : friendSuggestions.getFriendSuggestions());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "ObservationDeckProvider\n…            )\n          }");
            return observableM11083G;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class CaptchaError extends Event {
            private final int discriminator;
            private final Error error;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CaptchaError(Error error, String str, int i) {
                super(null);
                C12238m.checkNotNullParameter(error, "error");
                C12238m.checkNotNullParameter(str, "username");
                this.error = error;
                this.username = str;
                this.discriminator = i;
            }

            public static /* synthetic */ CaptchaError copy$default(CaptchaError captchaError, Error error, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    error = captchaError.error;
                }
                if ((i2 & 2) != 0) {
                    str = captchaError.username;
                }
                if ((i2 & 4) != 0) {
                    i = captchaError.discriminator;
                }
                return captchaError.copy(error, str, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getDiscriminator() {
                return this.discriminator;
            }

            public final CaptchaError copy(Error error, String username, int discriminator) {
                C12238m.checkNotNullParameter(error, "error");
                C12238m.checkNotNullParameter(username, "username");
                return new CaptchaError(error, username, discriminator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CaptchaError)) {
                    return false;
                }
                CaptchaError captchaError = (CaptchaError) other;
                return C12238m.areEqual(this.error, captchaError.error) && C12238m.areEqual(this.username, captchaError.username) && this.discriminator == captchaError.discriminator;
            }

            public final int getDiscriminator() {
                return this.discriminator;
            }

            public final Error getError() {
                return this.error;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                Error error = this.error;
                int iHashCode = (error != null ? error.hashCode() : 0) * 31;
                String str = this.username;
                return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.discriminator;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("CaptchaError(error=");
                sbM833U.append(this.error);
                sbM833U.append(", username=");
                sbM833U.append(this.username);
                sbM833U.append(", discriminator=");
                return C1643a.m814B(sbM833U, this.discriminator, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class LaunchVoiceCall extends Event {
            private final long channelId;

            public LaunchVoiceCall(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ LaunchVoiceCall copy$default(LaunchVoiceCall launchVoiceCall, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVoiceCall.channelId;
                }
                return launchVoiceCall.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final LaunchVoiceCall copy(long channelId) {
                return new LaunchVoiceCall(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchVoiceCall) && this.channelId == ((LaunchVoiceCall) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return C0002b.m3a(this.channelId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("LaunchVoiceCall(channelId="), this.channelId, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class ShowFriendRequestErrorToast extends Event {
            private final int abortCode;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFriendRequestErrorToast(int i, String str) {
                super(null);
                C12238m.checkNotNullParameter(str, "username");
                this.abortCode = i;
                this.username = str;
            }

            public static /* synthetic */ ShowFriendRequestErrorToast copy$default(ShowFriendRequestErrorToast showFriendRequestErrorToast, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showFriendRequestErrorToast.abortCode;
                }
                if ((i2 & 2) != 0) {
                    str = showFriendRequestErrorToast.username;
                }
                return showFriendRequestErrorToast.copy(i, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getAbortCode() {
                return this.abortCode;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            public final ShowFriendRequestErrorToast copy(int abortCode, String username) {
                C12238m.checkNotNullParameter(username, "username");
                return new ShowFriendRequestErrorToast(abortCode, username);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowFriendRequestErrorToast)) {
                    return false;
                }
                ShowFriendRequestErrorToast showFriendRequestErrorToast = (ShowFriendRequestErrorToast) other;
                return this.abortCode == showFriendRequestErrorToast.abortCode && C12238m.areEqual(this.username, showFriendRequestErrorToast.username);
            }

            public final int getAbortCode() {
                return this.abortCode;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                int i = this.abortCode * 31;
                String str = this.username;
                return i + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ShowFriendRequestErrorToast(abortCode=");
                sbM833U.append(this.abortCode);
                sbM833U.append(", username=");
                return C1643a.m822J(sbM833U, this.username, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int stringRes;

            public ShowToast(int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.stringRes;
                }
                return showToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final ShowToast copy(int stringRes) {
                return new ShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.stringRes == ((ShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("ShowToast(stringRes="), this.stringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_CONTACT_SYNC_UPSELL = 6;
        public static final int TYPE_FRIEND = 0;
        public static final int TYPE_HEADER = 3;
        public static final int TYPE_PENDING_FRIEND = 1;
        public static final int TYPE_PENDING_HEADER = 2;
        public static final int TYPE_SUGGESTED_FRIEND = 5;
        public static final int TYPE_SUGGESTED_FRIEND_HEADER = 4;
        private final int type;

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class ContactSyncUpsell extends Item {
            private final boolean dismissed;
            private final String key;

            public ContactSyncUpsell(boolean z2) {
                super(6, null);
                this.dismissed = z2;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ ContactSyncUpsell copy$default(ContactSyncUpsell contactSyncUpsell, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = contactSyncUpsell.dismissed;
                }
                return contactSyncUpsell.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getDismissed() {
                return this.dismissed;
            }

            public final ContactSyncUpsell copy(boolean dismissed) {
                return new ContactSyncUpsell(dismissed);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ContactSyncUpsell) && this.dismissed == ((ContactSyncUpsell) other).dismissed;
                }
                return true;
            }

            public final boolean getDismissed() {
                return this.dismissed;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public int hashCode() {
                boolean z2 = this.dismissed;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return C1643a.m827O(C1643a.m833U("ContactSyncUpsell(dismissed="), this.dismissed, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Friend extends Item {
            private final boolean isApplicationStreaming;
            private final String key;
            private final Presence presence;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Friend(User user, Presence presence, boolean z2) {
                super(0, null);
                C12238m.checkNotNullParameter(user, "user");
                this.user = user;
                this.presence = presence;
                this.isApplicationStreaming = z2;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(user.getId());
                this.key = sb.toString();
            }

            public static /* synthetic */ Friend copy$default(Friend friend, User user, Presence presence, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = friend.user;
                }
                if ((i & 2) != 0) {
                    presence = friend.presence;
                }
                if ((i & 4) != 0) {
                    z2 = friend.isApplicationStreaming;
                }
                return friend.copy(user, presence, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final Friend copy(User user, Presence presence, boolean isApplicationStreaming) {
                C12238m.checkNotNullParameter(user, "user");
                return new Friend(user, presence, isApplicationStreaming);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Friend)) {
                    return false;
                }
                Friend friend = (Friend) other;
                return C12238m.areEqual(this.user, friend.user) && C12238m.areEqual(this.presence, friend.presence) && this.isApplicationStreaming == friend.isApplicationStreaming;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final User getUser() {
                return this.user;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
                boolean z2 = this.isApplicationStreaming;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode2 + r1;
            }

            public final boolean isApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final boolean isOnline() {
                return this.presence != null && C12148n0.setOf((Object[]) new ClientStatus[]{ClientStatus.ONLINE, ClientStatus.IDLE, ClientStatus.DND}).contains(this.presence.getStatus());
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Friend(user=");
                sbM833U.append(this.user);
                sbM833U.append(", presence=");
                sbM833U.append(this.presence);
                sbM833U.append(", isApplicationStreaming=");
                return C1643a.m827O(sbM833U, this.isApplicationStreaming, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Header extends Item {
            private final int count;
            private final String key;
            private final int titleStringResId;

            public Header(@StringRes int i, int i2) {
                super(3, null);
                this.titleStringResId = i;
                this.count = i2;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(i);
                this.key = sb.toString();
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = header.titleStringResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = header.count;
                }
                return header.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final Header copy(@StringRes int titleStringResId, int count) {
                return new Header(titleStringResId, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return this.titleStringResId == header.titleStringResId && this.count == header.count;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public int hashCode() {
                return (this.titleStringResId * 31) + this.count;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Header(titleStringResId=");
                sbM833U.append(this.titleStringResId);
                sbM833U.append(", count=");
                return C1643a.m814B(sbM833U, this.count, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class PendingFriendRequest extends Item {
            private final String key;
            private final Presence presence;
            private final int relationshipType;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PendingFriendRequest(User user, Presence presence, int i) {
                super(1, null);
                C12238m.checkNotNullParameter(user, "user");
                this.user = user;
                this.presence = presence;
                this.relationshipType = i;
                StringBuilder sb = new StringBuilder();
                sb.append(getType());
                sb.append(user.getId());
                this.key = sb.toString();
            }

            public static /* synthetic */ PendingFriendRequest copy$default(PendingFriendRequest pendingFriendRequest, User user, Presence presence, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    user = pendingFriendRequest.user;
                }
                if ((i2 & 2) != 0) {
                    presence = pendingFriendRequest.presence;
                }
                if ((i2 & 4) != 0) {
                    i = pendingFriendRequest.relationshipType;
                }
                return pendingFriendRequest.copy(user, presence, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getRelationshipType() {
                return this.relationshipType;
            }

            public final PendingFriendRequest copy(User user, Presence presence, int relationshipType) {
                C12238m.checkNotNullParameter(user, "user");
                return new PendingFriendRequest(user, presence, relationshipType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PendingFriendRequest)) {
                    return false;
                }
                PendingFriendRequest pendingFriendRequest = (PendingFriendRequest) other;
                return C12238m.areEqual(this.user, pendingFriendRequest.user) && C12238m.areEqual(this.presence, pendingFriendRequest.presence) && this.relationshipType == pendingFriendRequest.relationshipType;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final int getRelationshipType() {
                return this.relationshipType;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                return ((iHashCode + (presence != null ? presence.hashCode() : 0)) * 31) + this.relationshipType;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("PendingFriendRequest(user=");
                sbM833U.append(this.user);
                sbM833U.append(", presence=");
                sbM833U.append(this.presence);
                sbM833U.append(", relationshipType=");
                return C1643a.m814B(sbM833U, this.relationshipType, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class PendingHeader extends Item {
            private final int count;
            private final boolean isPendingSectionExpanded;
            private final String key;
            private final boolean showExpandButton;
            private final int titleStringResId;

            public PendingHeader(@StringRes int i, int i2, boolean z2, boolean z3) {
                super(2, null);
                this.titleStringResId = i;
                this.count = i2;
                this.isPendingSectionExpanded = z2;
                this.showExpandButton = z3;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ PendingHeader copy$default(PendingHeader pendingHeader, int i, int i2, boolean z2, boolean z3, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = pendingHeader.titleStringResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = pendingHeader.count;
                }
                if ((i3 & 4) != 0) {
                    z2 = pendingHeader.isPendingSectionExpanded;
                }
                if ((i3 & 8) != 0) {
                    z3 = pendingHeader.showExpandButton;
                }
                return pendingHeader.copy(i, i2, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsPendingSectionExpanded() {
                return this.isPendingSectionExpanded;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final PendingHeader copy(@StringRes int titleStringResId, int count, boolean isPendingSectionExpanded, boolean showExpandButton) {
                return new PendingHeader(titleStringResId, count, isPendingSectionExpanded, showExpandButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PendingHeader)) {
                    return false;
                }
                PendingHeader pendingHeader = (PendingHeader) other;
                return this.titleStringResId == pendingHeader.titleStringResId && this.count == pendingHeader.count && this.isPendingSectionExpanded == pendingHeader.isPendingSectionExpanded && this.showExpandButton == pendingHeader.showExpandButton;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int i = ((this.titleStringResId * 31) + this.count) * 31;
                boolean z2 = this.isPendingSectionExpanded;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i2 = (i + r1) * 31;
                boolean z3 = this.showExpandButton;
                return i2 + (z3 ? 1 : z3);
            }

            public final boolean isPendingSectionExpanded() {
                return this.isPendingSectionExpanded;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("PendingHeader(titleStringResId=");
                sbM833U.append(this.titleStringResId);
                sbM833U.append(", count=");
                sbM833U.append(this.count);
                sbM833U.append(", isPendingSectionExpanded=");
                sbM833U.append(this.isPendingSectionExpanded);
                sbM833U.append(", showExpandButton=");
                return C1643a.m827O(sbM833U, this.showExpandButton, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class SuggestedFriend extends Item {
            private final String key;
            private final FriendSuggestion suggestion;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedFriend(FriendSuggestion friendSuggestion) {
                super(5, null);
                C12238m.checkNotNullParameter(friendSuggestion, "suggestion");
                this.suggestion = friendSuggestion;
                this.key = getType() + " -- " + friendSuggestion.getUser().getId();
            }

            public static /* synthetic */ SuggestedFriend copy$default(SuggestedFriend suggestedFriend, FriendSuggestion friendSuggestion, int i, Object obj) {
                if ((i & 1) != 0) {
                    friendSuggestion = suggestedFriend.suggestion;
                }
                return suggestedFriend.copy(friendSuggestion);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            public final SuggestedFriend copy(FriendSuggestion suggestion) {
                C12238m.checkNotNullParameter(suggestion, "suggestion");
                return new SuggestedFriend(suggestion);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SuggestedFriend) && C12238m.areEqual(this.suggestion, ((SuggestedFriend) other).suggestion);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final FriendSuggestion getSuggestion() {
                return this.suggestion;
            }

            public int hashCode() {
                FriendSuggestion friendSuggestion = this.suggestion;
                if (friendSuggestion != null) {
                    return friendSuggestion.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SuggestedFriend(suggestion=");
                sbM833U.append(this.suggestion);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class SuggestedFriendsHeader extends Item {
            private final int count;
            private final boolean isExpanded;
            private final String key;
            private final boolean showExpandButton;

            public SuggestedFriendsHeader(int i, boolean z2, boolean z3) {
                super(4, null);
                this.count = i;
                this.isExpanded = z2;
                this.showExpandButton = z3;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ SuggestedFriendsHeader copy$default(SuggestedFriendsHeader suggestedFriendsHeader, int i, boolean z2, boolean z3, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = suggestedFriendsHeader.count;
                }
                if ((i2 & 2) != 0) {
                    z2 = suggestedFriendsHeader.isExpanded;
                }
                if ((i2 & 4) != 0) {
                    z3 = suggestedFriendsHeader.showExpandButton;
                }
                return suggestedFriendsHeader.copy(i, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsExpanded() {
                return this.isExpanded;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            public final SuggestedFriendsHeader copy(int count, boolean isExpanded, boolean showExpandButton) {
                return new SuggestedFriendsHeader(count, isExpanded, showExpandButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedFriendsHeader)) {
                    return false;
                }
                SuggestedFriendsHeader suggestedFriendsHeader = (SuggestedFriendsHeader) other;
                return this.count == suggestedFriendsHeader.count && this.isExpanded == suggestedFriendsHeader.isExpanded && this.showExpandButton == suggestedFriendsHeader.showExpandButton;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final boolean getShowExpandButton() {
                return this.showExpandButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v2, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int i = this.count * 31;
                boolean z2 = this.isExpanded;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i2 = (i + r1) * 31;
                boolean z3 = this.showExpandButton;
                return i2 + (z3 ? 1 : z3);
            }

            public final boolean isExpanded() {
                return this.isExpanded;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SuggestedFriendsHeader(count=");
                sbM833U.append(this.count);
                sbM833U.append(", isExpanded=");
                sbM833U.append(this.isExpanded);
                sbM833U.append(", showExpandButton=");
                return C1643a.m827O(sbM833U, this.showExpandButton, ")");
            }
        }

        private Item(int i) {
            this.type = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final /* data */ class ListSections {
        private final Item.ContactSyncUpsell contactSyncUpsell;
        private final List<Item> friendsItemsWithHeaders;
        private final Item.PendingHeader pendingHeaderItem;
        private final List<Item> pendingItems;
        private final List<Item.SuggestedFriend> suggestedFriendItems;
        private final Item.SuggestedFriendsHeader suggestionsHeaderItem;

        /* JADX WARN: Multi-variable type inference failed */
        public ListSections(Item.SuggestedFriendsHeader suggestedFriendsHeader, List<Item.SuggestedFriend> list, Item.PendingHeader pendingHeader, List<? extends Item> list2, List<? extends Item> list3, Item.ContactSyncUpsell contactSyncUpsell) {
            C12238m.checkNotNullParameter(list, "suggestedFriendItems");
            C12238m.checkNotNullParameter(list2, "pendingItems");
            C12238m.checkNotNullParameter(list3, "friendsItemsWithHeaders");
            this.suggestionsHeaderItem = suggestedFriendsHeader;
            this.suggestedFriendItems = list;
            this.pendingHeaderItem = pendingHeader;
            this.pendingItems = list2;
            this.friendsItemsWithHeaders = list3;
            this.contactSyncUpsell = contactSyncUpsell;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListSections copy$default(ListSections listSections, Item.SuggestedFriendsHeader suggestedFriendsHeader, List list, Item.PendingHeader pendingHeader, List list2, List list3, Item.ContactSyncUpsell contactSyncUpsell, int i, Object obj) {
            if ((i & 1) != 0) {
                suggestedFriendsHeader = listSections.suggestionsHeaderItem;
            }
            if ((i & 2) != 0) {
                list = listSections.suggestedFriendItems;
            }
            List list4 = list;
            if ((i & 4) != 0) {
                pendingHeader = listSections.pendingHeaderItem;
            }
            Item.PendingHeader pendingHeader2 = pendingHeader;
            if ((i & 8) != 0) {
                list2 = listSections.pendingItems;
            }
            List list5 = list2;
            if ((i & 16) != 0) {
                list3 = listSections.friendsItemsWithHeaders;
            }
            List list6 = list3;
            if ((i & 32) != 0) {
                contactSyncUpsell = listSections.contactSyncUpsell;
            }
            return listSections.copy(suggestedFriendsHeader, list4, pendingHeader2, list5, list6, contactSyncUpsell);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Item.SuggestedFriendsHeader getSuggestionsHeaderItem() {
            return this.suggestionsHeaderItem;
        }

        public final List<Item.SuggestedFriend> component2() {
            return this.suggestedFriendItems;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Item.PendingHeader getPendingHeaderItem() {
            return this.pendingHeaderItem;
        }

        public final List<Item> component4() {
            return this.pendingItems;
        }

        public final List<Item> component5() {
            return this.friendsItemsWithHeaders;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Item.ContactSyncUpsell getContactSyncUpsell() {
            return this.contactSyncUpsell;
        }

        public final ListSections copy(Item.SuggestedFriendsHeader suggestionsHeaderItem, List<Item.SuggestedFriend> suggestedFriendItems, Item.PendingHeader pendingHeaderItem, List<? extends Item> pendingItems, List<? extends Item> friendsItemsWithHeaders, Item.ContactSyncUpsell contactSyncUpsell) {
            C12238m.checkNotNullParameter(suggestedFriendItems, "suggestedFriendItems");
            C12238m.checkNotNullParameter(pendingItems, "pendingItems");
            C12238m.checkNotNullParameter(friendsItemsWithHeaders, "friendsItemsWithHeaders");
            return new ListSections(suggestionsHeaderItem, suggestedFriendItems, pendingHeaderItem, pendingItems, friendsItemsWithHeaders, contactSyncUpsell);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListSections)) {
                return false;
            }
            ListSections listSections = (ListSections) other;
            return C12238m.areEqual(this.suggestionsHeaderItem, listSections.suggestionsHeaderItem) && C12238m.areEqual(this.suggestedFriendItems, listSections.suggestedFriendItems) && C12238m.areEqual(this.pendingHeaderItem, listSections.pendingHeaderItem) && C12238m.areEqual(this.pendingItems, listSections.pendingItems) && C12238m.areEqual(this.friendsItemsWithHeaders, listSections.friendsItemsWithHeaders) && C12238m.areEqual(this.contactSyncUpsell, listSections.contactSyncUpsell);
        }

        public final Item.ContactSyncUpsell getContactSyncUpsell() {
            return this.contactSyncUpsell;
        }

        public final List<Item> getFriendsItemsWithHeaders() {
            return this.friendsItemsWithHeaders;
        }

        public final Item.PendingHeader getPendingHeaderItem() {
            return this.pendingHeaderItem;
        }

        public final List<Item> getPendingItems() {
            return this.pendingItems;
        }

        public final List<Item.SuggestedFriend> getSuggestedFriendItems() {
            return this.suggestedFriendItems;
        }

        public final Item.SuggestedFriendsHeader getSuggestionsHeaderItem() {
            return this.suggestionsHeaderItem;
        }

        public int hashCode() {
            Item.SuggestedFriendsHeader suggestedFriendsHeader = this.suggestionsHeaderItem;
            int iHashCode = (suggestedFriendsHeader != null ? suggestedFriendsHeader.hashCode() : 0) * 31;
            List<Item.SuggestedFriend> list = this.suggestedFriendItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Item.PendingHeader pendingHeader = this.pendingHeaderItem;
            int iHashCode3 = (iHashCode2 + (pendingHeader != null ? pendingHeader.hashCode() : 0)) * 31;
            List<Item> list2 = this.pendingItems;
            int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Item> list3 = this.friendsItemsWithHeaders;
            int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
            Item.ContactSyncUpsell contactSyncUpsell = this.contactSyncUpsell;
            return iHashCode5 + (contactSyncUpsell != null ? contactSyncUpsell.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ListSections(suggestionsHeaderItem=");
            sbM833U.append(this.suggestionsHeaderItem);
            sbM833U.append(", suggestedFriendItems=");
            sbM833U.append(this.suggestedFriendItems);
            sbM833U.append(", pendingHeaderItem=");
            sbM833U.append(this.pendingHeaderItem);
            sbM833U.append(", pendingItems=");
            sbM833U.append(this.pendingItems);
            sbM833U.append(", friendsItemsWithHeaders=");
            sbM833U.append(this.friendsItemsWithHeaders);
            sbM833U.append(", contactSyncUpsell=");
            sbM833U.append(this.contactSyncUpsell);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, ModelApplicationStream> applicationStreams;
        private final long channelId;
        private final Map<Long, FriendSuggestion> friendSuggestions;
        private final Map<Long, Presence> presences;
        private final StoreUserRelationships.UserRelationshipsState relationshipsState;
        private final boolean showContactSyncIcon;
        private final boolean showContactSyncUpsell;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(boolean z2, boolean z3, long j, StoreUserRelationships.UserRelationshipsState userRelationshipsState, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, FriendSuggestion> map4) {
            C12238m.checkNotNullParameter(userRelationshipsState, "relationshipsState");
            C12238m.checkNotNullParameter(map, "users");
            C12238m.checkNotNullParameter(map2, "presences");
            C12238m.checkNotNullParameter(map3, "applicationStreams");
            C12238m.checkNotNullParameter(map4, "friendSuggestions");
            this.showContactSyncIcon = z2;
            this.showContactSyncUpsell = z3;
            this.channelId = j;
            this.relationshipsState = userRelationshipsState;
            this.users = map;
            this.presences = map2;
            this.applicationStreams = map3;
            this.friendSuggestions = map4;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowContactSyncIcon() {
            return this.showContactSyncIcon;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowContactSyncUpsell() {
            return this.showContactSyncUpsell;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreUserRelationships.UserRelationshipsState getRelationshipsState() {
            return this.relationshipsState;
        }

        public final Map<Long, User> component5() {
            return this.users;
        }

        public final Map<Long, Presence> component6() {
            return this.presences;
        }

        public final Map<Long, ModelApplicationStream> component7() {
            return this.applicationStreams;
        }

        public final Map<Long, FriendSuggestion> component8() {
            return this.friendSuggestions;
        }

        public final StoreState copy(boolean showContactSyncIcon, boolean showContactSyncUpsell, long channelId, StoreUserRelationships.UserRelationshipsState relationshipsState, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, FriendSuggestion> friendSuggestions) {
            C12238m.checkNotNullParameter(relationshipsState, "relationshipsState");
            C12238m.checkNotNullParameter(users, "users");
            C12238m.checkNotNullParameter(presences, "presences");
            C12238m.checkNotNullParameter(applicationStreams, "applicationStreams");
            C12238m.checkNotNullParameter(friendSuggestions, "friendSuggestions");
            return new StoreState(showContactSyncIcon, showContactSyncUpsell, channelId, relationshipsState, users, presences, applicationStreams, friendSuggestions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.showContactSyncIcon == storeState.showContactSyncIcon && this.showContactSyncUpsell == storeState.showContactSyncUpsell && this.channelId == storeState.channelId && C12238m.areEqual(this.relationshipsState, storeState.relationshipsState) && C12238m.areEqual(this.users, storeState.users) && C12238m.areEqual(this.presences, storeState.presences) && C12238m.areEqual(this.applicationStreams, storeState.applicationStreams) && C12238m.areEqual(this.friendSuggestions, storeState.friendSuggestions);
        }

        public final Map<Long, ModelApplicationStream> getApplicationStreams() {
            return this.applicationStreams;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Map<Long, FriendSuggestion> getFriendSuggestions() {
            return this.friendSuggestions;
        }

        public final Map<Long, Presence> getPresences() {
            return this.presences;
        }

        public final StoreUserRelationships.UserRelationshipsState getRelationshipsState() {
            return this.relationshipsState;
        }

        public final boolean getShowContactSyncIcon() {
            return this.showContactSyncIcon;
        }

        public final boolean getShowContactSyncUpsell() {
            return this.showContactSyncUpsell;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15 */
        public int hashCode() {
            boolean z2 = this.showContactSyncIcon;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showContactSyncUpsell;
            int iM3a = (C0002b.m3a(this.channelId) + ((i + (z3 ? 1 : z3)) * 31)) * 31;
            StoreUserRelationships.UserRelationshipsState userRelationshipsState = this.relationshipsState;
            int iHashCode = (iM3a + (userRelationshipsState != null ? userRelationshipsState.hashCode() : 0)) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, FriendSuggestion> map4 = this.friendSuggestions;
            return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(showContactSyncIcon=");
            sbM833U.append(this.showContactSyncIcon);
            sbM833U.append(", showContactSyncUpsell=");
            sbM833U.append(this.showContactSyncUpsell);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", relationshipsState=");
            sbM833U.append(this.relationshipsState);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", presences=");
            sbM833U.append(this.presences);
            sbM833U.append(", applicationStreams=");
            sbM833U.append(this.applicationStreams);
            sbM833U.append(", friendSuggestions=");
            return C1643a.m825M(sbM833U, this.friendSuggestions, ")");
        }
    }

    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Empty extends ViewState {
            private final boolean showContactSyncIcon;

            public Empty(boolean z2) {
                super(null);
                this.showContactSyncIcon = z2;
            }

            public static /* synthetic */ Empty copy$default(Empty empty, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = empty.showContactSyncIcon;
                }
                return empty.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public final Empty copy(boolean showContactSyncIcon) {
                return new Empty(showContactSyncIcon);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && this.showContactSyncIcon == ((Empty) other).showContactSyncIcon;
                }
                return true;
            }

            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public int hashCode() {
                boolean z2 = this.showContactSyncIcon;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return C1643a.m827O(C1643a.m833U("Empty(showContactSyncIcon="), this.showContactSyncIcon, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Item> items;
            private final boolean showContactSyncIcon;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(boolean z2, List<? extends Item> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "items");
                this.showContactSyncIcon = z2;
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.showContactSyncIcon;
                }
                if ((i & 2) != 0) {
                    list = loaded.items;
                }
                return loaded.copy(z2, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            public final List<Item> component2() {
                return this.items;
            }

            public final Loaded copy(boolean showContactSyncIcon, List<? extends Item> items) {
                C12238m.checkNotNullParameter(items, "items");
                return new Loaded(showContactSyncIcon, items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.showContactSyncIcon == loaded.showContactSyncIcon && C12238m.areEqual(this.items, loaded.items);
            }

            public final List<Item> getItems() {
                return this.items;
            }

            public final boolean getShowContactSyncIcon() {
                return this.showContactSyncIcon;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.showContactSyncIcon;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                List<Item> list = this.items;
                return i + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(showContactSyncIcon=");
                sbM833U.append(this.showContactSyncIcon);
                sbM833U.append(", items=");
                return C1643a.m824L(sbM833U, this.items, ")");
            }
        }

        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$1 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83571 extends AbstractC12240o implements Function1<Void, Unit> {
        public C83571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            FriendsListViewModel.this.emitShowToastEvent(C5419R.string.accept_request_button_after);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83582 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendsListViewModel friendsListViewModel = FriendsListViewModel.this;
                Error.Response response = this.$error.getResponse();
                C12238m.checkNotNullExpressionValue(response, "error.response");
                friendsListViewModel.emitShowFriendRequestAbortToast(response.getCode(), C83582.this.$username);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendRequest$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Boolean> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                FriendsListViewModel.this.emitShowToastEvent(C5419R.string.default_failure_to_perform_action_message);
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83582(String str) {
            super(1);
            this.$username = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            RestAPIAbortMessages.INSTANCE.handleAbortCodeOrDefault(error, new AnonymousClass1(error), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$1 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83591 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C83591 INSTANCE = new C83591();

        public C83591() {
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

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$2 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83602 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$acceptFriendSuggestion$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendsListViewModel.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (WidgetCaptchaKt.isCaptchaError(this.$error)) {
                    C83602 c83602 = C83602.this;
                    FriendsListViewModel.this.emitCaptchaErrorEvent(this.$error, c83602.$username, c83602.$discriminator);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83602(String str, int i) {
            super(1);
            this.$username = str;
            this.$discriminator = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(RestAPIAbortMessages.INSTANCE, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$2 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83622<T> extends AbstractC12240o implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83622(Function1 function1) {
            super(1);
            this.$onSuccess = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$onSuccess.invoke(t);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$3 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83633 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83633(Function1 function1) {
            super(1);
            this.$onError = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            Function1 function1 = this.$onError;
            if (function1 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$asyncComputeAndHandleOnUiThread$4 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83644 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public final /* synthetic */ Ref$ObjectRef $subscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83644(Ref$ObjectRef ref$ObjectRef) {
            super(1);
            this.$subscription = ref$ObjectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            this.$subscription.element = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$getItems$3 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83663 extends AbstractC12240o implements Function1<Integer, Boolean> {
        public static final C83663 INSTANCE = new C83663();

        public C83663() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(int i) {
            return C12148n0.setOf((Object[]) new Integer[]{3, 4}).contains(Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$handleStoreState$1 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83671 extends AbstractC12240o implements Function0<ListSections> {
        public final /* synthetic */ Map $relationships;
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83671(Map map, StoreState storeState) {
            super(0);
            this.$relationships = map;
            this.$storeState = storeState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ListSections invoke() {
            return FriendsListViewModel.this.getItems(this.$relationships, this.$storeState.getUsers(), this.$storeState.getPresences(), this.$storeState.getApplicationStreams(), this.$storeState.getShowContactSyncUpsell(), this.$storeState.getFriendSuggestions());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$handleStoreState$2 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83682 extends AbstractC12240o implements Function1<ListSections, Unit> {
        public final /* synthetic */ StoreState $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83682(StoreState storeState) {
            super(1);
            this.$storeState = storeState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListSections listSections) {
            invoke2(listSections);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ListSections listSections) {
            C12238m.checkNotNullParameter(listSections, "it");
            FriendsListViewModel.this.handleComputedItems(listSections, this.$storeState.getShowContactSyncIcon());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$ignoreSuggestion$1 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83691 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C83691 INSTANCE = new C83691();

        public C83691() {
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

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$launchVoiceCall$1 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83701 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C83701() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            FriendsListViewModel.this.emitLaunchVoiceCallEvent(channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$launchVoiceCall$2 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83712 extends AbstractC12240o implements Function1<Error, Unit> {
        public C83712() {
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
            FriendsListViewModel.this.emitShowToastEvent(C5419R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$removeFriendRequest$1 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83721 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83721(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            FriendsListViewModel.this.emitShowToastEvent(this.$successMessageStringRes);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$removeFriendRequest$2 */
    /* JADX INFO: compiled from: FriendsListViewModel.kt */
    public static final class C83732 extends AbstractC12240o implements Function1<Error, Unit> {
        public C83732() {
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
            FriendsListViewModel.this.emitShowToastEvent(C5419R.string.default_failure_to_perform_action_message);
        }
    }

    public FriendsListViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ FriendsListViewModel(Observable observable, StoreChannels storeChannels, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? INSTANCE.observeStores() : observable, (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static /* synthetic */ void acceptFriendSuggestion$default(FriendsListViewModel friendsListViewModel, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        friendsListViewModel.acceptFriendSuggestion(str, i, captchaPayload);
    }

    private final <T> Cancellable asyncComputeAndHandleOnUiThread(final Function0<? extends T> compute, Function1<? super Error, Unit> onError, Function1<? super T, Unit> onSuccess) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Observable<T> observableM11098X = Observable.m11080o(new Action1<Emitter<T>>() { // from class: com.discord.widgets.friends.FriendsListViewModel.asyncComputeAndHandleOnUiThread.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p658rx.functions.Action1
            public final void call(Emitter<T> emitter) {
                emitter.onNext(compute.invoke());
            }
        }, Emitter.BackpressureMode.NONE).m11098X(C12781a.m10873a());
        C12238m.checkNotNullExpressionValue(observableM11098X, "Observable\n        .crea…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11098X, this, null, 2, null), (Class<?>) FriendsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C83644(ref$ObjectRef)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C83633(onError)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83622(onSuccess));
        return new Cancellable() { // from class: com.discord.widgets.friends.FriendsListViewModel.asyncComputeAndHandleOnUiThread.5
            @Override // p658rx.functions.Cancellable
            public final void cancel() {
                Subscription subscription = (Subscription) ref$ObjectRef.element;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Cancellable asyncComputeAndHandleOnUiThread$default(FriendsListViewModel friendsListViewModel, Function0 function0, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return friendsListViewModel.asyncComputeAndHandleOnUiThread(function0, function1, function2);
    }

    private final void emitCaptchaErrorEvent(Error error, String username, int discriminator) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.CaptchaError(error, username, discriminator));
    }

    private final void emitLaunchVoiceCallEvent(long channelId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.LaunchVoiceCall(channelId));
    }

    private final void emitShowFriendRequestAbortToast(int abortCode, String username) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowFriendRequestErrorToast(abortCode, username));
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowToast(stringRes));
    }

    @MainThread
    private final void generateLoadedItems(boolean showContactSyncIcon) {
        Item.SuggestedFriendsHeader suggestionsHeaderItem = this.listSections.getSuggestionsHeaderItem();
        Item.SuggestedFriendsHeader suggestedFriendsHeaderCopy$default = suggestionsHeaderItem != null ? Item.SuggestedFriendsHeader.copy$default(suggestionsHeaderItem, 0, this.isSuggestedSectionExpanded, false, 5, null) : null;
        Item.PendingHeader pendingHeaderItem = this.listSections.getPendingHeaderItem();
        ListSections listSectionsCopy$default = ListSections.copy$default(this.listSections, suggestedFriendsHeaderCopy$default, null, pendingHeaderItem != null ? Item.PendingHeader.copy$default(pendingHeaderItem, 0, 0, this.isPendingSectionExpanded, false, 11, null) : null, null, null, null, 58, null);
        this.listSections = listSectionsCopy$default;
        List<Item> visibleItems = getVisibleItems(listSectionsCopy$default);
        updateViewState(visibleItems.isEmpty() ^ true ? new ViewState.Loaded(showContactSyncIcon, visibleItems) : new ViewState.Empty(showContactSyncIcon));
    }

    public static /* synthetic */ void generateLoadedItems$default(FriendsListViewModel friendsListViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        friendsListViewModel.generateLoadedItems(z2);
    }

    private final ListSections getItems(Map<Long, Integer> relationships, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, boolean showContactSyncUpsell, Map<Long, FriendSuggestion> friendSuggestions) {
        ArrayList arrayList = new ArrayList();
        if (!friendSuggestions.isEmpty()) {
            Iterator<T> it = friendSuggestions.values().iterator();
            while (it.hasNext()) {
                arrayList.add(new Item.SuggestedFriend((FriendSuggestion) it.next()));
            }
            if (arrayList.size() > 1) {
                C12153q.sortWith(arrayList, new Comparator() { // from class: com.discord.widgets.friends.FriendsListViewModel$getItems$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return C12169a.compareValues(Long.valueOf(((FriendsListViewModel.Item.SuggestedFriend) t).getSuggestion().getUser().getId()), Long.valueOf(((FriendsListViewModel.Item.SuggestedFriend) t2).getSuggestion().getUser().getId()));
                    }
                });
            }
        }
        Item.SuggestedFriendsHeader suggestedFriendsHeader = !arrayList.isEmpty() ? new Item.SuggestedFriendsHeader(arrayList.size(), false, arrayList.size() > 2) : null;
        C83663 c83663 = C83663.INSTANCE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : C12138i0.asSequence(relationships)) {
            long jLongValue = ((Number) entry.getKey()).longValue();
            int iIntValue = ((Number) entry.getValue()).intValue();
            User user = users.get(Long.valueOf(jLongValue));
            int type = ModelUserRelationship.getType(Integer.valueOf(iIntValue));
            Presence presence = presences.get(Long.valueOf(jLongValue));
            boolean zContainsKey = applicationStreams.containsKey(Long.valueOf(jLongValue));
            if (user != null && type != 2) {
                if (C83663.INSTANCE.invoke(type)) {
                    arrayList2.add(new Item.PendingFriendRequest(user, presence, type));
                } else {
                    arrayList3.add(new Item.Friend(user, presence, zContainsKey));
                }
            }
        }
        List list = C12163u.toList(C12163u.sortedWith(arrayList2, new Comparator<Item.PendingFriendRequest>() { // from class: com.discord.widgets.friends.FriendsListViewModel$getItems$sortedPendingItems$1
            @Override // java.util.Comparator
            public final int compare(FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest, FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest2) {
                if (pendingFriendRequest.getRelationshipType() == 3 && pendingFriendRequest2.getRelationshipType() == 4) {
                    return -1;
                }
                if (pendingFriendRequest.getRelationshipType() == 4 && pendingFriendRequest2.getRelationshipType() == 3) {
                    return 1;
                }
                return UserUtils.INSTANCE.compareUserNames(pendingFriendRequest.getUser(), pendingFriendRequest2.getUser());
            }
        }));
        Item.PendingHeader pendingHeader = !list.isEmpty() ? new Item.PendingHeader(C5419R.string.friends_pending_request_header, list.size(), false, list.size() > 2) : null;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj : arrayList3) {
            if (((Item.Friend) obj).isOnline()) {
                arrayList5.add(obj);
            }
        }
        List list2 = C12163u.toList(C12163u.sortedWith(arrayList5, new Comparator<Item.Friend>() { // from class: com.discord.widgets.friends.FriendsListViewModel$getItems$onlineFriendItems$2
            @Override // java.util.Comparator
            public final int compare(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
                return UserUtils.INSTANCE.compareUserNames(friend.getUser(), friend2.getUser());
            }
        }));
        if (!list2.isEmpty()) {
            arrayList4.add(new Item.Header(C5419R.string.friends_online_header, list2.size()));
            arrayList4.addAll(list2);
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (!((Item.Friend) obj2).isOnline()) {
                arrayList6.add(obj2);
            }
        }
        List list3 = C12163u.toList(C12163u.sortedWith(arrayList6, new Comparator<Item.Friend>() { // from class: com.discord.widgets.friends.FriendsListViewModel$getItems$offlineFriendItems$2
            @Override // java.util.Comparator
            public final int compare(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
                return UserUtils.INSTANCE.compareUserNames(friend.getUser(), friend2.getUser());
            }
        }));
        if (true ^ list3.isEmpty()) {
            arrayList4.add(new Item.Header(C5419R.string.friends_offline_header, list3.size()));
            arrayList4.addAll(list3);
        }
        return new ListSections(suggestedFriendsHeader, arrayList, pendingHeader, list, arrayList4, showContactSyncUpsell ? new Item.ContactSyncUpsell(false) : null);
    }

    private final List<Item> getVisibleItems(ListSections listSections) {
        Item.SuggestedFriendsHeader suggestionsHeaderItem = listSections.getSuggestionsHeaderItem();
        List<Item.SuggestedFriend> suggestedFriendItems = listSections.getSuggestedFriendItems();
        Item.PendingHeader pendingHeaderItem = listSections.getPendingHeaderItem();
        List<Item> pendingItems = listSections.getPendingItems();
        List<Item> friendsItemsWithHeaders = listSections.getFriendsItemsWithHeaders();
        ArrayList arrayList = new ArrayList();
        if (listSections.getContactSyncUpsell() != null) {
            arrayList.add(listSections.getContactSyncUpsell());
        }
        if (!this.isSuggestedSectionExpanded) {
            suggestedFriendItems = C12163u.take(suggestedFriendItems, 2);
        }
        if (suggestionsHeaderItem != null && (!suggestedFriendItems.isEmpty())) {
            arrayList.add(suggestionsHeaderItem);
            arrayList.addAll(suggestedFriendItems);
        }
        if (!this.isPendingSectionExpanded) {
            pendingItems = C12163u.take(pendingItems, 2);
        }
        if (pendingHeaderItem != null && (!pendingItems.isEmpty())) {
            arrayList.add(pendingHeaderItem);
            arrayList.addAll(pendingItems);
        }
        arrayList.addAll(friendsItemsWithHeaders);
        return arrayList;
    }

    @MainThread
    private final void handleComputedItems(ListSections listSections, boolean showContactSyncIcon) {
        this.listSections = listSections;
        generateLoadedItems(showContactSyncIcon);
    }

    private final void handleStoreState(StoreState storeState) throws Exception {
        Cancellable cancellable = this.computeItemJob;
        if (cancellable != null) {
            cancellable.cancel();
        }
        if (!(storeState.getRelationshipsState() instanceof StoreUserRelationships.UserRelationshipsState.Loaded)) {
            updateViewState(ViewState.Uninitialized.INSTANCE);
            return;
        }
        Map<Long, Integer> relationships = ((StoreUserRelationships.UserRelationshipsState.Loaded) storeState.getRelationshipsState()).getRelationships();
        if (relationships.isEmpty()) {
            updateViewState(new ViewState.Empty(storeState.getShowContactSyncIcon() || storeState.getShowContactSyncUpsell()));
        } else {
            this.computeItemJob = asyncComputeAndHandleOnUiThread$default(this, new C83671(relationships, storeState), null, new C83682(storeState), 2, null);
        }
    }

    public final void acceptFriendRequest(long userId, String username) {
        C12238m.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.addRelationship(LOCATION, userId, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null), false, 1, null), this, null, 2, null), (Class<?>) FriendsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C83582(username)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83571());
    }

    public final void acceptFriendSuggestion(String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        C12238m.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Friends List - Friend Suggestion", username, discriminator, captchaPayload), false, 1, null), this, null, 2, null), (Class<?>) FriendsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C83602(username, discriminator)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C83591.INSTANCE);
    }

    @MainThread
    public final void dismissContactSyncUpsell() {
        StoreStream.INSTANCE.getContactSync().dismissFriendsListUpsell();
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final Observable<StoreState> getStoreObservable() {
        return this.storeObservable;
    }

    @MainThread
    public final void handleClickPendingHeader() {
        boolean showContactSyncIcon;
        this.isPendingSectionExpanded = !this.isPendingSectionExpanded;
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Empty) {
            showContactSyncIcon = ((ViewState.Empty) viewState).getShowContactSyncIcon();
        } else {
            showContactSyncIcon = viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getShowContactSyncIcon() : false;
        }
        generateLoadedItems(showContactSyncIcon);
    }

    @MainThread
    public final void handleClickSuggestedHeader() {
        boolean showContactSyncIcon;
        this.isSuggestedSectionExpanded = !this.isSuggestedSectionExpanded;
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Empty) {
            showContactSyncIcon = ((ViewState.Empty) viewState).getShowContactSyncIcon();
        } else {
            showContactSyncIcon = viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getShowContactSyncIcon() : false;
        }
        generateLoadedItems(showContactSyncIcon);
    }

    public final void ignoreSuggestion(long userId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ignoreFriendSuggestion(userId), false, 1, null), this, null, 2, null), (Class<?>) FriendsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C83691.INSTANCE);
    }

    public final void launchVoiceCall(long userId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.createOrFetchDM(userId), false, 1, null), this, null, 2, null), (Class<?>) FriendsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C83712()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83701());
    }

    @MainThread
    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void removeFriendRequest(long userId, int relationshipType) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship(LOCATION, userId), false, 1, null), this, null, 2, null), (Class<?>) FriendsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C83732()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83721(relationshipType == 3 ? C5419R.string.friend_request_ignored : C5419R.string.friend_request_cancelled));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel(Observable<StoreState> observable, StoreChannels storeChannels, RestAPI restAPI) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(observable, "storeObservable");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.storeObservable = observable;
        this.storeChannels = storeChannels;
        this.restAPI = restAPI;
        this.listSections = new ListSections(null, C12147n.emptyList(), null, C12147n.emptyList(), C12147n.emptyList(), null);
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) FriendsListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83561());
    }
}
