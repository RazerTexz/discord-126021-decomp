package androidx.core.provider;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FontRequestWorker$4 implements Consumer<FontRequestWorker$TypefaceResult> {
    public final /* synthetic */ String val$id;

    public FontRequestWorker$4(String str) {
        this.val$id = str;
    }

    @Override // androidx.core.util.Consumer
    public /* bridge */ /* synthetic */ void accept(FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        accept2(fontRequestWorker$TypefaceResult);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        synchronized (FontRequestWorker.LOCK) {
            SimpleArrayMap<String, ArrayList<Consumer<FontRequestWorker$TypefaceResult>>> simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
            ArrayList<Consumer<FontRequestWorker$TypefaceResult>> arrayList = simpleArrayMap.get(this.val$id);
            if (arrayList == null) {
                return;
            }
            simpleArrayMap.remove(this.val$id);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).accept(fontRequestWorker$TypefaceResult);
            }
        }
    }
}
