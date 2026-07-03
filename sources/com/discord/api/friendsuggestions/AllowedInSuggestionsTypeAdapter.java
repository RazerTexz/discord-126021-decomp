package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AllowedInSuggestionsType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AllowedInSuggestionsTypeAdapter extends TypeAdapter<AllowedInSuggestionsType> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public AllowedInSuggestionsType read(JsonReader jsonReader) throws IOException {
        AllowedInSuggestionsType allowedInSuggestionsType;
        C12238m.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        AllowedInSuggestionsType[] allowedInSuggestionsTypeArrValues = AllowedInSuggestionsType.values();
        for (int i = 0; i < 3; i++) {
            allowedInSuggestionsType = allowedInSuggestionsTypeArrValues[i];
            if (allowedInSuggestionsType.getApiValue() == iMo6891y) {
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
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (allowedInSuggestionsType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(allowedInSuggestionsType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
