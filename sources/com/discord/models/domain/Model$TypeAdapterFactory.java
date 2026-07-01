package com.discord.models.domain;

import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes.dex */
public class Model$TypeAdapterFactory implements o {
    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (Model.class.isAssignableFrom(typeToken.getRawType())) {
            return new Model$TypeAdapterFactory$1(this, typeToken);
        }
        return null;
    }
}
