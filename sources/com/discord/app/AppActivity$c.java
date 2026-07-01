package com.discord.app;

import android.content.ContentResolver;
import android.util.TypedValue;
import b.a.d.c;
import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreUserSettingsSystem$Settings;
import com.discord.utilities.font.FontUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$c extends o implements Function1<StoreUserSettingsSystem$Settings, Unit> {
    public final /* synthetic */ AppActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppActivity$c(AppActivity appActivity) {
        super(1);
        this.this$0 = appActivity;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0079  */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings) {
        boolean z2;
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings2 = storeUserSettingsSystem$Settings;
        m.checkNotNullParameter(storeUserSettingsSystem$Settings2, "it");
        AppActivity appActivity = this.this$0;
        boolean z3 = AppActivity.m;
        Objects.requireNonNull(appActivity);
        Locale localeObject = ModelUserSettings.getLocaleObject(storeUserSettingsSystem$Settings2.getLocale());
        m.checkNotNullExpressionValue(localeObject, "ModelUserSettings.getLocaleObject(model.locale)");
        if (!appActivity.f(localeObject)) {
            String theme = storeUserSettingsSystem$Settings2.getTheme();
            c cVar = new c(appActivity);
            TypedValue typedValue = new TypedValue();
            cVar.this$0.getTheme().resolveAttribute(2130970308, typedValue, true);
            if (!(!m.areEqual(typedValue.string, theme))) {
                int fontScale = storeUserSettingsSystem$Settings2.getFontScale();
                FontUtils fontUtils = FontUtils.INSTANCE;
                ContentResolver contentResolver = appActivity.getContentResolver();
                m.checkNotNullExpressionValue(contentResolver, "contentResolver");
                if (!((fontScale == -1 && appActivity.originalFontScale != fontUtils.getSystemFontScaleInt(contentResolver)) || !(fontScale == -1 || appActivity.originalFontScale == fontScale))) {
                    z2 = false;
                }
            }
            if (z2) {
                AppActivity.i(this.this$0, false, 1, null);
            }
            return Unit.a;
        }
        appActivity.b(storeUserSettingsSystem$Settings2.getLocale(), true);
        z2 = true;
        if (z2) {
            AppActivity.i(this.this$0, false, 1, null);
        }
        return Unit.a;
    }
}
