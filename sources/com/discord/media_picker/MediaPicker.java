package com.discord.media_picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.content.FileProvider;
import d0.z.d.m;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: MediaPicker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaPicker {
    public static final MediaPicker a = new MediaPicker();

    public final Uri a(MediaPicker$Provider mediaPicker$Provider) throws IOException {
        File imageFile = mediaPicker$Provider.getImageFile();
        Context contextRequireContext = mediaPicker$Provider.requireContext();
        Uri uriForFile = FileProvider.getUriForFile(contextRequireContext, contextRequireContext.getPackageName().toString() + ".file-provider", imageFile);
        m.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…context, authority, file)");
        e(contextRequireContext, imageFile.toURI().toString());
        return uriForFile;
    }

    public final Uri b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("picker", 0);
        m.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
        String string = sharedPreferences.getString("picker_uri", null);
        if (string == null) {
            Uri uri = Uri.EMPTY;
            m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
            return uri;
        }
        e(context, null);
        Uri uri2 = Uri.parse(string);
        m.checkNotNullExpressionValue(uri2, "Uri.parse(uriString)");
        return uri2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public final void c(Context context, Intent intent, Uri uri) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        m.checkNotNullExpressionValue(listQueryIntentActivities, "context\n        .package…nager.MATCH_DEFAULT_ONLY)");
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uri, 3);
        }
    }

    public final Uri d(Context context, RequestType requestType, Intent intent) throws IOException {
        Uri uri;
        Uri uriB;
        int iOrdinal = requestType.ordinal();
        if (iOrdinal == 0) {
            return b(context);
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            if (intent == null || intent.getData() == null) {
                throw new IOException("Picker returned no data result.");
            }
            Uri data = intent.getData();
            if (data == null) {
                data = Uri.EMPTY;
            }
            m.checkNotNullExpressionValue(data, "if (data == null || data…ta ?: Uri.EMPTY\n        }");
            return data;
        }
        if (iOrdinal == 3) {
            if (intent == null || (uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri")) == null) {
                uri = Uri.EMPTY;
            }
            m.checkNotNullExpressionValue(uri, "if (data != null) {\n    …      Uri.EMPTY\n        }");
            return uri;
        }
        if (iOrdinal != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (intent == null || intent.getData() == null) {
            uriB = b(context);
        } else {
            uriB = intent.getData();
            if (uriB == null) {
                uriB = Uri.EMPTY;
            }
        }
        m.checkNotNullExpressionValue(uriB, "if (data != null && data…dClear(context)\n        }");
        return uriB;
    }

    public final void e(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("picker", 0);
        m.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
        SharedPreferences$Editor sharedPreferences$EditorEdit = sharedPreferences.edit();
        sharedPreferences$EditorEdit.putString("picker_uri", str);
        sharedPreferences$EditorEdit.apply();
    }
}
