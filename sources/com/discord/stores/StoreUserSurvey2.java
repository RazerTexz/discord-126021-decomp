package com.discord.stores;

import com.discord.api.user.UserSurvey2;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: renamed from: com.discord.stores.StoreUserSurveyKt, reason: use source file name */
/* JADX INFO: compiled from: StoreUserSurvey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSurvey2 {
    private static final Set<String> IMPLEMENTED_GUILD_REQUIREMENTS;

    static {
        UserSurvey2[] userSurvey2ArrValues = UserSurvey2.values();
        ArrayList arrayList = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            arrayList.add(userSurvey2ArrValues[i].getValue());
        }
        IMPLEMENTED_GUILD_REQUIREMENTS = _Collections.toSet(arrayList);
    }

    public static final Set<String> getIMPLEMENTED_GUILD_REQUIREMENTS() {
        return IMPLEMENTED_GUILD_REQUIREMENTS;
    }
}
