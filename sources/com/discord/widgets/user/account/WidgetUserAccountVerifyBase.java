package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;
import p658rx.functions.Func2;

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
            C12238m.checkNotNullParameter(mode, "mode");
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

    /* JADX INFO: renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
    public static final /* synthetic */ class C102511 extends C12236k implements Function1<Boolean, Unit> {
        public C102511(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase) {
            super(1, widgetUserAccountVerifyBase, WidgetUserAccountVerifyBase.class, "handleIsAuthorized", "handleIsAuthorized(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
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
            C12238m.throwUninitializedPropertyAccessException("mode");
        }
        if (mode == Mode.UNFORCED) {
            return true;
        }
        Mode mode2 = this.mode;
        if (mode2 == null) {
            C12238m.throwUninitializedPropertyAccessException("mode");
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
        Observable observableM11076j = Observable.m11076j(companion.getUserRequiredActions().observeUserRequiredAction(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new Func2<RequiredAction, MeUser, Boolean>() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerifyBase.getShouldDismissObservable.1
            /* JADX WARN: Code duplicated, block: B:7:0x001a  */
            @Override // p658rx.functions.Func2
            public final Boolean call(RequiredAction requiredAction, MeUser meUser) {
                boolean z2;
                if (WidgetUserAccountVerifyBase.this.getIsPhoneAllowed()) {
                    UserUtils userUtils = UserUtils.INSTANCE;
                    C12238m.checkNotNullExpressionValue(meUser, "me");
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
                C12238m.checkNotNullExpressionValue(requiredAction, "requiredAction");
                return Boolean.valueOf(widgetUserAccountVerifyBase.computeShouldDismiss(z2, z3, requiredAction));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…requiredAction)\n        }");
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationBuffered(observableM11076j).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n        .comb…  .distinctUntilChanged()");
        return observableM11112r;
    }

    private final void handleIsAuthorized(boolean isAuthorized) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            if (isAuthorized) {
                return;
            }
            C0870j.m155c(context, false, null, 6);
        }
    }

    private final void setOptionsMenu() {
        Mode mode = this.mode;
        if (mode == null) {
            C12238m.throwUninitializedPropertyAccessException("mode");
        }
        AppFragment.setActionBarOptionsMenu$default(this, mode == Mode.FORCED ? C5419R.menu.menu_settings_logout : C5419R.menu.menu_empty, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerifyBase.setOptionsMenu.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_settings_log_out) {
                    return;
                }
                StoreStream.INSTANCE.getAuthentication().logout();
            }
        }, null, 4, null);
    }

    public final Mode getMode() {
        Mode mode = this.mode;
        if (mode == null) {
            C12238m.throwUninitializedPropertyAccessException("mode");
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
            C12238m.throwUninitializedPropertyAccessException("mode");
        }
        return mode == Mode.FORCED;
    }

    /* JADX INFO: renamed from: isPhoneAllowed, reason: from getter */
    public final boolean getIsPhoneAllowed() {
        return this.isPhoneAllowed;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
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
        AppLog appLog = AppLog.f14950g;
        StringBuilder sbM833U = C1643a.m833U("Invalid mode passed into ");
        sbM833U.append(WidgetUserAccountVerifyBase.class.getName());
        Logger.e$default(appLog, sbM833U.toString(), null, null, 6, null);
        FragmentActivity fragmentActivityM95e = m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getShouldDismissObservable(), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102511(this));
    }

    public final void setEmailAllowed(boolean z2) {
        this.isEmailAllowed = z2;
    }

    public final void setMode(Mode mode) {
        C12238m.checkNotNullParameter(mode, "<set-?>");
        this.mode = mode;
    }

    public final void setPhoneAllowed(boolean z2) {
        this.isPhoneAllowed = z2;
    }
}
