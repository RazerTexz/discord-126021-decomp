package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import b.i.a.f.e.o.f;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import d0.z.d.m;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAppearance this$0;

    public WidgetSettingsAppearance$configureUI$1(WidgetSettingsAppearance widgetSettingsAppearance) {
        this.this$0 = widgetSettingsAppearance;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAppearance.access$getBinding$p(this.this$0).l.g(true, true);
        int andIncrement = WidgetSettingsAppearance.access$getHolyLightEasterEggCounter$p(this.this$0).getAndIncrement();
        if (andIncrement != 0) {
            if (andIncrement != 5) {
                return;
            }
            WidgetSettingsAppearance.access$showHolyLight(this.this$0);
        } else {
            m.checkNotNullExpressionValue(view, "it");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetSettingsAppearance$configureUI$1$1(this, null), 3, null);
            }
        }
    }
}
