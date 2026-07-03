package p007b.p225i.p226a.p341g.p350i;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: renamed from: b.i.a.g.i.a */
/* JADX INFO: compiled from: ElasticTabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4428a extends C4429b {
    /* JADX INFO: renamed from: c */
    public static float m6143c(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        return (float) (1.0d - Math.cos((((double) f) * 3.141592653589793d) / 2.0d));
    }

    @Override // p007b.p225i.p226a.p341g.p350i.C4429b
    /* JADX INFO: renamed from: b */
    public void mo6144b(TabLayout tabLayout, View view, View view2, float f, @NonNull Drawable drawable) {
        float fSin;
        float fM6143c;
        RectF rectFM6145a = C4429b.m6145a(tabLayout, view);
        RectF rectFM6145a2 = C4429b.m6145a(tabLayout, view2);
        if (rectFM6145a.left < rectFM6145a2.left) {
            fSin = m6143c(f);
            fM6143c = (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
        } else {
            fSin = (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
            fM6143c = m6143c(f);
        }
        drawable.setBounds(AnimationUtils.lerp((int) rectFM6145a.left, (int) rectFM6145a2.left, fSin), drawable.getBounds().top, AnimationUtils.lerp((int) rectFM6145a.right, (int) rectFM6145a2.right, fM6143c), drawable.getBounds().bottom);
    }
}
