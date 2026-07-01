package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.databinding.WidgetChatListAdapterItemSpotifyListenTogetherBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.g0.Strings4;
import d0.t.Iterators5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether extends WidgetChatListItem {
    private static final long EMBED_LIFETIME_MILLIS = 7200000;
    private static final long MAX_USERS_SHOWN = 6;
    private final WidgetChatListAdapterItemSpotifyListenTogetherBinding binding;
    private Subscription subscription;

    /* JADX INFO: renamed from: userAdapter$delegate, reason: from kotlin metadata */
    private final Lazy userAdapter;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isMe;
        private final SpotifyListenTogetherEntry item;
        private final Presence presence;
        private final List<CollapsedUser> users;

        /* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Model create(Presence presence, Map<Long, ? extends User> userMap, SpotifyListenTogetherEntry item, boolean isMe) {
                ActivityParty party;
                HashMap map = new HashMap();
                for (User user : userMap.values()) {
                    map.put(Long.valueOf(user.getId()), new CollapsedUser(user, false, 0L, 6, null));
                }
                if (isMe) {
                    MeUser meSnapshot = StoreStream.INSTANCE.getUsers().getMeSnapshot();
                    map.put(Long.valueOf(meSnapshot.getId()), new CollapsedUser(meSnapshot, false, 0L, 6, null));
                }
                Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
                long maxSize = (spotifyListeningActivity == null || (party = spotifyListeningActivity.getParty()) == null) ? 0L : PresenceUtils.INSTANCE.getMaxSize(party);
                Collection collectionValues = map.values();
                Intrinsics3.checkNotNullExpressionValue(collectionValues, "collapsedUserMap.values");
                List mutableList = _Collections.toMutableList(collectionValues);
                Iterator<Long> it = _Ranges.until(userMap.size(), Math.min(WidgetChatListAdapterItemSpotifyListenTogether.MAX_USERS_SHOWN, maxSize)).iterator();
                while (it.hasNext()) {
                    mutableList.add(CollapsedUser.INSTANCE.createEmptyUser(((Iterators5) it).nextLong() == 5 ? maxSize - WidgetChatListAdapterItemSpotifyListenTogether.MAX_USERS_SHOWN : 0L));
                }
                return new Model(presence, mutableList, item, isMe);
            }

            public final Observable<Model> get(final SpotifyListenTogetherEntry item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getPresences().observePresenceForUser(item.getUserId()), companion.getGameParty().observeUsersForPartyId(item.getActivity().getPartyId()), companion.getUsers().observeMeId(), new Func3<Presence, Map<Long, ? extends User>, Long, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion$get$1
                    @Override // rx.functions.Func3
                    public final WidgetChatListAdapterItemSpotifyListenTogether.Model call(Presence presence, Map<Long, ? extends User> map, Long l) {
                        WidgetChatListAdapterItemSpotifyListenTogether.Model.Companion companion2 = WidgetChatListAdapterItemSpotifyListenTogether.Model.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(map, "userMap");
                        SpotifyListenTogetherEntry spotifyListenTogetherEntry = item;
                        return companion2.create(presence, map, spotifyListenTogetherEntry, l != null && l.longValue() == spotifyListenTogetherEntry.getUserId());
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n             …m.userId)\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Presence presence, List<CollapsedUser> list, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "users");
            Intrinsics3.checkNotNullParameter(spotifyListenTogetherEntry, "item");
            this.presence = presence;
            this.users = list;
            this.item = spotifyListenTogetherEntry;
            this.isMe = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Presence presence, List list, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                presence = model.presence;
            }
            if ((i & 2) != 0) {
                list = model.users;
            }
            if ((i & 4) != 0) {
                spotifyListenTogetherEntry = model.item;
            }
            if ((i & 8) != 0) {
                z2 = model.isMe;
            }
            return model.copy(presence, list, spotifyListenTogetherEntry, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        public final List<CollapsedUser> component2() {
            return this.users;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final SpotifyListenTogetherEntry getItem() {
            return this.item;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        public final Model copy(Presence presence, List<CollapsedUser> users, SpotifyListenTogetherEntry item, boolean isMe) {
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(item, "item");
            return new Model(presence, users, item, isMe);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.presence, model.presence) && Intrinsics3.areEqual(this.users, model.users) && Intrinsics3.areEqual(this.item, model.item) && this.isMe == model.isMe;
        }

        public final SpotifyListenTogetherEntry getItem() {
            return this.item;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        public final List<CollapsedUser> getUsers() {
            return this.users;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Presence presence = this.presence;
            int iHashCode = (presence != null ? presence.hashCode() : 0) * 31;
            List<CollapsedUser> list = this.users;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            SpotifyListenTogetherEntry spotifyListenTogetherEntry = this.item;
            int iHashCode3 = (iHashCode2 + (spotifyListenTogetherEntry != null ? spotifyListenTogetherEntry.hashCode() : 0)) * 31;
            boolean z2 = this.isMe;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(presence=");
            sbU.append(this.presence);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", item=");
            sbU.append(this.item);
            sbU.append(", isMe=");
            return outline.O(sbU, this.isMe, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemSpotifyListenTogether.this.subscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetChatListAdapterItemSpotifyListenTogether.this.configureUI(model);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSpotifyListenTogether(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_spotify_listen_together, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.barrier;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier);
        if (barrier != null) {
            i = R.id.item_listen_together_album_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_listen_together_album_image);
            if (simpleDraweeView != null) {
                i = R.id.item_listen_together_artist;
                TextView textView = (TextView) view.findViewById(R.id.item_listen_together_artist);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.item_listen_together_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.item_listen_together_header);
                    if (textView2 != null) {
                        i = R.id.item_listen_together_join;
                        TextView textView3 = (TextView) view.findViewById(R.id.item_listen_together_join);
                        if (textView3 != null) {
                            i = R.id.item_listen_together_recycler;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.item_listen_together_recycler);
                            if (recyclerView != null) {
                                i = R.id.item_listen_together_session_ended;
                                TextView textView4 = (TextView) view.findViewById(R.id.item_listen_together_session_ended);
                                if (textView4 != null) {
                                    i = R.id.item_listen_together_track;
                                    TextView textView5 = (TextView) view.findViewById(R.id.item_listen_together_track);
                                    if (textView5 != null) {
                                        WidgetChatListAdapterItemSpotifyListenTogetherBinding widgetChatListAdapterItemSpotifyListenTogetherBinding = new WidgetChatListAdapterItemSpotifyListenTogetherBinding(constraintLayout, barrier, simpleDraweeView, textView, constraintLayout, textView2, textView3, recyclerView, textView4, textView5);
                                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemSpotifyListenTogetherBinding, "WidgetChatListAdapterIte…herBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemSpotifyListenTogetherBinding;
                                        this.userAdapter = LazyJVM.lazy(new WidgetChatListAdapterItemSpotifyListenTogether3(this));
                                        return;
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

    private final void configureUI(final Model model) {
        String largeImage;
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemListenTogetherHeader");
        textView.setText(FormatUtils.b(outline.I(this.binding.e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), R.string.invite_embed_invite_to_listen, new Object[]{getActivityName(outline.I(this.binding.e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), model.getItem())}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        boolean zIsDeadInvite = isDeadInvite(model.getPresence(), model.getItem());
        Presence presence = model.getPresence();
        final Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
        TextView textView2 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemListenTogetherSessionEnded");
        textView2.setVisibility(zIsDeadInvite ? 0 : 8);
        RecyclerView recyclerView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemListenTogetherRecycler");
        recyclerView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView3 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemListenTogetherTrack");
        textView3.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView4 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemListenTogetherArtist");
        textView4.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        SimpleDraweeView simpleDraweeView = this.binding.f2331b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.itemListenTogetherContainer");
        constraintLayout.setSelected(true);
        if (zIsDeadInvite) {
            return;
        }
        getUserAdapter().setData(model.getUsers());
        TextView textView5 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.itemListenTogetherTrack");
        textView5.setText(spotifyListeningActivity != null ? spotifyListeningActivity.getDetails() : null);
        TextView textView6 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.itemListenTogetherArtist");
        Object[] objArr = new Object[1];
        objArr[0] = spotifyListeningActivity != null ? spotifyListeningActivity.getState() : null;
        FormatUtils.m(textView6, R.string.user_activity_listening_artists, objArr, (4 & 4) != 0 ? FormatUtils.g.j : null);
        ActivityAssets assets = spotifyListeningActivity != null ? spotifyListeningActivity.getAssets() : null;
        if (assets != null && (largeImage = assets.getLargeImage()) != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f2331b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemListenTogetherAlbumImage");
            MGImages.setImage$default(simpleDraweeView2, IconUtils.getAssetImage$default(IconUtils.INSTANCE, null, largeImage, 0, 4, null), 0, 0, false, null, null, 124, null);
        }
        SimpleDraweeView simpleDraweeView3 = this.binding.f2331b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView3.setContentDescription(assets != null ? assets.getLargeText() : null);
        this.binding.h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyHelper.INSTANCE.launchTrack(outline.x(view, "it", "it.context"), spotifyListeningActivity);
            }
        });
        this.binding.f2331b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyHelper.INSTANCE.launchAlbum(outline.x(view, "it", "it.context"), spotifyListeningActivity, model.getItem().getUserId(), model.isMe());
            }
        });
    }

    private final String getActivityName(Context context, SpotifyListenTogetherEntry spotifyListenTogetherEntry) {
        String partyId = spotifyListenTogetherEntry.getActivity().getPartyId();
        Platform platform = Platform.SPOTIFY;
        if (Strings4.contains((CharSequence) partyId, (CharSequence) platform.getPlatformId(), true)) {
            return platform.getProperName();
        }
        String string = context.getString(R.string.form_label_desktop_only);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri….form_label_desktop_only)");
        return string;
    }

    private final WidgetCollapsedUsersListAdapter getUserAdapter() {
        return (WidgetCollapsedUsersListAdapter) this.userAdapter.getValue();
    }

    private final boolean isDeadInvite(Presence presence, SpotifyListenTogetherEntry item) {
        ActivityParty party;
        String id2;
        Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
        return !((spotifyListeningActivity == null || (party = spotifyListeningActivity.getParty()) == null || (id2 = party.getId()) == null) ? false : id2.equals(item.getActivity().getPartyId())) || TimeUtils.parseSnowflake(Long.valueOf(item.getMessageId())) + EMBED_LIFETIME_MILLIS < ClockFactory.get().currentTimeMillis();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(Model.INSTANCE.get((SpotifyListenTogetherEntry) data)), (Class<?>) WidgetChatListAdapterItemSpotifyListenTogether.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
