package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppViewFlipper;
import d0.z.d.m;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$configureUI$1<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetAgeVerify this$0;

    public WidgetAgeVerify$configureUI$1(WidgetAgeVerify widgetAgeVerify) {
        this.this$0 = widgetAgeVerify;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        AppViewFlipper appViewFlipper = WidgetAgeVerify.access$getBinding$p(this.this$0).f2224b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        int displayedChild = appViewFlipper.getDisplayedChild();
        if (displayedChild == 1) {
            WidgetAgeVerify.access$getViewModel$p(this.this$0).onConfirmBackClicked();
        } else if (displayedChild == 2 || WidgetAgeVerify.access$getViewModel$p(this.this$0).backToSafety()) {
            this.this$0.requireAppActivity().j(this.this$0.requireContext());
        } else {
            this.this$0.requireActivity().finish();
        }
        return Boolean.TRUE;
    }
}
