package androidx.core.view;

import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import androidx.core.R$id;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class ViewCompat$CompatImplApi28 {
    private ViewCompat$CompatImplApi28() {
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat) {
        int i = R$id.tag_unhandled_key_listeners;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i);
        if (simpleArrayMap == null) {
            simpleArrayMap = new SimpleArrayMap();
            view.setTag(i, simpleArrayMap);
        }
        ViewCompat$CompatImplApi28$1 viewCompat$CompatImplApi28$1 = new ViewCompat$CompatImplApi28$1(viewCompat$OnUnhandledKeyEventListenerCompat);
        simpleArrayMap.put(viewCompat$OnUnhandledKeyEventListenerCompat, viewCompat$CompatImplApi28$1);
        view.addOnUnhandledKeyEventListener(viewCompat$CompatImplApi28$1);
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat) {
        View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R$id.tag_unhandled_key_listeners);
        if (simpleArrayMap == null || (view$OnUnhandledKeyEventListener = (View$OnUnhandledKeyEventListener) simpleArrayMap.get(viewCompat$OnUnhandledKeyEventListenerCompat)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
    }
}
