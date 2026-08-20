package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CommandTypeAdapter extends TypeAdapter<ApplicationCommandType> {
    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        ApplicationCommandType.Companion companion = ApplicationCommandType.INSTANCE;
        int iMo6891y = jsonReader.mo6891y();
        Objects.requireNonNull(companion);
        switch (iMo6891y) {
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
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (applicationCommandType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(applicationCommandType2.getType()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
