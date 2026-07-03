package com.facebook.imagepipeline.nativecode;

import android.content.Context;
import com.facebook.soloader.SoLoader;
import java.io.IOException;
import p007b.p109f.p115d.p119d.InterfaceC1680c;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class NativeCodeInitializer {
    @InterfaceC1680c
    public static void init(Context context) throws IOException {
        SoLoader.init(context, 0);
    }
}
