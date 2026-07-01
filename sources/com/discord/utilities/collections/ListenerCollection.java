package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: ListenerCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ListenerCollection<T> {
    void add(T listener);

    boolean remove(T listener);
}
