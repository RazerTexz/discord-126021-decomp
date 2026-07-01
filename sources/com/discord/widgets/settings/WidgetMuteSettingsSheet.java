package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetMuteSettingsSheetBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Companion;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet extends AppBottomSheet {
    private static final float ACTIVE_OPACITY = 1.0f;
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final float INACTIVE_OPACITY = 0.2f;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetMuteSettingsSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", 0)};
    public static final WidgetMuteSettingsSheet$Companion Companion = new WidgetMuteSettingsSheet$Companion(null);

    public WidgetMuteSettingsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetMuteSettingsSheet$binding$2.INSTANCE, null, 2, null);
        WidgetMuteSettingsSheet$viewModel$2 widgetMuteSettingsSheet$viewModel$2 = new WidgetMuteSettingsSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(MuteSettingsSheetViewModel.class), new WidgetMuteSettingsSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetMuteSettingsSheet$viewModel$2));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetMuteSettingsSheetBinding access$getBinding$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getBinding();
    }

    public static final /* synthetic */ MuteSettingsSheetViewModel access$getViewModel$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetMuteSettingsSheet widgetMuteSettingsSheet, MuteSettingsSheetViewModel$Event muteSettingsSheetViewModel$Event) {
        widgetMuteSettingsSheet.handleEvent(muteSettingsSheetViewModel$Event);
    }

    public static final /* synthetic */ void access$updateViews(WidgetMuteSettingsSheet widgetMuteSettingsSheet, MuteSettingsSheetViewModel$ViewState muteSettingsSheetViewModel$ViewState) {
        widgetMuteSettingsSheet.updateViews(muteSettingsSheetViewModel$ViewState);
    }

    private final void configureNotificationSettings(MuteSettingsSheetViewModel$ViewState$Loaded viewState) {
        CharSequence charSequenceK;
        CharSequence charSequenceE;
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.notificationSettingsOverridesLabel");
        int notificationSetting = viewState.getNotificationSetting();
        if (notificationSetting == ModelNotificationSettings.FREQUENCY_ALL) {
            charSequenceK = b.k(this, 2131889131, new Object[0], null, 4);
        } else if (notificationSetting == ModelNotificationSettings.FREQUENCY_MENTIONS) {
            charSequenceK = b.k(this, 2131889234, new Object[0], null, 4);
        } else {
            charSequenceK = notificationSetting == ModelNotificationSettings.FREQUENCY_NOTHING ? b.k(this, 2131889227, new Object[0], null, 4) : "";
        }
        textView.setText(charSequenceK);
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal != 0) {
            boolean z2 = true;
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 5) {
                if (!viewState.isChannelMuted() && !viewState.isGuildMuted()) {
                    z2 = false;
                }
                if (z2) {
                    TextView textView2 = getBinding().f;
                    m.checkNotNullExpressionValue(textView2, "binding.notificationSettingsLabel");
                    textView2.setAlpha(0.2f);
                    getBinding().d.setOnClickListener(null);
                    TextView textView3 = getBinding().f2498b;
                    m.checkNotNullExpressionValue(textView3, "binding.channelMutedDetails");
                    textView3.setVisibility(0);
                    TextView textView4 = getBinding().f2498b;
                    m.checkNotNullExpressionValue(textView4, "binding.channelMutedDetails");
                    if (viewState.isChannelMuted()) {
                        charSequenceE = b.k(this, 2131889072, new Object[0], null, 4);
                    } else {
                        charSequenceE = b.e(this, 2131889196, new Object[0], new WidgetMuteSettingsSheet$configureNotificationSettings$1(this));
                    }
                    textView4.setText(charSequenceE);
                } else {
                    TextView textView5 = getBinding().f;
                    m.checkNotNullExpressionValue(textView5, "binding.notificationSettingsLabel");
                    textView5.setAlpha(1.0f);
                    getBinding().d.setOnClickListener(new WidgetMuteSettingsSheet$configureNotificationSettings$2(this));
                    TextView textView6 = getBinding().f2498b;
                    m.checkNotNullExpressionValue(textView6, "binding.channelMutedDetails");
                    textView6.setVisibility(8);
                }
                FrameLayout frameLayout = getBinding().e;
                m.checkNotNullExpressionValue(frameLayout, "binding.notificationSettingsButtonContainer");
                frameLayout.setVisibility(0);
                return;
            }
        }
        FrameLayout frameLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(frameLayout2, "binding.notificationSettingsButtonContainer");
        frameLayout2.setVisibility(8);
        TextView textView7 = getBinding().f2498b;
        m.checkNotNullExpressionValue(textView7, "binding.channelMutedDetails");
        textView7.setVisibility(8);
    }

    private final void configureUnmuteButton(MuteSettingsSheetViewModel$ViewState$Loaded viewState) {
        CharSequence charSequenceE;
        WidgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1 widgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1 = new WidgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1(this);
        if (!viewState.isChannelMuted()) {
            LinearLayout linearLayout = getBinding().o;
            m.checkNotNullExpressionValue(linearLayout, "binding.unmuteButton");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().c;
            m.checkNotNullExpressionValue(linearLayout2, "binding.muteSettingsSheetMuteOptions");
            linearLayout2.setVisibility(0);
            return;
        }
        TextView textView = getBinding().q;
        m.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        b.m(textView, 2131896589, new Object[]{viewState.getSubtitle()}, widgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1);
        TextView textView2 = getBinding().p;
        m.checkNotNullExpressionValue(textView2, "binding.unmuteButtonDetailsLabel");
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            String muteEndTime = viewState.getMuteEndTime();
            charSequenceE = muteEndTime == null ? b.e(this, 2131889198, new Object[0], widgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1) : b.e(this, 2131889199, new Object[]{parseMuteEndtime(muteEndTime)}, widgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1);
        } else {
            String muteEndTime2 = viewState.getMuteEndTime();
            charSequenceE = muteEndTime2 == null ? b.e(this, 2131889193, new Object[0], widgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1) : b.e(this, 2131889194, new Object[]{parseMuteEndtime(muteEndTime2)}, widgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1);
        }
        textView2.setText(charSequenceE);
        LinearLayout linearLayout3 = getBinding().o;
        m.checkNotNullExpressionValue(linearLayout3, "binding.unmuteButton");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout4, "binding.muteSettingsSheetMuteOptions");
        linearLayout4.setVisibility(8);
    }

    private final WidgetMuteSettingsSheetBinding getBinding() {
        return (WidgetMuteSettingsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MuteSettingsSheetViewModel getViewModel() {
        return (MuteSettingsSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(MuteSettingsSheetViewModel$Event event) {
        if (event instanceof MuteSettingsSheetViewModel$Event$Dismiss) {
            dismiss();
        } else if (event instanceof MuteSettingsSheetViewModel$Event$NavigateToChannelSettings) {
            WidgetChannelNotificationSettings$Companion widgetChannelNotificationSettings$Companion = WidgetChannelNotificationSettings.Companion;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetChannelNotificationSettings$Companion.launch$default(widgetChannelNotificationSettings$Companion, contextRequireContext, ((MuteSettingsSheetViewModel$Event$NavigateToChannelSettings) event).getChannelId(), false, 4, null);
        }
    }

    private final String parseMuteEndtime(String muteEndTime) {
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, contextRequireContext, null, 3, 3, 4, null);
    }

    public static final void showForChannel(long j, FragmentManager fragmentManager) {
        Companion.showForChannel(j, fragmentManager);
    }

    private final void updateViews(MuteSettingsSheetViewModel$ViewState viewState) {
        Integer num;
        if (!(viewState instanceof MuteSettingsSheetViewModel$ViewState$Loaded)) {
            if (viewState instanceof MuteSettingsSheetViewModel$ViewState$Failure) {
                b.a.d.m.i(this, 2131888366, 0, 4);
                dismiss();
                return;
            }
            return;
        }
        MuteSettingsSheetViewModel$ViewState$Loaded muteSettingsSheetViewModel$ViewState$Loaded = (MuteSettingsSheetViewModel$ViewState$Loaded) viewState;
        int iOrdinal = muteSettingsSheetViewModel$ViewState$Loaded.getSettingsType().ordinal();
        if (iOrdinal == 0) {
            num = 2131893155;
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            num = 2131893156;
        } else if (iOrdinal == 3) {
            num = 2131893157;
        } else if (iOrdinal != 4) {
            num = iOrdinal != 5 ? null : 2131893152;
        } else {
            num = 2131893153;
        }
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(num != null ? b.k(this, num.intValue(), new Object[0], null, 4) : null);
        TextView textView2 = getBinding().m;
        m.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(muteSettingsSheetViewModel$ViewState$Loaded.getSubtitle());
        configureUnmuteButton(muteSettingsSheetViewModel$ViewState$Loaded);
        configureNotificationSettings(muteSettingsSheetViewModel$ViewState$Loaded);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        getBinding().o.setOnClickListener(new WidgetMuteSettingsSheet$bindSubscriptions$1(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMuteSettingsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetMuteSettingsSheet$bindSubscriptions$2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetMuteSettingsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetMuteSettingsSheet$bindSubscriptions$3(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_mute_settings_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().j.setOnClickListener(new WidgetMuteSettingsSheet$onViewCreated$1(this));
        getBinding().k.setOnClickListener(new WidgetMuteSettingsSheet$onViewCreated$2(this));
        getBinding().i.setOnClickListener(new WidgetMuteSettingsSheet$onViewCreated$3(this));
        getBinding().l.setOnClickListener(new WidgetMuteSettingsSheet$onViewCreated$4(this));
        getBinding().h.setOnClickListener(new WidgetMuteSettingsSheet$onViewCreated$5(this));
    }
}
