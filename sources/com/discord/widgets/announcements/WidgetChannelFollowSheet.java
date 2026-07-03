package com.discord.widgets.announcements;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel;
import com.discord.widgets.announcements.WidgetChannelFollowSuccessDialog;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelFollowSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", 0)};

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
            C12238m.checkNotNullParameter(set, "channelIds");
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
            C12238m.checkNotNullParameter(channelIds, "channelIds");
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
            return this.selectedGuildId == channelFollowChannelFilterFunction.selectedGuildId && C12238m.areEqual(this.channelIds, channelFollowChannelFilterFunction.channelIds);
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.selectedGuildId) * 31;
            Set<Long> set = this.channelIds;
            return iM3a + (set != null ? set.hashCode() : 0);
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            return this.channelIds.contains(Long.valueOf(channel.getId())) && channel.getGuildId() == this.selectedGuildId;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelFollowChannelFilterFunction(selectedGuildId=");
            sbM833U.append(this.selectedGuildId);
            sbM833U.append(", channelIds=");
            return C1643a.m826N(sbM833U, this.channelIds, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelFollowSheet widgetChannelFollowSheet = new WidgetChannelFollowSheet();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetChannelFollowSheet.setArguments(bundleM832T);
            widgetChannelFollowSheet.show(fragmentManager, WidgetChannelFollowSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onCreate$1 */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class C71411 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C71411() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetChannelFollowSheet.this.getViewModel().selectChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onCreate$2 */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class C71422 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C71422() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetChannelFollowSheet.this.getViewModel().selectGuild(j);
            WidgetChannelFollowSheet.this.getViewModel().selectChannel(0L);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final /* synthetic */ class C71431 extends C12236k implements Function1<WidgetChannelFollowSheetViewModel.ViewState.Loaded, Unit> {
        public C71431(WidgetChannelFollowSheet widgetChannelFollowSheet) {
            super(1, widgetChannelFollowSheet, WidgetChannelFollowSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelFollowSheetViewModel.ViewState.Loaded loaded) {
            C12238m.checkNotNullParameter(loaded, "p1");
            ((WidgetChannelFollowSheet) this.receiver).configureUI(loaded);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
    public static final class C71442 extends AbstractC12240o implements Function1<WidgetChannelFollowSheetViewModel.Event, Unit> {
        public C71442() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelFollowSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "it");
            WidgetChannelFollowSheet.this.dismiss();
            WidgetChannelFollowSuccessDialog.Companion companion = WidgetChannelFollowSuccessDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelFollowSheet.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager);
        }
    }

    public WidgetChannelFollowSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelFollowSheet$binding$2.INSTANCE, null, 2, null);
        WidgetChannelFollowSheet$viewModel$2 widgetChannelFollowSheet$viewModel$2 = new WidgetChannelFollowSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetChannelFollowSheetViewModel.class), new WidgetChannelFollowSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetChannelFollowSheet$viewModel$2));
    }

    private final void configureChannelSelector(final WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        int i;
        final Guild selectedGuild = viewState.getSelectedGuild();
        final Channel selectedChannel = viewState.getSelectedChannel();
        if (selectedGuild != null) {
            getBinding().f15835e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet.configureChannelSelector.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChannelSelector.INSTANCE.launch(WidgetChannelFollowSheet.this, selectedGuild.getId(), WidgetChannelFollowSheet.REQUEST_KEY_CHANNEL_FOLLOW, false, C5419R.string.none, new ChannelFollowChannelFilterFunction(selectedGuild.getId(), viewState.getAvailableChannels()));
                }
            });
        }
        if (selectedChannel != null) {
            i = C5419R.attr.colorInteractiveActive;
            TextView textView = getBinding().f15837g;
            C12238m.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedChannelName");
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.m7681e(selectedChannel, contextRequireContext, false, 2));
            MaterialButton materialButton = getBinding().f15839i;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.createChannelFollowerButton");
            materialButton.setEnabled(true);
            getBinding().f15839i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet.configureChannelSelector.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChannelFollowSheet.this.getViewModel().followChannel(selectedChannel.getId());
                }
            });
        } else {
            i = C5419R.attr.colorInteractiveNormal;
            TextView textView2 = getBinding().f15837g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.channelFollowSelectedChannelName");
            textView2.setText(getString(C5419R.string.select));
            MaterialButton materialButton2 = getBinding().f15839i;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.createChannelFollowerButton");
            materialButton2.setEnabled(false);
        }
        TextView textView3 = getBinding().f15837g;
        TextView textView4 = getBinding().f15838h;
        C12238m.checkNotNullExpressionValue(textView4, "binding.channelFollowSelectedGuildName");
        textView3.setTextColor(ColorCompat.getThemedColor(textView4, i));
    }

    private final void configureGuildSelector(final WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        String string;
        getBinding().f15836f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet.configureGuildSelector.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetChannelFollowSheet.this, null, false, 0, new WidgetGuildSelector.GuildFilterFunction(viewState.getAvailableGuilds()), 14, null);
            }
        });
        Guild selectedGuild = viewState.getSelectedGuild();
        TextView textView = getBinding().f15838h;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelFollowSelectedGuildName");
        if (selectedGuild == null || (string = selectedGuild.getName()) == null) {
            string = getString(C5419R.string.select);
        }
        textView.setText(string);
        int i = selectedGuild != null ? C5419R.attr.colorInteractiveActive : C5419R.attr.colorInteractiveNormal;
        TextView textView2 = getBinding().f15838h;
        TextView textView3 = getBinding().f15838h;
        C12238m.checkNotNullExpressionValue(textView3, "binding.channelFollowSelectedGuildName");
        textView2.setTextColor(ColorCompat.getThemedColor(textView3, i));
    }

    private final void configureUI(WidgetChannelFollowSheetViewModel.ViewState.Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().f15834d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowGuildIcon");
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForGuild$default(viewState.getSourceGuild(), null, false, null, 14, null), 0, 0, false, null, null, 124, null);
        Channel sourceChannel = viewState.getSourceChannel();
        if (sourceChannel != null) {
            TextView textView = getBinding().f15832b;
            C12238m.checkNotNullExpressionValue(textView, "binding.channelFollowChannelName");
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(ChannelUtils.m7680d(sourceChannel, contextRequireContext, false));
        }
        if (viewState.getAvailableGuilds().isEmpty()) {
            AppViewFlipper appViewFlipper = getBinding().f15840j;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.followSheetViewFlipper");
            appViewFlipper.setDisplayedChild(1);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().f15840j;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.followSheetViewFlipper");
            appViewFlipper2.setDisplayedChild(0);
            configureGuildSelector(viewState);
            configureChannelSelector(viewState);
        }
        if (viewState.getErrorTextRes() == null) {
            TextView textView2 = getBinding().f15833c;
            C12238m.checkNotNullExpressionValue(textView2, "binding.channelFollowErrorText");
            textView2.setVisibility(8);
        } else {
            getBinding().f15833c.setText(viewState.getErrorTextRes().intValue());
            TextView textView3 = getBinding().f15833c;
            C12238m.checkNotNullExpressionValue(textView3, "binding.channelFollowErrorText");
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
        return C5419R.layout.widget_channel_follow_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WidgetChannelSelector.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_FOLLOW, true, new C71411());
        WidgetGuildSelector.Companion.registerForResult$default(WidgetGuildSelector.INSTANCE, this, null, true, new C71422(), 2, null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<WidgetChannelFollowSheetViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        Observable<R> observableM11083G = observableM11112r.m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetChannelFollowSheetViewModel.ViewState.Loaded);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.announcements.WidgetChannelFollowSheet$onResume$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.ViewState.Loaded");
                return (T) ((WidgetChannelFollowSheetViewModel.ViewState.Loaded) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, this, null, 2, null), (Class<?>) WidgetChannelFollowSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71431(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChannelFollowSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71442());
    }
}
