package com.discord.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.notice.WidgetNoticeDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: AppDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppDialog extends DialogFragment implements AppComponent {
    private boolean isRecreated;
    private boolean onViewBoundOrOnResumeInvoked;
    private final Subject<Void, Void> unsubscribeSignal;

    /* JADX INFO: renamed from: com.discord.app.AppDialog$a */
    /* JADX INFO: compiled from: AppDialog.kt */
    public static final class ViewOnClickListenerC5446a implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ View f14941k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ Function1 f14942l;

        public ViewOnClickListenerC5446a(View view, Function1 function1) {
            this.f14941k = view;
            this.f14942l = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppDialog.this.dismiss();
        }
    }

    public AppDialog() {
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
    }

    public static /* synthetic */ void hideKeyboard$default(AppDialog appDialog, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideKeyboard");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        appDialog.hideKeyboard(view);
    }

    @Override // androidx.fragment.app.DialogFragment
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

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final void hideKeyboard() {
        hideKeyboard$default(this, null, 1, null);
    }

    public final void hideKeyboard(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.hideKeyboard(view);
        }
    }

    /* JADX INFO: renamed from: isRecreated, reason: from getter */
    public final boolean getIsRecreated() {
        return this.isRecreated;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Window window;
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        C12238m.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        dialogOnCreateDialog.requestWindowFeature(1);
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled() && (window = dialogOnCreateDialog.getWindow()) != null) {
            window.setWindowAnimations(C5419R.style.FadeInOut);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TextWatcher.INSTANCE.reset(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getUnsubscribeSignal().onNext(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.onViewBoundOrOnResumeInvoked) {
            this.onViewBoundOrOnResumeInvoked = false;
        } else {
            onViewBoundOrOnResume();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        try {
            super.onStart();
        } catch (Exception e) {
            if (this instanceof WidgetNoticeDialog) {
                ((WidgetNoticeDialog) this).logOnStartError(e);
            } else {
                AppLog appLog = AppLog.f14950g;
                StringBuilder sbM833U = C1643a.m833U("Failed to start AppDialog: ");
                sbM833U.append(getClass().getName());
                Logger.e$default(appLog, sbM833U.toString(), e, null, 4, null);
            }
        }
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(C5419R.color.transparent);
    }

    @CallSuper
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
    }

    @CallSuper
    public void onViewBoundOrOnResume() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.isRecreated = savedInstanceState != null;
        DisplayUtils.drawUnderSystemBars(view);
        onViewBound(view);
        onViewBoundOrOnResume();
        this.onViewBoundOrOnResumeInvoked = true;
    }

    public final void setOnClickAndDismissListener(View view, Function1<? super View, Unit> function1) {
        C12238m.checkNotNullParameter(view, "$this$setOnClickAndDismissListener");
        C12238m.checkNotNullParameter(function1, "onClickListener");
        view.setOnClickListener(new ViewOnClickListenerC5446a(view, function1));
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        C12238m.checkNotNullParameter(manager, "manager");
        if (!isDetached()) {
            try {
                super.show(manager, tag);
            } catch (Exception unused) {
            }
        } else {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("failed to show ");
            sbM833U.append(manager.getClass().getName());
            Logger.e$default(appLog, "Could not show dialog because of detached FragmentManager", new IllegalStateException(sbM833U.toString()), null, 4, null);
        }
    }

    public final void showKeyboard(View view) {
        C12238m.checkNotNullParameter(view, "view");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.showKeyboard(view);
        }
    }

    public AppDialog(@LayoutRes int i) {
        super(i);
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
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
}
