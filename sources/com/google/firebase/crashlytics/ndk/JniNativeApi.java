package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.e.NativeApi;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class JniNativeApi implements NativeApi {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f3110b;

    static {
        boolean z2;
        try {
            System.loadLibrary("crashlytics");
            z2 = true;
        } catch (UnsatisfiedLinkError e) {
            Logger3 logger3 = Logger3.a;
            StringBuilder sbU = outline.U("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n");
            sbU.append(e.getLocalizedMessage());
            logger3.d(sbU.toString());
            z2 = false;
        }
        a = z2;
    }

    public JniNativeApi(Context context) {
        this.f3110b = context;
    }

    public boolean a(String str, AssetManager assetManager) {
        String str2 = Build.CPU_ABI;
        try {
            PackageInfo packageInfo = this.f3110b.getPackageManager().getPackageInfo(this.f3110b.getPackageName(), 9216);
            ArrayList<String> arrayList = new ArrayList(10);
            arrayList.add(packageInfo.applicationInfo.sourceDir);
            String[] strArr = packageInfo.applicationInfo.splitSourceDirs;
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            String[] strArr2 = packageInfo.applicationInfo.sharedLibraryFiles;
            if (strArr2 != null) {
                Collections.addAll(arrayList, strArr2);
            }
            ArrayList arrayList2 = new ArrayList(10);
            File parentFile = new File(packageInfo.applicationInfo.nativeLibraryDir).getParentFile();
            if (parentFile != null) {
                arrayList2.add(new File(parentFile, str2).getPath());
                if (str2.startsWith("arm64")) {
                    arrayList2.add(new File(parentFile, "arm64").getPath());
                } else if (str2.startsWith("arm")) {
                    arrayList2.add(new File(parentFile, "arm").getPath());
                }
            }
            for (String str3 : arrayList) {
                if (str3.endsWith(".apk")) {
                    arrayList2.add(str3 + "!/lib/" + str2);
                }
            }
            arrayList2.add(System.getProperty("java.library.path"));
            arrayList2.add(packageInfo.applicationInfo.nativeLibraryDir);
            String str4 = File.pathSeparator;
            String[] strArr3 = {TextUtils.join(str4, arrayList), TextUtils.join(str4, arrayList2)};
            return a && nativeInit(new String[]{strArr3[0], strArr3[1], str}, assetManager);
        } catch (PackageManager.NameNotFoundException e) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Unable to compose package paths", e);
            }
            throw new RuntimeException(e);
        }
    }

    public final native boolean nativeInit(String[] strArr, Object obj);
}
