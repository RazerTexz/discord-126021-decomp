package com.discord.media_picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MediaPicker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaPicker {

    /* JADX INFO: renamed from: a */
    public static final MediaPicker f18555a = new MediaPicker();

    /* JADX INFO: compiled from: MediaPicker.kt */
    public interface Provider {
        File getImageFile();

        Context requireContext();

        void startActivityForResult(Intent intent, int requestCode);
    }

    /* JADX INFO: renamed from: com.discord.media_picker.MediaPicker$a */
    /* JADX INFO: compiled from: MediaPicker.kt */
    public interface InterfaceC5527a {
        /* JADX INFO: renamed from: a */
        void mo8354a(Exception exc);

        /* JADX INFO: renamed from: b */
        void mo8355b(Uri uri, RequestType requestType);
    }

    /* JADX INFO: renamed from: a */
    public final Uri m8424a(Provider provider) throws IOException {
        File imageFile = provider.getImageFile();
        Context contextRequireContext = provider.requireContext();
        Uri uriForFile = FileProvider.getUriForFile(contextRequireContext, contextRequireContext.getPackageName().toString() + ".file-provider", imageFile);
        C12238m.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…context, authority, file)");
        m8428e(contextRequireContext, imageFile.toURI().toString());
        return uriForFile;
    }

    /* JADX INFO: renamed from: b */
    public final Uri m8425b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("picker", 0);
        C12238m.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
        String string = sharedPreferences.getString("picker_uri", null);
        if (string == null) {
            Uri uri = Uri.EMPTY;
            C12238m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
            return uri;
        }
        m8428e(context, null);
        Uri uri2 = Uri.parse(string);
        C12238m.checkNotNullExpressionValue(uri2, "Uri.parse(uriString)");
        return uri2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    /* JADX INFO: renamed from: c */
    public final void m8426c(Context context, Intent intent, Uri uri) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        C12238m.checkNotNullExpressionValue(listQueryIntentActivities, "context\n        .package…nager.MATCH_DEFAULT_ONLY)");
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uri, 3);
        }
    }

    /* JADX INFO: renamed from: d */
    public final Uri m8427d(Context context, RequestType requestType, Intent intent) throws IOException {
        Uri uri;
        Uri uriM8425b;
        int iOrdinal = requestType.ordinal();
        if (iOrdinal == 0) {
            return m8425b(context);
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            if (intent == null || intent.getData() == null) {
                throw new IOException("Picker returned no data result.");
            }
            Uri data = intent.getData();
            if (data == null) {
                data = Uri.EMPTY;
            }
            C12238m.checkNotNullExpressionValue(data, "if (data == null || data…ta ?: Uri.EMPTY\n        }");
            return data;
        }
        if (iOrdinal == 3) {
            if (intent == null || (uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri")) == null) {
                uri = Uri.EMPTY;
            }
            C12238m.checkNotNullExpressionValue(uri, "if (data != null) {\n    …      Uri.EMPTY\n        }");
            return uri;
        }
        if (iOrdinal != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (intent == null || intent.getData() == null) {
            uriM8425b = m8425b(context);
        } else {
            uriM8425b = intent.getData();
            if (uriM8425b == null) {
                uriM8425b = Uri.EMPTY;
            }
        }
        C12238m.checkNotNullExpressionValue(uriM8425b, "if (data != null && data…dClear(context)\n        }");
        return uriM8425b;
    }

    /* JADX INFO: renamed from: e */
    public final void m8428e(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("picker", 0);
        C12238m.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("picker_uri", str);
        editorEdit.apply();
    }
}
