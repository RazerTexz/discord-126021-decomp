package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action2;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetUserAccountVerifyBase extends AppFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EMAIL_ALLOWED = "INTENT_EMAIL_ALLOWED";
    private static final String INTENT_MODE = "INTENT_MODE";
    private static final String INTENT_PHONE_ALLOWED = "INTENT_PHONE_ALLOWED";
    private boolean isEmailAllowed;
    private boolean isPhoneAllowed;
    public Mode mode;

    /* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Intent getLaunchIntent(Mode mode, boolean phoneAllowed, boolean emailAllowed) {
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent();
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_PHONE_ALLOWED, phoneAllowed);
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_EMAIL_ALLOWED, emailAllowed);
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_MODE, mode.ordinal());
            return intent;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
    public enum Mode {
        UNFORCED,
        FORCED,
        NO_HISTORY_FROM_USER_SETTINGS
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase) {
            super(1, widgetUserAccountVerifyBase, WidgetUserAccountVerifyBase.class, "handleIsAuthorized", "handleIsAuthorized(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((WidgetUserAccountVerifyBase) this.receiver).handleIsAuthorized(z2);
        }
    }

    public WidgetUserAccountVerifyBase(@LayoutRes int i) {
        super(i);
        this.isPhoneAllowed = true;
        this.isEmailAllowed = true;
    }

    private final boolean computeShouldDismiss(boolean isMissingPhone, boolean isMissingEmailOrUnverified, RequiredAction requiredAction) {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        if (mode == Mode.UNFORCED) {
            return true;
        }
        Mode mode2 = this.mode;
        if (mode2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        if (mode2 == Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            return true;
        }
        if (isMissingPhone && requiredAction == RequiredAction.REQUIRE_VERIFIED_PHONE) {
            return true;
        }
        return (isMissingPhone || isMissingEmailOrUnverified) && requiredAction == RequiredAction.REQUIRE_VERIFIED_EMAIL;
    }

    public static final Intent getLaunchIntent(Mode mode, boolean z2, boolean z3) {
        return INSTANCE.getLaunchIntent(mode, z2, z3);
    }

    private final Observable<Boolean> getShouldDismissObservable() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableJ = Observable.j(companion.getUserRequiredActions().observeUserRequiredAction(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new Func2<RequiredAction, MeUser, Boolean>() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerifyBase.getShouldDismissObservable.1
            /* JADX WARN: Code duplicated, block: B:7:0x001a  */
            @Override // rx.functions.Func2
            public final Boolean call(RequiredAction requiredAction, MeUser meUser) {
                boolean z2;
                if (WidgetUserAccountVerifyBase.this.getIsPhoneAllowed()) {
                    UserUtils userUtils = UserUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                    if (userUtils.getHasPhone(meUser)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                boolean z3 = WidgetUserAccountVerifyBase.this.getIsEmailAllowed() && !meUser.isVerified();
                WidgetUserAccountVerifyBase widgetUserAccountVerifyBase = WidgetUserAccountVerifyBase.this;
                Intrinsics3.checkNotNullExpressionValue(requiredAction, "requiredAction");
                return Boolean.valueOf(widgetUserAccountVerifyBase.computeShouldDismiss(z2, z3, requiredAction));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…requiredAction)\n        }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationBuffered(observableJ).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        return observableR;
    }

    private final void handleIsAuthorized(boolean isAuthorized) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            if (isAuthorized) {
                return;
            }
            AppScreen2.c(context, false, null, 6);
        }
    }

    private final void setOptionsMenu() {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        AppFragment.setActionBarOptionsMenu$default(this, mode == Mode.FORCED ? R.menu.menu_settings_logout : R.menu.menu_empty, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerifyBase.setOptionsMenu.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_settings_log_out) {
                    return;
                }
                StoreStream.INSTANCE.getAuthentication().logout();
            }
        }, null, 4, null);
    }

    public final Mode getMode() {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        return mode;
    }

    /* JADX INFO: renamed from: isEmailAllowed, reason: from getter */
    public final boolean getIsEmailAllowed() {
        return this.isEmailAllowed;
    }

    public final boolean isForced() {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        return mode == Mode.FORCED;
    }

    /* JADX INFO: renamed from: isPhoneAllowed, reason: from getter */
    public final boolean getIsPhoneAllowed() {
        return this.isPhoneAllowed;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int intExtra = getMostRecentIntent().getIntExtra(INTENT_MODE, -1);
        Mode.values();
        if (intExtra >= 0 && 3 > intExtra) {
            this.mode = Mode.values()[intExtra];
            setOptionsMenu();
            this.isPhoneAllowed = getMostRecentIntent().getBooleanExtra(INTENT_PHONE_ALLOWED, this.isPhoneAllowed);
            this.isEmailAllowed = getMostRecentIntent().getBooleanExtra(INTENT_EMAIL_ALLOWED, this.isEmailAllowed);
            return;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = outline.U("Invalid mode passed into ");
        sbU.append(WidgetUserAccountVerifyBase.class.getName());
        Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        FragmentActivity fragmentActivityE = e();
        if (fragmentActivityE != null) {
            fragmentActivityE.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getShouldDismissObservable(), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    public final void setEmailAllowed(boolean z2) {
        this.isEmailAllowed = z2;
    }

    public final void setMode(Mode mode) {
        Intrinsics3.checkNotNullParameter(mode, "<set-?>");
        this.mode = mode;
    }

    public final void setPhoneAllowed(boolean z2) {
        this.isPhoneAllowed = z2;
    }
}
