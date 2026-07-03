package com.discord.widgets.user.search;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGlobalSearchDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchDialog extends AppDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    /* JADX INFO: compiled from: WidgetGlobalSearchDialog.kt */
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
            if (fragmentFindFragmentByTag == null || !(fragmentFindFragmentByTag instanceof WidgetGlobalSearchDialog)) {
                return;
            }
            ((WidgetGlobalSearchDialog) fragmentFindFragmentByTag).dismiss();
        }

        public final void show(FragmentManager fragmentManager, String searchText) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            dismiss(fragmentManager);
            WidgetGlobalSearchDialog widgetGlobalSearchDialog = new WidgetGlobalSearchDialog();
            widgetGlobalSearchDialog.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
            widgetGlobalSearchDialog.show(fragmentManager, "javaClass");
            AnalyticsTracker.INSTANCE.quickSwitcherOpen();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGlobalSearchDialog.kt */
    public static final class C103251 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C103251() {
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
            WidgetGlobalSearchDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchDialog$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGlobalSearchDialog.kt */
    public static final class C103262 extends AbstractC12240o implements Function1<Long, Unit> {
        public C103262() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetGlobalSearchDialog.this.dismissAllowingStateLoss();
        }
    }

    public WidgetGlobalSearchDialog() {
        super(C5419R.layout.widget_global_search_dialog);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetGlobalSearchDialog$$special$$inlined$activityViewModels$1(this), new WidgetGlobalSearchDialog$$special$$inlined$activityViewModels$2(this));
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final WidgetGlobalSearch getFragment() {
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C5419R.id.widget_global_search_container);
        Objects.requireNonNull(fragmentFindFragmentById, "null cannot be cast to non-null type com.discord.widgets.user.search.WidgetGlobalSearch");
        return (WidgetGlobalSearch) fragmentFindFragmentById;
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        getFragment().onDismiss();
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getDismissViewModel().getDismissEvents(), this, null, 2, null), (Class<?>) WidgetGlobalSearchDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C103251());
        Observable observableM11093S = ObservableExtensionsKt.computationLatest(StoreStream.INSTANCE.getChannelsSelected().observeId()).m11112r().m11093S(1);
        C12238m.checkNotNullExpressionValue(observableM11093S, "StoreStream\n        .get…hanged()\n        .skip(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11093S, this, null, 2, null), (Class<?>) WidgetGlobalSearchDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C103262());
    }
}
