package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetPreviewGuildScheduledEventBinding;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPreviewGuildScheduledEvent.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", 0)};
    public static final WidgetPreviewGuildScheduledEvent$Companion Companion = new WidgetPreviewGuildScheduledEvent$Companion(null);
    public static final String EXTRA_EVENT_CREATED = "INTENT_EXTRA_EVENT_CREATED";
    private static final String EXTRA_EVENT_MODEL = "INTENT_EXTRA_EVENT_MODEL";
    private static final String EXTRA_EXISTING_EVENT_DATA = "INTENT_EXTRA_EXISTING_EVENT_DATA";
    private static final int RESULT_QUIT = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: eventModel$delegate, reason: from kotlin metadata */
    private final Lazy eventModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetPreviewGuildScheduledEvent() {
        super(R$layout.widget_preview_guild_scheduled_event);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPreviewGuildScheduledEvent$binding$2.INSTANCE, null, 2, null);
        this.eventModel = g.lazy(new WidgetPreviewGuildScheduledEvent$eventModel$2(this));
        WidgetPreviewGuildScheduledEvent$viewModel$2 widgetPreviewGuildScheduledEvent$viewModel$2 = new WidgetPreviewGuildScheduledEvent$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(PreviewGuildScheduledEventViewModel.class), new WidgetPreviewGuildScheduledEvent$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetPreviewGuildScheduledEvent$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUi(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent, PreviewGuildScheduledEventViewModel$ViewState previewGuildScheduledEventViewModel$ViewState) {
        widgetPreviewGuildScheduledEvent.configureUi(previewGuildScheduledEventViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetPreviewGuildScheduledEventBinding access$getBinding$p(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        return widgetPreviewGuildScheduledEvent.getBinding();
    }

    public static final /* synthetic */ GuildScheduledEventModel access$getEventModel$p(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        return widgetPreviewGuildScheduledEvent.getEventModel();
    }

    public static final /* synthetic */ PreviewGuildScheduledEventViewModel access$getViewModel$p(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        return widgetPreviewGuildScheduledEvent.getViewModel();
    }

    private final void configureTextForCreation(PreviewGuildScheduledEventViewModel$ViewState$Initialized viewState) {
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.confirmGuildScheduledEventSubtitle");
        textView.setVisibility(8);
        TextView textView2 = getBinding().g;
        ViewGroup$LayoutParams layoutParams = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.setMargins(DimenUtils.dpToPixels(16), DimenUtils.dpToPixels(24), DimenUtils.dpToPixels(16), 0);
        textView2.setLayoutParams(viewGroup$MarginLayoutParams);
        textView2.setText(b.j(textView2, 2131890115, new Object[0], null, 4));
        TextView textView3 = getBinding().h;
        m.checkNotNullExpressionValue(textView3, "binding.createEventSubtitle");
        textView3.setVisibility(0);
        GuildScheduledEventLocationInfo locationInfo = viewState.getLocationInfo();
        if (locationInfo instanceof GuildScheduledEventLocationInfo$ChannelLocation) {
            String locationName = viewState.getLocationInfo().getLocationName();
            TextView textView4 = getBinding().h;
            m.checkNotNullExpressionValue(textView4, "binding.createEventSubtitle");
            b.m(textView4, 2131890113, new Object[0], new WidgetPreviewGuildScheduledEvent$configureTextForCreation$2(this, locationName, viewState));
            return;
        }
        if (locationInfo instanceof GuildScheduledEventLocationInfo$ExternalLocation) {
            TextView textView5 = getBinding().h;
            m.checkNotNullExpressionValue(textView5, "binding.createEventSubtitle");
            textView5.setText(getString(2131890114));
        }
    }

    private final void configureTextForStart(PreviewGuildScheduledEventViewModel$ViewState$Initialized viewState) {
        TextView textView = getBinding().f;
        textView.setVisibility(0);
        textView.setText(getString(2131895867));
        getBinding().g.setText(viewState.getEventModel().getName());
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.createEventSubtitle");
        textView2.setVisibility(8);
    }

    private final void configureUi(PreviewGuildScheduledEventViewModel$ViewState viewState) {
        int i;
        if (viewState instanceof PreviewGuildScheduledEventViewModel$ViewState$Invalid) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (viewState instanceof PreviewGuildScheduledEventViewModel$ViewState$Initialized) {
            PreviewGuildScheduledEventViewModel$ViewState$Initialized previewGuildScheduledEventViewModel$ViewState$Initialized = (PreviewGuildScheduledEventViewModel$ViewState$Initialized) viewState;
            GuildScheduledEventLocationInfo locationInfo = previewGuildScheduledEventViewModel$ViewState$Initialized.getLocationInfo();
            if (!(locationInfo instanceof GuildScheduledEventLocationInfo$ChannelLocation)) {
                locationInfo = null;
            }
            GuildScheduledEventLocationInfo$ChannelLocation guildScheduledEventLocationInfo$ChannelLocation = (GuildScheduledEventLocationInfo$ChannelLocation) locationInfo;
            Channel channel = guildScheduledEventLocationInfo$ChannelLocation != null ? guildScheduledEventLocationInfo$ChannelLocation.getChannel() : null;
            UserGuildMember creatorUserGuildMember$default = GuildScheduledEventUtilitiesKt.getCreatorUserGuildMember$default(previewGuildScheduledEventViewModel$ViewState$Initialized.getEventModel(), (StoreGuilds) null, (StoreUser) null, 3, (Object) null);
            GuildScheduledEventItemView guildScheduledEventItemView = getBinding().e;
            GuildScheduledEventModel eventModel = previewGuildScheduledEventViewModel$ViewState$Initialized.getEventModel();
            if (creatorUserGuildMember$default == null) {
                creatorUserGuildMember$default = new UserGuildMember(StoreStream.Companion.getUsers().getMeSnapshot(), null);
            }
            guildScheduledEventItemView.configureAsPreview(eventModel, channel, creatorUserGuildMember$default);
            MaterialButton materialButton = getBinding().i;
            materialButton.setEnabled(!previewGuildScheduledEventViewModel$ViewState$Initialized.getRequestProcessing());
            materialButton.setBackgroundTintList(ContextCompat.getColorStateList(materialButton.getContext(), previewGuildScheduledEventViewModel$ViewState$Initialized.getIsStartingEvent() ? 2131100471 : 2131100470));
            Context context = materialButton.getContext();
            m.checkNotNullExpressionValue(context, "context");
            WidgetPreviewGuildScheduledEvent$Companion$Action existingEventAction = previewGuildScheduledEventViewModel$ViewState$Initialized.getExistingEventAction();
            if (existingEventAction == null) {
                i = 2131895236;
            } else {
                int iOrdinal = existingEventAction.ordinal();
                if (iOrdinal == 0) {
                    i = 2131888630;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = 2131895865;
                }
            }
            materialButton.setText(b.h(context, i, new Object[0], null, 4));
            ImageView imageView = getBinding().f2512b;
            m.checkNotNullExpressionValue(imageView, "binding.backButton");
            imageView.setVisibility(previewGuildScheduledEventViewModel$ViewState$Initialized.getIsStartingEvent() ^ true ? 0 : 8);
            TextView textView = getBinding().j;
            m.checkNotNullExpressionValue(textView, "binding.stepText");
            textView.setVisibility(previewGuildScheduledEventViewModel$ViewState$Initialized.getIsStartingEvent() ^ true ? 0 : 8);
            if (previewGuildScheduledEventViewModel$ViewState$Initialized.getIsStartingEvent()) {
                configureTextForStart(previewGuildScheduledEventViewModel$ViewState$Initialized);
            } else {
                configureTextForCreation(previewGuildScheduledEventViewModel$ViewState$Initialized);
            }
            CheckedSetting checkedSetting = getBinding().d;
            m.checkNotNullExpressionValue(checkedSetting, "binding.confirmGuildScheduledEventNotify");
            checkedSetting.setVisibility(previewGuildScheduledEventViewModel$ViewState$Initialized.getCanNotifyEveryone() ? 0 : 8);
        }
    }

    private final WidgetPreviewGuildScheduledEventBinding getBinding() {
        return (WidgetPreviewGuildScheduledEventBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildScheduledEventModel getEventModel() {
        return (GuildScheduledEventModel) this.eventModel.getValue();
    }

    private final PreviewGuildScheduledEventViewModel getViewModel() {
        return (PreviewGuildScheduledEventViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetPreviewGuildScheduledEvent.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetPreviewGuildScheduledEvent$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().j;
        m.checkNotNullExpressionValue(textView, "binding.stepText");
        b.n(textView, 2131890132, new Object[]{3, 3}, null, 4);
        getBinding().f2512b.setOnClickListener(new WidgetPreviewGuildScheduledEvent$onViewBound$1(this));
        getBinding().c.setOnClickListener(new WidgetPreviewGuildScheduledEvent$onViewBound$2(this));
        getBinding().i.setOnClickListener(new WidgetPreviewGuildScheduledEvent$onViewBound$3(this));
    }
}
