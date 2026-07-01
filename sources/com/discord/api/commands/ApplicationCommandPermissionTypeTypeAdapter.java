package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: ApplicationCommandPermission.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommandPermissionTypeTypeAdapter extends TypeAdapter<ApplicationCommandPermissionType> {
    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandPermissionType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        if (iY != 1) {
            return iY != 2 ? ApplicationCommandPermissionType.UNKNOWN : ApplicationCommandPermissionType.USER;
        }
        return ApplicationCommandPermissionType.ROLE;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationCommandPermissionType applicationCommandPermissionType) throws IOException {
        ApplicationCommandPermissionType applicationCommandPermissionType2 = applicationCommandPermissionType;
        m.checkNotNullParameter(jsonWriter, "out");
        int i = 2;
        if (applicationCommandPermissionType2 != null) {
            int iOrdinal = applicationCommandPermissionType2.ordinal();
            if (iOrdinal == 1) {
                i = 1;
            } else if (iOrdinal != 2) {
                i = 0;
            }
        } else {
            i = 0;
        }
        jsonWriter.D(Integer.valueOf(i));
    }
}
