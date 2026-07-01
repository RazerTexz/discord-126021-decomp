package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import b.a.y.o0.d$a;
import b.a.y.o0.d$b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.stageinstance.StageInstance;
import com.discord.databinding.WidgetChatListAdapterItemStageInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.stages.StageCardSpeakersView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StageInviteEntry;
import com.discord.widgets.stage.StageCardSpeaker;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStageInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemStageInviteBinding binding;
    private String iconUrl;
    private Job inviteJoinJob;
    private StageInviteEntry item;
    private Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStageInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_stage_invite, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.item_invite_channel_topic;
        TextView textView = (TextView) view.findViewById(R$id.item_invite_channel_topic);
        if (textView != null) {
            i = R$id.item_invite_guild_name;
            TextView textView2 = (TextView) view.findViewById(R$id.item_invite_guild_name);
            if (textView2 != null) {
                i = R$id.item_invite_header;
                TextView textView3 = (TextView) view.findViewById(R$id.item_invite_header);
                if (textView3 != null) {
                    i = R$id.item_invite_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.item_invite_image);
                    if (simpleDraweeView != null) {
                        i = R$id.item_invite_image_text;
                        TextView textView4 = (TextView) view.findViewById(R$id.item_invite_image_text);
                        if (textView4 != null) {
                            i = R$id.item_invite_join_button;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.item_invite_join_button);
                            if (materialButton != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i = R$id.item_listeners_count;
                                TextView textView5 = (TextView) view.findViewById(R$id.item_listeners_count);
                                if (textView5 != null) {
                                    i = R$id.stage_discovery_speakers_view;
                                    StageCardSpeakersView stageCardSpeakersView = (StageCardSpeakersView) view.findViewById(R$id.stage_discovery_speakers_view);
                                    if (stageCardSpeakersView != null) {
                                        WidgetChatListAdapterItemStageInviteBinding widgetChatListAdapterItemStageInviteBinding = new WidgetChatListAdapterItemStageInviteBinding(constraintLayout, textView, textView2, textView3, simpleDraweeView, textView4, materialButton, constraintLayout, textView5, stageCardSpeakersView);
                                        m.checkNotNullExpressionValue(widgetChatListAdapterItemStageInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemStageInviteBinding;
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

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite, WidgetChatListAdapterItemStageInvite$Model widgetChatListAdapterItemStageInvite$Model) {
        widgetChatListAdapterItemStageInvite.configureUI(widgetChatListAdapterItemStageInvite$Model);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStageInvite.adapter;
    }

    public static final /* synthetic */ Job access$getInviteJoinJob$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        return widgetChatListAdapterItemStageInvite.inviteJoinJob;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        return widgetChatListAdapterItemStageInvite.subscription;
    }

    public static final /* synthetic */ void access$setInviteJoinJob$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite, Job job) {
        widgetChatListAdapterItemStageInvite.inviteJoinJob = job;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite, Subscription subscription) {
        widgetChatListAdapterItemStageInvite.subscription = subscription;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    private final void configureUI(WidgetChatListAdapterItemStageInvite$Model model) {
        boolean z2;
        Guild guild;
        String name;
        String name2;
        String topic;
        String icon;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Guild guild2 = model.getInvite().guild;
        Long lValueOf = guild2 != null ? Long.valueOf(guild2.getId()) : null;
        Guild guild3 = model.getInvite().guild;
        updateIconUrlIfChanged(IconUtils.getForGuild$default(lValueOf, guild3 != null ? guild3.getIcon() : null, IconUtils.DEFAULT_ICON_BLURPLE, model.getShouldAnimateGuildIcon(), null, 16, null));
        Guild guild4 = model.getInvite().guild;
        int i = 0;
        if (guild4 == null || (icon = guild4.getIcon()) == null) {
            z2 = false;
        } else if (icon.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.itemInviteImageText");
        ViewExtensions.setTextAndVisibilityBy(textView, (z2 || (guild = model.getInvite().guild) == null || (name = guild.getName()) == null) ? null : GuildUtilsKt.computeShortName(name));
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.itemInviteGuildName");
        Guild guild5 = model.getInvite().guild;
        if (guild5 == null || (name2 = guild5.getName()) == null) {
            Channel channel = model.getChannel();
            name2 = channel != null ? channel.getName() : null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView2, name2);
        TextView textView3 = this.binding.f2332b;
        m.checkNotNullExpressionValue(textView3, "binding.itemInviteChannelTopic");
        StageInstance stageInstance = model.getStageInstance();
        if (stageInstance == null || (topic = stageInstance.getTopic()) == null) {
            Channel channel2 = model.getChannel();
            topic = channel2 != null ? channel2.getTopic() : null;
        }
        if (topic == null) {
            Channel channel3 = model.getChannel();
            topic = channel3 != null ? channel3.getName() : null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, topic);
        TextView textView4 = this.binding.g;
        m.checkNotNullExpressionValue(textView4, "binding.itemListenersCount");
        Integer listenersCount = model.getListenersCount();
        ViewExtensions.setTextAndVisibilityBy(textView4, listenersCount != null ? String.valueOf(listenersCount.intValue()) : null);
        StageCardSpeakersView stageCardSpeakersView = this.binding.h;
        List<StageCardSpeaker> speakers = model.getSpeakers();
        RecyclerView$ItemDecoration recyclerView$ItemDecoration = StageCardSpeakersView.j;
        int size = speakers.size();
        Objects.requireNonNull(stageCardSpeakersView);
        m.checkNotNullParameter(speakers, "speakers");
        List listTake = u.take(speakers, 3);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listTake, 10));
        for (Object obj : listTake) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            StageCardSpeaker stageCardSpeaker = (StageCardSpeaker) obj;
            User user = stageCardSpeaker.getUser();
            GuildMember guildMember = stageCardSpeaker.getGuildMember();
            String displayName = stageCardSpeaker.getDisplayName();
            StringBuilder sb = new StringBuilder();
            sb.append(size);
            sb.append('-');
            sb.append(i);
            arrayList.add(new d$a(user, guildMember, displayName, sb.toString()));
            i = i2;
        }
        int size2 = size - arrayList.size();
        m.checkNotNullParameter(arrayList, "speakersToDisplay");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        if (size2 > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(size);
            sb2.append('-');
            sb2.append(arrayList.size() + 1);
            arrayList2.add(new d$b(size2, sb2.toString()));
        }
        stageCardSpeakersView.speakersAdapter.setData(arrayList2);
        this.binding.f.setOnClickListener(new WidgetChatListAdapterItemStageInvite$configureUI$2(this, model, context));
    }

    private final void updateIconUrlIfChanged(String iconUrl) {
        if (!m.areEqual(this.iconUrl, iconUrl)) {
            SimpleDraweeView simpleDraweeView = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteImage");
            IconUtils.setIcon$default(simpleDraweeView, iconUrl, 2131165293, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
            this.iconUrl = iconUrl;
        }
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
        this.item = (StageInviteEntry) data;
        StoreInstantInvites instantInvites = StoreStream.Companion.getInstantInvites();
        StageInviteEntry stageInviteEntry = this.item;
        if (stageInviteEntry == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        StoreInstantInvites.fetchInviteIfNotLoaded$default(instantInvites, stageInviteEntry.getInviteCode(), null, "Invite Button Embed", null, null, 26, null);
        WidgetChatListAdapterItemStageInvite$Model$Companion widgetChatListAdapterItemStageInvite$Model$Companion = WidgetChatListAdapterItemStageInvite$Model.Companion;
        StageInviteEntry stageInviteEntry2 = this.item;
        if (stageInviteEntry2 == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        Observable observableG = ObservableExtensionsKt.ui(WidgetChatListAdapterItemStageInvite$Model$Companion.observe$default(widgetChatListAdapterItemStageInvite$Model$Companion, stageInviteEntry2, null, null, null, null, null, null, null, null, 510, null)).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetChatListAdapterItemStageInvite.class, (Context) null, new WidgetChatListAdapterItemStageInvite$onConfigure$2(this), (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterItemStageInvite$onConfigure$1(this), 58, (Object) null);
    }
}
