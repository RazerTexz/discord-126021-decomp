package androidx.sharetarget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.AnyThread;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.util.AtomicFile;
import b.d.b.a.outline;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutsInfoSerialization {
    private static final String ATTR_ACTION = "action";
    private static final String ATTR_COMPONENT = "component";
    private static final String ATTR_DISABLED_MSG = "disabled_message";
    private static final String ATTR_ICON_BMP_PATH = "icon_bitmap_path";
    private static final String ATTR_ICON_RES_NAME = "icon_resource_name";
    private static final String ATTR_ID = "id";
    private static final String ATTR_LONG_LABEL = "long_label";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_RANK = "rank";
    private static final String ATTR_SHORT_LABEL = "short_label";
    private static final String ATTR_TARGET_CLASS = "targetClass";
    private static final String ATTR_TARGET_PACKAGE = "targetPackage";
    private static final String TAG = "ShortcutInfoCompatSaver";
    private static final String TAG_CATEGORY = "categories";
    private static final String TAG_INTENT = "intent";
    private static final String TAG_ROOT = "share_targets";
    private static final String TAG_TARGET = "target";

    public static class ShortcutContainer {
        public final String mBitmapPath;
        public final String mResourceName;
        public final ShortcutInfoCompat mShortcutInfo;

        @AnyThread
        public ShortcutContainer(ShortcutInfoCompat shortcutInfoCompat, String str, String str2) {
            this.mShortcutInfo = shortcutInfoCompat;
            this.mResourceName = str;
            this.mBitmapPath = str2;
        }
    }

    private ShortcutsInfoSerialization() {
    }

    @WorkerThread
    private static String getAttributeValue(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        return attributeValue == null ? xmlPullParser.getAttributeValue(null, str) : attributeValue;
    }

    @WorkerThread
    public static Map<String, ShortcutContainer> loadFromXml(File file, Context context) {
        ShortcutContainer shortcutContainer;
        ShortcutInfoCompat shortcutInfoCompat;
        ArrayMap arrayMap = new ArrayMap();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                if (!file.exists()) {
                    fileInputStream.close();
                    return arrayMap;
                }
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, "UTF_8");
                while (true) {
                    int next = xmlPullParserNewPullParser.next();
                    if (next == 1) {
                        break;
                    }
                    if (next == 2 && xmlPullParserNewPullParser.getName().equals(TAG_TARGET) && (shortcutContainer = parseShortcutContainer(xmlPullParserNewPullParser, context)) != null && (shortcutInfoCompat = shortcutContainer.mShortcutInfo) != null) {
                        arrayMap.put(shortcutInfoCompat.getId(), shortcutContainer);
                    }
                }
                fileInputStream.close();
                return arrayMap;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            file.delete();
            Log.e("ShortcutInfoCompatSaver", "Failed to load saved values from file " + file.getAbsolutePath() + ". Old state removed, new added", e);
        }
        file.delete();
        Log.e("ShortcutInfoCompatSaver", "Failed to load saved values from file " + file.getAbsolutePath() + ". Old state removed, new added", e);
        return arrayMap;
    }

    @WorkerThread
    private static ComponentName parseComponentName(XmlPullParser xmlPullParser) {
        String attributeValue = getAttributeValue(xmlPullParser, ATTR_COMPONENT);
        if (TextUtils.isEmpty(attributeValue)) {
            return null;
        }
        return ComponentName.unflattenFromString(attributeValue);
    }

    @WorkerThread
    private static Intent parseIntent(XmlPullParser xmlPullParser) {
        String attributeValue = getAttributeValue(xmlPullParser, ATTR_ACTION);
        String attributeValue2 = getAttributeValue(xmlPullParser, ATTR_TARGET_PACKAGE);
        String attributeValue3 = getAttributeValue(xmlPullParser, ATTR_TARGET_CLASS);
        if (attributeValue == null) {
            return null;
        }
        Intent intent = new Intent(attributeValue);
        if (!TextUtils.isEmpty(attributeValue2) && !TextUtils.isEmpty(attributeValue3)) {
            intent.setClassName(attributeValue2, attributeValue3);
        }
        return intent;
    }

    @WorkerThread
    private static ShortcutContainer parseShortcutContainer(XmlPullParser xmlPullParser, Context context) throws Exception {
        if (!xmlPullParser.getName().equals(TAG_TARGET)) {
            return null;
        }
        String attributeValue = getAttributeValue(xmlPullParser, "id");
        String attributeValue2 = getAttributeValue(xmlPullParser, ATTR_SHORT_LABEL);
        if (TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(attributeValue2)) {
            return null;
        }
        int i = Integer.parseInt(getAttributeValue(xmlPullParser, ATTR_RANK));
        String attributeValue3 = getAttributeValue(xmlPullParser, ATTR_LONG_LABEL);
        String attributeValue4 = getAttributeValue(xmlPullParser, ATTR_DISABLED_MSG);
        ComponentName componentName = parseComponentName(xmlPullParser);
        String attributeValue5 = getAttributeValue(xmlPullParser, ATTR_ICON_RES_NAME);
        String attributeValue6 = getAttributeValue(xmlPullParser, ATTR_ICON_BMP_PATH);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(TAG_TARGET)) {
                        break;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    if (name.equals(TAG_INTENT)) {
                        Intent intent = parseIntent(xmlPullParser);
                        if (intent != null) {
                            arrayList.add(intent);
                        }
                    } else if (name.equals(TAG_CATEGORY)) {
                        String attributeValue7 = getAttributeValue(xmlPullParser, "name");
                        if (!TextUtils.isEmpty(attributeValue7)) {
                            hashSet.add(attributeValue7);
                        }
                    }
                }
            } else {
                break;
            }
        }
        ShortcutInfoCompat.Builder rank = new ShortcutInfoCompat.Builder(context, attributeValue).setShortLabel(attributeValue2).setRank(i);
        if (!TextUtils.isEmpty(attributeValue3)) {
            rank.setLongLabel(attributeValue3);
        }
        if (!TextUtils.isEmpty(attributeValue4)) {
            rank.setDisabledMessage(attributeValue4);
        }
        if (componentName != null) {
            rank.setActivity(componentName);
        }
        if (!arrayList.isEmpty()) {
            rank.setIntents((Intent[]) arrayList.toArray(new Intent[0]));
        }
        if (!hashSet.isEmpty()) {
            rank.setCategories(hashSet);
        }
        return new ShortcutContainer(rank.build(), attributeValue5, attributeValue6);
    }

    public static void saveAsXml(List<ShortcutContainer> list, File file) {
        AtomicFile atomicFile = new AtomicFile(file);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStreamStartWrite);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                xmlSerializerNewSerializer.setOutput(bufferedOutputStream, "UTF_8");
                xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
                xmlSerializerNewSerializer.startTag(null, TAG_ROOT);
                Iterator<ShortcutContainer> it = list.iterator();
                while (it.hasNext()) {
                    serializeShortcutContainer(xmlSerializerNewSerializer, it.next());
                }
                xmlSerializerNewSerializer.endTag(null, TAG_ROOT);
                xmlSerializerNewSerializer.endDocument();
                bufferedOutputStream.flush();
                fileOutputStreamStartWrite.flush();
                atomicFile.finishWrite(fileOutputStreamStartWrite);
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStreamStartWrite;
                StringBuilder sbU = outline.U("Failed to write to file ");
                sbU.append(atomicFile.getBaseFile());
                Log.e("ShortcutInfoCompatSaver", sbU.toString(), e);
                atomicFile.failWrite(fileOutputStream);
                StringBuilder sbU2 = outline.U("Failed to write to file ");
                sbU2.append(atomicFile.getBaseFile());
                throw new RuntimeException(sbU2.toString(), e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @WorkerThread
    private static void serializeAttribute(XmlSerializer xmlSerializer, String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        xmlSerializer.attribute(null, str, str2);
    }

    @WorkerThread
    private static void serializeCategory(XmlSerializer xmlSerializer, String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xmlSerializer.startTag(null, TAG_CATEGORY);
        serializeAttribute(xmlSerializer, "name", str);
        xmlSerializer.endTag(null, TAG_CATEGORY);
    }

    @WorkerThread
    private static void serializeIntent(XmlSerializer xmlSerializer, Intent intent) throws IOException {
        xmlSerializer.startTag(null, TAG_INTENT);
        serializeAttribute(xmlSerializer, ATTR_ACTION, intent.getAction());
        if (intent.getComponent() != null) {
            serializeAttribute(xmlSerializer, ATTR_TARGET_PACKAGE, intent.getComponent().getPackageName());
            serializeAttribute(xmlSerializer, ATTR_TARGET_CLASS, intent.getComponent().getClassName());
        }
        xmlSerializer.endTag(null, TAG_INTENT);
    }

    @WorkerThread
    private static void serializeShortcutContainer(XmlSerializer xmlSerializer, ShortcutContainer shortcutContainer) throws IOException {
        xmlSerializer.startTag(null, TAG_TARGET);
        ShortcutInfoCompat shortcutInfoCompat = shortcutContainer.mShortcutInfo;
        serializeAttribute(xmlSerializer, "id", shortcutInfoCompat.getId());
        serializeAttribute(xmlSerializer, ATTR_SHORT_LABEL, shortcutInfoCompat.getShortLabel().toString());
        serializeAttribute(xmlSerializer, ATTR_RANK, Integer.toString(shortcutInfoCompat.getRank()));
        if (!TextUtils.isEmpty(shortcutInfoCompat.getLongLabel())) {
            serializeAttribute(xmlSerializer, ATTR_LONG_LABEL, shortcutInfoCompat.getLongLabel().toString());
        }
        if (!TextUtils.isEmpty(shortcutInfoCompat.getDisabledMessage())) {
            serializeAttribute(xmlSerializer, ATTR_DISABLED_MSG, shortcutInfoCompat.getDisabledMessage().toString());
        }
        if (shortcutInfoCompat.getActivity() != null) {
            serializeAttribute(xmlSerializer, ATTR_COMPONENT, shortcutInfoCompat.getActivity().flattenToString());
        }
        if (!TextUtils.isEmpty(shortcutContainer.mResourceName)) {
            serializeAttribute(xmlSerializer, ATTR_ICON_RES_NAME, shortcutContainer.mResourceName);
        }
        if (!TextUtils.isEmpty(shortcutContainer.mBitmapPath)) {
            serializeAttribute(xmlSerializer, ATTR_ICON_BMP_PATH, shortcutContainer.mBitmapPath);
        }
        for (Intent intent : shortcutInfoCompat.getIntents()) {
            serializeIntent(xmlSerializer, intent);
        }
        Iterator<String> it = shortcutInfoCompat.getCategories().iterator();
        while (it.hasNext()) {
            serializeCategory(xmlSerializer, it.next());
        }
        xmlSerializer.endTag(null, TAG_TARGET);
    }
}
