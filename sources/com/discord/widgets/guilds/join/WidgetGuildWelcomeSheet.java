package com.discord.widgets.guilds.join;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildWelcomeSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetChannelAdapter3;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildWelcomeSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildWelcomeSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int LOADED_VIEW_INDEX = 1;
    private static final int LOADING_VIEW_INDEX = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final WidgetGuildWelcomeSheetChannelAdapter channelsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.show(fragmentManager, j, l);
        }

        public final void show(FragmentManager fragmentManager, long guildId, Long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildWelcomeSheet widgetGuildWelcomeSheet = new WidgetGuildWelcomeSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (guildScheduledEventId != null) {
                bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId.longValue());
            }
            widgetGuildWelcomeSheet.setArguments(bundleT);
            widgetGuildWelcomeSheet.show(fragmentManager, WidgetGuildWelcomeSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildWelcomeSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
            super(1, widgetGuildWelcomeSheet, WidgetGuildWelcomeSheet.class, "handleViewState", "handleViewState(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildWelcomeSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildWelcomeSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildWelcomeSheet) this.receiver).handleViewState(viewState);
        }
    }

    public WidgetGuildWelcomeSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildWelcomeSheet2.INSTANCE, null, 2, null);
        this.channelsAdapter = new WidgetGuildWelcomeSheetChannelAdapter();
        WidgetGuildWelcomeSheet5 widgetGuildWelcomeSheet5 = new WidgetGuildWelcomeSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildWelcomeSheetViewModel.class), new WidgetGuildWelcomeSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildWelcomeSheet5));
    }

    private final void configureGuildDetails(String name, String description) {
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildWelcomeSheetName");
        FormatUtils.m(textView, R.string.welcome_screen_title, new Object[]{name}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        if (description != null) {
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildWelcomeSheetDescription");
            ViewExtensions.setTextAndVisibilityBy(textView2, description);
        } else {
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildWelcomeSheetDescription");
            textView3.setVisibility(8);
        }
    }

    private final void configureGuildIcon(long guildId, String iconHash, String shortName) {
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guildId), iconHash, null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.avatar_size_xxlarge))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildWelcomeSheetIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeSheetIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeSheetIcon");
        IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildWelcomeSheetIconName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildWelcomeSheetIconName");
        textView3.setText(shortName);
    }

    private final void configureUI(WidgetGuildWelcomeSheetViewModel.ViewState.Loaded viewState) {
        long guildId = viewState.getGuildId();
        String guildName = viewState.getGuildName();
        String guildShortName = viewState.getGuildShortName();
        String guildIcon = viewState.getGuildIcon();
        String guildDescription = viewState.getGuildDescription();
        List<GuildWelcomeChannel> listComponent6 = viewState.component6();
        if (listComponent6 == null) {
            return;
        }
        configureGuildIcon(guildId, guildIcon, guildShortName);
        configureGuildDetails(guildName, guildDescription);
        configureWelcomeChannels(listComponent6, guildId);
    }

    private final void configureWelcomeChannels(List<GuildWelcomeChannel> welcomeChannels, long guildId) {
        WidgetGuildWelcomeSheet3 widgetGuildWelcomeSheet3 = new WidgetGuildWelcomeSheet3(this);
        WidgetGuildWelcomeSheet4 widgetGuildWelcomeSheet4 = new WidgetGuildWelcomeSheet4(this, guildId, welcomeChannels);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(welcomeChannels, 10));
        int i = 0;
        for (Object obj : welcomeChannels) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(new WidgetGuildWelcomeSheetChannelAdapter3.ChannelData((GuildWelcomeChannel) obj, widgetGuildWelcomeSheet3, guildId, widgetGuildWelcomeSheet4, i));
            i = i2;
        }
        this.channelsAdapter.setData(arrayList);
    }

    private final WidgetGuildWelcomeSheetBinding getBinding() {
        return (WidgetGuildWelcomeSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildWelcomeSheetViewModel getViewModel() {
        return (WidgetGuildWelcomeSheetViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(WidgetGuildWelcomeSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildWelcomeSheetViewModel.ViewState.Loading) {
            showLoadingView();
        } else if (viewState instanceof WidgetGuildWelcomeSheetViewModel.ViewState.Loaded) {
            updateView((WidgetGuildWelcomeSheetViewModel.ViewState.Loaded) viewState);
        } else {
            if (!(viewState instanceof WidgetGuildWelcomeSheetViewModel.ViewState.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
        }
    }

    public static final void show(FragmentManager fragmentManager, long j, Long l) {
        INSTANCE.show(fragmentManager, j, l);
    }

    private final void showLoadingView() {
        AppViewFlipper appViewFlipper = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildWelcomeSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final void updateView(WidgetGuildWelcomeSheetViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildWelcomeSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
        configureUI(viewState);
    }

    @Override // com.discord.app.AppBottomSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", 0L);
        if (j != 0) {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(j);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_welcome_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildWelcomeSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        RecyclerView recyclerView = getBinding().f2457b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildWelcomeSheetChannels");
        recyclerView.setAdapter(this.channelsAdapter);
    }
}
