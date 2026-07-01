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
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.WidgetChannelSettingsDeleteBinding;
import b.a.k.FormatUtils;
import b.a.y.OnSeekBarChangeListenerAdapter;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetThreadSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetThreadSettings.this.getViewModel().onChannelNameInputChanged(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettings.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetThreadSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetThreadSettings) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettings.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetThreadSettingsViewModel.Event, Unit> {
        public AnonymousClass2(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetThreadSettings) this.receiver).handleEvent(event);
        }
    }

    public WidgetThreadSettings() {
        super(R.layout.widget_thread_settings);
        WidgetThreadSettings3 widgetThreadSettings3 = new WidgetThreadSettings3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadSettingsViewModel.class), new WidgetThreadSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetThreadSettings3));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadSettings2.INSTANCE, null, 2, null);
    }

    private final void configureUI(final WidgetThreadSettingsViewModel.ViewState viewState) {
        if (!(viewState instanceof WidgetThreadSettingsViewModel.ViewState.Valid)) {
            requireActivity().finish();
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.thread_settings);
        WidgetThreadSettingsViewModel.ViewState.Valid valid = (WidgetThreadSettingsViewModel.ViewState.Valid) viewState;
        setActionBarSubtitle(ChannelUtils.e(valid.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(R.menu.menu_text_channel_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_channel_settings_delete) {
                    return;
                }
                WidgetThreadSettings.this.confirmDelete(((WidgetThreadSettingsViewModel.ViewState.Valid) viewState).getChannel());
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.2
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_channel_settings_delete);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
                menuItemFindItem.setVisible(((WidgetThreadSettingsViewModel.ViewState.Valid) viewState).getCanManageThread());
                menu.findItem(R.id.menu_channel_settings_delete).setTitle(R.string.delete_thread);
                MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_channel_settings_reset);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "it.findItem(R.id.menu_channel_settings_reset)");
                menuItemFindItem2.setVisible(false);
            }
        });
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.threadSettingsEditWrap");
        linearLayout.setVisibility(valid.getCanManageThread() ? 0 : 8);
        String channelNameDraft = valid.getChannelNameDraft();
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        if (!Intrinsics3.areEqual(channelNameDraft, ViewExtensions.getTextOrEmpty(textInputLayout))) {
            TextInputLayout textInputLayout2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.threadSettingsEditName");
            ViewExtensions.setText(textInputLayout2, valid.getChannelNameDraft());
        }
        LinearLayout linearLayout2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.threadSettingsSectionSlowMode");
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
        SeekBar seekBar = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        SeekBar seekBar2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.threadSettingsSlowModeCooldownSlider");
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView.getText());
        TextView textView2 = getBinding().f2672b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsPinnedMessages");
        textView2.setEnabled(valid.isPinsEnabled());
        getBinding().f2672b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelPinnedMessages.INSTANCE.show(outline.x(view, "it", "it.context"), ((WidgetThreadSettingsViewModel.ViewState.Valid) viewState).getChannel().getId());
            }
        });
        View view = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(true ^ valid.isPinsEnabled() ? 0 : 8);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                AppToast.g(view2.getContext(), R.string.pins_disabled_nsfw, 0, null, 12);
            }
        });
        FloatingActionButton floatingActionButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.threadSettingsSave");
        floatingActionButton.setVisibility(valid.getHasUnsavedChanges() ? 0 : 8);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetThreadSettings.this.getViewModel().saveThread();
            }
        });
    }

    private final void confirmDelete(final Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingA = WidgetChannelSettingsDeleteBinding.a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingA.a).create();
        widgetChannelSettingsDeleteBindingA.e.setText(R.string.delete_thread);
        widgetChannelSettingsDeleteBindingA.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.confirmDelete.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        widgetChannelSettingsDeleteBindingA.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.confirmDelete.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadSettings.this.getViewModel().onThreadDeleted(channel.getId());
            }
        });
        TextView textView = widgetChannelSettingsDeleteBindingA.f199b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        FormatUtils.m(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
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
            AppToast.i(this, ((WidgetThreadSettingsViewModel.Event.ShowToast) event).getMessageStringRes(), 0, 4);
        }
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        WidgetTextChannelSettings.Companion companion = WidgetTextChannelSettings.INSTANCE;
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), R.string.form_label_slowmode_off);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        SeekBar seekBar = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setMax(Collections2.getLastIndex(WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES()));
        getBinding().i.setOnSeekBarChangeListener(new OnSeekBarChangeListenerAdapter() { // from class: com.discord.widgets.channels.settings.WidgetThreadSettings.onViewBound.2
            @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                Intrinsics3.checkNotNullParameter(seekBar2, "seekBar");
                super.onProgressChanged(seekBar2, progress, fromUser);
                if (fromUser) {
                    int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                    WidgetThreadSettings.this.setSlowmodeLabel(iIntValue);
                    WidgetThreadSettings.this.getViewModel().onSlowModeInputChanged(iIntValue);
                    TextView textView = WidgetThreadSettings.this.getBinding().h;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
                    seekBar2.setContentDescription(textView.getText());
                }
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetThreadSettingsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetThreadSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetThreadSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
