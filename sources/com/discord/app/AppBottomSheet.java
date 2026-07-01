package com.discord.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.view.text.TextWatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppBottomSheet extends BottomSheetDialogFragment implements AppPermissionsRequests, AppComponent, AppLogger$a {

    /* JADX INFO: renamed from: appLogger$delegate, reason: from kotlin metadata */
    private final Lazy appLogger;
    private CompositeSubscription compositeSubscription;
    private final LoggingConfig loggingConfig;
    private View peekBottomView;
    private final View$OnLayoutChangeListener peekLayoutListener;
    private final boolean shouldAvoidKeyboard;
    private final Subject<Void, Void> unsubscribeSignal;

    public AppBottomSheet() {
        this(false, 1, null);
    }

    public /* synthetic */ AppBottomSheet(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2);
    }

    private final void fixWindowInsetHandling() {
        View viewFindViewById;
        View view = getView();
        if (view == null || (viewFindViewById = view.getRootView().findViewById(2131362883)) == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, AppBottomSheet$a.a);
        View viewFindViewById2 = view.getRootView().findViewById(2131363003);
        m.checkNotNullExpressionValue(viewFindViewById2, "designBottomSheet");
        viewFindViewById2.setFitsSystemWindows(true);
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById2, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        ViewCompat.setOnApplyWindowInsetsListener(view, AppBottomSheet$a.f2078b);
    }

    private final AppLogger getAppLogger() {
        return (AppLogger) this.appLogger.getValue();
    }

    private final BottomSheetBehavior<View> getBottomSheetBehavior() {
        View view = getView();
        Object parent = view != null ? view.getParent() : null;
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view2 = (View) parent;
        ViewGroup$LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
        if (!(layoutParams instanceof CoordinatorLayout$LayoutParams)) {
            layoutParams = null;
        }
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams) layoutParams;
        CoordinatorLayout$Behavior behavior = coordinatorLayout$LayoutParams != null ? coordinatorLayout$LayoutParams.getBehavior() : null;
        return (BottomSheetBehavior) (behavior instanceof BottomSheetBehavior ? behavior : null);
    }

    public static /* synthetic */ void hideKeyboard$default(AppBottomSheet appBottomSheet, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideKeyboard");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        appBottomSheet.hideKeyboard(view);
    }

    private final void resizeContentForSoftInput() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(16);
    }

    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public final AppActivity getAppActivity() {
        return (AppActivity) getActivity();
    }

    public final Bundle getArgumentsOrDefault() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        m.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
        return arguments;
    }

    @LayoutRes
    public abstract int getContentViewResId();

    @Override // com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // com.discord.app.AppPermissionsRequests
    public boolean hasMedia() {
        return requireAppActivity().appPermissions.hasMedia();
    }

    public final void hideKeyboard(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.hideKeyboard(view);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.shouldAvoidKeyboard) {
            setStyle(0, 2131952533);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(true);
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            m.checkNotNullExpressionValue(dialogOnCreateDialog, "dialog");
            Window window = dialogOnCreateDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(2131951962);
            }
        }
        if (this.shouldAvoidKeyboard) {
            dialogOnCreateDialog.setOnShowListener(new AppBottomSheet$c(dialogOnCreateDialog, this));
        }
        m.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…      }\n      }\n    }\n  }");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getContentViewResId(), (ViewGroup) null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        TextWatcher.Companion.reset(this);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CompositeSubscription compositeSubscription = this.compositeSubscription;
        if (compositeSubscription != null) {
            compositeSubscription.b();
        }
        getUnsubscribeSignal().onNext(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        fixWindowInsetHandling();
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        bindSubscriptions(compositeSubscription);
        this.compositeSubscription = compositeSubscription;
    }

    public void onStateChanged(int state) {
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DisplayUtils.drawUnderSystemBars(view);
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setBottomSheetCallback(new AppBottomSheet$d(this));
        }
        getAppLogger().b();
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFailure, "onFailure");
        requireAppActivity().appPermissions.requestContacts(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestMedia(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMedia(onSuccess);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestMediaDownload(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMediaDownload(onSuccess);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMicrophone(onFailure, onSuccess);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestVideoCallPermissions(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestVideoCallPermissions(onSuccess);
    }

    public final AppActivity requireAppActivity() {
        AppActivity appActivity = getAppActivity();
        m.checkNotNull(appActivity);
        return appActivity;
    }

    public final Unit setBottomSheetCollapsedStateDisabled() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        resizeContentForSoftInput();
        dialog.setOnShowListener(new AppBottomSheet$f(dialog));
        return Unit.a;
    }

    public final void setBottomSheetState(int state) {
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(state);
        }
    }

    public final void setOnClickAndDismissListener(View view, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(view, "$this$setOnClickAndDismissListener");
        m.checkNotNullParameter(function1, "onClickListener");
        view.setOnClickListener(new AppBottomSheet$g(this, view, function1));
    }

    public final void setPeekHeightBottomView(View targetView) {
        if (m.areEqual(this.peekBottomView, targetView)) {
            return;
        }
        View view = this.peekBottomView;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.peekLayoutListener);
        }
        this.peekBottomView = targetView;
        if (targetView == null) {
            setPeekHeightBottomView(getView());
        } else {
            targetView.addOnLayoutChangeListener(this.peekLayoutListener);
            targetView.requestLayout();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        m.checkNotNullParameter(manager, "manager");
        if (manager.findFragmentByTag(tag) != null) {
            return;
        }
        try {
            super.show(manager, tag);
        } catch (Exception unused) {
        }
    }

    public final void showKeyboard(View view) {
        m.checkNotNullParameter(view, "view");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.showKeyboard(view);
        }
    }

    public final void updatePeekHeightPx(int peekHeightPx) {
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(peekHeightPx);
        }
    }

    public AppBottomSheet(boolean z2) {
        this.shouldAvoidKeyboard = z2;
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.peekLayoutListener = new AppBottomSheet$e(this);
        this.appLogger = g.lazy(new AppBottomSheet$b(this));
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction transaction, String tag) {
        m.checkNotNullParameter(transaction, "transaction");
        try {
            return super.show(transaction, tag);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestCameraQRScanner(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess);
    }
}
