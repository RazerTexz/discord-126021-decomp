package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Process;
import b.f.m.DoNotOptimize;
import b.f.m.MinElf2;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
@DoNotOptimize
@TargetApi(23)
public final class SysUtil$MarshmallowSysdeps {
    private SysUtil$MarshmallowSysdeps() {
    }

    @DoNotOptimize
    public static String[] getSupportedAbis() {
        String[] strArr = Build.SUPPORTED_ABIS;
        TreeSet treeSet = new TreeSet();
        if (is64Bit()) {
            treeSet.add(MinElf2.AARCH64.toString());
            treeSet.add(MinElf2.X86_64.toString());
        } else {
            treeSet.add(MinElf2.ARM.toString());
            treeSet.add(MinElf2.X86.toString());
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (treeSet.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @DoNotOptimize
    public static boolean is64Bit() {
        return Process.is64Bit();
    }
}
