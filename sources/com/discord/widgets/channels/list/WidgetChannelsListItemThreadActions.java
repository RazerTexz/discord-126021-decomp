package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemThreadActionsBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.channels.list.WidgetThreadArchiveActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func7;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelsListItemThreadActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions = new WidgetChannelsListItemThreadActions();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChannelsListItemThreadActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            widgetChannelsListItemThreadActions.setArguments(bundle);
            widgetChannelsListItemThreadActions.show(fragmentManager, WidgetChannelsListItemThreadActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageThread;
        private final boolean canUnarchiveThread;
        private final Channel channel;
        private final Guild guild;
        private final boolean isActiveThread;
        private final boolean isDeveloper;
        private final boolean isModerator;
        private final boolean isMuted;
        private final StoreThreadsJoined.JoinedThread joinedThread;
        private final MeUser meUser;
        private final int notificationSetting;
        private final Channel parentChannel;

        /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetChannelsListItemThreadActions.Model> call(final Channel channel) {
                        if (channel == null) {
                            return new C12721k(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.m11069e(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getChannels().observeChannel(channel.getParentId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getPermissions().observePermissionsForChannel(channel.getParentId()), companion.getUserGuildSettings().observeGuildSettings(), companion.getThreadsJoined().observeJoinedThread(channel.getId()), companion.getThreadsActive().observeActiveThreadsForGuild(channel.getGuildId()).m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                                return call2((Map<Long, Channel>) map);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final Boolean call2(Map<Long, Channel> map) {
                                return Boolean.valueOf(C1643a.m845d(channel, map) != null);
                            }
                        }).m11112r(), new Func7<MeUser, Channel, Guild, Long, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined.JoinedThread, Boolean, WidgetChannelsListItemThreadActions.Model>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1.2
                            @Override // p658rx.functions.Func7
                            public final WidgetChannelsListItemThreadActions.Model call(MeUser meUser, Channel channel2, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread, Boolean bool) {
                                NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
                                boolean zIsGuildOrCategoryOrChannelMuted = notificationTextUtils.isGuildOrCategoryOrChannelMuted((ModelNotificationSettings) C1643a.m843c(channel, map), channel2);
                                Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel((ModelNotificationSettings) C1643a.m843c(channel, map), channel, guild);
                                ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                                int iComputeThreadNotificationSetting = threadUtils.computeThreadNotificationSetting(joinedThread, zIsGuildOrCategoryOrChannelMuted, numChannelMessageNotificationLevel);
                                C12238m.checkNotNullExpressionValue(meUser, "meUser");
                                boolean zCanManageThread = threadUtils.canManageThread(meUser, channel, Long.valueOf(l != null ? l.longValue() : 0L));
                                boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(channel, Long.valueOf(l != null ? l.longValue() : 0L));
                                boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
                                boolean z2 = joinedThread != null && joinedThread.getMuted();
                                Channel channel3 = channel;
                                C12238m.checkNotNullExpressionValue(bool, "isActiveThread");
                                return new WidgetChannelsListItemThreadActions.Model(meUser, channel3, guild, channel2, iComputeThreadNotificationSetting, joinedThread, bool.booleanValue(), zIsThreadModerator, zCanManageThread, zCanUnarchiveThread, z2);
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined.JoinedThread joinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(channel, "channel");
            this.meUser = meUser;
            this.channel = channel;
            this.guild = guild;
            this.parentChannel = channel2;
            this.notificationSetting = i;
            this.joinedThread = joinedThread;
            this.isActiveThread = z2;
            this.isModerator = z3;
            this.canManageThread = z4;
            this.canUnarchiveThread = z5;
            this.isMuted = z6;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getCanUnarchiveThread() {
            return this.canUnarchiveThread;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsActiveThread() {
            return this.isActiveThread;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final Model copy(MeUser meUser, Channel channel, Guild guild, Channel parentChannel, int notificationSetting, StoreThreadsJoined.JoinedThread joinedThread, boolean isActiveThread, boolean isModerator, boolean canManageThread, boolean canUnarchiveThread, boolean isMuted) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(channel, "channel");
            return new Model(meUser, channel, guild, parentChannel, notificationSetting, joinedThread, isActiveThread, isModerator, canManageThread, canUnarchiveThread, isMuted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.meUser, model.meUser) && C12238m.areEqual(this.channel, model.channel) && C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.parentChannel, model.parentChannel) && this.notificationSetting == model.notificationSetting && C12238m.areEqual(this.joinedThread, model.joinedThread) && this.isActiveThread == model.isActiveThread && this.isModerator == model.isModerator && this.canManageThread == model.canManageThread && this.canUnarchiveThread == model.canUnarchiveThread && this.isMuted == model.isMuted;
        }

        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final boolean getCanUnarchiveThread() {
            return this.canUnarchiveThread;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel2 = this.parentChannel;
            int iHashCode4 = (((iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31) + this.notificationSetting) * 31;
            StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
            int iHashCode5 = (iHashCode4 + (joinedThread != null ? joinedThread.hashCode() : 0)) * 31;
            boolean z2 = this.isActiveThread;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode5 + r1) * 31;
            boolean z3 = this.isModerator;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.canManageThread;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.canUnarchiveThread;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.isMuted;
            return i4 + (z6 ? 1 : z6);
        }

        public final boolean isActiveThread() {
            return this.isActiveThread;
        }

        /* JADX INFO: renamed from: isDeveloper, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", parentChannel=");
            sbM833U.append(this.parentChannel);
            sbM833U.append(", notificationSetting=");
            sbM833U.append(this.notificationSetting);
            sbM833U.append(", joinedThread=");
            sbM833U.append(this.joinedThread);
            sbM833U.append(", isActiveThread=");
            sbM833U.append(this.isActiveThread);
            sbM833U.append(", isModerator=");
            sbM833U.append(this.isModerator);
            sbM833U.append(", canManageThread=");
            sbM833U.append(this.canManageThread);
            sbM833U.append(", canUnarchiveThread=");
            sbM833U.append(this.canUnarchiveThread);
            sbM833U.append(", isMuted=");
            return C1643a.m827O(sbM833U, this.isMuted, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74631 extends AbstractC12240o implements Function1<Model, Unit> {
        public C74631() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelsListItemThreadActions.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$1 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74641 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74641(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getMessageAck().ack(this.$this_configureUI.getChannel().getId(), false, true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$2 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74652 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74652(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            if (this.$this_configureUI.isMuted()) {
                StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                Context contextRequireContext = WidgetChannelsListItemThreadActions.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                StoreUserGuildSettings.setChannelMuted$default(userGuildSettings, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, null, 8, null);
                return;
            }
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(id2, parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$4 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74674 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74674(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetThreadSettings.Companion companion = WidgetThreadSettings.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "it.context");
            companion.launch(id2, context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$5 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74685 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74685(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetThreadArchiveActions.Companion companion = WidgetThreadArchiveActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$this_configureUI.getChannel().getId(), this.$this_configureUI.getChannel().getGuildId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$8 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74718 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74718(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "it.context");
            C0876m.m165c(context, String.valueOf(this.$this_configureUI.getChannel().getId()), 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$leaveThread$1 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74721 extends AbstractC12240o implements Function1<Void, Unit> {
        public C74721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$1 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74731 extends AbstractC12240o implements Function1<Error, Unit> {
        public C74731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
            C0876m.m169g(WidgetChannelsListItemThreadActions.this.getContext(), abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : C5419R.string.network_error_bad_request, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$2 */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class C74742 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C74742() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "it");
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    public WidgetChannelsListItemThreadActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelsListItemThreadActions$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(final Model model) {
        ThreadMetadata threadMetadata;
        ThreadMetadata threadMetadata2;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f16062i;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f16062i;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().f16066m;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelsListItemThreadActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.m7681e(channel, contextRequireContext, false, 2));
        TextView textView2 = getBinding().f16064k;
        C12238m.checkNotNullExpressionValue(textView2, "binding.channelsListItemThreadActionsMarkAsRead");
        setOnClickAndDismissListener(textView2, new C74641(model));
        TextView textView3 = getBinding().f16065l;
        C12238m.checkNotNullExpressionValue(textView3, "binding.channelsListItemThreadActionsMute");
        Channel channel2 = model.getChannel();
        boolean zIsMuted = model.isMuted();
        Context contextRequireContext2 = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        textView3.setText(getMuteThreadText(channel2, zIsMuted, contextRequireContext2));
        TextView textView4 = getBinding().f16065l;
        boolean zIsMuted2 = model.isMuted();
        Context contextRequireContext3 = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
        textView4.setCompoundDrawablesWithIntrinsicBounds(getMuteIconResId(zIsMuted2, contextRequireContext3), 0, 0, 0);
        TextView textView5 = getBinding().f16065l;
        C12238m.checkNotNullExpressionValue(textView5, "binding.channelsListItemThreadActionsMute");
        setOnClickAndDismissListener(textView5, new C74652(model));
        getBinding().f16057d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
                Context contextRequireContext4 = WidgetChannelsListItemThreadActions.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
                WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext4, model.getChannel().getId(), false, 4, null);
            }
        });
        View view = getBinding().f16060g;
        C12238m.checkNotNullExpressionValue(view, "binding.channelsListItemThreadActionsDivider");
        view.setVisibility(model.isActiveThread() ? 0 : 8);
        TextView textView6 = getBinding().f16061h;
        C12238m.checkNotNullExpressionValue(textView6, "binding.channelsListItemThreadActionsEdit");
        textView6.setVisibility(model.getCanManageThread() ? 0 : 8);
        TextView textView7 = getBinding().f16061h;
        C12238m.checkNotNullExpressionValue(textView7, "binding.channelsListItemThreadActionsEdit");
        setOnClickAndDismissListener(textView7, new C74674(model));
        boolean z2 = model.getCanManageThread() && ((threadMetadata2 = model.getChannel().getThreadMetadata()) == null || !threadMetadata2.getArchived());
        LinearLayout linearLayout = getBinding().f16055b;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.channelsListItem…eadActionsArchiveSettings");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Context contextRequireContext4 = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
            ThreadMetadata threadMetadata3 = model.getChannel().getThreadMetadata();
            C12238m.checkNotNull(threadMetadata3);
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(contextRequireContext4, threadMetadata3.getAutoArchiveDuration());
            TextView textView8 = getBinding().f16056c;
            C12238m.checkNotNullExpressionValue(textView8, "binding.channelsListItem…sArchiveSettingsSubheader");
            Locale locale = Locale.getDefault();
            C12238m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            textView8.setText(C1107b.m213e(this, C5419R.string.auto_archive_thread_after, new Object[]{lowerCase}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        }
        LinearLayout linearLayout2 = getBinding().f16055b;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.channelsListItem…eadActionsArchiveSettings");
        setOnClickAndDismissListener(linearLayout2, new C74685(model));
        TextView textView9 = getBinding().f16067n;
        C12238m.checkNotNullExpressionValue(textView9, "binding.channelsListItemThreadActionsUnarchive");
        textView9.setVisibility(model.getCanUnarchiveThread() && (threadMetadata = model.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() ? 0 : 8);
        getBinding().f16067n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelsListItemThreadActions.this.unarchiveThread(model.getChannel(), model.isModerator());
            }
        });
        TextView textView10 = getBinding().f16063j;
        C12238m.checkNotNullExpressionValue(textView10, "binding.channelsListItemThreadActionsLeave");
        textView10.setVisibility(model.getJoinedThread() != null ? 0 : 8);
        getBinding().f16063j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelsListItemThreadActions.this.leaveThread(model.getChannel());
            }
        });
        View view2 = getBinding().f16059f;
        C12238m.checkNotNullExpressionValue(view2, "binding.channelsListItem…adActionsDeveloperDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView11 = getBinding().f16058e;
        C12238m.checkNotNullExpressionValue(textView11, "binding.channelsListItemThreadActionsCopyId");
        textView11.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView12 = getBinding().f16058e;
        C12238m.checkNotNullExpressionValue(textView12, "binding.channelsListItemThreadActionsCopyId");
        setOnClickAndDismissListener(textView12, new C74718(model));
    }

    private final WidgetChannelsListItemThreadActionsBinding getBinding() {
        return (WidgetChannelsListItemThreadActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getMuteIconResId(boolean isMuted, Context context) {
        return DrawableCompat.getThemedDrawableRes$default(context, isMuted ? C5419R.attr.ic_channel_muted : C5419R.attr.ic_channel_mute, 0, 2, (Object) null);
    }

    private final CharSequence getMuteThreadText(Channel channel, boolean isMuted, Context context) {
        return isMuted ? C1107b.m210b(context, C5419R.string.unmute, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null) : C1107b.m210b(context, C5419R.string.mute_channel, new Object[]{ChannelUtils.m7681e(channel, context, false, 2)}, (4 & 4) != 0 ? C1107b.b.f1491j : null);
    }

    private final void leaveThread(Channel channel) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channel.getId(), "Context Menu"), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: leaveThread", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C74721(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    private final void unarchiveThread(Channel channel, boolean unlockThread) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.FALSE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, unlockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: unarchiveThread", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C74742(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new C74731()), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), (Class<?>) WidgetChannelsListItemThreadActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74631());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channels_list_item_thread_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
