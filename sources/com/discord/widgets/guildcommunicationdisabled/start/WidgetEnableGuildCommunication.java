package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserCommunicationDisabledUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableGuildCommunicationBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.duration.DurationUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEnableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Clock clock;
    private Subscription communicationDisabledCountdownSubscription;

    /* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long userId, long guildId, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetEnableGuildCommunication widgetEnableGuildCommunication = new WidgetEnableGuildCommunication();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_USER_ID", userId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetEnableGuildCommunication.setArguments(bundleM832T);
            widgetEnableGuildCommunication.show(fragmentManager, WidgetEnableGuildCommunication.class.getSimpleName());
            AnalyticsTracker.INSTANCE.viewedEnableCommunicationModal(guildId, userId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$1 */
    /* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
    public static final class C85651 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ long $communicationDisabledTimestampMs;
        public final /* synthetic */ CharSequence $username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C85651(long j, CharSequence charSequence) {
            super(1);
            this.$communicationDisabledTimestampMs = j;
            this.$username = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            long jMax = Math.max(this.$communicationDisabledTimestampMs - WidgetEnableGuildCommunication.this.clock.currentTimeMillis(), 0L);
            TextView textView = WidgetEnableGuildCommunication.this.getBinding().f16587d;
            C12238m.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
            Context contextRequireContext = WidgetEnableGuildCommunication.this.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            C1107b.m221m(textView, C5419R.string.enable_guild_communication_body, new Object[]{this.$username, DurationUtilsKt.humanizeCountdownDuration(contextRequireContext, jMax)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$2 */
    /* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
    public static final class C85662 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C85662() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetEnableGuildCommunication.this.communicationDisabledCountdownSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$handleEnableGuildCommunication$1 */
    /* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
    public static final class C85671 extends AbstractC12240o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C85671(long j, long j2) {
            super(1);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(Void r7) {
            return new TrackNetworkActionUserCommunicationDisabledUpdate(Long.valueOf(this.$guildId), Long.valueOf(this.$userId), null, null, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$handleEnableGuildCommunication$2 */
    /* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
    public static final class C85682 extends AbstractC12240o implements Function1<Void, Unit> {
        public C85682() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetEnableGuildCommunication.this.dismiss();
            Context context = WidgetEnableGuildCommunication.this.getContext();
            Context context2 = WidgetEnableGuildCommunication.this.getContext();
            C0876m.m170h(context, context2 != null ? C1107b.m210b(context2, C5419R.string.guild_enable_communication_success, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null) : null, 0, null, 12);
        }
    }

    public WidgetEnableGuildCommunication() {
        super(C5419R.layout.widget_enable_guild_communication);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableGuildCommunication$binding$2.INSTANCE, null, 2, null);
        this.clock = ClockFactory.get();
    }

    private final void configureCommunicationDisabledTimer(long communicationDisabledTimestampMs, CharSequence username) {
        if (this.communicationDisabledCountdownSubscription != null) {
            return;
        }
        Observable<Long> observableM11061E = Observable.m11061E(0L, 1L, TimeUnit.SECONDS);
        C12238m.checkNotNullExpressionValue(observableM11061E, "Observable\n        .inte…0L, 1L, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11061E, this, null, 2, null), (Class<?>) WidgetEnableGuildCommunication.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C85662()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85651(communicationDisabledTimestampMs, username));
    }

    private final WidgetEnableGuildCommunicationBinding getBinding() {
        return (WidgetEnableGuildCommunicationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleEnableGuildCommunication(long guildId, long userId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().disableGuildCommunication(guildId, userId, new RestAPIParams.DisableGuildCommunication(null), null), false, 1, null), new C85671(guildId, userId)), this, null, 2, null), (Class<?>) WidgetEnableGuildCommunication.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85682());
    }

    public static final void launch(long j, long j2, FragmentManager fragmentManager) {
        INSTANCE.launch(j, j2, fragmentManager);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.communicationDisabledCountdownSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        final long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        final long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreUser users = companion.getUsers();
        GuildMember member = companion.getGuilds().getMember(j, j2);
        User user = users.getUsers().get(Long.valueOf(j2));
        if (member == null || user == null || !member.isCommunicationDisabled()) {
            return;
        }
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
        UtcDateTime communicationDisabledUntil = member.getCommunicationDisabledUntil();
        long dateTimeMillis = communicationDisabledUntil != null ? communicationDisabledUntil.getDateTimeMillis() : 0L;
        configureCommunicationDisabledTimer(dateTimeMillis, userNameWithDiscriminator$default);
        long jMax = Math.max(dateTimeMillis - this.clock.currentTimeMillis(), 0L);
        TextView textView = getBinding().f16587d;
        C12238m.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C1107b.m221m(textView, C5419R.string.enable_guild_communication_body, new Object[]{userNameWithDiscriminator$default, DurationUtilsKt.humanizeCountdownDuration(contextRequireContext, jMax)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        Context context = getContext();
        CharSequence charSequenceM210b = context != null ? C1107b.m210b(context, C5419R.string.enable_guild_communication_body_help_text, new Object[]{C0862f.f507a.m149a(4413305239191L, null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null) : null;
        TextView textView2 = getBinding().f16588e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.enableGuildCommunicationBodyHelpText");
        textView2.setText(charSequenceM210b);
        getBinding().f16588e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m821I(WidgetEnableGuildCommunication.this.getBinding().f16588e, "binding.enableGuildCommunicationBodyHelpText", "binding.enableGuildCommu…ationBodyHelpText.context"), C0862f.f507a.m149a(4413305239191L, null), false, false, null, 28, null);
            }
        });
        getBinding().f16585b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEnableGuildCommunication.this.dismiss();
            }
        });
        getBinding().f16586c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEnableGuildCommunication.this.handleEnableGuildCommunication(j, j2);
            }
        });
    }
}
