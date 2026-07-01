package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$pureEvilEasterEggSubject$2 extends o implements Function0<BehaviorSubject<Boolean>> {
    public static final WidgetSettingsAppearance$pureEvilEasterEggSubject$2 INSTANCE = new WidgetSettingsAppearance$pureEvilEasterEggSubject$2();

    public WidgetSettingsAppearance$pureEvilEasterEggSubject$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ BehaviorSubject<Boolean> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BehaviorSubject<Boolean> invoke2() {
        return BehaviorSubject.l0(Boolean.valueOf(m.areEqual(StoreStream.Companion.getUserSettingsSystem().getTheme(), ModelUserSettings.THEME_PURE_EVIL)));
    }
}
