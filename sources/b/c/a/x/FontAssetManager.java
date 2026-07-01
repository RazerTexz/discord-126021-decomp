package b.c.a.x;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import b.c.a.b0.Logger2;
import b.c.a.y.MutablePair;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.c.a.x.a, reason: use source file name */
/* JADX INFO: compiled from: FontAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class FontAssetManager {
    public final AssetManager d;
    public final MutablePair<String> a = new MutablePair<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<MutablePair<String>, Typeface> f397b = new HashMap();
    public final Map<String, Typeface> c = new HashMap();
    public String e = ".ttf";

    public FontAssetManager(Drawable.Callback callback) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            Logger2.b("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }
}
