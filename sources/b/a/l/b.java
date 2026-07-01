package b.a.l;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import d0.z.d.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaPickerChooser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final void a(Map<String, Intent> map, PackageManager packageManager, Intent intent, Function1<? super Intent, Unit> function1) {
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (function1 != null) {
                ((a) function1).invoke(intent2);
            }
            String str = resolveInfo.activityInfo.packageName;
            m.checkNotNullExpressionValue(str, "resolveInfo.activityInfo.packageName");
            map.put(str, intent2);
        }
    }

    public static final Intent b(PackageManager packageManager, CharSequence charSequence, Uri uri, String str) throws IOException {
        m.checkNotNullParameter(packageManager, "packageManager");
        m.checkNotNullParameter(uri, "captureFileURI");
        m.checkNotNullParameter(str, "mimeType");
        Intent intentAddFlags = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri).addFlags(2).addFlags(1);
        m.checkNotNullExpressionValue(intentAddFlags, "Intent(MediaStore.ACTION…RANT_READ_URI_PERMISSION)");
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType(str);
        intent.putExtra("android.intent.extra.MIME_TYPES", str);
        Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
        intent2.setType(str);
        intent2.putExtra("android.intent.extra.MIME_TYPES", str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(linkedHashMap, packageManager, intent2, null);
        a(linkedHashMap, packageManager, intent, null);
        a(linkedHashMap, packageManager, intentAddFlags, new a(uri));
        Collection collectionValues = linkedHashMap.values();
        if (collectionValues.isEmpty()) {
            throw new IOException("No media applications available on this device.");
        }
        Iterator it = collectionValues.iterator();
        Intent intent3 = (Intent) it.next();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Intent intentCreateChooser = Intent.createChooser(intent3, charSequence);
        if (!arrayList.isEmpty()) {
            Object[] array = arrayList.toArray(new Parcelable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
        }
        m.checkNotNullExpressionValue(intentCreateChooser, "chooserIntent");
        return intentCreateChooser;
    }
}
