package com.discord.media_picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.content.FileProvider;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: MediaPicker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaPicker {
    public static final MediaPicker a = new MediaPicker();

    /* JADX INFO: compiled from: MediaPicker.kt */
    public interface Provider {
        File getImageFile();

        Context requireContext();

        void startActivityForResult(Intent intent, int requestCode);
    }

    /* JADX INFO: compiled from: MediaPicker.kt */
    public interface a {
        void a(Exception exc);

        void b(Uri uri, RequestType requestType);
    }

    public final Uri a(Provider provider) throws IOException {
        File imageFile = provider.getImageFile();
        Context contextRequireContext = provider.requireContext();
        Uri uriForFile = FileProvider.getUriForFile(contextRequireContext, contextRequireContext.getPackageName().toString() + ".file-provider", imageFile);
        Intrinsics3.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…context, authority, file)");
        e(contextRequireContext, imageFile.toURI().toString());
        return uriForFile;
    }

    public final Uri b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("picker", 0);
        Intrinsics3.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
        String string = sharedPreferences.getString("picker_uri", null);
        if (string == null) {
            Uri uri = Uri.EMPTY;
            Intrinsics3.checkNotNullExpressionValue(uri, "Uri.EMPTY");
            return uri;
        }
        e(context, null);
        Uri uri2 = Uri.parse(string);
        Intrinsics3.checkNotNullExpressionValue(uri2, "Uri.parse(uriString)");
        return uri2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public final void c(Context context, Intent intent, Uri uri) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics3.checkNotNullExpressionValue(listQueryIntentActivities, "context\n        .package…nager.MATCH_DEFAULT_ONLY)");
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
            Intrinsics3.checkNotNullExpressionValue(data, "if (data == null || data…ta ?: Uri.EMPTY\n        }");
            return data;
        }
        if (iOrdinal == 3) {
            if (intent == null || (uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri")) == null) {
                uri = Uri.EMPTY;
            }
            Intrinsics3.checkNotNullExpressionValue(uri, "if (data != null) {\n    …      Uri.EMPTY\n        }");
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
        Intrinsics3.checkNotNullExpressionValue(uriB, "if (data != null && data…dClear(context)\n        }");
        return uriB;
    }

    public final void e(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("picker", 0);
        Intrinsics3.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("picker_uri", str);
        editorEdit.apply();
    }
}
