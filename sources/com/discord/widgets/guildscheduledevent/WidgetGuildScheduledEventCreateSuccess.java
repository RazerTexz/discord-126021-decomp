package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteUiHelperKt;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventCreateSuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0)};
    public static final WidgetGuildScheduledEventCreateSuccess$Companion Companion = new WidgetGuildScheduledEventCreateSuccess$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: guildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy guildScheduledEventId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildScheduledEventCreateSuccess() {
        super(R$layout.widget_guild_scheduled_event_create_success);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventCreateSuccess$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetGuildScheduledEventCreateSuccess$channelId$2(this));
        this.guildId = g.lazy(new WidgetGuildScheduledEventCreateSuccess$guildId$2(this));
        this.guildScheduledEventId = g.lazy(new WidgetGuildScheduledEventCreateSuccess$guildScheduledEventId$2(this));
        WidgetGuildScheduledEventCreateSuccess$viewModel$2 widgetGuildScheduledEventCreateSuccess$viewModel$2 = new WidgetGuildScheduledEventCreateSuccess$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildScheduledEventCreateSuccessViewModel.class), new WidgetGuildScheduledEventCreateSuccess$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventCreateSuccess$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess, WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded) {
        widgetGuildScheduledEventCreateSuccess.configureUI(widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventCreateSuccessBinding access$getBinding$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getBinding();
    }

    public static final /* synthetic */ Long access$getChannelId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getGuildId();
    }

    public static final /* synthetic */ long access$getGuildScheduledEventId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getGuildScheduledEventId();
    }

    public static final /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getViewModel();
    }

    private final void configureUI(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.guildInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().c.setOnClickListener(new WidgetGuildScheduledEventCreateSuccess$configureUI$1(this, invite));
        ModelInvite$Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.i(getBinding().d, GuildInviteUiHelperKt.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().d.e(new WidgetGuildScheduledEventCreateSuccess$configureUI$2(this, widgetInviteModel, defaultInviteExperiment));
        getBinding().f2442b.setOnClickListener(new WidgetGuildScheduledEventCreateSuccess$configureUI$3(this));
        getBinding().e.setOnClickListener(new WidgetGuildScheduledEventCreateSuccess$configureUI$4(this, invite));
    }

    private final WidgetGuildScheduledEventCreateSuccessBinding getBinding() {
        return (WidgetGuildScheduledEventCreateSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getChannelId() {
        return (Long) this.channelId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildScheduledEventId() {
        return ((Number) this.guildScheduledEventId.getValue()).longValue();
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildScheduledEventCreateSuccessViewModel getViewModel() {
        return (WidgetGuildScheduledEventCreateSuccessViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), WidgetGuildScheduledEventCreateSuccess.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventCreateSuccess$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getViewModel().generateInviteLink(getChannelId());
    }
}
