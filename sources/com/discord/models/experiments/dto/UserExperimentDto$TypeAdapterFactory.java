package com.discord.models.experiments.dto;

import androidx.exifinterface.media.ExifInterface;
import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: compiled from: UserExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserExperimentDto$TypeAdapterFactory implements o {
    public static final UserExperimentDto$TypeAdapterFactory INSTANCE = new UserExperimentDto$TypeAdapterFactory();

    private UserExperimentDto$TypeAdapterFactory() {
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (gson == null || type == null || !UserExperimentDto.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        return new UserExperimentDto$TypeAdapterFactory$TypeAdapter();
    }
}
