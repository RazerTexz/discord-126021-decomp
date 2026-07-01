package b.c.a.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import b.c.a.ImageAssetDelegate;
import b.c.a.LottieImageAsset;
import b.c.a.b0.Logger2;
import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.c.a.x.b, reason: use source file name */
/* JADX INFO: compiled from: ImageAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageAssetManager {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f398b;
    public String c;

    @Nullable
    public ImageAssetDelegate d;
    public final Map<String, LottieImageAsset> e;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.c = outline.H(new StringBuilder(), this.c, MentionUtils.SLASH_CHAR);
            }
        }
        if (callback instanceof View) {
            this.f398b = ((View) callback).getContext();
            this.e = map;
            this.d = imageAssetDelegate;
        } else {
            Logger2.b("LottieDrawable must be inside of a view for images to work.");
            this.e = new HashMap();
            this.f398b = null;
        }
    }

    public final Bitmap a(String str, @Nullable Bitmap bitmap) {
        synchronized (a) {
            this.e.get(str).e = bitmap;
        }
        return bitmap;
    }
}
