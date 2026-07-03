package com.discord.widgets.auth;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetAuthForceChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthForceChangePassword extends WidgetSettingsAccountChangePassword {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetAuthForceChangePassword.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetAuthForceChangePassword.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword
    public void onChangePasswordSuccess() {
        AnalyticsTracker.INSTANCE.trackForceUpdatePasswordSucceeded();
    }

    @Override // com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword, com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ImageView imageView = getBinding().f17819b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.authChangePasswordIcon");
        imageView.setVisibility(0);
        setOnBackPressed(new Func0<Boolean>() { // from class: com.discord.widgets.auth.WidgetAuthForceChangePassword.onViewBound.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                StoreStream.INSTANCE.getAuthentication().logout();
                return Boolean.TRUE;
            }
        }, 0);
    }
}
