package b.c.a.x;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable$Callback;
import android.view.View;
import b.c.a.b0.c;
import b.c.a.y.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FontAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public final AssetManager d;
    public final j<String> a = new j<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<j<String>, Typeface> f397b = new HashMap();
    public final Map<String, Typeface> c = new HashMap();
    public String e = ".ttf";

    public a(Drawable$Callback drawable$Callback) {
        if (drawable$Callback instanceof View) {
            this.d = ((View) drawable$Callback).getContext().getAssets();
        } else {
            c.b("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }
}
