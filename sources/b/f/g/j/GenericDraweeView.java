package b.f.g.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import b.c.a.a0.AnimatableValueParser;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import b.f.j.r.FrescoSystrace;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;

/* JADX INFO: renamed from: b.f.g.j.a, reason: use source file name */
/* JADX INFO: compiled from: GenericDraweeView.java */
/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    public void inflateHierarchy(Context context, AttributeSet attributeSet) {
        FrescoSystrace.b();
        FrescoSystrace.b();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        AnimatableValueParser.l2(genericDraweeHierarchyBuilder, context, attributeSet);
        FrescoSystrace.b();
        setAspectRatio(genericDraweeHierarchyBuilder.e);
        setHierarchy(genericDraweeHierarchyBuilder.a());
        FrescoSystrace.b();
    }

    public GenericDraweeView(Context context) {
        super(context);
        inflateHierarchy(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    @TargetApi(21)
    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }
}
