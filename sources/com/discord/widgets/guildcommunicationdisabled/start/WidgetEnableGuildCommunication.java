package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.f;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableGuildCommunicationBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams$DisableGuildCommunication;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.duration.DurationUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", 0)};
    public static final WidgetEnableGuildCommunication$Companion Companion = new WidgetEnableGuildCommunication$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Clock clock;
    private Subscription communicationDisabledCountdownSubscription;

    public WidgetEnableGuildCommunication() {
        super(R$layout.widget_enable_guild_communication);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableGuildCommunication$binding$2.INSTANCE, null, 2, null);
        this.clock = ClockFactory.get();
    }

    public static final /* synthetic */ WidgetEnableGuildCommunicationBinding access$getBinding$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.getBinding();
    }

    public static final /* synthetic */ Clock access$getClock$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.clock;
    }

    public static final /* synthetic */ Subscription access$getCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.communicationDisabledCountdownSubscription;
    }

    public static final /* synthetic */ void access$handleEnableGuildCommunication(WidgetEnableGuildCommunication widgetEnableGuildCommunication, long j, long j2) {
        widgetEnableGuildCommunication.handleEnableGuildCommunication(j, j2);
    }

    public static final /* synthetic */ void access$setCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication, Subscription subscription) {
        widgetEnableGuildCommunication.communicationDisabledCountdownSubscription = subscription;
    }

    private final void configureCommunicationDisabledTimer(long communicationDisabledTimestampMs, CharSequence username) {
        if (this.communicationDisabledCountdownSubscription != null) {
            return;
        }
        Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableE, "Observable\n        .inte…0L, 1L, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableE, this, null, 2, null), WidgetEnableGuildCommunication.class, (Context) null, new WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$2(this), (Function1) null, (Function0) null, (Function0) null, new WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$1(this, communicationDisabledTimestampMs, username), 58, (Object) null);
    }

    private final WidgetEnableGuildCommunicationBinding getBinding() {
        return (WidgetEnableGuildCommunicationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleEnableGuildCommunication(long guildId, long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApiSerializeNulls().disableGuildCommunication(guildId, userId, new RestAPIParams$DisableGuildCommunication(null), null), false, 1, null), new WidgetEnableGuildCommunication$handleEnableGuildCommunication$1(guildId, userId)), this, null, 2, null), WidgetEnableGuildCommunication.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEnableGuildCommunication$handleEnableGuildCommunication$2(this), 60, (Object) null);
    }

    public static final void launch(long j, long j2, FragmentManager fragmentManager) {
        Companion.launch(j, j2, fragmentManager);
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreUser users = storeStream$Companion.getUsers();
        GuildMember member = storeStream$Companion.getGuilds().getMember(j, j2);
        User user = users.getUsers().get(Long.valueOf(j2));
        if (member == null || user == null || !member.isCommunicationDisabled()) {
            return;
        }
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
        UtcDateTime communicationDisabledUntil = member.getCommunicationDisabledUntil();
        long dateTimeMillis = communicationDisabledUntil != null ? communicationDisabledUntil.getDateTimeMillis() : 0L;
        configureCommunicationDisabledTimer(dateTimeMillis, userNameWithDiscriminator$default);
        long jMax = Math.max(dateTimeMillis - this.clock.currentTimeMillis(), 0L);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        b.n(textView, 2131888849, new Object[]{userNameWithDiscriminator$default, DurationUtilsKt.humanizeCountdownDuration(contextRequireContext, jMax)}, null, 4);
        Context context = getContext();
        CharSequence charSequenceH = context != null ? b.h(context, 2131888850, new Object[]{f.a.a(4413305239191L, null)}, null, 4) : null;
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.enableGuildCommunicationBodyHelpText");
        textView2.setText(charSequenceH);
        getBinding().e.setOnClickListener(new WidgetEnableGuildCommunication$onViewBound$1(this));
        getBinding().f2379b.setOnClickListener(new WidgetEnableGuildCommunication$onViewBound$2(this));
        getBinding().c.setOnClickListener(new WidgetEnableGuildCommunication$onViewBound$3(this, j, j2));
    }
}
