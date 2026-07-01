package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class NullSerializable<T> implements Serializable {
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public NullSerializable(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this.value = obj;
    }

    public T a() {
        return this.value;
    }
}
