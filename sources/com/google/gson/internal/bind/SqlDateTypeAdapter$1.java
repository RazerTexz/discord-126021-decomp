package com.google.gson.internal.bind;

import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.sql.Date;

/* JADX INFO: loaded from: classes3.dex */
public class SqlDateTypeAdapter$1 implements o {
    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getRawType() == Date.class) {
            return new SqlDateTypeAdapter();
        }
        return null;
    }
}
