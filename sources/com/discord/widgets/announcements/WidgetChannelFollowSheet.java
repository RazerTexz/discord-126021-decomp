package com.discord.widgets.announcements;

import a0.a.a.b;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelFollowSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel;
import com.discord.widgets.announcements.WidgetChannelFollowSuccessDialog;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelFollowSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String REQUEST_KEY_CHANNEL_FOLLOW = "REQUEST_KEY_CHANNEL_FOLLOW_CHANNEL";
    private static final int VIEW_INDEX_FOLLOW = 0;
    private static final int VIEW_INDEX_NO_AVAILABLE_GUILDS = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final /* data */ class ChannelFollowChannelFilterFunction implements WidgetChannelSelector.FilterFunction {
        private final Set<Long> channelIds;
        private final long selectedGuildId;

        public ChannelFollowChannelFilterFunction(long j, Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "channelIds");
            this.selectedGuildId = j;
            this.channelIds = set;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final long getSelectedGuildId() {
            return this.selectedGuildId;
        }

        private final Set<Long> component2() {
            return this.channelIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelFollowChannelFilterFunction copy$default(ChannelFollowChannelFilterFunction channelFollowChannelFilterFunction, long j, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                j = channelFollowChannelFilterFunction.selectedGuildId;
            }
            if ((i & 2) != 0) {
                set = channelFollowChannelFilterFunction.channelIds;
            }
            return channelFollowChannelFilterFunction.copy(j, set);
        }

        public final ChannelFollowChannelFilterFunction copy(long selectedGuildId, Set<Long> channelIds) {
            Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
            return new ChannelFollowChannelFilterFunction(selectedGuildId, channelIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelFollowChannelFilterFunction)) {
                return false;
            }
            ChannelFollowChannelFilterFunction channelFollowChannelFilterFunction = (ChannelFollowChannelFilterFunction) other;
            return this.selectedGuildId == channelFollowChannelFilterFunction.selectedGuildId && Intrinsics3.areEqual(this.channelIds, channelFollowChannelFilterFunction.channelIds);
        }

        public int hashCode() {
            int iA = b.a(this.selectedGuildId) * 31;
            Set<Long> set = this.channelIds;
            return iA + (set != null ? set.hashCode() : 0);
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return this.channelIds.contains(Long.valueOf(channel.getId())) && channel.getGuildId() == this.selectedGuildId;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelFollowChannelFilterFunction(selectedGuildId=");
            sbU.append(this.selectedGuildId);
            sbU.append(", channelIds=");
            return outline.N(sbU, this.channelIds, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelFollowSheet widgetChannelFollowSheet = new WidgetChannelFollowSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetChannelFollowSheet.setArguments(bundleT);
            widgetChannelFollowSheet.show(fragmentManager, WidgetChannelFollowSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetChannelFollowSheet.this.getViewModel().selectChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetChannelFollowSheet.this.getViewModel().selectGuild(j);
            WidgetChannelFollowSheet.this.getViewModel().selectChannel(0L);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetChannelFollowSheetViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetChannelFollowSheet widgetChannelFollowSheet) {
            super(1, widgetChannelFollowSheet, WidgetChannelFollowSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            ((WidgetChannelFollowSheet) this.receiver).configureUI(loaded);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetChannelFollowSheetViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelFollowSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetChannelFollowSheet.this.dismiss();
            WidgetChannelFollowSuccessDialog.Companion companion = WidgetChannelFollowSuccessDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelFollowSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager);
        }
    }

    public WidgetChannelFollowSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelFollowSheet2.INSTANCE, null, 2, null);
        WidgetChannelFollowSheet3 widgetChannelFollowSheet3 = new WidgetChannelFollowSheet3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelFollowSheetViewModel.class), new WidgetChannelFollowSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelFollowSheet3));
    }

    private final void configureChannelSelector(final WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        int i;
        final Guild selectedGuild = viewState.getSelectedGuild();
        final Channel selectedChannel = viewState.getSelectedChannel();
        if (selectedGuild != null) {
            getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet.configureChannelSelector.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChannelSelector.INSTANCE.launch(WidgetChannelFollowSheet.this, selectedGuild.getId(), WidgetChannelFollowSheet.REQUEST_KEY_CHANNEL_FOLLOW, false, R.string.none, new ChannelFollowChannelFilterFunction(selectedGuild.getId(), viewState.getAvailableChannels()));
                }
            });
        }
        if (selectedChannel != null) {
            i = R.attr.colorInteractiveActive;
            TextView textView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedChannelName");
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.e(selectedChannel, contextRequireContext, false, 2));
            MaterialButton materialButton = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.createChannelFollowerButton");
            materialButton.setEnabled(true);
            getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet.configureChannelSelector.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChannelFollowSheet.this.getViewModel().followChannel(selectedChannel.getId());
                }
            });
        } else {
            i = R.attr.colorInteractiveNormal;
            TextView textView2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelFollowSelectedChannelName");
            textView2.setText(getString(R.string.select));
            MaterialButton materialButton2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.createChannelFollowerButton");
            materialButton2.setEnabled(false);
        }
        TextView textView3 = getBinding().g;
        TextView textView4 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelFollowSelectedGuildName");
        textView3.setTextColor(ColorCompat.getThemedColor(textView4, i));
    }

    private final void configureGuildSelector(final WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        String string;
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet.configureGuildSelector.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetChannelFollowSheet.this, null, false, 0, new WidgetGuildSelector.GuildFilterFunction(viewState.getAvailableGuilds()), 14, null);
            }
        });
        Guild selectedGuild = viewState.getSelectedGuild();
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedGuildName");
        if (selectedGuild == null || (string = selectedGuild.getName()) == null) {
            string = getString(R.string.select);
        }
        textView.setText(string);
        int i = selectedGuild != null ? R.attr.colorInteractiveActive : R.attr.colorInteractiveNormal;
        TextView textView2 = getBinding().h;
        TextView textView3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelFollowSelectedGuildName");
        textView2.setTextColor(ColorCompat.getThemedColor(textView3, i));
    }

    private final void configureUI(WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowGuildIcon");
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForGuild$default(viewState.getSourceGuild(), null, false, null, 14, null), 0, 0, false, null, null, 124, null);
        Channel sourceChannel = viewState.getSourceChannel();
        if (sourceChannel != null) {
            TextView textView = getBinding().f2255b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowChannelName");
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.d(sourceChannel, contextRequireContext, false));
        }
        if (viewState.getAvailableGuilds().isEmpty()) {
            AppViewFlipper appViewFlipper = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.followSheetViewFlipper");
            appViewFlipper.setDisplayedChild(1);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.followSheetViewFlipper");
            appViewFlipper2.setDisplayedChild(0);
            configureGuildSelector(viewState);
            configureChannelSelector(viewState);
        }
        if (viewState.getErrorTextRes() == null) {
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelFollowErrorText");
            textView2.setVisibility(8);
        } else {
            getBinding().c.setText(viewState.getErrorTextRes().intValue());
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelFollowErrorText");
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
        INSTANCE.show(fragmentManager, j, j2);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channel_follow_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WidgetChannelSelector.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_FOLLOW, true, new AnonymousClass1());
        WidgetGuildSelector.Companion.registerForResult$default(WidgetGuildSelector.INSTANCE, this, null, true, new AnonymousClass2(), 2, null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<WidgetChannelFollowSheetViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetChannelFollowSheetViewModel.ViewState.Loaded);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.ViewState.Loaded");
                return (T) ((WidgetChannelFollowSheetViewModel.ViewState.Loaded) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), (Class<?>) WidgetChannelFollowSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChannelFollowSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
