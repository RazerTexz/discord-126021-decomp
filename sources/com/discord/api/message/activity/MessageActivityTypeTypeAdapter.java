package com.discord.api.message.activity;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: MessageActivityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageActivityTypeTypeAdapter extends TypeAdapter<MessageActivityType> {
    @Override // com.google.gson.TypeAdapter
    public MessageActivityType read(JsonReader jsonReader) {
        m.checkNotNullParameter(jsonReader, "in");
        return MessageActivityType.Companion.a(d.n1(jsonReader));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, MessageActivityType messageActivityType) throws IOException {
        MessageActivityType messageActivityType2 = messageActivityType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (messageActivityType2 != null) {
            jsonWriter.D(Integer.valueOf(messageActivityType2.getApiInt()));
        } else {
            jsonWriter.s();
        }
    }
}
