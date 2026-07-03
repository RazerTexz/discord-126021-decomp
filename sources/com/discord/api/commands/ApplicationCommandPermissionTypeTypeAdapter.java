package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandPermission.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommandPermissionTypeTypeAdapter extends TypeAdapter<ApplicationCommandPermissionType> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandPermissionType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandPermissionType.ROLE.ordinal()] = 1;
            iArr[ApplicationCommandPermissionType.USER.ordinal()] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandPermissionType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        if (iMo6891y != 1) {
            return iMo6891y != 2 ? ApplicationCommandPermissionType.UNKNOWN : ApplicationCommandPermissionType.USER;
        }
        return ApplicationCommandPermissionType.ROLE;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationCommandPermissionType applicationCommandPermissionType) throws IOException {
        ApplicationCommandPermissionType applicationCommandPermissionType2 = applicationCommandPermissionType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
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
        jsonWriter.mo6894D(Integer.valueOf(i));
    }
}
