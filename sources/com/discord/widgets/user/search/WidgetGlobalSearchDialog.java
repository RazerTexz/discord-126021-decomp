package com.discord.widgets.user.search;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGlobalSearchDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchDialog extends AppDialog {
    public static final WidgetGlobalSearchDialog$Companion Companion = new WidgetGlobalSearchDialog$Companion(null);

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    public WidgetGlobalSearchDialog() {
        super(R$layout.widget_global_search_dialog);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetGlobalSearchDialog$$special$$inlined$activityViewModels$1(this), new WidgetGlobalSearchDialog$$special$$inlined$activityViewModels$2(this));
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final WidgetGlobalSearch getFragment() {
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R$id.widget_global_search_container);
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getDismissViewModel().getDismissEvents(), this, null, 2, null), WidgetGlobalSearchDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalSearchDialog$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable observableS = ObservableExtensionsKt.computationLatest(StoreStream.Companion.getChannelsSelected().observeId()).r().S(1);
        m.checkNotNullExpressionValue(observableS, "StoreStream\n        .get…hanged()\n        .skip(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableS, this, null, 2, null), WidgetGlobalSearchDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGlobalSearchDialog$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
