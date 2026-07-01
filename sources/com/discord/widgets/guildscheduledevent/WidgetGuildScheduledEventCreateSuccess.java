package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteUiHelper;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventCreateSuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            AppScreen2.d(context, WidgetGuildScheduledEventCreateSuccess.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetGuildScheduledEventCreateSuccess.this.configureUI(loaded);
        }
    }

    public WidgetGuildScheduledEventCreateSuccess() {
        super(R.layout.widget_guild_scheduled_event_create_success);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventCreateSuccess2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess3(this));
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess4(this));
        this.guildScheduledEventId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess5(this));
        WidgetGuildScheduledEventCreateSuccess6 widgetGuildScheduledEventCreateSuccess6 = new WidgetGuildScheduledEventCreateSuccess6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildScheduledEventCreateSuccessViewModel.class), new WidgetGuildScheduledEventCreateSuccess$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventCreateSuccess6));
    }

    private final void configureUI(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded viewState) {
        final WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        final ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInviteUiHelper.copyLinkClick(outline.x(view, "it", "it.context"), invite, WidgetGuildScheduledEventCreateSuccess.this.getMostRecentIntent());
            }
        });
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        final Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.i(getBinding().d, GuildInviteUiHelper.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().d.e(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i;
                WidgetGuildScheduledEventCreateSuccess.this.getBinding().d.toggle();
                ModelInvite.Settings settings2 = widgetInviteModel.getSettings();
                if (settings2 != null) {
                    WidgetGuildScheduledEventCreateSuccessViewModel viewModel = WidgetGuildScheduledEventCreateSuccess.this.getViewModel();
                    CheckedSetting checkedSetting2 = WidgetGuildScheduledEventCreateSuccess.this.getBinding().d;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteNeverExpire");
                    if (checkedSetting2.isChecked()) {
                        i = 0;
                    } else {
                        Experiment experiment = defaultInviteExperiment;
                        i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                    }
                    ModelInvite.Settings settingsMergeMaxAge = settings2.mergeMaxAge(i);
                    Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                    viewModel.updateInviteSettings(settingsMergeMaxAge);
                }
                Channel targetChannel = widgetInviteModel.getTargetChannel();
                if (targetChannel != null) {
                    WidgetGuildScheduledEventCreateSuccess.this.getViewModel().generateInviteLink(Long.valueOf(Long.valueOf(targetChannel.getId()).longValue()));
                }
            }
        });
        getBinding().f2442b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentActivity fragmentActivityE = WidgetGuildScheduledEventCreateSuccess.this.e();
                if (fragmentActivityE != null) {
                    fragmentActivityE.finish();
                }
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelInvite modelInvite = invite;
                if (modelInvite != null) {
                    GuildInviteUiHelper.shareLinkClick(WidgetGuildScheduledEventCreateSuccess.this.getContext(), modelInvite);
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
        Observable<R> observableG = getViewModel().observeViewState().y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded");
                return (T) ((WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), (Class<?>) WidgetGuildScheduledEventCreateSuccess.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getViewModel().generateInviteLink(getChannelId());
    }
}
