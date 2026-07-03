package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p389e.InterfaceC4761d;

/* JADX INFO: loaded from: classes3.dex */
public class JniNativeApi implements InterfaceC4761d {

    /* JADX INFO: renamed from: a */
    public static final boolean f21419a;

    /* JADX INFO: renamed from: b */
    public Context f21420b;

    static {
        boolean z2;
        try {
            System.loadLibrary("crashlytics");
            z2 = true;
        } catch (UnsatisfiedLinkError e) {
            C4592b c4592b = C4592b.f12227a;
            StringBuilder sbM833U = C1643a.m833U("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n");
            sbM833U.append(e.getLocalizedMessage());
            c4592b.m6373d(sbM833U.toString());
            z2 = false;
        }
        f21419a = z2;
    }

    public JniNativeApi(Context context) {
        this.f21420b = context;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9176a(String str, AssetManager assetManager) {
        String str2 = Build.CPU_ABI;
        try {
            PackageInfo packageInfo = this.f21420b.getPackageManager().getPackageInfo(this.f21420b.getPackageName(), 9216);
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
            return f21419a && nativeInit(new String[]{strArr3[0], strArr3[1], str}, assetManager);
        } catch (PackageManager.NameNotFoundException e) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Unable to compose package paths", e);
            }
            throw new RuntimeException(e);
        }
    }

    public final native boolean nativeInit(String[] strArr, Object obj);
}
