package com.discord.api.activity;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ActivityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityTypeTypeAdapter extends TypeAdapter<ActivityType> {
    @Override // com.google.gson.TypeAdapter
    public ActivityType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        ActivityType$Companion activityType$Companion = ActivityType.Companion;
        Integer numN1 = d.n1(jsonReader);
        Objects.requireNonNull(activityType$Companion);
        ActivityType activityType = ActivityType.PLAYING;
        int apiInt = activityType.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt) {
            return activityType;
        }
        ActivityType activityType2 = ActivityType.STREAMING;
        int apiInt2 = activityType2.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt2) {
            return activityType2;
        }
        ActivityType activityType3 = ActivityType.LISTENING;
        int apiInt3 = activityType3.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt3) {
            return activityType3;
        }
        ActivityType activityType4 = ActivityType.WATCHING;
        int apiInt4 = activityType4.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt4) {
            return activityType4;
        }
        ActivityType activityType5 = ActivityType.CUSTOM_STATUS;
        int apiInt5 = activityType5.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt5) {
            return activityType5;
        }
        ActivityType activityType6 = ActivityType.COMPETING;
        return (numN1 != null && numN1.intValue() == activityType6.getApiInt()) ? activityType6 : ActivityType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ActivityType activityType) throws IOException {
        ActivityType activityType2 = activityType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (activityType2 != null) {
            jsonWriter.D(Integer.valueOf(activityType2.getApiInt()));
        } else {
            jsonWriter.s();
        }
    }
}
