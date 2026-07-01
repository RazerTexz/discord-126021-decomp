package b.f.g.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import b.c.a.a0.d;
import b.f.j.r.b;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;

/* JADX INFO: compiled from: GenericDraweeView.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends DraweeView<GenericDraweeHierarchy> {
    public a(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    public void inflateHierarchy(Context context, AttributeSet attributeSet) {
        b.b();
        b.b();
        b.f.g.f.a aVar = new b.f.g.f.a(context.getResources());
        d.l2(aVar, context, attributeSet);
        b.b();
        setAspectRatio(aVar.e);
        setHierarchy(aVar.a());
        b.b();
    }

    public a(Context context) {
        super(context);
        inflateHierarchy(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    @TargetApi(21)
    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }
}
