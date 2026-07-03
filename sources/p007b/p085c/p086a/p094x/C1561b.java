package p007b.p085c.p086a.p094x;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.HashMap;
import java.util.Map;
import p007b.p085c.p086a.C1512k;
import p007b.p085c.p086a.InterfaceC1492b;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.x.b */
/* JADX INFO: compiled from: ImageAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1561b {

    /* JADX INFO: renamed from: a */
    public static final Object f2647a = new Object();

    /* JADX INFO: renamed from: b */
    public final Context f2648b;

    /* JADX INFO: renamed from: c */
    public String f2649c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public InterfaceC1492b f2650d;

    /* JADX INFO: renamed from: e */
    public final Map<String, C1512k> f2651e;

    public C1561b(Drawable.Callback callback, String str, InterfaceC1492b interfaceC1492b, Map<String, C1512k> map) {
        this.f2649c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f2649c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f2649c = C1643a.m820H(new StringBuilder(), this.f2649c, MentionUtilsKt.SLASH_CHAR);
            }
        }
        if (callback instanceof View) {
            this.f2648b = ((View) callback).getContext();
            this.f2651e = map;
            this.f2650d = interfaceC1492b;
        } else {
            C1495c.m640b("LottieDrawable must be inside of a view for images to work.");
            this.f2651e = new HashMap();
            this.f2648b = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final Bitmap m749a(String str, @Nullable Bitmap bitmap) {
        synchronized (f2647a) {
            this.f2651e.get(str).f2418e = bitmap;
        }
        return bitmap;
    }
}
