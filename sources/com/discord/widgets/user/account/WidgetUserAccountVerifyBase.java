package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentActivity;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetUserAccountVerifyBase extends AppFragment {
    public static final WidgetUserAccountVerifyBase$Companion Companion = new WidgetUserAccountVerifyBase$Companion(null);
    private static final String INTENT_EMAIL_ALLOWED = "INTENT_EMAIL_ALLOWED";
    private static final String INTENT_MODE = "INTENT_MODE";
    private static final String INTENT_PHONE_ALLOWED = "INTENT_PHONE_ALLOWED";
    private boolean isEmailAllowed;
    private boolean isPhoneAllowed;
    public WidgetUserAccountVerifyBase$Mode mode;

    public WidgetUserAccountVerifyBase(@LayoutRes int i) {
        super(i);
        this.isPhoneAllowed = true;
        this.isEmailAllowed = true;
    }

    public static final /* synthetic */ boolean access$computeShouldDismiss(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase, boolean z2, boolean z3, RequiredAction requiredAction) {
        return widgetUserAccountVerifyBase.computeShouldDismiss(z2, z3, requiredAction);
    }

    public static final /* synthetic */ void access$handleIsAuthorized(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase, boolean z2) {
        widgetUserAccountVerifyBase.handleIsAuthorized(z2);
    }

    private final boolean computeShouldDismiss(boolean isMissingPhone, boolean isMissingEmailOrUnverified, RequiredAction requiredAction) {
        WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode = this.mode;
        if (widgetUserAccountVerifyBase$Mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        if (widgetUserAccountVerifyBase$Mode == WidgetUserAccountVerifyBase$Mode.UNFORCED) {
            return true;
        }
        WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode2 = this.mode;
        if (widgetUserAccountVerifyBase$Mode2 == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        if (widgetUserAccountVerifyBase$Mode2 == WidgetUserAccountVerifyBase$Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            return true;
        }
        if (isMissingPhone && requiredAction == RequiredAction.REQUIRE_VERIFIED_PHONE) {
            return true;
        }
        return (isMissingPhone || isMissingEmailOrUnverified) && requiredAction == RequiredAction.REQUIRE_VERIFIED_EMAIL;
    }

    public static final Intent getLaunchIntent(WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode, boolean z2, boolean z3) {
        return Companion.getLaunchIntent(widgetUserAccountVerifyBase$Mode, z2, z3);
    }

    private final Observable<Boolean> getShouldDismissObservable() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableJ = Observable.j(storeStream$Companion.getUserRequiredActions().observeUserRequiredAction(), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), new WidgetUserAccountVerifyBase$getShouldDismissObservable$1(this));
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…requiredAction)\n        }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationBuffered(observableJ).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        return observableR;
    }

    private final void handleIsAuthorized(boolean isAuthorized) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            if (isAuthorized) {
                return;
            }
            j.c(context, false, null, 6);
        }
    }

    private final void setOptionsMenu() {
        WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode = this.mode;
        if (widgetUserAccountVerifyBase$Mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        AppFragment.setActionBarOptionsMenu$default(this, widgetUserAccountVerifyBase$Mode == WidgetUserAccountVerifyBase$Mode.FORCED ? R$menu.menu_settings_logout : R$menu.menu_empty, WidgetUserAccountVerifyBase$setOptionsMenu$1.INSTANCE, null, 4, null);
    }

    public final WidgetUserAccountVerifyBase$Mode getMode() {
        WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode = this.mode;
        if (widgetUserAccountVerifyBase$Mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        return widgetUserAccountVerifyBase$Mode;
    }

    /* JADX INFO: renamed from: isEmailAllowed, reason: from getter */
    public final boolean getIsEmailAllowed() {
        return this.isEmailAllowed;
    }

    public final boolean isForced() {
        WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode = this.mode;
        if (widgetUserAccountVerifyBase$Mode == null) {
            m.throwUninitializedPropertyAccessException("mode");
        }
        return widgetUserAccountVerifyBase$Mode == WidgetUserAccountVerifyBase$Mode.FORCED;
    }

    /* JADX INFO: renamed from: isPhoneAllowed, reason: from getter */
    public final boolean getIsPhoneAllowed() {
        return this.isPhoneAllowed;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int intExtra = getMostRecentIntent().getIntExtra(INTENT_MODE, -1);
        WidgetUserAccountVerifyBase$Mode.values();
        if (intExtra >= 0 && 3 > intExtra) {
            this.mode = WidgetUserAccountVerifyBase$Mode.values()[intExtra];
            setOptionsMenu();
            this.isPhoneAllowed = getMostRecentIntent().getBooleanExtra(INTENT_PHONE_ALLOWED, this.isPhoneAllowed);
            this.isEmailAllowed = getMostRecentIntent().getBooleanExtra(INTENT_EMAIL_ALLOWED, this.isEmailAllowed);
            return;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("Invalid mode passed into ");
        sbU.append(WidgetUserAccountVerifyBase.class.getName());
        Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getShouldDismissObservable(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserAccountVerifyBase$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }

    public final void setEmailAllowed(boolean z2) {
        this.isEmailAllowed = z2;
    }

    public final void setMode(WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode) {
        m.checkNotNullParameter(widgetUserAccountVerifyBase$Mode, "<set-?>");
        this.mode = widgetUserAccountVerifyBase$Mode;
    }

    public final void setPhoneAllowed(boolean z2) {
        this.isPhoneAllowed = z2;
    }
}
