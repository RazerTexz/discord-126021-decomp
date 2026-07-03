package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.databinding.WidgetChatListAdapterItemInviteBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guilds.ServerMemberCount;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.InviteEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.hubs.HubEmailArgs;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemInviteBinding binding;
    private String iconUrl;
    private InviteEntry item;
    private Subscription subscription;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
    public static abstract class Model {

        /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
        public static final /* data */ class Invalid extends Model {
            private final User authorUser;
            private final Channel channel;
            private final long meId;

            public Invalid(User user, long j, Channel channel) {
                super(null);
                this.authorUser = user;
                this.meId = j;
                this.channel = channel;
            }

            public static /* synthetic */ Invalid copy$default(Invalid invalid, User user, long j, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = invalid.authorUser;
                }
                if ((i & 2) != 0) {
                    j = invalid.meId;
                }
                if ((i & 4) != 0) {
                    channel = invalid.channel;
                }
                return invalid.copy(user, j, channel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final User getAuthorUser() {
                return this.authorUser;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getMeId() {
                return this.meId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Invalid copy(User authorUser, long meId, Channel channel) {
                return new Invalid(authorUser, meId, channel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invalid)) {
                    return false;
                }
                Invalid invalid = (Invalid) other;
                return C12238m.areEqual(this.authorUser, invalid.authorUser) && this.meId == invalid.meId && C12238m.areEqual(this.channel, invalid.channel);
            }

            public final User getAuthorUser() {
                return this.authorUser;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final long getMeId() {
                return this.meId;
            }

            public int hashCode() {
                User user = this.authorUser;
                int iM3a = (C0002b.m3a(this.meId) + ((user != null ? user.hashCode() : 0) * 31)) * 31;
                Channel channel = this.channel;
                return iM3a + (channel != null ? channel.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Invalid(authorUser=");
                sbM833U.append(this.authorUser);
                sbM833U.append(", meId=");
                sbM833U.append(this.meId);
                sbM833U.append(", channel=");
                sbM833U.append(this.channel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
        public static final /* data */ class Resolved extends Model {
            private final User authorUser;
            private final Channel channel;
            private final ModelInvite invite;
            private final boolean isMemberOfGuild;
            private final long meId;
            private final boolean shouldAnimateGuildIcon;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelInvite modelInvite, long j, User user, boolean z2, Channel channel, boolean z3) {
                super(null);
                C12238m.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
                this.meId = j;
                this.authorUser = user;
                this.isMemberOfGuild = z2;
                this.channel = channel;
                this.shouldAnimateGuildIcon = z3;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelInvite modelInvite, long j, User user, boolean z2, Channel channel, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = resolved.invite;
                }
                if ((i & 2) != 0) {
                    j = resolved.meId;
                }
                long j2 = j;
                if ((i & 4) != 0) {
                    user = resolved.authorUser;
                }
                User user2 = user;
                if ((i & 8) != 0) {
                    z2 = resolved.isMemberOfGuild;
                }
                boolean z4 = z2;
                if ((i & 16) != 0) {
                    channel = resolved.channel;
                }
                Channel channel2 = channel;
                if ((i & 32) != 0) {
                    z3 = resolved.shouldAnimateGuildIcon;
                }
                return resolved.copy(modelInvite, j2, user2, z4, channel2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getMeId() {
                return this.meId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final User getAuthorUser() {
                return this.authorUser;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsMemberOfGuild() {
                return this.isMemberOfGuild;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getShouldAnimateGuildIcon() {
                return this.shouldAnimateGuildIcon;
            }

            public final Resolved copy(ModelInvite invite, long meId, User authorUser, boolean isMemberOfGuild, Channel channel, boolean shouldAnimateGuildIcon) {
                C12238m.checkNotNullParameter(invite, "invite");
                return new Resolved(invite, meId, authorUser, isMemberOfGuild, channel, shouldAnimateGuildIcon);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Resolved)) {
                    return false;
                }
                Resolved resolved = (Resolved) other;
                return C12238m.areEqual(this.invite, resolved.invite) && this.meId == resolved.meId && C12238m.areEqual(this.authorUser, resolved.authorUser) && this.isMemberOfGuild == resolved.isMemberOfGuild && C12238m.areEqual(this.channel, resolved.channel) && this.shouldAnimateGuildIcon == resolved.shouldAnimateGuildIcon;
            }

            public final User getAuthorUser() {
                return this.authorUser;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final long getMeId() {
                return this.meId;
            }

            public final boolean getShouldAnimateGuildIcon() {
                return this.shouldAnimateGuildIcon;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v11 */
            /* JADX WARN: Type inference failed for: r0v14 */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v6, types: [int] */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                int iM3a = (C0002b.m3a(this.meId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
                User user = this.authorUser;
                int iHashCode = (iM3a + (user != null ? user.hashCode() : 0)) * 31;
                boolean z2 = this.isMemberOfGuild;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = (iHashCode + r0) * 31;
                Channel channel = this.channel;
                int iHashCode2 = (i + (channel != null ? channel.hashCode() : 0)) * 31;
                boolean z3 = this.shouldAnimateGuildIcon;
                return iHashCode2 + (z3 ? 1 : z3);
            }

            public final boolean isMemberOfGuild() {
                return this.isMemberOfGuild;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Resolved(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(", meId=");
                sbM833U.append(this.meId);
                sbM833U.append(", authorUser=");
                sbM833U.append(this.authorUser);
                sbM833U.append(", isMemberOfGuild=");
                sbM833U.append(this.isMemberOfGuild);
                sbM833U.append(", channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", shouldAnimateGuildIcon=");
                return C1643a.m827O(sbM833U, this.shouldAnimateGuildIcon, ")");
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        private final Observable<Model> getInvalidInvite(InviteEntry item) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model> observableM11076j = Observable.m11076j(companion.getUsers().observeMeId(), companion.getUsers().observeUser(item.getUserId()), new Func2<Long, User, Model>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1
                @Override // p658rx.functions.Func2
                public final WidgetChatListAdapterItemInvite.Model call(Long l, User user) {
                    C12238m.checkNotNullExpressionValue(l, "meId");
                    return new WidgetChatListAdapterItemInvite.Model.Invalid(user, l.longValue(), null);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…authorUser, meId, null) }");
            return observableM11076j;
        }

        private final Observable<Model> observeModel(InviteEntry item, ModelInvite invite) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreUser users = companion.getUsers();
            StoreGuilds guilds = companion.getGuilds();
            StoreChannels channels = companion.getChannels();
            StoreAccessibility accessibility = companion.getAccessibility();
            return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{users, guilds, channels, accessibility}, false, null, null, new WidgetChatListAdapterItemInvite$ModelProvider$observeModel$1(users, item, invite, guilds, channels, accessibility), 14, null);
        }

        public final Observable<Model> get(final InviteEntry item) {
            C12238m.checkNotNullParameter(item, "item");
            StoreInstantInvites instantInvites = StoreStream.INSTANCE.getInstantInvites();
            String inviteCode = item.getInviteCode();
            String eventId = item.getEventId();
            Observable observableM11099Y = instantInvites.observeInvite(ModelInvite.getInviteStoreKey(inviteCode, eventId != null ? SnowflakeUtils.INSTANCE.toSnowflake(eventId) : null)).m11099Y(new InterfaceC12589b<StoreInstantInvites.InviteState, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$get$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetChatListAdapterItemInvite.Model> call(StoreInstantInvites.InviteState inviteState) {
                    if ((inviteState instanceof StoreInstantInvites.InviteState.Loading) || (inviteState instanceof StoreInstantInvites.InviteState.LoadFailed)) {
                        return new C12721k(WidgetChatListAdapterItemInvite.Model.Loading.INSTANCE);
                    }
                    return inviteState instanceof StoreInstantInvites.InviteState.Resolved ? WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE.observeModel(item, ((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE.getInvalidInvite(item);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…tes\n          }\n        }");
            return observableM11099Y;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$configureResolvedUI$4 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
    public static final class C80924 extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$configureResolvedUI$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                WidgetChatListAdapterItemInvite.this.launchHubsEmail(new HubEmailArgs(null, 0, null, 7, null));
            }
        }

        public C80924() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onClick", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
    public static final /* synthetic */ class C80931 extends C12236k implements Function1<Model, Unit> {
        public C80931(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
            super(1, widgetChatListAdapterItemInvite, WidgetChatListAdapterItemInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemInvite) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
    public static final class C80942 extends AbstractC12240o implements Function1<Error, Unit> {
        public C80942() {
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
            WidgetChatListAdapterItemInvite.this.configureInvalidUI(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$onConfigure$3 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
    public static final class C80953 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C80953() {
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
            WidgetChatListAdapterItemInvite.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_invite, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.barrier_button;
        Barrier barrier = (Barrier) view.findViewById(C5419R.id.barrier_button);
        if (barrier != null) {
            i = C5419R.id.barrier_header;
            Barrier barrier2 = (Barrier) view.findViewById(C5419R.id.barrier_header);
            if (barrier2 != null) {
                i = C5419R.id.item_invite_button_layout;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.item_invite_button_layout);
                if (frameLayout != null) {
                    i = C5419R.id.item_invite_channel_name;
                    TextView textView = (TextView) view.findViewById(C5419R.id.item_invite_channel_name);
                    if (textView != null) {
                        i = C5419R.id.item_invite_header;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.item_invite_header);
                        if (textView2 != null) {
                            i = C5419R.id.item_invite_hub_layout;
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(C5419R.id.item_invite_hub_layout);
                            if (frameLayout2 != null) {
                                i = C5419R.id.item_invite_hub_link;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.item_invite_hub_link);
                                if (linkifiedTextView != null) {
                                    i = C5419R.id.item_invite_image;
                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.item_invite_image);
                                    if (simpleDraweeView != null) {
                                        i = C5419R.id.item_invite_image_text;
                                        TextView textView3 = (TextView) view.findViewById(C5419R.id.item_invite_image_text);
                                        if (textView3 != null) {
                                            i = C5419R.id.item_invite_join_button;
                                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.item_invite_join_button);
                                            if (materialButton != null) {
                                                i = C5419R.id.item_invite_joined_button;
                                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.item_invite_joined_button);
                                                if (materialButton2 != null) {
                                                    i = C5419R.id.item_invite_loading_button;
                                                    View viewFindViewById = view.findViewById(C5419R.id.item_invite_loading_button);
                                                    if (viewFindViewById != null) {
                                                        i = C5419R.id.item_invite_member_container;
                                                        ServerMemberCount serverMemberCount = (ServerMemberCount) view.findViewById(C5419R.id.item_invite_member_container);
                                                        if (serverMemberCount != null) {
                                                            i = C5419R.id.item_invite_mention_button;
                                                            MaterialButton materialButton3 = (MaterialButton) view.findViewById(C5419R.id.item_invite_mention_button);
                                                            if (materialButton3 != null) {
                                                                i = C5419R.id.item_invite_name;
                                                                TextView textView4 = (TextView) view.findViewById(C5419R.id.item_invite_name);
                                                                if (textView4 != null) {
                                                                    i = C5419R.id.item_invite_splash;
                                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.item_invite_splash);
                                                                    if (simpleDraweeView2 != null) {
                                                                        i = C5419R.id.item_invite_splash_container;
                                                                        RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view.findViewById(C5419R.id.item_invite_splash_container);
                                                                        if (roundedRelativeLayout != null) {
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                            WidgetChatListAdapterItemInviteBinding widgetChatListAdapterItemInviteBinding = new WidgetChatListAdapterItemInviteBinding(constraintLayout, barrier, barrier2, frameLayout, textView, textView2, frameLayout2, linkifiedTextView, simpleDraweeView, textView3, materialButton, materialButton2, viewFindViewById, serverMemberCount, materialButton3, textView4, simpleDraweeView2, roundedRelativeLayout, constraintLayout);
                                                                            C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
                                                                            this.binding = widgetChatListAdapterItemInviteBinding;
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

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemInvite.adapter;
    }

    public static final /* synthetic */ InviteEntry access$getItem$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        InviteEntry inviteEntry = widgetChatListAdapterItemInvite.item;
        if (inviteEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        return inviteEntry;
    }

    private final void configureForTextChannel(boolean isGroupDM, ModelInvite invite) {
        ServerMemberCount serverMemberCount = this.binding.f16248k;
        C12238m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(invite.getChannel() != null ? 0 : 8);
        this.binding.f16248k.setOnline(!isGroupDM ? Integer.valueOf(invite.getApproximatePresenceCount()) : null);
        this.binding.f16248k.setMembers(Integer.valueOf(invite.getApproximateMemberCount()));
    }

    private final void configureForVocalChannel(Channel channel, Context context) {
        int themedDrawableRes$default;
        ServerMemberCount serverMemberCount = this.binding.f16248k;
        C12238m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(8);
        TextView textView = this.binding.f16239b;
        int type = channel.getType();
        if (type != 2) {
            themedDrawableRes$default = type != 13 ? 0 : C5419R.drawable.ic_channel_stage_24dp;
        } else {
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, C5419R.attr.ic_volume_up, 0, 2, (Object) null);
        }
        DrawableCompat.setCompoundDrawablesCompat$default(textView, themedDrawableRes$default, 0, 0, 0, 14, (Object) null);
        ViewExtensions.setTextAndVisibilityBy(textView, ChannelUtils.m7680d(channel, context, false));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x00af  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d3  */
    private final void configureInvalidUI(final Model.Invalid model) {
        CharSequence charSequenceM216h;
        User authorUser;
        Channel channel;
        User authorUser2;
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        final Context context = view.getContext();
        Long lValueOf = null;
        final boolean zAreEqual = C12238m.areEqual((model == null || (authorUser2 = model.getAuthorUser()) == null) ? null : Long.valueOf(authorUser2.getId()), model != null ? Long.valueOf(model.getMeId()) : null);
        TextView textView = this.binding.f16240c;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemInviteHeader");
        C1107b.m221m(textView, zAreEqual ? C5419R.string.invite_button_title_inviter_invalid : C5419R.string.invite_button_title_invited_invalid, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = this.binding.f16250m;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemInviteName");
        C1107b.m221m(textView2, C5419R.string.invite_button_invalid, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        this.binding.f16250m.setTextColor(ColorCompat.getColor(context, C5419R.color.status_red_500));
        this.binding.f16250m.setBackgroundResource(0);
        this.binding.f16243f.setActualImageResource(C5419R.drawable.img_wump_trash_dark);
        TextView textView3 = this.binding.f16244g;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemInviteImageText");
        textView3.setVisibility(8);
        boolean z2 = true;
        if (!zAreEqual) {
            if ((model != null ? model.getAuthorUser() : null) != null) {
                C12238m.checkNotNullExpressionValue(context, "context");
                charSequenceM216h = C1107b.m216h(context, C5419R.string.instant_invite_ask_user_for_new_invite, new Object[]{model.getAuthorUser().getUsername()}, null, 4);
            } else if (zAreEqual) {
                if (model != null) {
                    authorUser = model.getAuthorUser();
                } else {
                    authorUser = null;
                }
                if (authorUser == null) {
                    C12238m.checkNotNullExpressionValue(context, "context");
                    charSequenceM216h = C1107b.m216h(context, C5419R.string.instant_invite_ask_for_new_invite, new Object[0], null, 4);
                } else if (zAreEqual) {
                    C12238m.checkNotNullExpressionValue(context, "context");
                    charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_invalid_owner, new Object[0], null, 4);
                } else {
                    charSequenceM216h = null;
                }
            } else if (zAreEqual) {
                C12238m.checkNotNullExpressionValue(context, "context");
                charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_invalid_owner, new Object[0], null, 4);
            } else {
                charSequenceM216h = null;
            }
        } else if (zAreEqual) {
            if (model != null) {
                authorUser = model.getAuthorUser();
            } else {
                authorUser = null;
            }
            if (authorUser == null) {
                C12238m.checkNotNullExpressionValue(context, "context");
                charSequenceM216h = C1107b.m216h(context, C5419R.string.instant_invite_ask_for_new_invite, new Object[0], null, 4);
            } else if (zAreEqual) {
                C12238m.checkNotNullExpressionValue(context, "context");
                charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_invalid_owner, new Object[0], null, 4);
            } else {
                charSequenceM216h = null;
            }
        } else if (zAreEqual) {
            C12238m.checkNotNullExpressionValue(context, "context");
            charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_invalid_owner, new Object[0], null, 4);
        } else {
            charSequenceM216h = null;
        }
        TextView textView4 = this.binding.f16239b;
        C12238m.checkNotNullExpressionValue(textView4, "binding.itemInviteChannelName");
        textView4.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.f16248k;
        C12238m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(0);
        this.binding.f16248k.setInvalidText(charSequenceM216h);
        MaterialButton materialButton = this.binding.f16249l;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemInviteMentionButton");
        C1107b.m221m(materialButton, zAreEqual ? C5419R.string.create_instant_invite : C5419R.string.mention, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        MaterialButton materialButton2 = this.binding.f16249l;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteMentionButton");
        if (zAreEqual) {
            if (model != null && (channel = model.getChannel()) != null) {
                lValueOf = Long.valueOf(channel.getGuildId());
            }
            if (lValueOf == null) {
                z2 = false;
            }
        }
        materialButton2.setVisibility(z2 ? 0 : 8);
        this.binding.f16249l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite.configureInvalidUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Channel channel2;
                if (!zAreEqual) {
                    StoreChat chat = StoreStream.INSTANCE.getChat();
                    Model.Invalid invalid = model;
                    chat.appendMention(invalid != null ? invalid.getAuthorUser() : null, WidgetChatListAdapterItemInvite.access$getItem$p(WidgetChatListAdapterItemInvite.this).getGuildId());
                    return;
                }
                Model.Invalid invalid2 = model;
                if (invalid2 == null || (channel2 = invalid2.getChannel()) == null) {
                    return;
                }
                long guildId = channel2.getGuildId();
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context context2 = context;
                C12238m.checkNotNullExpressionValue(context2, "context");
                companion.launch(context2, WidgetChatListAdapterItemInvite.access$getAdapter$p(WidgetChatListAdapterItemInvite.this).getFragmentManager(), guildId, (16 & 8) != 0 ? null : Long.valueOf(model.getChannel().getId()), (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Invite Button Embed");
            }
        });
        MaterialButton materialButton3 = this.binding.f16245h;
        C12238m.checkNotNullExpressionValue(materialButton3, "binding.itemInviteJoinButton");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = this.binding.f16246i;
        C12238m.checkNotNullExpressionValue(materialButton4, "binding.itemInviteJoinedButton");
        materialButton4.setVisibility(8);
        View view2 = this.binding.f16247j;
        C12238m.checkNotNullExpressionValue(view2, "binding.itemInviteLoadingButton");
        view2.setVisibility(8);
    }

    private final void configureLoadingUI() {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        this.binding.f16240c.setText(C5419R.string.instant_invite_resolving);
        TextView textView = this.binding.f16250m;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemInviteName");
        textView.setText((CharSequence) null);
        this.binding.f16250m.setTextColor(ColorCompat.getThemedColor(context, C5419R.attr.primary_100));
        this.binding.f16250m.setBackgroundResource(C5419R.drawable.drawable_empty_text_placeholder_dark);
        this.binding.f16243f.setImageResource(C5419R.drawable.drawable_empty_text_placeholder_dark);
        TextView textView2 = this.binding.f16244g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemInviteImageText");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.f16239b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemInviteChannelName");
        textView3.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.f16248k;
        C12238m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(8);
        MaterialButton materialButton = this.binding.f16249l;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemInviteMentionButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.f16245h;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteJoinButton");
        materialButton2.setVisibility(8);
        MaterialButton materialButton3 = this.binding.f16246i;
        C12238m.checkNotNullExpressionValue(materialButton3, "binding.itemInviteJoinedButton");
        materialButton3.setVisibility(8);
        View view2 = this.binding.f16247j;
        C12238m.checkNotNullExpressionValue(view2, "binding.itemInviteLoadingButton");
        view2.setVisibility(0);
    }

    /* JADX WARN: Code duplicated, block: B:120:0x023d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0197  */
    /* JADX WARN: Code duplicated, block: B:90:0x019d  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a5  */
    private final void configureResolvedUI(Model.Resolved model) {
        Guild guild;
        CharSequence charSequenceM216h;
        String name;
        boolean z2;
        com.discord.api.guild.Guild guild2;
        String name2;
        String icon;
        Channel channel;
        List<GuildFeature> listM7866m;
        final ModelInvite invite = model.getInvite();
        long meId = model.getMeId();
        User authorUser = model.getAuthorUser();
        boolean isMemberOfGuild = model.getIsMemberOfGuild();
        Channel channel2 = model.getChannel();
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        boolean z3 = authorUser != null && authorUser.getId() == meId;
        com.discord.api.guild.Guild guild3 = invite.guild;
        boolean z4 = (guild3 != null ? guild3.getMemberCount() : 0) < 200;
        Channel channel3 = invite.getChannel();
        boolean zM7702z = channel3 != null ? ChannelUtils.m7702z(channel3) : false;
        com.discord.api.guild.Guild guild4 = invite.guild;
        boolean z5 = (guild4 == null || (listM7866m = guild4.m7866m()) == null || !listM7866m.contains(GuildFeature.HUB)) ? false : true;
        boolean z6 = invite.getChannel() == null && invite.guild == null && invite.getInviter() != null;
        com.discord.api.guild.Guild guild5 = invite.guild;
        if (guild5 != null) {
            C12238m.checkNotNullExpressionValue(guild5, "it");
            guild = new Guild(guild5);
        } else {
            guild = null;
        }
        SimpleDraweeView simpleDraweeView = this.binding.f16251n;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteSplash");
        IconUtils iconUtils = IconUtils.INSTANCE;
        View view2 = this.itemView;
        C12238m.checkNotNullExpressionValue(view2, "itemView");
        Resources resources = view2.getResources();
        C12238m.checkNotNullExpressionValue(resources, "itemView.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        IconUtils.setIcon$default(simpleDraweeView, iconUtils.getGuildSplashUrl(guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        RoundedRelativeLayout roundedRelativeLayout = this.binding.f16252o;
        C12238m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.itemInviteSplashContainer");
        roundedRelativeLayout.setVisibility((guild != null ? guild.getSplash() : null) != null ? 0 : 8);
        TextView textView = this.binding.f16240c;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemInviteHeader");
        if (zM7702z && z3) {
            C12238m.checkNotNullExpressionValue(context, "context");
            charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_title_inviter_group_dm, new Object[0], null, 4);
        } else if (z3) {
            C12238m.checkNotNullExpressionValue(context, "context");
            charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_title_inviter, new Object[0], null, 4);
        } else if (zM7702z && !z3) {
            C12238m.checkNotNullExpressionValue(context, "context");
            charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_title_invited_group_dm, new Object[0], null, 4);
        } else if (z5) {
            charSequenceM216h = context.getString(C5419R.string.invite_button_title_invited_hub);
        } else if (z6) {
            C12238m.checkNotNullExpressionValue(context, "context");
            Object[] objArr = new Object[1];
            com.discord.api.user.User inviter = invite.getInviter();
            objArr[0] = inviter != null ? inviter.getUsername() : null;
            charSequenceM216h = C1107b.m216h(context, C5419R.string.instant_invite_you_have_been_invited_to_chat, objArr, null, 4);
        } else if (!z4 || invite.getInviter() == null) {
            C12238m.checkNotNullExpressionValue(context, "context");
            charSequenceM216h = C1107b.m216h(context, C5419R.string.invite_button_title_invited, new Object[0], null, 4);
        } else {
            C12238m.checkNotNullExpressionValue(context, "context");
            Object[] objArr2 = new Object[1];
            com.discord.api.user.User inviter2 = invite.getInviter();
            objArr2[0] = inviter2 != null ? inviter2.getUsername() : null;
            charSequenceM216h = C1107b.m216h(context, C5419R.string.instant_invite_you_have_been_invited_to_join_by_user, objArr2, null, 4);
        }
        textView.setText(charSequenceM216h);
        TextView textView2 = this.binding.f16250m;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemInviteName");
        if (!zM7702z) {
            com.discord.api.guild.Guild guild6 = invite.guild;
            if (guild6 != null) {
                name = guild6.getName();
            } else {
                name = null;
            }
        } else if (channel2 != null) {
            C12238m.checkNotNullExpressionValue(context, "context");
            name = ChannelUtils.m7681e(channel2, context, false, 2);
            if (name == null) {
                channel = invite.getChannel();
                if (channel != null) {
                    C12238m.checkNotNullExpressionValue(context, "context");
                    name = ChannelUtils.m7681e(channel, context, false, 2);
                } else {
                    name = null;
                }
            }
        } else {
            channel = invite.getChannel();
            if (channel != null) {
                C12238m.checkNotNullExpressionValue(context, "context");
                name = ChannelUtils.m7681e(channel, context, false, 2);
            } else {
                name = null;
            }
        }
        textView2.setText(name);
        this.binding.f16250m.setTextColor(ColorCompat.getThemedColor(context, C5419R.attr.primary_100));
        this.binding.f16250m.setBackgroundResource(0);
        if (z6) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f16243f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemInviteImage");
            simpleDraweeView2.setVisibility(8);
        } else if (zM7702z) {
            updateIconUrlIfChanged(IconUtils.getForChannel$default(invite.getChannel(), null, 2, null));
            TextView textView3 = this.binding.f16244g;
            C12238m.checkNotNullExpressionValue(textView3, "binding.itemInviteImageText");
            textView3.setVisibility(8);
        } else {
            String strComputeShortName = null;
            com.discord.api.guild.Guild guild7 = invite.guild;
            Long lValueOf = guild7 != null ? Long.valueOf(guild7.getId()) : null;
            com.discord.api.guild.Guild guild8 = invite.guild;
            updateIconUrlIfChanged(IconUtils.getForGuild$default(lValueOf, guild8 != null ? guild8.getIcon() : null, IconUtils.DEFAULT_ICON_BLURPLE, model.getShouldAnimateGuildIcon(), null, 16, null));
            com.discord.api.guild.Guild guild9 = invite.guild;
            if (guild9 == null || (icon = guild9.getIcon()) == null) {
                z2 = false;
            } else {
                if (icon.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            TextView textView4 = this.binding.f16244g;
            C12238m.checkNotNullExpressionValue(textView4, "binding.itemInviteImageText");
            if (!z2 && (guild2 = invite.guild) != null && (name2 = guild2.getName()) != null) {
                strComputeShortName = GuildUtilsKt.computeShortName(name2);
            }
            ViewExtensions.setTextAndVisibilityBy(textView4, strComputeShortName);
        }
        if (channel2 == null || !ChannelUtils.m7699w(channel2)) {
            configureForTextChannel(zM7702z, invite);
        } else {
            C12238m.checkNotNullExpressionValue(context, "context");
            configureForVocalChannel(channel2, context);
        }
        if (zM7702z) {
            isMemberOfGuild = channel2 != null;
        }
        boolean z7 = z5 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled();
        View view3 = this.binding.f16247j;
        C12238m.checkNotNullExpressionValue(view3, "binding.itemInviteLoadingButton");
        view3.setVisibility(8);
        MaterialButton materialButton = this.binding.f16246i;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.itemInviteJoinedButton");
        materialButton.setVisibility(isMemberOfGuild ? 0 : 8);
        MaterialButton materialButton2 = this.binding.f16245h;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteJoinButton");
        materialButton2.setVisibility(true ^ isMemberOfGuild ? 0 : 8);
        MaterialButton materialButton3 = this.binding.f16249l;
        C12238m.checkNotNullExpressionValue(materialButton3, "binding.itemInviteMentionButton");
        materialButton3.setVisibility(8);
        this.binding.f16245h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite.configureResolvedUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite = WidgetChatListAdapterItemInvite.this;
                WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemInvite, widgetChatListAdapterItemInvite.getClass(), invite, null, null, 12, null);
            }
        });
        this.binding.f16246i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite.configureResolvedUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite = WidgetChatListAdapterItemInvite.this;
                WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemInvite, widgetChatListAdapterItemInvite.getClass(), invite, null, null, 12, null);
            }
        });
        FrameLayout frameLayout = this.binding.f16241d;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.itemInviteHubLayout");
        frameLayout.setVisibility(z7 ? 0 : 8);
        if (z7) {
            LinkifiedTextView linkifiedTextView = this.binding.f16242e;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.itemInviteHubLink");
            C12238m.checkNotNullExpressionValue(context, "context");
            linkifiedTextView.setText(C1107b.m210b(context, C5419R.string.hub_invite_another_school_link, new Object[0], new C80924()));
        }
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            configureLoadingUI();
        } else if (model instanceof Model.Resolved) {
            configureResolvedUI((Model.Resolved) model);
        } else {
            if (!(model instanceof Model.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI((Model.Invalid) model);
        }
    }

    private final void launchHubsEmail(HubEmailArgs args) {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "itemView.context");
        C0870j.m156d(context, WidgetHubEmailFlow.class, args);
    }

    private final void updateIconUrlIfChanged(String iconUrl) {
        if (!C12238m.areEqual(this.iconUrl, iconUrl)) {
            SimpleDraweeView simpleDraweeView = this.binding.f16243f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteImage");
            IconUtils.setIcon$default(simpleDraweeView, iconUrl, C5419R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            this.iconUrl = iconUrl;
        }
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
        this.item = (InviteEntry) data;
        StoreInstantInvites instantInvites = StoreStream.INSTANCE.getInstantInvites();
        InviteEntry inviteEntry = this.item;
        if (inviteEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        String inviteCode = inviteEntry.getInviteCode();
        InviteEntry inviteEntry2 = this.item;
        if (inviteEntry2 == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        String eventId = inviteEntry2.getEventId();
        instantInvites.fetchInviteIfNotLoaded(inviteCode, (24 & 2) != 0 ? null : eventId != null ? SnowflakeUtils.INSTANCE.toSnowflake(eventId) : null, (24 & 4) != 0 ? null : "Invite Button Embed", (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        InviteEntry inviteEntry3 = this.item;
        if (inviteEntry3 == null) {
            C12238m.throwUninitializedPropertyAccessException("item");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(modelProvider.get(inviteEntry3)), (Class<?>) WidgetChatListAdapterItemInvite.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C80953()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C80942()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C80931(this));
    }
}
