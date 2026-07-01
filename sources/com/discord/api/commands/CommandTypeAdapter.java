package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ApplicationCommandType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CommandTypeAdapter extends TypeAdapter<ApplicationCommandType> {
    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        ApplicationCommandType$Companion applicationCommandType$Companion = ApplicationCommandType.Companion;
        int iY = jsonReader.y();
        Objects.requireNonNull(applicationCommandType$Companion);
        switch (iY) {
            case 1:
                return ApplicationCommandType.SUBCOMMAND;
            case 2:
                return ApplicationCommandType.SUBCOMMAND_GROUP;
            case 3:
                return ApplicationCommandType.STRING;
            case 4:
                return ApplicationCommandType.INTEGER;
            case 5:
                return ApplicationCommandType.BOOLEAN;
            case 6:
                return ApplicationCommandType.USER;
            case 7:
                return ApplicationCommandType.CHANNEL;
            case 8:
                return ApplicationCommandType.ROLE;
            case 9:
                return ApplicationCommandType.MENTIONABLE;
            case 10:
                return ApplicationCommandType.NUMBER;
            case 11:
                return ApplicationCommandType.ATTACHMENT;
            default:
                return ApplicationCommandType.UNKNOWN;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationCommandType applicationCommandType) throws IOException {
        ApplicationCommandType applicationCommandType2 = applicationCommandType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (applicationCommandType2 != null) {
            jsonWriter.D(Integer.valueOf(applicationCommandType2.getType()));
        } else {
            jsonWriter.s();
        }
    }
}
