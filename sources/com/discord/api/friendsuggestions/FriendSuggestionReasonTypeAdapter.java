package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: FriendSuggestionReasonType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FriendSuggestionReasonTypeAdapter extends TypeAdapter<FriendSuggestionReasonType> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public FriendSuggestionReasonType read(JsonReader jsonReader) throws IOException {
        FriendSuggestionReasonType friendSuggestionReasonType;
        m.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        FriendSuggestionReasonType[] friendSuggestionReasonTypeArrValues = FriendSuggestionReasonType.values();
        for (int i = 0; i < 2; i++) {
            friendSuggestionReasonType = friendSuggestionReasonTypeArrValues[i];
            if (friendSuggestionReasonType.getApiValue() == iY) {
                if (friendSuggestionReasonType != null) {
                    return friendSuggestionReasonType;
                }
                return FriendSuggestionReasonType.NONE;
            }
        }
        friendSuggestionReasonType = null;
        if (friendSuggestionReasonType != null) {
            return friendSuggestionReasonType;
        }
        return FriendSuggestionReasonType.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, FriendSuggestionReasonType friendSuggestionReasonType) throws IOException {
        FriendSuggestionReasonType friendSuggestionReasonType2 = friendSuggestionReasonType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (friendSuggestionReasonType2 != null) {
            jsonWriter.D(Integer.valueOf(friendSuggestionReasonType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
