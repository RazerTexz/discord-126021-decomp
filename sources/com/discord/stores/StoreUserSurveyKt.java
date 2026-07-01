package com.discord.stores;

import com.discord.api.user.SurveyGuildRequirements;
import d0.t.u;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: StoreUserSurvey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSurveyKt {
    private static final Set<String> IMPLEMENTED_GUILD_REQUIREMENTS;

    static {
        SurveyGuildRequirements[] surveyGuildRequirementsArrValues = SurveyGuildRequirements.values();
        ArrayList arrayList = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            arrayList.add(surveyGuildRequirementsArrValues[i].getValue());
        }
        IMPLEMENTED_GUILD_REQUIREMENTS = u.toSet(arrayList);
    }

    public static final Set<String> getIMPLEMENTED_GUILD_REQUIREMENTS() {
        return IMPLEMENTED_GUILD_REQUIREMENTS;
    }
}
