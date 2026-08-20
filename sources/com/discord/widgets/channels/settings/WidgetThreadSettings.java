package com.discord.widgets.channels.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1049s4;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1337j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetThreadSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetThreadSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long channelId, Context context) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            C0870j.m156d(context, WidgetThreadSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetThreadSettings.kt */
    public static final class C76161 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C76161() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            WidgetThreadSettings.this.getViewModel().onChannelNameInputChanged(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetThreadSettings.kt */
    public static final /* synthetic */ class C76181 extends C12236k implements Function1<WidgetThreadSettingsViewModel.ViewState, Unit> {
        public C76181(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetThreadSettings) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetThreadSettings.kt */
    public static final /* synthetic */ class C76192 extends C12236k implements Function1<WidgetThreadSettingsViewModel.Event, Unit> {
        public C76192(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetThreadSettings) this.receiver).handleEvent(event);
        }
    }

    public WidgetThreadSettings() {
        super(C5419R.layout.widget_thread_settings);
        WidgetThreadSettings$viewModel$2 widgetThreadSettings$viewModel$2 = new WidgetThreadSettings$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetThreadSettingsViewModel.class), new WidgetThreadSettings$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetThreadSettings$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadSettings$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(final WidgetThreadSettingsViewModel.ViewState viewState) {
        if (!(viewState instanceof WidgetThreadSettingsViewModel.ViewState.Valid)) {
            requireActivity().finish();
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.thread_settings);
        WidgetThreadSettingsViewModel.ViewState.Valid valid = (WidgetThreadSettingsViewModel.ViewState.Valid) viewState;
        setActionBarSubtitle(ChannelUtils.m7681e(valid.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(C5419R.menu.menu_text_channel_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_channel_settings_delete) {
                    return;
                }
                WidgetThreadSettings.this.confirmDelete(((WidgetThreadSettingsViewModel.ViewState.Valid) viewState).getChannel());
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.2
            @Override // p658rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_channel_settings_delete);
                C12238m.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
                menuItemFindItem.setVisible(((WidgetThreadSettingsViewModel.ViewState.Valid) viewState).getCanManageThread());
                menu.findItem(C5419R.id.menu_channel_settings_delete).setTitle(C5419R.string.delete_thread);
                MenuItem menuItemFindItem2 = menu.findItem(C5419R.id.menu_channel_settings_reset);
                C12238m.checkNotNullExpressionValue(menuItemFindItem2, "it.findItem(R.id.menu_channel_settings_reset)");
                menuItemFindItem2.setVisible(false);
            }
        });
        LinearLayout linearLayout = getBinding().f18284e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.threadSettingsEditWrap");
        linearLayout.setVisibility(valid.getCanManageThread() ? 0 : 8);
        String channelNameDraft = valid.getChannelNameDraft();
        TextInputLayout textInputLayout = getBinding().f18283d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        if (!C12238m.areEqual(channelNameDraft, ViewExtensions.getTextOrEmpty(textInputLayout))) {
            TextInputLayout textInputLayout2 = getBinding().f18283d;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.threadSettingsEditName");
            ViewExtensions.setText(textInputLayout2, valid.getChannelNameDraft());
        }
        LinearLayout linearLayout2 = getBinding().f18286g;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.threadSettingsSectionSlowMode");
        linearLayout2.setVisibility(valid.getCanManageThread() ? 0 : 8);
        int slowModeCooldownDraft = valid.getSlowModeCooldownDraft();
        setSlowmodeLabel(slowModeCooldownDraft);
        Iterator<Integer> it = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().iterator();
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
        SeekBar seekBar = getBinding().f18288i;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        SeekBar seekBar2 = getBinding().f18288i;
        C12238m.checkNotNullExpressionValue(seekBar2, "binding.threadSettingsSlowModeCooldownSlider");
        TextView textView = getBinding().f18287h;
        C12238m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView.getText());
        TextView textView2 = getBinding().f18281b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.channelSettingsPinnedMessages");
        textView2.setEnabled(valid.isPinsEnabled());
        getBinding().f18281b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelPinnedMessages.INSTANCE.show(C1643a.m885x(view, "it", "it.context"), ((WidgetThreadSettingsViewModel.ViewState.Valid) viewState).getChannel().getId());
            }
        });
        View view = getBinding().f18282c;
        C12238m.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(true ^ valid.isPinsEnabled() ? 0 : 8);
        getBinding().f18282c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C12238m.checkNotNullExpressionValue(view2, "it");
                C0876m.m169g(view2.getContext(), C5419R.string.pins_disabled_nsfw, 0, null, 12);
            }
        });
        FloatingActionButton floatingActionButton = getBinding().f18285f;
        C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.threadSettingsSave");
        floatingActionButton.setVisibility(valid.getHasUnsavedChanges() ? 0 : 8);
        getBinding().f18285f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetThreadSettings.this.getViewModel().saveThread();
            }
        });
    }

    private final void confirmDelete(final Channel channel) {
        C1049s4 c1049s4M206a = C1049s4.m206a(LayoutInflater.from(getContext()), null, false);
        C12238m.checkNotNullExpressionValue(c1049s4M206a, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = c1049s4M206a.f1214a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(c1049s4M206a.f1214a).create();
        c1049s4M206a.f1218e.setText(C5419R.string.delete_thread);
        c1049s4M206a.f1216c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.confirmDelete.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        c1049s4M206a.f1217d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.confirmDelete.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadSettings.this.getViewModel().onThreadDeleted(channel.getId());
            }
        });
        TextView textView = c1049s4M206a.f1215b;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        C1107b.m221m(textView, C5419R.string.delete_channel_body, new Object[]{ChannelUtils.m7681e(channel, requireContext(), false, 2)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        alertDialogCreate.show();
    }

    private final WidgetThreadSettingsBinding getBinding() {
        return (WidgetThreadSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadSettingsViewModel getViewModel() {
        return (WidgetThreadSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetThreadSettingsViewModel.Event event) {
        if (event instanceof WidgetThreadSettingsViewModel.Event.ShowToast) {
            C0876m.m171i(this, ((WidgetThreadSettingsViewModel.Event.ShowToast) event).getMessageStringRes(), 0, 4);
        }
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        WidgetTextChannelSettings.Companion companion = WidgetTextChannelSettings.INSTANCE;
        TextView textView = getBinding().f18287h;
        C12238m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), C5419R.string.form_label_slowmode_off);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().f18283d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C76161());
        SeekBar seekBar = getBinding().f18288i;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setMax(C12147n.getLastIndex(WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES()));
        getBinding().f18288i.setOnSeekBarChangeListener(new C1337j() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.onViewBound.2
            @Override // p007b.p008a.p062y.C1337j, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                C12238m.checkNotNullParameter(seekBar2, "seekBar");
                super.onProgressChanged(seekBar2, progress, fromUser);
                if (fromUser) {
                    int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                    WidgetThreadSettings.this.setSlowmodeLabel(iIntValue);
                    WidgetThreadSettings.this.getViewModel().onSlowModeInputChanged(iIntValue);
                    TextView textView = WidgetThreadSettings.this.getBinding().f18287h;
                    C12238m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
                    seekBar2.setContentDescription(textView.getText());
                }
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetThreadSettingsViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetThreadSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76181(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetThreadSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76192(this));
    }
}
