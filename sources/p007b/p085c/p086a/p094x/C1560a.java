package p007b.p085c.p086a.p094x;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p095y.C1571j;

/* JADX INFO: renamed from: b.c.a.x.a */
/* JADX INFO: compiled from: FontAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1560a {

    /* JADX INFO: renamed from: d */
    public final AssetManager f2645d;

    /* JADX INFO: renamed from: a */
    public final C1571j<String> f2642a = new C1571j<>();

    /* JADX INFO: renamed from: b */
    public final Map<C1571j<String>, Typeface> f2643b = new HashMap();

    /* JADX INFO: renamed from: c */
    public final Map<String, Typeface> f2644c = new HashMap();

    /* JADX INFO: renamed from: e */
    public String f2646e = ".ttf";

    public C1560a(Drawable.Callback callback) {
        if (callback instanceof View) {
            this.f2645d = ((View) callback).getContext().getAssets();
        } else {
            C1495c.m640b("LottieDrawable must be inside of a view for images to work.");
            this.f2645d = null;
        }
    }
}
