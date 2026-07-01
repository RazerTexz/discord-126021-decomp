package androidx.sharetarget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.WorkerThread;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class ShareTargetXmlParser {
    private static final String ATTR_HOST = "host";
    private static final String ATTR_MIME_TYPE = "mimeType";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String ATTR_PATH_PATTERN = "pathPattern";
    private static final String ATTR_PATH_PREFIX = "pathPrefix";
    private static final String ATTR_PORT = "port";
    private static final String ATTR_SCHEME = "scheme";
    private static final String ATTR_TARGET_CLASS = "targetClass";
    private static final Object GET_INSTANCE_LOCK = new Object();
    private static final String META_DATA_APP_SHORTCUTS = "android.app.shortcuts";
    public static final String TAG = "ShareTargetXmlParser";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_DATA = "data";
    private static final String TAG_SHARE_TARGET = "share-target";
    private static volatile ArrayList<ShareTargetCompat> sShareTargets;

    private ShareTargetXmlParser() {
    }

    private static String getAttributeValue(XmlResourceParser xmlResourceParser, String str) {
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        return attributeValue == null ? xmlResourceParser.getAttributeValue(null, str) : attributeValue;
    }

    @WorkerThread
    public static ArrayList<ShareTargetCompat> getShareTargets(Context context) {
        if (sShareTargets == null) {
            synchronized (GET_INSTANCE_LOCK) {
                if (sShareTargets == null) {
                    sShareTargets = parseShareTargets(context);
                }
            }
        }
        return sShareTargets;
    }

    private static XmlResourceParser getXmlResourceParser(Context context, ActivityInfo activityInfo) {
        XmlResourceParser xmlResourceParserLoadXmlMetaData = activityInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_APP_SHORTCUTS);
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        StringBuilder sbU = a.U("Failed to open android.app.shortcuts meta-data resource of ");
        sbU.append(activityInfo.name);
        throw new IllegalArgumentException(sbU.toString());
    }

    private static ShareTargetCompat parseShareTarget(XmlResourceParser xmlResourceParser) throws Exception {
        String attributeValue = getAttributeValue(xmlResourceParser, ATTR_TARGET_CLASS);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlResourceParser.getName().equals(TAG_SHARE_TARGET)) {
                        break;
                    }
                } else {
                    String name = xmlResourceParser.getName();
                    name.hashCode();
                    if (name.equals(TAG_DATA)) {
                        arrayList.add(parseTargetData(xmlResourceParser));
                    } else if (name.equals(TAG_CATEGORY)) {
                        arrayList2.add(getAttributeValue(xmlResourceParser, "name"));
                    }
                }
            } else {
                break;
            }
        }
        if (arrayList.isEmpty() || attributeValue == null || arrayList2.isEmpty()) {
            return null;
        }
        return new ShareTargetCompat((ShareTargetCompat$TargetData[]) arrayList.toArray(new ShareTargetCompat$TargetData[arrayList.size()]), attributeValue, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
    }

    private static ArrayList<ShareTargetCompat> parseShareTargets(Context context) {
        ArrayList<ShareTargetCompat> arrayList = new ArrayList<>();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (listQueryIntentActivities == null) {
            return arrayList;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            Bundle bundle = activityInfo.metaData;
            if (bundle != null && bundle.containsKey(META_DATA_APP_SHORTCUTS)) {
                arrayList.addAll(parseShareTargets(context, activityInfo));
            }
        }
        return arrayList;
    }

    private static ShareTargetCompat$TargetData parseTargetData(XmlResourceParser xmlResourceParser) {
        return new ShareTargetCompat$TargetData(getAttributeValue(xmlResourceParser, ATTR_SCHEME), getAttributeValue(xmlResourceParser, ATTR_HOST), getAttributeValue(xmlResourceParser, ATTR_PORT), getAttributeValue(xmlResourceParser, ATTR_PATH), getAttributeValue(xmlResourceParser, ATTR_PATH_PATTERN), getAttributeValue(xmlResourceParser, ATTR_PATH_PREFIX), getAttributeValue(xmlResourceParser, ATTR_MIME_TYPE));
    }

    private static ArrayList<ShareTargetCompat> parseShareTargets(Context context, ActivityInfo activityInfo) {
        ShareTargetCompat shareTarget;
        ArrayList<ShareTargetCompat> arrayList = new ArrayList<>();
        XmlResourceParser xmlResourceParser = getXmlResourceParser(context, activityInfo);
        while (true) {
            try {
                int next = xmlResourceParser.next();
                if (next == 1) {
                    break;
                }
                if (next == 2 && xmlResourceParser.getName().equals(TAG_SHARE_TARGET) && (shareTarget = parseShareTarget(xmlResourceParser)) != null) {
                    arrayList.add(shareTarget);
                }
            } catch (Exception e) {
                Log.e(TAG, "Failed to parse the Xml resource: ", e);
            }
        }
        xmlResourceParser.close();
        return arrayList;
    }
}
