package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreUserSettingsSystem$Settings;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$Model$Companion$get$1<T1, T2, T3, R> implements Func3<MeUser, StoreUserSettingsSystem$Settings, Boolean, WidgetSettingsAppearance$Model> {
    public static final WidgetSettingsAppearance$Model$Companion$get$1 INSTANCE = new WidgetSettingsAppearance$Model$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetSettingsAppearance$Model call(MeUser meUser, StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings, Boolean bool) {
        return call2(meUser, storeUserSettingsSystem$Settings, bool);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAppearance$Model call2(MeUser meUser, StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings, Boolean bool) {
        boolean z2;
        String theme = storeUserSettingsSystem$Settings.getTheme();
        m.checkNotNullExpressionValue(bool, "isPureEvilVisible");
        if (bool.booleanValue()) {
            z2 = true;
        } else {
            UserUtils userUtils = UserUtils.INSTANCE;
            m.checkNotNullExpressionValue(meUser, "meUser");
            if (userUtils.isStaff(meUser)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        int fontScale = storeUserSettingsSystem$Settings.getFontScale();
        m.checkNotNullExpressionValue(meUser, "meUser");
        return new WidgetSettingsAppearance$Model(theme, z2, fontScale, meUser);
    }
}
