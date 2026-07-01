package com.discord.widgets.announcements;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelFollowSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.guilds.WidgetGuildSelector$Companion;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelFollowSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", 0)};
    public static final WidgetChannelFollowSheet$Companion Companion = new WidgetChannelFollowSheet$Companion(null);
    private static final String REQUEST_KEY_CHANNEL_FOLLOW = "REQUEST_KEY_CHANNEL_FOLLOW_CHANNEL";
    private static final int VIEW_INDEX_FOLLOW = 0;
    private static final int VIEW_INDEX_NO_AVAILABLE_GUILDS = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChannelFollowSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelFollowSheet$binding$2.INSTANCE, null, 2, null);
        WidgetChannelFollowSheet$viewModel$2 widgetChannelFollowSheet$viewModel$2 = new WidgetChannelFollowSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelFollowSheetViewModel.class), new WidgetChannelFollowSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelFollowSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelFollowSheet widgetChannelFollowSheet, WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded) {
        widgetChannelFollowSheet.configureUI(widgetChannelFollowSheetViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        return widgetChannelFollowSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetChannelFollowSheetViewModel access$getViewModel$p(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        return widgetChannelFollowSheet.getViewModel();
    }

    private final void configureChannelSelector(WidgetChannelFollowSheetViewModel$ViewState$Loaded viewState) {
        int i;
        Guild selectedGuild = viewState.getSelectedGuild();
        Channel selectedChannel = viewState.getSelectedChannel();
        if (selectedGuild != null) {
            getBinding().e.setOnClickListener(new WidgetChannelFollowSheet$configureChannelSelector$1(this, selectedGuild, viewState));
        }
        if (selectedChannel != null) {
            i = 2130969005;
            TextView textView = getBinding().g;
            m.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedChannelName");
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.e(selectedChannel, contextRequireContext, false, 2));
            MaterialButton materialButton = getBinding().i;
            m.checkNotNullExpressionValue(materialButton, "binding.createChannelFollowerButton");
            materialButton.setEnabled(true);
            getBinding().i.setOnClickListener(new WidgetChannelFollowSheet$configureChannelSelector$2(this, selectedChannel));
        } else {
            i = 2130969008;
            TextView textView2 = getBinding().g;
            m.checkNotNullExpressionValue(textView2, "binding.channelFollowSelectedChannelName");
            textView2.setText(getString(2131895390));
            MaterialButton materialButton2 = getBinding().i;
            m.checkNotNullExpressionValue(materialButton2, "binding.createChannelFollowerButton");
            materialButton2.setEnabled(false);
        }
        TextView textView3 = getBinding().g;
        TextView textView4 = getBinding().h;
        m.checkNotNullExpressionValue(textView4, "binding.channelFollowSelectedGuildName");
        textView3.setTextColor(ColorCompat.getThemedColor(textView4, i));
    }

    private final void configureGuildSelector(WidgetChannelFollowSheetViewModel$ViewState$Loaded viewState) {
        String string;
        getBinding().f.setOnClickListener(new WidgetChannelFollowSheet$configureGuildSelector$1(this, viewState));
        Guild selectedGuild = viewState.getSelectedGuild();
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedGuildName");
        if (selectedGuild == null || (string = selectedGuild.getName()) == null) {
            string = getString(2131895390);
        }
        textView.setText(string);
        int i = selectedGuild != null ? 2130969005 : 2130969008;
        TextView textView2 = getBinding().h;
        TextView textView3 = getBinding().h;
        m.checkNotNullExpressionValue(textView3, "binding.channelFollowSelectedGuildName");
        textView2.setTextColor(ColorCompat.getThemedColor(textView3, i));
    }

    private final void configureUI(WidgetChannelFollowSheetViewModel$ViewState$Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowGuildIcon");
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForGuild$default(viewState.getSourceGuild(), null, false, null, 14, null), 0, 0, false, null, null, 124, null);
        Channel sourceChannel = viewState.getSourceChannel();
        if (sourceChannel != null) {
            TextView textView = getBinding().f2255b;
            m.checkNotNullExpressionValue(textView, "binding.channelFollowChannelName");
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.d(sourceChannel, contextRequireContext, false));
        }
        if (viewState.getAvailableGuilds().isEmpty()) {
            AppViewFlipper appViewFlipper = getBinding().j;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.followSheetViewFlipper");
            appViewFlipper.setDisplayedChild(1);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().j;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.followSheetViewFlipper");
            appViewFlipper2.setDisplayedChild(0);
            configureGuildSelector(viewState);
            configureChannelSelector(viewState);
        }
        if (viewState.getErrorTextRes() == null) {
            TextView textView2 = getBinding().c;
            m.checkNotNullExpressionValue(textView2, "binding.channelFollowErrorText");
            textView2.setVisibility(8);
        } else {
            getBinding().c.setText(viewState.getErrorTextRes().intValue());
            TextView textView3 = getBinding().c;
            m.checkNotNullExpressionValue(textView3, "binding.channelFollowErrorText");
            textView3.setVisibility(0);
        }
    }

    private final WidgetChannelFollowSheetBinding getBinding() {
        return (WidgetChannelFollowSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelFollowSheetViewModel getViewModel() {
        return (WidgetChannelFollowSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2) {
        Companion.show(fragmentManager, j, j2);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_channel_follow_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WidgetChannelSelector.Companion.registerForResult(this, REQUEST_KEY_CHANNEL_FOLLOW, true, new WidgetChannelFollowSheet$onCreate$1(this));
        WidgetGuildSelector$Companion.registerForResult$default(WidgetGuildSelector.Companion, this, null, true, new WidgetChannelFollowSheet$onCreate$2(this), 2, null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<WidgetChannelFollowSheetViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(WidgetChannelFollowSheet$onResume$$inlined$filterIs$1.INSTANCE).G(WidgetChannelFollowSheet$onResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), WidgetChannelFollowSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelFollowSheet$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChannelFollowSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelFollowSheet$onResume$2(this), 62, (Object) null);
    }
}
