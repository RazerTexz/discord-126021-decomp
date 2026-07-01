package b.a.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsService;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CustomTabsPackages.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();

    public final String a(Context context, Function1<? super String, Boolean> function1) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        m.checkNotNullParameter(context, "$this$getCustomTabsDefaultPackage");
        m.checkNotNullParameter(function1, "filter");
        PackageManager packageManager = context.getPackageManager();
        Object obj = null;
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
        m.checkNotNullExpressionValue(data, "Intent()\n          .setA…mParts(\"http\", \"\", null))");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(data, 0);
        m.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…ltViewIntentHandler(), 0)");
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent = new Intent().setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(resolveInfo.activityInfo.packageName);
            m.checkNotNullExpressionValue(intent, "Intent()\n            .se…activityInfo.packageName)");
            String str = context.getPackageManager().resolveService(intent, 0) != null ? resolveInfo.activityInfo.packageName : null;
            if (str != null) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual((String) next, "com.android.chrome"));
        String str2 = (String) next;
        if (str2 == null) {
            Iterator it2 = arrayList.iterator();
            do {
                if (!it2.hasNext()) {
                    next4 = null;
                    break;
                }
                next4 = it2.next();
            } while (!m.areEqual((String) next4, "com.chrome.beta"));
            str2 = (String) next4;
        }
        if (str2 == null) {
            Iterator it3 = arrayList.iterator();
            do {
                if (!it3.hasNext()) {
                    next3 = null;
                    break;
                }
                next3 = it3.next();
            } while (!m.areEqual((String) next3, "com.chrome.dev"));
            str2 = (String) next3;
        }
        if (str2 == null) {
            Iterator it4 = arrayList.iterator();
            do {
                if (!it4.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it4.next();
            } while (!m.areEqual((String) next2, "com.google.android.apps.chrome"));
            str2 = (String) next2;
        }
        if (str2 != null) {
            return str2;
        }
        for (Object obj2 : arrayList) {
            if (function1.invoke(obj2).booleanValue()) {
                obj = obj2;
                break;
            }
        }
        return (String) obj;
    }
}
