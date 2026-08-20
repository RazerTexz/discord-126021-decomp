package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import com.facebook.drawee.view.SimpleDraweeView;
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
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12106w;
import p507d0.p580t.AbstractC12128d0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

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
                C12238m.checkNotNullExpressionValue(collectionValues, "collapsedUserMap.values");
                List mutableList = C12163u.toMutableList(collectionValues);
                Iterator<Long> it = C11226f.until(userMap.size(), Math.min(WidgetChatListAdapterItemSpotifyListenTogether.MAX_USERS_SHOWN, maxSize)).iterator();
                while (it.hasNext()) {
                    mutableList.add(CollapsedUser.INSTANCE.createEmptyUser(((AbstractC12128d0) it).nextLong() == 5 ? maxSize - WidgetChatListAdapterItemSpotifyListenTogether.MAX_USERS_SHOWN : 0L));
                }
                return new Model(presence, mutableList, item, isMe);
            }

            public final Observable<Model> get(final SpotifyListenTogetherEntry item) {
                C12238m.checkNotNullParameter(item, "item");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11075i = Observable.m11075i(companion.getPresences().observePresenceForUser(item.getUserId()), companion.getGameParty().observeUsersForPartyId(item.getActivity().getPartyId()), companion.getUsers().observeMeId(), new Func3<Presence, Map<Long, ? extends User>, Long, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion$get$1
                    @Override // p658rx.functions.Func3
                    public final WidgetChatListAdapterItemSpotifyListenTogether.Model call(Presence presence, Map<Long, ? extends User> map, Long l) {
                        WidgetChatListAdapterItemSpotifyListenTogether.Model.Companion companion2 = WidgetChatListAdapterItemSpotifyListenTogether.Model.INSTANCE;
                        C12238m.checkNotNullExpressionValue(map, "userMap");
                        SpotifyListenTogetherEntry spotifyListenTogetherEntry = item;
                        return companion2.create(presence, map, spotifyListenTogetherEntry, l != null && l.longValue() == spotifyListenTogetherEntry.getUserId());
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11075i, "Observable\n             …m.userId)\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n             …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Presence presence, List<CollapsedUser> list, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2) {
            C12238m.checkNotNullParameter(list, "users");
            C12238m.checkNotNullParameter(spotifyListenTogetherEntry, "item");
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
            C12238m.checkNotNullParameter(users, "users");
            C12238m.checkNotNullParameter(item, "item");
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
            return C12238m.areEqual(this.presence, model.presence) && C12238m.areEqual(this.users, model.users) && C12238m.areEqual(this.item, model.item) && this.isMe == model.isMe;
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
            StringBuilder sbM833U = C1643a.m833U("Model(presence=");
            sbM833U.append(this.presence);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", item=");
            sbM833U.append(this.item);
            sbM833U.append(", isMe=");
            return C1643a.m827O(sbM833U, this.isMe, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    public static final class C81181 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C81181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemSpotifyListenTogether.this.subscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    public static final class C81192 extends AbstractC12240o implements Function1<Model, Unit> {
        public C81192() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "it");
            WidgetChatListAdapterItemSpotifyListenTogether.this.configureUI(model);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSpotifyListenTogether(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_spotify_listen_together, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.barrier;
        Barrier barrier = (Barrier) view.findViewById(C5419R.id.barrier);
        if (barrier != null) {
            i = C5419R.id.item_listen_together_album_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.item_listen_together_album_image);
            if (simpleDraweeView != null) {
                i = C5419R.id.item_listen_together_artist;
                TextView textView = (TextView) view.findViewById(C5419R.id.item_listen_together_artist);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = C5419R.id.item_listen_together_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.item_listen_together_header);
                    if (textView2 != null) {
                        i = C5419R.id.item_listen_together_join;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.item_listen_together_join);
                        if (textView3 != null) {
                            i = C5419R.id.item_listen_together_recycler;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.item_listen_together_recycler);
                            if (recyclerView != null) {
                                i = C5419R.id.item_listen_together_session_ended;
                                TextView textView4 = (TextView) view.findViewById(C5419R.id.item_listen_together_session_ended);
                                if (textView4 != null) {
                                    i = C5419R.id.item_listen_together_track;
                                    TextView textView5 = (TextView) view.findViewById(C5419R.id.item_listen_together_track);
                                    if (textView5 != null) {
                                        WidgetChatListAdapterItemSpotifyListenTogetherBinding widgetChatListAdapterItemSpotifyListenTogetherBinding = new WidgetChatListAdapterItemSpotifyListenTogetherBinding(constraintLayout, barrier, simpleDraweeView, textView, constraintLayout, textView2, textView3, recyclerView, textView4, textView5);
                                        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemSpotifyListenTogetherBinding, "WidgetChatListAdapterIte…herBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemSpotifyListenTogetherBinding;
                                        this.userAdapter = C12083g.lazy(new WidgetChatListAdapterItemSpotifyListenTogether$userAdapter$2(this));
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
        TextView textView = this.binding.f16278e;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemListenTogetherHeader");
        textView.setText(C1107b.m216h(C1643a.m821I(this.binding.f16278e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), C5419R.string.invite_embed_invite_to_listen, new Object[]{getActivityName(C1643a.m821I(this.binding.f16278e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), model.getItem())}, null, 4));
        boolean zIsDeadInvite = isDeadInvite(model.getPresence(), model.getItem());
        Presence presence = model.getPresence();
        final Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
        TextView textView2 = this.binding.f16280g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemListenTogetherSessionEnded");
        textView2.setVisibility(zIsDeadInvite ? 0 : 8);
        RecyclerView recyclerView = this.binding.f16279f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.itemListenTogetherRecycler");
        recyclerView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView3 = this.binding.f16281h;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemListenTogetherTrack");
        textView3.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView4 = this.binding.f16276c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.itemListenTogetherArtist");
        textView4.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        SimpleDraweeView simpleDraweeView = this.binding.f16275b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = this.binding.f16277d;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.itemListenTogetherContainer");
        constraintLayout.setSelected(true);
        if (zIsDeadInvite) {
            return;
        }
        getUserAdapter().setData(model.getUsers());
        TextView textView5 = this.binding.f16281h;
        C12238m.checkNotNullExpressionValue(textView5, "binding.itemListenTogetherTrack");
        textView5.setText(spotifyListeningActivity != null ? spotifyListeningActivity.getDetails() : null);
        TextView textView6 = this.binding.f16276c;
        C12238m.checkNotNullExpressionValue(textView6, "binding.itemListenTogetherArtist");
        Object[] objArr = new Object[1];
        objArr[0] = spotifyListeningActivity != null ? spotifyListeningActivity.getState() : null;
        C1107b.m221m(textView6, C5419R.string.user_activity_listening_artists, objArr, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        ActivityAssets assets = spotifyListeningActivity != null ? spotifyListeningActivity.getAssets() : null;
        if (assets != null && (largeImage = assets.getLargeImage()) != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f16275b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemListenTogetherAlbumImage");
            MGImages.setImage$default(simpleDraweeView2, IconUtils.getAssetImage$default(IconUtils.INSTANCE, null, largeImage, 0, 4, null), 0, 0, false, null, null, 124, null);
        }
        SimpleDraweeView simpleDraweeView3 = this.binding.f16275b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView3.setContentDescription(assets != null ? assets.getLargeText() : null);
        this.binding.f16281h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyHelper.INSTANCE.launchTrack(C1643a.m885x(view, "it", "it.context"), spotifyListeningActivity);
            }
        });
        this.binding.f16275b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyHelper.INSTANCE.launchAlbum(C1643a.m885x(view, "it", "it.context"), spotifyListeningActivity, model.getItem().getUserId(), model.isMe());
            }
        });
    }

    private final String getActivityName(Context context, SpotifyListenTogetherEntry spotifyListenTogetherEntry) {
        String partyId = spotifyListenTogetherEntry.getActivity().getPartyId();
        Platform platform = Platform.SPOTIFY;
        if (C12106w.contains((CharSequence) partyId, (CharSequence) platform.getPlatformId(), true)) {
            return platform.getProperName();
        }
        String string = context.getString(C5419R.string.form_label_desktop_only);
        C12238m.checkNotNullExpressionValue(string, "context.getString(R.stri….form_label_desktop_only)");
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
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(Model.INSTANCE.get((SpotifyListenTogetherEntry) data)), (Class<?>) WidgetChatListAdapterItemSpotifyListenTogether.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C81181()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81192());
    }
}
