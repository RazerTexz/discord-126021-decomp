package com.discord.widgets.channels.settings;

import android.app.AlertDialog;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.s4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0)};
    public static final WidgetThreadSettings$Companion Companion = new WidgetThreadSettings$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetThreadSettings() {
        super(R$layout.widget_thread_settings);
        WidgetThreadSettings$viewModel$2 widgetThreadSettings$viewModel$2 = new WidgetThreadSettings$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadSettingsViewModel.class), new WidgetThreadSettings$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetThreadSettings$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadSettings$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadSettings widgetThreadSettings, WidgetThreadSettingsViewModel$ViewState widgetThreadSettingsViewModel$ViewState) {
        widgetThreadSettings.configureUI(widgetThreadSettingsViewModel$ViewState);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetThreadSettings widgetThreadSettings, Channel channel) {
        widgetThreadSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetThreadSettingsBinding access$getBinding$p(WidgetThreadSettings widgetThreadSettings) {
        return widgetThreadSettings.getBinding();
    }

    public static final /* synthetic */ WidgetThreadSettingsViewModel access$getViewModel$p(WidgetThreadSettings widgetThreadSettings) {
        return widgetThreadSettings.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetThreadSettings widgetThreadSettings, WidgetThreadSettingsViewModel$Event widgetThreadSettingsViewModel$Event) {
        widgetThreadSettings.handleEvent(widgetThreadSettingsViewModel$Event);
    }

    public static final /* synthetic */ void access$setSlowmodeLabel(WidgetThreadSettings widgetThreadSettings, int i) {
        widgetThreadSettings.setSlowmodeLabel(i);
    }

    private final void configureUI(WidgetThreadSettingsViewModel$ViewState viewState) {
        if (!(viewState instanceof WidgetThreadSettingsViewModel$ViewState$Valid)) {
            requireActivity().finish();
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131896393);
        WidgetThreadSettingsViewModel$ViewState$Valid widgetThreadSettingsViewModel$ViewState$Valid = (WidgetThreadSettingsViewModel$ViewState$Valid) viewState;
        setActionBarSubtitle(ChannelUtils.e(widgetThreadSettingsViewModel$ViewState$Valid.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(R$menu.menu_text_channel_settings, new WidgetThreadSettings$configureUI$1(this, viewState), new WidgetThreadSettings$configureUI$2(viewState));
        LinearLayout linearLayout = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout, "binding.threadSettingsEditWrap");
        linearLayout.setVisibility(widgetThreadSettingsViewModel$ViewState$Valid.getCanManageThread() ? 0 : 8);
        String channelNameDraft = widgetThreadSettingsViewModel$ViewState$Valid.getChannelNameDraft();
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        if (!m.areEqual(channelNameDraft, ViewExtensions.getTextOrEmpty(textInputLayout))) {
            TextInputLayout textInputLayout2 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.threadSettingsEditName");
            ViewExtensions.setText(textInputLayout2, widgetThreadSettingsViewModel$ViewState$Valid.getChannelNameDraft());
        }
        LinearLayout linearLayout2 = getBinding().g;
        m.checkNotNullExpressionValue(linearLayout2, "binding.threadSettingsSectionSlowMode");
        linearLayout2.setVisibility(widgetThreadSettingsViewModel$ViewState$Valid.getCanManageThread() ? 0 : 8);
        int slowModeCooldownDraft = widgetThreadSettingsViewModel$ViewState$Valid.getSlowModeCooldownDraft();
        setSlowmodeLabel(slowModeCooldownDraft);
        Iterator<Integer> it = WidgetTextChannelSettings.Companion.getSLOWMODE_COOLDOWN_VALUES().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().intValue() >= slowModeCooldownDraft) {
                    break;
                } else {
                    i++;
                }
            }
        }
        SeekBar seekBar = getBinding().i;
        m.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        SeekBar seekBar2 = getBinding().i;
        m.checkNotNullExpressionValue(seekBar2, "binding.threadSettingsSlowModeCooldownSlider");
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView.getText());
        TextView textView2 = getBinding().f2672b;
        m.checkNotNullExpressionValue(textView2, "binding.channelSettingsPinnedMessages");
        textView2.setEnabled(widgetThreadSettingsViewModel$ViewState$Valid.isPinsEnabled());
        getBinding().f2672b.setOnClickListener(new WidgetThreadSettings$configureUI$3(viewState));
        View view = getBinding().c;
        m.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(true ^ widgetThreadSettingsViewModel$ViewState$Valid.isPinsEnabled() ? 0 : 8);
        getBinding().c.setOnClickListener(WidgetThreadSettings$configureUI$4.INSTANCE);
        FloatingActionButton floatingActionButton = getBinding().f;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.threadSettingsSave");
        floatingActionButton.setVisibility(widgetThreadSettingsViewModel$ViewState$Valid.getHasUnsavedChanges() ? 0 : 8);
        getBinding().f.setOnClickListener(new WidgetThreadSettings$configureUI$5(this));
    }

    private final void confirmDelete(Channel channel) {
        s4 s4VarA = s4.a(LayoutInflater.from(getContext()), null, false);
        m.checkNotNullExpressionValue(s4VarA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog$Builder(linearLayout.getContext()).setView(s4VarA.a).create();
        s4VarA.e.setText(2131888404);
        s4VarA.c.setOnClickListener(new WidgetThreadSettings$confirmDelete$1(alertDialogCreate));
        s4VarA.d.setOnClickListener(new WidgetThreadSettings$confirmDelete$2(this, channel));
        TextView textView = s4VarA.f199b;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        b.n(textView, 2131888378, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetThreadSettingsBinding getBinding() {
        return (WidgetThreadSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadSettingsViewModel getViewModel() {
        return (WidgetThreadSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetThreadSettingsViewModel$Event event) {
        if (event instanceof WidgetThreadSettingsViewModel$Event$ShowToast) {
            b.a.d.m.i(this, ((WidgetThreadSettingsViewModel$Event$ShowToast) event).getMessageStringRes(), 0, 4);
        }
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        WidgetTextChannelSettings$Companion widgetTextChannelSettings$Companion = WidgetTextChannelSettings.Companion;
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        widgetTextChannelSettings$Companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), 2131889270);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetThreadSettings$onViewBound$1(this));
        SeekBar seekBar = getBinding().i;
        m.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setMax(n.getLastIndex(WidgetTextChannelSettings.Companion.getSLOWMODE_COOLDOWN_VALUES()));
        getBinding().i.setOnSeekBarChangeListener(new WidgetThreadSettings$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetThreadSettingsViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadSettings$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
