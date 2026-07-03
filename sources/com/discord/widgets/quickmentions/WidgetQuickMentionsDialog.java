package com.discord.widgets.quickmentions;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserMentions;
import com.discord.widgets.user.search.WidgetGlobalSearch;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import com.google.android.material.tabs.TabLayout;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetQuickMentionsDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int POSITION_MENTIONS = 1;
    private static final int POSITION_QUICK_SWITCHER = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    /* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.show(fragmentManager, str);
        }

        public final void dismiss(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("javaClass");
            if (fragmentFindFragmentByTag instanceof WidgetQuickMentionsDialog) {
                ((WidgetQuickMentionsDialog) fragmentFindFragmentByTag).dismiss();
            }
        }

        public final void show(FragmentManager fragmentManager, String searchText) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            dismiss(fragmentManager);
            WidgetQuickMentionsDialog widgetQuickMentionsDialog = new WidgetQuickMentionsDialog();
            widgetQuickMentionsDialog.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
            widgetQuickMentionsDialog.show(fragmentManager, "javaClass");
            AnalyticsTracker.INSTANCE.quickSwitcherOpen();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
    public static final class TabsAdapter extends FragmentStateAdapter {
        private final String searchText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabsAdapter(WidgetQuickMentionsDialog widgetQuickMentionsDialog, String str) {
            super(widgetQuickMentionsDialog);
            C12238m.checkNotNullParameter(widgetQuickMentionsDialog, "fragment");
            this.searchText = str;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (position == 0) {
                return WidgetGlobalSearch.INSTANCE.create(this.searchText);
            }
            if (position == 1) {
                return WidgetUserMentions.INSTANCE.create(true);
            }
            throw new UnsupportedOperationException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: getItemCount */
        public int getPageSize() {
            return 2;
        }

        public final int getItemTitleResId(int position) {
            if (position == 0) {
                return C5419R.string.search;
            }
            if (position == 1) {
                return C5419R.string.mentions;
            }
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
    public static final class C91221 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C91221() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            C12238m.checkNotNullParameter(unit, "it");
            WidgetQuickMentionsDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
    public static final class C91232 extends AbstractC12240o implements Function2<TabLayout.Tab, Integer, Unit> {
        public final /* synthetic */ TabsAdapter $adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91232(TabsAdapter tabsAdapter) {
            super(2);
            this.$adapter = tabsAdapter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            C12238m.checkNotNullParameter(tab, "tab");
            tab.setText(WidgetQuickMentionsDialog.this.getString(this.$adapter.getItemTitleResId(i)));
        }
    }

    public WidgetQuickMentionsDialog() {
        super(C5419R.layout.widget_quick_mentions_dialog);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$1(this), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$2(this));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetQuickMentionsDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetQuickMentionsDialogBinding getBinding() {
        return (WidgetQuickMentionsDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setStyle(0, 2131951656);
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        if (!AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            window.getAttributes().windowAnimations = 2131952508;
        }
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(53);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getDismissViewModel().getDismissEvents(), this, null, 2, null), (Class<?>) WidgetQuickMentionsDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91221());
        TabsAdapter tabsAdapter = new TabsAdapter(this, requireArguments().getString(WidgetGlobalSearch.EXTRA_SEARCH_TEXT));
        ViewPager2 viewPager2 = getBinding().f17399b;
        C12238m.checkNotNullExpressionValue(viewPager2, "binding.tabContents");
        viewPager2.setAdapter(tabsAdapter);
        TabLayout tabLayout = getBinding().f17400c;
        C12238m.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        ViewPager2 viewPager3 = getBinding().f17399b;
        C12238m.checkNotNullExpressionValue(viewPager3, "binding.tabContents");
        ViewPager2ExtensionsKt.setUpWithViewPager2(tabLayout, viewPager3, new C91232(tabsAdapter));
    }
}
