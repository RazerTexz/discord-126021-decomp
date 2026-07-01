package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import b.i.a.f.e.o.f;
import b.i.c.l.Component4;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.x.LibraryVersion;
import b.i.c.x.LibraryVersionComponent2;
import b.i.c.x.UserAgentPublisher;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.firebase.FirebaseCommonRegistrar;
import d0.KotlinVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(' ', '_').replace(MentionUtils.SLASH_CHAR, '_');
    }

    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        String string;
        ArrayList arrayList = new ArrayList();
        Component4.b bVarA = Component4.a(UserAgentPublisher.class);
        bVarA.a(new Dependency2(LibraryVersion.class, 2, 0));
        bVarA.c(new ComponentFactory() { // from class: b.i.c.x.b
            @Override // b.i.c.l.ComponentFactory
            public Object a(ComponentContainer componentContainer) {
                Set setD = componentContainer.d(LibraryVersion.class);
                GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.a;
                if (globalLibraryVersionRegistrar == null) {
                    synchronized (GlobalLibraryVersionRegistrar.class) {
                        globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.a;
                        if (globalLibraryVersionRegistrar == null) {
                            globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                            GlobalLibraryVersionRegistrar.a = globalLibraryVersionRegistrar;
                        }
                    }
                }
                return new DefaultUserAgentPublisher2(setD, globalLibraryVersionRegistrar);
            }
        });
        arrayList.add(bVarA.b());
        Component4.b bVarA2 = Component4.a(HeartBeatInfo.class);
        bVarA2.a(new Dependency2(Context.class, 1, 0));
        bVarA2.c(new ComponentFactory() { // from class: b.i.c.r.b
            @Override // b.i.c.l.ComponentFactory
            public Object a(ComponentContainer componentContainer) {
                return new DefaultHeartBeatInfo3((Context) componentContainer.a(Context.class));
            }
        });
        arrayList.add(bVarA2.b());
        arrayList.add(f.N("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(f.N("fire-core", "19.4.0"));
        arrayList.add(f.N("device-name", a(Build.PRODUCT)));
        arrayList.add(f.N("device-model", a(Build.DEVICE)));
        arrayList.add(f.N("device-brand", a(Build.BRAND)));
        arrayList.add(f.b0("android-target-sdk", new LibraryVersionComponent2() { // from class: b.i.c.d
            @Override // b.i.c.x.LibraryVersionComponent2
            public String a(Object obj) {
                ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
                return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
            }
        }));
        arrayList.add(f.b0("android-min-sdk", new LibraryVersionComponent2() { // from class: b.i.c.e
            @Override // b.i.c.x.LibraryVersionComponent2
            public String a(Object obj) {
                ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
                return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
            }
        }));
        arrayList.add(f.b0("android-platform", new LibraryVersionComponent2() { // from class: b.i.c.f
            @Override // b.i.c.x.LibraryVersionComponent2
            public String a(Object obj) {
                Context context = (Context) obj;
                int i = Build.VERSION.SDK_INT;
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                    return "tv";
                }
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                    return "watch";
                }
                if (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                    return (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
                }
                return "auto";
            }
        }));
        arrayList.add(f.b0("android-installer", new LibraryVersionComponent2() { // from class: b.i.c.g
            @Override // b.i.c.x.LibraryVersionComponent2
            public String a(Object obj) {
                Context context = (Context) obj;
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                return installerPackageName != null ? FirebaseCommonRegistrar.a(installerPackageName) : "";
            }
        }));
        try {
            string = KotlinVersion.j.toString();
        } catch (NoClassDefFoundError unused) {
            string = null;
        }
        if (string != null) {
            arrayList.add(f.N("kotlin", string));
        }
        return arrayList;
    }
}
