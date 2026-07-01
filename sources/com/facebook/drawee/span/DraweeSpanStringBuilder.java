package com.facebook.drawee.span;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import b.f.g.b.c$a;
import b.f.g.i.a;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DraweeSpanStringBuilder extends SpannableStringBuilder {
    public static final /* synthetic */ int j = 0;
    public final Set<a> k = new HashSet();
    public final DraweeSpanStringBuilder$b l = new DraweeSpanStringBuilder$b(this, null);
    public View m;

    public void a(View view) {
        View view2 = this.m;
        if (view2 != null && view2 == view2) {
            this.m = null;
        }
        this.m = view;
        Iterator<a> it = this.k.iterator();
        while (it.hasNext()) {
            DraweeHolder draweeHolder = it.next().p;
            draweeHolder.f.a(c$a.ON_HOLDER_ATTACH);
            draweeHolder.f2893b = true;
            draweeHolder.b();
        }
    }

    public void b(View view) {
        if (view == this.m) {
            this.m = null;
        }
        Iterator<a> it = this.k.iterator();
        while (it.hasNext()) {
            DraweeHolder draweeHolder = it.next().p;
            draweeHolder.f.a(c$a.ON_HOLDER_DETACH);
            draweeHolder.f2893b = false;
            draweeHolder.b();
        }
    }

    public void c(Context context, DraweeHierarchy draweeHierarchy, DraweeController draweeController, int i, int i2, int i3, int i4, boolean z2, int i5) {
        DraweeHolder draweeHolder = new DraweeHolder(draweeHierarchy);
        draweeHolder.g(draweeController);
        if (i2 >= length()) {
            return;
        }
        Drawable drawableD = draweeHolder.d();
        if (drawableD != null) {
            if (drawableD.getBounds().isEmpty()) {
                drawableD.setBounds(0, 0, i3, i4);
            }
            drawableD.setCallback(this.l);
        }
        a aVar = new a(draweeHolder, i5);
        DraweeController draweeController2 = draweeHolder.e;
        if (draweeController2 instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController2).f(new DraweeSpanStringBuilder$c(this, aVar, z2, i4));
        }
        this.k.add(aVar);
        setSpan(aVar, i, i2 + 1, 33);
    }
}
