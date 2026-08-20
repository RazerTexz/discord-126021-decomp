package com.discord.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppBottomSheet extends BottomSheetDialogFragment implements AppPermissionsRequests, AppComponent, AppLogger.InterfaceC5455a {

    /* JADX INFO: renamed from: appLogger$delegate, reason: from kotlin metadata */
    private final Lazy appLogger;
    private CompositeSubscription compositeSubscription;
    private final LoggingConfig loggingConfig;
    private View peekBottomView;
    private final View.OnLayoutChangeListener peekLayoutListener;
    private final boolean shouldAvoidKeyboard;
    private final Subject<Void, Void> unsubscribeSignal;

    /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class C5439a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a */
        public static final C5439a f14929a = new C5439a(0);

        /* JADX INFO: renamed from: b */
        public static final C5439a f14930b = new C5439a(1);

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ int f14931c;

        public C5439a(int i) {
            this.f14931c = i;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i = this.f14931c;
            if (i == 0) {
                C12238m.checkNotNullParameter(view, "v");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
                return new WindowInsetsCompat.Builder(windowInsetsCompat).setSystemWindowInsets(Insets.m82of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
            }
            if (i != 1) {
                throw null;
            }
            C12238m.checkNotNullExpressionValue(view, "v");
            C12238m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$b */
    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class C5440b extends AbstractC12240o implements Function0<AppLogger> {
        public C5440b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppLogger invoke() {
            return new AppLogger(AppBottomSheet.this, null, false, 6);
        }
    }

    /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$c */
    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class DialogInterfaceOnShowListenerC5441c implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Dialog f14932a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ AppBottomSheet f14933b;

        /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$c$a */
        /* JADX INFO: compiled from: AppBottomSheet.kt */
        public static final class a extends AbstractC12240o implements Function1<Unit, Unit> {
            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Unit unit) {
                BottomSheetBehavior<FrameLayout> behavior;
                Dialog dialog = DialogInterfaceOnShowListenerC5441c.this.f14932a;
                if (!(dialog instanceof BottomSheetDialog)) {
                    dialog = null;
                }
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
                if (bottomSheetDialog != null && (behavior = bottomSheetDialog.getBehavior()) != null) {
                    behavior.setState(3);
                }
                return Unit.f27425a;
            }
        }

        public DialogInterfaceOnShowListenerC5441c(Dialog dialog, AppBottomSheet appBottomSheet) {
            this.f14932a = dialog;
            this.f14933b = appBottomSheet;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            C12721k c12721k = new C12721k(Unit.f27425a);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(Unit)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(c12721k, this.f14933b, null, 2, null), (Class<?>) this.f14933b.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new a());
        }
    }

    /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$d */
    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class C5442d extends BottomSheetBehavior.BottomSheetCallback {
        public C5442d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
            C12238m.checkNotNullParameter(view, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            C12238m.checkNotNullParameter(view, "bottomSheet");
            AppBottomSheet.this.onStateChanged(i);
            if (i == 5) {
                AppBottomSheet.this.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$e */
    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class ViewOnLayoutChangeListenerC5443e implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC5443e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppBottomSheet.this.updatePeekHeightPx(i4);
        }
    }

    /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$f */
    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class DialogInterfaceOnShowListenerC5444f implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Dialog f14936a;

        public DialogInterfaceOnShowListenerC5444f(Dialog dialog) {
            this.f14936a = dialog;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.f14936a.findViewById(C5419R.id.design_bottom_sheet));
            C12238m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from(bottomSheet)");
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
            bottomSheetBehaviorFrom.setState(3);
        }
    }

    /* JADX INFO: renamed from: com.discord.app.AppBottomSheet$g */
    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class ViewOnClickListenerC5445g implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ View f14938k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ Function1 f14939l;

        public ViewOnClickListenerC5445g(View view, Function1 function1) {
            this.f14938k = view;
            this.f14939l = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppBottomSheet.this.dismiss();
        }
    }

    public AppBottomSheet() {
        this(false, 1, null);
    }

    public /* synthetic */ AppBottomSheet(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2);
    }

    private final void fixWindowInsetHandling() {
        View viewFindViewById;
        View view = getView();
        if (view == null || (viewFindViewById = view.getRootView().findViewById(C5419R.id.container)) == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, C5439a.f14929a);
        View viewFindViewById2 = view.getRootView().findViewById(C5419R.id.design_bottom_sheet);
        C12238m.checkNotNullExpressionValue(viewFindViewById2, "designBottomSheet");
        viewFindViewById2.setFitsSystemWindows(true);
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById2, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        ViewCompat.setOnApplyWindowInsetsListener(view, C5439a.f14930b);
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
        ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            layoutParams = null;
        }
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        CoordinatorLayout.Behavior behavior = layoutParams2 != null ? layoutParams2.getBehavior() : null;
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
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public final AppActivity getAppActivity() {
        return (AppActivity) m95e();
    }

    public final Bundle getArgumentsOrDefault() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        C12238m.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
        return arguments;
    }

    @LayoutRes
    public abstract int getContentViewResId();

    @Override // com.discord.app.AppLogger.InterfaceC5455a
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
            C12238m.checkNotNullExpressionValue(dialogOnCreateDialog, "dialog");
            Window window = dialogOnCreateDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(C5419R.style.FadeInOut);
            }
        }
        if (this.shouldAvoidKeyboard) {
            dialogOnCreateDialog.setOnShowListener(new DialogInterfaceOnShowListenerC5441c(dialogOnCreateDialog, this));
        }
        C12238m.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…      }\n      }\n    }\n  }");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getContentViewResId(), (ViewGroup) null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        TextWatcher.INSTANCE.reset(this);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CompositeSubscription compositeSubscription = this.compositeSubscription;
        if (compositeSubscription != null) {
            compositeSubscription.m11137b();
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DisplayUtils.drawUnderSystemBars(view);
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setBottomSheetCallback(new C5442d());
        }
        getAppLogger().m8372b();
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        C12238m.checkNotNullParameter(onFailure, "onFailure");
        requireAppActivity().appPermissions.requestContacts(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestMedia(Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMedia(onSuccess);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestMediaDownload(Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMediaDownload(onSuccess);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMicrophone(onFailure, onSuccess);
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestVideoCallPermissions(Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestVideoCallPermissions(onSuccess);
    }

    public final AppActivity requireAppActivity() {
        AppActivity appActivity = getAppActivity();
        C12238m.checkNotNull(appActivity);
        return appActivity;
    }

    public final Unit setBottomSheetCollapsedStateDisabled() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        resizeContentForSoftInput();
        dialog.setOnShowListener(new DialogInterfaceOnShowListenerC5444f(dialog));
        return Unit.f27425a;
    }

    public final void setBottomSheetState(int state) {
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(state);
        }
    }

    public final void setOnClickAndDismissListener(View view, Function1<? super View, Unit> function1) {
        C12238m.checkNotNullParameter(view, "$this$setOnClickAndDismissListener");
        C12238m.checkNotNullParameter(function1, "onClickListener");
        view.setOnClickListener(new ViewOnClickListenerC5445g(view, function1));
    }

    public final void setPeekHeightBottomView(View targetView) {
        if (C12238m.areEqual(this.peekBottomView, targetView)) {
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
        C12238m.checkNotNullParameter(manager, "manager");
        if (manager.findFragmentByTag(tag) != null) {
            return;
        }
        try {
            super.show(manager, tag);
        } catch (Exception unused) {
        }
    }

    public final void showKeyboard(View view) {
        C12238m.checkNotNullParameter(view, "view");
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
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
        this.peekLayoutListener = new ViewOnLayoutChangeListenerC5443e();
        this.appLogger = C12083g.lazy(new C5440b());
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction transaction, String tag) {
        C12238m.checkNotNullParameter(transaction, "transaction");
        try {
            return super.show(transaction, tag);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.discord.app.AppPermissionsRequests
    public void requestCameraQRScanner(Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess);
    }
}
