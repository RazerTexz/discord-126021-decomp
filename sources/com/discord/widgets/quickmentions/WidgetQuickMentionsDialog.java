package com.discord.widgets.quickmentions;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.search.WidgetGlobalSearch;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetQuickMentionsDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0)};
    public static final WidgetQuickMentionsDialog$Companion Companion = new WidgetQuickMentionsDialog$Companion(null);
    private static final int POSITION_MENTIONS = 1;
    private static final int POSITION_QUICK_SWITCHER = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    public WidgetQuickMentionsDialog() {
        super(R$layout.widget_quick_mentions_dialog);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$1(this), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$2(this));
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getDismissViewModel().getDismissEvents(), this, null, 2, null), WidgetQuickMentionsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetQuickMentionsDialog$onViewBoundOrOnResume$1(this), 62, (Object) null);
        WidgetQuickMentionsDialog$TabsAdapter widgetQuickMentionsDialog$TabsAdapter = new WidgetQuickMentionsDialog$TabsAdapter(this, requireArguments().getString(WidgetGlobalSearch.EXTRA_SEARCH_TEXT));
        ViewPager2 viewPager2 = getBinding().f2516b;
        m.checkNotNullExpressionValue(viewPager2, "binding.tabContents");
        viewPager2.setAdapter(widgetQuickMentionsDialog$TabsAdapter);
        TabLayout tabLayout = getBinding().c;
        m.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        ViewPager2 viewPager3 = getBinding().f2516b;
        m.checkNotNullExpressionValue(viewPager3, "binding.tabContents");
        ViewPager2ExtensionsKt.setUpWithViewPager2(tabLayout, viewPager3, new WidgetQuickMentionsDialog$onViewBoundOrOnResume$2(this, widgetQuickMentionsDialog$TabsAdapter));
    }
}
