package com.discord.widgets.guilds.join;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildWelcomeSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.n;
import d0.t.o;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildWelcomeSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildWelcomeSheetBinding;", 0)};
    public static final WidgetGuildWelcomeSheet$Companion Companion = new WidgetGuildWelcomeSheet$Companion(null);
    private static final int LOADED_VIEW_INDEX = 1;
    private static final int LOADING_VIEW_INDEX = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final WidgetGuildWelcomeSheetChannelAdapter channelsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildWelcomeSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildWelcomeSheet$binding$2.INSTANCE, null, 2, null);
        this.channelsAdapter = new WidgetGuildWelcomeSheetChannelAdapter();
        WidgetGuildWelcomeSheet$viewModel$2 widgetGuildWelcomeSheet$viewModel$2 = new WidgetGuildWelcomeSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildWelcomeSheetViewModel.class), new WidgetGuildWelcomeSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildWelcomeSheet$viewModel$2));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        return widgetGuildWelcomeSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildWelcomeSheetViewModel access$getViewModel$p(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        return widgetGuildWelcomeSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet, WidgetGuildWelcomeSheetViewModel$ViewState widgetGuildWelcomeSheetViewModel$ViewState) {
        widgetGuildWelcomeSheet.handleViewState(widgetGuildWelcomeSheetViewModel$ViewState);
    }

    private final void configureGuildDetails(String name, String description) {
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.guildWelcomeSheetName");
        b.n(textView, 2131897255, new Object[]{name}, null, 4);
        if (description != null) {
            TextView textView2 = getBinding().c;
            m.checkNotNullExpressionValue(textView2, "binding.guildWelcomeSheetDescription");
            ViewExtensions.setTextAndVisibilityBy(textView2, description);
        } else {
            TextView textView3 = getBinding().c;
            m.checkNotNullExpressionValue(textView3, "binding.guildWelcomeSheetDescription");
            textView3.setVisibility(8);
        }
    }

    private final void configureGuildIcon(long guildId, String iconHash, String shortName) {
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guildId), iconHash, null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(2131165302))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().f;
            m.checkNotNullExpressionValue(textView, "binding.guildWelcomeSheetIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().e;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeSheetIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().e;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeSheetIcon");
        IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        TextView textView2 = getBinding().f;
        m.checkNotNullExpressionValue(textView2, "binding.guildWelcomeSheetIconName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().f;
        m.checkNotNullExpressionValue(textView3, "binding.guildWelcomeSheetIconName");
        textView3.setText(shortName);
    }

    private final void configureUI(WidgetGuildWelcomeSheetViewModel$ViewState$Loaded viewState) {
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
        WidgetGuildWelcomeSheet$configureWelcomeChannels$dismissSheet$1 widgetGuildWelcomeSheet$configureWelcomeChannels$dismissSheet$1 = new WidgetGuildWelcomeSheet$configureWelcomeChannels$dismissSheet$1(this);
        WidgetGuildWelcomeSheet$configureWelcomeChannels$goToChannel$1 widgetGuildWelcomeSheet$configureWelcomeChannels$goToChannel$1 = new WidgetGuildWelcomeSheet$configureWelcomeChannels$goToChannel$1(this, guildId, welcomeChannels);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(welcomeChannels, 10));
        int i = 0;
        for (Object obj : welcomeChannels) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            arrayList.add(new ChannelItem$ChannelData((GuildWelcomeChannel) obj, widgetGuildWelcomeSheet$configureWelcomeChannels$dismissSheet$1, guildId, widgetGuildWelcomeSheet$configureWelcomeChannels$goToChannel$1, i));
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

    private final void handleViewState(WidgetGuildWelcomeSheetViewModel$ViewState viewState) {
        if (viewState instanceof WidgetGuildWelcomeSheetViewModel$ViewState$Loading) {
            showLoadingView();
        } else if (viewState instanceof WidgetGuildWelcomeSheetViewModel$ViewState$Loaded) {
            updateView((WidgetGuildWelcomeSheetViewModel$ViewState$Loaded) viewState);
        } else {
            if (!(viewState instanceof WidgetGuildWelcomeSheetViewModel$ViewState$Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
        }
    }

    public static final void show(FragmentManager fragmentManager, long j, Long l) {
        Companion.show(fragmentManager, j, l);
    }

    private final void showLoadingView() {
        AppViewFlipper appViewFlipper = getBinding().d;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildWelcomeSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final void updateView(WidgetGuildWelcomeSheetViewModel$ViewState$Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().d;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildWelcomeSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
        configureUI(viewState);
    }

    @Override // com.discord.app.AppBottomSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", 0L);
        if (j != 0) {
            WidgetGuildScheduledEventDetailsBottomSheet.Companion.enqueue(j);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_welcome_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildWelcomeSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildWelcomeSheet$onViewCreated$1(this), 62, (Object) null);
        RecyclerView recyclerView = getBinding().f2457b;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildWelcomeSheetChannels");
        recyclerView.setAdapter(this.channelsAdapter);
    }
}
