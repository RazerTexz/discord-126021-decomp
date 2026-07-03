package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$pureEvilEasterEggSubject$2 extends AbstractC12240o implements Function0<BehaviorSubject<Boolean>> {
    public static final WidgetSettingsAppearance$pureEvilEasterEggSubject$2 INSTANCE = new WidgetSettingsAppearance$pureEvilEasterEggSubject$2();

    public WidgetSettingsAppearance$pureEvilEasterEggSubject$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final BehaviorSubject<Boolean> invoke() {
        return BehaviorSubject.m11130l0(Boolean.valueOf(C12238m.areEqual(StoreStream.INSTANCE.getUserSettingsSystem().getTheme(), ModelUserSettings.THEME_PURE_EVIL)));
    }
}
