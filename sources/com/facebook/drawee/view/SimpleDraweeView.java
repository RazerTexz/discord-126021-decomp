package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.C10638R;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p132g.p133a.p134a.C1733d;
import p007b.p109f.p132g.p147j.C1800a;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDraweeView extends C1800a {
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private AbstractDraweeControllerBuilder mControllerBuilder;

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int resourceId;
        try {
            C2030b.m1527b();
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                C1460d.m591y(sDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                this.mControllerBuilder = sDraweecontrollerbuildersupplier.get();
            }
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10638R.a.SimpleDraweeView);
                try {
                    int i = C10638R.a.SimpleDraweeView_actualImageUri;
                    if (typedArrayObtainStyledAttributes.hasValue(i)) {
                        setImageURI(Uri.parse(typedArrayObtainStyledAttributes.getString(i)), (Object) null);
                    } else {
                        int i2 = C10638R.a.SimpleDraweeView_actualImageResource;
                        if (typedArrayObtainStyledAttributes.hasValue(i2) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, -1)) != -1) {
                            if (isInEditMode()) {
                                setImageResource(resourceId);
                            } else {
                                setActualImageResource(resourceId);
                            }
                        }
                    }
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            }
            C2030b.m1527b();
        } catch (Throwable th2) {
            C2030b.m1527b();
            throw th2;
        }
    }

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public void setActualImageResource(@DrawableRes int i, Object obj) {
        Uri uri = C1717b.f3138a;
        setImageURI(new Uri.Builder().scheme("res").path(String.valueOf(i)).build(), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageRequest(ImageRequest imageRequest) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mControllerBuilder;
        abstractDraweeControllerBuilder.f19484h = imageRequest;
        abstractDraweeControllerBuilder.f19490n = getController();
        setController(abstractDraweeControllerBuilder.m8667a());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setImageURI(String str) {
        setImageURI(str, (Object) null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        init(context, null);
    }

    public void setImageURI(Uri uri, Object obj) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mControllerBuilder;
        abstractDraweeControllerBuilder.f19483g = obj;
        C1733d c1733dM1058f = ((C1733d) abstractDraweeControllerBuilder).m1058f(uri);
        c1733dM1058f.f19490n = getController();
        setController(c1733dM1058f.m8667a());
    }

    public void setActualImageResource(@DrawableRes int i) {
        setActualImageResource(i, null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    public void setImageURI(String str, Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }
}
