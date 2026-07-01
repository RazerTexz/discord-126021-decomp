package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class ShapeableImageView$a extends ViewOutlineProvider {
    public final Rect a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShapeableImageView f3042b;

    public ShapeableImageView$a(ShapeableImageView shapeableImageView) {
        this.f3042b = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        if (ShapeableImageView.access$000(this.f3042b) == null) {
            return;
        }
        if (ShapeableImageView.access$100(this.f3042b) == null) {
            ShapeableImageView.access$102(this.f3042b, new MaterialShapeDrawable(ShapeableImageView.access$000(this.f3042b)));
        }
        ShapeableImageView.access$200(this.f3042b).round(this.a);
        ShapeableImageView.access$100(this.f3042b).setBounds(this.a);
        ShapeableImageView.access$100(this.f3042b).getOutline(outline);
    }
}
