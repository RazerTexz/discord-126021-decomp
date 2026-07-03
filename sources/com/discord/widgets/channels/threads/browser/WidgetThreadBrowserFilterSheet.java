package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadBrowserFilterSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetThreadBrowserFilterSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId, long channelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet = new WidgetThreadBrowserFilterSheet();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetThreadBrowserFilterSheet.setArguments(bundleM832T);
            widgetThreadBrowserFilterSheet.show(fragmentManager, WidgetThreadBrowserFilterSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
    public static final class C76651 extends AbstractC12240o implements Function1<WidgetThreadBrowserArchivedViewModel.ViewState, Unit> {
        public C76651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowserFilterSheet.this.configureUI(viewState);
        }
    }

    public WidgetThreadBrowserFilterSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadBrowserFilterSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetThreadBrowserFilterSheet$guildId$2(this));
        this.channelId = C12083g.lazy(new WidgetThreadBrowserFilterSheet$channelId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new C7663x6248c6ac(this), new C0863f0(new WidgetThreadBrowserFilterSheet$viewModel$2(this)));
    }

    private final void configureUI(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
        WidgetThreadBrowserArchivedViewModel.ViewMode viewMode = viewState.getViewMode();
        CheckedSetting checkedSetting = getBinding().f18279e;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.threadBrowserVisibilityPublic");
        WidgetThreadBrowserArchivedViewModel.VisibilityMode visibility = viewMode.getVisibility();
        WidgetThreadBrowserArchivedViewModel.VisibilityMode visibilityMode = WidgetThreadBrowserArchivedViewModel.VisibilityMode.PublicThreads;
        checkedSetting.setChecked(visibility == visibilityMode);
        CheckedSetting checkedSetting2 = getBinding().f18278d;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.threadBrowserVisibilityPrivate");
        checkedSetting2.setChecked(viewMode.getVisibility() == WidgetThreadBrowserArchivedViewModel.VisibilityMode.PrivateThreads);
        CardView cardView = getBinding().f18277c;
        C12238m.checkNotNullExpressionValue(cardView, "binding.threadBrowserModeratorViewCard");
        cardView.setVisibility(viewState.isModerator() ? 0 : 8);
        if (viewMode.getVisibility() == visibilityMode) {
            CheckedSetting.m8523d(getBinding().f18276b, null, 1);
        } else {
            getBinding().f18276b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetThreadBrowserFilterSheet.this.getBinding().f18276b.toggle();
                    WidgetThreadBrowserArchivedViewModel viewModel = WidgetThreadBrowserFilterSheet.this.getViewModel();
                    CheckedSetting checkedSetting3 = WidgetThreadBrowserFilterSheet.this.getBinding().f18276b;
                    C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.threadBrowserModeratorView");
                    viewModel.onModeratorModeChanged(checkedSetting3.isChecked());
                }
            });
        }
        getBinding().f18276b.m8529g(viewMode.isModeratorMode(), false);
    }

    private final WidgetThreadBrowserFilterSheetBinding getBinding() {
        return (WidgetThreadBrowserFilterSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserArchivedViewModel getViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetThreadBrowserFilterSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76651());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_thread_browser_filter_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBinding().f18279e.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet.onResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadBrowserFilterSheet.this.getViewModel().onVisibilityChanged(WidgetThreadBrowserArchivedViewModel.VisibilityMode.PublicThreads);
            }
        });
        getBinding().f18278d.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadBrowserFilterSheet.this.getViewModel().onVisibilityChanged(WidgetThreadBrowserArchivedViewModel.VisibilityMode.PrivateThreads);
            }
        });
    }
}
