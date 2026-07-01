package com.discord.widgets.quickmentions;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserMentions;
import com.discord.widgets.user.search.WidgetGlobalSearch;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import com.google.android.material.tabs.TabLayout;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetQuickMentionsDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("javaClass");
            if (fragmentFindFragmentByTag instanceof WidgetQuickMentionsDialog) {
                ((WidgetQuickMentionsDialog) fragmentFindFragmentByTag).dismiss();
            }
        }

        public final void show(FragmentManager fragmentManager, String searchText) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            dismiss(fragmentManager);
            WidgetQuickMentionsDialog widgetQuickMentionsDialog = new WidgetQuickMentionsDialog();
            widgetQuickMentionsDialog.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
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
            Intrinsics3.checkNotNullParameter(widgetQuickMentionsDialog, "fragment");
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
                return R.string.search;
            }
            if (position == 1) {
                return R.string.mentions;
            }
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            WidgetQuickMentionsDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
        public final /* synthetic */ TabsAdapter $adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TabsAdapter tabsAdapter) {
            super(2);
            this.$adapter = tabsAdapter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            Intrinsics3.checkNotNullParameter(tab, "tab");
            tab.setText(WidgetQuickMentionsDialog.this.getString(this.$adapter.getItemTitleResId(i)));
        }
    }

    public WidgetQuickMentionsDialog() {
        super(R.layout.widget_quick_mentions_dialog);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$1(this), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$2(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetQuickMentionsDialog2.INSTANCE, null, 2, null);
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getDismissViewModel().getDismissEvents(), this, null, 2, null), (Class<?>) WidgetQuickMentionsDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        TabsAdapter tabsAdapter = new TabsAdapter(this, requireArguments().getString(WidgetGlobalSearch.EXTRA_SEARCH_TEXT));
        ViewPager2 viewPager2 = getBinding().f2516b;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.tabContents");
        viewPager2.setAdapter(tabsAdapter);
        TabLayout tabLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        ViewPager2 viewPager3 = getBinding().f2516b;
        Intrinsics3.checkNotNullExpressionValue(viewPager3, "binding.tabContents");
        ViewPager2Extensions.setUpWithViewPager2(tabLayout, viewPager3, new AnonymousClass2(tabsAdapter));
    }
}
