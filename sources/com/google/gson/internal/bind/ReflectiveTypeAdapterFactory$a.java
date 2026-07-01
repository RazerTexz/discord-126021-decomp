package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectiveTypeAdapterFactory$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3123b;
    public final boolean c;

    public ReflectiveTypeAdapterFactory$a(String str, boolean z2, boolean z3) {
        this.a = str;
        this.f3123b = z2;
        this.c = z3;
    }

    public abstract void a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

    public abstract void b(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

    public abstract boolean c(Object obj) throws IllegalAccessException, IOException;
}
