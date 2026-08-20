package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMutualFriendsBinding;
import com.discord.databinding.WidgetUserProfileAdapterItemFriendBinding;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.StatusView;
import com.discord.widgets.user.profile.WidgetUserProfileEmptyListItem;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p025i.C0958f6;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func6;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserMutualFriends.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMutualFriendsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MutualFriendsAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final Lazy userId;

    /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, User user) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(user, "user");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_USER_ID", user.getId());
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(Intents.EXTRA_USER_ID, user.id)");
            C0870j.m156d(context, WidgetUserMutualFriends.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<Item> items;
        private final int numMutualFriends;
        private final User user;

        /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final long userId) {
                Observable observableM11099Y = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getRelationships(userId), false, 1, null).m11099Y(new InterfaceC12589b<List<? extends ModelUserRelationship>, Observable<? extends Model>>() { // from class: com.discord.widgets.user.WidgetUserMutualFriends$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetUserMutualFriends.Model> call(List<? extends ModelUserRelationship> list) {
                        C12238m.checkNotNullExpressionValue(list, "relationshipsApiResponse");
                        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Long.valueOf(((ModelUserRelationship) it.next()).getId()));
                        }
                        Observable<Map<Long, List<Guild>>> observableObserveMutualGuilds = new UserMutualGuildsManager(null, null, null, 7, null).observeMutualGuilds(arrayList);
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMutualGuilds, companion.getUsers().observeUsers(arrayList), companion.getPresences().observePresencesForUsers(arrayList), companion.getUserRelationships().observe(), companion.getApplicationStreaming().observeStreamsByUser(), companion.getUsers().observeUser(userId), new Func6<Map<Long, ? extends List<? extends Guild>>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Map<Long, ? extends ModelApplicationStream>, User, WidgetUserMutualFriends.Model>() { // from class: com.discord.widgets.user.WidgetUserMutualFriends$Model$Companion$get$1.1
                            @Override // p658rx.functions.Func6
                            public /* bridge */ /* synthetic */ WidgetUserMutualFriends.Model call(Map<Long, ? extends List<? extends Guild>> map, Map<Long, ? extends User> map2, Map<Long, ? extends Presence> map3, Map<Long, ? extends Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
                                return call2((Map<Long, ? extends List<Guild>>) map, map2, (Map<Long, Presence>) map3, (Map<Long, Integer>) map4, map5, user);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final WidgetUserMutualFriends.Model call2(Map<Long, ? extends List<Guild>> map, Map<Long, ? extends User> map2, Map<Long, Presence> map3, Map<Long, Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
                                C12238m.checkNotNullExpressionValue(map2, "users");
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                for (Map.Entry<Long, ? extends User> entry : map2.entrySet()) {
                                    if (map4.containsKey(Long.valueOf(entry.getKey().longValue()))) {
                                        linkedHashMap.put(entry.getKey(), entry.getValue());
                                    }
                                }
                                ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
                                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                    long jLongValue = ((Number) entry2.getKey()).longValue();
                                    User user2 = (User) entry2.getValue();
                                    Presence presence = map3.get(Long.valueOf(jLongValue));
                                    List<Guild> listEmptyList = map.get(Long.valueOf(jLongValue));
                                    if (listEmptyList == null) {
                                        listEmptyList = C12147n.emptyList();
                                    }
                                    arrayList2.add(new WidgetUserMutualFriends.Model.Item.MutualFriend(user2, presence, listEmptyList, Boolean.valueOf(map5.containsKey(Long.valueOf(jLongValue)))));
                                }
                                return new WidgetUserMutualFriends.Model(user, arrayList2.isEmpty() ? C12163u.plus((Collection<? extends WidgetUserMutualFriends.Model.Item.Empty>) arrayList2, WidgetUserMutualFriends.Model.Item.Empty.INSTANCE) : arrayList2, arrayList2.size());
                            }
                        }, 1000L, TimeUnit.MILLISECONDS);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "RestAPI\n            .api…          )\n            }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "RestAPI\n            .api…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
        public static abstract class Item implements MGRecyclerDataPayload {
            public static final int TYPE_EMPTY = 0;
            public static final int TYPE_FRIEND = 1;

            /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
            public static final class Empty extends Item {
                public static final Empty INSTANCE;
                private static final String key;
                private static final int type = 0;

                static {
                    Empty empty = new Empty();
                    INSTANCE = empty;
                    StringBuilder sbM833U = C1643a.m833U("empty");
                    sbM833U.append(empty.getType());
                    key = sbM833U.toString();
                }

                private Empty() {
                    super(null);
                }

                @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return key;
                }

                @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
                public int getType() {
                    return type;
                }
            }

            /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
            public static final /* data */ class MutualFriend extends Item {
                private final Boolean isApplicationStreaming;
                private final String key;
                private final List<Guild> mutualGuilds;
                private final Presence presence;
                private final int type;
                private final User user;

                public /* synthetic */ MutualFriend(User user, Presence presence, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(user, presence, list, (i & 8) != 0 ? null : bool);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ MutualFriend copy$default(MutualFriend mutualFriend, User user, Presence presence, List list, Boolean bool, int i, Object obj) {
                    if ((i & 1) != 0) {
                        user = mutualFriend.user;
                    }
                    if ((i & 2) != 0) {
                        presence = mutualFriend.presence;
                    }
                    if ((i & 4) != 0) {
                        list = mutualFriend.mutualGuilds;
                    }
                    if ((i & 8) != 0) {
                        bool = mutualFriend.isApplicationStreaming;
                    }
                    return mutualFriend.copy(user, presence, list, bool);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final User getUser() {
                    return this.user;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final Presence getPresence() {
                    return this.presence;
                }

                public final List<Guild> component3() {
                    return this.mutualGuilds;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final Boolean getIsApplicationStreaming() {
                    return this.isApplicationStreaming;
                }

                public final MutualFriend copy(User user, Presence presence, List<Guild> mutualGuilds, Boolean isApplicationStreaming) {
                    C12238m.checkNotNullParameter(user, "user");
                    C12238m.checkNotNullParameter(mutualGuilds, "mutualGuilds");
                    return new MutualFriend(user, presence, mutualGuilds, isApplicationStreaming);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof MutualFriend)) {
                        return false;
                    }
                    MutualFriend mutualFriend = (MutualFriend) other;
                    return C12238m.areEqual(this.user, mutualFriend.user) && C12238m.areEqual(this.presence, mutualFriend.presence) && C12238m.areEqual(this.mutualGuilds, mutualFriend.mutualGuilds) && C12238m.areEqual(this.isApplicationStreaming, mutualFriend.isApplicationStreaming);
                }

                @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return this.key;
                }

                public final List<Guild> getMutualGuilds() {
                    return this.mutualGuilds;
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

                public int hashCode() {
                    User user = this.user;
                    int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                    Presence presence = this.presence;
                    int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
                    List<Guild> list = this.mutualGuilds;
                    int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
                    Boolean bool = this.isApplicationStreaming;
                    return iHashCode3 + (bool != null ? bool.hashCode() : 0);
                }

                public final Boolean isApplicationStreaming() {
                    return this.isApplicationStreaming;
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("MutualFriend(user=");
                    sbM833U.append(this.user);
                    sbM833U.append(", presence=");
                    sbM833U.append(this.presence);
                    sbM833U.append(", mutualGuilds=");
                    sbM833U.append(this.mutualGuilds);
                    sbM833U.append(", isApplicationStreaming=");
                    return C1643a.m816D(sbM833U, this.isApplicationStreaming, ")");
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public MutualFriend(User user, Presence presence, List<Guild> list, Boolean bool) {
                    super(null);
                    C12238m.checkNotNullParameter(user, "user");
                    C12238m.checkNotNullParameter(list, "mutualGuilds");
                    this.user = user;
                    this.presence = presence;
                    this.mutualGuilds = list;
                    this.isApplicationStreaming = bool;
                    this.type = 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append(getType());
                    sb.append(user.getId());
                    this.key = sb.toString();
                }
            }

            private Item() {
            }

            public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(User user, List<? extends Item> list, int i) {
            C12238m.checkNotNullParameter(list, "items");
            this.user = user;
            this.items = list;
            this.numMutualFriends = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, User user, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                user = model.user;
            }
            if ((i2 & 2) != 0) {
                list = model.items;
            }
            if ((i2 & 4) != 0) {
                i = model.numMutualFriends;
            }
            return model.copy(user, list, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<Item> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getNumMutualFriends() {
            return this.numMutualFriends;
        }

        public final Model copy(User user, List<? extends Item> items, int numMutualFriends) {
            C12238m.checkNotNullParameter(items, "items");
            return new Model(user, items, numMutualFriends);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.user, model.user) && C12238m.areEqual(this.items, model.items) && this.numMutualFriends == model.numMutualFriends;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public final int getNumMutualFriends() {
            return this.numMutualFriends;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            List<Item> list = this.items;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.numMutualFriends;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(user=");
            sbM833U.append(this.user);
            sbM833U.append(", items=");
            sbM833U.append(this.items);
            sbM833U.append(", numMutualFriends=");
            return C1643a.m814B(sbM833U, this.numMutualFriends, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
    public static final class MutualFriendsAdapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final AppFragment fragment;

        /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
        public static final class ViewHolder extends MGRecyclerViewHolder<MutualFriendsAdapter, Model.Item> {
            private final WidgetUserProfileAdapterItemFriendBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(MutualFriendsAdapter mutualFriendsAdapter) {
                super(C5419R.layout.widget_user_profile_adapter_item_friend, mutualFriendsAdapter);
                C12238m.checkNotNullParameter(mutualFriendsAdapter, "adapter");
                View view = this.itemView;
                int i = C5419R.id.mutual_server_1;
                View viewFindViewById = view.findViewById(C5419R.id.mutual_server_1);
                if (viewFindViewById != null) {
                    C0958f6 c0958f6M200a = C0958f6.m200a(viewFindViewById);
                    i = C5419R.id.mutual_server_2;
                    View viewFindViewById2 = view.findViewById(C5419R.id.mutual_server_2);
                    if (viewFindViewById2 != null) {
                        C0958f6 c0958f6M200a2 = C0958f6.m200a(viewFindViewById2);
                        i = C5419R.id.mutual_server_3;
                        View viewFindViewById3 = view.findViewById(C5419R.id.mutual_server_3);
                        if (viewFindViewById3 != null) {
                            C0958f6 c0958f6M200a3 = C0958f6.m200a(viewFindViewById3);
                            i = C5419R.id.mutual_server_4;
                            View viewFindViewById4 = view.findViewById(C5419R.id.mutual_server_4);
                            if (viewFindViewById4 != null) {
                                C0958f6 c0958f6M200a4 = C0958f6.m200a(viewFindViewById4);
                                i = C5419R.id.user_profile_adapter_item_friend_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.user_profile_adapter_item_friend_avatar);
                                if (simpleDraweeView != null) {
                                    i = C5419R.id.user_profile_adapter_item_friend_mutual;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.user_profile_adapter_item_friend_mutual);
                                    if (linearLayout != null) {
                                        i = C5419R.id.user_profile_adapter_item_friend_status;
                                        StatusView statusView = (StatusView) view.findViewById(C5419R.id.user_profile_adapter_item_friend_status);
                                        if (statusView != null) {
                                            i = C5419R.id.user_profile_adapter_item_friend_user_game;
                                            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.user_profile_adapter_item_friend_user_game);
                                            if (simpleDraweeSpanTextView != null) {
                                                i = C5419R.id.user_profile_adapter_item_friend_user_name;
                                                TextView textView = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_friend_user_name);
                                                if (textView != null) {
                                                    WidgetUserProfileAdapterItemFriendBinding widgetUserProfileAdapterItemFriendBinding = new WidgetUserProfileAdapterItemFriendBinding((RelativeLayout) view, c0958f6M200a, c0958f6M200a2, c0958f6M200a3, c0958f6M200a4, simpleDraweeView, linearLayout, statusView, simpleDraweeSpanTextView, textView);
                                                    C12238m.checkNotNullExpressionValue(widgetUserProfileAdapterItemFriendBinding, "WidgetUserProfileAdapter…endBinding.bind(itemView)");
                                                    this.binding = widgetUserProfileAdapterItemFriendBinding;
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ MutualFriendsAdapter access$getAdapter$p(ViewHolder viewHolder) {
                return (MutualFriendsAdapter) viewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, Model.Item data) {
                C0958f6 c0958f6;
                C12238m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                final Model.Item.MutualFriend mutualFriend = (Model.Item.MutualFriend) data;
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                        long id2 = mutualFriend.getUser().getId();
                        FragmentManager parentFragmentManager = WidgetUserMutualFriends.MutualFriendsAdapter.ViewHolder.access$getAdapter$p(this.this$0).fragment.getParentFragmentManager();
                        C12238m.checkNotNullExpressionValue(parentFragmentManager, "adapter.fragment.parentFragmentManager");
                        WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
                    }
                });
                TextView textView = this.binding.f18370i;
                C12238m.checkNotNullExpressionValue(textView, "binding.userProfileAdapterItemFriendUserName");
                textView.setText(mutualFriend.getUser().getUsername());
                this.binding.f18368g.setPresence(mutualFriend.getPresence());
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f18369h;
                Presence presence = mutualFriend.getPresence();
                Boolean boolIsApplicationStreaming = mutualFriend.isApplicationStreaming();
                C12238m.checkNotNull(boolIsApplicationStreaming);
                boolean zBooleanValue = boolIsApplicationStreaming.booleanValue();
                C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "it");
                PresenceUtils.setPresenceText$default(presence, zBooleanValue, simpleDraweeSpanTextView, true, false, 16, null);
                SimpleDraweeView simpleDraweeView = this.binding.f18367f;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.userProfileAdapterItemFriendAvatar");
                IconUtils.setIcon$default(simpleDraweeView, mutualFriend.getUser(), C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
                int i = 0;
                while (i <= 3) {
                    if (i == 1) {
                        c0958f6 = this.binding.f18363b;
                    } else if (i == 2) {
                        c0958f6 = this.binding.f18364c;
                    } else if (i != 3) {
                        c0958f6 = i != 4 ? this.binding.f18366e : this.binding.f18366e;
                    } else {
                        c0958f6 = this.binding.f18365d;
                    }
                    C12238m.checkNotNullExpressionValue(c0958f6, "when (i) {\n            1…mutualServer4\n          }");
                    RelativeLayout relativeLayout = c0958f6.f849a;
                    C12238m.checkNotNullExpressionValue(relativeLayout, "item.root");
                    relativeLayout.setVisibility(8);
                    TextView textView2 = c0958f6.f851c;
                    C12238m.checkNotNullExpressionValue(textView2, "item.userProfileAdapterItemFriendMutualText");
                    textView2.setVisibility(8);
                    SimpleDraweeView simpleDraweeView2 = c0958f6.f850b;
                    C12238m.checkNotNullExpressionValue(simpleDraweeView2, "item.userProfileAdapterItemFriendMutualImage");
                    simpleDraweeView2.setVisibility(8);
                    Guild guild = (Guild) C12163u.getOrNull(mutualFriend.getMutualGuilds(), i);
                    if (guild != null) {
                        RelativeLayout relativeLayout2 = c0958f6.f849a;
                        C12238m.checkNotNullExpressionValue(relativeLayout2, "item.root");
                        relativeLayout2.setVisibility(0);
                        if (guild.getIcon() != null) {
                            SimpleDraweeView simpleDraweeView3 = c0958f6.f850b;
                            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "item.userProfileAdapterItemFriendMutualImage");
                            simpleDraweeView3.setVisibility(0);
                            SimpleDraweeView simpleDraweeView4 = c0958f6.f850b;
                            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "imageView");
                            IconUtils.setIcon$default((ImageView) simpleDraweeView4, guild, 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
                        } else {
                            TextView textView3 = c0958f6.f851c;
                            C12238m.checkNotNullExpressionValue(textView3, "item.userProfileAdapterItemFriendMutualText");
                            textView3.setVisibility(0);
                            TextView textView4 = c0958f6.f851c;
                            C12238m.checkNotNullExpressionValue(textView4, "item.userProfileAdapterItemFriendMutualText");
                            textView4.setText(guild.getShortName());
                        }
                    }
                    i++;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutualFriendsAdapter(RecyclerView recyclerView, AppFragment appFragment) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            C12238m.checkNotNullParameter(appFragment, "fragment");
            this.fragment = appFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, Model.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetUserProfileEmptyListItem(C5419R.layout.widget_user_profile_adapter_item_empty, this, C5419R.attr.img_no_mutual_friends, C5419R.string.no_mutual_friends);
            }
            if (viewType == 1) {
                return new ViewHolder(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMutualFriends$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
    public static final /* synthetic */ class C102171 extends C12236k implements Function1<Model, Unit> {
        public C102171(WidgetUserMutualFriends widgetUserMutualFriends) {
            super(1, widgetUserMutualFriends, WidgetUserMutualFriends.class, "configureUI", "configureUI(Lcom/discord/widgets/user/WidgetUserMutualFriends$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetUserMutualFriends) this.receiver).configureUI(model);
        }
    }

    public WidgetUserMutualFriends() {
        super(C5419R.layout.widget_user_mutual_friends);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMutualFriends$binding$2.INSTANCE, null, 2, null);
        this.userId = C12083g.lazy(new WidgetUserMutualFriends$userId$2(this));
    }

    private final void configureUI(Model data) {
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        setActionBarTitle(StringResourceUtilsKt.getQuantityString(resources, C5419R.plurals.user_profile_mutual_friends_count, C5419R.string.mutual_friends, data.getNumMutualFriends(), Integer.valueOf(data.getNumMutualFriends())));
        User user = data.getUser();
        setActionBarSubtitle(user != null ? user.getUsername() : null);
        MutualFriendsAdapter mutualFriendsAdapter = this.adapter;
        if (mutualFriendsAdapter != null) {
            mutualFriendsAdapter.setData(data.getItems());
        }
    }

    private final WidgetUserMutualFriendsBinding getBinding() {
        return (WidgetUserMutualFriendsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getUserId() {
        return ((Number) this.userId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f18341b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.userMutualFriendsRecyclerView");
        this.adapter = (MutualFriendsAdapter) companion.configure(new MutualFriendsAdapter(recyclerView, this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getUserId()), this, null, 2, null), (Class<?>) WidgetUserMutualFriends.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102171(this));
    }
}
