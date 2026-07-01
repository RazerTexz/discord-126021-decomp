package com.discord.widgets.chat.input;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import b.a.i.t4;
import b.a.i.u4;
import b.a.i.v4;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$setWindowInsetsListeners$4 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ boolean $shouldApplyWindowInsets;
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$setWindowInsetsListeners$4(WidgetChatInput widgetChatInput, boolean z2) {
        this.this$0 = widgetChatInput;
        this.$shouldApplyWindowInsets = z2;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat$Builder().setSystemWindowInsets(Insets.of(0, 0, 0, this.$shouldApplyWindowInsets ? windowInsetsCompat.getSystemWindowInsetBottom() : 0)).build();
        m.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
        ViewCompat.dispatchApplyWindowInsets(WidgetChatInput.access$getBinding$p(this.this$0).q, windowInsetsCompatBuild);
        u4 u4Var = WidgetChatInput.access$getBinding$p(this.this$0).r;
        m.checkNotNullExpressionValue(u4Var, "binding.guard");
        ViewCompat.dispatchApplyWindowInsets(u4Var.a, windowInsetsCompatBuild);
        v4 v4Var = WidgetChatInput.access$getBinding$p(this.this$0).t;
        m.checkNotNullExpressionValue(v4Var, "binding.guardMemberVerification");
        ViewCompat.dispatchApplyWindowInsets(v4Var.a, windowInsetsCompatBuild);
        t4 t4Var = WidgetChatInput.access$getBinding$p(this.this$0).f2304s;
        m.checkNotNullExpressionValue(t4Var, "binding.guardCommunicationDisabled");
        ViewCompat.dispatchApplyWindowInsets(t4Var.a, windowInsetsCompatBuild);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
