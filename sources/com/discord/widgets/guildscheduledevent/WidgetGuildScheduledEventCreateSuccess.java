package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteUiHelperKt;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildScheduledEventCreateSuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

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

    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, Long channelId, long guildId, long guildScheduledEventId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            C0870j.m156d(context, WidgetGuildScheduledEventCreateSuccess.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class C88511 extends AbstractC12240o implements Function1<WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded, Unit> {
        public C88511() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            C12238m.checkNotNullParameter(loaded, "viewState");
            WidgetGuildScheduledEventCreateSuccess.this.configureUI(loaded);
        }
    }

    public WidgetGuildScheduledEventCreateSuccess() {
        super(C5419R.layout.widget_guild_scheduled_event_create_success);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventCreateSuccess$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetGuildScheduledEventCreateSuccess$channelId$2(this));
        this.guildId = C12083g.lazy(new WidgetGuildScheduledEventCreateSuccess$guildId$2(this));
        this.guildScheduledEventId = C12083g.lazy(new WidgetGuildScheduledEventCreateSuccess$guildScheduledEventId$2(this));
        WidgetGuildScheduledEventCreateSuccess$viewModel$2 widgetGuildScheduledEventCreateSuccess$viewModel$2 = new WidgetGuildScheduledEventCreateSuccess$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGuildScheduledEventCreateSuccessViewModel.class), new C8844x6415a92c(c0865g0), new C0869i0(widgetGuildScheduledEventCreateSuccess$viewModel$2));
    }

    private final void configureUI(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded viewState) {
        final WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        final ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().f16976c;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().f16976c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInviteUiHelperKt.copyLinkClick(C1643a.m885x(view, "it", "it.context"), invite, WidgetGuildScheduledEventCreateSuccess.this.getMostRecentIntent());
            }
        });
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().f16977d;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        final Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.m8524i(getBinding().f16977d, GuildInviteUiHelperKt.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().f16977d.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i;
                WidgetGuildScheduledEventCreateSuccess.this.getBinding().f16977d.toggle();
                ModelInvite.Settings settings2 = widgetInviteModel.getSettings();
                if (settings2 != null) {
                    WidgetGuildScheduledEventCreateSuccessViewModel viewModel = WidgetGuildScheduledEventCreateSuccess.this.getViewModel();
                    CheckedSetting checkedSetting2 = WidgetGuildScheduledEventCreateSuccess.this.getBinding().f16977d;
                    C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteNeverExpire");
                    if (checkedSetting2.isChecked()) {
                        i = 0;
                    } else {
                        Experiment experiment = defaultInviteExperiment;
                        i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                    }
                    ModelInvite.Settings settingsMergeMaxAge = settings2.mergeMaxAge(i);
                    C12238m.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                    viewModel.updateInviteSettings(settingsMergeMaxAge);
                }
                Channel targetChannel = widgetInviteModel.getTargetChannel();
                if (targetChannel != null) {
                    WidgetGuildScheduledEventCreateSuccess.this.getViewModel().generateInviteLink(Long.valueOf(Long.valueOf(targetChannel.getId()).longValue()));
                }
            }
        });
        getBinding().f16975b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentActivity fragmentActivityM95e = WidgetGuildScheduledEventCreateSuccess.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
        getBinding().f16978e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelInvite modelInvite = invite;
                if (modelInvite != null) {
                    GuildInviteUiHelperKt.shareLinkClick(WidgetGuildScheduledEventCreateSuccess.this.getContext(), modelInvite);
                }
            }
        });
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
        Observable<R> observableM11083G = getViewModel().observeViewState().m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded");
                return (T) ((WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, this, null, 2, null), (Class<?>) WidgetGuildScheduledEventCreateSuccess.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88511());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getViewModel().generateInviteLink(getChannelId());
    }
}
