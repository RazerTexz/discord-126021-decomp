package com.discord.widgets.auth;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import b.a.d.AppScreen2;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Func0;

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
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetAuthForceChangePassword.class, null, 4);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ImageView imageView = getBinding().f2596b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.authChangePasswordIcon");
        imageView.setVisibility(0);
        setOnBackPressed(new Func0<Boolean>() { // from class: com.discord.widgets.auth.WidgetAuthForceChangePassword.onViewBound.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                StoreStream.INSTANCE.getAuthentication().logout();
                return Boolean.TRUE;
            }
        }, 0);
    }
}
