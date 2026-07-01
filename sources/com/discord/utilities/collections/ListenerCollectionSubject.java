package com.discord.utilities.collections;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ListenerCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ListenerCollectionSubject<T> implements ListenerCollection<T> {
    private final CopyOnWriteArraySet<T> listeners = new CopyOnWriteArraySet<>();

    @Override // com.discord.utilities.collections.ListenerCollection
    public void add(T listener) {
        this.listeners.add(listener);
    }

    public final void clear() {
        this.listeners.clear();
    }

    public final void notify(Function1<? super T, Unit> action) {
        m.checkNotNullParameter(action, "action");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            try {
                action.invoke(it.next());
            } catch (Exception e) {
                Log.e("ListenerCollection", "Exception calling handler: " + e);
            }
        }
    }

    @Override // com.discord.utilities.collections.ListenerCollection
    public boolean remove(T listener) {
        return this.listeners.remove(listener);
    }
}
