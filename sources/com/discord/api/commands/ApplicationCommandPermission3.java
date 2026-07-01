package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: ApplicationCommandPermission.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommandPermission3 extends TypeAdapter<ApplicationCommandPermission2> {

    /* JADX INFO: renamed from: com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandPermission2.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandPermission2.ROLE.ordinal()] = 1;
            iArr[ApplicationCommandPermission2.USER.ordinal()] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandPermission2 read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        if (iY != 1) {
            return iY != 2 ? ApplicationCommandPermission2.UNKNOWN : ApplicationCommandPermission2.USER;
        }
        return ApplicationCommandPermission2.ROLE;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationCommandPermission2 applicationCommandPermission2) throws IOException {
        ApplicationCommandPermission2 applicationCommandPermission3 = applicationCommandPermission2;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        int i = 2;
        if (applicationCommandPermission3 != null) {
            int iOrdinal = applicationCommandPermission3.ordinal();
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
