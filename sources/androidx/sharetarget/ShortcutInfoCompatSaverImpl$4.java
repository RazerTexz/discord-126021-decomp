package androidx.sharetarget;

import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompat$Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl$4 implements Callable<ArrayList<ShortcutInfoCompat>> {
    public final /* synthetic */ ShortcutInfoCompatSaverImpl this$0;

    public ShortcutInfoCompatSaverImpl$4(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl) {
        this.this$0 = shortcutInfoCompatSaverImpl;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ ArrayList<ShortcutInfoCompat> call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public ArrayList<ShortcutInfoCompat> call2() {
        ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<>();
        Iterator<ShortcutsInfoSerialization$ShortcutContainer> it = this.this$0.mShortcutsMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(new ShortcutInfoCompat$Builder(it.next().mShortcutInfo).build());
        }
        return arrayList;
    }
}
