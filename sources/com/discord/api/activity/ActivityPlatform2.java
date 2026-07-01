package com.discord.api.activity;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: renamed from: com.discord.api.activity.ActivityPlatformTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: ActivityPlatform.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityPlatform2 extends TypeAdapter<ActivityPlatform> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.gson.TypeAdapter
    public ActivityPlatform read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        if (strJ != null) {
            switch (strJ.hashCode()) {
                case -1998723398:
                    if (strJ.equals("spotify")) {
                        return ActivityPlatform.SPOTIFY;
                    }
                    break;
                case -861391249:
                    if (strJ.equals("android")) {
                        return ActivityPlatform.ANDROID;
                    }
                    break;
                case 104461:
                    if (strJ.equals("ios")) {
                        return ActivityPlatform.IOS;
                    }
                    break;
                case 111249:
                    if (strJ.equals("ps4")) {
                        return ActivityPlatform.PS4;
                    }
                    break;
                case 111250:
                    if (strJ.equals("ps5")) {
                        return ActivityPlatform.PS5;
                    }
                    break;
                case 3672659:
                    if (strJ.equals("xbox")) {
                        return ActivityPlatform.XBOX;
                    }
                    break;
                case 1557106716:
                    if (strJ.equals("desktop")) {
                        return ActivityPlatform.DESKTOP;
                    }
                    break;
                case 1864941562:
                    if (strJ.equals("samsung")) {
                        return ActivityPlatform.SAMSUNG;
                    }
                    break;
            }
        }
        return ActivityPlatform.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ActivityPlatform activityPlatform) throws IOException {
        String lowerCase;
        String strName;
        ActivityPlatform activityPlatform2 = activityPlatform;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (activityPlatform2 == null || (strName = activityPlatform2.name()) == null) {
            lowerCase = null;
        } else {
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            lowerCase = strName.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        jsonWriter.H(lowerCase);
    }
}
