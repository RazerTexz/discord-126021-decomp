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
import com.discord.R;
import com.discord.app.AppLogger;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppBottomSheet extends BottomSheetDialogFragment implements AppPermissions2, AppComponent, AppLogger.a {

    /* JADX INFO: renamed from: appLogger$delegate, reason: from kotlin metadata */
    private final Lazy appLogger;
    private CompositeSubscription compositeSubscription;
    private final AppLogger2 loggingConfig;
    private View peekBottomView;
    private final View.OnLayoutChangeListener peekLayoutListener;
    private final boolean shouldAvoidKeyboard;
    private final Subject<Void, Void> unsubscribeSignal;

    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements OnApplyWindowInsetsListener {
        public static final a a = new a(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2078b = new a(1);
        public final /* synthetic */ int c;

        public a(int i) {
            this.c = i;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i = this.c;
            if (i == 0) {
                Intrinsics3.checkNotNullParameter(view, "v");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
                return new WindowInsetsCompat.Builder(windowInsetsCompat).setSystemWindowInsets(Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
            }
            if (i != 1) {
                throw null;
            }
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class b extends Lambda implements Function0<AppLogger> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppLogger invoke() {
            return new AppLogger(AppBottomSheet.this, null, false, 6);
        }
    }

    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class c implements DialogInterface.OnShowListener {
        public final /* synthetic */ Dialog a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppBottomSheet f2079b;

        /* JADX INFO: compiled from: AppBottomSheet.kt */
        public static final class a extends Lambda implements Function1<Unit, Unit> {
            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Unit unit) {
                BottomSheetBehavior<FrameLayout> behavior;
                Dialog dialog = c.this.a;
                if (!(dialog instanceof BottomSheetDialog)) {
                    dialog = null;
                }
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
                if (bottomSheetDialog != null && (behavior = bottomSheetDialog.getBehavior()) != null) {
                    behavior.setState(3);
                }
                return Unit.a;
            }
        }

        public c(Dialog dialog, AppBottomSheet appBottomSheet) {
            this.a = dialog;
            this.f2079b = appBottomSheet;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.a);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Unit)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(scalarSynchronousObservable, this.f2079b, null, 2, null), (Class<?>) this.f2079b.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new a());
        }
    }

    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class d extends BottomSheetBehavior.BottomSheetCallback {
        public d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
            Intrinsics3.checkNotNullParameter(view, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            Intrinsics3.checkNotNullParameter(view, "bottomSheet");
            AppBottomSheet.this.onStateChanged(i);
            if (i == 5) {
                AppBottomSheet.this.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppBottomSheet.this.updatePeekHeightPx(i4);
        }
    }

    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class f implements DialogInterface.OnShowListener {
        public final /* synthetic */ Dialog a;

        public f(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.a.findViewById(R.id.design_bottom_sheet));
            Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from(bottomSheet)");
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
            bottomSheetBehaviorFrom.setState(3);
        }
    }

    /* JADX INFO: compiled from: AppBottomSheet.kt */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ View k;
        public final /* synthetic */ Function1 l;

        public g(View view, Function1 function1) {
            this.k = view;
            this.l = function1;
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
        if (view == null || (viewFindViewById = view.getRootView().findViewById(R.id.container)) == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, a.a);
        View viewFindViewById2 = view.getRootView().findViewById(R.id.design_bottom_sheet);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById2, "designBottomSheet");
        viewFindViewById2.setFitsSystemWindows(true);
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById2, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        ViewCompat.setOnApplyWindowInsetsListener(view, a.f2078b);
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
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public final AppActivity getAppActivity() {
        return (AppActivity) e();
    }

    public final Bundle getArgumentsOrDefault() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        Intrinsics3.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
        return arguments;
    }

    @LayoutRes
    public abstract int getContentViewResId();

    @Override // com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // com.discord.app.AppPermissions2
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
            Intrinsics3.checkNotNullExpressionValue(dialogOnCreateDialog, "dialog");
            Window window = dialogOnCreateDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.FadeInOut);
            }
        }
        if (this.shouldAvoidKeyboard) {
            dialogOnCreateDialog.setOnShowListener(new c(dialogOnCreateDialog, this));
        }
        Intrinsics3.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…      }\n      }\n    }\n  }");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DisplayUtils.drawUnderSystemBars(view);
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setBottomSheetCallback(new d());
        }
        getAppLogger().b();
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        requireAppActivity().appPermissions.requestContacts(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMedia(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMedia(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMediaDownload(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMediaDownload(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMicrophone(onFailure, onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestVideoCallPermissions(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestVideoCallPermissions(onSuccess);
    }

    public final AppActivity requireAppActivity() {
        AppActivity appActivity = getAppActivity();
        Intrinsics3.checkNotNull(appActivity);
        return appActivity;
    }

    public final Unit setBottomSheetCollapsedStateDisabled() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        resizeContentForSoftInput();
        dialog.setOnShowListener(new f(dialog));
        return Unit.a;
    }

    public final void setBottomSheetState(int state) {
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(state);
        }
    }

    public final void setOnClickAndDismissListener(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$setOnClickAndDismissListener");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        view.setOnClickListener(new g(view, function1));
    }

    public final void setPeekHeightBottomView(View targetView) {
        if (Intrinsics3.areEqual(this.peekBottomView, targetView)) {
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
        Intrinsics3.checkNotNullParameter(manager, "manager");
        if (manager.findFragmentByTag(tag) != null) {
            return;
        }
        try {
            super.show(manager, tag);
        } catch (Exception unused) {
        }
    }

    public final void showKeyboard(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
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
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.peekLayoutListener = new e();
        this.appLogger = LazyJVM.lazy(new b());
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction transaction, String tag) {
        Intrinsics3.checkNotNullParameter(transaction, "transaction");
        try {
            return super.show(transaction, tag);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess);
    }
}
