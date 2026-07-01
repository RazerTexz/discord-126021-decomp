package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/* JADX INFO: compiled from: UserExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserExperimentDto$TypeAdapterFactory$TypeAdapter extends TypeAdapter<UserExperimentDto> {
    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ UserExperimentDto read(JsonReader jsonReader) {
        return read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, UserExperimentDto userExperimentDto) {
        write2(jsonWriter, userExperimentDto);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public UserExperimentDto read(JsonReader in) {
        return UserExperimentDto$Parser.parse(new Model$JsonReader(in));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter out, UserExperimentDto value) {
        throw new UnsupportedOperationException();
    }
}
