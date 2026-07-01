package b.c.a.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable$Callback;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import b.c.a.b0.c;
import b.c.a.k;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ImageAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f398b;
    public String c;

    @Nullable
    public b.c.a.b d;
    public final Map<String, k> e;

    public b(Drawable$Callback drawable$Callback, String str, b.c.a.b bVar, Map<String, k> map) {
        this.c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.c = b.d.b.a.a.H(new StringBuilder(), this.c, MentionUtilsKt.SLASH_CHAR);
            }
        }
        if (drawable$Callback instanceof View) {
            this.f398b = ((View) drawable$Callback).getContext();
            this.e = map;
            this.d = bVar;
        } else {
            c.b("LottieDrawable must be inside of a view for images to work.");
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
