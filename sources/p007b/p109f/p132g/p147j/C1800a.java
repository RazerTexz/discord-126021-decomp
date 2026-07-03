package p007b.p109f.p132g.p147j;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p132g.p143f.C1793a;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.j.a */
/* JADX INFO: compiled from: GenericDraweeView.java */
/* JADX INFO: loaded from: classes.dex */
public class C1800a extends DraweeView<GenericDraweeHierarchy> {
    public C1800a(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    public void inflateHierarchy(Context context, AttributeSet attributeSet) {
        C2030b.m1527b();
        C2030b.m1527b();
        C1793a c1793a = new C1793a(context.getResources());
        C1460d.m542l2(c1793a, context, attributeSet);
        C2030b.m1527b();
        setAspectRatio(c1793a.f3455e);
        setHierarchy(c1793a.m1122a());
        C2030b.m1527b();
    }

    public C1800a(Context context) {
        super(context);
        inflateHierarchy(context, null);
    }

    public C1800a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public C1800a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    @TargetApi(21)
    public C1800a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }
}
