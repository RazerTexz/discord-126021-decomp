package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$updateTheme$1$1 extends o implements Function1<ModelUserSettings, Unit> {
    public final /* synthetic */ WidgetSettingsAppearance$updateTheme$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAppearance$updateTheme$1$1(WidgetSettingsAppearance$updateTheme$1 widgetSettingsAppearance$updateTheme$1) {
        super(1);
        this.this$0 = widgetSettingsAppearance$updateTheme$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
        invoke2(modelUserSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserSettings modelUserSettings) {
        m.checkNotNullParameter(modelUserSettings, "it");
        if (m.areEqual(this.this$0.$theme, ModelUserSettings.THEME_PURE_EVIL)) {
            b.a.d.m.g(this.this$0.this$0.getActivity(), 2131896336, 0, null, 12);
        } else {
            b.a.d.m.g(this.this$0.this$0.getActivity(), 2131896338, 0, null, 12);
        }
    }
}
