package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.databinding.WidgetChatListAdapterItemSpotifyListenTogetherBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g;
import d0.g0.w;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether extends WidgetChatListItem {
    public static final WidgetChatListAdapterItemSpotifyListenTogether$Companion Companion = new WidgetChatListAdapterItemSpotifyListenTogether$Companion(null);
    private static final long EMBED_LIFETIME_MILLIS = 7200000;
    private static final long MAX_USERS_SHOWN = 6;
    private final WidgetChatListAdapterItemSpotifyListenTogetherBinding binding;
    private Subscription subscription;

    /* JADX INFO: renamed from: userAdapter$delegate, reason: from kotlin metadata */
    private final Lazy userAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSpotifyListenTogether(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_spotify_listen_together, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = 2131362146;
        Barrier barrier = (Barrier) view.findViewById(2131362146);
        if (barrier != null) {
            i = R$id.item_listen_together_album_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.item_listen_together_album_image);
            if (simpleDraweeView != null) {
                i = R$id.item_listen_together_artist;
                TextView textView = (TextView) view.findViewById(R$id.item_listen_together_artist);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R$id.item_listen_together_header;
                    TextView textView2 = (TextView) view.findViewById(R$id.item_listen_together_header);
                    if (textView2 != null) {
                        i = R$id.item_listen_together_join;
                        TextView textView3 = (TextView) view.findViewById(R$id.item_listen_together_join);
                        if (textView3 != null) {
                            i = R$id.item_listen_together_recycler;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.item_listen_together_recycler);
                            if (recyclerView != null) {
                                i = R$id.item_listen_together_session_ended;
                                TextView textView4 = (TextView) view.findViewById(R$id.item_listen_together_session_ended);
                                if (textView4 != null) {
                                    i = R$id.item_listen_together_track;
                                    TextView textView5 = (TextView) view.findViewById(R$id.item_listen_together_track);
                                    if (textView5 != null) {
                                        WidgetChatListAdapterItemSpotifyListenTogetherBinding widgetChatListAdapterItemSpotifyListenTogetherBinding = new WidgetChatListAdapterItemSpotifyListenTogetherBinding(constraintLayout, barrier, simpleDraweeView, textView, constraintLayout, textView2, textView3, recyclerView, textView4, textView5);
                                        m.checkNotNullExpressionValue(widgetChatListAdapterItemSpotifyListenTogetherBinding, "WidgetChatListAdapterIte…herBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemSpotifyListenTogetherBinding;
                                        this.userAdapter = g.lazy(new WidgetChatListAdapterItemSpotifyListenTogether$userAdapter$2(this));
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

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether, WidgetChatListAdapterItemSpotifyListenTogether$Model widgetChatListAdapterItemSpotifyListenTogether$Model) {
        widgetChatListAdapterItemSpotifyListenTogether.configureUI(widgetChatListAdapterItemSpotifyListenTogether$Model);
    }

    public static final /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogetherBinding access$getBinding$p(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether) {
        return widgetChatListAdapterItemSpotifyListenTogether.binding;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether) {
        return widgetChatListAdapterItemSpotifyListenTogether.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether, Subscription subscription) {
        widgetChatListAdapterItemSpotifyListenTogether.subscription = subscription;
    }

    private final void configureUI(WidgetChatListAdapterItemSpotifyListenTogether$Model widgetChatListAdapterItemSpotifyListenTogether$Model) {
        String largeImage;
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.itemListenTogetherHeader");
        textView.setText(b.h(a.I(this.binding.e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), 2131892263, new Object[]{getActivityName(a.I(this.binding.e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), widgetChatListAdapterItemSpotifyListenTogether$Model.getItem())}, null, 4));
        boolean zIsDeadInvite = isDeadInvite(widgetChatListAdapterItemSpotifyListenTogether$Model.getPresence(), widgetChatListAdapterItemSpotifyListenTogether$Model.getItem());
        Presence presence = widgetChatListAdapterItemSpotifyListenTogether$Model.getPresence();
        Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
        TextView textView2 = this.binding.g;
        m.checkNotNullExpressionValue(textView2, "binding.itemListenTogetherSessionEnded");
        textView2.setVisibility(zIsDeadInvite ? 0 : 8);
        RecyclerView recyclerView = this.binding.f;
        m.checkNotNullExpressionValue(recyclerView, "binding.itemListenTogetherRecycler");
        recyclerView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView3 = this.binding.h;
        m.checkNotNullExpressionValue(textView3, "binding.itemListenTogetherTrack");
        textView3.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView4 = this.binding.c;
        m.checkNotNullExpressionValue(textView4, "binding.itemListenTogetherArtist");
        textView4.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        SimpleDraweeView simpleDraweeView = this.binding.f2331b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = this.binding.d;
        m.checkNotNullExpressionValue(constraintLayout, "binding.itemListenTogetherContainer");
        constraintLayout.setSelected(true);
        if (zIsDeadInvite) {
            return;
        }
        getUserAdapter().setData(widgetChatListAdapterItemSpotifyListenTogether$Model.getUsers());
        TextView textView5 = this.binding.h;
        m.checkNotNullExpressionValue(textView5, "binding.itemListenTogetherTrack");
        textView5.setText(spotifyListeningActivity != null ? spotifyListeningActivity.getDetails() : null);
        TextView textView6 = this.binding.c;
        m.checkNotNullExpressionValue(textView6, "binding.itemListenTogetherArtist");
        Object[] objArr = new Object[1];
        objArr[0] = spotifyListeningActivity != null ? spotifyListeningActivity.getState() : null;
        b.n(textView6, 2131896737, objArr, null, 4);
        ActivityAssets assets = spotifyListeningActivity != null ? spotifyListeningActivity.getAssets() : null;
        if (assets != null && (largeImage = assets.getLargeImage()) != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f2331b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemListenTogetherAlbumImage");
            MGImages.setImage$default(simpleDraweeView2, IconUtils.getAssetImage$default(IconUtils.INSTANCE, null, largeImage, 0, 4, null), 0, 0, false, null, null, 124, null);
        }
        SimpleDraweeView simpleDraweeView3 = this.binding.f2331b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView3.setContentDescription(assets != null ? assets.getLargeText() : null);
        this.binding.h.setOnClickListener(new WidgetChatListAdapterItemSpotifyListenTogether$configureUI$2(spotifyListeningActivity));
        this.binding.f2331b.setOnClickListener(new WidgetChatListAdapterItemSpotifyListenTogether$configureUI$3(widgetChatListAdapterItemSpotifyListenTogether$Model, spotifyListeningActivity));
    }

    private final String getActivityName(Context context, SpotifyListenTogetherEntry spotifyListenTogetherEntry) {
        String partyId = spotifyListenTogetherEntry.getActivity().getPartyId();
        Platform platform = Platform.SPOTIFY;
        if (w.contains((CharSequence) partyId, (CharSequence) platform.getPlatformId(), true)) {
            return platform.getProperName();
        }
        String string = context.getString(2131889160);
        m.checkNotNullExpressionValue(string, "context.getString(R.stri….form_label_desktop_only)");
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

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(WidgetChatListAdapterItemSpotifyListenTogether$Model.Companion.get((SpotifyListenTogetherEntry) data)), WidgetChatListAdapterItemSpotifyListenTogether.class, (Context) null, new WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$2(this), 58, (Object) null);
    }
}
