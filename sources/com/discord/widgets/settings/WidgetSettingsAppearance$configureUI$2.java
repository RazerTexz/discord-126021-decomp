package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.k.b;
import b.i.a.f.e.o.f;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import d0.z.d.m;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAppearance$Model $model;
    public final /* synthetic */ WidgetSettingsAppearance this$0;

    public WidgetSettingsAppearance$configureUI$2(WidgetSettingsAppearance widgetSettingsAppearance, WidgetSettingsAppearance$Model widgetSettingsAppearance$Model) {
        this.this$0 = widgetSettingsAppearance;
        this.$model = widgetSettingsAppearance$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAppearance.access$getBinding$p(this.this$0).j.g(true, true);
        if (this.$model.getCanSeePureEvil()) {
            return;
        }
        int andIncrement = WidgetSettingsAppearance.access$getPureEvilEasterEggCounter$p(this.this$0).getAndIncrement();
        if (andIncrement == 0) {
            m.checkNotNullExpressionValue(view, "it");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetSettingsAppearance$configureUI$2$1(this, null), 3, null);
                return;
            }
            return;
        }
        if (3 <= andIncrement && 8 > andIncrement) {
            m.checkNotNullExpressionValue(view, "it");
            b.a.d.m.h(view.getContext(), b.k(this.this$0, 2131896333, new Object[]{String.valueOf(8 - andIncrement)}, null, 4), 0, WidgetSettingsAppearance.access$getToastManager$p(this.this$0), 4);
        } else if (andIncrement == 8) {
            b.a.d.m.d(this.this$0.getContext(), 2131896334, 0, WidgetSettingsAppearance.access$getToastManager$p(this.this$0));
            WidgetSettingsAppearance.access$getPureEvilEasterEggSubject$p(this.this$0).onNext(Boolean.TRUE);
        }
    }
}
