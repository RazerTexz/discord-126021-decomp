package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.friendsuggestions.AllowedInSuggestionsTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: AllowedInSuggestionsType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AllowedInSuggestionsType2 extends TypeAdapter<AllowedInSuggestionsType> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public AllowedInSuggestionsType read(JsonReader jsonReader) throws IOException {
        AllowedInSuggestionsType allowedInSuggestionsType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        AllowedInSuggestionsType[] allowedInSuggestionsTypeArrValues = AllowedInSuggestionsType.values();
        for (int i = 0; i < 3; i++) {
            allowedInSuggestionsType = allowedInSuggestionsTypeArrValues[i];
            if (allowedInSuggestionsType.getApiValue() == iY) {
                if (allowedInSuggestionsType != null) {
                    return allowedInSuggestionsType;
                }
                return AllowedInSuggestionsType.DISABLED;
            }
        }
        allowedInSuggestionsType = null;
        if (allowedInSuggestionsType != null) {
            return allowedInSuggestionsType;
        }
        return AllowedInSuggestionsType.DISABLED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AllowedInSuggestionsType allowedInSuggestionsType) throws IOException {
        AllowedInSuggestionsType allowedInSuggestionsType2 = allowedInSuggestionsType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (allowedInSuggestionsType2 != null) {
            jsonWriter.D(Integer.valueOf(allowedInSuggestionsType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
