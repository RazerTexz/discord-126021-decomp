package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemActionsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelsListItemChannelActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions = new WidgetChannelsListItemChannelActions();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChannelsListItemChannelActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            widgetChannelsListItemChannelActions.setArguments(bundle);
            widgetChannelsListItemChannelActions.show(fragmentManager, WidgetChannelsListItemChannelActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canCreateInstantInvite;
        private final boolean canManageChannel;
        private final Channel channel;
        private final Guild guild;
        private final boolean isDeveloper;
        private final boolean isMuted;
        private final Long permissions;

        /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new Func1<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetChannelsListItemChannelActions.Model> call(final Channel channel) {
                        if (channel == null) {
                            return new ScalarSynchronousObservable(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.i(companion.getGuilds().observeFromChannelId(channelId), companion.getPermissions().observePermissionsForChannel(channelId), companion.getUserGuildSettings().observeGuildSettings(), new Func3<Guild, Long, Map<Long, ? extends ModelNotificationSettings>, WidgetChannelsListItemChannelActions.Model>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Model$Companion$get$1.1
                            @Override // rx.functions.Func3
                            public final WidgetChannelsListItemChannelActions.Model call(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
                                ModelNotificationSettings.ChannelOverride channelOverride;
                                ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) outline.c(channel, map);
                                return new WidgetChannelsListItemChannelActions.Model(channel, guild, l, (modelNotificationSettings == null || (channelOverride = modelNotificationSettings.getChannelOverride(channel.getId())) == null || !channelOverride.isMuted()) ? false : true);
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getChannels(…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, Long l, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
            this.isMuted = z2;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
            this.canManageChannel = PermissionUtils.can(16L, l) || ChannelUtils.z(channel);
            this.canCreateInstantInvite = PermissionUtils.can(1L, l);
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, Guild guild, Long l, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = model.channel;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                l = model.permissions;
            }
            if ((i & 8) != 0) {
                z2 = model.isMuted;
            }
            return model.copy(channel, guild, l, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        public final Model copy(Channel channel, Guild guild, Long permissions, boolean isMuted) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(channel, guild, permissions, isMuted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.permissions, model.permissions) && this.isMuted == model.isMuted;
        }

        public final boolean getCanCreateInstantInvite() {
            return this.canCreateInstantInvite;
        }

        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final CharSequence getMuteChannelText(Context context, Channel channel) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (this.isMuted && ChannelUtils.k(channel)) {
                return FormatUtils.b(context, R.string.unmute_category, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            if (this.isMuted || !ChannelUtils.k(channel)) {
                return this.isMuted ? FormatUtils.b(context, R.string.unmute_channel_generic, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.mute_channel_generic, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            return FormatUtils.b(context, R.string.mute_category, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }

        public final int getMuteIconResId(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, this.isMuted ? R.attr.ic_channel_muted : R.attr.ic_channel_mute, 0, 2, (Object) null);
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z2 = this.isMuted;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        /* JADX INFO: renamed from: isDeveloper, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", isMuted=");
            return outline.O(sbU, this.isMuted, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
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
            WidgetChannelsListItemChannelActions.this.configureUI(model);
        }
    }

    public WidgetChannelsListItemChannelActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelsListItemChannelActions$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(final Model model) {
        Guild guild;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListItemTextActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        final User userA = ChannelUtils.a(model.getChannel());
        TextView textView2 = getBinding().i;
        boolean z2 = true;
        textView2.setVisibility(userA != null ? 0 : 8);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                User user = userA;
                if (user != null) {
                    WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                    long id2 = user.getId();
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
                }
            }
        });
        TextView textView3 = getBinding().e;
        textView3.setVisibility(model.getCanCreateInstantInvite() ? 0 : 8);
        setOnClickAndDismissListener(textView3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$2(textView3, this, model));
        TextView textView4 = getBinding().k;
        textView4.setVisibility(ChannelUtils.F(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        setOnClickAndDismissListener(textView4, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$3(textView4, this, model));
        Context context = textView4.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView4.setCompoundDrawablesWithIntrinsicBounds(model.getMuteIconResId(context), 0, 0, 0);
        Context context2 = textView4.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        textView4.setText(model.getMuteChannelText(context2, model.getChannel()));
        TextView textView5 = getBinding().l;
        textView5.setVisibility(ThreadUtils.INSTANCE.isThreadsEnabled(model.getChannel().getGuildId()) && ChannelUtils.I(model.getChannel()) && !ChannelUtils.q(model.getChannel()) && !model.getChannel().getNsfw() ? 0 : 8);
        setOnClickAndDismissListener(textView5, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$4(textView5, this, model));
        TextView textView6 = getBinding().c;
        textView6.setVisibility(model.getCanManageChannel() ? 0 : 8);
        setOnClickAndDismissListener(textView6, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$5(this, model));
        textView6.setText(getSettingsText(model.getChannel(), model.getCanManageChannel()));
        TextView textView7 = getBinding().f2283b;
        textView7.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) || (ChannelUtils.D(model.getChannel()) && (guild = model.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY)) ? 0 : 8);
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, outline.x(view, "it", "it.context"), model.getChannel().getId(), false, 4, null);
            }
        });
        View view = getBinding().j;
        if (!ChannelUtils.F(model.getChannel()) && !ChannelUtils.k(model.getChannel())) {
            z2 = false;
        }
        view.setVisibility(z2 ? 0 : 8);
        setOnClickAndDismissListener(view, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$7(this, model));
        View view2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.developerDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        View view3 = getBinding().d;
        view3.setVisibility(model.getIsDeveloper() ? 0 : 8);
        setOnClickAndDismissListener(view3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$8(this, model));
    }

    private final WidgetChannelsListItemActionsBinding getBinding() {
        return (WidgetChannelsListItemActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSettingsText(Channel channel, boolean z2) {
        int i;
        if (ChannelUtils.k(channel)) {
            i = R.string.edit_category;
        } else if (z2) {
            i = R.string.edit_channel;
        } else {
            i = !z2 ? R.string.channel_settings : R.string.sample_empty_string;
        }
        String string = getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(\n      when {\n…_empty_string\n      }\n  )");
        return string;
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), (Class<?>) WidgetChannelsListItemChannelActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channels_list_item_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
