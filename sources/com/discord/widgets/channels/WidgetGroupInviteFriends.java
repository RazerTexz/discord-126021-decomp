package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.WidgetGroupInviteFriendsBinding;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGroupInviteFriends.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGroupInviteFriendsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final int MAX_GROUP_MEMBERS = 10;
    private static final int MAX_GROUP_MEMBERS_STAFF = 25;
    private static final long NO_CHANNEL_ID = -1;
    private static final int VIEW_INDEX_FRIENDS_LIST = 0;
    private static final int VIEW_INDEX_GROUP_FULL = 2;
    private static final int VIEW_INDEX_NO_FRIENDS = 1;
    private WidgetGroupInviteFriendsAdapter adapter;
    private final LinkedTreeMap<Long, User> addedUsers;
    private final BehaviorSubject<Collection<User>> addedUsersPublisher;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> filterPublisher;

    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, String source) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("DM Group Create", source, null, 4, null);
            C0870j.m157e(context, WidgetGroupInviteFriends.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(Context context, long channelId, String source) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("DM Group Add", source, null, 4, null);
            Intent intent = new Intent();
            intent.putExtra(WidgetGroupInviteFriends.INTENT_EXTRA_CHANNEL_ID, channelId);
            C0870j.m156d(context, WidgetGroupInviteFriends.class, intent);
        }
    }

    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int MODE_ADD = 1;
        public static final int MODE_CREATE = 0;
        private final Channel channel;
        private final String filterText;
        private final int maxGroupMemberCount;
        private final int mode;
        private final List<FriendItem> potentialAdditions;
        private final Collection<User> selectedUsers;

        /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
        public static final class Companion {

            /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
            public static final /* data */ class AddedUsersInput {
                private final Collection<User> addedUsers;
                private final String filter;

                /* JADX WARN: Multi-variable type inference failed */
                public AddedUsersInput(Collection<? extends User> collection, String str) {
                    C12238m.checkNotNullParameter(collection, "addedUsers");
                    C12238m.checkNotNullParameter(str, "filter");
                    this.addedUsers = collection;
                    this.filter = str;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AddedUsersInput copy$default(AddedUsersInput addedUsersInput, Collection collection, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        collection = addedUsersInput.addedUsers;
                    }
                    if ((i & 2) != 0) {
                        str = addedUsersInput.filter;
                    }
                    return addedUsersInput.copy(collection, str);
                }

                public final Collection<User> component1() {
                    return this.addedUsers;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getFilter() {
                    return this.filter;
                }

                public final AddedUsersInput copy(Collection<? extends User> addedUsers, String filter) {
                    C12238m.checkNotNullParameter(addedUsers, "addedUsers");
                    C12238m.checkNotNullParameter(filter, "filter");
                    return new AddedUsersInput(addedUsers, filter);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AddedUsersInput)) {
                        return false;
                    }
                    AddedUsersInput addedUsersInput = (AddedUsersInput) other;
                    return C12238m.areEqual(this.addedUsers, addedUsersInput.addedUsers) && C12238m.areEqual(this.filter, addedUsersInput.filter);
                }

                public final Collection<User> getAddedUsers() {
                    return this.addedUsers;
                }

                public final String getFilter() {
                    return this.filter;
                }

                public int hashCode() {
                    Collection<User> collection = this.addedUsers;
                    int iHashCode = (collection != null ? collection.hashCode() : 0) * 31;
                    String str = this.filter;
                    return iHashCode + (str != null ? str.hashCode() : 0);
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("AddedUsersInput(addedUsers=");
                    sbM833U.append(this.addedUsers);
                    sbM833U.append(", filter=");
                    return C1643a.m822J(sbM833U, this.filter, ")");
                }
            }

            private Companion() {
            }

            @SuppressLint({"DefaultLocale"})
            private final Observable<ModelAppUserRelationship> getFilteredFriends(Collection<? extends User> oldExcludeUsers, String nameFilter) {
                if (oldExcludeUsers == null) {
                    oldExcludeUsers = C12147n.emptyList();
                }
                Observable<ModelAppUserRelationship> observableM11099Y = Observable.m11058B(oldExcludeUsers).m11083G(new InterfaceC12589b<User, Long>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Long call(User user) {
                        return Long.valueOf(user.getId());
                    }
                }).m11105f0().m11082A(new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2(nameFilter)).m11099Y(new InterfaceC12589b<Map<Long, Integer>, Observable<? extends ModelAppUserRelationship>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship> call(final Map<Long, Integer> map) {
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.m11075i(companion.getPresences().observePresencesForUsers(map.keySet()), companion.getUsers().observeUsers(map.keySet()), companion.getApplicationStreaming().observeStreamsByUser(), new Func3<Map<Long, ? extends Presence>, Map<Long, ? extends User>, Map<Long, ? extends ModelApplicationStream>, WidgetGroupInviteFriends.Model.ModelAppUserRelationship>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3.1
                            @Override // p658rx.functions.Func3
                            public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.ModelAppUserRelationship call(Map<Long, ? extends Presence> map2, Map<Long, ? extends User> map3, Map<Long, ? extends ModelApplicationStream> map4) {
                                return call2((Map<Long, Presence>) map2, map3, map4);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final WidgetGroupInviteFriends.Model.ModelAppUserRelationship call2(Map<Long, Presence> map2, Map<Long, ? extends User> map3, Map<Long, ? extends ModelApplicationStream> map4) {
                                Map map5 = map;
                                C12238m.checkNotNullExpressionValue(map5, "filteredFriends");
                                C12238m.checkNotNullExpressionValue(map2, "presences");
                                C12238m.checkNotNullExpressionValue(map3, "users");
                                C12238m.checkNotNullExpressionValue(map4, "applicationStreams");
                                return new WidgetGroupInviteFriends.Model.ModelAppUserRelationship(map5, map2, map3, map4);
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable\n            .…          }\n            }");
                return observableM11099Y;
            }

            private final Observable<Model> getForAdd(long channelId, final Observable<Collection<User>> addedUsersPublisher, final Observable<String> filterPublisher) {
                Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1

                    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1 */
                    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
                    public static final /* synthetic */ class C73801 extends C12236k implements Function2<Collection<? extends User>, String, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput> {
                        public static final C73801 INSTANCE = new C73801();

                        public C73801() {
                            super(2, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput.class, "<init>", "<init>(Ljava/util/Collection;Ljava/lang/String;)V", 0);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke(Collection<? extends User> collection, String str) {
                            C12238m.checkNotNullParameter(collection, "p1");
                            C12238m.checkNotNullParameter(str, "p2");
                            return new WidgetGroupInviteFriends.Model.Companion.AddedUsersInput(collection, str);
                        }
                    }

                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetGroupInviteFriends.Model> call(final Channel channel) {
                        Object widgetGroupInviteFriends$sam$rx_functions_Func2$0;
                        if (channel == null) {
                            return new C12721k(null);
                        }
                        Observable observable = addedUsersPublisher;
                        Observable observable2 = filterPublisher;
                        C73801 c73801 = C73801.INSTANCE;
                        if (c73801 != null) {
                            widgetGroupInviteFriends$sam$rx_functions_Func2$0 = c73801;
                            widgetGroupInviteFriends$sam$rx_functions_Func2$0 = new WidgetGroupInviteFriends$sam$rx_functions_Func2$0(c73801);
                        }
                        widgetGroupInviteFriends$sam$rx_functions_Func2$0 = c73801;
                        return Observable.m11076j(observable, observable2, (Func2) widgetGroupInviteFriends$sam$rx_functions_Func2$0).m11099Y(new InterfaceC12589b<WidgetGroupInviteFriends.Model.Companion.AddedUsersInput, Observable<? extends WidgetGroupInviteFriends.Model>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1.2
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Observable<? extends WidgetGroupInviteFriends.Model> call(final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
                                ArrayList arrayList;
                                WidgetGroupInviteFriends.Model.Companion companion = WidgetGroupInviteFriends.Model.INSTANCE;
                                List<com.discord.api.user.User> listM7659z = channel.m7659z();
                                if (listM7659z != null) {
                                    arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7659z, 10));
                                    Iterator<T> it = listM7659z.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(new CoreUser((com.discord.api.user.User) it.next()));
                                    }
                                } else {
                                    arrayList = null;
                                }
                                return companion.getFilteredFriends(arrayList, addedUsersInput.getFilter()).m11083G(new InterfaceC12589b<WidgetGroupInviteFriends.Model.ModelAppUserRelationship, List<? extends WidgetGroupInviteFriends.Model.FriendItem>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getForAdd.1.2.2
                                    @Override // p637j0.p641k.InterfaceC12589b
                                    public final List<WidgetGroupInviteFriends.Model.FriendItem> call(WidgetGroupInviteFriends.Model.ModelAppUserRelationship modelAppUserRelationship) {
                                        WidgetGroupInviteFriends.Model.FriendItem.Companion companion2 = WidgetGroupInviteFriends.Model.FriendItem.INSTANCE;
                                        C12238m.checkNotNullExpressionValue(modelAppUserRelationship, "friends");
                                        return companion2.createData(modelAppUserRelationship, addedUsersInput.getAddedUsers());
                                    }
                                }).m11099Y(new InterfaceC12589b<List<? extends WidgetGroupInviteFriends.Model.FriendItem>, Observable<? extends WidgetGroupInviteFriends.Model>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getForAdd.1.2.3
                                    @Override // p637j0.p641k.InterfaceC12589b
                                    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(List<? extends WidgetGroupInviteFriends.Model.FriendItem> list) {
                                        return call2((List<WidgetGroupInviteFriends.Model.FriendItem>) list);
                                    }

                                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                                    public final Observable<? extends WidgetGroupInviteFriends.Model> call2(List<WidgetGroupInviteFriends.Model.FriendItem> list) {
                                        Channel channel2 = channel;
                                        String filter = addedUsersInput.getFilter();
                                        Collection<User> addedUsers = addedUsersInput.getAddedUsers();
                                        C12238m.checkNotNullExpressionValue(list, "friendItems");
                                        return new C12721k(new WidgetGroupInviteFriends.Model(channel2, filter, addedUsers, list, 1, UserUtils.INSTANCE.isStaff(StoreStream.INSTANCE.getUsers().getMeSnapshot()) ? 25 : 10));
                                    }
                                });
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
                return observableM11099Y;
            }

            private final Observable<Model> getForCreate(Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
                WidgetGroupInviteFriends$Model$Companion$getForCreate$1 widgetGroupInviteFriends$Model$Companion$getForCreate$1 = WidgetGroupInviteFriends$Model$Companion$getForCreate$1.INSTANCE;
                Object widgetGroupInviteFriends$sam$rx_functions_Func2$0 = widgetGroupInviteFriends$Model$Companion$getForCreate$1;
                if (widgetGroupInviteFriends$Model$Companion$getForCreate$1 != null) {
                    widgetGroupInviteFriends$sam$rx_functions_Func2$0 = new WidgetGroupInviteFriends$sam$rx_functions_Func2$0(widgetGroupInviteFriends$Model$Companion$getForCreate$1);
                }
                Observable<Model> observableM11099Y = Observable.m11076j(addedUsersPublisher, filterPublisher, (Func2) widgetGroupInviteFriends$sam$rx_functions_Func2$0).m11099Y(new InterfaceC12589b<AddedUsersInput, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForCreate$2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetGroupInviteFriends.Model> call(final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
                        return WidgetGroupInviteFriends.Model.INSTANCE.getFilteredFriends(null, addedUsersInput.getFilter()).m11083G(new InterfaceC12589b<WidgetGroupInviteFriends.Model.ModelAppUserRelationship, List<? extends WidgetGroupInviteFriends.Model.FriendItem>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForCreate$2.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final List<WidgetGroupInviteFriends.Model.FriendItem> call(WidgetGroupInviteFriends.Model.ModelAppUserRelationship modelAppUserRelationship) {
                                WidgetGroupInviteFriends.Model.FriendItem.Companion companion = WidgetGroupInviteFriends.Model.FriendItem.INSTANCE;
                                C12238m.checkNotNullExpressionValue(modelAppUserRelationship, "friends");
                                return companion.createData(modelAppUserRelationship, addedUsersInput.getAddedUsers());
                            }
                        }).m11099Y(new InterfaceC12589b<List<? extends WidgetGroupInviteFriends.Model.FriendItem>, Observable<? extends WidgetGroupInviteFriends.Model>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForCreate$2.2
                            @Override // p637j0.p641k.InterfaceC12589b
                            public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(List<? extends WidgetGroupInviteFriends.Model.FriendItem> list) {
                                return call2((List<WidgetGroupInviteFriends.Model.FriendItem>) list);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final Observable<? extends WidgetGroupInviteFriends.Model> call2(List<WidgetGroupInviteFriends.Model.FriendItem> list) {
                                String filter = addedUsersInput.getFilter();
                                Collection<User> addedUsers = addedUsersInput.getAddedUsers();
                                C12238m.checkNotNullExpressionValue(list, "friendItems");
                                return new C12721k(new WidgetGroupInviteFriends.Model(null, filter, addedUsers, list, 0, UserUtils.INSTANCE.isStaff(StoreStream.INSTANCE.getUsers().getMeSnapshot()) ? 25 : 10));
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable\n            .…          }\n            }");
                return observableM11099Y;
            }

            public static /* synthetic */ void getMODE_CREATE$annotations() {
            }

            public final Observable<Model> get(long channelId, Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
                C12238m.checkNotNullParameter(addedUsersPublisher, "addedUsersPublisher");
                C12238m.checkNotNullParameter(filterPublisher, "filterPublisher");
                return channelId == -1 ? getForCreate(addedUsersPublisher, filterPublisher) : getForAdd(channelId, addedUsersPublisher, filterPublisher);
            }

            public final Observable<? extends Collection<User>> getFriendChanges(final Observable<Collection<User>> addedUsers) {
                C12238m.checkNotNullParameter(addedUsers, "addedUsers");
                Observable<? extends Collection<User>> observableM11112r = StoreStream.INSTANCE.getUserRelationships().observeForType(1).m11099Y(new InterfaceC12589b<Map<Long, ? extends Integer>, Observable<? extends List<User>>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Map<Long, ? extends Integer> map) {
                        return call2((Map<Long, Integer>) map);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Observable<? extends List<User>> call2(final Map<Long, Integer> map) {
                        return addedUsers.m11099Y(new InterfaceC12589b<Collection<? extends User>, Observable<? extends List<User>>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Observable<? extends List<User>> call(Collection<? extends User> collection) {
                                return Observable.m11058B(collection).m11118y(new InterfaceC12589b<User, Boolean>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFriendChanges.1.1.1
                                    @Override // p637j0.p641k.InterfaceC12589b
                                    public final Boolean call(User user) {
                                        return Boolean.valueOf(map.containsKey(Long.valueOf(user.getId())));
                                    }
                                }).m11105f0();
                            }
                        });
                    }
                }).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
        public static final /* data */ class ModelAppUserRelationship {
            private final Map<Long, Presence> presences;
            private final Map<Long, Integer> relationships;
            private final Map<Long, ModelApplicationStream> streams;
            private final Map<Long, User> users;

            /* JADX WARN: Multi-variable type inference failed */
            public ModelAppUserRelationship(Map<Long, Integer> map, Map<Long, Presence> map2, Map<Long, ? extends User> map3, Map<Long, ? extends ModelApplicationStream> map4) {
                C12238m.checkNotNullParameter(map, "relationships");
                C12238m.checkNotNullParameter(map2, "presences");
                C12238m.checkNotNullParameter(map3, "users");
                C12238m.checkNotNullParameter(map4, "streams");
                this.relationships = map;
                this.presences = map2;
                this.users = map3;
                this.streams = map4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ModelAppUserRelationship copy$default(ModelAppUserRelationship modelAppUserRelationship, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = modelAppUserRelationship.relationships;
                }
                if ((i & 2) != 0) {
                    map2 = modelAppUserRelationship.presences;
                }
                if ((i & 4) != 0) {
                    map3 = modelAppUserRelationship.users;
                }
                if ((i & 8) != 0) {
                    map4 = modelAppUserRelationship.streams;
                }
                return modelAppUserRelationship.copy(map, map2, map3, map4);
            }

            public final Map<Long, Integer> component1() {
                return this.relationships;
            }

            public final Map<Long, Presence> component2() {
                return this.presences;
            }

            public final Map<Long, User> component3() {
                return this.users;
            }

            public final Map<Long, ModelApplicationStream> component4() {
                return this.streams;
            }

            public final ModelAppUserRelationship copy(Map<Long, Integer> relationships, Map<Long, Presence> presences, Map<Long, ? extends User> users, Map<Long, ? extends ModelApplicationStream> streams) {
                C12238m.checkNotNullParameter(relationships, "relationships");
                C12238m.checkNotNullParameter(presences, "presences");
                C12238m.checkNotNullParameter(users, "users");
                C12238m.checkNotNullParameter(streams, "streams");
                return new ModelAppUserRelationship(relationships, presences, users, streams);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ModelAppUserRelationship)) {
                    return false;
                }
                ModelAppUserRelationship modelAppUserRelationship = (ModelAppUserRelationship) other;
                return C12238m.areEqual(this.relationships, modelAppUserRelationship.relationships) && C12238m.areEqual(this.presences, modelAppUserRelationship.presences) && C12238m.areEqual(this.users, modelAppUserRelationship.users) && C12238m.areEqual(this.streams, modelAppUserRelationship.streams);
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public final Map<Long, ModelApplicationStream> getStreams() {
                return this.streams;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                Map<Long, Integer> map = this.relationships;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                Map<Long, Presence> map2 = this.presences;
                int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, User> map3 = this.users;
                int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map4 = this.streams;
                return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ModelAppUserRelationship(relationships=");
                sbM833U.append(this.relationships);
                sbM833U.append(", presences=");
                sbM833U.append(this.presences);
                sbM833U.append(", users=");
                sbM833U.append(this.users);
                sbM833U.append(", streams=");
                return C1643a.m825M(sbM833U, this.streams, ")");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, String str, Collection<? extends User> collection, List<FriendItem> list, int i, int i2) {
            C12238m.checkNotNullParameter(collection, "selectedUsers");
            C12238m.checkNotNullParameter(list, "potentialAdditions");
            this.channel = channel;
            this.filterText = str;
            this.selectedUsers = collection;
            this.potentialAdditions = list;
            this.mode = i;
            this.maxGroupMemberCount = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Channel channel, String str, Collection collection, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                channel = model.channel;
            }
            if ((i3 & 2) != 0) {
                str = model.filterText;
            }
            String str2 = str;
            if ((i3 & 4) != 0) {
                collection = model.selectedUsers;
            }
            Collection collection2 = collection;
            if ((i3 & 8) != 0) {
                list = model.potentialAdditions;
            }
            List list2 = list;
            if ((i3 & 16) != 0) {
                i = model.mode;
            }
            int i4 = i;
            if ((i3 & 32) != 0) {
                i2 = model.maxGroupMemberCount;
            }
            return model.copy(channel, str2, collection2, list2, i4, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFilterText() {
            return this.filterText;
        }

        public final Collection<User> component3() {
            return this.selectedUsers;
        }

        public final List<FriendItem> component4() {
            return this.potentialAdditions;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getMode() {
            return this.mode;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getMaxGroupMemberCount() {
            return this.maxGroupMemberCount;
        }

        public final Model copy(Channel channel, String filterText, Collection<? extends User> selectedUsers, List<FriendItem> potentialAdditions, int mode, int maxGroupMemberCount) {
            C12238m.checkNotNullParameter(selectedUsers, "selectedUsers");
            C12238m.checkNotNullParameter(potentialAdditions, "potentialAdditions");
            return new Model(channel, filterText, selectedUsers, potentialAdditions, mode, maxGroupMemberCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.channel, model.channel) && C12238m.areEqual(this.filterText, model.filterText) && C12238m.areEqual(this.selectedUsers, model.selectedUsers) && C12238m.areEqual(this.potentialAdditions, model.potentialAdditions) && this.mode == model.mode && this.maxGroupMemberCount == model.maxGroupMemberCount;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final String getFilterText() {
            return this.filterText;
        }

        public final int getMaxGroupMemberCount() {
            return this.maxGroupMemberCount;
        }

        public final int getMode() {
            return this.mode;
        }

        public final List<FriendItem> getPotentialAdditions() {
            return this.potentialAdditions;
        }

        public final Collection<User> getSelectedUsers() {
            return this.selectedUsers;
        }

        public final int getTotalNumRecipients() {
            int size = this.selectedUsers.size() + 1;
            Channel channel = this.channel;
            if (channel == null) {
                return size;
            }
            List<com.discord.api.user.User> listM7659z = channel.m7659z();
            return size + (listM7659z != null ? listM7659z.size() : 0);
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            String str = this.filterText;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            Collection<User> collection = this.selectedUsers;
            int iHashCode3 = (iHashCode2 + (collection != null ? collection.hashCode() : 0)) * 31;
            List<FriendItem> list = this.potentialAdditions;
            return ((((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.mode) * 31) + this.maxGroupMemberCount;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", filterText=");
            sbM833U.append(this.filterText);
            sbM833U.append(", selectedUsers=");
            sbM833U.append(this.selectedUsers);
            sbM833U.append(", potentialAdditions=");
            sbM833U.append(this.potentialAdditions);
            sbM833U.append(", mode=");
            sbM833U.append(this.mode);
            sbM833U.append(", maxGroupMemberCount=");
            return C1643a.m814B(sbM833U, this.maxGroupMemberCount, ")");
        }

        /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
        public static final /* data */ class FriendItem implements MGRecyclerDataPayload {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int TYPE_FRIEND = 0;
            private final boolean isApplicationStreaming;
            private final boolean isSelected;
            private final String key;
            private final Presence presence;
            private final int type;
            private final User user;

            /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
            public static final class Companion {
                private Companion() {
                }

                public final List<FriendItem> createData(ModelAppUserRelationship friends, Collection<? extends User> alreadyAddedUsers) {
                    C12238m.checkNotNullParameter(friends, "friends");
                    C12238m.checkNotNullParameter(alreadyAddedUsers, "alreadyAddedUsers");
                    ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(alreadyAddedUsers, 10));
                    Iterator<T> it = alreadyAddedUsers.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((User) it.next()).getId()));
                    }
                    Set set = C12163u.toSet(arrayList);
                    Set<Long> setKeySet = friends.getUsers().keySet();
                    ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(setKeySet, 10));
                    Iterator<T> it2 = setKeySet.iterator();
                    while (it2.hasNext()) {
                        long jLongValue = ((Number) it2.next()).longValue();
                        arrayList2.add(new FriendItem(friends.getUsers().get(Long.valueOf(jLongValue)), friends.getPresences().get(Long.valueOf(jLongValue)), set.contains(Long.valueOf(jLongValue)), friends.getStreams().containsKey(Long.valueOf(jLongValue))));
                    }
                    return arrayList2;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public FriendItem() {
                this(null, null, false, false, 15, null);
            }

            public FriendItem(User user, Presence presence, boolean z2, boolean z3) {
                this.user = user;
                this.presence = presence;
                this.isSelected = z2;
                this.isApplicationStreaming = z3;
                this.key = String.valueOf(user != null ? Long.valueOf(user.getId()) : null);
            }

            public static /* synthetic */ FriendItem copy$default(FriendItem friendItem, User user, Presence presence, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = friendItem.user;
                }
                if ((i & 2) != 0) {
                    presence = friendItem.presence;
                }
                if ((i & 4) != 0) {
                    z2 = friendItem.isSelected;
                }
                if ((i & 8) != 0) {
                    z3 = friendItem.isApplicationStreaming;
                }
                return friendItem.copy(user, presence, z2, z3);
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
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final FriendItem copy(User user, Presence presence, boolean isSelected, boolean isApplicationStreaming) {
                return new FriendItem(user, presence, isSelected, isApplicationStreaming);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FriendItem)) {
                    return false;
                }
                FriendItem friendItem = (FriendItem) other;
                return C12238m.areEqual(this.user, friendItem.user) && C12238m.areEqual(this.presence, friendItem.presence) && this.isSelected == friendItem.isSelected && this.isApplicationStreaming == friendItem.isApplicationStreaming;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public final User getUser() {
                return this.user;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
                boolean z2 = this.isSelected;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean z3 = this.isApplicationStreaming;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final boolean isSelected() {
                return this.isSelected;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("FriendItem(user=");
                sbM833U.append(this.user);
                sbM833U.append(", presence=");
                sbM833U.append(this.presence);
                sbM833U.append(", isSelected=");
                sbM833U.append(this.isSelected);
                sbM833U.append(", isApplicationStreaming=");
                return C1643a.m827O(sbM833U, this.isApplicationStreaming, ")");
            }

            public /* synthetic */ FriendItem(User user, Presence presence, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : user, (i & 2) != 0 ? null : presence, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
            }
        }

        public /* synthetic */ Model(Channel channel, String str, Collection collection, List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : channel, (i3 & 2) != 0 ? null : str, collection, list, (i3 & 16) != 0 ? 0 : i, i2);
        }
    }

    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class UserDataContract implements ChipsView.InterfaceC5465a {
        private final String displayString;
        private final User modelUser;

        public UserDataContract(User user) {
            this.modelUser = user;
            this.displayString = user != null ? user.getUsername() : null;
        }

        @Override // com.discord.chips_view.ChipsView.InterfaceC5465a
        public String getDisplayString() {
            return this.displayString;
        }

        public final User getModelUser() {
            return this.modelUser;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class C73851 extends AbstractC12240o implements Function2<User, Boolean, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73851(Model model) {
            super(2);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Boolean bool) {
            invoke(user, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(User user, boolean z2) {
            C12238m.checkNotNullParameter(user, "user");
            if (!z2) {
                WidgetGroupInviteFriends.this.unselectUser(user);
            } else if (this.$data.getTotalNumRecipients() >= this.$data.getMaxGroupMemberCount()) {
                C0876m.m171i(WidgetGroupInviteFriends.this, C5419R.string.group_dm_invite_full_sub, 0, 4);
            } else {
                WidgetGroupInviteFriends.this.selectUser(user);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class C73861 extends AbstractC12240o implements Function1<UserDataContract, Unit> {
        public C73861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserDataContract userDataContract) {
            invoke2(userDataContract);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserDataContract userDataContract) {
            User modelUser;
            if (userDataContract == null || (modelUser = userDataContract.getModelUser()) == null) {
                return;
            }
            WidgetGroupInviteFriends.this.unselectUser(modelUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class C73872 extends AbstractC12240o implements Function1<Object, Unit> {
        public C73872() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            WidgetGroupInviteFriends.this.filterPublisher.onNext(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final /* synthetic */ class C73883 extends C12236k implements Function1<Collection<? extends User>, Unit> {
        public C73883(BehaviorSubject behaviorSubject) {
            super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Collection<? extends User> collection) {
            invoke2(collection);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Collection<? extends User> collection) {
            ((BehaviorSubject) this.receiver).onNext(collection);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final /* synthetic */ class C73894 extends C12236k implements Function1<Model, Unit> {
        public C73894(WidgetGroupInviteFriends widgetGroupInviteFriends) {
            super(1, widgetGroupInviteFriends, WidgetGroupInviteFriends.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetGroupInviteFriends) this.receiver).configureUI(model);
        }
    }

    public WidgetGroupInviteFriends() {
        super(C5419R.layout.widget_group_invite_friends);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGroupInviteFriends$binding$2.INSTANCE, null, 2, null);
        this.addedUsers = new LinkedTreeMap<>();
        this.filterPublisher = BehaviorSubject.m11130l0("");
        this.addedUsersPublisher = BehaviorSubject.m11130l0(new ArrayList());
    }

    private final void configureUI(Model data) {
        int size;
        List<com.discord.api.user.User> listM7659z;
        if (data == null || (data.getMode() == 1 && data.getChannel() == null)) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<User> it = data.getSelectedUsers().iterator();
        while (true) {
            size = 0;
            if (!it.hasNext()) {
                break;
            }
            User next = it.next();
            getBinding().f16728b.m8376b(next.getUsername(), C1107b.m213e(this, C5419R.string.remove_role_or_user, new Object[]{next.getUsername()}, (4 & 4) != 0 ? C1107b.a.f1490j : null).toString(), Long.valueOf(next.getId()), new UserDataContract(next));
            hashSet.add(Long.valueOf(next.getId()));
        }
        String filterText = data.getFilterText();
        if (filterText != null) {
            if (filterText.length() > 0) {
                if (getBinding().f16728b.getText().length() == 0) {
                    getBinding().f16728b.setText(data.getFilterText());
                }
            }
        }
        getBinding().f16728b.m8378d(hashSet);
        List<Model.FriendItem> potentialAdditions = data.getPotentialAdditions();
        Channel channel = data.getChannel();
        if (channel != null && (listM7659z = channel.m7659z()) != null) {
            size = listM7659z.size();
        }
        AppViewFlipper appViewFlipper = getBinding().f16732f;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.groupInviteFriendsViewFlipper");
        appViewFlipper.setDisplayedChild(getChildToDisplay(data.getMaxGroupMemberCount(), 1 + size, potentialAdditions));
        WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter = this.adapter;
        if (widgetGroupInviteFriendsAdapter != null) {
            widgetGroupInviteFriendsAdapter.setData(potentialAdditions, new C73851(data));
        }
        setupFAB(data);
        setupToolbar(data);
    }

    private final WidgetGroupInviteFriendsBinding getBinding() {
        return (WidgetGroupInviteFriendsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getChildToDisplay(int maxGroupSize, int numRecipients, List<Model.FriendItem> potentialAdditions) {
        if (numRecipients >= maxGroupSize) {
            return 2;
        }
        return potentialAdditions == null || potentialAdditions.isEmpty() ? 1 : 0;
    }

    private final void selectUser(User user) {
        getBinding().f16728b.m8376b(user.getUsername(), C1107b.m213e(this, C5419R.string.remove_role_or_user, new Object[]{user.getUsername()}, (4 & 4) != 0 ? C1107b.a.f1490j : null).toString(), Long.valueOf(user.getId()), new UserDataContract(user));
        this.addedUsers.put(Long.valueOf(user.getId()), user);
        this.addedUsersPublisher.onNext(new ArrayList(this.addedUsers.values()));
    }

    @SuppressLint({"RestrictedApi"})
    private final void setupFAB(final Model data) {
        if (!(!data.getSelectedUsers().isEmpty())) {
            FloatingActionButton floatingActionButton = getBinding().f16731e;
            C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.groupInviteFriendsSaveFab");
            floatingActionButton.setVisibility(8);
            return;
        }
        FloatingActionButton floatingActionButton2 = getBinding().f16731e;
        C12238m.checkNotNullExpressionValue(floatingActionButton2, "binding.groupInviteFriendsSaveFab");
        floatingActionButton2.setVisibility(0);
        if (data.getTotalNumRecipients() > data.getMaxGroupMemberCount()) {
            getBinding().f16731e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.setupFAB.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C0876m.m169g(WidgetGroupInviteFriends.this.getContext(), C5419R.string.group_dm_invite_full_sub, 0, null, 12);
                }
            });
        } else {
            getBinding().f16731e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.setupFAB.2

                /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$setupFAB$2$3, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
                public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Pair<? extends Channel, ? extends Long>, Unit> {

                    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$setupFAB$2$3$2, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
                    public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                        public AnonymousClass2() {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f27425a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            StoreStream.INSTANCE.getMediaEngine().selectVideoInputDevice(null);
                        }
                    }

                    public AnonymousClass3() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Channel, ? extends Long> pair) throws Exception {
                        invoke2((Pair<Channel, Long>) pair);
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Pair<Channel, Long> pair) throws Exception {
                        Channel channelComponent1 = pair.component1();
                        Long lComponent2 = pair.component2();
                        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, channelComponent1.getId(), null, null, 12, null);
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        StoreTabsNavigation.selectHomeTab$default(companion.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
                        Channel channel = data.getChannel();
                        if (C12238m.areEqual(lComponent2, channel != null ? Long.valueOf(channel.getId()) : null)) {
                            Channel channel2 = data.getChannel();
                            if (channel2 == null || !ChannelUtils.m7702z(channel2)) {
                                companion.getVoiceChannelSelected().clear();
                                StoreCalls calls = companion.getCalls();
                                WidgetGroupInviteFriends widgetGroupInviteFriends = WidgetGroupInviteFriends.this;
                                Context contextRequireContext = widgetGroupInviteFriends.requireContext();
                                FragmentManager parentFragmentManager = WidgetGroupInviteFriends.this.getParentFragmentManager();
                                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                                calls.call(widgetGroupInviteFriends, contextRequireContext, parentFragmentManager, channelComponent1.getId(), AnonymousClass2.INSTANCE);
                            } else {
                                StoreCalls calls2 = companion.getCalls();
                                long id2 = channelComponent1.getId();
                                Collection<User> selectedUsers = data.getSelectedUsers();
                                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(selectedUsers, 10));
                                Iterator<T> it = selectedUsers.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(Long.valueOf(((User) it.next()).getId()));
                                }
                                calls2.ring(id2, arrayList);
                            }
                        }
                        AppActivity appActivity = WidgetGroupInviteFriends.this.getAppActivity();
                        if (appActivity != null) {
                            appActivity.onBackPressed();
                        }
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Observable<Channel> observableCreateGroupDM;
                    if (data.getChannel() != null) {
                        observableCreateGroupDM = RestAPI.INSTANCE.getApi().addGroupRecipients(data.getChannel().getId(), C12163u.toList(data.getSelectedUsers()));
                    } else if (data.getSelectedUsers().size() == 1) {
                        observableCreateGroupDM = RestAPI.INSTANCE.getApi().createOrFetchDM(((User) C12163u.first(data.getSelectedUsers())).getId());
                    } else {
                        RestAPI api = RestAPI.INSTANCE.getApi();
                        Collection<User> selectedUsers = data.getSelectedUsers();
                        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(selectedUsers, 10));
                        Iterator<T> it = selectedUsers.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Long.valueOf(((User) it.next()).getId()));
                        }
                        observableCreateGroupDM = api.createGroupDM(arrayList);
                    }
                    Observable observableM11076j = Observable.m11076j(observableCreateGroupDM, ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId(), 0L, false, 3, null), new Func2<Channel, Long, Pair<? extends Channel, ? extends Long>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.setupFAB.2.2
                        @Override // p658rx.functions.Func2
                        public final Pair<Channel, Long> call(Channel channel, Long l) {
                            return C12116o.m10073to(channel, l);
                        }
                    });
                    C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…dVoiceChannelId\n        }");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11076j, WidgetGroupInviteFriends.this, null, 2, null), (Class<?>) WidgetGroupInviteFriends.this.getClass(), (58 & 2) != 0 ? null : WidgetGroupInviteFriends.this.requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass3());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0069  */
    /* JADX WARN: Code duplicated, block: B:17:0x0076  */
    /* JADX WARN: Code duplicated, block: B:18:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0093  */
    /* JADX WARN: Code duplicated, block: B:20:0x00a0  */
    private final void setupToolbar(Model data) {
        int maxGroupMemberCount;
        CharSequence quantityString;
        if (data.getChannel() != null) {
            setActionBarTitle(C1107b.m213e(this, C5419R.string.group_dm_invite_with_name, new Object[]{ChannelUtils.m7681e(data.getChannel(), requireContext(), false, 2)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        } else {
            setActionBarTitle(getString(C5419R.string.invite_friend_modal_title));
        }
        if (data.getChannel() == null) {
            maxGroupMemberCount = data.getMaxGroupMemberCount() - data.getTotalNumRecipients();
            if (maxGroupMemberCount > 0) {
                Resources resources = getResources();
                C12238m.checkNotNullExpressionValue(resources, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), C5419R.plurals.group_dm_invite_remaining_number, maxGroupMemberCount, Integer.valueOf(maxGroupMemberCount));
            } else if (maxGroupMemberCount == 0) {
                quantityString = getString(C5419R.string.group_dm_invite_will_fill_mobile);
                C12238m.checkNotNullExpressionValue(quantityString, "getString(R.string.group…_invite_will_fill_mobile)");
            } else {
                int i = maxGroupMemberCount * (-1);
                Resources resources2 = getResources();
                C12238m.checkNotNullExpressionValue(resources2, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), C5419R.plurals.group_dm_invite_unselect_users_number, i, Integer.valueOf(i));
            }
            RelativeLayout relativeLayout = getBinding().f16729c;
            C12238m.checkNotNullExpressionValue(relativeLayout, "binding.groupInviteFriendsRecipientsContainer");
            relativeLayout.setVisibility(0);
        } else {
            List<com.discord.api.user.User> listM7659z = data.getChannel().m7659z();
            if ((listM7659z != null ? listM7659z.size() : 1) >= data.getMaxGroupMemberCount()) {
                quantityString = getString(C5419R.string.group_dm_invite_full_main);
                C12238m.checkNotNullExpressionValue(quantityString, "getString(R.string.group_dm_invite_full_main)");
                RelativeLayout relativeLayout2 = getBinding().f16729c;
                C12238m.checkNotNullExpressionValue(relativeLayout2, "binding.groupInviteFriendsRecipientsContainer");
                relativeLayout2.setVisibility(8);
            } else {
                maxGroupMemberCount = data.getMaxGroupMemberCount() - data.getTotalNumRecipients();
                if (maxGroupMemberCount > 0) {
                    Resources resources3 = getResources();
                    C12238m.checkNotNullExpressionValue(resources3, "resources");
                    quantityString = StringResourceUtilsKt.getQuantityString(resources3, requireContext(), C5419R.plurals.group_dm_invite_remaining_number, maxGroupMemberCount, Integer.valueOf(maxGroupMemberCount));
                } else if (maxGroupMemberCount == 0) {
                    quantityString = getString(C5419R.string.group_dm_invite_will_fill_mobile);
                    C12238m.checkNotNullExpressionValue(quantityString, "getString(R.string.group…_invite_will_fill_mobile)");
                } else {
                    int i2 = maxGroupMemberCount * (-1);
                    Resources resources4 = getResources();
                    C12238m.checkNotNullExpressionValue(resources4, "resources");
                    quantityString = StringResourceUtilsKt.getQuantityString(resources4, requireContext(), C5419R.plurals.group_dm_invite_unselect_users_number, i2, Integer.valueOf(i2));
                }
                RelativeLayout relativeLayout3 = getBinding().f16729c;
                C12238m.checkNotNullExpressionValue(relativeLayout3, "binding.groupInviteFriendsRecipientsContainer");
                relativeLayout3.setVisibility(0);
            }
        }
        setActionBarSubtitle(quantityString);
    }

    private final void unselectUser(User user) {
        this.addedUsers.remove(Long.valueOf(user.getId()));
        this.addedUsersPublisher.onNext(new ArrayList(this.addedUsers.values()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16730d;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.groupInviteFriendsRecycler");
        this.adapter = (WidgetGroupInviteFriendsAdapter) companion.configure(new WidgetGroupInviteFriendsAdapter(recyclerView));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ChipsView chipsView = getBinding().f16728b;
        Objects.requireNonNull(chipsView, "null cannot be cast to non-null type com.discord.chips_view.ChipsView<kotlin.Long, com.discord.widgets.channels.WidgetGroupInviteFriends.UserDataContract>");
        chipsView.setChipDeletedListener(new C73861());
        getBinding().f16728b.setTextChangedListener(new C73872());
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Collection<User>> behaviorSubject = this.addedUsersPublisher;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "addedUsersPublisher");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(companion.getFriendChanges(behaviorSubject), this, this.adapter), (Class<?>) WidgetGroupInviteFriends.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73883(this.addedUsersPublisher));
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L);
        BehaviorSubject<Collection<User>> behaviorSubject2 = this.addedUsersPublisher;
        C12238m.checkNotNullExpressionValue(behaviorSubject2, "addedUsersPublisher");
        BehaviorSubject<String> behaviorSubject3 = this.filterPublisher;
        C12238m.checkNotNullExpressionValue(behaviorSubject3, "filterPublisher");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(companion.get(longExtra, behaviorSubject2, behaviorSubject3), this, this.adapter), (Class<?>) WidgetGroupInviteFriends.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73894(this));
    }
}
