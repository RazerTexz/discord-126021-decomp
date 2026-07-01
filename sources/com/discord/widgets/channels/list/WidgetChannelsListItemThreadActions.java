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
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.channels.list.WidgetThreadArchiveActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func7;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelsListItemThreadActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new Func1<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetChannelsListItemThreadActions.Model> call(final Channel channel) {
                        if (channel == null) {
                            return new ScalarSynchronousObservable(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.e(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getChannels().observeChannel(channel.getParentId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getPermissions().observePermissionsForChannel(channel.getParentId()), companion.getUserGuildSettings().observeGuildSettings(), companion.getThreadsJoined().observeJoinedThread(channel.getId()), companion.getThreadsActive().observeActiveThreadsForGuild(channel.getGuildId()).G(new Func1<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1.1
                            @Override // j0.k.Func1
                            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                                return call2((Map<Long, Channel>) map);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final Boolean call2(Map<Long, Channel> map) {
                                return Boolean.valueOf(outline.d(channel, map) != null);
                            }
                        }).r(), new Func7<MeUser, Channel, Guild, Long, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined.JoinedThread, Boolean, WidgetChannelsListItemThreadActions.Model>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1.2
                            @Override // rx.functions.Func7
                            public final WidgetChannelsListItemThreadActions.Model call(MeUser meUser, Channel channel2, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread, Boolean bool) {
                                NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
                                boolean zIsGuildOrCategoryOrChannelMuted = notificationTextUtils.isGuildOrCategoryOrChannelMuted((ModelNotificationSettings) outline.c(channel, map), channel2);
                                Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel((ModelNotificationSettings) outline.c(channel, map), channel, guild);
                                ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                                int iComputeThreadNotificationSetting = threadUtils.computeThreadNotificationSetting(joinedThread, zIsGuildOrCategoryOrChannelMuted, numChannelMessageNotificationLevel);
                                Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                                boolean zCanManageThread = threadUtils.canManageThread(meUser, channel, Long.valueOf(l != null ? l.longValue() : 0L));
                                boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(channel, Long.valueOf(l != null ? l.longValue() : 0L));
                                boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
                                boolean z2 = joinedThread != null && joinedThread.getMuted();
                                Channel channel3 = channel;
                                Intrinsics3.checkNotNullExpressionValue(bool, "isActiveThread");
                                return new WidgetChannelsListItemThreadActions.Model(meUser, channel3, guild, channel2, iComputeThreadNotificationSetting, joinedThread, bool.booleanValue(), zIsThreadModerator, zCanManageThread, zCanUnarchiveThread, z2);
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined.JoinedThread joinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            return Intrinsics3.areEqual(this.meUser, model.meUser) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.parentChannel, model.parentChannel) && this.notificationSetting == model.notificationSetting && Intrinsics3.areEqual(this.joinedThread, model.joinedThread) && this.isActiveThread == model.isActiveThread && this.isModerator == model.isModerator && this.canManageThread == model.canManageThread && this.canUnarchiveThread == model.canUnarchiveThread && this.isMuted == model.isMuted;
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
            StringBuilder sbU = outline.U("Model(meUser=");
            sbU.append(this.meUser);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", parentChannel=");
            sbU.append(this.parentChannel);
            sbU.append(", notificationSetting=");
            sbU.append(this.notificationSetting);
            sbU.append(", joinedThread=");
            sbU.append(this.joinedThread);
            sbU.append(", isActiveThread=");
            sbU.append(this.isActiveThread);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", canManageThread=");
            sbU.append(this.canManageThread);
            sbU.append(", canUnarchiveThread=");
            sbU.append(this.canUnarchiveThread);
            sbU.append(", isMuted=");
            return outline.O(sbU, this.isMuted, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelsListItemThreadActions.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getMessageAck().ack(this.$this_configureUI.getChannel().getId(), false, true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (this.$this_configureUI.isMuted()) {
                StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                Context contextRequireContext = WidgetChannelsListItemThreadActions.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                StoreUserGuildSettings.setChannelMuted$default(userGuildSettings, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, null, 8, null);
                return;
            }
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(id2, parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadSettings.Companion companion = WidgetThreadSettings.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            companion.launch(id2, context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadArchiveActions.Companion companion = WidgetThreadArchiveActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$this_configureUI.getChannel().getId(), this.$this_configureUI.getChannel().getGuildId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$8, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass8 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppToast.c(context, String.valueOf(this.$this_configureUI.getChannel().getId()), 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$leaveThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
            AppToast.g(WidgetChannelsListItemThreadActions.this.getContext(), abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.network_error_bad_request, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    public WidgetChannelsListItemThreadActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelsListItemThreadActions3.INSTANCE, null, 2, null);
    }

    private final void configureUI(final Model model) {
        ThreadMetadata threadMetadata;
        ThreadMetadata threadMetadata2;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListItemThreadActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        TextView textView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelsListItemThreadActionsMarkAsRead");
        setOnClickAndDismissListener(textView2, new AnonymousClass1(model));
        TextView textView3 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelsListItemThreadActionsMute");
        Channel channel2 = model.getChannel();
        boolean zIsMuted = model.isMuted();
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        textView3.setText(getMuteThreadText(channel2, zIsMuted, contextRequireContext2));
        TextView textView4 = getBinding().l;
        boolean zIsMuted2 = model.isMuted();
        Context contextRequireContext3 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
        textView4.setCompoundDrawablesWithIntrinsicBounds(getMuteIconResId(zIsMuted2, contextRequireContext3), 0, 0, 0);
        TextView textView5 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.channelsListItemThreadActionsMute");
        setOnClickAndDismissListener(textView5, new AnonymousClass2(model));
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
                Context contextRequireContext4 = WidgetChannelsListItemThreadActions.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
                WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext4, model.getChannel().getId(), false, 4, null);
            }
        });
        View view = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelsListItemThreadActionsDivider");
        view.setVisibility(model.isActiveThread() ? 0 : 8);
        TextView textView6 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.channelsListItemThreadActionsEdit");
        textView6.setVisibility(model.getCanManageThread() ? 0 : 8);
        TextView textView7 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelsListItemThreadActionsEdit");
        setOnClickAndDismissListener(textView7, new AnonymousClass4(model));
        boolean z2 = model.getCanManageThread() && ((threadMetadata2 = model.getChannel().getThreadMetadata()) == null || !threadMetadata2.getArchived());
        LinearLayout linearLayout = getBinding().f2297b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelsListItem…eadActionsArchiveSettings");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Context contextRequireContext4 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
            ThreadMetadata threadMetadata3 = model.getChannel().getThreadMetadata();
            Intrinsics3.checkNotNull(threadMetadata3);
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(contextRequireContext4, threadMetadata3.getAutoArchiveDuration());
            TextView textView8 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.channelsListItem…sArchiveSettingsSubheader");
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            textView8.setText(FormatUtils.e(this, R.string.auto_archive_thread_after, new Object[]{lowerCase}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        }
        LinearLayout linearLayout2 = getBinding().f2297b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelsListItem…eadActionsArchiveSettings");
        setOnClickAndDismissListener(linearLayout2, new AnonymousClass5(model));
        TextView textView9 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.channelsListItemThreadActionsUnarchive");
        textView9.setVisibility(model.getCanUnarchiveThread() && (threadMetadata = model.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() ? 0 : 8);
        getBinding().n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelsListItemThreadActions.this.unarchiveThread(model.getChannel(), model.isModerator());
            }
        });
        TextView textView10 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.channelsListItemThreadActionsLeave");
        textView10.setVisibility(model.getJoinedThread() != null ? 0 : 8);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelsListItemThreadActions.this.leaveThread(model.getChannel());
            }
        });
        View view2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.channelsListItem…adActionsDeveloperDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView11 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.channelsListItemThreadActionsCopyId");
        textView11.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView12 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.channelsListItemThreadActionsCopyId");
        setOnClickAndDismissListener(textView12, new AnonymousClass8(model));
    }

    private final WidgetChannelsListItemThreadActionsBinding getBinding() {
        return (WidgetChannelsListItemThreadActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getMuteIconResId(boolean isMuted, Context context) {
        return DrawableCompat.getThemedDrawableRes$default(context, isMuted ? R.attr.ic_channel_muted : R.attr.ic_channel_mute, 0, 2, (Object) null);
    }

    private final CharSequence getMuteThreadText(Channel channel, boolean isMuted, Context context) {
        return isMuted ? FormatUtils.b(context, R.string.unmute, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.mute_channel, new Object[]{ChannelUtils.e(channel, context, false, 2)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    private final void leaveThread(Channel channel) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channel.getId(), "Context Menu"), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: leaveThread", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    private final void unarchiveThread(Channel channel, boolean unlockThread) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.FALSE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, unlockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: unarchiveThread", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), (Class<?>) WidgetChannelsListItemThreadActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channels_list_item_thread_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
