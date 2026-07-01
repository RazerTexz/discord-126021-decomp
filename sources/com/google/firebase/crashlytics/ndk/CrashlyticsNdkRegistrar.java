package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import b.i.a.f.e.o.f;
import b.i.c.l.Component4;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.m.d.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.ndk.CrashlyticsNdkRegistrar;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(CrashlyticsNativeComponent.class);
        bVarA.a(new Dependency2(Context.class, 1, 0));
        bVarA.c(new ComponentFactory(this) { // from class: b.i.c.m.e.b
            public final CrashlyticsNdkRegistrar a;

            {
                this.a = this;
            }

            @Override // b.i.c.l.ComponentFactory
            public Object a(ComponentContainer componentContainer) {
                Objects.requireNonNull(this.a);
                Context context = (Context) componentContainer.a(Context.class);
                return new FirebaseCrashlyticsNdk(new BreakpadController(context, new JniNativeApi(context), new NdkCrashFilesManager(new File(context.getFilesDir(), ".com.google.firebase.crashlytics-ndk"))));
            }
        });
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-cls-ndk", "17.3.0"));
    }
}
