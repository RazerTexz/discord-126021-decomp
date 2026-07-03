package com.discord.api.activity;

import com.discord.api.activity.ActivityType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityTypeTypeAdapter extends TypeAdapter<ActivityType> {
    @Override // com.google.gson.TypeAdapter
    public ActivityType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        ActivityType.Companion companion = ActivityType.INSTANCE;
        Integer numM549n1 = C1460d.m549n1(jsonReader);
        Objects.requireNonNull(companion);
        ActivityType activityType = ActivityType.PLAYING;
        int apiInt = activityType.getApiInt();
        if (numM549n1 != null && numM549n1.intValue() == apiInt) {
            return activityType;
        }
        ActivityType activityType2 = ActivityType.STREAMING;
        int apiInt2 = activityType2.getApiInt();
        if (numM549n1 != null && numM549n1.intValue() == apiInt2) {
            return activityType2;
        }
        ActivityType activityType3 = ActivityType.LISTENING;
        int apiInt3 = activityType3.getApiInt();
        if (numM549n1 != null && numM549n1.intValue() == apiInt3) {
            return activityType3;
        }
        ActivityType activityType4 = ActivityType.WATCHING;
        int apiInt4 = activityType4.getApiInt();
        if (numM549n1 != null && numM549n1.intValue() == apiInt4) {
            return activityType4;
        }
        ActivityType activityType5 = ActivityType.CUSTOM_STATUS;
        int apiInt5 = activityType5.getApiInt();
        if (numM549n1 != null && numM549n1.intValue() == apiInt5) {
            return activityType5;
        }
        ActivityType activityType6 = ActivityType.COMPETING;
        return (numM549n1 != null && numM549n1.intValue() == activityType6.getApiInt()) ? activityType6 : ActivityType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ActivityType activityType) throws IOException {
        ActivityType activityType2 = activityType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (activityType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(activityType2.getApiInt()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
