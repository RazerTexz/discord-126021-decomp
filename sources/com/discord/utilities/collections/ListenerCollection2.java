package com.discord.utilities.collections;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.collections.ListenerCollectionSubject, reason: use source file name */
/* JADX INFO: compiled from: ListenerCollection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ListenerCollection2<T> implements ListenerCollection<T> {
    private final CopyOnWriteArraySet<T> listeners = new CopyOnWriteArraySet<>();

    @Override // com.discord.utilities.collections.ListenerCollection
    public void add(T listener) {
        this.listeners.add(listener);
    }

    public final void clear() {
        this.listeners.clear();
    }

    public final void notify(Function1<? super T, Unit> action) {
        Intrinsics3.checkNotNullParameter(action, "action");
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
