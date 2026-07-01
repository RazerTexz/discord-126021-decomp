package com.discord.api.stageinstance;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: StageInstancePrivacyLevel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageInstancePrivacyLevelTypeAdapter extends TypeAdapter<StageInstancePrivacyLevel> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public StageInstancePrivacyLevel read(JsonReader jsonReader) throws IOException {
        StageInstancePrivacyLevel stageInstancePrivacyLevel;
        m.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        StageInstancePrivacyLevel[] stageInstancePrivacyLevelArrValues = StageInstancePrivacyLevel.values();
        for (int i = 0; i < 3; i++) {
            stageInstancePrivacyLevel = stageInstancePrivacyLevelArrValues[i];
            if (stageInstancePrivacyLevel.getApiValue() == iY) {
                if (stageInstancePrivacyLevel != null) {
                    return stageInstancePrivacyLevel;
                }
                return StageInstancePrivacyLevel.INVALID;
            }
        }
        stageInstancePrivacyLevel = null;
        if (stageInstancePrivacyLevel != null) {
            return stageInstancePrivacyLevel;
        }
        return StageInstancePrivacyLevel.INVALID;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StageInstancePrivacyLevel stageInstancePrivacyLevel) throws IOException {
        StageInstancePrivacyLevel stageInstancePrivacyLevel2 = stageInstancePrivacyLevel;
        m.checkNotNullParameter(jsonWriter, "out");
        if (stageInstancePrivacyLevel2 != null) {
            jsonWriter.D(Integer.valueOf(stageInstancePrivacyLevel2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
