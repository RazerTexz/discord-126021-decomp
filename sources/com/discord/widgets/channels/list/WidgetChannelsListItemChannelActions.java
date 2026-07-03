package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelsListItemChannelActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0)};

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
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
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
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetChannelsListItemChannelActions.Model> call(final Channel channel) {
                        if (channel == null) {
                            return new C12721k(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.m11075i(companion.getGuilds().observeFromChannelId(channelId), companion.getPermissions().observePermissionsForChannel(channelId), companion.getUserGuildSettings().observeGuildSettings(), new Func3<Guild, Long, Map<Long, ? extends ModelNotificationSettings>, WidgetChannelsListItemChannelActions.Model>() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Model$Companion$get$1.1
                            @Override // p658rx.functions.Func3
                            public final WidgetChannelsListItemChannelActions.Model call(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
                                ModelNotificationSettings.ChannelOverride channelOverride;
                                ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) C1643a.m843c(channel, map);
                                return new WidgetChannelsListItemChannelActions.Model(channel, guild, l, (modelNotificationSettings == null || (channelOverride = modelNotificationSettings.getChannelOverride(channel.getId())) == null || !channelOverride.isMuted()) ? false : true);
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream.getChannels(…        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream.getChannels(…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, Long l, boolean z2) {
            C12238m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
            this.isMuted = z2;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
            this.canManageChannel = PermissionUtils.can(16L, l) || ChannelUtils.m7702z(channel);
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
            C12238m.checkNotNullParameter(channel, "channel");
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
            return C12238m.areEqual(this.channel, model.channel) && C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.permissions, model.permissions) && this.isMuted == model.isMuted;
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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(channel, "channel");
            if (this.isMuted && ChannelUtils.m7687k(channel)) {
                return C1107b.m210b(context, C5419R.string.unmute_category, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
            }
            if (this.isMuted || !ChannelUtils.m7687k(channel)) {
                return this.isMuted ? C1107b.m210b(context, C5419R.string.unmute_channel_generic, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null) : C1107b.m210b(context, C5419R.string.mute_channel_generic, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
            }
            return C1107b.m210b(context, C5419R.string.mute_category, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
        }

        public final int getMuteIconResId(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, this.isMuted ? C5419R.attr.ic_channel_muted : C5419R.attr.ic_channel_mute, 0, 2, (Object) null);
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
            StringBuilder sbM833U = C1643a.m833U("Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", permissions=");
            sbM833U.append(this.permissions);
            sbM833U.append(", isMuted=");
            return C1643a.m827O(sbM833U, this.isMuted, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
    public static final class C74521 extends AbstractC12240o implements Function1<Model, Unit> {
        public C74521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelsListItemChannelActions.this.configureUI(model);
        }
    }

    public WidgetChannelsListItemChannelActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelsListItemChannelActions$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(final Model model) {
        Guild guild;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f15989f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f15989f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().f15990g;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelsListItemTextActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.m7681e(channel, contextRequireContext, false, 2));
        final User userM7677a = ChannelUtils.m7677a(model.getChannel());
        TextView textView2 = getBinding().f15992i;
        boolean z2 = true;
        textView2.setVisibility(userM7677a != null ? 0 : 8);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                User user = userM7677a;
                if (user != null) {
                    WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                    long id2 = user.getId();
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
                }
            }
        });
        TextView textView3 = getBinding().f15988e;
        textView3.setVisibility(model.getCanCreateInstantInvite() ? 0 : 8);
        setOnClickAndDismissListener(textView3, new C7454x3de54559(textView3, this, model));
        TextView textView4 = getBinding().f15994k;
        textView4.setVisibility(ChannelUtils.m7671F(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) ? 0 : 8);
        setOnClickAndDismissListener(textView4, new C7455x3de5455a(textView4, this, model));
        Context context = textView4.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        textView4.setCompoundDrawablesWithIntrinsicBounds(model.getMuteIconResId(context), 0, 0, 0);
        Context context2 = textView4.getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        textView4.setText(model.getMuteChannelText(context2, model.getChannel()));
        TextView textView5 = getBinding().f15995l;
        textView5.setVisibility(ThreadUtils.INSTANCE.isThreadsEnabled(model.getChannel().getGuildId()) && ChannelUtils.m7674I(model.getChannel()) && !ChannelUtils.m7693q(model.getChannel()) && !model.getChannel().getNsfw() ? 0 : 8);
        setOnClickAndDismissListener(textView5, new C7456x3de5455b(textView5, this, model));
        TextView textView6 = getBinding().f15986c;
        textView6.setVisibility(model.getCanManageChannel() ? 0 : 8);
        setOnClickAndDismissListener(textView6, new C7457x3de5455c(this, model));
        textView6.setText(getSettingsText(model.getChannel(), model.getCanManageChannel()));
        TextView textView7 = getBinding().f15985b;
        textView7.setVisibility(ChannelUtils.m7698v(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) || (ChannelUtils.m7669D(model.getChannel()) && (guild = model.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY)) ? 0 : 8);
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, C1643a.m885x(view, "it", "it.context"), model.getChannel().getId(), false, 4, null);
            }
        });
        View view = getBinding().f15993j;
        if (!ChannelUtils.m7671F(model.getChannel()) && !ChannelUtils.m7687k(model.getChannel())) {
            z2 = false;
        }
        view.setVisibility(z2 ? 0 : 8);
        setOnClickAndDismissListener(view, new C7459x3de5455e(this, model));
        View view2 = getBinding().f15991h;
        C12238m.checkNotNullExpressionValue(view2, "binding.developerDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        View view3 = getBinding().f15987d;
        view3.setVisibility(model.getIsDeveloper() ? 0 : 8);
        setOnClickAndDismissListener(view3, new C7460x3de5455f(this, model));
    }

    private final WidgetChannelsListItemActionsBinding getBinding() {
        return (WidgetChannelsListItemActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSettingsText(Channel channel, boolean z2) {
        int i;
        if (ChannelUtils.m7687k(channel)) {
            i = C5419R.string.edit_category;
        } else if (z2) {
            i = C5419R.string.edit_channel;
        } else {
            i = !z2 ? C5419R.string.channel_settings : C5419R.string.sample_empty_string;
        }
        String string = getString(i);
        C12238m.checkNotNullExpressionValue(string, "getString(\n      when {\n…_empty_string\n      }\n  )");
        return string;
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), (Class<?>) WidgetChannelsListItemChannelActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74521());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channels_list_item_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
